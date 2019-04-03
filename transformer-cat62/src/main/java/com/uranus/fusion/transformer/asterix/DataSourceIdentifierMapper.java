package com.uranus.fusion.transformer.asterix;

import com.uranus.fusion.transformer.asterix.message.spec.FieldSpec;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicator;
import com.uranus.fusion.transformer.asterix.util.ByteUtil;

import java.util.List;

/**
 * DataSourceIdentifierMapper
 *
 * @author 肖鹏 tellxp@github.com
 */
public class DataSourceIdentifierMapper {

  private static final Integer FRN = 1;
  private static final Integer SIZE = 2;

  public static SystemIdentifier readDataSourceIdentifier(
      List<Byte> uapOctetList, FieldSpec fieldSpec) {

    // Data Source Identifier frn=1
    FpIndicator fpIndicator = fieldSpec.getFpIndicator(FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {

      // 固定长度
      fpIndicator.setSize(SIZE);

      int index = fieldSpec.calculateOctetIndexByFrn(FRN);
      SystemIdentifier dataSourceIdentifier = new SystemIdentifier();

      String sac = ByteUtil.toString(uapOctetList.get(index));
      dataSourceIdentifier.setSac(sac);

      String sic = ByteUtil.toString(uapOctetList.get(index + 1));
      dataSourceIdentifier.setSic(sic);

      return dataSourceIdentifier;
    }
    return null;
  }
}
