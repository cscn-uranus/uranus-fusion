package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.uap.measure.QnhStatus;
import com.uranus.fusion.asterix.uap.measure.altitude.BarometricAltitude;
import com.uranus.fusion.util.ByteUtil;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * CalculatedTrackBarometricAltitudeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class CalculatedTrackBarometricAltitudeMapper {

  public static BarometricAltitude read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.getFpIndicator(Cat062Config.CALCULATED_TRACK_BAROMETRIC_ALTITUDE_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(Cat062Config.CALCULATED_TRACK_BAROMETRIC_ALTITUDE_SIZE);

      int index =
          fieldSpec.calculateIndexByFrn(Cat062Config.CALCULATED_TRACK_BAROMETRIC_ALTITUDE_FRN);

      BarometricAltitude trackBarometricAltitude = new BarometricAltitude();
      String qnhStatusBit = ByteUtil.toString(uap.get(index)).substring(0, 1);
      trackBarometricAltitude.setQnhStatus(
          ByteUtil.ZERO_BIT.equals(qnhStatusBit)
              ? QnhStatus.CORRECTION_NOT_APPLIED
              : QnhStatus.CORRECTION_APPLIED);

      int altitudeValue =
          IntegerUtil.valueOf(
              ByteUtil.valueOf(ByteUtil.toString(uap.get(index)).substring(1, 8)),
              uap.get(index + 1));
      trackBarometricAltitude.setAltitude(DecimalUtil.multiply(altitudeValue, 25));
      return trackBarometricAltitude;
    }
    return null;
  }
}
