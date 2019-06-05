package com.uranus.transition.common.asterix.dto;

import com.uranus.transition.common.asterix.AsterixDataBlock;

/**
 * @author tellxp@github.com
 * @date 2019/5/20 21:39
 */

public class DataIdentificationParser {
  public static DataIdentificationDTO parse(
    AsterixDataBlock asterixDataBlock) {
    DataIdentificationDTO dataIdentificationDTO = new DataIdentificationDTO();

    if (null != asterixDataBlock.getSystemIdentification()) {
      dataIdentificationDTO.setSac(asterixDataBlock.getSystemIdentification().getSac());
      dataIdentificationDTO.setSic(asterixDataBlock.getSystemIdentification().getSic());
    }

    if (null != asterixDataBlock.getServiceIdentification()) {
      dataIdentificationDTO.setSi(asterixDataBlock.getServiceIdentification().getIdentifier());
    }
    return dataIdentificationDTO;
  }
}
