package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;
import com.uranus.transition.common.asterix.uap.shared.identification.SystemIdentification;
import com.uranus.transition.common.util.ByteUtil;

import java.util.List;

/**
 * # I003/010
 *
 * <p>数据源标识 {@link SystemIdentification}
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2019/6/25
 */
public class DataSourceIdentifierReader {

  public static SystemIdentification read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(CnCat003Config.DATA_SOURCE_IDENTIFIER_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      // 固定长度
      fpIndicator.setSize(CnCat003Config.DATA_SOURCE_IDENTIFIER_SIZE);

      int index = fieldSpec.calculateIndexByFrn(CnCat003Config.DATA_SOURCE_IDENTIFIER_FRN);
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
