package com.uranus.fusion.asterix.uap.flightplan;

import com.uranus.fusion.asterix.uap.datainfo.DataAvailableEnum;
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
