package com.uranus.transition.common.asterix.cat062.aircraftdata;

import com.uranus.transition.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.measure.angle.TrackAngle;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * TrackAngleReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
class TrackAngleReader {

  public static TrackAngle read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(AircraftDerivedDataConfig.TRACK_ANGLE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.TRACK_ANGLE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.TRACK_ANGLE_DRN);

      TrackAngle trackAngle = new TrackAngle();

      int trackAngleValue = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      double resolution = DecimalUtil.divide(360, Math.pow(2, 16));
      trackAngle.setAngle(DecimalUtil.multiply(trackAngleValue, resolution));

      return trackAngle;
    }
    return null;
  }
}
