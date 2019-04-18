package com.uranus.fusion.asterix.uap.datainfo;

import lombok.Data;

/**
 * ReportType
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
@Data
public class ReportType {

  private ReportDetectionEnum reportDetectionEnum;
  private TargetTypeEnum targetTypeEnum;
  private ReportSourceEnum reportSourceEnum;
  private ReportTestEnum reportTestEnum;
}
