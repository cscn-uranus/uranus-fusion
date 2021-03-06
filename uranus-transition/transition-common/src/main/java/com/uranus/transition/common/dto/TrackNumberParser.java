package com.uranus.transition.common.dto;

import com.uranus.transition.common.asterix.uap.shared.track.TrackNumber;

/**
 * @author tellxp@github.com
 * @date 2019/5/24 18:05
 */

public class TrackNumberParser {
  public static Integer parse(TrackNumber trackNumber) {
    if (null==trackNumber) {
      return null;
    }
    return trackNumber.getNumber();
  }
}
