package com.uranus.fusion.common.asterix.aircraft.identity;

import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.ByteUtil;

import java.util.List;

/**
 * TargetAddressMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/30
 */
public class TargetAddressMapper {

  public static TargetAddress read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 1;
    final int size = 3;

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

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
