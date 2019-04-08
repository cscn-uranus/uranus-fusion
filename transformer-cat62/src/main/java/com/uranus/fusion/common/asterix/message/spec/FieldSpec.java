package com.uranus.fusion.common.asterix.message.spec;

import com.uranus.fusion.common.asterix.util.ByteUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FieldSpec
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/16
 */
public class FieldSpec implements Serializable {

  private final static Integer MAX_FRN = 35;
  private final static Integer MAX_FXN = 5;

  private Map<Integer, FpIndicator> fpIndicatorMap;
  private Map<String, FxIndicator> fxIndicatorMap;
  private Integer sizeOfOctet;
  private Integer startIndex;

  public FieldSpec() {
    this.fpIndicatorMap = new HashMap<>();
    this.fxIndicatorMap = new HashMap<>();
    this.initIndicatorMap();
  }

  public Integer getSizeOfOctet() {
    return sizeOfOctet;
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

  public FxIndicator getFxIndicator(String frn) {
    return this.fxIndicatorMap.get(frn);
  }

  private void initIndicatorMap() {

    // 创建FpIndicator对象
    final int frnStartIndex = 1;
    final FpIndicationEnum defaultFpIndication = FpIndicationEnum.ABSENCE;
    final int defaultFpIndicatorLength = 0;

    for (int i = 0; i < MAX_FRN; i++) {
      FpIndicator fpIndicator = new FpIndicator();
      int fpIndicatorFrn = i + frnStartIndex;
      fpIndicator.setFrn(fpIndicatorFrn);
      fpIndicator.setIndication(defaultFpIndication);
      fpIndicator.setSize(defaultFpIndicatorLength);
      this.addFpIndicator(fpIndicator);
    }

    // 创建FxIndicator对象
    final int fxnStartIndex = 1;
    final FxIndicationEnum defaultFxIndication = FxIndicationEnum.END;
    for (int i = 0; i < MAX_FXN; i++) {
      FxIndicator fxIndicator = new FxIndicator();
      String fxIndicatorFrn = "fx" + (i + fxnStartIndex);
      fxIndicator.setFxn(fxIndicatorFrn);
      fxIndicator.setIndication(defaultFxIndication);
      this.addFxIndicator(fxIndicator);
    }
  }

  public int calculateOctetIndexByFrn(int frn) {
    // 初始的index为FpSpecStartIndex+FpSpecSize，即第一个field的index
    final int frnStartNum = 1;
    int index = this.startIndex + this.getSizeOfOctet();
    for (int i = frnStartNum; i < frn; i++) {
      FpIndicator fpIndicator = this.getFpIndicator(i);

      // 当前frn的field的index是初始index+前序出现的field字段长度之和
      // 需要注意的是，每个field解析的时候必须为length赋值，这样才能计算
      if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
        index += fpIndicator.getSize();
      }
    }
    return index;
  }

  public void readValue(List<Byte> uapOctetList, int startIndex) {
    final int frnSizeOctet = 7;
    final int frnStartNum = 1;

    int sizeOfOctet = 0;
    this.startIndex = startIndex;
    int index = this.startIndex;

    for (int i = 0; i < MAX_FXN; i++) {
      Byte fieldSpecificationOctet = uapOctetList.get(index);
      for (int j = 0; j < frnSizeOctet; j++) {
        // set f1-f7
        int fpIndicatorFrn =
            i * frnSizeOctet
                + j
                + frnStartNum;
        String fpIndicatorIndicationBit = ByteUtil.getBitByIndex(fieldSpecificationOctet, j);

        FpIndicator fpIndicator = this.getFpIndicator(fpIndicatorFrn);
        fpIndicator.setIndication(
            "1".equals(fpIndicatorIndicationBit)
                ? FpIndicationEnum.PRESENCE
                : FpIndicationEnum.ABSENCE);
      }

      // set fxIndicator
      final int fxnStartNum = 1;
      final int fxnOctetIndex = 7;

      String fxIndicatorFrn = "fx" + (i + fxnStartNum);
      String fxIndicatorIndicationBit =
          ByteUtil.getBitByIndex(
              fieldSpecificationOctet, fxnOctetIndex);

      FxIndicator fxIndicator = this.getFxIndicator(fxIndicatorFrn);
      fxIndicator.setIndication(
          "1".equals(fxIndicatorIndicationBit) ? FxIndicationEnum.EXTENSION : FxIndicationEnum.END);

      sizeOfOctet++;
      index++;
      this.sizeOfOctet = sizeOfOctet;

      if (fxIndicator.getIndication().equals(FxIndicationEnum.END)) {
        break;
      }
    }
  }

}
