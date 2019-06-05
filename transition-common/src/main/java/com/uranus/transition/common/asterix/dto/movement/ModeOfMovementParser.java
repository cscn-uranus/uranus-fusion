package com.uranus.transition.common.asterix.dto.movement;

import com.uranus.transition.common.asterix.AsterixDataBlock;

/**
 * @author tellxp@github.com
 * @date 2019/5/20 21:39
 */

public class ModeOfMovementParser {
  public static ModeOfMovementDTO parse(AsterixDataBlock asterixDataBlock) {
    ModeOfMovementDTO modeOfMovementDTO = new ModeOfMovementDTO();

    if (null != asterixDataBlock.getModeOfMovement()) {
      modeOfMovementDTO.setTransversalMoveStatus(
        asterixDataBlock.getModeOfMovement().getTransversalMoveEnum().toString());
      modeOfMovementDTO.setLongitudinalMoveStatus(
        asterixDataBlock.getModeOfMovement().getLongitudinalMoveEnum().toString());
      modeOfMovementDTO.setVerticalMoveStatus(
        asterixDataBlock.getModeOfMovement().getVerticalMoveEnum().toString());
      modeOfMovementDTO.setAltitudeDiscrepancyStatus(
        asterixDataBlock.getModeOfMovement().getAltitudeDiscrepancyStatusEnum().toString());
    }
    return modeOfMovementDTO;
  }
}
