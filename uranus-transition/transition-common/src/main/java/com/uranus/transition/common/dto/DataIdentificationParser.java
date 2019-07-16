package com.uranus.transition.common.dto;

import com.uranus.transition.common.asterix.uap.eucat062.EuCat062DataBlock;

/**
 * @author tellxp@github.com
 * @date 2019/5/20 21:39
 */

public class DataIdentificationParser {
  public static DataIdentificationDTO parse(
    EuCat062DataBlock euCat062DataBlock) {
    DataIdentificationDTO dataIdentificationDTO = new DataIdentificationDTO();

    if (null != euCat062DataBlock.getSystemIdentification()) {
      dataIdentificationDTO.setSac(euCat062DataBlock.getSystemIdentification().getSac());
      dataIdentificationDTO.setSic(euCat062DataBlock.getSystemIdentification().getSic());
    }

    if (null != euCat062DataBlock.getServiceIdentification()) {
      dataIdentificationDTO.setSi(euCat062DataBlock.getServiceIdentification().getIdentification());
    }
    return dataIdentificationDTO;
  }
}
