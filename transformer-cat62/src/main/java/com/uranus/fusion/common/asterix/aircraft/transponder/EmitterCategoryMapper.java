package com.uranus.fusion.common.asterix.aircraft.transponder;

import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.IntegerUtil;

import java.util.List;

/**
 * EmitterCategoryMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class EmitterCategoryMapper {

  public static EmitterCategoryEnum readEmitterCategory(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 21;
    final int size = 1;

    DpIndicator fpIndicator = dataSpec.getDpIndicator(drn);
    if (fpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(size);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      int emitterCategoryValue = IntegerUtil.valueOf(uap.get(index));
      EmitterCategoryEnum emitterCategory;
      switch (emitterCategoryValue) {
        case 1:
          emitterCategory = EmitterCategoryEnum.LIGHT;
          break;
        case 3:
          emitterCategory = EmitterCategoryEnum.MEDIUM;
          break;
        case 5:
          emitterCategory = EmitterCategoryEnum.HEAVY;
          break;
        case 6:
          emitterCategory = EmitterCategoryEnum.HIGH_MANO;
          break;
        case 10:
          emitterCategory = EmitterCategoryEnum.ROTO;
          break;
        case 11:
          emitterCategory = EmitterCategoryEnum.GLIDER;
          break;
        case 12:
          emitterCategory = EmitterCategoryEnum.LTA;
          break;
        case 13:
          emitterCategory = EmitterCategoryEnum.UAV;
          break;
        case 14:
          emitterCategory = EmitterCategoryEnum.SPACE;
          break;
        case 15:
          emitterCategory = EmitterCategoryEnum.ULTRALIGHT;
          break;
        case 16:
          emitterCategory = EmitterCategoryEnum.PARACHUTIST;
          break;
        case 20:
          emitterCategory = EmitterCategoryEnum.SURF_EMG_VEH;
          break;
        case 21:
          emitterCategory = EmitterCategoryEnum.SURF_SVC_VEH;
          break;
        case 22:
          emitterCategory = EmitterCategoryEnum.FIXED_OBS;
          break;
        default:
          emitterCategory = EmitterCategoryEnum.UNKNOWN;
          break;
      }
      return emitterCategory;
    }
    return null;
  }
}
