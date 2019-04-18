package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.uap.identification.ServiceIdentification;
import com.uranus.fusion.util.ByteUtil;

import java.util.List;

public class ServiceIdentifierMapper {
  public static ServiceIdentification readServiceIdentification(
      List<Byte> uapOctetList, FieldSpec fieldSpec) {

    // Service Identification: frn=3, size=1
    final int frn = Cat062Config.SERVICE_IDENTIFICATION_FRN;
    final int size = Cat062Config.SERVICE_IDENTIFICATION_SIZE;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      // 固定长度
      fpIndicator.setSize(size);
      int index = fieldSpec.calculateIndexByFrn(frn);

      ServiceIdentification serviceIdentification = new ServiceIdentification();

      String identifier = ByteUtil.toString(uapOctetList.get(index));
      serviceIdentification.setIdentifier(identifier);

      return serviceIdentification;
    }

    return null;
  }
}
