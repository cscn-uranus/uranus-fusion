package com.uranus.fusion.asterix;

import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.uap.accuracy.EstimatedAccuracy;
import com.uranus.fusion.asterix.uap.aircraft.AircraftDerivedData;
import com.uranus.fusion.asterix.uap.datainfo.MeasuredInformation;
import com.uranus.fusion.asterix.uap.emitter.mode2.Mode2Code;
import com.uranus.fusion.asterix.uap.emitter.mode3.Mode3Code;
import com.uranus.fusion.asterix.uap.emitter.mode5.Mode5AndExtendedMode1Data;
import com.uranus.fusion.asterix.uap.flightplan.FlightPlanRelatedData;
import com.uranus.fusion.asterix.uap.identification.ServiceIdentification;
import com.uranus.fusion.asterix.uap.identification.SystemIdentification;
import com.uranus.fusion.asterix.uap.identification.TargetIdentification;
import com.uranus.fusion.asterix.uap.measure.altitude.BarometricAltitude;
import com.uranus.fusion.asterix.uap.measure.altitude.FlightLevel;
import com.uranus.fusion.asterix.uap.measure.altitude.GeometricAltitude;
import com.uranus.fusion.asterix.uap.measure.altitude.RateOfClimbOrDescent;
import com.uranus.fusion.asterix.uap.measure.movement.ModeOfMovement;
import com.uranus.fusion.asterix.uap.measure.position.CartesianPosition;
import com.uranus.fusion.asterix.uap.measure.position.Wgs84Position;
import com.uranus.fusion.asterix.uap.measure.speed.CartesianAcceleration;
import com.uranus.fusion.asterix.uap.measure.speed.CartesianVelocity;
import com.uranus.fusion.asterix.uap.track.ComposedTrackNumber;
import com.uranus.fusion.asterix.uap.track.TimeOfTrack;
import com.uranus.fusion.asterix.uap.track.TrackNumber;
import com.uranus.fusion.asterix.uap.track.TrackStatus;
import com.uranus.fusion.asterix.uap.track.status.SystemTrackUpdateAge;
import com.uranus.fusion.asterix.uap.track.status.TrackDataAge;
import com.uranus.fusion.asterix.uap.vehicle.TargetSizeAndOrientation;
import com.uranus.fusion.asterix.uap.vehicle.VehicleFleetIdentification;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserAccessProfile implements Serializable {
  private Integer                    category;
  private Integer                    length;
  private FieldSpec                  fieldSpec;
  private SystemIdentification       dataSourceIdentifier;
  private ServiceIdentification      serviceIdentification;
  private TimeOfTrack                timeOfTrack;
  private Wgs84Position              wgs84Position;
  private CartesianPosition          cartesianPosition;
  private CartesianVelocity          cartesianVelocity;
  private CartesianAcceleration      cartesianAcceleration;
  private Mode3Code                  mode3Code;
  private TargetIdentification       targetIdentification;
  private AircraftDerivedData        aircraftDerivedData;
  private TrackNumber                trackNumber;
  private TrackStatus                trackStatus;
  private SystemTrackUpdateAge       systemTrackUpdateAge;
  private ModeOfMovement             modeOfMovement;
  private TrackDataAge               trackDataAge;
  private FlightLevel                measuredFlightLevel;
  private GeometricAltitude          trackGeometricAltitude;
  private BarometricAltitude         trackBarometricAltitude;
  private RateOfClimbOrDescent       rateOfClimbOrDescent;
  private FlightPlanRelatedData      flightPlanRelatedData;
  private TargetSizeAndOrientation   targetSizeAndOrientation;
  private VehicleFleetIdentification vehicleFleetIdentification;
  private Mode5AndExtendedMode1Data  mode5AndExtendedMode1Data;
  private Mode2Code                  mode2Code;
  private ComposedTrackNumber        composedTrackNumber;
  private EstimatedAccuracy estimatedAccuracy;
  private MeasuredInformation measuredInformation;
}
