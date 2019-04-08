package com.uranus.fusion.common.asterix.aircraft.nd;

import com.uranus.fusion.common.asterix.aircraft.pfd.TurnDirectionEnum;
import com.uranus.fusion.common.asterix.aircraft.transponder.comm.ComplianceEnum;
import com.uranus.fusion.common.asterix.aircraft.type.DataAvailableEnum;

import java.util.Objects;

/**
 * TrajectoryPoint
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/22
 */
public class TrajectoryPoint {

  private TrajectoryIntentData trajectoryIntentData;

  private DataAvailableEnum tcpAvailableStatus;
  private ComplianceEnum tcpComplianceStatus;
  private Integer tcpNumber;

  private Integer altitude;
  private Double latitude;
  private Double longitude;

  private TrajectoryPointTypeEnum trajectoryPointTypeEnum;
  private TurnDirectionEnum turnDirectionEnum;
  private DataAvailableEnum turnRadiusStatus;
  private DataAvailableEnum timeOverPointStatus;
  private Integer timeOverPoint;
  private Double turnRadius;

  public TrajectoryIntentData getTrajectoryIntentData() {
    return trajectoryIntentData;
  }

  public void setTrajectoryIntentData(
      TrajectoryIntentData trajectoryIntentData) {
    this.trajectoryIntentData = trajectoryIntentData;
  }

  public DataAvailableEnum getTcpAvailableStatus() {
    return tcpAvailableStatus;
  }

  public void setTcpAvailableStatus(
      DataAvailableEnum tcpAvailableStatus) {
    this.tcpAvailableStatus = tcpAvailableStatus;
  }

  public ComplianceEnum getTcpComplianceStatus() {
    return tcpComplianceStatus;
  }

  public void setTcpComplianceStatus(
      ComplianceEnum tcpComplianceStatus) {
    this.tcpComplianceStatus = tcpComplianceStatus;
  }

  public Integer getTcpNumber() {
    return tcpNumber;
  }

  public void setTcpNumber(Integer tcpNumber) {
    this.tcpNumber = tcpNumber;
  }

  public Integer getAltitude() {
    return altitude;
  }

  public void setAltitude(Integer altitude) {
    this.altitude = altitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public TrajectoryPointTypeEnum getTrajectoryPointTypeEnum() {
    return trajectoryPointTypeEnum;
  }

  public void setTrajectoryPointTypeEnum(TrajectoryPointTypeEnum trajectoryPointTypeEnum) {
    this.trajectoryPointTypeEnum = trajectoryPointTypeEnum;
  }

  public TurnDirectionEnum getTurnDirectionEnum() {
    return turnDirectionEnum;
  }

  public void setTurnDirectionEnum(TurnDirectionEnum turnDirectionEnum) {
    this.turnDirectionEnum = turnDirectionEnum;
  }

  public DataAvailableEnum getTurnRadiusStatus() {
    return turnRadiusStatus;
  }

  public void setTurnRadiusStatus(
      DataAvailableEnum turnRadiusStatus) {
    this.turnRadiusStatus = turnRadiusStatus;
  }

  public DataAvailableEnum getTimeOverPointStatus() {
    return timeOverPointStatus;
  }

  public void setTimeOverPointStatus(
      DataAvailableEnum timeOverPointStatus) {
    this.timeOverPointStatus = timeOverPointStatus;
  }

  public Integer getTimeOverPoint() {
    return timeOverPoint;
  }

  public void setTimeOverPoint(Integer timeOverPoint) {
    this.timeOverPoint = timeOverPoint;
  }

  public Double getTurnRadius() {
    return turnRadius;
  }

  public void setTurnRadius(Double turnRadius) {
    this.turnRadius = turnRadius;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TrajectoryPoint)) {
      return false;
    }
    TrajectoryPoint that = (TrajectoryPoint) o;
    return tcpAvailableStatus == that.tcpAvailableStatus &&
        tcpComplianceStatus == that.tcpComplianceStatus &&
        Objects.equals(tcpNumber, that.tcpNumber) &&
        Objects.equals(altitude, that.altitude) &&
        Objects.equals(latitude, that.latitude) &&
        Objects.equals(longitude, that.longitude) &&
        trajectoryPointTypeEnum == that.trajectoryPointTypeEnum &&
        turnDirectionEnum == that.turnDirectionEnum &&
        turnRadiusStatus == that.turnRadiusStatus &&
        timeOverPointStatus == that.timeOverPointStatus &&
        Objects.equals(timeOverPoint, that.timeOverPoint) &&
        Objects.equals(turnRadius, that.turnRadius);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(tcpAvailableStatus, tcpComplianceStatus, tcpNumber, altitude, latitude, longitude,
            trajectoryPointTypeEnum, turnDirectionEnum, turnRadiusStatus, timeOverPointStatus, timeOverPoint,
            turnRadius);
  }

}
