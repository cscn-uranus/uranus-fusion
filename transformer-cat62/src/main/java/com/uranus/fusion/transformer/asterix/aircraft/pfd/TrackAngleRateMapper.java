package com.uranus.fusion.transformer.asterix.aircraft.pfd;

import com.uranus.fusion.transformer.asterix.measure.TrackAngleRate;
import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.ByteUtil;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;

import java.util.List;

/**
 * TrackAngleRateMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class TrackAngleRateMapper {

  public static TrackAngleRate readTrackAngleRate(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 16;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(2);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      TrackAngleRate trackAngleRate = new TrackAngleRate();

      String turnDirectionBits = ByteUtil.toString(uap.get(index)).substring(0, 2);
      switch (turnDirectionBits) {
        case "00":
          trackAngleRate.setTurnDirectionEnum(TurnDirectionEnum.NA);
          break;
        case "01":
          trackAngleRate.setTurnDirectionEnum(TurnDirectionEnum.NA);
          break;
        case "10":
          trackAngleRate.setTurnDirectionEnum(TurnDirectionEnum.NA);
          break;
        case "11":
          trackAngleRate.setTurnDirectionEnum(TurnDirectionEnum.NA);
          break;
        default:
          trackAngleRate.setTurnDirectionEnum(TurnDirectionEnum.NA);
          break;
      }

      String rateBits = ByteUtil.toString(uap.get(index + 1)).substring(0, 7);
      int rateValue = IntegerUtil.valueOf(ByteUtil.valueOf(rateBits));
      double rate = DecimalUtil.multiply(rateValue, 0.25);
      trackAngleRate.setRate(rate);

      return trackAngleRate;
    }
    return null;
  }
}
