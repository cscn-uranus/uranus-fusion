package com.uranus.transition.common.asterix.uap.shared.flightplan;

import lombok.Data;

/**
 * StandardInstrumentDeparture
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
@Data
public class StandardInstrumentDeparture {

  /**
   * NOTE - Each one of the seven Octets contains an ASCII Character. The SID is always left
   * adjusted. It contains up to seven alphanumeric characters, the remaining character positions
   * (if any) are padded with space characters.
   */
  private String procedure;
}
