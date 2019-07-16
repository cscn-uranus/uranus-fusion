package com.uranus.transition.reader.eucat062;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.identification.SystemIdentification;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com
 */
class DataSourceIdentifierReader {

  static SystemIdentification read(List<Byte> message, FieldSpec fieldSpec) {

    // Data Source Identifier: frn = 1, size = 2
    final int frn = EuCat062Config.DATA_SOURCE_IDENTIFIER_FRN;
    final int size = EuCat062Config.DATA_SOURCE_IDENTIFIER_SIZE;

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      // 固定长度
      fpIndicator.setSize(size);

      int index = fieldSpec.calculateIndexByFrn(frn);
      SystemIdentification dataSourceIdentifier = new SystemIdentification();

      String sac = ByteUtil.toString(message.get(index));
      dataSourceIdentifier.setSac(sac);

      String sic = ByteUtil.toString(message.get(index + 1));
      dataSourceIdentifier.setSic(sic);

      return dataSourceIdentifier;
    }
    return null;
  }
}
