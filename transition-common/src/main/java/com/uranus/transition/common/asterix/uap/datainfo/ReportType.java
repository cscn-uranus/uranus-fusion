package com.uranus.transition.common.asterix.uap.datainfo;

import lombok.Data;

/**
 * ReportType
 *
 * <p>Data Item I062/340, Measured Information
 *
 * Structure of Subfield # 6: Report Type
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
@Data
public class ReportType {

  /**
   * bits-8/6 (TYP) = 000 No detection = 001 Single PSR detection = 010 Single SSR detection = 011
   * SSR + PSR detection = 100 Single ModeS All-Call = 101 Single ModeS Roll-Call = 110 ModeS
   * All-Call + PSR = 111 ModeS Roll-Call +PSR
   */
  private ReportDetectionEnum reportDetectionEnum;

  /** bit-5 (SIM) = 0 Actual target report = 1 Simulated target report */
  private TargetTypeEnum targetTypeEnum;

  /**
   * bit-4 (RAB) = 0 Report from target transponder = 1 Report from field monitor (fixed
   * transponder)
   */
  private ReportSourceEnum reportSourceEnum;

  /** bit-3 (TST) = 0 Real target report = 1 Test target report */
  private ReportTestEnum reportTestEnum;
}
