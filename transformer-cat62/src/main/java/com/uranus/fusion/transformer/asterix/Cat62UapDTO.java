package com.uranus.fusion.transformer.asterix;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uranus.fusion.transformer.asterix.aircraft.AircraftDerivedData;
import com.uranus.fusion.transformer.asterix.aircraft.AircraftDerivedDataMapper;
import com.uranus.fusion.transformer.asterix.aircraft.identity.TargetIdentification;
import com.uranus.fusion.transformer.asterix.aircraft.identity.TargetIdentificationEnum;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode2.Mode2Code;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode2.Mode2CodeMapper;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode3.CodeChangeStatusEnum;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode3.CodeGarbledStatusEnum;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode3.CodeValidatedStatusEnum;

import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode3.Mode3Code;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode5.Mode5AndExtendedMode1Data;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode5.Mode5AndExtendedMode1DataMapper;
import com.uranus.fusion.transformer.asterix.flightplan.FlightPlanRelatedData;
import com.uranus.fusion.transformer.asterix.flightplan.FlightPlanRelatedDataMapper;
import com.uranus.fusion.transformer.asterix.measure.*;
import com.uranus.fusion.transformer.asterix.message.accuracy.EstimatedAccuracy;
import com.uranus.fusion.transformer.asterix.message.accuracy.EstimatedAccuracyMapper;
import com.uranus.fusion.transformer.asterix.message.spec.FieldSpec;
import com.uranus.fusion.transformer.asterix.sensor.MeasuredFlightLevelMapper;
import com.uranus.fusion.transformer.asterix.sensor.RateOfClimbOrDescentMapper;
import com.uranus.fusion.transformer.asterix.sensor.TrackBarometricAltitudeMapper;
import com.uranus.fusion.transformer.asterix.sensor.TrackGeometricAltitudeMapper;
import com.uranus.fusion.transformer.asterix.sensor.info.MeasuredInformation;
import com.uranus.fusion.transformer.asterix.sensor.info.MeasuredInformationMapper;
import com.uranus.fusion.transformer.asterix.track.ComposedTrackNumber;
import com.uranus.fusion.transformer.asterix.track.ComposedTrackNumberMapper;
import com.uranus.fusion.transformer.asterix.track.TrackNumber;
import com.uranus.fusion.transformer.asterix.track.TrackNumberMapper;
import com.uranus.fusion.transformer.asterix.track.dataage.TrackDataAgeStatus;
import com.uranus.fusion.transformer.asterix.track.dataage.TrackDataAgeStatusMapper;
import com.uranus.fusion.transformer.asterix.track.movement.ModeOfMovement;
import com.uranus.fusion.transformer.asterix.track.movement.ModeOfMovementMapper;
import com.uranus.fusion.transformer.asterix.track.status.TrackStatus;
import com.uranus.fusion.transformer.asterix.track.status.TrackStatusMapper;
import com.uranus.fusion.transformer.asterix.track.updateage.TrackUpdateAgeStatus;
import com.uranus.fusion.transformer.asterix.track.updateage.TrackUpdateAgeStatusMapper;
import com.uranus.fusion.transformer.asterix.vehicle.*;

import java.io.Serializable;
import java.time.LocalTime;

public class Cat62UapDTO implements Serializable {
  private Integer category;

  private Integer length;

  @JsonIgnore
  private FieldSpec fieldSpec;

  // F1
  // Data Item I062/010, Data Source Identifier
  private SystemIdentifier dataSourceIdentifier;

  // F2
  // Spare

  // F3
  // Data Item I062/015, Service Identification
  private ServiceIdentifier serviceIdentification;

  // F4
  // Data Item I062/070, Time Of Track Information
  private TimeOfTrack timeOfTrack;

  // F5
  // Calculated Track Position (WGS-84)
  private Wgs84Position wgs84Position;

  // F6
  // Calculated Track Position (Cartesian)
  private CartesianPosition cartesianPosition;

  // F7
  // Calculated Track Velocity (Cartesian)
  private CartesianVelocity cartesianVelocity;

  // F8
  // Calculated Acceleration (Cartesian)
  private CartesianAcceleration cartesianAcceleration;

  // F9
  // Track Mode 3/A Code
  private Mode3Code mode3Code;

  // F10
  // Target Identification
  private TargetIdentification targetIdentification;

  // F11
  // Aircraft Derived Data
  private AircraftDerivedData aircraftDerivedData;

