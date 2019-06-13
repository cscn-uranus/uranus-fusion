package com.uranus.transition.common.asterix.spec;

import com.uranus.transition.common.util.ByteUtil;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
@Data
public class DataSpec {



  private Integer beginIndex;
  private Integer size;

  private Integer maxDrn;
  private DpIndicationEnum defaultDpIndication;
  private Integer defaultDpIndicatorSize;
  private Integer drnStartNumber;
  private Integer drnOctetSize;
  private Map<Integer, DpIndicator> dpIndicatorMap;

  private Integer maxDxn;
  private DxIndicationEnum defaultDxIndication;
  private Integer dxnStartNumber;
  private Integer dxnOctetIndex;
  private String dxPrefix;
  private Map<String, DxIndicator> dxIndicatorMap;

  public DataSpec(int beginIndex, DataSpecParameter dataSpecParameter) {
    this.beginIndex = beginIndex;

    this.maxDrn = dataSpecParameter.maxDrn();
    this.defaultDpIndication = dataSpecParameter.defaultDpIndication();
    this.defaultDpIndicatorSize = dataSpecParameter.defaultDpIndicatorSize();
    this.drnStartNumber = dataSpecParameter.drnStartNumber();
    this.drnOctetSize = dataSpecParameter.drnStepSize();

    this.maxDxn = dataSpecParameter.maxDxn();
    this.defaultDxIndication = dataSpecParameter.defaultDxIndication();
    this.dxnStartNumber = dataSpecParameter.dxnStartNumber();
    this.dxnOctetIndex = dataSpecParameter.dxnOctetIndex();
    this.dxPrefix = dataSpecParameter.dxPrefix();

    initializeDpIndicatorMap();
    initializeDxIndicatorMap();
  }

  public DpIndicator getDpIndicator(int drn) {
    return this.dpIndicatorMap.get(drn);
  }

  private void initializeDpIndicatorMap() {
    dpIndicatorMap = new HashMap<>(maxDrn);
    // 创建DpIndicator对象
    for (int i = 0; i < maxDrn; i++) {
      DpIndicator dpIndicator = new DpIndicator();
      int drn = i + drnStartNumber;
      dpIndicator.setDrn(drn);
      dpIndicator.setIndication(defaultDpIndication);
      dpIndicator.setSize(defaultDpIndicatorSize);
      this.dpIndicatorMap.put(drn, dpIndicator);
    }
  }
  private void initializeDxIndicatorMap() {

  dxIndicatorMap = new HashMap<>(maxDxn);

    // 创建DxIndicator对象
    for (int i = 0; i < maxDxn; i++) {
      DxIndicator dxIndicator = new DxIndicator();
      String dxn = dxPrefix + (i + dxnStartNumber);
      dxIndicator.setDxn(dxn);
      dxIndicator.setIndication(defaultDxIndication);
      this.dxIndicatorMap.put(dxn, dxIndicator);
    }
  }

  public void readValue(List<Byte> uap) {

    int sizeCount = 0;
    int index = beginIndex;

    for (int i = 0; i < maxDxn; i++) {
      Byte dataSpecOctet = uap.get(index);
      for (int j = 0; j < drnOctetSize; j++) {
        // set f1-f7
        int dpIndicatorDrn = i * drnOctetSize + j + drnStartNumber;

        String dpIndicatorIndicationBit = ByteUtil.getBitByIndex(dataSpecOctet, j);

        DpIndicator dpIndicator = this.dpIndicatorMap.get(dpIndicatorDrn);

        dpIndicator.setIndication(
            ByteUtil.ZERO_BIT.equals(dpIndicatorIndicationBit)
                ? DpIndicationEnum.ABSENCE
                : DpIndicationEnum.PRESENCE);
      }

      // set dxIndicator
      String dxIndicatorDxn = dxPrefix + (i + dxnStartNumber);
      String dxIndicatorIndicationBit = ByteUtil.getBitByIndex(dataSpecOctet, 7);

      DxIndicator dxIndicator = this.dxIndicatorMap.get(dxIndicatorDxn);
      dxIndicator.setIndication(
        ByteUtil.ZERO_BIT.equals(dxIndicatorIndicationBit)
              ? DxIndicationEnum.END
              : DxIndicationEnum.EXTENSION);

      sizeCount++;
      index++;

      this.size = sizeCount;

      if (dxIndicator.getIndication().equals(DxIndicationEnum.END)) {
        break;
      }
    }
  }

  public Integer calculateOctetIndexByDrn(int drn) {

    int index = this.beginIndex + this.size;
    for (int i = drnStartNumber; i < drn; i++) {
      DpIndicator dpIndicator = this.dpIndicatorMap.get(i);

      // 当前frn的field的index是初始index+前序出现的field字段长度之和
      // 需要注意的是，每个field解析的时候必须为length赋值，这样才能计算
      if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
        index += dpIndicator.getSize();
      }
    }
    return index;
  }

  public Integer calculateTotalSize() {
    int length = this.size;

    for (int i = 0; i < this.maxDrn; i++) {
      int drn = i + drnStartNumber;
      length += this.dpIndicatorMap.get(drn).getSize();
    }
    return length;
  }
}
