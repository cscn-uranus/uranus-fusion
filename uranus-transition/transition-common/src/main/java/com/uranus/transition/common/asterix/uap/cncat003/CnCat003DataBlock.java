package com.uranus.transition.common.asterix.uap.cncat003;

import com.uranus.transition.common.asterix.AsterixDataBlock;
import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode2.Mode2Code;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode3.Mode3Code;
import com.uranus.transition.common.asterix.uap.shared.flightplan.*;
import com.uranus.transition.common.asterix.uap.shared.identification.SystemIdentification;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.FlightLevel;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.RateOfClimbOrDescent;
import com.uranus.transition.common.asterix.uap.shared.measure.position.CartesianPosition;
import com.uranus.transition.common.asterix.uap.shared.measure.speed.PolarVelocity;
import com.uranus.transition.common.asterix.uap.shared.track.TimeOfTrack;
import com.uranus.transition.common.asterix.uap.shared.track.TrackAccuracy;
import com.uranus.transition.common.asterix.uap.shared.track.TrackNumber;
import lombok.Data;

/**
 * @author tellxp@github.com
 * @date 2019/6/25
 */
@Data
public class CnCat003DataBlock implements AsterixDataBlock {
  @Override
  public FieldSpec fieldSpec() {
    return fieldSpec;
  }

  private FieldSpec fieldSpec;
  /**
   * I003/010
   *
   * 数据源标识
   */
  private SystemIdentification datasourceIdentifier;

  /**
   * I003/020
   *
   * 目标报告描述
   */
  private TargetReportInformation targetReportInformation;

  /**
   * I003/240
   *
   * <p>飞机呼号/批号
   */
  private Callsign callsign;
  /**
   * I003/161
   *
   * <p>航迹号
   */
  private TrackNumber trackNumber;

  /**
   * I003/042
   *
   * <p>目标位置
   */
  private CartesianPosition cartesianPosition;

  /**
   * I003/090
   *
   * <p>模式C高度
   */
  private FlightLevel modecFlightLevel;

  /**
   * I003/091
   *
   * <p>计划高度
   */
  private FlightLevel planedFlightLevel;


  /**
   * I003/092
   *
   * <p>许可高度
   */
  private FlightLevel clearedFlightLevel;

  /**
   * I003/170
   */
  private TrackStatus trackStatus;
  /**
   * MH 4008 I003/020
   *
   * 用极坐标表示的计算航迹地速
   */
  private PolarVelocity polarVelocity;
  /**
   * I003/070
   *
   * <p>模式3代码
   */
  private Mode3Code mode3Code;

  /**
   * MH 4003 I003/210
   *
   * <p>相对航迹质量
   */
  private TrackAccuracy trackAccuracy;
  /**
   * I003/094
   *
   * <p>飞行员报告高度
   */
  private FlightLevel reportedFlightLevel;
  /**
   * I003/141
   *
   * <p>时间标记
   */
  private TimeOfTrack timeOfTrack;
  /**
   * I003/140
   *
   * <p>爬升/下降率
   */
  private RateOfClimbOrDescent rateOfClimbOrDescent;
  /**
   * I003/050
   *
   * <p>模式2代码
   */
  private Mode2Code mode2Code;


  /**
   * I003/181
   *
   * 降落机场
   */
  private DestinationAirport destinationAirport;

  /**
   * MH 4008 I003/180
   *
   * 位8-2 管制权限的ASCII
   */
  private ControlledStatus controlledStatus;


  /**
   * I003/182
   *
   * 尾流指示符
   */
  private WakeTurbulenceCategory wakeTurbulenceCategory;








}
