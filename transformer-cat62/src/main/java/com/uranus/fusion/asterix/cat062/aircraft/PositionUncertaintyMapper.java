package com.uranus.fusion.asterix.cat062.aircraft;

import com.uranus.fusion.asterix.cat062.config.AircraftDerivedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.measure.position.PositionUncertainty;
import com.uranus.fusion.util.ByteUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * PositionUncertaintyMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class PositionUncertaintyMapper {

  public static PositionUncertainty readPositionUncertainty(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(AircraftDerivedDataConfig.POSITION_UNCERTAINTY_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.POSITION_UNCERTAINTY_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.POSITION_UNCERTAINTY_SIZE);

      PositionUncertainty positionUncertainty = new PositionUncertainty();

      String positionUncertaintyBits = ByteUtil.toString(uap.get(index)).substring(4, 8);
      positionUncertainty.setCategory(
          IntegerUtil.valueOf(ByteUtil.valueOf(positionUncertaintyBits)));

      return positionUncertainty;
    }
    return null;
  }
}
