package com.uranus.fusion.asterix;

import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.util.ByteUtil;

import java.util.List;

public class ServiceIdentifierMapper {
    public static ServiceIdentifier readServiceIdentification(
            List<Byte> uapOctetList, FieldSpec fieldSpec) {

      // Service Identification frn=3
      FpIndicator fpIndicator = fieldSpec.getFpIndicator(3);
      if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
        // 固定长度
        fpIndicator.setSize(1);
        int index = fieldSpec.calculateOctetIndexByFrn(3);

        ServiceIdentifier serviceIdentifier = new ServiceIdentifier();

        String identifier = ByteUtil.toString(uapOctetList.get(index));
        serviceIdentifier.setIdentifier(identifier);

        return serviceIdentifier;
      }

      return null;
    }
}
