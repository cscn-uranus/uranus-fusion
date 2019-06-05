package com.uranus.transition.common.asterix;

import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.uap.accuracy.EstimatedAccuracy;
import com.uranus.transition.common.asterix.uap.aircraft.AircraftDerivedData;
import com.uranus.transition.common.asterix.uap.datainfo.MeasuredInformation;
import com.uranus.transition.common.asterix.uap.emitter.mode2.Mode2Code;
import com.uranus.transition.common.asterix.uap.emitter.mode3.Mode3Code;
import com.uranus.transition.common.asterix.uap.emitter.mode5.Mode5AndExtendedMode1;
import com.uranus.transition.common.asterix.uap.flightplan.FlightPlanRelatedData;
import com.uranus.transition.common.asterix.uap.identification.ServiceIdentification;
import com.uranus.transition.common.asterix.uap.identification.SystemIdentification;
import com.uranus.transition.common.asterix.uap.identification.TargetIdentification;
import com.uranus.transition.common.asterix.uap.measure.altitude.BarometricAltitude;
import com.uranus.transition.common.asterix.uap.measure.altitude.FlightLevel;
import com.uranus.transition.common.asterix.uap.measure.altitude.GeometricAltitude;
import com.uranus.transition.common.asterix.uap.measure.altitude.RateOfClimbOrDescent;
import com.uranus.transition.common.asterix.uap.measure.movement.ModeOfMovement;
import com.uranus.transition.common.asterix.uap.measure.position.CartesianPosition;
import com.uranus.transition.common.asterix.uap.measure.position.Wgs84Position;
import com.uranus.transition.common.asterix.uap.measure.speed.CartesianAcceleration;
import com.uranus.transition.common.asterix.uap.measure.speed.CartesianVelocity;
import com.uranus.transition.common.asterix.uap.track.ComposedTrackNumber;
import com.uranus.transition.common.asterix.uap.track.TimeOfTrack;
import com.uranus.transition.common.asterix.uap.track.TrackNumber;
import com.uranus.transition.common.asterix.uap.track.TrackStatus;
import com.uranus.transition.common.asterix.uap.track.status.SystemTrackUpdateAge;
import com.uranus.transition.common.asterix.uap.track.status.TrackDataAge;
import com.uranus.transition.common.asterix.uap.vehicle.TargetSizeAndOrientation;
import com.uranus.transition.common.asterix.uap.vehicle.VehicleFleetIdentification;
import lombok.Data;

/** @author XiaoPeng */
@Data
public class AsterixDataBlock {
  private FieldSpec fieldSpec;

  private SystemIdentification systemIdentification;
  private ServiceIdentification serviceIdentification;
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
  private SystemTrackUpdateAge systemTrackUpdateAge;
  private ModeOfMovement modeOfMovement;
  private TrackDataAge trackDataAge;
  private FlightLevel measuredFlightLevel;
  private GeometricAltitude trackGeometricAltitude;
  private BarometricAltitude trackBarometricAltitude;
  private RateOfClimbOrDescent rateOfClimbOrDescent;
  private FlightPlanRelatedData flightPlanRelatedData;
  private TargetSizeAndOrientation targetSizeAndOrientation;
  private VehicleFleetIdentification vehicleFleetIdentification;
  private Mode5AndExtendedMode1 mode5AndExtendedMode1;
  private Mode2Code mode2Code;
  private ComposedTrackNumber composedTrackNumber;
  private EstimatedAccuracy estimatedAccuracy;
  private MeasuredInformation measuredInformation;
}
