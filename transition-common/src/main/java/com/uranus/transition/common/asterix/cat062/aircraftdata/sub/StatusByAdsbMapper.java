package com.uranus.transition.common.asterix.cat062.aircraftdata.sub;

import com.uranus.transition.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.datainfo.CorrectionEnum;
import com.uranus.transition.common.asterix.uap.emitter.adsb.AdsBroadcastFlightStatusEnum;
import com.uranus.transition.common.asterix.uap.emitter.adsb.BitSetStatusEnum;
import com.uranus.transition.common.asterix.uap.emitter.adsb.OperationalEnum;
import com.uranus.transition.common.asterix.uap.emitter.adsb.StatusByAdsb;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * StatusByAdsbMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/30
 */
public class StatusByAdsbMapper {

  public static StatusByAdsb read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.STATUS_REPORTED_BY_ADSB_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.STATUS_REPORTED_BY_ADSB_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.STATUS_REPORTED_BY_ADSB_DRN);

      StatusByAdsb statusByAdsB = new StatusByAdsb();

      String acasOperationStatusBits = ByteUtil.toString(uap.get(index)).substring(0, 2);
      switch (acasOperationStatusBits) {
        case "01":
          statusByAdsB.setAcasOperationStatus(OperationalEnum.NOT_OPERATIONAL);
          break;
        case "10":
          statusByAdsB.setAcasOperationStatus(OperationalEnum.OPERATIONAL);
          break;
        case "11":
          statusByAdsB.setAcasOperationStatus(OperationalEnum.INVALID);
          break;
        case "00":
        default:
          statusByAdsB.setAcasOperationStatus(OperationalEnum.UNKNOWN);
          break;
      }

      String multiNavaidsOperationStatusBits = ByteUtil.toString(uap.get(index)).substring(2, 4);
      switch (multiNavaidsOperationStatusBits) {
        case "01":
          statusByAdsB.setMultiNavaidsOperationStatus(OperationalEnum.NOT_OPERATIONAL);
          break;
        case "10":
          statusByAdsB.setMultiNavaidsOperationStatus(OperationalEnum.OPERATIONAL);
          break;
        case "11":
          statusByAdsB.setMultiNavaidsOperationStatus(OperationalEnum.INVALID);
          break;
        case "00":
        default:
          statusByAdsB.setMultiNavaidsOperationStatus(OperationalEnum.UNKNOWN);
          break;
      }

      String differentialCorrectionStatusBits = ByteUtil.toString(uap.get(index)).substring(4, 6);
      switch (differentialCorrectionStatusBits) {
        case "01":
          statusByAdsB.setDifferentialCorrectionEnum(CorrectionEnum.CORRECTION);
          break;
        case "10":
          statusByAdsB.setDifferentialCorrectionEnum(CorrectionEnum.NO_CORRECTION);
          break;
        case "11":
          statusByAdsB.setDifferentialCorrectionEnum(CorrectionEnum.INVALID);
          break;
        case "00":
        default:
          statusByAdsB.setDifferentialCorrectionEnum(CorrectionEnum.UNKNOWN);
          break;
      }

      String groundBitStatusBits = ByteUtil.toString(uap.get(index)).substring(7, 8);
      statusByAdsB.setGroundBitStatus(
          ByteUtil.ZERO_BIT.equals(groundBitStatusBits)
              ? BitSetStatusEnum.NOT_SET
              : BitSetStatusEnum.SET);

      String flightStatusBits = ByteUtil.toString(uap.get(index + 1)).substring(5, 8);
      int flightStatusValue =
          IntegerUtil.unsignedValueOf(ByteUtil.unsignedValueOf(flightStatusBits));
      switch (flightStatusValue) {
        case 0:
          statusByAdsB.setFlightStatusEnum(AdsBroadcastFlightStatusEnum.NO_EMG);
          break;
        case 1:
          statusByAdsB.setFlightStatusEnum(AdsBroadcastFlightStatusEnum.GENERAL_EMG);
          break;
        case 2:
          statusByAdsB.setFlightStatusEnum(AdsBroadcastFlightStatusEnum.LIFEGUARD_MEDICAL);
          break;
        case 3:
          statusByAdsB.setFlightStatusEnum(AdsBroadcastFlightStatusEnum.MINI_FUEL);
          break;
        case 4:
          statusByAdsB.setFlightStatusEnum(AdsBroadcastFlightStatusEnum.NO_COMM);
          break;
        case 5:
          statusByAdsB.setFlightStatusEnum(AdsBroadcastFlightStatusEnum.UNLAWFUAL_INTERFER);
          break;
        case 6:
          statusByAdsB.setFlightStatusEnum(AdsBroadcastFlightStatusEnum.DOWNED);
          break;
        case 7:
        default:
          statusByAdsB.setFlightStatusEnum(AdsBroadcastFlightStatusEnum.UNKNOWN);
          break;
      }
      return statusByAdsB;
    }
    return null;
  }
}
