package com.uranus.tdp.xml.track.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FlightTrackDO {
  @Id private String flightTrackId;
  private String dataSource;
  private String dataType;
  private LocalDateTime timestamp;

  private String reportTrackId;
  private String flightIdentification;
  private String aircraftRegistration;
  private String ssrCode;
  private String groundSpeed;
  private String height;
  private String altitude;
  private String longitude;
  private String latitude;
  private String vector;
  private String verticalRate;

  private LocalDateTime persistTime;
  private LocalDateTime updateTime;

  public String getFlightTrackId() {
    return flightTrackId;
  }

  public void setFlightTrackId(String flightTrackId) {
    this.flightTrackId = flightTrackId;
  }

  public String getDataSource() {
    return dataSource;
  }

  public void setDataSource(String dataSource) {
    this.dataSource = dataSource;
  }

  public String getDataType() {
    return dataType;
  }

  public void setDataType(String dataType) {
    this.dataType = dataType;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public String getReportTrackId() {
    return reportTrackId;
  }

  public void setReportTrackId(String reportTrackId) {
    this.reportTrackId = reportTrackId;
  }

  public String getFlightIdentification() {
    return flightIdentification;
  }

  public void setFlightIdentification(String flightIdentification) {
    this.flightIdentification = flightIdentification;
  }

  public String getAircraftRegistration() {
    return aircraftRegistration;
  }

  public void setAircraftRegistration(String aircraftRegistration) {
    this.aircraftRegistration = aircraftRegistration;
  }

  public String getSsrCode() {
    return ssrCode;
  }

  public void setSsrCode(String ssrCode) {
    this.ssrCode = ssrCode;
  }

  public String getGroundSpeed() {
    return groundSpeed;
  }

  public void setGroundSpeed(String groundSpeed) {
    this.groundSpeed = groundSpeed;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public String getAltitude() {
    return altitude;
  }

  public void setAltitude(String altitude) {
    this.altitude = altitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getVector() {
    return vector;
  }

  public void setVector(String vector) {
    this.vector = vector;
  }

  public String getVerticalRate() {
    return verticalRate;
  }

  public void setVerticalRate(String verticalRate) {
    this.verticalRate = verticalRate;
  }

  public LocalDateTime getPersistTime() {
    return persistTime;
  }

  public void setPersistTime(LocalDateTime persistTime) {
    this.persistTime = persistTime;
  }

  public LocalDateTime getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(LocalDateTime updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FlightTrackDO)) {
      return false;
    }
    FlightTrackDO that = (FlightTrackDO) o;
    return Objects.equals(dataSource, that.dataSource) &&
        Objects.equals(dataType, that.dataType) &&
        Objects.equals(timestamp, that.timestamp) &&
        Objects.equals(reportTrackId, that.reportTrackId) &&
        Objects.equals(flightIdentification, that.flightIdentification) &&
        Objects.equals(aircraftRegistration, that.aircraftRegistration) &&
        Objects.equals(ssrCode, that.ssrCode) &&
        Objects.equals(groundSpeed, that.groundSpeed) &&
        Objects.equals(height, that.height) &&
        Objects.equals(altitude, that.altitude) &&
        Objects.equals(longitude, that.longitude) &&
        Objects.equals(latitude, that.latitude) &&
        Objects.equals(vector, that.vector) &&
        Objects.equals(verticalRate, that.verticalRate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataSource, dataType, timestamp, reportTrackId, flightIdentification,
        aircraftRegistration, ssrCode, groundSpeed, height, altitude, longitude, latitude, vector,
        verticalRate);
  }
}
