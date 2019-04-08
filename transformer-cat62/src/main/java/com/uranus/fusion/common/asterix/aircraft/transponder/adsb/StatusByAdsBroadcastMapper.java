package com.uranus.fusion.common.asterix.aircraft.transponder.adsb;

import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.ByteUtil;
import com.uranus.fusion.common.asterix.util.IntegerUtil;
import com.uranus.fusion.common.asterix.aircraft.transponder.BitSetEnum;
import com.uranus.fusion.common.asterix.aircraft.transponder.CorrectionEnum;
import com.uranus.fusion.common.asterix.aircraft.transponder.OperationalEnum;

import java.util.List;

/**
 * StatusByAdsBroadcastMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/30
 */
public class StatusByAdsBroadcastMapper {

  public static StatusByAdsBroadcast readStatusReportedByAdsB(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 11;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(2);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      StatusByAdsBroadcast statusByAdsB = new StatusByAdsBroadcast();

      String acasOperationStatusBits = ByteUtil.toString(uap.get(index)).substring(0, 2);
      switch (acasOperationStatusBits) {
        case "00":
          statusByAdsB.setAcasOperationStatus(OperationalEnum.UNKNOWN);
          break;
        case "01":
          statusByAdsB.setAcasOperationStatus(OperationalEnum.NOT_OPERATIONAL);
          break;
        case "10":
          statusByAdsB.setAcasOperationStatus(OperationalEnum.OPERATIONAL);
          break;
        case "11":
          statusByAdsB.setAcasOperationStatus(OperationalEnum.INVALID);
          break;
        default:
          statusByAdsB.setAcasOperationStatus(OperationalEnum.UNKNOWN);
          break;
      }

      String multiNavaidsOperationStatusBits = ByteUtil.toString(uap.get(index)).substring(2, 4);
      switch (multiNavaidsOperationStatusBits) {
        case "00":
          statusByAdsB.setMultiNavaidsOperationStatus(OperationalEnum.UNKNOWN);
          break;
        case "01":
          statusByAdsB.setMultiNavaidsOperationStatus(OperationalEnum.NOT_OPERATIONAL);
          break;
        case "10":
          statusByAdsB.setMultiNavaidsOperationStatus(OperationalEnum.OPERATIONAL);
          break;
        case "11":
          statusByAdsB.setMultiNavaidsOperationStatus(OperationalEnum.INVALID);
          break;
        default:
          statusByAdsB.setMultiNavaidsOperationStatus(OperationalEnum.UNKNOWN);
          break;
      }

      String differentialCorrectionStatusBits = ByteUtil.toString(uap.get(index)).substring(4, 6);
      switch (differentialCorrectionStatusBits) {
        case "00":
          statusByAdsB.setDifferentialCorrectionEnum(CorrectionEnum.UNKNOWN);
          break;
        case "01":
          statusByAdsB.setDifferentialCorrectionEnum(CorrectionEnum.CORRECTION);
          break;
        case "10":
          statusByAdsB.setDifferentialCorrectionEnum(CorrectionEnum.NO_CORRECTION);
          break;
        case "11":
          statusByAdsB.setDifferentialCorrectionEnum(CorrectionEnum.INVALID);
          break;
        default:
          statusByAdsB.setDifferentialCorrectionEnum(CorrectionEnum.UNKNOWN);
          break;
      }

      String groundBitStatusBits = ByteUtil.toString(uap.get(index)).substring(7, 8);
      statusByAdsB.setGroundBitStatus(
          zeroBit.equals(groundBitStatusBits) ? BitSetEnum.NOT_SET : BitSetEnum.SET);

      String flightStatusBits = ByteUtil.toString(uap.get(index + 1)).substring(5, 8);
      int flightStatusValue = IntegerUtil.valueOf(ByteUtil.valueOf(flightStatusBits));
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
          statusByAdsB.setFlightStatusEnum(AdsBroadcastFlightStatusEnum.UNKNOWN);
          break;
        default:
          statusByAdsB.setFlightStatusEnum(AdsBroadcastFlightStatusEnum.UNKNOWN);
          break;
      }
      return statusByAdsB;
    }
    return null;
  }
}
