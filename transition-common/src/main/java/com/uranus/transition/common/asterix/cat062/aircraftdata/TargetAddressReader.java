package com.uranus.transition.common.asterix.cat062.aircraftdata;

import com.uranus.transition.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.identification.TargetAddress;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

/**
 * TargetAddressReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/30
 */
class TargetAddressReader {

  public static TargetAddress read(List<Byte> uap, DataSpec dataSpec) {
    DpIndicator dpIndicator = dataSpec.getDpIndicator(AircraftDerivedDataConfig.TARGET_ADDRESS_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.TARGET_ADDRESS_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.TARGET_ADDRESS_DRN);

      TargetAddress targetAddress = new TargetAddress();

      targetAddress.setAddress(
          ByteUtil.toString(uap.get(index))
              + ByteUtil.toString(uap.get(index + 1))
              + ByteUtil.toString(uap.get(index + 2)));

      return targetAddress;
    }
    return null;
  }
}
