package com.uranus.fusion.transformer.asterix.aircraft.transponder.comm;

import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.ByteUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;

import java.util.List;

/**
 * CommAndStatusByModeSelMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/30
 */
public class CommAndStatusByModeSelMapper {

  public static CommAndStatusByModeSel read(
      List<Byte> uap, DataSpec dataSpec) {

    final int drn = 10;
    final int size = 2;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      CommAndStatusByModeSel commAndStatusByModeS = new CommAndStatusByModeSel();

      String commCapabilityBits = ByteUtil.toString(uap.get(index)).substring(0, 3);
      int commCapabilityValue = IntegerUtil.valueOf(ByteUtil.valueOf(commCapabilityBits));
      switch (commCapabilityValue) {
        case 0:
          commAndStatusByModeS.setCommCapabilityEnum(CommCapabilityEnum.NO_COMM);
          break;
        case 1:
          commAndStatusByModeS.setCommCapabilityEnum(CommCapabilityEnum.COMM_AB);
          break;
        case 2:
          commAndStatusByModeS.setCommCapabilityEnum(CommCapabilityEnum.COMM_AB_UDELM);
          break;
        case 3:
          commAndStatusByModeS.setCommCapabilityEnum(CommCapabilityEnum.COMM_AB_UDELM);
          break;
        case 4:
          commAndStatusByModeS.setCommCapabilityEnum(CommCapabilityEnum.LEVEL_5);
          break;
        default:
          commAndStatusByModeS.setCommCapabilityEnum(CommCapabilityEnum.NO_COMM);
          break;
      }

      String flightStatusBits = ByteUtil.toString(uap.get(index)).substring(3, 6);
      int flightStatusValue = IntegerUtil.valueOf(ByteUtil.valueOf(flightStatusBits));
      switch (flightStatusValue) {
        case 0:
          commAndStatusByModeS.setModeSelFlightStatusEnum(ModeSelFlightStatusEnum.NA_NS_AIR);
          break;
        case 1:
          commAndStatusByModeS.setModeSelFlightStatusEnum(ModeSelFlightStatusEnum.NA_NS_GROUND);
          break;
        case 2:
          commAndStatusByModeS.setModeSelFlightStatusEnum(ModeSelFlightStatusEnum.PA_NS_AIR);
          break;
        case 3:
          commAndStatusByModeS.setModeSelFlightStatusEnum(ModeSelFlightStatusEnum.PA_NS_GROUND);
          break;
        case 4:
          commAndStatusByModeS.setModeSelFlightStatusEnum(ModeSelFlightStatusEnum.PA_PS);
          break;
        case 5:
          commAndStatusByModeS.setModeSelFlightStatusEnum(ModeSelFlightStatusEnum.NA_PS);
          break;
        default:
          commAndStatusByModeS.setModeSelFlightStatusEnum(ModeSelFlightStatusEnum.NA_NS_AIR);
          break;
      }

      String specificServiceCapabilityBits = ByteUtil.toString(uap.get(index + 1)).substring(0, 1);
      commAndStatusByModeS.setSpecificServiceCapability(
          zeroBit.equals(specificServiceCapabilityBits)
              ? ServiceCapabilityEnum.NO
              : ServiceCapabilityEnum.YES);

      String altitudeReportingCapabilityBits =
          ByteUtil.toString(uap.get(index + 1)).substring(1, 2);
      commAndStatusByModeS.setAltitudeReportCapabilityEnum(
          zeroBit.equals(altitudeReportingCapabilityBits)
              ? AltitudeReportCapabilityEnum.FEET_100
              : AltitudeReportCapabilityEnum.FEET_25);

      String aircraftIdentificationCapabilityBits =
          ByteUtil.toString(uap.get(index + 1)).substring(2, 3);
      commAndStatusByModeS.setAircraftIdentificationCapability(
          zeroBit.equals(aircraftIdentificationCapabilityBits)
              ? ServiceCapabilityEnum.NO
              : ServiceCapabilityEnum.YES);

      String bdsAValue = ByteUtil.toString(uap.get(index + 1)).substring(3, 4);
      commAndStatusByModeS.setBdsA(bdsAValue);

      String bdsBValue = ByteUtil.toString(uap.get(index + 1)).substring(4, 8);
      commAndStatusByModeS.setBdsB(bdsBValue);
      return new CommAndStatusByModeSel();
    }
    return null;
  }
}
