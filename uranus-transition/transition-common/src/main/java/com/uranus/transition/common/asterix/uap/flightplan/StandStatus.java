package com.uranus.transition.common.asterix.uap.flightplan;

import com.uranus.transition.common.asterix.uap.datainfo.DataAvailableEnum;
import lombok.Data;

/**
 * StandStatus
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
@Data
public class StandStatus {

  /** bits-8/7 (EMP) = 00 Empty = 01 Occupied = 10 Unknown = 11 Invalid */
  private CabinStatusEnum cabinStatusEnum;

  /** bits-6/5 (AVL) = 00 Available = 01 Not available = 10 Unknown = 11 Invalid */
  private DataAvailableEnum dataAvailableEnum;
}
