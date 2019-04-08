package com.uranus.fusion.transformer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.uranus.fusion.common.asterix.ServiceIdentifier;
import com.uranus.fusion.common.asterix.SystemIdentifier;
import com.uranus.fusion.common.asterix.TimeOfTrack;
import com.uranus.fusion.common.asterix.aircraft.AircraftDerivedData;
import com.uranus.fusion.common.asterix.aircraft.identity.TargetIdentification;
import com.uranus.fusion.common.asterix.aircraft.transponder.mode2.Mode2Code;

import com.uranus.fusion.common.asterix.aircraft.transponder.mode3.Mode3Code;
import com.uranus.fusion.common.asterix.aircraft.transponder.mode5.Mode5AndExtendedMode1Data;
import com.uranus.fusion.common.asterix.flightplan.FlightPlanRelatedData;
import com.uranus.fusion.common.asterix.measure.*;
import com.uranus.fusion.common.asterix.vehicle.TargetSizeAndOrientation;
import com.uranus.fusion.common.asterix.vehicle.VehicleFleetIdentification;
import com.uranus.fusion.common.asterix.message.accuracy.EstimatedAccuracy;
import com.uranus.fusion.common.asterix.message.spec.FieldSpec;
import com.uranus.fusion.common.asterix.sensor.info.MeasuredInformation;
import com.uranus.fusion.common.asterix.track.ComposedTrackNumber;
import com.uranus.fusion.common.asterix.track.TrackNumber;
import com.uranus.fusion.common.asterix.track.dataage.TrackDataAgeStatus;
import com.uranus.fusion.common.asterix.track.movement.ModeOfMovement;
import com.uranus.fusion.common.asterix.track.status.TrackStatus;
import com.uranus.fusion.common.asterix.track.updateage.TrackUpdateAgeStatus;
import lombok.Data;

import java.io.Serializable;

@Data
public class FlightDTO implements Serializable {
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
}
