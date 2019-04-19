package com.uranus.fusion.asterix.cat062.aircraftdata.sub;

import com.uranus.fusion.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.measure.angle.TrackAngle;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * TrackAngleMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class TrackAngleMapper {

  public static TrackAngle readTrackAngle(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(AircraftDerivedDataConfig.TRACK_ANGLE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.TRACK_ANGLE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.TRACK_ANGLE_DRN);

      TrackAngle trackAngle = new TrackAngle();

      int trackAngleValue = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      double resolution = DecimalUtil.divide(360, Math.pow(2, 16));
      trackAngle.setAngle(DecimalUtil.multiply(trackAngleValue, resolution));

      return trackAngle;
    }
    return null;
  }
}
