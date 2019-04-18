package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.emitter.mode5.DataReplyStatusEnum;
import com.uranus.fusion.asterix.uap.emitter.mode5.XpulsePresenceStatus;
import com.uranus.fusion.util.ByteUtil;

import java.util.List;

/**
 * XpuLsePresenceStatusMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
public class XpuLsePresenceStatusMapper {

  public static XpulsePresenceStatus read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 7;
    final int size = 1;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      XpulsePresenceStatus xpulsePresenceStatus = new XpulsePresenceStatus();

      String x5Bit = ByteUtil.toString(uap.get(index)).substring(3, 4);
      xpulsePresenceStatus.setMode5Xpulse(
          zeroBit.equals(x5Bit) ? DataReplyStatusEnum.NO_REPLY : DataReplyStatusEnum.REPLY);

      String xcBit = ByteUtil.toString(uap.get(index)).substring(4, 5);
      xpulsePresenceStatus.setMode5Xpulse(
          zeroBit.equals(xcBit) ? DataReplyStatusEnum.NO_REPLY : DataReplyStatusEnum.REPLY);

      String x3Bit = ByteUtil.toString(uap.get(index)).substring(5, 6);
      xpulsePresenceStatus.setMode5Xpulse(
          zeroBit.equals(x3Bit) ? DataReplyStatusEnum.NO_REPLY : DataReplyStatusEnum.REPLY);

      String x2Bit = ByteUtil.toString(uap.get(index)).substring(6, 7);
      xpulsePresenceStatus.setMode5Xpulse(
          zeroBit.equals(x2Bit) ? DataReplyStatusEnum.NO_REPLY : DataReplyStatusEnum.REPLY);

      String x1Bit = ByteUtil.toString(uap.get(index)).substring(7, 8);
      xpulsePresenceStatus.setMode5Xpulse(
          zeroBit.equals(x1Bit) ? DataReplyStatusEnum.NO_REPLY : DataReplyStatusEnum.REPLY);

      return xpulsePresenceStatus;
    }
    return null;
  }
}
