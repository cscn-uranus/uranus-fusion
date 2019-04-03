package com.uranus.fusion.transformer.asterix.aircraft.nd;

import com.uranus.fusion.transformer.asterix.aircraft.type.DataAvailableEnum;
import com.uranus.fusion.transformer.asterix.aircraft.type.DataValidEnum;

/**
 * TrajectoryIntentStatus
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/18
 */
public class TrajectoryIntentStatus {

  private DataAvailableEnum dataAvailableStatus;
  private DataValidEnum dataValidStatus;

  public DataAvailableEnum getDataAvailableStatus() {
    return dataAvailableStatus;
  }

  public void setDataAvailableStatus(
      DataAvailableEnum dataAvailableStatus) {
    this.dataAvailableStatus = dataAvailableStatus;
  }

  public DataValidEnum getDataValidStatus() {
    return dataValidStatus;
  }

  public void setDataValidStatus(DataValidEnum dataValidStatus) {
    this.dataValidStatus = dataValidStatus;
  }
}
