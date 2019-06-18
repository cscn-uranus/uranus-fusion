package com.uranus.transition.common.asterix.uap.vehicle;

import lombok.Data;

/**
 * TargetSizeAndOrientation
 *
 * <p>Data Item I062/270, Target Size & Orientation
 *
 * <p>Definition: Target size defined as length and width of the detected target, and orientation.
 *
 * <p>Format: Variable length Data Item comprising a first part of one octet, followed by one-octet
 * extents as necessary.
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
@Data
public class TargetSizeAndOrientation {

  /** bit-2 (LSB) = 1 m bit-1 (FX) = 0 End of Data Item = 1 Extension into first extent */
  private Integer length;

  /**
   * bit-2 (LSB) = 360° / 128 = approx. 2.81° bit-1 (FX) = 0 End of Data Item = 1 Extension into
   * next extent
   */
  private Double orientation;

  /** bit-2 (LSB) = 1 m bit-1 (FX) = 0 End of Data Item = 1 Extension into next extent */
  private Integer width;
}
