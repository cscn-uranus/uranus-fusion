package com.uranus.fusion.transformer.dto;

import com.uranus.fusion.asterix.ServiceIdentifier;
import com.uranus.fusion.asterix.SystemIdentifier;
import com.uranus.fusion.asterix.TimeOfTrack;
import com.uranus.fusion.asterix.aircraft.AircraftDerivedData;
import com.uranus.fusion.asterix.aircraft.identity.TargetIdentification;
import com.uranus.fusion.asterix.aircraft.transponder.mode2.Mode2Code;

import com.uranus.fusion.asterix.aircraft.transponder.mode3.Mode3Code;
import com.uranus.fusion.asterix.aircraft.transponder.mode5.Mode5AndExtendedMode1Data;
import com.uranus.fusion.asterix.flightplan.FlightPlanRelatedData;
import com.uranus.fusion.asterix.measure.*;
import com.uranus.fusion.asterix.vehicle.TargetSizeAndOrientation;
import com.uranus.fusion.asterix.vehicle.VehicleFleetIdentification;
import com.uranus.fusion.asterix.accuracy.EstimatedAccuracy;
import com.uranus.fusion.asterix.sensor.info.MeasuredInformation;
import com.uranus.fusion.asterix.track.ComposedTrackNumber;
import com.uranus.fusion.asterix.track.TrackNumber;
import com.uranus.fusion.asterix.track.dataage.TrackDataAgeStatus;
import com.uranus.fusion.asterix.track.movement.ModeOfMovement;
import com.uranus.fusion.asterix.track.status.TrackStatus;
import com.uranus.fusion.asterix.track.updateage.TrackUpdateAgeStatus;
import lombok.Data;

import java.io.Serializable;

@Data
public class FlightDTO implements Serializable {

  private SystemIdentifier dataSourceIdentifier;

  private ServiceIdentifier serviceIdentification;

  private TimeOfTrack timeOfTrack;

  private Wgs84Position wgs84Position;

  private CartesianPosition cartesianPosition;

  private CartesianVelocity cartesianVelocity;

  private CartesianAcceleration cartesianAcceleration;

  private Mode3Code mode3Code;

  private TargetIdentification targetIdentification;

  private AircraftDerivedData aircraftDerivedData;

  private TrackNumber trackNumber;

  private TrackStatus trackStatus;

  private TrackUpdateAgeStatus trackUpdateAgeStatus;

  private ModeOfMovement modeOfMovement;

  private TrackDataAgeStatus trackDataAgeStatus;

  private FlightLevel measuredFlightLevel;

  private GeometricAltitude trackGeometricAltitude;

  private BarometricAltitude trackBarometricAltitude;

  private RateOfClimbOrDescent rateOfClimbOrDescent;

  private FlightPlanRelatedData flightPlanRelatedData;

  private TargetSizeAndOrientation targetSizeAndOrientation;

  private VehicleFleetIdentification vehicleFleetIdentification;

  private Mode5AndExtendedMode1Data mode5AndExtendedMode1Data;

  private Mode2Code mode2Code;

  private ComposedTrackNumber composedTrackNumber;

  private EstimatedAccuracy estimatedAccuracy;

  private MeasuredInformation measuredInformation;
}
