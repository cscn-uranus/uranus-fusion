package com.uranus.fusion.common.asterix.aircraft.transponder.mode5;

import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.ByteUtil;

import java.util.List;

/**
 * Mode5SummaryMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
 */
public class Mode5SummaryMapper {

  public static Mode5Summary read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 1;
    final int size = 1;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(size);

      Mode5Summary mode5Summary = new Mode5Summary();
      int index = dataSpec.calculateOctetIndexByDrn(drn);

      String m5Bit = ByteUtil.toString(uap.get(index)).substring(0, 1);
      mode5Summary.setMode5InterrogationStatusEnum(
          zeroBit.equals(m5Bit)
              ? InterrogationStatusEnum.NO_INTERROGATION
              : InterrogationStatusEnum.INTERROGATION);

      String idBit = ByteUtil.toString(uap.get(index)).substring(1, 2);
      mode5Summary.setIdDataReplyStatusEnum(
          zeroBit.equals(idBit) ? DataReplyStatusEnum.NO_REPLY : DataReplyStatusEnum.REPLY);

      String daBit = ByteUtil.toString(uap.get(index)).substring(2, 3);
      mode5Summary.setMode5DataReplyStatusEnum(
          zeroBit.equals(daBit) ? DataReplyStatusEnum.NO_REPLY : DataReplyStatusEnum.REPLY);

      String m1Bit = ByteUtil.toString(uap.get(index)).substring(3, 4);
      mode5Summary.setMode1DataReplyStatusEnum(
          zeroBit.equals(m1Bit) ? DataReplyStatusEnum.NO_REPLY : DataReplyStatusEnum.REPLY);

      String m2Bit = ByteUtil.toString(uap.get(index)).substring(4, 5);
      mode5Summary.setMode2DataReplyStatusEnum(
          zeroBit.equals(m2Bit) ? DataReplyStatusEnum.NO_REPLY : DataReplyStatusEnum.REPLY);

      String m3Bit = ByteUtil.toString(uap.get(index)).substring(5, 6);
      mode5Summary.setMode3DataReplyStatusEnum(
          zeroBit.equals(m3Bit) ? DataReplyStatusEnum.NO_REPLY : DataReplyStatusEnum.REPLY);

      String mcBit = ByteUtil.toString(uap.get(index)).substring(6, 7);
      mode5Summary.setModeCDataReplyStatusEnum(
          zeroBit.equals(mcBit) ? DataReplyStatusEnum.NO_REPLY : DataReplyStatusEnum.REPLY);

      return mode5Summary;
    }
    return null;
  }
}
