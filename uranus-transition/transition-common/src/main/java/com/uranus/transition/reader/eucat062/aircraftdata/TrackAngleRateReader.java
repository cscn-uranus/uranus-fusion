package com.uranus.transition.reader.eucat062.aircraftdata;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.angle.TrackAngleRate;
import com.uranus.transition.common.asterix.uap.shared.measure.movement.TurnDirectionEnum;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * TrackAngleRateReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
class TrackAngleRateReader {

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
