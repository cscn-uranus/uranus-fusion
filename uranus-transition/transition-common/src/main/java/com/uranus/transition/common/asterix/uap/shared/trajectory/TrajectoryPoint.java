package com.uranus.transition.common.asterix.uap.shared.trajectory;

import com.uranus.transition.common.asterix.uap.shared.datainfo.DataAvailableEnum;
import com.uranus.transition.common.asterix.uap.shared.measure.movement.TurnDirectionEnum;
import lombok.Data;

/**
 * TrajectoryPoint
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/22
 */
@Data
public class TrajectoryPoint {

  private TrajectoryIntentData trajectoryIntentData;

  private DataAvailableEnum tcpAvailableStatus;
  private ComplianceEnum tcpComplianceStatus;
  private Integer tcpNumber;

  private Integer altitude;
  private Double latitude;
  private Double longitude;

  private TrajectoryPointTypeEnum trajectoryPointTypeEnum;
  private TurnDirectionEnum turnDirectionEnum;
  private DataAvailableEnum turnRadiusStatus;
  private DataAvailableEnum timeOverPointStatus;
  private Integer timeOverPoint;
  private Double turnRadius;
}
