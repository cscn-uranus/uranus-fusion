package com.uranus.fusion.asterix.sensor;

import com.uranus.fusion.asterix.measure.BarometricAltitude;
import com.uranus.fusion.asterix.measure.QnhStatus;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.util.ByteUtil;
import com.uranus.fusion.asterix.util.DecimalUtil;
import com.uranus.fusion.asterix.util.IntegerUtil;
import java.util.List;

/**
 * TrackBarometricAltitudeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class TrackBarometricAltitudeMapper {

  public static BarometricAltitude read(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 19;
    final int length = 2;
    final String zeroBit = "0";

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(length);

      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      BarometricAltitude trackBarometricAltitude = new BarometricAltitude();
      String qnhStatusBit = ByteUtil.toString(uap.get(index)).substring(0, 1);
      trackBarometricAltitude.setQnhStatus(
          zeroBit.equals(qnhStatusBit) ? QnhStatus.CORRECTION_NOT_APPLIED
              : QnhStatus.CORRECTION_APPLIED
      );

      int altitudeValue = IntegerUtil
          .valueOf(ByteUtil.valueOf(ByteUtil.toString(uap.get(index)).substring(1, 8)),
              uap.get(index + 1));
      trackBarometricAltitude.setAltitude(DecimalUtil.multiply(altitudeValue, 25));
      return trackBarometricAltitude;

    }
    return null;
  }

}
