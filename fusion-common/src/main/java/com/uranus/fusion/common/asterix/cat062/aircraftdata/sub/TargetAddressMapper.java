package com.uranus.fusion.common.asterix.cat062.aircraftdata.sub;

import com.uranus.fusion.common.asterix.cat062.aircraftdata.AircraftDerivedDataConfig;
import com.uranus.fusion.common.asterix.spec.DataSpec;
import com.uranus.fusion.common.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.DpIndicator;
import com.uranus.fusion.common.asterix.uap.identification.TargetAddress;
import com.uranus.fusion.common.util.ByteUtil;

import java.util.List;

/**
 * TargetAddressMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/30
 */
public class TargetAddressMapper {

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
