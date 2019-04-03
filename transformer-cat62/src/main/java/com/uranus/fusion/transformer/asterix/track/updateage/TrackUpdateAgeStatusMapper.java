package com.uranus.fusion.transformer.asterix.track.updateage;

import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DataSpecTypeEnum;
import com.uranus.fusion.transformer.asterix.message.spec.FieldSpec;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicator;

import java.util.List;

/**
 * TrackUpdateAgeStatusMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/8
 */
public class TrackUpdateAgeStatusMapper {

  public static TrackUpdateAgeStatus readTrackUpdateAge(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 14;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.SYSTEM_TRACK_UPDATE_AGES);
      dataSpec.readValue(uap, index);

      TrackUpdateAgeStatus trackUpdateAgeStatus = new TrackUpdateAgeStatus();

      TrackUpdateAge trackAge = TrackUpdateAgeMapper.readByDrn(uap, dataSpec,1);
      TrackUpdateAge psrAge = TrackUpdateAgeMapper.readByDrn(uap, dataSpec,2);
      TrackUpdateAge ssrAge = TrackUpdateAgeMapper.readByDrn(uap, dataSpec,3);
      TrackUpdateAge modeSelAge = TrackUpdateAgeMapper.readByDrn(uap, dataSpec,4);
      TrackUpdateAge adsContractAge = TrackUpdateAgeMapper.readByDrn(uap, dataSpec,5);
      TrackUpdateAge esAge = TrackUpdateAgeMapper.readByDrn(uap, dataSpec,6);
      TrackUpdateAge vdlAge = TrackUpdateAgeMapper.readByDrn(uap, dataSpec,7);
      TrackUpdateAge uatAge = TrackUpdateAgeMapper.readByDrn(uap, dataSpec,8);
      TrackUpdateAge loopAge = TrackUpdateAgeMapper.readByDrn(uap, dataSpec,9);
      TrackUpdateAge multilaterationAge = TrackUpdateAgeMapper.readByDrn(uap, dataSpec,10);

      trackUpdateAgeStatus.setTrackAge(trackAge);
      trackUpdateAgeStatus.setPsrAge(psrAge);
      trackUpdateAgeStatus.setSsrAge(ssrAge);
      trackUpdateAgeStatus.setModeSelAge(modeSelAge);
      trackUpdateAgeStatus.setAdsContractAge(adsContractAge);
      trackUpdateAgeStatus.setEsAge(esAge);
      trackUpdateAgeStatus.setVdlAge(vdlAge);
      trackUpdateAgeStatus.setUatAge(uatAge);
      trackUpdateAgeStatus.setLoopAge(loopAge);
      trackUpdateAgeStatus.setMultilaterationAge(multilaterationAge);

      fpIndicator.setSize(dataSpec.calculateTotalSize());
      return trackUpdateAgeStatus;
    }
    return null;
  }

}
