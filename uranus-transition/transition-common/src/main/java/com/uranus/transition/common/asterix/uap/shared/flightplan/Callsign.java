package com.uranus.transition.common.asterix.uap.shared.flightplan;

import lombok.Data;

/**
 * Callsign
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/24
 */
@Data
public class Callsign {

  /**
   * Each one of the seven Octets contains an ASCII Character. The Callsign is always left adjusted.
   * It contains up to seven upper-case alphanumeric characters, the remaining character positions
   * (if any) are padded with space characters.
   */
  private String sign;
}
