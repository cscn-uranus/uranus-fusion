package com.uranus.fusion.asterix.flightplan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uranus.fusion.asterix.SystemIdentifier;
import com.uranus.fusion.asterix.measure.FlightLevel;
import com.uranus.fusion.asterix.spec.DataSpec;

/**
 * FlightPlanRelatedData
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/24
 */
public class FlightPlanRelatedData {

  @JsonIgnore
  private DataSpec dataSpec;

  private SystemIdentifier FppsIdentificationTag;

  private Callsign callsign;

  private IfpsFlightId ifpsFlightId;

  private FlightCategory flightCategory;

  private AircraftType aircraftType;

  private WakeTurbulenceCategory wakeTurbulenceCategory;

  private DepartureAerodrome departureAerodrome;

  private DestinationAerodrome destinationAerodrome;

  public DestinationAerodrome getDestinationAerodrome() {
    return destinationAerodrome;
  }

  public void setDestinationAerodrome(DestinationAerodrome destinationAerodrome) {
    this.destinationAerodrome = destinationAerodrome;
  }

  private Runway runwayDesignation;

  private FlightLevel currentClearedFlightLevel;

  private ControlPosition currentControlPosition;

  private FlightPlanTimeData flightPlanTimeData;

  private AircraftStand aircraftStand;

  private StandStatus standStatus;

  private StandardInstrumentDeparture standardInstrumentDeparture;

  private StandardInstrumentArrival standardInstrumentArrival;

  private PreEmergencyMode3 preEmergencyMode3;

  private PreEmergencyCallsign preEmergencyCallsign;

  public DataSpec getDataSpec() {
    return dataSpec;
  }

  public void setDataSpec(DataSpec dataSpec) {
    this.dataSpec = dataSpec;
  }

  public SystemIdentifier getFppsIdentificationTag() {
    return FppsIdentificationTag;
  }

  public void setFppsIdentificationTag(SystemIdentifier fppsIdentificationTag) {
    FppsIdentificationTag = fppsIdentificationTag;
  }

  public Callsign getCallsign() {
    return callsign;
  }

  public void setCallsign(Callsign callsign) {
    this.callsign = callsign;
  }

  public IfpsFlightId getIfpsFlightId() {
    return ifpsFlightId;
  }

  public void setIfpsFlightId(IfpsFlightId ifpsFlightId) {
    this.ifpsFlightId = ifpsFlightId;
  }

  public FlightCategory getFlightCategory() {
    return flightCategory;
  }

  public void setFlightCategory(FlightCategory flightCategory) {
    this.flightCategory = flightCategory;
  }

  public AircraftType getAircraftType() {
    return aircraftType;
  }

  public void setAircraftType(AircraftType aircraftType) {
    this.aircraftType = aircraftType;
  }

  public WakeTurbulenceCategory getWakeTurbulenceCategory() {
    return wakeTurbulenceCategory;
  }

  public void setWakeTurbulenceCategory(WakeTurbulenceCategory wakeTurbulenceCategory) {
    this.wakeTurbulenceCategory = wakeTurbulenceCategory;
  }

  public DepartureAerodrome getDepartureAerodrome() {
    return departureAerodrome;
  }

  public void setDepartureAerodrome(DepartureAerodrome departureAerodrome) {
    this.departureAerodrome = departureAerodrome;
  }

  public Runway getRunwayDesignation() {
    return runwayDesignation;
  }

  public void setRunwayDesignation(Runway runwayDesignation) {
    this.runwayDesignation = runwayDesignation;
  }

  public FlightLevel getCurrentClearedFlightLevel() {
    return currentClearedFlightLevel;
  }

  public void setCurrentClearedFlightLevel(FlightLevel currentClearedFlightLevel) {
    this.currentClearedFlightLevel = currentClearedFlightLevel;
  }

  public ControlPosition getCurrentControlPosition() {
    return currentControlPosition;
  }

  public void setCurrentControlPosition(ControlPosition currentControlPosition) {
    this.currentControlPosition = currentControlPosition;
  }

  public FlightPlanTimeData getFlightPlanTimeData() {
    return flightPlanTimeData;
  }

  public void setFlightPlanTimeData(FlightPlanTimeData flightPlanTimeData) {
    this.flightPlanTimeData = flightPlanTimeData;
  }

  public AircraftStand getAircraftStand() {
    return aircraftStand;
  }

  public void setAircraftStand(AircraftStand aircraftStand) {
    this.aircraftStand = aircraftStand;
  }

  public StandStatus getStandStatus() {
    return standStatus;
  }

  public void setStandStatus(StandStatus standStatus) {
    this.standStatus = standStatus;
  }

  public StandardInstrumentDeparture getStandardInstrumentDeparture() {
    return standardInstrumentDeparture;
  }

  public void setStandardInstrumentDeparture(StandardInstrumentDeparture standardInstrumentDeparture) {
    this.standardInstrumentDeparture = standardInstrumentDeparture;
  }

  public StandardInstrumentArrival getStandardInstrumentArrival() {
    return standardInstrumentArrival;
  }

  public void setStandardInstrumentArrival(StandardInstrumentArrival standardInstrumentArrival) {
    this.standardInstrumentArrival = standardInstrumentArrival;
  }

  public PreEmergencyMode3 getPreEmergencyMode3() {
    return preEmergencyMode3;
  }

  public void setPreEmergencyMode3(PreEmergencyMode3 preEmergencyMode3) {
    this.preEmergencyMode3 = preEmergencyMode3;
  }

  public PreEmergencyCallsign getPreEmergencyCallsign() {
    return preEmergencyCallsign;
  }

  public void setPreEmergencyCallsign(PreEmergencyCallsign preEmergencyCallsign) {
    this.preEmergencyCallsign = preEmergencyCallsign;
  }
}
