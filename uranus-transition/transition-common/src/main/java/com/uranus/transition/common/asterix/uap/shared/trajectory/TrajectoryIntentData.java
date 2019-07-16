package com.uranus.transition.common.asterix.uap.shared.trajectory;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * TrajectoryIntentData
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/22
 */
@Data
public class TrajectoryIntentData {

  private Integer repeatIndicator;

  private List<TrajectoryPoint> trajectoryPoints = new ArrayList<>();

  public void add(TrajectoryPoint trajectoryPoint) {
    trajectoryPoints.add(trajectoryPoint);
  }
}
