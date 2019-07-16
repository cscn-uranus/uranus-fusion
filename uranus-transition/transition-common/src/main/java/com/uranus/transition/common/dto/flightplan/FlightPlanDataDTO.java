package com.uranus.transition.common.dto.flightplan;

import com.uranus.transition.common.asterix.uap.eucat062.FlightPlanRelatedData;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author tellxp@github.com
 * @date 2019/5/21 11:50
 *     <p>对应 FlightPlanRelatedData 的传输对象
 * @see FlightPlanRelatedData
 */
@Data
public class FlightPlanDataDTO {
  /**
   * 转换项
   *
   * <p>DRN=1 FPPS Identification Tag
   */
  private String fppsId;

  /**
   * 转换项
   *
   * <p>DRN=2 Callsign
   */
  private String callsign;

  /**
   * 转换项
   *
   * <p>DRN=3 IFPS_FLIGHT_ID
   */
  private Integer ifpsId;

  /**
   * 转换项
   *
   * <p>DRN=4 Flight Category
   *
   * @deprecated 待实现
   */
  private Object flightCategory;

  /**
   * 转换项
   *
   * <p>DRN=5 Type of Aircraft
   */
  private String aircraftType;

  /**
   * 转换项
   *
   * <p>DRN=6 Wake Turbulence Category
   */
  private String wakeTurbulenceCategory;

  /**
   * 转换项
   *
   * <p>DRN=7 Departure Airport
   */
  private String departureAerodrome;

  /**
   * 转换项
   *
   * <p>DRN=8 Destination Airport
   */
  private String destinationAerodrome;

  /**
   * 转换项
   *
   * <p>DRN=9 RunwayDesignation Designation
   */
  private String runwayDesignation;

  /**
   * 转换项
   *
   * <p>DRN=10 Current Cleared Flight Level
   */
  private Double currentClearedFlightLevel;

  /**
   * 转换项
   *
   * <p>DRN=11 Current Control Position
   *
   * @deprecated 待实现
   */
  private Object currentControlPosition;

  /**
   * 转换项
   *
   * <p>DRN=12 Time of Departure / Arrival
   *
   * <p>TYP=0 Scheduled off-block time
   */
  private LocalDateTime scheduledOffBlockTime;

  /**
   * 转换项
   *
   * <p>DRN=12 Time of Departure / Arrival
   *
   * <p>TYP=1 Estimated off-block time
   */
  private LocalDateTime estimatedOffBlockTime;

  /**
   * 转换项
   *
   * <p>DRN=12 Time of Departure / Arrival
   *
   * <p>TYP=2 Estimated take-off time
   */
  private LocalDateTime estimatedTakeOffTime;

  /**
   * 转换项
   *
   * <p>DRN=12 Time of Departure / Arrival
   *
   * <p>TYP=3 Actual off-block time
   */
  private LocalDateTime actualOffBlockTime;

  /**
   * 转换项
   *
   * <p>DRN=12 Time of Departure / Arrival
   *
   * <p>TYP=4 Predicted time at runway hold
   */
  private LocalDateTime predictedTimeAtRunwayHold;

  /**
   * 转换项
   *
   * <p>DRN=12 Time of Departure / Arrival
   *
   * <p>TYP=5 Actual time at runway hold
   */
  private LocalDateTime actualTimeAtRunwayHold;

  /**
   * 转换项
   *
   * <p>DRN=12 Time of Departure / Arrival
   *
   * <p>TYP=6 Actual line-up time
   */
  private LocalDateTime actualLineUpTime;

  /**
   * 转换项
   *
   * <p>DRN=12 Time of Departure / Arrival
   *
   * <p>TYP=7 Actual take-off time
   */
  private LocalDateTime actualTakeOffTime;

  /**
   * 转换项
   *
   * <p>DRN=12 Time of Departure / Arrival
   *
   * <p>TYP=8 Estimated time of arrival
   */
  private LocalDateTime estimatedTimeOfArrival;

  /**
   * 转换项
   *
   * <p>DRN=12 Time of Departure / Arrival
   *
   * <p>TYP=9 Predicted landing time
   */
  private LocalDateTime predictedLandingTime;

  /**
   * 转换项
   *
   * <p>DRN=12 Time of Departure / Arrival
   *
   * <p>TYP=10 Actual landing time
   */
  private LocalDateTime actualLandingTime;

  /**
   * 转换项
   *
   * <p>DRN=12 Time of Departure / Arrival
   *
   * <p>TYP=11 Actual time off runway
   */
  private LocalDateTime actualTimeOffRunway;

  /**
   * 转换项
   *
   * <p>DRN=12 Time of Departure / Arrival
   *
   * <p>TYP=12 Predicted time to gate
   */
  private LocalDateTime predictedTimeToGate;

  /**
   * 转换项
   *
   * <p>DRN=12 Time of Departure / Arrival
   *
   * <p>TYP=13 Actual on-block time
   */
  private LocalDateTime actualInBlockTime;

  /**
   * 转换项
   *
   * <p>DRN=13 Aircraft Stand
   *
   */
  private String aircraftStand;

  /**
   * 转换项
   *
   * <p>DRN=14 Stand Status
   *
   * @deprecated 待实现
   */
  private Object standStatus;

  /**
   * 转换项
   *
   * <p>DRN=15 Standard Instrument Departure
   *
   */
  private String standardInstrumentDeparture;

  /**
   * 转换项
   *
   * <p>DRN=16 Standard Instrument Arrival
   *
   */
  private String standardInstrumentArrival;

  /**
   * 转换项
   *
   * <p>DRN=17 Pre-Emergency Mode 3/A
   *
   */
  private String preEmergencyMode3Code;

  /**
   * 转换项
   *
   * <p>DRN=18 Pre-Emergency Callsign
   *
   */
  private String preEmergencyCallsign;
}
