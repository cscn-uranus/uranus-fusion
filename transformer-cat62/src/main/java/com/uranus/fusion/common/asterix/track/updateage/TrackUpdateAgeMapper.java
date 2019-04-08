package com.uranus.fusion.common.asterix.track.updateage;

import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.DecimalUtil;
import com.uranus.fusion.common.asterix.util.IntegerUtil;
import java.util.List;

/**
 * TrackUpdateAgeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/8
 */
public class TrackUpdateAgeMapper {


  public static TrackUpdateAge readByDrn(List<Byte> uap, DataSpec dataSpec, int drn) {
    final int adsContractDrn = 5;


    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index = dataSpec.calculateOctetIndexByDrn(drn);
      TrackUpdateAge trackUpdateAge = new TrackUpdateAge();

      if(drn==adsContractDrn) {
        int size = 2;
        dpIndicator.setSize(size);

        int ageValue = IntegerUtil.valueOf(uap.get(index),uap.get(index+1));
        Double age = DecimalUtil.multiply(ageValue, 0.25);


        trackUpdateAge.setAge(age);
        return trackUpdateAge;
      } else {
        int size = 1;
        dpIndicator.setSize(size);

        int ageValue = IntegerUtil.valueOf(uap.get(index));
        Double age = DecimalUtil.multiply(ageValue, 0.25);

        trackUpdateAge.setAge(age);
        return trackUpdateAge;
      }


    }
    return null;
  }

}
