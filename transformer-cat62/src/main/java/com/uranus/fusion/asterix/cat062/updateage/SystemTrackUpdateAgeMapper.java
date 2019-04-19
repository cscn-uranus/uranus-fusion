package com.uranus.fusion.asterix.cat062.updateage;

import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.cat062.updateage.sub.*;
import com.uranus.fusion.asterix.spec.*;
import com.uranus.fusion.asterix.uap.track.UpdateAge;
import com.uranus.fusion.asterix.uap.track.status.SystemTrackUpdateAge;

import java.util.List;

/**
 * SystemTrackUpdateAgeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
public class SystemTrackUpdateAgeMapper {

  public static SystemTrackUpdateAge read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(Cat062Config.SYSTEM_TRACK_UPDATE_AGES_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateIndexByFrn(Cat062Config.SYSTEM_TRACK_UPDATE_AGES_FRN);

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.CAT062_SYSTEM_TRACK_UPDATE_AGES);
      dataSpec.readValue(uap, index);

      SystemTrackUpdateAge systemTrackUpdateAge = new SystemTrackUpdateAge();

      UpdateAge trackUpdateAge = TrackUpdateAgeMapper.read(uap, dataSpec);
      UpdateAge psrAge = PsrUpdateAgeMapper.read(uap, dataSpec);
      UpdateAge ssrAge = SsrUpdateAgeMapper.read(uap, dataSpec);
      UpdateAge modeSelAge = ModeSelUpdateAgeMapper.read(uap, dataSpec);
      UpdateAge adscAge = AdscUpdateAgeMapper.read(uap, dataSpec);
      UpdateAge esAge = EsUpdateAgeMapper.read(uap, dataSpec);
      UpdateAge vdlAge = VdlUpdateAgeMapper.read(uap, dataSpec);
      UpdateAge uatAge = UatUpdateAgeMapper.read(uap, dataSpec);
      UpdateAge loopAge = LoopUpdateAgeMapper.read(uap, dataSpec);
      UpdateAge multilaterationAge = MultilaterationUpdateAgeMapper.read(uap, dataSpec);

      systemTrackUpdateAge.setUpdateAge(trackUpdateAge);
      systemTrackUpdateAge.setPsrAge(psrAge);
      systemTrackUpdateAge.setSsrAge(ssrAge);
      systemTrackUpdateAge.setModeSelAge(modeSelAge);
      systemTrackUpdateAge.setAdsContractAge(adscAge);
      systemTrackUpdateAge.setEsAge(esAge);
      systemTrackUpdateAge.setVdlAge(vdlAge);
      systemTrackUpdateAge.setUatAge(uatAge);
      systemTrackUpdateAge.setLoopAge(loopAge);
      systemTrackUpdateAge.setMultilaterationAge(multilaterationAge);

      fpIndicator.setSize(dataSpec.calculateTotalSize());
      return systemTrackUpdateAge;
    }
    return null;
  }
}
