package com.uranus.transition.common.asterix.uap.measure.position;

import lombok.Data;

import java.io.Serializable;

/**
 * Wgs84Position
 *
 * <p>Data Item I062/105, Calculated Position In WGS-84 Co-ordinates
 *
 * <p>Definition : Calculated Position in WGS-84 Co-ordinates with a resolution of 180/225. degrees
 *
 * <p>Format : Eight-octet fixed length Data Item
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/11
 */
@Data
public class Wgs84Position implements Serializable {

  /**
   * bits-64/33
   *
   * <p>(Latitude) In WGS.84 in two’s complement. Range -90 £ latitude £ 90 deg.
   *
   * <p>(LSB) = 180/225 degrees
   */
  private Double latitude;

  /**
   * bits-32/1
   *
   * <p>(Longitude) In WGS.84 in two’s complement. Range -180 £ longitude < 180 deg.
   *
   * <p>(LSB) = 180/225 degrees
   */
  private Double longitude;
}
