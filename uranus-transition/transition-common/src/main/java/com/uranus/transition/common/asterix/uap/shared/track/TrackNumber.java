package com.uranus.transition.common.asterix.uap.shared.track;

import lombok.Data;

/**
 * TrackNumber
 *
 * <p>Data Item I062/040, Track Number
 *
 * Definition : Identification of a track
 *
 * Format : Two-Octet
 * fixed length data item
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
@Data
public class TrackNumber {

  /**
   * bits 16/1
   *
   * Track Number
   */
  private Integer number;
}
