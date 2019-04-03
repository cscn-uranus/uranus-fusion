package com.uranus.fusion.transformer.asterix.flightplan;

import com.uranus.fusion.transformer.asterix.aircraft.type.DataAvailableEnum;

/**
 * StandStatus
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/12
 */
public class StandStatus {

  private CabinStatusEnum cabinStatusEnum;
  private DataAvailableEnum dataAvailableEnum;

  public CabinStatusEnum getCabinStatusEnum() {
    return cabinStatusEnum;
  }

  public void setCabinStatusEnum(CabinStatusEnum cabinStatusEnum) {
    this.cabinStatusEnum = cabinStatusEnum;
  }

  public DataAvailableEnum getDataAvailableEnum() {
    return dataAvailableEnum;
  }

  public void setDataAvailableEnum(DataAvailableEnum dataAvailableEnum) {
    this.dataAvailableEnum = dataAvailableEnum;
  }
}
