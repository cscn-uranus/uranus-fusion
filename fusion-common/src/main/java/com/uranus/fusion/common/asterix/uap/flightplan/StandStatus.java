package com.uranus.fusion.common.asterix.uap.flightplan;

import com.uranus.fusion.common.asterix.uap.datainfo.DataAvailableEnum;
import lombok.Data;

/**
 * StandStatus
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
@Data
public class StandStatus {

  private CabinStatusEnum cabinStatusEnum;
  private DataAvailableEnum dataAvailableEnum;
}