  // F12
  // Track Number
  private TrackNumber trackNumber;

  // F13
  // Track Status
  private TrackStatus trackStatus;

  // F14
  // System Track Update Ages
  private TrackUpdateAgeStatus trackUpdateAgeStatus;

  // F15
  // Mode of Movement
  private ModeOfMovement modeOfMovement;

  // F16
  // Track Data Ages
  private TrackDataAgeStatus trackDataAgeStatus;

  // F17
  // Measured Flight Level
  private FlightLevel measuredFlightLevel;

  // F18
  // Calculated Track Geometric Altitude
  private GeometricAltitude trackGeometricAltitude;

  // F19
  // Calculated Track Barometric Altitude
  private BarometricAltitude trackBarometricAltitude;

  // F20
  // Calculated Rate Of Climb/Descent
  private RateOfClimbOrDescent rateOfClimbOrDescent;

  // F21
  // Flight Plan Related Data
  private FlightPlanRelatedData flightPlanRelatedData;

  // F22
  // Target Size & Orientation
  private TargetSizeAndOrientation targetSizeAndOrientation;

  // F23
  // Vehicle Fleet Identification
  private VehicleFleetIdentification vehicleFleetIdentification;

  // F24
  // Mode 5 Data reports & Extended Mode 1 Code
  private Mode5AndExtendedMode1Data mode5AndExtendedMode1Data;

  // F25
  // Track Mode 2 Code
  private Mode2Code mode2Code;

  // F26
  // Composed Track Number
  private ComposedTrackNumber composedTrackNumber;

  // F27
  // Estimated Accuracies
  private EstimatedAccuracy estimatedAccuracy;

  // F28
  // Measured Information
  private MeasuredInformation measuredInformation;

  public Integer getCategory() {
    return category;
  }

