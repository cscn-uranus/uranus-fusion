package com.uranus.transition.common.asterix.uap.shared.measure.angle;

import com.uranus.transition.common.asterix.uap.shared.measure.movement.TurnDirectionEnum;
import lombok.Data;

/**
 * TrackAngleRate
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
@Data
public class TrackAngleRate {

  private TurnDirectionEnum turnDirectionEnum;
  private Double rate;
}
