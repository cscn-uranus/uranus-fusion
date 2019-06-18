package com.uranus.transition.common.asterix.cat062;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.datainfo.TargetTypeEnum;
import com.uranus.transition.common.asterix.uap.emitter.InterrogationStatusEnum;
import com.uranus.transition.common.asterix.uap.emitter.adsb.AdsBroadcastConsistentStatusEnum;
import com.uranus.transition.common.asterix.uap.flightplan.FlightPlanCorrelatedStatusEnum;
import com.uranus.transition.common.asterix.uap.flightplan.FplDataStatusEnum;
import com.uranus.transition.common.asterix.uap.measure.altitude.CalculatedAltitudeSourceEnum;
import com.uranus.transition.common.asterix.uap.measure.altitude.MostReliableAltitudeStatusEnum;
import com.uranus.transition.common.asterix.uap.military.MilitaryEmergencyStatusEnum;
import com.uranus.transition.common.asterix.uap.military.MilitaryIdentificationStatusEnum;
import com.uranus.transition.common.asterix.uap.track.TrackStatus;
import com.uranus.transition.common.asterix.uap.track.status.*;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * TrackStatusReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/6
 */
public class TrackStatusReader {

  public static TrackStatus readTrackStatus(List<Byte> uap, FieldSpec fieldSpec) {

    int sizeCount = Cat062Config.TRACK_STATUS_EX_SIZE;

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(Cat062Config.TRACK_STATUS_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateIndexByFrn(Cat062Config.TRACK_STATUS_FRN);

      TrackStatus trackStatus = new TrackStatus();

      readZeroContent(uap.get(index), trackStatus);
      String fx0Bit = ByteUtil.toString(uap.get(index)).substring(7, 8);
      if (ByteUtil.ZERO_BIT.equals(fx0Bit)) {
        fpIndicator.setSize(sizeCount);
        return trackStatus;
      }

      sizeCount++;

      readFirstContent(uap.get(index + 1), trackStatus);
      String fx1Bit = ByteUtil.toString(uap.get(index + 1)).substring(7, 8);
      if (ByteUtil.ZERO_BIT.equals(fx1Bit)) {
        fpIndicator.setSize(sizeCount);
        return trackStatus;
      }

      sizeCount++;

      readSecondContent(uap.get(index + 2), trackStatus);
      String fx2Bit = ByteUtil.toString(uap.get(index + 2)).substring(7, 8);
      if (ByteUtil.ZERO_BIT.equals(fx2Bit)) {
        fpIndicator.setSize(sizeCount);
        return trackStatus;
      }

      sizeCount++;

      readThirdContent(uap.get(index + 3), trackStatus);
      String fx3Bit = ByteUtil.toString(uap.get(index + 3)).substring(7, 8);
      if (ByteUtil.ZERO_BIT.equals(fx3Bit)) {
        fpIndicator.setSize(sizeCount);
        return trackStatus;
      }

      sizeCount++;

      readFourthContent(uap.get(index + 4), trackStatus);
      String fx4Bit = ByteUtil.toString(uap.get(index + 4)).substring(7, 8);
      if (ByteUtil.ZERO_BIT.equals(fx4Bit)) {
        fpIndicator.setSize(sizeCount);
        return trackStatus;
      }

      sizeCount++;

      readFifthContent(uap.get(index + 5), trackStatus);
      String fx5Bit = ByteUtil.toString(uap.get(index + 5)).substring(7, 8);
      if (ByteUtil.ZERO_BIT.equals(fx5Bit)) {
        fpIndicator.setSize(sizeCount);
        return trackStatus;
      } else {
        return null;
      }
    }
    return null;
  }

