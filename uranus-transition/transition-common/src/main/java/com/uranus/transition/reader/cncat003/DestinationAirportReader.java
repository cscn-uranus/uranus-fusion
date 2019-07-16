package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.flightplan.ControlledStatus;
import com.uranus.transition.common.asterix.uap.shared.flightplan.DestinationAirport;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.StringUtil;

import java.util.List;

/**
 * @author tellxp@github.com
 * @date 2019/7/4
 */
public class DestinationAirportReader {
  public static DestinationAirport read(List<Byte> message, FieldSpec fieldSpec) {
    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(CnCat003Config.DESTINATION_AIRPORT_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      int sizeCount = CnCat003Config.DESTINATION_AIRPORT_EX_SIZE;

      int index = fieldSpec.calculateIndexByFrn(CnCat003Config.DESTINATION_AIRPORT_FRN);
      DestinationAirport destinationAirport = new DestinationAirport();

      StringBuilder icaoNameBuilder = new StringBuilder();

      while (true) {
        String icaoNameBit = ByteUtil.toString(message.get(index)).substring(0, 7);
        icaoNameBuilder.append(
          StringUtil.standardAsciiValueOf("0" + icaoNameBit, ByteUtil.BITS_OF_BYTE));

        String fxBit = ByteUtil.toString(message.get(index)).substring(7, 8);
        if (ByteUtil.ZERO_BIT.equals(fxBit)) {
          destinationAirport.setIcaoName(icaoNameBuilder.toString());
          fpIndicator.setSize(sizeCount);
          return destinationAirport;
        }
        sizeCount+=CnCat003Config.DESTINATION_AIRPORT_EX_SIZE;
      }
    }
    return null;
  }
}
