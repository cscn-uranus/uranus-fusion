package com.uranus.fusion.asterix.uap.flightplan;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.datainfo.DataAvailableEnum;
import com.uranus.fusion.util.ByteUtil;

import java.util.List;

/**
 * StandStatusMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class StandStatusMapper {

  public static StandStatus read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 14;
    final int length = 1;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(length);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

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
          standStatus.setCabinStatusEnum(CabinStatusEnum.INVALID);
          break;
        default:
          standStatus.setCabinStatusEnum(CabinStatusEnum.UNKNOWN);
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
          standStatus.setDataAvailableEnum(DataAvailableEnum.INVALID);
          break;
        default:
          standStatus.setDataAvailableEnum(DataAvailableEnum.UNKNOWN);
          break;
      }

      return standStatus;
    }
    return null;
  }
}
