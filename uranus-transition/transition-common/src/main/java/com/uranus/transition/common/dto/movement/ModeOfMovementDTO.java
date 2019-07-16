package com.uranus.transition.common.dto.movement;

import lombok.Data;

/**
 * ModeOfMovementDTO
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
@Data
public class ModeOfMovementDTO {

  private String transversalMoveStatus;
  private String longitudinalMoveStatus;
  private String verticalMoveStatus;
  private String altitudeDiscrepancyStatus;
}
