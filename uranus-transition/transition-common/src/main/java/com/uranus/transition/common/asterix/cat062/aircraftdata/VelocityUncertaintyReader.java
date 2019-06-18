package com.uranus.transition.common.asterix.cat062.aircraftdata;

import com.uranus.transition.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.measure.VelocityUncertainty;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * VelocityUncertaintyReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
class VelocityUncertaintyReader {

  public static VelocityUncertainty readVelocityUncertainty(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.VELOCITY_UNCERTAINTY_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.VELOCITY_UNCERTAINTY_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.VELOCITY_UNCERTAINTY_DRN);

      VelocityUncertainty velocityUncertainty = new VelocityUncertainty();

      velocityUncertainty.setCategory(IntegerUtil.unsignedValueOf(uap.get(index)));

      return velocityUncertainty;
    }
    return null;
  }
}