  private static void readZeroContent(Byte octet, TrackStatus trackStatus) {

    String monBit = ByteUtil.toString(octet).substring(0, 1);
    trackStatus.setSensorSourceStatusEnum(
        ByteUtil.ZERO_BIT.equals(monBit)
            ? SensorSourceStatusEnum.MULTI_SENSOR
            : SensorSourceStatusEnum.MONO_SENSOR);

    String spiBit = ByteUtil.toString(octet).substring(1, 2);
    trackStatus.setSpiStatusEnum(
        ByteUtil.ZERO_BIT.equals(spiBit) ? SpiStatusEnum.DEFAULT : SpiStatusEnum.PRESENT);

    String mrhBit = ByteUtil.toString(octet).substring(2, 3);
    trackStatus.setMostReliableAltitudeStatusEnum(
        ByteUtil.ZERO_BIT.equals(mrhBit)
            ? MostReliableAltitudeStatusEnum.BARO
            : MostReliableAltitudeStatusEnum.GEO);

    String srcBits = ByteUtil.toString(octet).substring(3, 6);
    switch (srcBits) {
      case "001":
        trackStatus.setCalculatedAltitudeSourceEnum(CalculatedAltitudeSourceEnum.GNSS);
        break;
      case "010":
        trackStatus.setCalculatedAltitudeSourceEnum(CalculatedAltitudeSourceEnum.RADAR_3D);
        break;
      case "011":
        trackStatus.setCalculatedAltitudeSourceEnum(CalculatedAltitudeSourceEnum.TRIANGULATION);
        break;
      case "100":
        trackStatus.setCalculatedAltitudeSourceEnum(
            CalculatedAltitudeSourceEnum.HEIGHT_FROM_COVERAGE);
        break;
      case "101":
        trackStatus.setCalculatedAltitudeSourceEnum(
            CalculatedAltitudeSourceEnum.SPEED_LOOKUP_TABLE);
        break;
      case "110":
        trackStatus.setCalculatedAltitudeSourceEnum(CalculatedAltitudeSourceEnum.DEFAULT);
        break;
      case "111":
        trackStatus.setCalculatedAltitudeSourceEnum(CalculatedAltitudeSourceEnum.MULTILATERATION);
        break;
      case "000":
      default:
        trackStatus.setCalculatedAltitudeSourceEnum(CalculatedAltitudeSourceEnum.NO_SOURCE);
        break;
    }

    String cnfBit = ByteUtil.toString(octet).substring(6, 7);
    trackStatus.setTrackCertaintyStatusEnum(
        ByteUtil.ZERO_BIT.equals(cnfBit)
            ? TrackCertaintyStatusEnum.CONFIRMED
            : TrackCertaintyStatusEnum.TENTATIVE);
  }

  private static void readFirstContent(Byte octet, TrackStatus trackStatus) {

    String simBit = ByteUtil.toString(octet).substring(0, 1);
    trackStatus.setTargetTypeEnum(
        ByteUtil.ZERO_BIT.equals(simBit) ? TargetTypeEnum.ACTUAL : TargetTypeEnum.SIMULATED);

    String tseBit = ByteUtil.toString(octet).substring(1, 2);
    trackStatus.setLastMessageStatusEnum(
        ByteUtil.ZERO_BIT.equals(tseBit)
            ? LastMessageStatusEnum.DEFAULT
            : LastMessageStatusEnum.LAST);

    String tsbBit = ByteUtil.toString(octet).substring(2, 3);
    trackStatus.setFirstMessageStatusEnum(
        ByteUtil.ZERO_BIT.equals(tsbBit)
            ? FirstMessageStatusEnum.DEFAULT
            : FirstMessageStatusEnum.FIRST);

    String fpcBit = ByteUtil.toString(octet).substring(3, 4);
    trackStatus.setFlightPlanCorrelatedStatusEnum(
        ByteUtil.ZERO_BIT.equals(fpcBit)
            ? FlightPlanCorrelatedStatusEnum.NOT_FLIGHT_PLAN_CORRELATED
            : FlightPlanCorrelatedStatusEnum.FLIGHT_PLAN_CORRELATED);

    String affBit = ByteUtil.toString(octet).substring(4, 5);
    trackStatus.setAdsBroadcastConsistentStatusEnum(
        ByteUtil.ZERO_BIT.equals(affBit)
            ? AdsBroadcastConsistentStatusEnum.DEFAULT
            : AdsBroadcastConsistentStatusEnum.INCONSISTENT);

    String stpBit = ByteUtil.toString(octet).substring(5, 6);
    trackStatus.setSlavePromotionStatusEnum(
        ByteUtil.ZERO_BIT.equals(stpBit)
            ? SlavePromotionStatusEnum.DEFAULT
            : SlavePromotionStatusEnum.SLAVE_TRACK_PROMOTION);

    String kosBit = ByteUtil.toString(octet).substring(6, 7);
    trackStatus.setKindOfServiceStatusEnum(
        ByteUtil.ZERO_BIT.equals(kosBit)
            ? KindOfServiceStatusEnum.COMPLEMENTARY
            : KindOfServiceStatusEnum.BACKGROUND);
  }

