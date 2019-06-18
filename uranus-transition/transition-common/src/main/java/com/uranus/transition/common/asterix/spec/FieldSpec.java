package com.uranus.transition.common.asterix.spec;

import com.uranus.transition.common.util.ByteUtil;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/16
 */
@Data
public class FieldSpec {

  /**
   * FSPEC 在报文 Byte 集合中开始的索引
   */
  private Integer beginIndex;
  /**
   * FSPEC 所占用的字节数
   */
  private Integer size;

  /**
   * 最大的 Field Reference Number
   *
   * 参考不同的规范实现
   */
  private Integer maxFrn;

  /**
   * 默认 Field Specification 指示为 Absence
   *
   */
  private FpIndicationEnum defaultFpIndication;

  /**
   * 默认 FieldIndicator 的大小为 0
   */
  private Integer defaultFpIndicatorSize;

  /**
   * FRN 起始编号的数值，默认为 1
   */
  private Integer frnStartNumber;

  /**
   * FRN 的步长大小
   */
  private Integer frnStepSize;
  /**
   * 存储 FRN 对象的 Map
   */
  private Map<Integer, FpIndicator> fpIndicatorMap;

  /**
   * 最大的 FXN 值，根据不同规范定义
   *
   * FXN 是根据不同规范来看 FX 标识出现的最多次数
   */
  private Integer maxFxn;

  /**
   * 默认的 FX 指示，一般为 Absence
   */
  private FxIndicationEnum defaultFxIndication;

  /**
   * FXN 起始计数的值，一般为 1
   */
  private Integer fxnStartNumber;
  /**
   * FX 指示在 FSPEC 一个字节中的索引，一般为 7
   */
  private Integer fxnOctetIndex;

  /**
   * FX 的前缀，一般为 fx
   */
  private String fxPrefix;

  /**
   * 存储 FX 对象的 Map
   */
  private Map<String, FxIndicator> fxIndicatorMap;

  public FieldSpec(int beginIndex, FieldSpecParameter fieldSpecParameter) {
    this.beginIndex = beginIndex;

    this.maxFrn = fieldSpecParameter.maxFrn();
    this.defaultFpIndication = fieldSpecParameter.defaultFpIndication();
    this.defaultFpIndicatorSize = fieldSpecParameter.defaultFpIndicatorSize();
    this.frnStartNumber = fieldSpecParameter.frnStartNumber();
    this.frnStepSize = fieldSpecParameter.frnStepSize();

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
      for (int j = 0; j < frnStepSize; j++) {
        // set f1-f7
        int frn = i * frnStepSize + j + frnStartNumber;
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
