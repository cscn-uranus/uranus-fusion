package com.uranus.transition.common.asterix.cat062.sub;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.measure.altitude.AltitudeDiscrepancyStatusEnum;
import com.uranus.transition.common.asterix.uap.measure.movement.LongitudinalMoveEnum;
import com.uranus.transition.common.asterix.uap.measure.movement.ModeOfMovement;
import com.uranus.transition.common.asterix.uap.measure.movement.TransversalMoveEnum;
import com.uranus.transition.common.asterix.uap.measure.movement.VerticalMoveEnum;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

/**
 * ModeOfMovementMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
public class ModeOfMovementMapper {

  public static ModeOfMovement readModeOfMovement(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(Cat062Config.MODE_OF_MOVEMENT_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(Cat062Config.MODE_OF_MOVEMENT_SIZE);

      int index = fieldSpec.calculateIndexByFrn(Cat062Config.MODE_OF_MOVEMENT_FRN);

      ModeOfMovement modeOfMovement = new ModeOfMovement();

      String transBits = ByteUtil.toString(uap.get(index)).substring(0, 2);
      switch (transBits) {
        case "00":
          modeOfMovement.setTransversalMoveEnum(TransversalMoveEnum.CONSTANT);
          break;
        case "01":
          modeOfMovement.setTransversalMoveEnum(TransversalMoveEnum.RIGHT);
          break;
        case "10":
          modeOfMovement.setTransversalMoveEnum(TransversalMoveEnum.LEFT);
          break;
        case "11":
        default:
          modeOfMovement.setTransversalMoveEnum(TransversalMoveEnum.UNDETERMINED);
          break;
      }

      String longBits = ByteUtil.toString(uap.get(index)).substring(2, 4);
      switch (longBits) {
        case "00":
          modeOfMovement.setLongitudinalMoveEnum(LongitudinalMoveEnum.CONSTANT);
          break;
        case "01":
          modeOfMovement.setLongitudinalMoveEnum(LongitudinalMoveEnum.INCREASING);
          break;
        case "10":
          modeOfMovement.setLongitudinalMoveEnum(LongitudinalMoveEnum.DECREASING);
          break;
        case "11":
        default:
          modeOfMovement.setLongitudinalMoveEnum(LongitudinalMoveEnum.UNDETERMINED);
          break;
      }

      String vertBits = ByteUtil.toString(uap.get(index)).substring(4, 6);
      switch (vertBits) {
        case "00":
          modeOfMovement.setVerticalMoveEnum(VerticalMoveEnum.LEVEL);
          break;
        case "01":
          modeOfMovement.setVerticalMoveEnum(VerticalMoveEnum.CLIMB);
          break;
        case "10":
          modeOfMovement.setVerticalMoveEnum(VerticalMoveEnum.DESCENT);
          break;
        case "11":
        default:
          modeOfMovement.setVerticalMoveEnum(VerticalMoveEnum.UNDETERMINED);
          break;
      }

      String adfBit = ByteUtil.toString(uap.get(index)).substring(6, 7);
      modeOfMovement.setAltitudeDiscrepancyStatusEnum(
          ByteUtil.ZERO_BIT.equals(adfBit)
              ? AltitudeDiscrepancyStatusEnum.NO_DISCREPANCY
              : AltitudeDiscrepancyStatusEnum.DISCREPANCY);

      return modeOfMovement;
    }
    return null;
  }
}
