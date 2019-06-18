package com.uranus.transition.common.asterix.uap.track;

import lombok.Data;

/**
 * TimeOfTrack
 *
 * <p>Data Item I062/070, Time Of Track Information
 *
 * <p>Definition : Absolute time stamping of the information provided in the track message, in the
 * form of elapsed time since last midnight, expressed as UTC.
 *
 * <p>Format : Three-Octet fixed length data item.
 *
 * <p>NOTES
 *
 * <p>1. This is the time of the track state vector.
 *
 * <p>2. The time is reset to zero at every midnight.
 *
 * @author tellxp@github.com
 * @date 2018/11/16
 */
@Data
public class TimeOfTrack {

  /**
   * bit-16
   *
   * <p>(LSB) = 2-7 s = 1/128 s
   */
  private Double time;
}
