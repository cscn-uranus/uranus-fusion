package com.uranus.fusion.asterix.cat062.aircraft;

import com.uranus.fusion.asterix.cat062.config.AircraftDerivedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.measure.VelocityUncertainty;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * VelocityUncertaintyMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class VelocityUncertaintyMapper {

  public static VelocityUncertainty readVelocityUncertainty(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.VELOCITY_UNCERTAINTY_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.VELOCITY_UNCERTAINTY_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.VELOCITY_UNCERTAINTY_DRN);

      VelocityUncertainty velocityUncertainty = new VelocityUncertainty();

      velocityUncertainty.setCategory(IntegerUtil.valueOf(uap.get(index)));

      return velocityUncertainty;
    }
    return null;
  }
}
