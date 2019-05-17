package com.uranus.fusion.common.asterix.spec;

import com.uranus.fusion.common.util.ByteUtil;
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

  private Integer beginIndex;
  private Integer size;

  private Integer maxFrn;
  private FpIndicationEnum defaultFpIndication;
  private Integer defaultFpIndicatorSize;
  private Integer frnStartNumber;
  private Integer frnOctetSize;
  private Map<Integer, FpIndicator> fpIndicatorMap;

  private Integer maxFxn;
  private FxIndicationEnum defaultFxIndication;
  private Integer fxnStartNumber;
  private Integer fxnOctetIndex;
  private String fxPrefix;
  private Map<String, FxIndicator> fxIndicatorMap;

  public FieldSpec(int beginIndex, FieldSpecParameter fieldSpecParameter) {
    this.beginIndex = beginIndex;

    this.maxFrn = fieldSpecParameter.maxFrn();
    this.defaultFpIndication = fieldSpecParameter.defaultFpIndication();
    this.defaultFpIndicatorSize = fieldSpecParameter.defaultFpIndicatorSize();
    this.frnStartNumber = fieldSpecParameter.frnStartNumber();
    this.frnOctetSize = fieldSpecParameter.frnOctetSize();

    this.maxFxn = fieldSpecParameter.maxFxn();
    this.defaultFxIndication = fieldSpecParameter.defaultFxIndication();
    this.fxnStartNumber = fieldSpecParameter.fxnStartNumber();
    this.fxnOctetIndex = fieldSpecParameter.fxnOctetIndex();
    this.fxPrefix = fieldSpecParameter.fxPrefix();

    initializeFpIndicatorMap();
    initializeFxIndicatorMap();
  }

  private void initializeFpIndicatorMap() {

    fpIndicatorMap = new HashMap<>(maxFrn);

    for (int i = 0; i < maxFrn; i++) {
      FpIndicator fpIndicator = new FpIndicator();
      int fpIndicatorFrn = i + frnStartNumber;
      fpIndicator.setFrn(fpIndicatorFrn);
      fpIndicator.setIndication(defaultFpIndication);
      fpIndicator.setSize(defaultFpIndicatorSize);
      fpIndicatorMap.put(fpIndicator.getFrn(), fpIndicator);
    }
  }

  private void initializeFxIndicatorMap() {

    fxIndicatorMap = new HashMap<>(maxFxn);

    for (int i = 0; i < maxFrn; i++) {
      FxIndicator fxIndicator = new FxIndicator();
      String fxIndicatorFrn = fxPrefix + (i + fxnStartNumber);
      fxIndicator.setFxn(fxIndicatorFrn);
      fxIndicator.setIndication(defaultFxIndication);
      fxIndicatorMap.put(fxIndicator.getFxn(), fxIndicator);
    }
  }

  public FpIndicator findFpIndicatorByFrn(int frn) {
    return this.fpIndicatorMap.get(frn);
  }

  public int calculateIndexByFrn(int frn) {
    // 初始的index为FpSpecStartIndex+FpSpecSize，即第一个field的index
    int index = this.beginIndex + this.size;
    for (int i = frnStartNumber; i < frn; i++) {
      FpIndicator fpIndicator = findFpIndicatorByFrn(i);

      // 当前frn的field的index是初始index+前序出现的field字段长度之和
      // 需要注意的是，每个field解析的时候必须为length赋值，这样才能计算
      if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
        index += fpIndicator.getSize();
      }
    }
    return index;
  }

  public Integer calculateCurrentDataBlockLength() {
    int length = this.size;

    for (int i = 0; i < maxFrn; i++) {
      int frn = i + frnStartNumber;
      length += fpIndicatorMap.get(frn).getSize();
    }
    return length;
  }

  public void read(List<Byte> message) {

    int sizeCount = 0;
    int currentIndex = beginIndex;

    for (int i = 0; i < this.maxFxn; i++) {
      Byte fieldSpecificationOctet = message.get(currentIndex);
      for (int j = 0; j < frnOctetSize; j++) {
        // set f1-f7
        int frn = i * frnOctetSize + j + frnStartNumber;
        String fpIndicatorIndicationBit = ByteUtil.getBitByIndex(fieldSpecificationOctet, j);

        FpIndicator fpIndicator = fpIndicatorMap.get(frn);
        fpIndicator.setIndication(
            ByteUtil.ZERO_BIT.equals(fpIndicatorIndicationBit)
                ? FpIndicationEnum.ABSENCE
                : FpIndicationEnum.PRESENCE);
      }

      String fxn = fxPrefix + (i + fxnStartNumber);
      String fxIndicatorIndicationBit =
          ByteUtil.getBitByIndex(fieldSpecificationOctet, fxnOctetIndex);

      FxIndicator fxIndicator = fxIndicatorMap.get(fxn);
      fxIndicator.setIndication(
          ByteUtil.ZERO_BIT.equals(fxIndicatorIndicationBit)
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
