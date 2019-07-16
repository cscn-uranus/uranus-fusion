package com.uranus.transition.reader.eucat062;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.measure.QnhStatus;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.BarometricAltitude;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.DecimalUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
class CalculatedTrackBarometricAltitudeReader {

  static BarometricAltitude read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(EuCat062Config.CALCULATED_TRACK_BAROMETRIC_ALTITUDE_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(EuCat062Config.CALCULATED_TRACK_BAROMETRIC_ALTITUDE_SIZE);

      int index =
          fieldSpec.calculateIndexByFrn(EuCat062Config.CALCULATED_TRACK_BAROMETRIC_ALTITUDE_FRN);

      BarometricAltitude trackBarometricAltitude = new BarometricAltitude();
      String qnhStatusBit = ByteUtil.toString(message.get(index)).substring(0, 1);
      trackBarometricAltitude.setQnhStatus(
          ByteUtil.ZERO_BIT.equals(qnhStatusBit)
              ? QnhStatus.CORRECTION_NOT_APPLIED
              : QnhStatus.CORRECTION_APPLIED);

      int altitudeValue =
          IntegerUtil.unsignedValueOf(
              ByteUtil.unsignedValueOf(ByteUtil.toString(message.get(index)).substring(1, 8)),
              message.get(index + 1));
      trackBarometricAltitude.setAltitude(DecimalUtil.multiply(altitudeValue, 25));
      return trackBarometricAltitude;
    }
    return null;
  }
}
