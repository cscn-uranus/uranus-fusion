package com.uranus.fusion.common.asterix.cat062.aircraftdata.sub;

import com.uranus.fusion.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.measure.angle.TrackAngleRate;
import com.uranus.fusion.common.asterix.uap.measure.movement.TurnDirectionEnum;
import com.uranus.fusion.common.util.ByteUtil;
import com.uranus.fusion.common.util.DecimalUtil;
import com.uranus.fusion.common.util.IntegerUtil;

import java.util.List;

/**
 * TrackAngleRateMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class TrackAngleRateMapper {

  public static TrackAngleRate read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.TRACK_ANGLE_RATE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.TRACK_ANGLE_RATE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.TRACK_ANGLE_RATE_DRN);

      TrackAngleRate trackAngleRate = new TrackAngleRate();

      String turnDirectionBits = ByteUtil.toString(uap.get(index)).substring(0, 2);
      switch (turnDirectionBits) {
        case "01":
          trackAngleRate.setTurnDirectionEnum(TurnDirectionEnum.LEFT);
          break;
        case "10":
          trackAngleRate.setTurnDirectionEnum(TurnDirectionEnum.RIGHT);
          break;
        case "11":
          trackAngleRate.setTurnDirectionEnum(TurnDirectionEnum.STRAIGHT);
          break;
        case "00":
        default:
          trackAngleRate.setTurnDirectionEnum(TurnDirectionEnum.NA);
          break;
      }

      String rateBits = ByteUtil.toString(uap.get(index + 1)).substring(0, 7);
      if (rateBits.startsWith(ByteUtil.ONE_BIT)) {
        rateBits = ByteUtil.ONE_BIT + rateBits;
      }
      int rateValue = IntegerUtil.signedValueOf(ByteUtil.unsignedValueOf(rateBits));
      double rate = DecimalUtil.multiply(rateValue, 0.25);
      trackAngleRate.setRate(rate);

      return trackAngleRate;
    }
    return null;
  }
}
