package com.uranus.fusion.asterix.cat062.measured.sub;

import com.uranus.fusion.asterix.cat062.measured.MeasuredInformationConfig;
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

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(MeasuredInformationConfig.SENSOR_IDENTIFICATION_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(MeasuredInformationConfig.SENSOR_IDENTIFICATION_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(MeasuredInformationConfig.SENSOR_IDENTIFICATION_DRN);

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
