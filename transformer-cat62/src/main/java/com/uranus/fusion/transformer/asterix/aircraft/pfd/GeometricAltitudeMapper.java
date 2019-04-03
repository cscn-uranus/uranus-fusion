package com.uranus.fusion.transformer.asterix.aircraft.pfd;

import com.uranus.fusion.transformer.asterix.measure.GeometricAltitude;
import com.uranus.fusion.transformer.asterix.measure.GeometricAltitudeEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.DpIndicator;
import com.uranus.fusion.transformer.asterix.util.DecimalUtil;
import com.uranus.fusion.transformer.asterix.util.IntegerUtil;

import java.util.List;

/**
 * GeometricAltitudeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class GeometricAltitudeMapper {

  public static GeometricAltitude readGeometricAltitude(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 23;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(2);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      GeometricAltitude geometricAltitude =
          new GeometricAltitude(GeometricAltitudeEnum.AIRCRAFT_DERIVED);

      int altitude = IntegerUtil.valueOf(uap.get(index), uap.get(index + 1));
      geometricAltitude.setAltitude(DecimalUtil.multiply(altitude, 6.25));

      return geometricAltitude;
    }
    return null;
  }
}