  private static void readSecondContent(Byte octet, TrackStatus trackStatus) {

    String amaBit = ByteUtil.toString(octet).substring(0, 1);
    trackStatus.setAmalgamationStatusEnum(
        ByteUtil.ZERO_BIT.equals(amaBit)
            ? AmalgamationStatusEnum.NOT_FROM_AMALGAMATION
            : AmalgamationStatusEnum.FROM_AMALGAMATION);

    String md4Bits = ByteUtil.toString(octet).substring(1, 3);
    switch (md4Bits) {
      case "01":
        trackStatus.setMode4InterrogationStatus(InterrogationStatusEnum.FRIENDLY);
        break;
      case "10":
        trackStatus.setMode4InterrogationStatus(InterrogationStatusEnum.UNKNOWN);
        break;
      case "11":
        trackStatus.setMode4InterrogationStatus(InterrogationStatusEnum.NO_REPLY);
        break;
      case "00":
      default:
        trackStatus.setMode4InterrogationStatus(InterrogationStatusEnum.NO_INTERROGATION);
        break;
    }

    String meBit = ByteUtil.toString(octet).substring(3, 4);
    trackStatus.setMilitaryEmergencyStatusEnum(
        ByteUtil.ZERO_BIT.equals(meBit)
            ? MilitaryEmergencyStatusEnum.DEFAULT
            : MilitaryEmergencyStatusEnum.MILITARY_EMERGENCY);

    String miBit = ByteUtil.toString(octet).substring(4, 5);
    trackStatus.setMilitaryIdentificationStatusEnum(
        ByteUtil.ZERO_BIT.equals(miBit)
            ? MilitaryIdentificationStatusEnum.DEFAULT
            : MilitaryIdentificationStatusEnum.MILITARY_IDENTIFICATION);

    String md5Bits = ByteUtil.toString(octet).substring(5, 7);
    switch (md5Bits) {
      case "01":
        trackStatus.setMode5InterrogationStatus(InterrogationStatusEnum.FRIENDLY);
        break;
      case "10":
        trackStatus.setMode5InterrogationStatus(InterrogationStatusEnum.UNKNOWN);
        break;
      case "11":
        trackStatus.setMode5InterrogationStatus(InterrogationStatusEnum.NO_REPLY);
        break;
      case "00":
      default:
        trackStatus.setMode5InterrogationStatus(InterrogationStatusEnum.NO_INTERROGATION);
        break;
    }
  }

