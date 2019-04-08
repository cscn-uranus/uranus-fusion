package com.uranus.fusion.common.asterix.aircraft.nd;

import com.uranus.fusion.common.asterix.aircraft.pfd.TurnDirectionEnum;
import com.uranus.fusion.common.asterix.aircraft.transponder.comm.ComplianceEnum;
import com.uranus.fusion.common.asterix.aircraft.type.DataAvailableEnum;
import com.uranus.fusion.common.asterix.aircraft.type.DataValidEnum;
import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.ByteUtil;
import com.uranus.fusion.common.asterix.util.DecimalUtil;
import com.uranus.fusion.common.asterix.util.IntegerUtil;

import java.util.List;

/**
 * TrajectoryMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/25
 */
public class TrajectoryMapper {

  public static TrajectoryIntentStatus readTrajectoryIntentStatus(List<Byte> uap,
      DataSpec dataSpec) {
    final int drn = 8;
    final int size = 1;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      TrajectoryIntentStatus trajectoryIntentStatus = new TrajectoryIntentStatus();

      String dataAvailableValue = ByteUtil.toString(uap.get(index)).substring(0, 1);
      trajectoryIntentStatus.setDataAvailableStatus(
          zeroBit.equals(dataAvailableValue) ? DataAvailableEnum.AVAILABLE
              : DataAvailableEnum.NOT_AVAILABLE);

      String dataValidValue = ByteUtil.toString(uap.get(index)).substring(1, 2);
      trajectoryIntentStatus.setDataValidStatus(
          zeroBit.equals(dataValidValue) ? DataValidEnum.VALID : DataValidEnum.NOT_VALID);

      return trajectoryIntentStatus;
    }
    return null;
  }

  public static TrajectoryIntentData readTrajectoryIntentData(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 9;
    final int repeatStep = 15;
    final String zeroBit = "0";

    TrajectoryIntentData trajectoryIntentData = new TrajectoryIntentData();

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index = dataSpec.calculateOctetIndexByDrn(drn);

      int repeatIndicator = IntegerUtil.valueOf(uap.get(index));
      trajectoryIntentData.setRepeatIndicator(repeatIndicator);

      for (int i = 0; i < repeatIndicator; i++) {
        TrajectoryPoint trajectoryPoint = new TrajectoryPoint();

        trajectoryPoint.setTcpAvailableStatus(
            zeroBit.equals(ByteUtil.toString(uap.get(index + 1)).substring(0, 1))
                ? DataAvailableEnum.AVAILABLE
                : DataAvailableEnum.NOT_AVAILABLE);

        trajectoryPoint.setTcpComplianceStatus(
            zeroBit.equals(ByteUtil.toString(uap.get(index + 1)).substring(1, 2))
                ? ComplianceEnum.COMPLIANCE
                : ComplianceEnum.NOT_COMPLIANCE);

        String tcpNumValue = ByteUtil.toString(uap.get(index + 1)).substring(3, 8);
        int tcpNum = IntegerUtil.valueOf(ByteUtil.valueOf(tcpNumValue));
        trajectoryPoint.setTcpNumber(tcpNum);

        int altitude = IntegerUtil.valueOf(uap.get(index + 2), uap.get(index + 3));
        trajectoryPoint.setAltitude(altitude);

        double resolution = DecimalUtil.divide(180, Math.pow(2, 23));
        int latitudeValue =
            IntegerUtil.valueOf(uap.get(index + 4), uap.get(index + 5), uap.get(index + 6));
        double latitude = DecimalUtil.multiply(latitudeValue, resolution);
        trajectoryPoint.setLatitude(latitude);
        int longitudeValue =
            IntegerUtil.valueOf(uap.get(index + 7), uap.get(index + 8), uap.get(index + 9));
        double longitude = DecimalUtil.multiply(longitudeValue, resolution);
        trajectoryPoint.setLongitude(longitude);

        int pointTypeValue =
            IntegerUtil.valueOf(
                ByteUtil.valueOf(ByteUtil.toString(uap.get(index + 10)).substring(0, 4)));

        switch (pointTypeValue) {
          case 0:
            trajectoryPoint.setTrajectoryPointTypeEnum(TrajectoryPointTypeEnum.UNKNOWN);
            break;
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
          default:
            trajectoryPoint.setTrajectoryPointTypeEnum(TrajectoryPointTypeEnum.UNKNOWN);
            break;
        }

        String turnDirectionValue = ByteUtil.toString(uap.get(index + 10)).substring(4, 6);
        switch (turnDirectionValue) {
          case "00":
            trajectoryPoint.setTurnDirectionEnum(TurnDirectionEnum.NA);
            break;
          case "01":
            trajectoryPoint.setTurnDirectionEnum(TurnDirectionEnum.RIGHT);
            break;
          case "10":
            trajectoryPoint.setTurnDirectionEnum(TurnDirectionEnum.LEFT);
          case "11":
            trajectoryPoint.setTurnDirectionEnum(TurnDirectionEnum.STRAIGHT);
            break;
          default:
            trajectoryPoint.setTurnDirectionEnum(TurnDirectionEnum.NA);
            break;
        }

        String turnRadiusStatusValue = ByteUtil.toString(uap.get(index + 10)).substring(6, 7);
        trajectoryPoint.setTurnRadiusStatus(
            zeroBit.equals(turnRadiusStatusValue)
                ? DataAvailableEnum.NOT_AVAILABLE
                : DataAvailableEnum.AVAILABLE);

        String timeOverPointStatusValue = ByteUtil.toString(uap.get(index + 10)).substring(7, 8);
        trajectoryPoint.setTimeOverPointStatus(
            zeroBit.equals(timeOverPointStatusValue)
                ? DataAvailableEnum.AVAILABLE
                : DataAvailableEnum.NOT_AVAILABLE);

        int timeOverPointValue =
            IntegerUtil.valueOf(uap.get(index + 11), uap.get(index + 12), uap.get(index + 13));
        trajectoryPoint.setTimeOverPoint(timeOverPointValue);

        int turnRadiusValue = IntegerUtil.valueOf(uap.get(index + 14), uap.get(index + 15));
        double turnRadius = DecimalUtil.multiply(turnRadiusValue, 0.01);
        trajectoryPoint.setTurnRadius(turnRadius);

        trajectoryIntentData.add(trajectoryPoint);
        index += repeatStep;
      }

      dpIndicator.setSize(
          trajectoryIntentData.getRepeatIndicator() * repeatStep + 1);
      return trajectoryIntentData;
    }
    return null;
  }
}
