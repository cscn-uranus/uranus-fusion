package com.uranus.fusion.common.asterix.uap.measure.movement;

import com.uranus.fusion.common.asterix.uap.measure.altitude.AltitudeDiscrepancyStatusEnum;
import lombok.Data;

/**
 * ModeOfMovement
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
@Data
public class ModeOfMovement {

  private TransversalMoveEnum transversalMoveEnum;
  private LongitudinalMoveEnum longitudinalMoveEnum;
  private VerticalMoveEnum verticalMoveEnum;
  private AltitudeDiscrepancyStatusEnum altitudeDiscrepancyStatusEnum;
}
