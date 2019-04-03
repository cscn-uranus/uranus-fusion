package com.uranus.fusion.transformer.asterix.sensor.info;

import com.uranus.fusion.transformer.asterix.track.status.type.TargetTypeEnum;

/**
 * ReportStatus
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class ReportStatus {

  private ReportDetectionEnum reportDetectionEnum;
  private TargetTypeEnum targetTypeEnum;
  private ReportSourceEnum reportSourceEnum;
  private ReportTestEnum reportTestEnum;

  public ReportDetectionEnum getReportDetectionEnum() {
    return reportDetectionEnum;
  }

  public void setReportDetectionEnum(
      ReportDetectionEnum reportDetectionEnum) {
    this.reportDetectionEnum = reportDetectionEnum;
  }

  public TargetTypeEnum getTargetTypeEnum() {
    return targetTypeEnum;
  }

  public void setTargetTypeEnum(TargetTypeEnum targetTypeEnum) {
    this.targetTypeEnum = targetTypeEnum;
  }

  public ReportSourceEnum getReportSourceEnum() {
    return reportSourceEnum;
  }

  public void setReportSourceEnum(ReportSourceEnum reportSourceEnum) {
    this.reportSourceEnum = reportSourceEnum;
  }

  public ReportTestEnum getReportTestEnum() {
    return reportTestEnum;
  }

  public void setReportTestEnum(ReportTestEnum reportTestEnum) {
    this.reportTestEnum = reportTestEnum;
  }
}
