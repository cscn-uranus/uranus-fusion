package com.uranus.transition.common.asterix.uap.flightplan;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.uap.emitter.mode3.PreEmergencyMode3;
import com.uranus.transition.common.asterix.uap.identification.SystemIdentification;
import com.uranus.transition.common.asterix.uap.measure.altitude.FlightLevel;
import lombok.Data;

/**
 * FlightPlanRelatedData
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
@Data
public class FlightPlanRelatedData {

  private DataSpec dataSpec;

  private SystemIdentification fppsIdentificationTag;

  private Callsign callsign;

  private IfpsFlightId ifpsFlightId;

  private FlightCategory flightCategory;

  private TypeOfAircraft typeOfAircraft;

  private WakeTurbulenceCategory wakeTurbulenceCategory;

  private DepartureAirport departureAirport;

  private DestinationAirport destinationAirport;

  private RunwayDesignation runwayDesignation;

  private FlightLevel currentClearedFlightLevel;

  private ControlPosition currentControlPosition;

  private FlightPlanTimeData flightPlanTimeData;

  private AircraftStand aircraftStand;

  private StandStatus standStatus;

  private StandardInstrumentDeparture standardInstrumentDeparture;

  private StandardInstrumentArrival standardInstrumentArrival;

  private PreEmergencyMode3 preEmergencyMode3;

  private PreEmergencyCallsign preEmergencyCallsign;
}
