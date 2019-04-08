package com.uranus.fusion.common.asterix.track.movement;

/**
 * ModeOfMovement
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/9
 */
public class ModeOfMovement {

  private TransversalMoveEnum transversalMoveEnum;
  private LongitudinalMoveEnum longitudinalMoveEnum;
  private VerticalMoveEnum verticalMoveEnum;
  private AltitudeDiscrepancyStatusEnum altitudeDiscrepancyStatusEnum;

  public TransversalMoveEnum getTransversalMoveEnum() {
    return transversalMoveEnum;
  }

  public void setTransversalMoveEnum(
      TransversalMoveEnum transversalMoveEnum) {
    this.transversalMoveEnum = transversalMoveEnum;
  }

  public LongitudinalMoveEnum getLongitudinalMoveEnum() {
    return longitudinalMoveEnum;
  }

  public void setLongitudinalMoveEnum(
      LongitudinalMoveEnum longitudinalMoveEnum) {
    this.longitudinalMoveEnum = longitudinalMoveEnum;
  }

  public VerticalMoveEnum getVerticalMoveEnum() {
    return verticalMoveEnum;
  }

  public void setVerticalMoveEnum(
      VerticalMoveEnum verticalMoveEnum) {
    this.verticalMoveEnum = verticalMoveEnum;
  }

  public AltitudeDiscrepancyStatusEnum getAltitudeDiscrepancyStatusEnum() {
    return altitudeDiscrepancyStatusEnum;
  }

  public void setAltitudeDiscrepancyStatusEnum(
      AltitudeDiscrepancyStatusEnum altitudeDiscrepancyStatusEnum) {
    this.altitudeDiscrepancyStatusEnum = altitudeDiscrepancyStatusEnum;
  }
}
