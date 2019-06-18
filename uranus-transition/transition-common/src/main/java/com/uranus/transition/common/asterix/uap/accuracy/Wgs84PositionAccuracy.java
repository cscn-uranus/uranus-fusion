package com.uranus.transition.common.asterix.uap.accuracy;

import lombok.Data;

/**
 * Wgs84PositionAccuracy
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/14
 */
@Data
public class Wgs84PositionAccuracy {

  private Double accuracyLatitude;
  private Double accuracyLongitude;
}