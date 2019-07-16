package com.uranus.transition.common.asterix.uap.shared.datainfo;

/**
 *
 * <p>Data Item I062/340, Measured Information
 *
 * @author 肖鹏 tellxp@github.com
 *
 * @date 2018/11/15
 */
public enum ReportDetectionEnum {
  /** No detection */
  NO_DETECTION,
  /** Single PSR detection */
  SINGLE_PSR,
  /** Single SSR detection */
  SINGLE_SSR,
  /** SSR + PSR detection */
  SSR_PSR,
  /** Single ModeS All-Call */
  SINGLE_MODES_AC,
  /** Single ModeS Roll-Call */
  SINGLE_MODES_RC,
  /** ModeS All-Call + PSR */
  MODES_AC_PSR,
  /** ModeS Roll-Call +PSR */
  MODES_RC_PSR
}
