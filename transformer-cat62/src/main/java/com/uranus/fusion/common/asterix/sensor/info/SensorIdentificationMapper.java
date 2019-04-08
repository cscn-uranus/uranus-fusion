package com.uranus.fusion.common.asterix.sensor.info;

import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.SystemIdentifier;
import com.uranus.fusion.common.asterix.util.ByteUtil;
import java.util.List;

/**
 * SensorIdentificationMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class SensorIdentificationMapper {

  public static SystemIdentifier read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 1;
    final int size = 2;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      SystemIdentifier sensorIdentification = new SystemIdentifier();

      String sac = ByteUtil.toString(uap.get(index));
      sensorIdentification.setSac(sac);

      String sic = ByteUtil.toString(uap.get(index + 1));
      sensorIdentification.setSic(sic);

      return sensorIdentification;
    }
    return null;
  }

}
