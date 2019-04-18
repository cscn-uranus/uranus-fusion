package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.spec.*;
import com.uranus.fusion.asterix.uap.accuracy.*;

import java.util.List;

/**
 * EstimatedAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class EstimatedAccuracyMapper {

  public static EstimatedAccuracy read(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 27;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateIndexByFrn(frn);

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.CAT062_ESTIMATED_ACCURACY);
      dataSpec.readValue(uap, index);

      EstimatedAccuracy estimatedAccuracy = new EstimatedAccuracy();

      CartesianPositionAccuracy cartesianPositionAccuracy =
          CartesianPositionAccuracyMapper.read(uap, dataSpec);
      estimatedAccuracy.setCartesianPositionAccuracy(cartesianPositionAccuracy);

      CartesianPositionCovariance cartesianPositionCovariance =
          CartesianPositionCovarianceMapper.read(uap, dataSpec);
      estimatedAccuracy.setCartesianPositionCovariance(cartesianPositionCovariance);

      Wgs84PositionAccuracy wgs84PositionAccuracy = Wgs84PositionAccuracyMapper.read(uap, dataSpec);
      estimatedAccuracy.setWgs84PositionAccuracy(wgs84PositionAccuracy);

      GeometricAltitudeAccuracy geometricAltitudeAccuracy =
          GeometricAltitudeAccuracyMapper.read(uap, dataSpec);
      estimatedAccuracy.setGeometricAltitudeAccuracy(geometricAltitudeAccuracy);

      BarometricAltitudeAccuracy barometricAltitudeAccuracy =
          BarometricAltitudeAccuracyMapper.read(uap, dataSpec);
      estimatedAccuracy.setBarometricAltitudeAccuracy(barometricAltitudeAccuracy);

      CartesianVelocityAccuracy cartesianVelocityAccuracy =
          CartesianVelocityAccuracyMapper.read(uap, dataSpec);
      estimatedAccuracy.setCartesianVelocityAccuracy(cartesianVelocityAccuracy);

      CartesianAccelerationAccuracy cartesianAccelerationAccuracy =
          CartesianAccelerationAccuracyMapper.read(uap, dataSpec);
      estimatedAccuracy.setCartesianAccelerationAccuracy(cartesianAccelerationAccuracy);

      VerticalRateAccuracy verticalRateAccuracy = VerticalRateAccuracyMapper.read(uap, dataSpec);
      estimatedAccuracy.setVerticalRateAccuracy(verticalRateAccuracy);

      int size = dataSpec.calculateTotalSize();
      fpIndicator.setSize(size);
      return estimatedAccuracy;
    }
    return null;
  }
}
