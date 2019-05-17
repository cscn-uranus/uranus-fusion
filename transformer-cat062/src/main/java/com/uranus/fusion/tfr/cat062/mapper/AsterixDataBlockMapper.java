package com.uranus.fusion.tfr.cat062.mapper;

import com.uranus.fusion.common.asterix.AsterixDataBlock;
import com.uranus.fusion.tfr.cat062.dto.DataIdentificationDTO;
import com.uranus.fusion.tfr.cat062.dto.FlightDTO;

import java.util.List;

/**
 * @author tellxp@github.com
 * @date 2019/5/15 22:11
 */

public class AsterixDataBlockMapper {
  public static FlightDTO toFlightDTO(AsterixDataBlock asterixDataBlock) {
    FlightDTO flightDTO = new FlightDTO();
    return flightDTO;
  }

  private static DataIdentificationDTO parseDataIdentificationDTO(AsterixDataBlock asterixDataBlock) {
    DataIdentificationDTO dataIdentificationDTO = new DataIdentificationDTO();
    dataIdentificationDTO.setSac(asterixDataBlock.getSystemIdentification().getSac());
    dataIdentificationDTO.setSic(asterixDataBlock.getSystemIdentification().getSic());
    dataIdentificationDTO.setSi(asterixDataBlock.getServiceIdentification().getIdentifier());
    return dataIdentificationDTO;
  }
}
