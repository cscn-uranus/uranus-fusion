package com.uranus.transition.common.asterix.uap.emitter.mode3;

/**
 * CodeSourceTypeEnum
 *
 * <p>Data Item I062/340, Measured Information
 *
 * Structure of Subfield # 5: Last Measured Mode 3/A
 * Code
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
public enum CodeSourceTypeEnum {
  /** MODE 3/A code as derived from the reply of the transponder, */
  DERIVED,
  /** Smoothed MODE 3/A code as provided by a sensor local tracker. */
  SMOOTHED
}
