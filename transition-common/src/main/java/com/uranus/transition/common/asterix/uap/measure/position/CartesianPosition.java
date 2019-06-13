package com.uranus.transition.common.asterix.uap.measure.position;

import lombok.Data;

/**
 * CartesianPosition
 *
 * <p>Data Item I062/100, Calculated Track Position. (Cartesian)
 *
 * Definition : Calculated position in
 * Cartesian co-ordinates with a resolution of 0.5m, in two’s complement form.
 *
 * Format : Six-octet
 * fixed length Data Item.
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/12
 */
@Data
public class CartesianPosition {

  /**
   * bits 48/25 X
   *
   * bit 25 (LSB) = 0.5 m
   */
  private Double x;

  /** bits 24/1 Y bit 1
   *
   * (LSB) = 0.5 m */
  private Double y;
}
