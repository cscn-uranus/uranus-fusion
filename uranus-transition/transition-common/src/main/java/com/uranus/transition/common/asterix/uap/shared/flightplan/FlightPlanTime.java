package com.uranus.transition.common.asterix.uap.shared.flightplan;

import com.uranus.transition.common.asterix.uap.shared.datainfo.DataAvailableEnum;
import lombok.Data;

/**
 * FlightPlanTime
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
@Data
public class FlightPlanTime {

  private FlightPlanTimeTypeEnum flightPlanTimeTypeEnum;
  private FlightPlanDayEnum flightPlanDayEnum;
  private Integer hour;
  private Integer minute;
  private DataAvailableEnum secondAvailableStatus;
  private Integer second;
}
