package com.uranus.transition.common.dto.aircraft;

import com.uranus.transition.common.dto.Wgs84CoordinateDTO;
import lombok.Data;

/**
 * FRN=11 Aircraft Derived Data
 *
 * @author tellxp@github.com
 * @date 2019/4/29 18:24
 */
@Data
public class AircraftDataDTO {

  /**
   * 转换项
   *
   * <p>DRN=1 Target Address
   */
  private String targetAddress;

  /**
   * 转换项
   *
   * <p>DRN=2 Target Identification
   */
  private String targetIdentification;

  /**
   * 转换项
   *
   * <p>DRN=3 Magnetic Heading
   */
  private Double magneticHeading;

  /**
   * 转换项
   *
   * <p>DRN=4 Indicated Airspeed / Mach No
   *
   * <p>DRN=26 Indicated Airspeed
   *
   * <p>当存在 DRN=26 数据项时，以 DRN=26 数据项为准
   */
  private Double indicatedAirspeed;

  /**
   * 转换项
   *
   * <p>DRN=4 Indicated Airspeed / Mach No
   *
   * <p>DRN=27 Mach Number
   *
   * <p>当存在 DRN=27 数据项时，以 DRN=27 数据项为准
   */
  private Double machNumber;

  /**
   * 转换项
   *
   * <p>DRN=5 True Airspeed
   */
  private Double trueAirspeed;

  /**
   * 转换项
   *
   * <p>DRN=6 Selected Altitude
   */
  private Double selectedAltitude;

  /**
   * 转换项
   *
   * <p>DRN=7 Final State Selected Altitude
   */
  private Double finalStateSelectedAltitude;

  /**
   * 转换项
   *
   * <p>DRN=8 Trajectory Intent Status
   *
   * <p>待完成
   */
  private Object trajectoryIntentStatus;

  /**
   * 转换项
   *
   * <p>DRN=9 Trajectory Intent Data
   *
   * <p>待完成
   */
  private Object trajectoryIntentData;

  /**
   * 转换项
   *
   * <p>DRN=10 Communications/ACAS Capability and Flight Status reported by Mode-S
   *
   * <p>待完成
   */
  private Object commCapabilityAndStatusByModeSel;

  /**
   * 转换项
   *
   * <p>DRN=11 Status reported by ADS-B
   *
   * <p>待完成
   */
  private Object statusByAdsb;

  /**
   * 转换项
   *
   * <p>DRN=12 ACAS Resolution Advisory Report
   *
   * <p>待完成
   */
  private Object acasResolutionAdvisoryReport;

  /**
   * 转换项
   *
   * <p>DRN=13 Barometric Vertical Rate
   */
  private Double baroVerticalRate;

  /**
   * 转换项
   *
   * <p>DRN=14 Geometric Vertical Rate
   */
  private Double geoVerticalRate;

  /**
   * 转换项
   *
   * <p>DRN=15 Roll Angle
   */
  private Double rollAngle;

  /**
   * 转换项
   *
   * <p>DRN=16 Track Angle Rate
   */
  private Double trackAngleRate;

  /**
   * 转换项
   *
   * <p>DRN=17 Track Angle
   */
  private Double trackAngle;

  /**
   * 转换项
   *
   * <p>DRN=18 Ground Speed
   */
  private Double groundSpeed;

  /**
   * 转换项
   *
   * DRN=19 Velocity Uncertainty
   *
   * 待完成
   */
  private Object velocityUncertainty;

  /**
   * 转换项
   *
   * DRN=20 Met Data
   *
   * 待完成
   */
  private Object metData;

  /**
   * 转换项
   *
   * DRN=21 Emitter Category
   *
   * 按照枚举型进行转换
   */
  private String emitterCategory;

  /**
   * 合并项
   *
   * DRN=22 Position
   *
   * DRN=23 Geometric Altitude
   */
  private Wgs84CoordinateDTO wgs84Coordinate;

  /**
   * 转换项
   *
   * DRN=24 Position Uncertainty
   */
  private Object positionUncertainty;

  /**
   * 转换项
   *
   * DRN=25 MODE S MB DATA
   *
   * 待完成
   */
  private Object modeselMbData;

  /**
   * 转换项
   *
   * DRN=28 Barometric Pressure Setting (derived from Mode S BDS 4,0)
   *
   */
  private Double baroPressureSetting;
}
