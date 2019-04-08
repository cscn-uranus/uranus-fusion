package com.uranus.fusion.common.asterix.aircraft.pfd;

import com.uranus.fusion.common.asterix.aircraft.type.DataValidEnum;

/**
 * MeteorologicalData
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/24
 */
public class MeteorologicalData {

  private DataValidEnum windSpeedStatus;
  private DataValidEnum windDirectionStatus;
  private DataValidEnum temperatureStatus;
  private DataValidEnum turbulenceStatus;
  private Double windSpeed;
  private Double windDirection;
  private Double temperature;
  private Integer turbulence;

  public DataValidEnum getWindSpeedStatus() {
    return windSpeedStatus;
  }

  public void setWindSpeedStatus(DataValidEnum windSpeedStatus) {
    this.windSpeedStatus = windSpeedStatus;
  }

  public DataValidEnum getWindDirectionStatus() {
    return windDirectionStatus;
  }

  public void setWindDirectionStatus(
      DataValidEnum windDirectionStatus) {
    this.windDirectionStatus = windDirectionStatus;
  }

  public DataValidEnum getTemperatureStatus() {
    return temperatureStatus;
  }

  public void setTemperatureStatus(DataValidEnum temperatureStatus) {
    this.temperatureStatus = temperatureStatus;
  }

  public DataValidEnum getTurbulenceStatus() {
    return turbulenceStatus;
  }

  public void setTurbulenceStatus(DataValidEnum turbulenceStatus) {
    this.turbulenceStatus = turbulenceStatus;
  }

  public Double getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(Double windSpeed) {
    this.windSpeed = windSpeed;
  }

  public Double getWindDirection() {
    return windDirection;
  }

  public void setWindDirection(Double windDirection) {
    this.windDirection = windDirection;
  }

  public Double getTemperature() {
    return temperature;
  }

  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }

  public Integer getTurbulence() {
    return turbulence;
  }

  public void setTurbulence(Integer turbulence) {
    this.turbulence = turbulence;
  }
}
