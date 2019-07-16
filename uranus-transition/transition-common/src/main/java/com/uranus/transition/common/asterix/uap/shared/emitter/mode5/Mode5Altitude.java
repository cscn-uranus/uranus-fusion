package com.uranus.transition.common.asterix.uap.shared.emitter.mode5;

import com.uranus.transition.common.asterix.uap.shared.measure.altitude.AltitudeResolutionEnum;
import lombok.Data;

/**
 * Mode5Altitude
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
@Data
public class Mode5Altitude {

  private AltitudeResolutionEnum altitudeResolutionEnum;
  private Double altitude;
}
