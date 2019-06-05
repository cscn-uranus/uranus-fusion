package com.uranus.transition.common.asterix.cat062.dataage.sub;

import com.uranus.transition.common.asterix.cat062.dataage.TrackDataAgeConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.track.DataAge;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * TrackAngleAgeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
public class CommAndFlightStatusDataAgeMapper {

  public static DataAge read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(TrackDataAgeConfig.COMM_AND_FLIGHT_STATUS_AGE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(TrackDataAgeConfig.COMM_AND_FLIGHT_STATUS_AGE_SIZE);

      int index =
          dataSpec.calculateOctetIndexByDrn(TrackDataAgeConfig.COMM_AND_FLIGHT_STATUS_AGE_DRN);

      DataAge age = new DataAge();
      int ageValue = IntegerUtil.unsignedValueOf(uap.get(index));

      age.setAge(DecimalUtil.multiply(ageValue, 0.25));
      return age;
    }
    return null;
  }
}
