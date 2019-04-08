package com.uranus.fusion.common.asterix.track.movement;

import com.uranus.fusion.common.asterix.message.spec.FieldSpec;
import com.uranus.fusion.common.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.FpIndicator;
import com.uranus.fusion.common.asterix.util.ByteUtil;
import java.util.List;

/**
 * ModeOfMovementMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/9
 */
public class ModeOfMovementMapper {

  public static ModeOfMovement readModeOfMovement(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 15;
    final int length = 1;
    final String zeroBit = "0";

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(length);

      int index = fieldSpec.calculateOctetIndexByFrn(frn);

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
          modeOfMovement.setTransversalMoveEnum(TransversalMoveEnum.UNDETERMINED);
          break;
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
          modeOfMovement.setLongitudinalMoveEnum(LongitudinalMoveEnum.UNDETERMINED);
          break;
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
          modeOfMovement.setVerticalMoveEnum(VerticalMoveEnum.UNDETERMINED);
          break;
        default:
          modeOfMovement.setVerticalMoveEnum(VerticalMoveEnum.UNDETERMINED);
          break;
      }

      String adfBit = ByteUtil.toString(uap.get(index)).substring(6, 7);
      modeOfMovement.setAltitudeDiscrepancyStatusEnum(
          zeroBit.equals(adfBit)
              ? AltitudeDiscrepancyStatusEnum.NO_DISCREPANCY
              : AltitudeDiscrepancyStatusEnum.DISCREPANCY);

      return modeOfMovement;
    }
    return null;
  }
}
