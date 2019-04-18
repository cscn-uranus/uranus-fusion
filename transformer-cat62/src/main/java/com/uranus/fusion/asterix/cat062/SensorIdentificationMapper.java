package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.identification.SystemIdentification;
import com.uranus.fusion.util.ByteUtil;

import java.util.List;

/**
 * SensorIdentificationMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class SensorIdentificationMapper {

  public static SystemIdentification read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 1;
    final int size = 2;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      SystemIdentification sensorIdentification = new SystemIdentification();

      String sac = ByteUtil.toString(uap.get(index));
      sensorIdentification.setSac(sac);

      String sic = ByteUtil.toString(uap.get(index + 1));
      sensorIdentification.setSic(sic);

      return sensorIdentification;
    }
    return null;
  }
}
