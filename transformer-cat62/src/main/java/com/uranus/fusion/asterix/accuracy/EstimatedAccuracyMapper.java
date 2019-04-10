package com.uranus.fusion.asterix.accuracy;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DataSpecTypeEnum;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import java.util.List;

/**
 * EstimatedAccuracyMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class EstimatedAccuracyMapper {

  public static EstimatedAccuracy read(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 27;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.ESTIMATED_ACCURACY);
      dataSpec.readValue(uap, index);

      EstimatedAccuracy estimatedAccuracy = new EstimatedAccuracy();

      CartesianPositionAccuracy cartesianPositionAccuracy =
          CartesianPositionAccuracyMapper.read(uap, dataSpec);

      CartesianPositionCovariance cartesianPositionCovariance =
          CartesianPositionCovarianceMapper.read(uap, dataSpec);

      Wgs84PositionAccuracy wgs84PositionAccuracy = Wgs84PositionAccuracyMapper.read(uap, dataSpec);

      GeometricAltitudeAccuracy geometricAltitudeAccuracy =
          GeometricAltitudeAccuracyMapper.read(uap, dataSpec);

      BarometricAltitudeAccuracy barometricAltitudeAccuracy =
          BarometricAltitudeAccuracyMapper.read(uap, dataSpec);

      CartesianVelocityAccuracy cartesianVelocityAccuracy =
          CartesianVelocityAccuracyMapper.read(uap, dataSpec);

      CartesianAccelerationAccuracy cartesianAccelerationAccuracy =
          CartesianAccelerationAccuracyMapper.read(uap, dataSpec);

      VerticalRateAccuracy verticalRateAccuracy = VerticalRateAccuracyMapper.read(uap, dataSpec);

      int size = dataSpec.calculateTotalSize();
      fpIndicator.setSize(dataSpec.calculateTotalSize());
      return estimatedAccuracy;
    }
    return null;
  }
}
