package com.uranus.tdp.xml.track.dom;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class PositionReportDom {

  @JacksonXmlProperty(localName = "TRACKID")
  private String trackId;

  @JacksonXmlProperty(localName = "CallSign")
  private String callSign;

  @JacksonXmlProperty(localName = "REGID")
  private String regId;

  @JacksonXmlProperty(localName = "RSPID")
  private String rspId;

  @JacksonXmlProperty(localName = "GroudSpeed")
  private String groundSpeed;

  @JacksonXmlProperty(localName = "Height")
  private String height;

  @JacksonXmlProperty(localName = "Altitude")
  private String altitude;

  @JacksonXmlProperty(localName = "LONGITUDE")
  private String longitude;

  @JacksonXmlProperty(localName = "LATITUDE")
  private String latitude;

  @JacksonXmlProperty(localName = "Vector")
  private String vector;

  @JacksonXmlProperty(localName = "VerticalRate")
  private String verticalRate;

  public String getTrackId() {
    return trackId;
  }

  public void setTrackId(String trackId) {
    this.trackId = trackId;
  }

  public String getCallSign() {
    return callSign;
  }

  public void setCallSign(String callSign) {
    this.callSign = callSign;
  }

  public String getRegId() {
    return regId;
  }

  public void setRegId(String regId) {
    this.regId = regId;
  }

  public String getRspId() {
    return rspId;
  }

  public void setRspId(String rspId) {
    this.rspId = rspId;
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
}
