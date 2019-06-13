package com.uranus.transition.common.asterix.uap.measure.speed;

import lombok.Data;

/**
 * CartesianAcceleration
 *
 * <p>Data Item I062/210, Calculated Acceleration (Cartesian)
 *
 * Definition : Calculated Acceleration
 * of the target expressed in Cartesian coordinates, in two’s complement form.
 *
 * Format: Two-octet
 * fixed length Data Item.
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/12
 */
@Data
public class CartesianAcceleration {

  /** bits-16/9
   *
   * Ax
   *
   * (LSB) = 0.25 m/s2 */
  private Double accelerationX;

  /** bits-8/1
   *
   * Ay
   *
   * (LSB) = 0.25 m/s2 */
  private Double accelerationY;
}
