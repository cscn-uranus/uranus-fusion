package com.uranus.fusion.transformer.asterix.track.status;

import com.uranus.fusion.transformer.asterix.message.spec.FieldSpec;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicator;
import com.uranus.fusion.transformer.asterix.track.status.type.AdsBroadcastConsistentStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.AgeStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.AmalgamationStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.CalculatedAltitudeSourceEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.DataConflictStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.DataDuplicateStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.EarlyTrackIndicationEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.EmergencyStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.FinalTrackIndicationEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.FlightPlanCorrelatedStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.FplDataStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.InterrogationStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.MilitaryEmergencyStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.MilitaryIdentificationStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.MostReliableAltitudeStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.PotentialFalseStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.SensorSourceStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.ServiceUsedEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.SlavePromotionStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.SpecialUsedCodeStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.SpiStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.SurveillanceDataStatusEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.TargetTypeEnum;
import com.uranus.fusion.transformer.asterix.track.status.type.TrackCertaintyStatusEnum;
import com.uranus.fusion.transformer.asterix.util.ByteUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;
import java.util.List;

/**
 * TrackStatusMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/6
 */
public class TrackStatusMapper {

  public static TrackStatus readTrackStatus(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 13;
    final int startLength = 1;
    final String zero = "0";

    int length = startLength;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      TrackStatus trackStatus = new TrackStatus();

      readZeroContent(uap.get(index), trackStatus);
      String fx0Bit = ByteUtil.toString(uap.get(index)).substring(7, 8);
      if (zero.equals(fx0Bit)) {
        fpIndicator.setSize(length);
        return trackStatus;
      }

      length++;

      readFirstContent(uap.get(index + 1), trackStatus);
      String fx1Bit = ByteUtil.toString(uap.get(index + 1)).substring(7, 8);
      if (zero.equals(fx1Bit)) {
        fpIndicator.setSize(length);
        return trackStatus;
      }

      length++;

      readSecondContent(uap.get(index + 2), trackStatus);
      String fx2Bit = ByteUtil.toString(uap.get(index + 2)).substring(7, 8);
      if (zero.equals(fx2Bit)) {
        fpIndicator.setSize(length);
        return trackStatus;
      }

      length++;

      readThirdContent(uap.get(index + 3), trackStatus);
      String fx3Bit = ByteUtil.toString(uap.get(index + 3)).substring(7, 8);
      if (zero.equals(fx3Bit)) {
        fpIndicator.setSize(length);
        return trackStatus;
      }

      length++;

      readFouthContent(uap.get(index + 4), trackStatus);
      String fx4Bit = ByteUtil.toString(uap.get(index + 4)).substring(7, 8);
      if (zero.equals(fx4Bit)) {
        fpIndicator.setSize(length);
        return trackStatus;
      }

      length++;

      readFifthContent(uap.get(index + 5), trackStatus);
      String fx5Bit = ByteUtil.toString(uap.get(index + 5)).substring(7, 8);
      if (zero.equals(fx5Bit)) {
        fpIndicator.setSize(length);
        return trackStatus;
      } else {
        return null;
      }
    }
    return null;
  }

  private static void readZeroContent(Byte octet, TrackStatus trackStatus) {
    final String zero = "0";

    String monBit = ByteUtil.toString(octet).substring(0, 1);
    trackStatus.setSensorSourceStatusEnum(
        zero.equals(monBit) ? SensorSourceStatusEnum.MULTISENSOR
            : SensorSourceStatusEnum.MONOSENSOR);

    String spiBit = ByteUtil.toString(octet).substring(1, 2);
    trackStatus
        .setSpiStatusEnum(zero.equals(spiBit) ? SpiStatusEnum.DEFAULT : SpiStatusEnum.PRESENT);

    String mrhBit = ByteUtil.toString(octet).substring(2, 3);
    trackStatus
        .setMostReliableAltitudeStatusEnum(zero.equals(mrhBit) ? MostReliableAltitudeStatusEnum.BARO
            : MostReliableAltitudeStatusEnum.GEO);

    String srcBits = ByteUtil.toString(octet).substring(3, 6);
    switch (srcBits) {
      case "000":
        trackStatus.setCalculatedAltitudeSourceEnum(CalculatedAltitudeSourceEnum.NO_SOURCE);
        break;
      case "001":
        trackStatus.setCalculatedAltitudeSourceEnum(CalculatedAltitudeSourceEnum.GNSS);
        break;
      case "010":
        trackStatus.setCalculatedAltitudeSourceEnum(CalculatedAltitudeSourceEnum.D3_RADAR);
        break;
      case "011":
        trackStatus.setCalculatedAltitudeSourceEnum(CalculatedAltitudeSourceEnum.TRIANGULATION);
        break;
      case "100":
        trackStatus.setCalculatedAltitudeSourceEnum(
            CalculatedAltitudeSourceEnum.HEIGHT_FROM_COVERAGE);
        break;
      case "101":
        trackStatus.setCalculatedAltitudeSourceEnum(CalculatedAltitudeSourceEnum.SPEED_LOOKUP_TABLE);
        break;
      case "110":
        trackStatus.setCalculatedAltitudeSourceEnum(CalculatedAltitudeSourceEnum.DEFAULT);
        break;
      case "111":
        trackStatus.setCalculatedAltitudeSourceEnum(CalculatedAltitudeSourceEnum.MULTILATERATION);
        break;
      default:
        trackStatus.setCalculatedAltitudeSourceEnum(CalculatedAltitudeSourceEnum.NO_SOURCE);
        break;
    }

    String cnfBit = ByteUtil.toString(octet).substring(6, 7);
    trackStatus.setTrackCertaintyStatusEnum(
        zero.equals(cnfBit) ? TrackCertaintyStatusEnum.CONFIRMED
            : TrackCertaintyStatusEnum.TENTATIVE);
  }

  private static void readFirstContent(Byte octet, TrackStatus trackStatus) {
    final String zero = "0";

    String simBit = ByteUtil.toString(octet).substring(0, 1);
    trackStatus
        .setTargetTypeEnum(zero.equals(simBit) ? TargetTypeEnum.ACTUAL : TargetTypeEnum.SIMULATED);

    String tseBit = ByteUtil.toString(octet).substring(1, 2);
    trackStatus.setFinalTrackIndicationEnum(
        zero.equals(tseBit) ? FinalTrackIndicationEnum.DEFAULT : FinalTrackIndicationEnum.LAST);

    String tsbBit = ByteUtil.toString(octet).substring(2, 3);
    trackStatus.setEarlyTrackIndicationEnum(
        zero.equals(tsbBit) ? EarlyTrackIndicationEnum.DEFAULT : EarlyTrackIndicationEnum.FIRST);

    String fpcBit = ByteUtil.toString(octet).substring(3, 4);
    trackStatus.setFlightPlanCorrelatedStatusEnum(
        zero.equals(fpcBit)
            ? FlightPlanCorrelatedStatusEnum.NOT_FLIGHT_PLAN_CORRELATED
            : FlightPlanCorrelatedStatusEnum.FLIGHT_PLAN_CORRELATED);

    String affBit = ByteUtil.toString(octet).substring(4, 5);
    trackStatus.setAdsBroadcastConsistentStatusEnum(
        zero.equals(affBit) ? AdsBroadcastConsistentStatusEnum.DEFAULT
            : AdsBroadcastConsistentStatusEnum.INCONSISTENT);

    String stpBit = ByteUtil.toString(octet).substring(5, 6);
    trackStatus.setSlavePromotionStatusEnum(
        zero.equals(stpBit)
            ? SlavePromotionStatusEnum.DEFAULT
            : SlavePromotionStatusEnum.SLAVE_TRACK_PROMOTION);

    String kosBit = ByteUtil.toString(octet).substring(6, 7);
    trackStatus.setServiceUsedEnum(
        zero.equals(kosBit) ? ServiceUsedEnum.COMPLEMENTARY : ServiceUsedEnum.BACKGROUND);
  }

  private static void readSecondContent(Byte octet, TrackStatus trackStatus) {
    final String zero = "0";

    String amaBit = ByteUtil.toString(octet).substring(0, 1);
    trackStatus.setAmalgamationStatusEnum(
        zero.equals(amaBit)
            ? AmalgamationStatusEnum.NOT_FROM_AMALGAMATION
            : AmalgamationStatusEnum.FROM_AMALGAMATION);

    String md4Bits = ByteUtil.toString(octet).substring(1, 3);
    switch (md4Bits) {
      case "00":
        trackStatus.setMode4InterrogationStatus(InterrogationStatusEnum.NO_INTERROGATION);
        break;
      case "01":
        trackStatus.setMode4InterrogationStatus(InterrogationStatusEnum.FRIENDLY);
        break;
      case "10":
        trackStatus.setMode4InterrogationStatus(InterrogationStatusEnum.UNKNOWN);
        break;
      case "11":
        trackStatus.setMode4InterrogationStatus(InterrogationStatusEnum.NO_REPLY);
        break;
      default:
        trackStatus.setMode4InterrogationStatus(InterrogationStatusEnum.NO_INTERROGATION);
        break;
    }

    String meBit = ByteUtil.toString(octet).substring(3, 4);
    trackStatus.setMilitaryEmergencyStatusEnum(
        zero.equals(meBit)
            ? MilitaryEmergencyStatusEnum.DEFAULT
            : MilitaryEmergencyStatusEnum.MILITARY_EMERGENCY);

    String miBit = ByteUtil.toString(octet).substring(4, 5);
    trackStatus.setMilitaryIdentificationStatusEnum(
        zero.equals(miBit)
            ? MilitaryIdentificationStatusEnum.DEFAULT
            : MilitaryIdentificationStatusEnum.MILITARY_IDENTIFICATION);

    String md5Bits = ByteUtil.toString(octet).substring(5, 7);
    switch (md5Bits) {
      case "00":
        trackStatus.setMode5InterrogationStatus(InterrogationStatusEnum.NO_INTERROGATION);
        break;
      case "01":
        trackStatus.setMode5InterrogationStatus(InterrogationStatusEnum.FRIENDLY);
        break;
      case "10":
        trackStatus.setMode5InterrogationStatus(InterrogationStatusEnum.UNKNOWN);
        break;
      case "11":
        trackStatus.setMode5InterrogationStatus(InterrogationStatusEnum.NO_REPLY);
        break;
      default:
        trackStatus.setMode5InterrogationStatus(InterrogationStatusEnum.NO_INTERROGATION);
        break;
    }
  }

  private static void readThirdContent(Byte octet, TrackStatus trackStatus) {
    final String zero = "0";

    String cstBit = ByteUtil.toString(octet).substring(0, 1);
    trackStatus.setCoastingStatusEnum(
        zero.equals(cstBit) ? AgeStatusEnum.DEFAULT : AgeStatusEnum.HIGHER);

    String psrBit = ByteUtil.toString(octet).substring(1, 2);
    trackStatus
        .setAgeStatusEnum(zero.equals(psrBit) ? AgeStatusEnum.DEFAULT : AgeStatusEnum.HIGHER);

    String ssrBit = ByteUtil.toString(octet).substring(2, 3);
    trackStatus
        .setSsrStatusEnum(zero.equals(ssrBit) ? AgeStatusEnum.DEFAULT : AgeStatusEnum.HIGHER);

    String mdsBit = ByteUtil.toString(octet).substring(4, 5);
    trackStatus
        .setModeSStatusEnum(zero.equals(mdsBit) ? AgeStatusEnum.DEFAULT : AgeStatusEnum.HIGHER);

    String adsBit = ByteUtil.toString(octet).substring(4, 5);
    trackStatus
        .setAdsbStatusEnum(zero.equals(adsBit) ? AgeStatusEnum.DEFAULT : AgeStatusEnum.HIGHER);

    String sucBit = ByteUtil.toString(octet).substring(5, 6);
    trackStatus.setSpecialUsedCodeStatusEnum(
        zero.equals(sucBit) ? SpecialUsedCodeStatusEnum.DEFAULT
            : SpecialUsedCodeStatusEnum.SPECIAL);

    String aacBit = ByteUtil.toString(octet).substring(6, 7);
    trackStatus.setDataConflictStatusEnum(
        zero.equals(aacBit) ? DataConflictStatusEnum.DEFAULT : DataConflictStatusEnum.CONFLICT);
  }

  private static void readFouthContent(Byte octet, TrackStatus trackStatus) {
    final String zero = "0";

    String sdsBits = ByteUtil.toString(octet).substring(0, 2);
    switch (sdsBits) {
      case "00":
        trackStatus.setSurveillanceDataStatusEnum(SurveillanceDataStatusEnum.COMBINED);
        break;
      case "01":
        trackStatus.setSurveillanceDataStatusEnum(SurveillanceDataStatusEnum.COOPERATIVE);
        break;
      case "10":
        trackStatus.setSurveillanceDataStatusEnum(SurveillanceDataStatusEnum.NONCOOPERATIVE);
        break;
      case "11":
        trackStatus.setSurveillanceDataStatusEnum(SurveillanceDataStatusEnum.NOT_DEFINED);
        break;
      default:
        trackStatus.setSurveillanceDataStatusEnum(SurveillanceDataStatusEnum.NOT_DEFINED);
        break;
    }

    String emsBits = ByteUtil.toString(octet).substring(2, 5);
    int emsValue = IntegerUtil.valueOf(ByteUtil.valueOf(emsBits));
    switch (emsValue) {
      case 0:
        trackStatus.setEmergencyStatusEnum(EmergencyStatusEnum.NO_EMERGENCY);
        break;
      case 1:
        trackStatus.setEmergencyStatusEnum(EmergencyStatusEnum.GENERAL_EMERGENCY);
        break;
      case 2:
        trackStatus.setEmergencyStatusEnum(EmergencyStatusEnum.LIFEGUARD);
        break;
      case 3:
        trackStatus.setEmergencyStatusEnum(EmergencyStatusEnum.MINIMUM_FUEL);
        break;
      case 4:
        trackStatus.setEmergencyStatusEnum(EmergencyStatusEnum.NO_COMMUNICATIONS);
        break;
      case 5:
        trackStatus.setEmergencyStatusEnum(EmergencyStatusEnum.UNLAWFUL_INTERFERENCE);
        break;
      case 6:
        trackStatus.setEmergencyStatusEnum(EmergencyStatusEnum.DOWNED);
        break;
      case 7:
        trackStatus.setEmergencyStatusEnum(EmergencyStatusEnum.UNDEFINED);
        break;
      default:
        trackStatus.setEmergencyStatusEnum(EmergencyStatusEnum.UNDEFINED);
        break;
    }

    String pftBit = ByteUtil.toString(octet).substring(5, 6);
    trackStatus.setPotentialFalseStatusEnum(
        zero.equals(pftBit)
            ? PotentialFalseStatusEnum.NO_INDICATION
            : PotentialFalseStatusEnum.POTENTIAL_FALSE);

    String fpltBit = ByteUtil.toString(octet).substring(6, 7);
    trackStatus.setFplDataStatusEnum(
        zero.equals(fpltBit) ? FplDataStatusEnum.DEFAULT : FplDataStatusEnum.TRACK_BY_FPL);
  }

  private static void readFifthContent(Byte octet, TrackStatus trackStatus) {
    final String zero = "0";

    String duptBit = ByteUtil.toString(octet).substring(0, 1);
    trackStatus.setDuplicateMode3CodeStatus(
        zero.equals(duptBit)
            ? DataDuplicateStatusEnum.DEFAULT
            : DataDuplicateStatusEnum.DUPLICATE);

    String dupfBit = ByteUtil.toString(octet).substring(1, 2);
    trackStatus.setDuplicateFlightPlanStatus(
        zero.equals(dupfBit)
            ? DataDuplicateStatusEnum.DEFAULT
            : DataDuplicateStatusEnum.DUPLICATE);

    String dupmBit = ByteUtil.toString(octet).substring(2, 3);
    trackStatus.setDuplicateManualFlightPlanStatus(
        zero.equals(dupmBit)
            ? DataDuplicateStatusEnum.DEFAULT
            : DataDuplicateStatusEnum.DUPLICATE_MANUAL);
  }
}
