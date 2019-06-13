package com.uranus.transition.common.asterix.cat062.mode5;

import com.uranus.transition.common.asterix.cat062.mode5.Mode5AndMode1Config;
import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.emitter.mode5.DataReplyStatusEnum;
import com.uranus.transition.common.asterix.uap.emitter.mode5.InterrogationStatusEnum;
import com.uranus.transition.common.asterix.uap.emitter.mode5.Mode5Summary;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
 class Mode5SummaryReader {

  public static Mode5Summary read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(Mode5AndMode1Config.MODE5_SUMMARY_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(Mode5AndMode1Config.MODE5_SUMMARY_SIZE);

      Mode5Summary mode5Summary = new Mode5Summary();
      int index = dataSpec.calculateOctetIndexByDrn(Mode5AndMode1Config.MODE5_SUMMARY_DRN);

      String m5Bit = ByteUtil.toString(uap.get(index)).substring(0, 1);
      mode5Summary.setMode5InterrogationStatusEnum(
          ByteUtil.ZERO_BIT.equals(m5Bit)
              ? InterrogationStatusEnum.NO_INTERROGATION
              : InterrogationStatusEnum.INTERROGATION);

      String idBit = ByteUtil.toString(uap.get(index)).substring(1, 2);
      mode5Summary.setIdDataReplyStatusEnum(
          ByteUtil.ZERO_BIT.equals(idBit)
              ? DataReplyStatusEnum.NO_REPLY
              : DataReplyStatusEnum.REPLY);

      String daBit = ByteUtil.toString(uap.get(index)).substring(2, 3);
      mode5Summary.setMode5DataReplyStatusEnum(
          ByteUtil.ZERO_BIT.equals(daBit)
              ? DataReplyStatusEnum.NO_REPLY
              : DataReplyStatusEnum.REPLY);

      String m1Bit = ByteUtil.toString(uap.get(index)).substring(3, 4);
      mode5Summary.setMode1DataReplyStatusEnum(
          ByteUtil.ZERO_BIT.equals(m1Bit)
              ? DataReplyStatusEnum.NO_REPLY
              : DataReplyStatusEnum.REPLY);

      String m2Bit = ByteUtil.toString(uap.get(index)).substring(4, 5);
      mode5Summary.setMode2DataReplyStatusEnum(
          ByteUtil.ZERO_BIT.equals(m2Bit)
              ? DataReplyStatusEnum.NO_REPLY
              : DataReplyStatusEnum.REPLY);

      String m3Bit = ByteUtil.toString(uap.get(index)).substring(5, 6);
      mode5Summary.setMode3DataReplyStatusEnum(
          ByteUtil.ZERO_BIT.equals(m3Bit)
              ? DataReplyStatusEnum.NO_REPLY
              : DataReplyStatusEnum.REPLY);

      String mcBit = ByteUtil.toString(uap.get(index)).substring(6, 7);
      mode5Summary.setModeCDataReplyStatusEnum(
          ByteUtil.ZERO_BIT.equals(mcBit)
              ? DataReplyStatusEnum.NO_REPLY
              : DataReplyStatusEnum.REPLY);

      return mode5Summary;
    }
    return null;
  }
}
