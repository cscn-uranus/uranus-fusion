package com.uranus.transition.common.asterix.uap.shared.trajectory;

import com.uranus.transition.common.asterix.uap.shared.datainfo.DataAvailableEnum;
import com.uranus.transition.common.asterix.uap.shared.datainfo.DataValidEnum;
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
