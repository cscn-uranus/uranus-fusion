package com.uranus.fusion.tfr.cat062.dto.ifpl;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * RoutePointDTO
 *
 * @author tellxp@github.com
 * @date 2018/11/23
 */
public class RoutePointDTO implements Serializable {

  private String pointId;
  private String flightLevel;
  private LocalDateTime estimatedTimeOver;
  private RoutePointPassEnum passedType;

  public String getPointId() {
    return pointId;
  }

  public void setPointId(String pointId) {
    this.pointId = pointId;
  }

  public String getFlightLevel() {
    return flightLevel;
  }

  public void setFlightLevel(String flightLevel) {
    this.flightLevel = flightLevel;
  }

  public LocalDateTime getEstimatedTimeOver() {
    return estimatedTimeOver;
  }

  public void setEstimatedTimeOver(LocalDateTime estimatedTimeOver) {
    this.estimatedTimeOver = estimatedTimeOver;
  }

  public RoutePointPassEnum getPassedType() {
    return passedType;
  }

  public void setPassedType(RoutePointPassEnum passedType) {
    this.passedType = passedType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RoutePointDTO)) {
      return false;
    }
    RoutePointDTO that = (RoutePointDTO) o;
    return Objects.equals(pointId, that.pointId) &&
        Objects.equals(flightLevel, that.flightLevel) &&
        Objects.equals(estimatedTimeOver, that.estimatedTimeOver) &&
        passedType == that.passedType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(pointId, flightLevel, estimatedTimeOver, passedType);
  }

  @Override
  public String toString() {
    return "RoutePointDTO{" +
        "pointId='" + pointId + '\'' +
        ", flightLevel='" + flightLevel + '\'' +
        ", estimatedTimeOver=" + estimatedTimeOver +
        ", passedType=" + passedType +
        '}';
  }
}

