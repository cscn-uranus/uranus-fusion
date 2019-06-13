package com.uranus.transition.common.asterix.cat062.mode5;

import com.uranus.transition.common.asterix.cat062.mode5.Mode5AndMode1Config;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.emitter.mode5.DataReplyStatusEnum;
import com.uranus.transition.common.asterix.uap.emitter.mode5.XpulsePresenceStatus;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
 class XpuLseReader {

  public static XpulsePresenceStatus read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(Mode5AndMode1Config.X_PULSE_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(Mode5AndMode1Config.X_PULSE_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(Mode5AndMode1Config.X_PULSE_DRN);

      XpulsePresenceStatus xpulsePresenceStatus = new XpulsePresenceStatus();

      String x5Bit = ByteUtil.toString(uap.get(index)).substring(3, 4);
      xpulsePresenceStatus.setMode5Xpulse(
          ByteUtil.ZERO_BIT.equals(x5Bit)
              ? DataReplyStatusEnum.NO_REPLY
              : DataReplyStatusEnum.REPLY);

      String xcBit = ByteUtil.toString(uap.get(index)).substring(4, 5);
      xpulsePresenceStatus.setMode5Xpulse(
          ByteUtil.ZERO_BIT.equals(xcBit)
              ? DataReplyStatusEnum.NO_REPLY
              : DataReplyStatusEnum.REPLY);

      String x3Bit = ByteUtil.toString(uap.get(index)).substring(5, 6);
      xpulsePresenceStatus.setMode5Xpulse(
          ByteUtil.ZERO_BIT.equals(x3Bit)
              ? DataReplyStatusEnum.NO_REPLY
              : DataReplyStatusEnum.REPLY);

      String x2Bit = ByteUtil.toString(uap.get(index)).substring(6, 7);
      xpulsePresenceStatus.setMode5Xpulse(
          ByteUtil.ZERO_BIT.equals(x2Bit)
              ? DataReplyStatusEnum.NO_REPLY
              : DataReplyStatusEnum.REPLY);

      String x1Bit = ByteUtil.toString(uap.get(index)).substring(7, 8);
      xpulsePresenceStatus.setMode5Xpulse(
          ByteUtil.ZERO_BIT.equals(x1Bit)
              ? DataReplyStatusEnum.NO_REPLY
              : DataReplyStatusEnum.REPLY);

      return xpulsePresenceStatus;
    }
    return null;
  }
}
