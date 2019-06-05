package com.uranus.transition.common.asterix.uap.measure.altitude;

import com.uranus.transition.common.asterix.uap.measure.QnhStatus;
import lombok.Data;

/**
 * BarometricAltitude
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
@Data
public class BarometricAltitude {

  private QnhStatus qnhStatus;
  private Double altitude;
}
