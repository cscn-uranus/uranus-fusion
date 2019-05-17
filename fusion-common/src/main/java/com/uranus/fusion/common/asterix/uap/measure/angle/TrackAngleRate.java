package com.uranus.fusion.common.asterix.uap.measure.angle;

import com.uranus.fusion.common.asterix.uap.measure.movement.TurnDirectionEnum;
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
