package com.uranus.transition.common.asterix.uap.shared.flightplan;

import lombok.Data;

/**
 * DepartureAirport
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
@Data
public class DepartureAirport {

  /**
   * NOTES 1. Each one of the four Octets composing the name of an airport contains an ASCII
   * Character (upper case alphabetic). 2. The Airport Names are indicated in the ICAO Location
   * Indicators book.
   */
  private String icaoName;
}
