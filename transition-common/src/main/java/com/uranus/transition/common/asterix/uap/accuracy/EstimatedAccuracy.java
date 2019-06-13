package com.uranus.transition.common.asterix.uap.accuracy;

import com.uranus.transition.common.asterix.spec.DataSpec;
import lombok.Data;

/**
 * Estimated Accuracy
 *
 * <p>Data Item I062/500, Estimated Accuracies
 *
 * Definition : Overview of all important accuracies
 *
 *
 * Format : Compound Data Item, comprising a primary subfield of up to two octets, followed by the
 * indicated subfields.
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/14
 */
@Data
public class EstimatedAccuracy {
  /**
   * Structure of Primary Subfield:
   *
   * <p>bit 16 (APC) Subfield #1: Estimated Accuracy Of Track Position (Cartesian) = 0 Absence of
   * subfield #1 = 1 Presence of subfield #1
   *
   * bit 15 (COV) Subfield #2: XY Covariance = 0 Absence of
   * subfield #2 = 1 Presence of subfield #2
   *
   * bit 14 (APW) Subfield #3: Estimated Accuracy Of Track
   * Position (WGS-84) = 0 Absence of subfield #3 = 1 Presence of subfield #3
   *
   * bit 13 (AGA) Subfield
   * #4: Estimated Accuracy Of Calculated Track Geometric Altitude = 0 Absence of subfield #4 = 1
   * Presence of subfield #4
   *
   * bit 12 (ABA) Subfield #5: Estimated Accuracy Of Calculated Track
   * Barometric Altitude = 0 Absence of subfield #5 = 1 Presence of subfield #5
   *
   * bit 11 (ATV)
   * Subfield #6: Estimated Accuracy Of Track Velocity (Cartesian) = 0 Absence of subfield #6 = 1
   * Presence of subfield #6
   *
   * bit 10 (AA) Subfield #7: Estimated Accuracy Of Acceleration (Cartesian)
   * = 0 Absence of subfield #7 = 1 Presence of subfield #7
   *
   * bit 9 (FX) = 0 no extension = 1
   * extension
   *
   * <p>bits 8 (ARC) Subfield #8: Estimated Accuracy Of Rate Of Climb/Descent = 0 Absence of
   * subfield #8 = 1 Presence of subfield #8
   *
   * bits 7/2 Spare
   *
   * bits set to 0
   *
   * bit 1 (FX) = 0 no
   * extension = 1 extension
   */
  private DataSpec dataSpec;

  /** Structure of Subfield # 1: Estimated Accuracy Of Track Position (Cartesian) */
  private CartesianPositionAccuracy cartesianPositionAccuracy;

  /** Structure of Subfield # 2: XY covariance component */
  private CartesianPositionCovariance cartesianPositionCovariance;

  /** Structure of Subfield #3: Estimated Accuracy Of Track Position (WGS-84) */
  private Wgs84PositionAccuracy wgs84PositionAccuracy;

  /** Structure of Subfield #4: Estimated Accuracy Of Calculated Track Geometric Altitude */
  private GeometricAltitudeAccuracy geometricAltitudeAccuracy;

  /** Structure of Subfield #5: Estimated Accuracy Of Calculated Track Barometric Altitude */
  private BarometricAltitudeAccuracy barometricAltitudeAccuracy;

  /** Structure of Subfield #6: Estimated Accuracy Of Track Velocity (Cartesian) */
  private CartesianVelocityAccuracy cartesianVelocityAccuracy;

  /** Structure of Subfield #7: Estimated Accuracy Of Acceleration (Cartesian) */
  private CartesianAccelerationAccuracy cartesianAccelerationAccuracy;

  /** Structure of Subfield #8: Estimated Accuracy Of Rate Of Climb/Descent */
  private VerticalRateAccuracy verticalRateAccuracy;
}
