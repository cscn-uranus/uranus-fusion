package com.uranus.fusion.asterix.spec;

import com.uranus.fusion.util.ByteUtil;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DataSpec
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
@Data
public class DataSpec {

  private static final Logger LOGGER = LoggerFactory.getLogger(DataSpec.class);
  /**
   * CAT062 data item specification ref to asterix at https://www.eurocontrol.int/services/asterix
   */
  private static final int AIRCRAFT_DERIVED_DATA_MAX_DRN = 28;

  private static final int AIRCRAFT_DERIVED_DATA_MAX_DXN = 4;
  private static final int SYSTEM_TRACK_UPDATE_AGES_MAX_DRN = 14;
  private static final int SYSTEM_TRACK_UPDATE_AGES_MAX_DXN = 2;
  private static final int TRACK_DATA_AGES_MAX_DRN = 35;
  private static final int TRACK_DATA_AGES_MAX_DXN = 5;
  private static final int FLIGHT_PLAN_RELATED_DATA_MAX_DRN = 21;
  private static final int FLIGHT_PLAN_RELATED_DATA_MAX_DXN = 3;
  private static final int MODE5_EXTENDED_MODE1_DATA_MAX_DRN = 7;
  private static final int MODE5_EXTENDED_MODE1_DATA_MAX_DXN = 1;
  private static final int ESTIMATED_ACCURACY_MAX_DRN = 14;
  private static final int ESTIMATED_ACCURACY_MAX_DXN = 2;
  private static final int MEASURED_INFORMATION_MAX_DRN = 7;
  private static final int MEASURED_INFORMATION_MAX_DXN = 1;
  private static final int DEFAULT_MAX_DRN = 0;
  private static final int DEFAULT_MAX_DXN = 0;

  /** CAT062 default parameter */
  private static final int DEFAULT_DP_INDICATOR_SIZE = 0;

  private static final DpIndicationEnum DEFAULT_DP_INDICATION = DpIndicationEnum.ABSENCE;
  private static final DxIndicationEnum DEFAULT_DX_INDICATION = DxIndicationEnum.END;
  private static final int DRN_START_NUM = 1;
  private static final int DXN_START_NUM = 1;
  private static final int DRN_OCTET_SIZE = 7;
  private static final String DX_PREFIX = "dx";
  private static final String ZERO_BIT = "0";
  private Map<Integer, DpIndicator> dpIndicatorMap;
  private Map<String, DxIndicator> dxIndicatorMap;
  private Integer size;
  private Integer maxDrn;
  private Integer maxDxn;
  private Integer startIndex;

  public DataSpec(DataSpecTypeEnum type) {
    doConfig(type);
    initIndicatorMap(this.maxDrn, this.maxDxn);
  }

  public DpIndicator getDpIndicator(int drn) {
    return this.dpIndicatorMap.get(drn);
  }

  private void doConfig(DataSpecTypeEnum type) {
    this.dpIndicatorMap = new HashMap<>();
    this.dxIndicatorMap = new HashMap<>();

    switch (type) {
      case CAT062_AIRCRAFT_DERIVED_DATA:
        this.maxDrn = AIRCRAFT_DERIVED_DATA_MAX_DRN;
        this.maxDxn = AIRCRAFT_DERIVED_DATA_MAX_DXN;
        break;
      case CAT062_SYSTEM_TRACK_UPDATE_AGES:
        this.maxDrn = SYSTEM_TRACK_UPDATE_AGES_MAX_DRN;
        this.maxDxn = SYSTEM_TRACK_UPDATE_AGES_MAX_DXN;
        break;
      case CAT062_TRACK_DATA_AGES:
        this.maxDrn = TRACK_DATA_AGES_MAX_DRN;
        this.maxDxn = TRACK_DATA_AGES_MAX_DXN;
        break;
      case CAT062_FLIGHT_PLAN_RELATED_DATA:
        this.maxDrn = FLIGHT_PLAN_RELATED_DATA_MAX_DRN;
        this.maxDxn = FLIGHT_PLAN_RELATED_DATA_MAX_DXN;
        break;
      case CAT062_MODE5_EXTENDED_MODE1_DATA:
        this.maxDrn = MODE5_EXTENDED_MODE1_DATA_MAX_DRN;
        this.maxDxn = MODE5_EXTENDED_MODE1_DATA_MAX_DXN;
        break;
      case CAT062_ESTIMATED_ACCURACY:
        this.maxDrn = ESTIMATED_ACCURACY_MAX_DRN;
        this.maxDxn = ESTIMATED_ACCURACY_MAX_DXN;
        break;
      case CAT062_MEASURED_INFORMATION:
        this.maxDrn = MEASURED_INFORMATION_MAX_DRN;
        this.maxDxn = MEASURED_INFORMATION_MAX_DXN;
        break;
      default:
        this.maxDrn = DEFAULT_MAX_DRN;
        this.maxDxn = DEFAULT_MAX_DXN;
        break;
    }
  }

  private void initIndicatorMap(int maxDrn, int maxDxn) {

    // 创建DpIndicator对象
    for (int i = 0; i < maxDrn; i++) {
      DpIndicator dpIndicator = new DpIndicator();
      int drn = i + DRN_START_NUM;
      dpIndicator.setDrn(drn);
      dpIndicator.setIndication(DEFAULT_DP_INDICATION);
      dpIndicator.setSize(DEFAULT_DP_INDICATOR_SIZE);
      this.dpIndicatorMap.put(drn, dpIndicator);
    }

    // 创建DxIndicator对象
    for (int i = 0; i < maxDxn; i++) {
      DxIndicator dxIndicator = new DxIndicator();
      String dxn = DX_PREFIX + (i + DXN_START_NUM);
      dxIndicator.setDxn(dxn);
      dxIndicator.setIndication(DEFAULT_DX_INDICATION);
      this.dxIndicatorMap.put(dxn, dxIndicator);
    }
  }

  public void readValue(List<Byte> uap, int start) {

    int sizeCount = 0;
    this.startIndex = start;
    int index = this.startIndex;

    for (int i = 0; i < maxDxn; i++) {
      Byte dataSpecOctet = uap.get(index);
      for (int j = 0; j < DRN_OCTET_SIZE; j++) {
        // set f1-f7
        int dpIndicatorDrn = i * DRN_OCTET_SIZE + j + DRN_START_NUM;

        String dpIndicatorIndicationBit = ByteUtil.getBitByIndex(dataSpecOctet, j);

        DpIndicator dpIndicator = this.dpIndicatorMap.get(dpIndicatorDrn);

        dpIndicator.setIndication(
            ZERO_BIT.equals(dpIndicatorIndicationBit)
                ? DpIndicationEnum.ABSENCE
                : DpIndicationEnum.PRESENCE);
      }

      // set dxIndicator
      String dxIndicatorDxn = DX_PREFIX + (i + DXN_START_NUM);
      String dxIndicatorIndicationBit = ByteUtil.getBitByIndex(dataSpecOctet, 7);

      DxIndicator dxIndicator = this.dxIndicatorMap.get(dxIndicatorDxn);
      dxIndicator.setIndication(
          ZERO_BIT.equals(dxIndicatorIndicationBit)
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

    int index = this.startIndex + this.size;
    for (int i = DRN_START_NUM; i < drn; i++) {
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
      int drn = i + DRN_START_NUM;
      length += this.dpIndicatorMap.get(drn).getSize();
    }
    return length;
  }
}
