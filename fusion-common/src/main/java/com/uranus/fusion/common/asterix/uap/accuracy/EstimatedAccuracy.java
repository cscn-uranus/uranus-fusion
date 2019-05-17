package com.uranus.fusion.common.asterix.uap.accuracy;

import lombok.Data;

/**
 * EstimatedAccuracy
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/14
 */
@Data
public class EstimatedAccuracy {
  private CartesianPositionAccuracy cartesianPositionAccuracy;
  private CartesianPositionCovariance cartesianPositionCovariance;
  private Wgs84PositionAccuracy wgs84PositionAccuracy;
  private GeometricAltitudeAccuracy geometricAltitudeAccuracy;
  private BarometricAltitudeAccuracy barometricAltitudeAccuracy;
  private CartesianVelocityAccuracy cartesianVelocityAccuracy;
  private CartesianAccelerationAccuracy cartesianAccelerationAccuracy;
  private VerticalRateAccuracy verticalRateAccuracy;
}
