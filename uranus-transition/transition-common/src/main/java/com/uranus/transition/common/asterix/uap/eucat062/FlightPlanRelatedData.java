package com.uranus.transition.common.asterix.uap.eucat062;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode3.PreEmergencyMode3;
import com.uranus.transition.common.asterix.uap.shared.flightplan.*;
import com.uranus.transition.common.asterix.uap.shared.identification.SystemIdentification;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.FlightLevel;
import lombok.Data;

/**
 * FlightPlanRelatedData
 *
 * <p>Data Item I062/390, Flight Plan Related Data
 *
 * <p>Definition : All flight plan related information, provided by ground-based systems.
 *
 * <p>Format : Compound Data Item, comprising a primary subfield of up to three octets, followed by
 * the indicated subfields.
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/24
 */
@Data
public class FlightPlanRelatedData {

  /**
   * Structure of Primary Subfield:
   *
   * <p>bit-24 (TAG) Subfield #1: FPPS Identification Tag = 0 Absence of Subfield #1 = 1 Presence of
   * Subfield #1
   *
   * <p>bit-23 (CSN) Subfield #2: Callsign = 0 Absence of Subfield #2 = 1 Presence of Subfield #2
   *
   * <p>bit-22 (IFI) Subfield #3: IFPS_FLIGHT_ID = 0 Absence of Subfield #3 = 1 Presence of Subfield
   * #3
   *
   * <p>bit-21 (FCT) Subfield #4: Flight Category = 0 Absence of Subfield #4 = 1 Presence of
   * Subfield #4
   *
   * <p>bit-20 (TAC) Subfield #5: Type of Aircraft = 0 Absence of Subfield #5 = 1 Presence of
   * Subfield #5
   *
   * <p>bit-19 (WTC) Subfield #6: Wake Turbulence Category = 0 Absence of Subfield #6 = 1 Presence
   * of Subfield #6
   *
   * <p>bit-18 (DEP) Subfield #7: Departure Airport = 0 Absence of Subfield #7 = 1 Presence of
   * Subfield #7
   *
   * <p>bit-17 FX Extension indicator = 0 no extension = 1 extension
   *
   * <p>bit-16 (DST) Subfield #8: Destination Airport = 0 Absence of Subfield #8 = 1 Presence of
   * Subfield #8
   *
   * <p>bit-15 (RDS) Subfield #9: Runway Designation = 0 Absence of Subfield #9 = 1 Presence of
   * Subfield #9
   *
   * <p>bit-14 (CFL) Subfield #10: Current Cleared Flight Level = 0 Absence of Subfield #10 = 1
   * Presence of Subfield #10
   *
   * <p>bit-13 (CTL) Subfield #11: Current Control Position = 0 Absence of Subfield #11 = 1 Presence
   * of Subfield #11
   *
   * <p>bit-12 (TOD) Subfield #12: Time of Departure / Arrival = 0 Absence of Subfield #12 = 1
   * Presence of Subfield #12
   *
   * <p>bit-11 (AST) Subfield #13: Aircraft Stand = 0 Absence of Subfield #13 = 1 Presence of
   * Subfield #13
   *
   * <p>bit-10 (STS) Subfield #14: Stand Status = 0 Absence of Subfield #14 = 1 Presence of Subfield
   * #14
   *
   * <p>bit-9 FX Extension indicator = 0 no extension = 1 extension
   *
   * <p>bit-8 (STD) Subfield #15: Standard Instrument Departure = 0 Absence of Subfield #15 = 1
   * Presence of Subfield #15
   *
   * <p>bit-7 (STA) Subfield #16: STandard Instrument ARrival = 0 Absence of Subfield #16 = 1
   * Presence of Subfield #16
   *
   * <p>bit-6 (PEM) Subfield #17: Pre-emergency Mode 3/A code = 0 Absence of Subfield #17 = 1
   * Presence of Subfield #17
   *
   * <p>bit-5 (PEC) Subfield #18: Pre-emergency Callsign = 0 Absence of Subfield #18 = 1 Presence of
   * Subfield #18 bits-4/2 Spare bits set to zero
   *
   * <p>bit-1 FX Extension indicator = 0 no extension = 1 extension
   */
  private DataSpec dataSpec;

  /**
   * Structure of Subfield # 1:
   *
   * <p>FPPS Identification Tag
   */
  private SystemIdentification fppsIdentificationTag;

  /**
   * Structure of Subfield # 2:
   *
   * <p>Callsign
   */
  private Callsign callsign;

  /**
   * Structure of Subfield # 3:
   *
   * <p>IFPS_FLIGHT_ID
   */
  private IfpsFlightId ifpsFlightId;

  /**
   * Structure of Subfield # 4:
   *
   * <p>Flight Category
   */
  private FlightCategory flightCategory;

  /**
   * Structure of Subfield # 5:
   *
   * <p>Type of Aircraft
   */
  private TypeOfAircraft typeOfAircraft;

  /**
   * Structure of Subfield # 6:
   *
   * <p>Wake Turbulence Category
   */
  private WakeTurbulenceCategory wakeTurbulenceCategory;

  /**
   * Structure of Subfield # 7:
   *
   * <p>Departure Airport
   */
  private DepartureAirport departureAirport;

  /**
   * Structure of Subfield # 8
   *
   * <p>Destination Airport
   */
  private DestinationAirport destinationAirport;

  /**
   * Structure of Subfield # 9:
   *
   * <p>Runway Designation
   */
  private RunwayDesignation runwayDesignation;

  /**
   * Structure of Subfield # 10:
   *
   * <p>Current Cleared Flight Level
   */
  private FlightLevel currentClearedFlightLevel;

  /**
   * Structure of Subfield # 11:
   *
   * <p>Current Control Position
   */
  private ControlPosition currentControlPosition;

  /**
   * Structure of Subfield # 12:
   *
   * <p>Time of Departure / Arrival
   */
  private FlightPlanTimeData flightPlanTimeData;

  /**
   * Structure of Subfield # 13:
   *
   * <p>Aircraft Stand
   */
  private AircraftStand aircraftStand;

  /**
   * Structure of Subfield # 14:
   *
   * <p>Stand Status
   */
  private StandStatus standStatus;

  /**
   * Structure of Subfield # 15:
   *
   * <p>Standard Instrument Departure
   */
  private StandardInstrumentDeparture standardInstrumentDeparture;

  /**
   * Structure of Subfield # 16:
   *
   * <p>Standard Instrument Arrival
   */
  private StandardInstrumentArrival standardInstrumentArrival;

  /**
   * Structure of Subfield # 17:
   *
   * <p>Pre-Emergency Mode 3/A
   */
  private PreEmergencyMode3 preEmergencyMode3;

  /**
   * Structure of Subfield # 18:
   *
   * <p>Pre-Emergency Callsign
   */
  private PreEmergencyCallsign preEmergencyCallsign;


}
