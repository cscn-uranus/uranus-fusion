package com.uranus.transition.common.asterix.uap.shared.measure.altitude;

import lombok.Data;

/**
 * Measured3dHeight
 *
 * <p>Data Item I062/340, Measured Information
 *
 * <p>Structure of Subfield # 3: Measured 3-D Height
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
@Data
public class Measured3dHeight {

  /** bits-16/1 Height (LSB) = 25 feet */
  private Double height;
}
