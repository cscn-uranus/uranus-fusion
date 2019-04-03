package com.uranus.fusion.transformer.asterix.aircraft.transponder.comm;

/**
 * CommAndStatusByModeSel
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/22
 */
public class CommAndStatusByModeSel {

  private CommCapabilityEnum commCapabilityEnum;
  private ModeSelFlightStatusEnum modeSelFlightStatusEnum;
  private ServiceCapabilityEnum specificServiceCapability;
  private AltitudeReportCapabilityEnum altitudeReportCapabilityEnum;
  private ServiceCapabilityEnum aircraftIdentificationCapability;

  private String bdsA;
  private String bdsB;

  public CommCapabilityEnum getCommCapabilityEnum() {
    return commCapabilityEnum;
  }

  public void setCommCapabilityEnum(
      CommCapabilityEnum commCapabilityEnum) {
    this.commCapabilityEnum = commCapabilityEnum;
  }

  public ModeSelFlightStatusEnum getModeSelFlightStatusEnum() {
    return modeSelFlightStatusEnum;
  }

  public void setModeSelFlightStatusEnum(
      ModeSelFlightStatusEnum modeSelFlightStatusEnum) {
    this.modeSelFlightStatusEnum = modeSelFlightStatusEnum;
  }

  public ServiceCapabilityEnum getSpecificServiceCapability() {
    return specificServiceCapability;
  }

  public void setSpecificServiceCapability(
      ServiceCapabilityEnum specificServiceCapability) {
    this.specificServiceCapability = specificServiceCapability;
  }

  public AltitudeReportCapabilityEnum getAltitudeReportCapabilityEnum() {
    return altitudeReportCapabilityEnum;
  }

  public void setAltitudeReportCapabilityEnum(
      AltitudeReportCapabilityEnum altitudeReportCapabilityEnum) {
    this.altitudeReportCapabilityEnum = altitudeReportCapabilityEnum;
  }

  public ServiceCapabilityEnum getAircraftIdentificationCapability() {
    return aircraftIdentificationCapability;
  }

  public void setAircraftIdentificationCapability(
      ServiceCapabilityEnum aircraftIdentificationCapability) {
    this.aircraftIdentificationCapability = aircraftIdentificationCapability;
  }

  public String getBdsA() {
    return bdsA;
  }

  public void setBdsA(String bdsA) {
    this.bdsA = bdsA;
  }

  public String getBdsB() {
    return bdsB;
  }

  public void setBdsB(String bdsB) {
    this.bdsB = bdsB;
  }
}