  public void setCategory(Integer category) {
    this.category = category;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public FieldSpec getFieldSpec() {
    return fieldSpec;
  }

  public void setFieldSpec(FieldSpec fieldSpec) {
    this.fieldSpec = fieldSpec;
  }

  public SystemIdentifier getDataSourceIdentifier() {
    return dataSourceIdentifier;
  }

  public void setDataSourceIdentifier(SystemIdentifier dataSourceIdentifier) {
    this.dataSourceIdentifier = dataSourceIdentifier;
  }

  public ServiceIdentifier getServiceIdentification() {
    return serviceIdentification;
  }

  public void setServiceIdentification(ServiceIdentifier serviceIdentification) {
    this.serviceIdentification = serviceIdentification;
  }

  public TimeOfTrack getTimeOfTrack() {
    return timeOfTrack;
  }

  public void setTimeOfTrack(TimeOfTrack timeOfTrack) {
    this.timeOfTrack = timeOfTrack;
  }

  public Wgs84Position getWgs84Position() {
    return wgs84Position;
  }

  public void setWgs84Position(Wgs84Position wgs84Position) {
    this.wgs84Position = wgs84Position;
  }

  public CartesianPosition getCartesianPosition() {
    return cartesianPosition;
  }

  public void setCartesianPosition(CartesianPosition cartesianPosition) {
    this.cartesianPosition = cartesianPosition;
  }

  public CartesianVelocity getCartesianVelocity() {
    return cartesianVelocity;
  }

  public void setCartesianVelocity(CartesianVelocity cartesianVelocity) {
    this.cartesianVelocity = cartesianVelocity;
  }

  public CartesianAcceleration getCartesianAcceleration() {
    return cartesianAcceleration;
  }

  public void setCartesianAcceleration(CartesianAcceleration cartesianAcceleration) {
    this.cartesianAcceleration = cartesianAcceleration;
  }

  public Mode3Code getMode3Code() {
    return mode3Code;
  }

  public void setMode3Code(Mode3Code mode3Code) {
    this.mode3Code = mode3Code;
  }

  public TargetIdentification getTargetIdentification() {
    return targetIdentification;
  }

  public void setTargetIdentification(TargetIdentification targetIdentification) {
    this.targetIdentification = targetIdentification;
  }

  public AircraftDerivedData getAircraftDerivedData() {
    return aircraftDerivedData;
  }

  public void setAircraftDerivedData(AircraftDerivedData aircraftDerivedData) {
    this.aircraftDerivedData = aircraftDerivedData;
  }

  public TrackNumber getTrackNumber() {
    return trackNumber;
  }

  public void setTrackNumber(TrackNumber trackNumber) {
    this.trackNumber = trackNumber;
  }

  public TrackStatus getTrackStatus() {
    return trackStatus;
  }

  public void setTrackStatus(TrackStatus trackStatus) {
    this.trackStatus = trackStatus;
  }

  public TrackUpdateAgeStatus getTrackUpdateAgeStatus() {
    return trackUpdateAgeStatus;
  }

  public void setTrackUpdateAgeStatus(TrackUpdateAgeStatus trackUpdateAgeStatus) {
    this.trackUpdateAgeStatus = trackUpdateAgeStatus;
  }

  public ModeOfMovement getModeOfMovement() {
    return modeOfMovement;
  }

  public void setModeOfMovement(ModeOfMovement modeOfMovement) {
    this.modeOfMovement = modeOfMovement;
  }

  public TrackDataAgeStatus getTrackDataAgeStatus() {
    return trackDataAgeStatus;
  }

  public void setTrackDataAgeStatus(TrackDataAgeStatus trackDataAgeStatus) {
    this.trackDataAgeStatus = trackDataAgeStatus;
  }

  public FlightLevel getMeasuredFlightLevel() {
    return measuredFlightLevel;
  }

  public void setMeasuredFlightLevel(FlightLevel measuredFlightLevel) {
    this.measuredFlightLevel = measuredFlightLevel;
  }

  public GeometricAltitude getTrackGeometricAltitude() {
    return trackGeometricAltitude;
  }

  public void setTrackGeometricAltitude(GeometricAltitude trackGeometricAltitude) {
    this.trackGeometricAltitude = trackGeometricAltitude;
  }

  public BarometricAltitude getTrackBarometricAltitude() {
    return trackBarometricAltitude;
  }

  public void setTrackBarometricAltitude(BarometricAltitude trackBarometricAltitude) {
    this.trackBarometricAltitude = trackBarometricAltitude;
  }

  public RateOfClimbOrDescent getRateOfClimbOrDescent() {
    return rateOfClimbOrDescent;
  }

  public void setRateOfClimbOrDescent(RateOfClimbOrDescent rateOfClimbOrDescent) {
    this.rateOfClimbOrDescent = rateOfClimbOrDescent;
  }

  public FlightPlanRelatedData getFlightPlanRelatedData() {
    return flightPlanRelatedData;
  }

  public void setFlightPlanRelatedData(FlightPlanRelatedData flightPlanRelatedData) {
    this.flightPlanRelatedData = flightPlanRelatedData;
  }

  public TargetSizeAndOrientation getTargetSizeAndOrientation() {
    return targetSizeAndOrientation;
  }

  public void setTargetSizeAndOrientation(TargetSizeAndOrientation targetSizeAndOrientation) {
    this.targetSizeAndOrientation = targetSizeAndOrientation;
  }

  public VehicleFleetIdentification getVehicleFleetIdentification() {
    return vehicleFleetIdentification;
  }

  public void setVehicleFleetIdentification(VehicleFleetIdentification vehicleFleetIdentification) {
    this.vehicleFleetIdentification = vehicleFleetIdentification;
  }

  public Mode5AndExtendedMode1Data getMode5AndExtendedMode1Data() {
    return mode5AndExtendedMode1Data;
  }

  public void setMode5AndExtendedMode1Data(Mode5AndExtendedMode1Data mode5AndExtendedMode1Data) {
    this.mode5AndExtendedMode1Data = mode5AndExtendedMode1Data;
  }

  public Mode2Code getMode2Code() {
    return mode2Code;
  }

  public void setMode2Code(Mode2Code mode2Code) {
    this.mode2Code = mode2Code;
  }

  public ComposedTrackNumber getComposedTrackNumber() {
    return composedTrackNumber;
  }

  public void setComposedTrackNumber(ComposedTrackNumber composedTrackNumber) {
    this.composedTrackNumber = composedTrackNumber;
  }

  public EstimatedAccuracy getEstimatedAccuracy() {
    return estimatedAccuracy;
  }

  public void setEstimatedAccuracy(EstimatedAccuracy estimatedAccuracy) {
    this.estimatedAccuracy = estimatedAccuracy;
  }

  public MeasuredInformation getMeasuredInformation() {
    return measuredInformation;
  }

  public void setMeasuredInformation(MeasuredInformation measuredInformation) {
    this.measuredInformation = measuredInformation;
  }
}
