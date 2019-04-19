package com.uranus.fusion.asterix.spec;

import com.uranus.fusion.asterix.AsterixConfig;
import com.uranus.fusion.util.ByteUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FieldSpec
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/16
 */
@Data
public class FieldSpec implements Serializable {

  private static final Integer CAT001_MAX_FRN = 28;
  private static final Integer CAT001_MAX_FXN = 4;
  private static final Integer CAT002_MAX_FRN = 14;
  private static final Integer CAT002_MAX_FXN = 2;
  private static final Integer CAT034_MAX_FRN = 14;
  private static final Integer CAT034_MAX_FXN = 2;
  private static final Integer CAT048_MAX_FRN = 28;
  private static final Integer CAT048_MAX_FXN = 4;
  private static final Integer CAT062_MAX_FRN = 35;
  private static final Integer CAT062_MAX_FXN = 5;
  private static final Integer DEFAULT_MAX_FRN = 0;
  private static final Integer DEFAULT_MAX_FXN = 0;
  private static final int DEFAULT_FP_INDICATOR_SIZE = 0;
  private static final FpIndicationEnum DEFAULT_FP_INDICATION = FpIndicationEnum.ABSENCE;
  private static final FxIndicationEnum DEFAULT_FX_INDICATION = FxIndicationEnum.END;
  private static final int FRN_START_NUM = 1;
  private static final int FRN_OCTET_SIZE = 7;
  private static final int FXN_START_NUM = 1;
  private static final int FXN_OCTET_INDEX = 7;
  private static final String FX_PREFIX = "fx";
  private static final String ZERO_BIT = "0";
  private Map<Integer, FpIndicator> fpIndicatorMap;
  private Map<String, FxIndicator> fxIndicatorMap;
  private Integer size;
  private Integer maxFrn;
  private Integer maxFxn;

  public FieldSpec(FieldSpecTypeEnum type) {
    this.doConfig(type);
    this.initIndicatorMap(this.maxFrn, this.maxFxn);
  }

  public void addFpIndicator(FpIndicator fpIndicator) {
    this.fpIndicatorMap.put(fpIndicator.getFrn(), fpIndicator);
  }

  public FpIndicator getFpIndicator(int frn) {
    return this.fpIndicatorMap.get(frn);
  }

  public void addFxIndicator(FxIndicator fxIndicator) {
    this.fxIndicatorMap.put(fxIndicator.getFxn(), fxIndicator);
  }

  public FxIndicator getFxIndicator(String fxn) {
    return this.fxIndicatorMap.get(fxn);
  }

  private void doConfig(FieldSpecTypeEnum type) {
    switch (type) {
      case CAT001:
        this.maxFrn = CAT001_MAX_FRN;
        this.maxFxn = CAT001_MAX_FXN;
        break;
      case CAT002:
        this.maxFrn = CAT002_MAX_FRN;
        this.maxFxn = CAT002_MAX_FXN;
        break;
      case CAT034:
        this.maxFrn = CAT034_MAX_FRN;
        this.maxFxn = CAT034_MAX_FXN;
        break;
      case CAT048:
        this.maxFrn = CAT048_MAX_FRN;
        this.maxFxn = CAT048_MAX_FXN;
        break;
      case CAT062:
        this.maxFrn = CAT062_MAX_FRN;
        this.maxFxn = CAT062_MAX_FXN;
        break;
      default:
        this.maxFrn = DEFAULT_MAX_FRN;
        this.maxFxn = DEFAULT_MAX_FXN;
    }
  }

  private void initIndicatorMap(int maxFrn, int maxFxn) {

    this.fpIndicatorMap = new HashMap<>();
    this.fxIndicatorMap = new HashMap<>();

    // 创建FpIndicator对象

    for (int i = 0; i < maxFrn; i++) {
      FpIndicator fpIndicator = new FpIndicator();
      int fpIndicatorFrn = i + FRN_START_NUM;
      fpIndicator.setFrn(fpIndicatorFrn);
      fpIndicator.setIndication(DEFAULT_FP_INDICATION);
      fpIndicator.setSize(DEFAULT_FP_INDICATOR_SIZE);
      this.addFpIndicator(fpIndicator);
    }

    // 创建FxIndicator对象
    for (int i = 0; i < maxFxn; i++) {
      FxIndicator fxIndicator = new FxIndicator();
      String fxIndicatorFrn = FX_PREFIX + (i + FXN_START_NUM);
      fxIndicator.setFxn(fxIndicatorFrn);
      fxIndicator.setIndication(DEFAULT_FX_INDICATION);
      this.addFxIndicator(fxIndicator);
    }
  }

  public int calculateIndexByFrn(int frn) {
    // 初始的index为FpSpecStartIndex+FpSpecSize，即第一个field的index
    int index = AsterixConfig.ASTERIX_FIRST_FSPEC_INDEX + this.size;
    for (int i = FRN_START_NUM; i < frn; i++) {
      FpIndicator fpIndicator = this.getFpIndicator(i);

      // 当前frn的field的index是初始index+前序出现的field字段长度之和
      // 需要注意的是，每个field解析的时候必须为length赋值，这样才能计算
      if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
        index += fpIndicator.getSize();
      }
    }
    return index;
  }

  public void readValue(List<Byte> input, int beginIndex) {

    int sizeCount = 0;
    int currentIndex = beginIndex;

    for (int i = 0; i < this.maxFxn; i++) {
      Byte fieldSpecificationOctet = input.get(currentIndex);
      for (int j = 0; j < FRN_OCTET_SIZE; j++) {
        // set f1-f7
        int fpIndicatorFrn = i * FRN_OCTET_SIZE + j + FRN_START_NUM;
        String fpIndicatorIndicationBit = ByteUtil.getBitByIndex(fieldSpecificationOctet, j);

        FpIndicator fpIndicator = this.getFpIndicator(fpIndicatorFrn);
        fpIndicator.setIndication(
            ZERO_BIT.equals(fpIndicatorIndicationBit)
                ? FpIndicationEnum.ABSENCE
                : FpIndicationEnum.PRESENCE);
      }

      String fxIndicatorFrn = FX_PREFIX + (i + FXN_START_NUM);
      String fxIndicatorIndicationBit =
          ByteUtil.getBitByIndex(fieldSpecificationOctet, FXN_OCTET_INDEX);

      FxIndicator fxIndicator = this.getFxIndicator(fxIndicatorFrn);
      fxIndicator.setIndication(
          ZERO_BIT.equals(fxIndicatorIndicationBit)
              ? FxIndicationEnum.END
              : FxIndicationEnum.EXTENSION);

      sizeCount++;
      currentIndex++;
      this.size = sizeCount;

      if (fxIndicator.getIndication().equals(FxIndicationEnum.END)) {
        break;
      }
    }
  }
}
