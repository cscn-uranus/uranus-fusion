package com.uranus.transition.common.asterix.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uranus.transition.common.asterix.dto.aircraft.AircraftDataDTO;
import com.uranus.transition.common.asterix.dto.flightplan.FlightPlanDataDTO;
import com.uranus.transition.common.asterix.dto.movement.ModeOfMovementDTO;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author tellxp@github.com
 * @date 2019/4/29 17:31
 */
@Data
public class FlightDTO implements Serializable {

  /// TODO
  // Mode 5 GNSS-derived Altitude //判断首位是否为1，为1就补1，为0则不管
  // Calculated Track Barometric Altitude //判断首位是否为1，为1就补1，为0则不管
  // Last Measured Mode C Code //判断首位是否为1，为1就补1，为0则不管
  // Indicated Airspeed / Mach No //判断首位是否为1，为1就补1，为0则不管
  // Selected Altitude //判断首位是否为1，为1就补1，为0则不管
  // Final State Selected Altitude  //判断首位是否为1，为1就补1，为0则不管
  // Track Angle Rate //判断首位是否为1，为1就补1，为0则不管
  // Barometric Pressure Setting (derived from Mode S BDS 4,0) 无符号

  /**
   * 合并项
   *
   * <p>FRN=1 Data Source Identifier
   *
   * <p>FRN=3 Service Identification
   */
  private DataIdentificationDTO dataIdentification;

  /**
   * 转换项
   *
   * <p>FRN=4 Time Of Track Information
   *
   * <p>源数值为当日的UTC秒，将被转换为本地时间（UTC+8）全日期
   */
  @JsonFormat(pattern = "yyyyMMddHHmmss")
  private LocalDateTime timeOfTrack;

  /**
   * 合并项
   *
   * <p>FRN=5 Calculated Track Position (WGS-84)
   *
   * <p>FRN=18 Calculated Track Geometric Altitude
   */
  private Wgs84CoordinateDTO wgs84Coordinate;

  /**
   * 合并项
   *
   * <p>FRN=6 Calculated Track Position (Cartesian)
   *
   * <p>FRN=7 Calculated Track Velocity (Cartesian)
   *
   * <p>FRN=8 Calculated Acceleration (Cartesian)
   */
  private CartesianCoordinateDTO cartesianCoordinate;

  /**
   * 转换项
   *
   * <p>FRN=9 Track Mode 3/A Code
   *
   * <p>3/A 模式二次应答机代码
   */
  private String mode3Code;

  /**
   * 转换项
   *
   * <p>FRN=10 Target Identification
   *
   * <p>航班识别号，该字段已弃用，应该使用 Aircraft Derived Data 中的航班号或者 Flight Plan Related Data中的航班号
   */
  private String flightIdentification;

  /**
   * 转换项
   *
   * <p>FRN=11 Aircraft Derived Data
   */
  private AircraftDataDTO aircraftData;

  /**
   * 转换项
   *
   * <p>FRN=12 TrackNumber
   *
   * <p>待实现
   */
  private Integer trackNumber;

  /**
   * 融合项
   *
   * <p>FRN=13 TrackStatus
   *
   * <p>待实现
   */
  private Object trackStatus;

  /**
   * 融合项
   *
   * <p>FRN=14 System Track Update Ages
   *
   * <p>待实现
   */
  private Object systemTrackUpdateAge;

  /**
   * 转换项
   *
   * <p>FRN=15 Mode of Movement
   */
  private ModeOfMovementDTO modeOfMovement;

  /**
   * 融合项
   *
   * <p>FRN=16 Track Data Ages
   *
   * <p>待实现
   */
  private Object trackDataAge;

  /**
   * 转换项
   *
   * <p>FRN=17 Measured Flight Level
   */
  private Double measuredFlightLevel;

  /**
   * 转换项
   *
   * <p>FRN=18 Calculated Track Geometric Altitude 已经在 Wgs84CoordinateDTO 中实现
   *
   * <p>FRN=19 Calculated Track Barometric Altitude
   *
   * @see Wgs84CoordinateDTO
   */
  private Double baroAltitude;

  /**
   * 转换项
   *
   * <p>FRN=20 Calculated Rate Of Climb/Descent
   */
  private Double rateOfClimbOrDescent;

  /**
   * 转换项
   *
   * <p>FRN=21 Flight Plan Related Data
   *
   */
  private FlightPlanDataDTO flightPlanData;

  /**
   * 转换项
   *
   * <p>FRN=22 Target Size & Orientation
   */
  private TargetShapeDTO targetShape;

  /**
   * 转换项
   *
   * <p>FRN=23 Vehicle Fleet Identification
   *
   * @deprecated 待实现
   */
  private Object vehicleFleetIdentification;

  /**
   * 转换项
   *
   * <p>FRN=24 Mode 5 Data reports & Extended Mode 1 Code
   *
   * <p>待实现
   */
  private Object mode5Data;

  /**
   * 转换项
   *
   * <p>FRN=25 Track Mode 2 Code
   *
   * <p>待实现
   */
  private Object mode2Code;

  /**
   * 转换项
   *
   * <p>FRN=26 Composed Track Number
   *
   * <p>待实现
   */
  private Object composedTrackNumber;

  /**
   * 转换项
   *
   * <p>FRN=27 Estimated Accuracies
   *
   * <p>待实现
   */
  private Object estimatedAccuracy;

  /**
   * 转换项
   *
   * <p>FRN=28 Measured Information
   *
   * <p>待实现
   */
  private Object measuredInformation;
}
