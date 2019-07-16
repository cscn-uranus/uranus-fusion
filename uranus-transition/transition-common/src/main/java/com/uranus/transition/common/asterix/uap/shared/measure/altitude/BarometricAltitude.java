package com.uranus.transition.common.asterix.uap.shared.measure.altitude;

import com.uranus.transition.common.asterix.uap.shared.measure.QnhStatus;
import lombok.Data;

/**
 * BarometricAltitude
 *
 * <p>Data Item I062/135, Calculated Track Barometric Altitude
 *
 * <p>Definition : Calculated Barometric Altitude of the track, in two’s complement form.
 *
 * <p>Format : Two-Octet fixed length data item.
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
@Data
public class BarometricAltitude {

  /**
   * bit-16
   *
   * <p>(QNH) = 0 No QNH correction applied = 1 QNH correction applied
   */
  private QnhStatus qnhStatus;

  /**
   * bits-15/1 Calculated Track Barometric Altitude
   *
   * <p>(LSB) = 1/4 FL = 25 ft Vmin = -15 FL Vmax = 1500 FL
   */
  private Double altitude;
}
