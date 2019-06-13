package com.uranus.transition.common.asterix.uap.measure.position;

import lombok.Data;

/**
 * MeasuredPosition
 *
 * <p>Data Item I062/340, Measured Information
 *
 * <p>Structure of Subfield # 2: Measured Position
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
@Data
public class MeasuredPosition {
  /** bits 32/17 (RHO) Measured distance:
   *
   * bit 17 (LSB) = 1/256 NM Maximum value = 256 NM */
  private Double rho;

  /** bits 16/1 (THETA) Measured azimuth
   *
   * bit 1 (LSB) = 360° / 216 @ 0.0055° */
  private Double theta;
}
