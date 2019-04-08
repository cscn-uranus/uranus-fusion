package com.uranus.fusion.common.asterix.aircraft.fcu;

import com.uranus.fusion.common.asterix.aircraft.type.SourceInformationEnum;
import com.uranus.fusion.common.asterix.aircraft.type.SourceTypeEnum;

/**
 * SelectedAltitude
 *
 * @author 肖鹏 tellxp@github.com
 * date 2018/10/18
 */
public class SelectedAltitude {

  private Double altitude;
  private SourceInformationEnum sourceStatus;
  private SourceTypeEnum sourceTypeEnum;

  public Double getAltitude() {
    return altitude;
  }

  public void setAltitude(Double altitude) {
    this.altitude = altitude;
  }

  public SourceInformationEnum getSourceStatus() {
    return sourceStatus;
  }

  public void setSourceStatus(
      SourceInformationEnum sourceStatus) {
    this.sourceStatus = sourceStatus;
  }

  public SourceTypeEnum getSourceTypeEnum() {
    return sourceTypeEnum;
  }

  public void setSourceTypeEnum(SourceTypeEnum sourceTypeEnum) {
    this.sourceTypeEnum = sourceTypeEnum;
  }


}
