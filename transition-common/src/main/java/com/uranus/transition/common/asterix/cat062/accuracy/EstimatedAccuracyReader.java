package com.uranus.transition.common.asterix.cat062.accuracy;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.spec.*;
import com.uranus.transition.common.asterix.uap.accuracy.*;

import java.util.List;

/**
 * EstimatedAccuracyReader
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class EstimatedAccuracyReader {

  public static EstimatedAccuracy read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(Cat062Config.ESTIMATED_ACCURACIES_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateIndexByFrn(Cat062Config.ESTIMATED_ACCURACIES_FRN);

      DataSpecParameter dataSpecParameter = new EstimatedAccuracyDataSpecParameter();
      DataSpec dataSpec = new DataSpec(index,dataSpecParameter);
      dataSpec.readValue(message);

      EstimatedAccuracy estimatedAccuracy = new EstimatedAccuracy();

      CartesianPositionAccuracy cartesianPositionAccuracy =
          CartesianPositionAccuracyReader.read(message, dataSpec);
      estimatedAccuracy.setCartesianPositionAccuracy(cartesianPositionAccuracy);

      CartesianPositionCovariance cartesianPositionCovariance =
          CartesianPositionCovarianceReader.read(message, dataSpec);
      estimatedAccuracy.setCartesianPositionCovariance(cartesianPositionCovariance);

      Wgs84PositionAccuracy wgs84PositionAccuracy =
          Wgs84PositionAccuracyReader.read(message, dataSpec);
      estimatedAccuracy.setWgs84PositionAccuracy(wgs84PositionAccuracy);

      GeometricAltitudeAccuracy geometricAltitudeAccuracy =
          GeometricAltitudeAccuracyReader.read(message, dataSpec);
      estimatedAccuracy.setGeometricAltitudeAccuracy(geometricAltitudeAccuracy);

      BarometricAltitudeAccuracy barometricAltitudeAccuracy =
          BarometricAltitudeAccuracyReader.read(message, dataSpec);
      estimatedAccuracy.setBarometricAltitudeAccuracy(barometricAltitudeAccuracy);

      CartesianVelocityAccuracy cartesianVelocityAccuracy =
          CartesianVelocityAccuracyReader.read(message, dataSpec);
      estimatedAccuracy.setCartesianVelocityAccuracy(cartesianVelocityAccuracy);

      CartesianAccelerationAccuracy cartesianAccelerationAccuracy =
          CartesianAccelerationAccuracyReader.read(message, dataSpec);
      estimatedAccuracy.setCartesianAccelerationAccuracy(cartesianAccelerationAccuracy);

      VerticalRateAccuracy verticalRateAccuracy =
          VerticalRateAccuracyReader.read(message, dataSpec);
      estimatedAccuracy.setVerticalRateAccuracy(verticalRateAccuracy);

      int size = dataSpec.calculateTotalSize();
      fpIndicator.setSize(size);
      return estimatedAccuracy;
    }
    return null;
  }
}
