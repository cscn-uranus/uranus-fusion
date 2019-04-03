package com.uranus.fusion.transformer.asterix.aircraft.nd;

import java.util.HashSet;
import java.util.Set;

/**
 * TrajectoryIntentData
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/22
 */
public class TrajectoryIntentData {

  private Integer repeatIndicator;
  private Set<TrajectoryPoint> trajectoryPoints;

  public TrajectoryIntentData() {
    this.trajectoryPoints = new HashSet<>();
  }

  public Integer getRepeatIndicator() {
    return repeatIndicator;
  }

  public void setRepeatIndicator(Integer repeatIndicator) {
    this.repeatIndicator = repeatIndicator;
  }

  public Set<TrajectoryPoint> getTrajectoryPoints() {
    return trajectoryPoints;
  }

  public void setTrajectoryPoints(
      Set<TrajectoryPoint> trajectoryPoints) {
    this.trajectoryPoints = trajectoryPoints;
  }

  public void add(TrajectoryPoint point) {
    this.trajectoryPoints.add(point);
  }

}
