package com.uranus.transition.common.asterix.uap.measure.speed;

import lombok.Data;

/**
 * CartesianVelocity
 *
 * <p>Data Item I062/185, Calculated Track Velocity (Cartesian)
 *
 * Definition: Calculated track
 * velocity expressed in Cartesian co-ordinates, in two’s complement form.
 *
 * Format: Four-octet fixed
 * length Data Item.
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/12
 */
@Data
public class CartesianVelocity {

  /** bits-32/17
   *
   * Vx (LSB) = 0.25 m/s
   *
   * -8192m/s £ Vx £ 8191.75m/s */
  private Double velocityX;

  /** bits-16/1
   *
   * Vy (LSB) = 0.25 m/s
   *
   * -8192m/s £ Vy £ 8191.75m/s */
  private Double velocityY;
}
