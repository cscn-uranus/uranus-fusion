package com.uranus.fusion.common.asterix.uap.meteorology;

import com.uranus.fusion.common.asterix.uap.datainfo.DataValidEnum;
import lombok.Data;

/**
 * MetData
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
@Data
public class MetData {

  private DataValidEnum windSpeedStatus;
  private DataValidEnum windDirectionStatus;
  private DataValidEnum temperatureStatus;
  private DataValidEnum turbulenceStatus;
  private Double windSpeed;
  private Double windDirection;
  private Double temperature;
  private Integer turbulence;
}
