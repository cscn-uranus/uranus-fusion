package com.uranus.transition.common.asterix.uap.cncat003;

import com.uranus.transition.common.asterix.uap.shared.datainfo.*;
import com.uranus.transition.common.asterix.uap.shared.military.MilitaryEmergencyStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.military.MilitaryIdentificationStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.track.status.EmergencyStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.track.status.SpiStatusEnum;
import lombok.Data;

/**
 * CAAC MH 4008 CAT003 I003/020
 *
 * @author tellxp@github.com
 * @date 2019/6/26
 */
@Data
public class TargetReportInformation {

  /**
   * TYP
   *
   * <p>位8 (TYP) =O 缺省 =1 航迹
   */
  private ReportDataTypeEnum reportDataType;

  /**
   * SIM
   *
   * <p>位7 (SIM) =O 实际目标 =1 模拟目标
   */
  private TargetTypeEnum targetType;

  /**
   * SSR/PRI
   *
   * <p>位6/5 (SSR/PRI) =00 无检测值 =01 一次雷达综合航迹 =10 二次雷达综合航迹 =11 合成的一次、二次雷达综合航迹
   */
  private ReportDetectionEnum reportDetectionEnum;

  /**
   * SPI
   *
   * <p>位3 (SPI) =O 缺省 =1 特殊位置识别
   */
  private SpiStatusEnum spiStatusEnum;

  /**
   * FIP
   *
   * <p>位2 (FIP) =O 缺省 =1 来自固定应答器的航迹
   */
  private ReportSourceEnum reportSourceEnum;

  /**
   * DS1/DS2
   *
   * <p>位7/6 (DS1/DS2） =00 缺省 =01 非法干扰(7500 代码） =10 无线电故障(7600 代码） =11 紧急情况(7700 代码）
   */
  private EmergencyStatusEnum emergencyStatusEnum;

  /**
   * ME
   *
   * <p>位5 (ME)=O 缺省 =1 军事紧急情况
   */
  private MilitaryEmergencyStatusEnum militaryEmergencyStatusEnum;

  /**
   * MI
   *
   * <p>位4 {MI) =O 缺省 =1 军事识别
   */
  private MilitaryIdentificationStatusEnum militaryIdentificationStatusEnum;

  /**
   * PI
   *
   * <p>位3 (PI)=O 缺省 =1 与飞行计划相关
   */
  private CorrelatedStatusEnum flightPlanCorrelatedStatusEnum;
}
