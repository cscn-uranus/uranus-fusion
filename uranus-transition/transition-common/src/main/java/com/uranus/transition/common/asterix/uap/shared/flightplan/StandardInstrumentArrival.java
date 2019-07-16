package com.uranus.transition.common.asterix.uap.shared.flightplan;

import lombok.Data;

/**
 * StandardInstrumentArrival
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
@Data
public class StandardInstrumentArrival {

  /**
   * NOTE - Each one of the seven Octets contains an ASCII Character. The STAR is always left
   * adjusted. It contains up to seven alphanumeric characters, the remaining character positions
   * (if any) are padded with space characters.
   */
  private String procedure;
}
