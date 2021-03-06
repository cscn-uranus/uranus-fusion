package com.uranus.transition.reader.eucat062.flightplan;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.datainfo.DataAvailableEnum;
import com.uranus.transition.common.asterix.uap.shared.flightplan.CabinStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.flightplan.StandStatus;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
 class StandStatusReader {

  public static StandStatus read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.STAND_STATUS_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(FlightPlanRelatedDataConfig.STAND_STATUS_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(FlightPlanRelatedDataConfig.STAND_STATUS_DRN);

      StandStatus standStatus = new StandStatus();

      String empBits = ByteUtil.toString(uap.get(index)).substring(0, 2);
      switch (empBits) {
        case "00":
          standStatus.setCabinStatusEnum(CabinStatusEnum.EMPTY);
          break;
        case "01":
          standStatus.setCabinStatusEnum(CabinStatusEnum.OCCUPIED);
          break;
        case "10":
          standStatus.setCabinStatusEnum(CabinStatusEnum.UNKNOWN);
          break;
        case "11":
        default:
          standStatus.setCabinStatusEnum(CabinStatusEnum.INVALID);
          break;
      }

      String avlBits = ByteUtil.toString(uap.get(index)).substring(2, 4);
      switch (avlBits) {
        case "00":
          standStatus.setDataAvailableEnum(DataAvailableEnum.AVAILABLE);
          break;
        case "01":
          standStatus.setDataAvailableEnum(DataAvailableEnum.NOT_AVAILABLE);
          break;
        case "10":
          standStatus.setDataAvailableEnum(DataAvailableEnum.UNKNOWN);
          break;
        case "11":
        default:
          standStatus.setDataAvailableEnum(DataAvailableEnum.INVALID);
          break;
      }

      return standStatus;
    }
    return null;
  }
}
