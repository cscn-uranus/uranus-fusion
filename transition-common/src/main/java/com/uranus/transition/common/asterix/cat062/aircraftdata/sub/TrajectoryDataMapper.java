package com.uranus.transition.common.asterix.cat062.aircraftdata.sub;

import com.uranus.transition.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.datainfo.DataAvailableEnum;
import com.uranus.transition.common.asterix.uap.measure.movement.TurnDirectionEnum;
import com.uranus.transition.common.asterix.uap.trajectory.ComplianceEnum;
import com.uranus.transition.common.asterix.uap.trajectory.TrajectoryIntentData;
import com.uranus.transition.common.asterix.uap.trajectory.TrajectoryPoint;
import com.uranus.transition.common.asterix.uap.trajectory.TrajectoryPointTypeEnum;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * TrajectoryDataMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/25
 */
public class TrajectoryDataMapper {

  public static TrajectoryIntentData read(List<Byte> uap, DataSpec dataSpec) {

    TrajectoryIntentData trajectoryIntentData = new TrajectoryIntentData();

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.TRAJECTORY_INTENT_DATA_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.TRAJECTORY_INTENT_DATA_DRN);

      int repeatIndicator = IntegerUtil.unsignedValueOf(uap.get(index));
      trajectoryIntentData.setRepeatIndicator(repeatIndicator);

      for (int i = 0; i < repeatIndicator; i++) {
        TrajectoryPoint trajectoryPoint = new TrajectoryPoint();

        trajectoryPoint.setTcpAvailableStatus(
            ByteUtil.ZERO_BIT.equals(ByteUtil.toString(uap.get(index + 1)).substring(0, 1))
                ? DataAvailableEnum.AVAILABLE
                : DataAvailableEnum.NOT_AVAILABLE);

        trajectoryPoint.setTcpComplianceStatus(
            ByteUtil.ZERO_BIT.equals(ByteUtil.toString(uap.get(index + 1)).substring(1, 2))
                ? ComplianceEnum.COMPLIANCE
                : ComplianceEnum.NOT_COMPLIANCE);

        String tcpNumValue = ByteUtil.toString(uap.get(index + 1)).substring(3, 8);
        int tcpNum = IntegerUtil.unsignedValueOf(ByteUtil.unsignedValueOf(tcpNumValue));
        trajectoryPoint.setTcpNumber(tcpNum);

        int altitude = IntegerUtil.unsignedValueOf(uap.get(index + 2), uap.get(index + 3));
        trajectoryPoint.setAltitude(altitude);

        double resolution = DecimalUtil.divide(180, Math.pow(2, 23));
        int latitudeValue =
            IntegerUtil.unsignedValueOf(uap.get(index + 4), uap.get(index + 5), uap.get(index + 6));
        double latitude = DecimalUtil.multiply(latitudeValue, resolution);
        trajectoryPoint.setLatitude(latitude);
        int longitudeValue =
            IntegerUtil.unsignedValueOf(uap.get(index + 7), uap.get(index + 8), uap.get(index + 9));
        double longitude = DecimalUtil.multiply(longitudeValue, resolution);
        trajectoryPoint.setLongitude(longitude);

        int pointTypeValue =
            IntegerUtil.unsignedValueOf(
                ByteUtil.unsignedValueOf(ByteUtil.toString(uap.get(index + 10)).substring(0, 4)));

        switch (pointTypeValue) {
          case 1:
            trajectoryPoint.setTrajectoryPointTypeEnum(TrajectoryPointTypeEnum.FLY_BY);
            break;
          case 2:
            trajectoryPoint.setTrajectoryPointTypeEnum(TrajectoryPointTypeEnum.FLY_OVER);
            break;
          case 3:
            trajectoryPoint.setTrajectoryPointTypeEnum(TrajectoryPointTypeEnum.HOLD_PATTERN);
            break;
          case 4:
            trajectoryPoint.setTrajectoryPointTypeEnum(TrajectoryPointTypeEnum.PROCEDURE_HOLD);
            break;
          case 5:
            trajectoryPoint.setTrajectoryPointTypeEnum(TrajectoryPointTypeEnum.PROCEDURE_TURN);
            break;
          case 6:
            trajectoryPoint.setTrajectoryPointTypeEnum(TrajectoryPointTypeEnum.RF_LEG);
            break;
          case 7:
            trajectoryPoint.setTrajectoryPointTypeEnum(TrajectoryPointTypeEnum.TOP_CLIMB);
            break;
          case 8:
            trajectoryPoint.setTrajectoryPointTypeEnum(TrajectoryPointTypeEnum.TOP_DESCENT);
            break;
          case 9:
            trajectoryPoint.setTrajectoryPointTypeEnum(TrajectoryPointTypeEnum.START_LEVEL);
            break;
          case 10:
            trajectoryPoint.setTrajectoryPointTypeEnum(TrajectoryPointTypeEnum.CROSSOVER_ALITUDE);
            break;
          case 11:
            trajectoryPoint.setTrajectoryPointTypeEnum(TrajectoryPointTypeEnum.TRANSITION_ALITUDE);
            break;
          case 0:
          default:
            trajectoryPoint.setTrajectoryPointTypeEnum(TrajectoryPointTypeEnum.UNKNOWN);
            break;
        }

        String turnDirectionValue = ByteUtil.toString(uap.get(index + 10)).substring(4, 6);
        switch (turnDirectionValue) {
          case "01":
            trajectoryPoint.setTurnDirectionEnum(TurnDirectionEnum.RIGHT);
            break;
          case "10":
            trajectoryPoint.setTurnDirectionEnum(TurnDirectionEnum.LEFT);
          case "11":
            trajectoryPoint.setTurnDirectionEnum(TurnDirectionEnum.STRAIGHT);
            break;
          case "00":
          default:
            trajectoryPoint.setTurnDirectionEnum(TurnDirectionEnum.NA);
            break;
        }

        String turnRadiusStatusValue = ByteUtil.toString(uap.get(index + 10)).substring(6, 7);
        trajectoryPoint.setTurnRadiusStatus(
            ByteUtil.ZERO_BIT.equals(turnRadiusStatusValue)
                ? DataAvailableEnum.NOT_AVAILABLE
                : DataAvailableEnum.AVAILABLE);

        String timeOverPointStatusValue = ByteUtil.toString(uap.get(index + 10)).substring(7, 8);
        trajectoryPoint.setTimeOverPointStatus(
            ByteUtil.ZERO_BIT.equals(timeOverPointStatusValue)
                ? DataAvailableEnum.AVAILABLE
                : DataAvailableEnum.NOT_AVAILABLE);

        int timeOverPointValue =
            IntegerUtil.unsignedValueOf(
                uap.get(index + 11), uap.get(index + 12), uap.get(index + 13));
        trajectoryPoint.setTimeOverPoint(timeOverPointValue);

        int turnRadiusValue = IntegerUtil.unsignedValueOf(uap.get(index + 14), uap.get(index + 15));
        double turnRadius = DecimalUtil.multiply(turnRadiusValue, 0.01);
        trajectoryPoint.setTurnRadius(turnRadius);

        trajectoryIntentData.add(trajectoryPoint);
        index += AircraftDerivedDataConfig.TRAJECTORY_INTENT_DATA_REPEAT_SIZE;
      }

      dpIndicator.setSize(
          trajectoryIntentData.getRepeatIndicator()
                  * AircraftDerivedDataConfig.TRAJECTORY_INTENT_DATA_REPEAT_SIZE
              + 1);
      return trajectoryIntentData;
    }
    return null;
  }
}
