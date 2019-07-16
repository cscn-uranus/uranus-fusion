package com.uranus.transition.common.asterix.uap.shared.measure.altitude;

import com.uranus.transition.common.asterix.uap.shared.aircraft.ModeActiveEnum;
import lombok.Data;

/**
 * FinalStateSelectedAltitude
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/18
 */
@Data
public class FinalStateSelectedAltitude {
  private Double altitude;
  private ModeActiveEnum manageVerticalMode;
  private ModeActiveEnum altitudeHold;
  private ModeActiveEnum approachMode;
}
