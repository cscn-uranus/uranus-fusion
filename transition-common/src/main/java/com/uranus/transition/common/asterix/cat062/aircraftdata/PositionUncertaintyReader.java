package com.uranus.transition.common.asterix.cat062.aircraftdata;

import com.uranus.transition.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.measure.position.PositionUncertainty;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * PositionUncertaintyReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
 class PositionUncertaintyReader {

  public static PositionUncertainty read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.POSITION_UNCERTAINTY_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.POSITION_UNCERTAINTY_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.POSITION_UNCERTAINTY_SIZE);

      PositionUncertainty positionUncertainty = new PositionUncertainty();

      String positionUncertaintyBits = ByteUtil.toString(uap.get(index)).substring(4, 8);
      positionUncertainty.setCategory(
          IntegerUtil.unsignedValueOf(ByteUtil.unsignedValueOf(positionUncertaintyBits)));

      return positionUncertainty;
    }
    return null;
  }
}
