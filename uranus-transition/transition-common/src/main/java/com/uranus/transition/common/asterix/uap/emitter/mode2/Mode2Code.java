package com.uranus.transition.common.asterix.uap.emitter.mode2;

import lombok.Data;

/**
 * Mode2Code
 *
 * <p>Data Item I062/120, Track Mode 2 Code
 *
 * Definition : Mode 2 code associated to the track
 *
 * Format
 * : Two-Octet fixed length data item.
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/14
 */
@Data
public class Mode2Code {

  /**
   * bits-12/1 Mode-2 code in octal representation
   */
  private String code;
}
