package com.uranus.transition.reader.eucat062.updateage;

import com.uranus.transition.reader.eucat062.EuCat062Config;
import com.uranus.transition.common.asterix.spec.*;
import com.uranus.transition.common.asterix.uap.shared.track.UpdateAge;
import com.uranus.transition.common.asterix.uap.shared.track.status.SystemTrackUpdateAge;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
public class SystemTrackUpdateAgeReader {

  public static SystemTrackUpdateAge read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(EuCat062Config.SYSTEM_TRACK_UPDATE_AGES_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateIndexByFrn(EuCat062Config.SYSTEM_TRACK_UPDATE_AGES_FRN);

      DataSpecParameter dataSpecParameter = new SystemTrackUpdateAgeDataSpecParameter();
      DataSpec dataSpec = new DataSpec(index,dataSpecParameter);
      dataSpec.readValue(message);

      SystemTrackUpdateAge systemTrackUpdateAge = new SystemTrackUpdateAge();

      UpdateAge trackUpdateAge = TrackUpdateAgeReader.read(message, dataSpec);
      UpdateAge psrAge = PsrUpdateAgeReader.read(message, dataSpec);
      UpdateAge ssrAge = SsrUpdateAgeReader.read(message, dataSpec);
      UpdateAge modeSelAge = ModeselUpdateAgeReader.read(message, dataSpec);
      UpdateAge adscAge = AdscUpdateAgeReader.read(message, dataSpec);
      UpdateAge esAge = EsUpdateAgeReader.read(message, dataSpec);
      UpdateAge vdlAge = VdlUpdateAgeReader.read(message, dataSpec);
      UpdateAge uatAge = UatUpdateAgeReader.read(message, dataSpec);
      UpdateAge loopAge = LoopUpdateAgeReader.read(message, dataSpec);
      UpdateAge multilaterationAge = MultilaterationUpdateAgeReader.read(message, dataSpec);

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
