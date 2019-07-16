package com.uranus.transition.reader.eucat062;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.identification.ServiceIdentification;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

class ServiceIdentificationReader {
  static ServiceIdentification read(List<Byte> message, FieldSpec fieldSpec) {

    // Service Identification: frn=3, size=1
    final int frn = EuCat062Config.SERVICE_IDENTIFICATION_FRN;
    final int size = EuCat062Config.SERVICE_IDENTIFICATION_SIZE;

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      // 固定长度
      fpIndicator.setSize(size);
      int index = fieldSpec.calculateIndexByFrn(frn);

      ServiceIdentification serviceIdentification = new ServiceIdentification();

      String identifier = ByteUtil.toString(message.get(index));
      serviceIdentification.setIdentification(identifier);

      return serviceIdentification;
    }

    return null;
  }
}
