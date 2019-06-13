package com.uranus.transition.common.asterix.uap.measure.altitude;

import lombok.Data;

/**
 * FlightLevel
 *
 * <ul>
 *   <li>Data Item I062/136, Measured Flight Level
 *       <p>Definition : Last valid and credible flight level used to update the track, in two’s
 *       complement form.
 *       <p>Structure: Two-Octet fixed length data item.
 *   <li>Structure of Subfield # 10: Current Cleared Flight Level
 * </ul>
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
@Data
public class FlightLevel {

  /**
   * Flight Level 类型
   *
   * <p>分为 Cleared 和 Measured
   */
  private FlightLevelEnum flightLevelEnum;

  /**
   * bits- 16/1
   *
   * <p>Measured Flight Level
   *
   * <p>(LSB) = 1/4 FL Vmin = -15 FL Vmax = 1500 FL
   */
  private Double fl;

  public FlightLevel(FlightLevelEnum flightLevelEnum) {
    this.flightLevelEnum = flightLevelEnum;
  }
}
