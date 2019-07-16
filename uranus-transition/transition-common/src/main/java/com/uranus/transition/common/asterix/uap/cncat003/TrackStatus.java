package com.uranus.transition.common.asterix.uap.cncat003;

import com.uranus.transition.common.asterix.uap.shared.datainfo.CorrelatedStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.flightplan.FlightPlanStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.measure.movement.VerticalMoveEnum;
import com.uranus.transition.common.asterix.uap.shared.track.TrackAccuracy;
import com.uranus.transition.common.asterix.uap.shared.track.status.*;
import lombok.Data;

/**
 * @author tellxp@github.com
 * @date 2019/6/26
 */
@Data
public class TrackStatus {
  /**
   * I003/170
   *
   * <p>CO
   */
  private TrackCertaintyStatusEnum trackCertaintyStatusEnum;

  /** SIM {@link TrackStatus#sensorSourceStatusEnum} */
  private SensorSourceStatusEnum sensorSourceStatusEnum;
  /**
   * MH 4008 I003/170
   *
   * <p>位6 (M) =O 缺省 =1 目标机动
   */
  private ManeuverStatusEnum maneuverStatusEnum;
  /**
   * MH 4008 I003/170
   *
   * <p>位5 (D) =O 缺省 =1 航迹与点迹难以相关
   */
  private CorrelatedStatusEnum trackCorrelatedStatusEnum;

  /**
   * MH 4008 I003/170
   *
   * <p>T =O 缺省 =1 航迹最后报告
   */
  private LastMessageStatusEnum lastMessageStatusEnum;
  /**
   * MH 4008 I003/170
   *
   * <p>位2 (H) =O 缺省 =1 航迹处于交出状态
   */
  private FlightPlanStatusEnum handOverStatus;

  /**
   * MH 4008 I003/170
   *
   * <p>位8 (ARR) =O 缺省 =1 降落
   */
  private FlightPlanStatusEnum arrivalStatus;

  /**
   * MH 4008 I003/170
   *
   * <p>位7 (DEP) =O 缺省 =1 起飞
   */
  private FlightPlanStatusEnum departureStatus;

  /**
   * MH 4008 I003/170
   *
   * <p>位6 {C) =O 缺省 =1 冲突告警
   */
  private AlertStatusEnum conflictAlert;

  /**
   * MH 4008 I003/170
   *
   * <p>位5 (H) =O 缺省 =1 最低安全高度告警
   */
  private AlertStatusEnum minimumSafeAltitudeWarning;

  /**
   * MH 4008 I003/170
   *
   * <p>位4 (R) =O 缺省 =1 进人限制区告警
   */
  private AlertStatusEnum dangerAreaInWarning;

  /**
   * MH 4008 I003/170
   *
   * <p>位3 (K) =O 缺省 =1 偏航告警
   */
  private AlertStatusEnum offCourseAlert;

  /**
   * MH 4008 I003/170
   *
   * <p>位2 (A) =O 缺省 =1 航迹处于接收状态
   */
  private FlightPlanStatusEnum handInStatus;

  /**
   * MH 4008 I003/170
   *
   * <p>位8 (B) =O 缺省 =1 外推
   */
  private ExtrapolationStatusEnum extrapolationStatusEnum;

  /**
   * MH 4008 I003/170
   *
   * <p>位7/6 (AC) =00 缺省 =01 偏高 =10 偏低 =11 当前不用
   */
  private TrackVerticalStatusEnum trackVerticalStatusEnum;

  /**
   * MH 4008 I003/170
   *
   * <p>位5/4 (ST) =00 缺省 =01 平飞 =10 上升 =11 下滑
   */
  private VerticalMoveEnum verticalMoveEnum;


}
