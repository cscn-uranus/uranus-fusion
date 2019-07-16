package com.uranus.transition.common.asterix.uap.shared.measure.speed;

import lombok.Data;

/**
 * MH 4008 I003/200
 *
 * <p>用极坐标表示的计算航迹地速
 *
 * @author tellxp@github.com
 * @date 2019/6/21
 */
@Data
public class PolarVelocity {
  /** 位17 (LSB) == (2E-13) km/s */
  private Double groundSpeed;

  /** 位1 (LSB) =360°/ (2E16) =0.005 5' */
  private Double angle;
}
