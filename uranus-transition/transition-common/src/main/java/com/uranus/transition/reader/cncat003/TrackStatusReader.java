package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.cncat003.TargetReportInformation;
import com.uranus.transition.common.asterix.uap.cncat003.TrackStatus;
import com.uranus.transition.common.asterix.uap.shared.datainfo.*;
import com.uranus.transition.common.asterix.uap.shared.flightplan.FlightPlanStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.measure.movement.VerticalMoveEnum;
import com.uranus.transition.common.asterix.uap.shared.military.MilitaryEmergencyStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.military.MilitaryIdentificationStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.track.status.*;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

/**
 * @author 肖鹏 tellxp@github.com
 * @date 2019/6/25
 */
public class TrackStatusReader {

  public static TrackStatus read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(CnCat003Config.TRACK_STATUS_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int sizeCount = CnCat003Config.TRACK_STATUS_EX_SIZE;

      int index = fieldSpec.calculateIndexByFrn(CnCat003Config.TRACK_STATUS_FRN);

      TrackStatus trackStatus = new TrackStatus();

      readZeroContent(message.get(index), trackStatus);
      String fx0Bit = ByteUtil.toString(message.get(index)).substring(7, 8);
      if (ByteUtil.ZERO_BIT.equals(fx0Bit)) {
        fpIndicator.setSize(sizeCount);
        return trackStatus;
      }

      sizeCount+=CnCat003Config.TRACK_STATUS_EX_SIZE;

      readFirstContent(message.get(index+1),trackStatus);
      String fx1Bit = ByteUtil.toString(message.get(index+1)).substring(7,8);
      if (ByteUtil.ZERO_BIT.equals(fx1Bit)) {
        fpIndicator.setSize(sizeCount);
        return trackStatus;
      }

      readSecondContent(message.get(index+2),trackStatus);
      String fx2Bit = ByteUtil.toString(message.get(index+2)).substring(7,8);
      if (ByteUtil.ZERO_BIT.equals(fx2Bit)) {
        fpIndicator.setSize(sizeCount);
        return trackStatus;
      }
    }
    return null;
  }

  private static void readZeroContent(
      Byte octet, TrackStatus trackStatus) {
    String coBit = ByteUtil.toString(octet).substring(0,1);
    trackStatus.setTrackCertaintyStatusEnum(
      ByteUtil.ZERO_BIT.equals(coBit)? TrackCertaintyStatusEnum.CONFIRMED:TrackCertaintyStatusEnum.TENTATIVE
    );

    String simBit = ByteUtil.toString(octet).substring(1,2);
    trackStatus.setSensorSourceStatusEnum(
      ByteUtil.ZERO_BIT.equals(simBit)? SensorSourceStatusEnum.MONO_SENSOR:SensorSourceStatusEnum.MULTI_SENSOR
    );

    String mBit = ByteUtil.toString(octet).substring(2,3);
    trackStatus.setManeuverStatusEnum(
      ByteUtil.ZERO_BIT.equals(mBit)? ManeuverStatusEnum.DEFAULT:ManeuverStatusEnum.MANEUVER
    );

    String dBit = ByteUtil.toString(octet).substring(3,4);
    trackStatus.setTrackCorrelatedStatusEnum(
      ByteUtil.ZERO_BIT.equals(dBit)?CorrelatedStatusEnum.DEFAULT:CorrelatedStatusEnum.NOT_CORRELATED
    );

    String tBit = ByteUtil.toString(octet).substring(4,5);
    trackStatus.setLastMessageStatusEnum(
      ByteUtil.ZERO_BIT.equals(tBit)?LastMessageStatusEnum.DEFAULT:LastMessageStatusEnum.LAST
    );

    String hBit = ByteUtil.toString(octet).substring(6,7);
    trackStatus.setHandOverStatus(
      ByteUtil.ZERO_BIT.equals(hBit)? FlightPlanStatusEnum.DEFAULT:FlightPlanStatusEnum.HAND_OVER
    );
  }

  private static void readFirstContent(
      Byte octet, TrackStatus trackStatus) {
    String arrBit = ByteUtil.toString(octet).substring(0,1);
    trackStatus.setArrivalStatus(
      ByteUtil.ZERO_BIT.equals(arrBit)?FlightPlanStatusEnum.DEFAULT:FlightPlanStatusEnum.LANDING
    );

    String depBit = ByteUtil.toString(octet).substring(1,2);
    trackStatus.setDepartureStatus(
      ByteUtil.ZERO_BIT.equals(depBit)?FlightPlanStatusEnum.DEFAULT:FlightPlanStatusEnum.TAKEOFF
    );

    String cBit = ByteUtil.toString(octet).substring(2,3);
    trackStatus.setConflictAlert(
      ByteUtil.ZERO_BIT.equals(cBit)?AlertStatusEnum.DEFAULT:AlertStatusEnum.CA
    );

    String hBit = ByteUtil.toString(octet).substring(3,4);
    trackStatus.setMinimumSafeAltitudeWarning(
      ByteUtil.ZERO_BIT.equals(hBit)?AlertStatusEnum.DEFAULT:AlertStatusEnum.MASW
    );

    String rBit = ByteUtil.toString(octet).substring(4,5);
    trackStatus.setDangerAreaInWarning(
      ByteUtil.ZERO_BIT.equals(rBit)?AlertStatusEnum.DEFAULT:AlertStatusEnum.DAIW
    );

    String kBit = ByteUtil.toString(octet).substring(5,6);
    trackStatus.setOffCourseAlert(
      ByteUtil.ZERO_BIT.equals(kBit)?AlertStatusEnum.DEFAULT:AlertStatusEnum.OCA
    );

    String aBit = ByteUtil.toString(octet).substring(6,7);
    trackStatus.setHandInStatus(
      ByteUtil.ZERO_BIT.equals(aBit)?FlightPlanStatusEnum.DEFAULT:FlightPlanStatusEnum.HAND_IN
    );
  }
  private static void readSecondContent(
    Byte octet, TrackStatus trackStatus) {

    String  bBit = ByteUtil.toString(octet).substring(0,1);
    trackStatus.setExtrapolationStatusEnum(
      ByteUtil.ZERO_BIT.equals(bBit)?ExtrapolationStatusEnum.DEFAULT:ExtrapolationStatusEnum.EXTRAPOLATION
    );

    String acBit = ByteUtil.toString(octet).substring(1,3);
    switch (acBit) {
      case "01":
        trackStatus.setTrackVerticalStatusEnum(TrackVerticalStatusEnum.HIGH);
        break;
      case "10":
        trackStatus.setTrackVerticalStatusEnum(TrackVerticalStatusEnum.LOW);
        break;
      case "11":
        trackStatus.setTrackVerticalStatusEnum(TrackVerticalStatusEnum.UNDEFINED);
        break;
      case "00":
      default:
          trackStatus.setTrackVerticalStatusEnum(TrackVerticalStatusEnum.DEFAULT);
          break;
    }

    String stBit = ByteUtil.toString(octet).substring(3,5);
    switch (stBit) {
      case "01":
        trackStatus.setVerticalMoveEnum(VerticalMoveEnum.LEVEL);
        break;
      case "10":
        trackStatus.setVerticalMoveEnum(VerticalMoveEnum.CLIMB);
        break;
      case "11":
        trackStatus.setVerticalMoveEnum(VerticalMoveEnum.DESCENT);
        break;
      case "00":
      default:
        trackStatus.setVerticalMoveEnum(VerticalMoveEnum.UNDETERMINED);
        break;
    }
  }
}
