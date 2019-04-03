package com.uranus.tdp.xml.track.dom;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "SData")
public class FlightTrackDom {

  @JacksonXmlProperty(localName = "DataSource")
  private String dataSource;

  @JacksonXmlProperty(localName = "DataType")
  private String dataType;

  @JacksonXmlProperty(localName = "TimeStamp")
  private String timeStamp;

  @JacksonXmlProperty(localName = "PositionReport")
  private PositionReportDom positionReportDom;

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

  public String getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(String timeStamp) {
    this.timeStamp = timeStamp;
  }

  public PositionReportDom getPositionReportDom() {
    return positionReportDom;
  }

  public void setPositionReportDom(PositionReportDom positionReportDom) {
    this.positionReportDom = positionReportDom;
  }
}
