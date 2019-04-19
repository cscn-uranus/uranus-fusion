package com.uranus.fusion.asterix.cat062.accuracy;

import com.uranus.fusion.asterix.cat062.accuracy.sub.*;
import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.*;
import com.uranus.fusion.asterix.uap.accuracy.*;

import java.util.List;

/**
 * EstimatedAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class EstimatedAccuracyMapper {

  public static EstimatedAccuracy read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(Cat062Config.ESTIMATED_ACCURACIES_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateIndexByFrn(Cat062Config.ESTIMATED_ACCURACIES_FRN);

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.CAT062_ESTIMATED_ACCURACY);
      dataSpec.readValue(message, index);

      EstimatedAccuracy estimatedAccuracy = new EstimatedAccuracy();

      CartesianPositionAccuracy cartesianPositionAccuracy =
          CartesianPositionAccuracyMapper.read(message, dataSpec);
      estimatedAccuracy.setCartesianPositionAccuracy(cartesianPositionAccuracy);

      CartesianPositionCovariance cartesianPositionCovariance =
          CartesianPositionCovarianceMapper.read(message, dataSpec);
      estimatedAccuracy.setCartesianPositionCovariance(cartesianPositionCovariance);

      Wgs84PositionAccuracy wgs84PositionAccuracy = Wgs84PositionAccuracyMapper.read(message, dataSpec);
      estimatedAccuracy.setWgs84PositionAccuracy(wgs84PositionAccuracy);

      GeometricAltitudeAccuracy geometricAltitudeAccuracy =
          GeometricAltitudeAccuracyMapper.read(message, dataSpec);
      estimatedAccuracy.setGeometricAltitudeAccuracy(geometricAltitudeAccuracy);

      BarometricAltitudeAccuracy barometricAltitudeAccuracy =
          BarometricAltitudeAccuracyMapper.read(message, dataSpec);
      estimatedAccuracy.setBarometricAltitudeAccuracy(barometricAltitudeAccuracy);

      CartesianVelocityAccuracy cartesianVelocityAccuracy =
          CartesianVelocityAccuracyMapper.read(message, dataSpec);
      estimatedAccuracy.setCartesianVelocityAccuracy(cartesianVelocityAccuracy);

      CartesianAccelerationAccuracy cartesianAccelerationAccuracy =
          CartesianAccelerationAccuracyMapper.read(message, dataSpec);
      estimatedAccuracy.setCartesianAccelerationAccuracy(cartesianAccelerationAccuracy);

      VerticalRateAccuracy verticalRateAccuracy = VerticalRateAccuracyMapper.read(message, dataSpec);
      estimatedAccuracy.setVerticalRateAccuracy(verticalRateAccuracy);

      int size = dataSpec.calculateTotalSize();
      fpIndicator.setSize(size);
      return estimatedAccuracy;
    }
    return null;
  }
}
