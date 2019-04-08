package com.uranus.fusion.common.asterix.message.spec;

import com.uranus.fusion.common.asterix.util.ByteUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DataSpec
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/8
 */
public class DataSpec {

  private static final Logger logger = LoggerFactory.getLogger(DataSpec.class);

  private Map<Integer, DpIndicator> dpIndicatorMap;
  private Map<String, DxIndicator> dxIndicatorMap;
  private Integer sizeOfOctet;
  private DataSpecTypeEnum type;
  private Integer maxDrn;
  private Integer maxDxn;
  private Integer startIndex;

  public DataSpec(DataSpecTypeEnum type) {
    this.type = type;
    doConfig(type);
    initIndicatorMap(this.maxDrn, this.maxDxn);
  }

  public Map<Integer, DpIndicator> getDpIndicatorMap() {
    return dpIndicatorMap;
  }

  public void setDpIndicatorMap(Map<Integer, DpIndicator> dpIndicatorMap) {
    this.dpIndicatorMap = dpIndicatorMap;
  }

  public Map<String, DxIndicator> getDxIndicatorMap() {
    return dxIndicatorMap;
  }

  public void setDxIndicatorMap(Map<String, DxIndicator> dxIndicatorMap) {
    this.dxIndicatorMap = dxIndicatorMap;
  }

  public Integer getSizeOfOctet() {
    return sizeOfOctet;
  }

  public void setSizeOfOctet(Integer sizeOfOctet) {
    this.sizeOfOctet = sizeOfOctet;
  }

  public DataSpecTypeEnum getType() {
    return type;
  }

  public void setType(DataSpecTypeEnum type) {
    this.type = type;
  }

  public Integer getMaxDrn() {
    return maxDrn;
  }

  public void setMaxDrn(Integer maxDrn) {
    this.maxDrn = maxDrn;
  }

  public Integer getMaxDxn() {
    return maxDxn;
  }

  public void setMaxDxn(Integer maxDxn) {
    this.maxDxn = maxDxn;
  }

  public Integer getStartIndex() {
    return startIndex;
  }

  public void setStartIndex(Integer startIndex) {
    this.startIndex = startIndex;
  }

  public DpIndicator getDpIndicator(int drn) {
    return this.dpIndicatorMap.get(drn);
  }

  public DxIndicator getDxIndicator(String dxn) {
    return this.dxIndicatorMap.get(dxn);
  }

  private void doConfig(DataSpecTypeEnum type) {
    this.dpIndicatorMap = new HashMap<>(16);
    this.dxIndicatorMap = new HashMap<>(16);

    switch (type) {
      case AIRCRAFT_DERIVED_DATA:
        this.maxDrn = 28;
        this.maxDxn = 4;
        break;
      case SYSTEM_TRACK_UPDATE_AGES:
        this.maxDrn = 14;
        this.maxDxn = 2;
        break;
      case TRACK_DATA_AGES:
        this.maxDrn = 35;
        this.maxDxn = 5;
        break;
      case FLIGHT_PLAN_RELATED_DATA:
        this.maxDrn = 21;
        this.maxDxn = 3;
        break;

      case MODE5_EXTENDED_MODE1_DATA:
        this.maxDrn = 7;
        this.maxDxn = 1;
        break;
      case ESTIMATED_ACCURACY:
        this.maxDrn = 14;
        this.maxDxn = 2;
        break;
      case MEASURED_INFROMATION:
        this.maxDrn = 7;
        this.maxDxn = 1;
        break;
      default:
        this.maxDrn = 0;
        this.maxDxn = 0;
        break;
    }
  }

  private void initIndicatorMap(int maxDrn, int maxDxn) {

    // 创建DpIndicator对象
    final int drnStartNum = 1;
    final DpIndicationEnum defaultDataIndication = DpIndicationEnum.ABSENCE;
    final int defaultDpIndicatorSize = 0;

    for (int i = 0; i < maxDrn; i++) {
      DpIndicator dpIndicator = new DpIndicator();
      int drn = i + drnStartNum;
      dpIndicator.setDrn(drn);
      dpIndicator.setIndication(defaultDataIndication);
      dpIndicator.setSize(defaultDpIndicatorSize);
      this.dpIndicatorMap.put(drn, dpIndicator);
    }

    // 创建DxIndicator对象
    final int dxnStartNumber = 1;
    final DxIndicationEnum defaultDxIndication = DxIndicationEnum.END;
    for (int i = 0; i < maxDxn; i++) {
      DxIndicator dxIndicator = new DxIndicator();
      String dxn = "dx" + (i + dxnStartNumber);
      dxIndicator.setDxn(dxn);
      dxIndicator.setIndication(defaultDxIndication);
      this.dxIndicatorMap.put(dxn, dxIndicator);
    }
  }

  public void readValue(List<Byte> uap, int startIndex) {
    final int maxDxn = this.getMaxDxn();
    final int drnSizeOctet = 7;
    final int drnStartNum = 1;

    final String zero = "0";

    int sizeOfOctet = 0;
    this.startIndex = startIndex;
    int index = this.startIndex;

    for (int i = 0; i < maxDxn; i++) {
      Byte dataSpecOctet = uap.get(index);
      for (int j = 0; j < drnSizeOctet; j++) {
        // set f1-f7
        int dpIndicatorDrn = i * drnSizeOctet + j + drnStartNum;

        String dpIndicatorIndicationBit = ByteUtil.getBitByIndex(dataSpecOctet, j);

        DpIndicator dpIndicator = getDpIndicator(dpIndicatorDrn);

        dpIndicator.setIndication(
            zero.equals(dpIndicatorIndicationBit)
                ? DpIndicationEnum.ABSENCE
                : DpIndicationEnum.PRESENCE);
      }

      // set dxIndicator
      final int dxnStartNum = 1;

      String dxIndicatorDxn = "dx" + (i + dxnStartNum);
      String dxIndicatorIndicationBit = ByteUtil.getBitByIndex(dataSpecOctet, 7);

      DxIndicator dxIndicator = getDxIndicator(dxIndicatorDxn);
      dxIndicator.setIndication(
          zero.equals(dxIndicatorIndicationBit)
              ? DxIndicationEnum.END
              : DxIndicationEnum.EXTENSION);

      sizeOfOctet++;
      index++;

      this.setSizeOfOctet(sizeOfOctet);

      if (dxIndicator.getIndication().equals(DxIndicationEnum.END)) {
        break;
      }
    }
  }

  public int calculateOctetIndexByDrn(int drn) {

    final int drnStartNum = 1;
    int index = this.startIndex + this.getSizeOfOctet();
    for (int i = drnStartNum; i < drn; i++) {
      DpIndicator dpIndicator = this.getDpIndicator(i);

      // 当前frn的field的index是初始index+前序出现的field字段长度之和
      // 需要注意的是，每个field解析的时候必须为length赋值，这样才能计算
      if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
        index += dpIndicator.getSize();
      }
    }
    return index;
  }

  public Integer calculateTotalSize() {
    final int drnStartNum = 1;
    int length = this.getSizeOfOctet();

    for (int i = 0; i < maxDrn; i++) {
      int drn = i + drnStartNum;
      length += this.dpIndicatorMap.get(drn).getSize();
    }
    return length;
  }
}
