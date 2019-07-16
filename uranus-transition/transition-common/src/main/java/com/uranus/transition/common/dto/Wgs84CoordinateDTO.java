package com.uranus.transition.common.dto;

import lombok.Data;

/**
 * @author tellxp@github.com
 * @date 2019/4/29 18:17
 */
@Data
public class Wgs84CoordinateDTO {
  /** 纬度 */
  private Double latitude;

  /** 经度 */
  private Double longitude;

  /** 地理高度 */
  private Double altitude;


}
