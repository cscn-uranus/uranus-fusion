package com.uranus.fusion.transformer.asterix.aircraft.transponder.mode5;

import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;

/**
 * Mode5AndExtendedMode1Data
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
 */
public class Mode5AndExtendedMode1Data {

  private DataSpec dataSpec;
  private Mode5Summary mode5Summary;
  private Mode5Identification mode5Identification;
  private Mode5Position mode5Position;
  private Mode5Altitude mode5Altitude;
  private ExtendedMode1Code extendedMode1Code;
  private TimeOffset timeOffset;
  private XpulsePresenceStatus xpulsePresenceStatus;

  public DataSpec getDataSpec() {
    return dataSpec;
  }

  public void setDataSpec(DataSpec dataSpec) {
    this.dataSpec = dataSpec;
  }

  public Mode5Summary getMode5Summary() {
    return mode5Summary;
  }

  public void setMode5Summary(Mode5Summary mode5Summary) {
    this.mode5Summary = mode5Summary;
  }

  public Mode5Identification getMode5Identification() {
    return mode5Identification;
  }

  public void setMode5Identification(
      Mode5Identification mode5Identification) {
    this.mode5Identification = mode5Identification;
  }

  public Mode5Position getMode5Position() {
    return mode5Position;
  }

  public void setMode5Position(
      Mode5Position mode5Position) {
    this.mode5Position = mode5Position;
  }

  public Mode5Altitude getMode5Altitude() {
    return mode5Altitude;
  }

  public void setMode5Altitude(
      Mode5Altitude mode5Altitude) {
    this.mode5Altitude = mode5Altitude;
  }

  public ExtendedMode1Code getExtendedMode1Code() {
    return extendedMode1Code;
  }

  public void setExtendedMode1Code(
      ExtendedMode1Code extendedMode1Code) {
    this.extendedMode1Code = extendedMode1Code;
  }

  public TimeOffset getTimeOffset() {
    return timeOffset;
  }

  public void setTimeOffset(TimeOffset timeOffset) {
    this.timeOffset = timeOffset;
  }

  public XpulsePresenceStatus getXpulsePresenceStatus() {
    return xpulsePresenceStatus;
  }

  public void setXpulsePresenceStatus(
      XpulsePresenceStatus xpulsePresenceStatus) {
    this.xpulsePresenceStatus = xpulsePresenceStatus;
  }
}