  private static void readThirdContent(Byte octet, TrackStatus trackStatus) {

    String cstBit = ByteUtil.toString(octet).substring(0, 1);
    trackStatus.setCoastingStatusEnum(
        ByteUtil.ZERO_BIT.equals(cstBit) ? AgeStatusEnum.DEFAULT : AgeStatusEnum.HIGHER);

    String psrBit = ByteUtil.toString(octet).substring(1, 2);
    trackStatus.setPsrStatusEnum(
        ByteUtil.ZERO_BIT.equals(psrBit) ? AgeStatusEnum.DEFAULT : AgeStatusEnum.HIGHER);

    String ssrBit = ByteUtil.toString(octet).substring(2, 3);
    trackStatus.setSsrStatusEnum(
        ByteUtil.ZERO_BIT.equals(ssrBit) ? AgeStatusEnum.DEFAULT : AgeStatusEnum.HIGHER);

    String mdsBit = ByteUtil.toString(octet).substring(4, 5);
    trackStatus.setModeselStatusEnum(
        ByteUtil.ZERO_BIT.equals(mdsBit) ? AgeStatusEnum.DEFAULT : AgeStatusEnum.HIGHER);

    String adsBit = ByteUtil.toString(octet).substring(4, 5);
    trackStatus.setAdsbStatusEnum(
        ByteUtil.ZERO_BIT.equals(adsBit) ? AgeStatusEnum.DEFAULT : AgeStatusEnum.HIGHER);

    String sucBit = ByteUtil.toString(octet).substring(5, 6);
    trackStatus.setSpecialUsedCodeStatusEnum(
        ByteUtil.ZERO_BIT.equals(sucBit)
            ? SpecialUsedCodeStatusEnum.DEFAULT
            : SpecialUsedCodeStatusEnum.SPECIAL);

    String aacBit = ByteUtil.toString(octet).substring(6, 7);
    trackStatus.setDataConflictStatusEnum(
        ByteUtil.ZERO_BIT.equals(aacBit)
            ? DataConflictStatusEnum.DEFAULT
            : DataConflictStatusEnum.CONFLICT);
  }

  private static void readFourthContent(Byte octet, TrackStatus trackStatus) {

    String sdsBits = ByteUtil.toString(octet).substring(0, 2);
    switch (sdsBits) {
      case "00":
        trackStatus.setSurveillanceDataStatusEnum(SurveillanceDataStatusEnum.COMBINED);
        break;
      case "01":
        trackStatus.setSurveillanceDataStatusEnum(SurveillanceDataStatusEnum.COOPERATIVE);
        break;
      case "10":
        trackStatus.setSurveillanceDataStatusEnum(SurveillanceDataStatusEnum.NON_COOPERATIVE);
        break;
      case "11":
      default:
        trackStatus.setSurveillanceDataStatusEnum(SurveillanceDataStatusEnum.NOT_DEFINED);
        break;
    }

    String emsBits = ByteUtil.toString(octet).substring(2, 5);
    int emsValue = IntegerUtil.unsignedValueOf(ByteUtil.unsignedValueOf(emsBits));
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
      default:
        trackStatus.setEmergencyStatusEnum(EmergencyStatusEnum.UNDEFINED);
        break;
    }

    String pftBit = ByteUtil.toString(octet).substring(5, 6);
    trackStatus.setPotentialFalseStatusEnum(
        ByteUtil.ZERO_BIT.equals(pftBit)
            ? PotentialFalseStatusEnum.NO_INDICATION
            : PotentialFalseStatusEnum.POTENTIAL_FALSE);

    String fpltBit = ByteUtil.toString(octet).substring(6, 7);
    trackStatus.setFplDataStatusEnum(
        ByteUtil.ZERO_BIT.equals(fpltBit)
            ? FplDataStatusEnum.DEFAULT
            : FplDataStatusEnum.TRACK_BY_FPL);
  }

  private static void readFifthContent(Byte octet, TrackStatus trackStatus) {

    String duptBit = ByteUtil.toString(octet).substring(0, 1);
    trackStatus.setDuplicateMode3CodeStatus(
        ByteUtil.ZERO_BIT.equals(duptBit)
            ? DataDuplicateStatusEnum.DEFAULT
            : DataDuplicateStatusEnum.DUPLICATE);

    String dupfBit = ByteUtil.toString(octet).substring(1, 2);
    trackStatus.setDuplicateFlightPlanStatus(
        ByteUtil.ZERO_BIT.equals(dupfBit)
            ? DataDuplicateStatusEnum.DEFAULT
            : DataDuplicateStatusEnum.DUPLICATE);

    String dupmBit = ByteUtil.toString(octet).substring(2, 3);
    trackStatus.setDuplicateManualFlightPlanStatus(
        ByteUtil.ZERO_BIT.equals(dupmBit)
            ? DataDuplicateStatusEnum.DEFAULT
            : DataDuplicateStatusEnum.DUPLICATE_MANUAL);
  }
}
