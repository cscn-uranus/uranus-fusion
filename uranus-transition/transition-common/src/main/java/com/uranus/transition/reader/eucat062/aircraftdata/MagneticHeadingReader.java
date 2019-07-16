package com.uranus.transition.reader.eucat062.aircraftdata;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.shared.aircraft.MagneticHeading;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/30
 */
 class MagneticHeadingReader {

  public static MagneticHeading read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.MAGNETIC_HEADING_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.MAGNETIC_HEADING_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.MAGNETIC_HEADING_DRN);

      MagneticHeading magneticHeading = new MagneticHeading();

      int degreeValue = IntegerUtil.unsignedValueOf(uap.get(index), uap.get(index + 1));
      double resolution = DecimalUtil.divide(360, Math.pow(2, 16));
      double degree = DecimalUtil.multiply(degreeValue, resolution);
      magneticHeading.setDegree(degree);

      return magneticHeading;
    }
    return null;
  }
}
