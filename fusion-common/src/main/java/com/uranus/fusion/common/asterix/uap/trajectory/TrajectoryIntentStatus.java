package com.uranus.fusion.common.asterix.uap.trajectory;

import com.uranus.fusion.common.asterix.uap.datainfo.DataAvailableEnum;
import com.uranus.fusion.common.asterix.uap.datainfo.DataValidEnum;
import lombok.Data;

/**
 * TrajectoryIntentStatus
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/18
 */
@Data
public class TrajectoryIntentStatus {

  private DataAvailableEnum dataAvailableStatus;
  private DataValidEnum dataValidStatus;
}
