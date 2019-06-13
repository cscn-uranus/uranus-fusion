package com.uranus.transition.common.asterix.uap.measure.movement;

import com.uranus.transition.common.asterix.uap.measure.altitude.AltitudeDiscrepancyStatusEnum;
import lombok.Data;

/**
 * ModeOfMovement
 *
 * <p>Data Item I062/200, Mode of Movement
 *
 * <p>Definition : Calculated Mode of Movement of a target.
 *
 * <p>Format : One-Octet fixed length data item.
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
@Data
public class ModeOfMovement {

  /**
   * bits 8/7 (TRANS)
   *
   * <p>Transversal Acceleration = 00 Constant Course = 01 Right Turn = 10 Left Turn = 11
   * Undetermined
   */
  private TransversalMoveEnum transversalMoveEnum;

  /**
   * bits 6/5 (LONG)
   *
   * <p>Longitudinal Acceleration = 00 Constant Groundspeed = 01 Increasing Groundspeed = 10
   * Decreasing Groundspeed = 11 Undetermined
   */
  private LongitudinalMoveEnum longitudinalMoveEnum;

  /**
   * bits 4/3 (VERT)
   *
   * <p>Vertical Rate = 00 Level = 01 Climb = 10 Descent = 11 Undetermined
   */
  private VerticalMoveEnum verticalMoveEnum;

  /**
   * bit 2 (ADF)
   *
   * <p>Altitude Discrepancy Flag = 0 No altitude discrepancy = 1 Altitude discrepancy
   */
  private AltitudeDiscrepancyStatusEnum altitudeDiscrepancyStatusEnum;
}
