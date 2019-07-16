package com.uranus.transition.common.dto.movement;

import com.uranus.transition.common.asterix.uap.eucat062.EuCat062DataBlock;

/**
 * @author tellxp@github.com
 * @date 2019/5/20 21:39
 */

public class ModeOfMovementParser {
  public static ModeOfMovementDTO parse(EuCat062DataBlock euCat062DataBlock) {
    ModeOfMovementDTO modeOfMovementDTO = new ModeOfMovementDTO();

    if (null != euCat062DataBlock.getModeOfMovement()) {
      modeOfMovementDTO.setTransversalMoveStatus(
        euCat062DataBlock.getModeOfMovement().getTransversalMoveEnum().toString());
      modeOfMovementDTO.setLongitudinalMoveStatus(
        euCat062DataBlock.getModeOfMovement().getLongitudinalMoveEnum().toString());
      modeOfMovementDTO.setVerticalMoveStatus(
        euCat062DataBlock.getModeOfMovement().getVerticalMoveEnum().toString());
      modeOfMovementDTO.setAltitudeDiscrepancyStatus(
        euCat062DataBlock.getModeOfMovement().getAltitudeDiscrepancyStatusEnum().toString());
    }
    return modeOfMovementDTO;
  }
}
