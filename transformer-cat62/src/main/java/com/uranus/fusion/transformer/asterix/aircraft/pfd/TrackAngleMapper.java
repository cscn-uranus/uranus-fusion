package com.uranus.fusion.transformer.asterix.aircraft.pfd;

import com.uranus.fusion.transformer.asterix.measure.TrackAngle;
import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;

import java.util.List;

/**
 * TrackAngleMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class TrackAngleMapper {

  public static TrackAngle readTrackAngle(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 17;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(2);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      TrackAngle trackAngle = new TrackAngle();

      int trackAngleValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      double resolution = DecimalUtil.divide(360, Math.pow(2, 16));
      trackAngle.setAngle(DecimalUtil.multiply(trackAngleValue, resolution));

      return trackAngle;
    }
    return null;
  }
}
