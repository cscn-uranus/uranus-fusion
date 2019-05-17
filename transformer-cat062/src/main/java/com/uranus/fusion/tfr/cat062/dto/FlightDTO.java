package com.uranus.fusion.tfr.cat062.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uranus.fusion.tfr.cat062.dto.aircraft.AircraftDataDTO;
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
  private DataIdentificationDTO dataIdentificationDTO;

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
   *
   */
  private Wgs84CoordinateDTO wgs84CoordinateDTO;

  /**
   * 合并项
   *
   * <p>FRN=6 Calculated Track Position (Cartesian)
   *
   * <p>FRN=7 Calculated Track Velocity (Cartesian)
   *
   * <p>FRN=8 Calculated Acceleration (Cartesian)
   */
  private CartesianCoordinateDTO cartesianCoordinateDTO;

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

  /** FRN=11 Aircraft Derived Data */
  private AircraftDataDTO aircraftData;

  /** TrackNumber */
  private Integer trackNumber;

  /** TrackStatus */
  private Object trackStatus;

  /** SystemTrackUpdateAge */
  private Object systemTrackUpdateAge;

  /** ModeOfMovement */
  private ModeOfMovementDTO modeOfMovement;

  /** TrackDataAge */
  private Object trackDataAge;

  /** FlightLevel */
  private Double measuredFlightLevel;

  /** BarometricAltitude */
  private Double barometricAltitude;

  /** RateOfClimbOrDescent */
  private Double rateOfClimbOrDescent;

  /** FlightPlanRelatedData */
  private Object flightPlanRelatedData;

  /** TargetSizeAndOrientation */
  private Object targetSizeAndOrientation;

  /** VehicleFleetIdentification */
  private String vehicleFleetIdentification;


  /** 气压高度 */
  private Double baroAltitude;

  /**
   * 垂直速率
   */
  private Double verticalRate;

  /** Mode5AndExtendedMode1 */

  /** Mode2Code */

  /** ComposedTrackNumber */

  /** EstimatedAccuracy */

  /** MeasuredInformation */
}
