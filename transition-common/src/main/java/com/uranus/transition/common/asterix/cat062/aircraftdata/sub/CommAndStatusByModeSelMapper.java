package com.uranus.transition.common.asterix.cat062.aircraftdata.sub;

import com.uranus.transition.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.comm.CommCapabilityEnum;
import com.uranus.transition.common.asterix.uap.datainfo.CapabilityEnum;
import com.uranus.transition.common.asterix.uap.emitter.modesel.CommAndStatusByModeSel;
import com.uranus.transition.common.asterix.uap.emitter.modesel.ModeSelFlightStatusEnum;
import com.uranus.transition.common.asterix.uap.measure.altitude.AltitudeReportCapabilityEnum;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * CommAndStatusByModeSelMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/30
 */
public class CommAndStatusByModeSelMapper {

  public static CommAndStatusByModeSel read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.COMM_AND_STATUS_BY_MODESEL_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.COMM_AND_STATUS_BY_MODESEL_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(
              AircraftDerivedDataConfig.COMM_AND_STATUS_BY_MODESEL_DRN);

      CommAndStatusByModeSel commAndStatusByModeS = new CommAndStatusByModeSel();

      String commCapabilityBits = ByteUtil.toString(uap.get(index)).substring(0, 3);
      int commCapabilityValue =
          IntegerUtil.unsignedValueOf(ByteUtil.unsignedValueOf(commCapabilityBits));
      switch (commCapabilityValue) {
        case 1:
          commAndStatusByModeS.setCommCapabilityEnum(CommCapabilityEnum.COMM_AB);
          break;
        case 2:
          commAndStatusByModeS.setCommCapabilityEnum(CommCapabilityEnum.COMM_AB_UDELM);
          break;
        case 3:
          commAndStatusByModeS.setCommCapabilityEnum(CommCapabilityEnum.COMM_AB_UELM);
          break;
        case 4:
          commAndStatusByModeS.setCommCapabilityEnum(CommCapabilityEnum.LEVEL_5);
          break;
        case 0:
        default:
          commAndStatusByModeS.setCommCapabilityEnum(CommCapabilityEnum.NO_COMM);
          break;
      }

      String flightStatusBits = ByteUtil.toString(uap.get(index)).substring(3, 6);
      int flightStatusValue =
          IntegerUtil.unsignedValueOf(ByteUtil.unsignedValueOf(flightStatusBits));
      switch (flightStatusValue) {
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
        case 0:
        default:
          commAndStatusByModeS.setModeSelFlightStatusEnum(ModeSelFlightStatusEnum.NA_NS_AIR);
          break;
      }

      String specificServiceCapabilityBits = ByteUtil.toString(uap.get(index + 1)).substring(0, 1);
      commAndStatusByModeS.setSpecificServiceCapability(
          ByteUtil.ZERO_BIT.equals(specificServiceCapabilityBits)
              ? CapabilityEnum.NO
              : CapabilityEnum.YES);

      String altitudeReportingCapabilityBits =
          ByteUtil.toString(uap.get(index + 1)).substring(1, 2);
      commAndStatusByModeS.setAltitudeReportCapabilityEnum(
          ByteUtil.ZERO_BIT.equals(altitudeReportingCapabilityBits)
              ? AltitudeReportCapabilityEnum.FEET_100
              : AltitudeReportCapabilityEnum.FEET_25);

      String aircraftIdentificationCapabilityBits =
          ByteUtil.toString(uap.get(index + 1)).substring(2, 3);
      commAndStatusByModeS.setAircraftIdentificationCapability(
          ByteUtil.ZERO_BIT.equals(aircraftIdentificationCapabilityBits)
              ? CapabilityEnum.NO
              : CapabilityEnum.YES);

      String bdsAValue = ByteUtil.toString(uap.get(index + 1)).substring(3, 4);
      commAndStatusByModeS.setBdsA(bdsAValue);

      String bdsBValue = ByteUtil.toString(uap.get(index + 1)).substring(4, 8);
      commAndStatusByModeS.setBdsB(bdsBValue);
      return new CommAndStatusByModeSel();
    }
    return null;
  }
}
