package com.uranus.transition.common.asterix.uap.shared.flightplan;

import lombok.Data;

/**
 * AircraftStand
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
@Data
public class AircraftStand {

  /**
   * NOTE - Each one of the six Octets contains an ASCII Character. The Aircraft Stand
   * identification is always left adjusted. It contains up to six uppercase alphanumeric
   * characters, the remaining character positions (if any) are padded with space characters.
   */
  private String stand;
}
