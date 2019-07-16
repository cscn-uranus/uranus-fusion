package com.uranus.transition.common.asterix.uap.eucat062;

import com.uranus.transition.common.asterix.AsterixDataBlock;
import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.uap.shared.accuracy.EstimatedAccuracy;
import com.uranus.transition.common.asterix.uap.eucat062.AircraftDerivedData;
import com.uranus.transition.common.asterix.uap.shared.datainfo.MeasuredInformation;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode2.Mode2Code;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode3.Mode3Code;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode5.Mode5AndExtendedMode1;
import com.uranus.transition.common.asterix.uap.eucat062.FlightPlanRelatedData;
import com.uranus.transition.common.asterix.uap.shared.identification.ServiceIdentification;
import com.uranus.transition.common.asterix.uap.shared.identification.SystemIdentification;
import com.uranus.transition.common.asterix.uap.shared.identification.TargetIdentification;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.BarometricAltitude;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.FlightLevel;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.GeometricAltitude;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.RateOfClimbOrDescent;
import com.uranus.transition.common.asterix.uap.shared.measure.movement.ModeOfMovement;
import com.uranus.transition.common.asterix.uap.shared.measure.position.CartesianPosition;
import com.uranus.transition.common.asterix.uap.shared.measure.position.Wgs84Position;
import com.uranus.transition.common.asterix.uap.shared.measure.speed.CartesianAcceleration;
import com.uranus.transition.common.asterix.uap.shared.measure.speed.CartesianVelocity;
import com.uranus.transition.common.asterix.uap.shared.track.ComposedTrackNumber;
import com.uranus.transition.common.asterix.uap.shared.track.TimeOfTrack;
import com.uranus.transition.common.asterix.uap.shared.track.TrackNumber;
import com.uranus.transition.common.asterix.uap.eucat062.TrackStatus;
import com.uranus.transition.common.asterix.uap.shared.track.status.SystemTrackUpdateAge;
import com.uranus.transition.common.asterix.uap.shared.track.status.TrackDataAge;
import com.uranus.transition.common.asterix.uap.shared.vehicle.TargetSizeAndOrientation;
import com.uranus.transition.common.asterix.uap.shared.vehicle.VehicleFleetIdentification;
import lombok.Data;

/**
 * @author tellxp@github.com
 * @date 2019/6/25
 */
@Data
public class EuCat062DataBlock implements AsterixDataBlock {
  @Override
  public FieldSpec fieldSpec() {
    return fieldSpec;
  }

  /**
   * Field Specification
   *
   * <p>使用 Map 来定义符合 Asterix 规范的 FRN（Field Reference Number）和 FpIndicator 的对应关系
   *
   * <p>不同类型的报文，由不同的 FieldSpec 使用来实例化不同的 Map
   *
   * @see com.uranus.transition.common.asterix.spec.FpIndicator
   * @see com.uranus.transition.common.asterix.spec.FieldSpecParameter
   *     <p>Data Specification 采用了相似的方式
   * @see com.uranus.transition.common.asterix.spec.DataSpec
   */
  private FieldSpec fieldSpec;

  /**
   * Data Item I062/010, Data Source Identifier
   *
   * <p>Definition : Identification of the system sending
   *
   * <p>the data Format : Two-octet fixed length Data Item
   */
  private SystemIdentification systemIdentification;

  /**
   * Data Item I062/015, Service Identification
   *
   * <p>Definition : Identification of the service provided to one or more users.
   *
   * <p>Format : One-Octet fixed length data item.
   */
  private ServiceIdentification serviceIdentification;

  /**
   * Data Item I062/070, Time Of Track Information
   *
   * <p>Definition : Absolute time stamping of the information provided in the track message, in the
   * form of elapsed time since last midnight, expressed as UTC.
   *
   * <p>Format : Three-Octet fixed length data item.
   */
  private TimeOfTrack timeOfTrack;

  /**
   * Data Item I062/105, Calculated Position In WGS-84 Co-ordinates
   *
   * <p>Definition : Calculated Position in WGS-84 Co-ordinates with a resolution of 180/225.
   * degrees
   *
   * <p>Format : Eight-octet fixed length Data Item
   */
  private Wgs84Position wgs84Position;

  /**
   * Data Item I062/100, Calculated Track Position. (Cartesian)
   *
   * <p>Definition : Calculated position in Cartesian co-ordinates with a resolution of 0.5m, in
   * two’s complement form.
   *
   * <p>Format : Six-octet fixed length Data Item.
   */
  private CartesianPosition cartesianPosition;

  /**
   * Data Item I062/185, Calculated Track Velocity (Cartesian)
   *
   * <p>Definition: Calculated track velocity expressed in Cartesian co-ordinates, in two’s
   * complement form.
   *
   * <p>Format: Four-octet fixed length Data Item.
   */
  private CartesianVelocity cartesianVelocity;

  /**
   * Data Item I062/210, Calculated Acceleration (Cartesian)
   *
   * <p>Definition : Calculated Acceleration of the target expressed in Cartesian coordinates, in
   * two’s complement form.
   *
   * <p>Format: Two-octet fixed length Data Item.
   */
  private CartesianAcceleration cartesianAcceleration;

  /**
   * Data Item I062/060, Track Mode 3/A Code
   *
   * <p>Definition : Mode-3/A code converted into octal representation.
   *
   * <p>Format : Two-octet fixed length Data Item.
   */
  private Mode3Code mode3Code;

  /**
   * Data Item I062/245, Target Identification
   *
   * <p>Definition: Target (aircraft or vehicle) identification in 8 characters.
   *
   * <p>Format: Seven-octet fixed length Data Item.
   */
  private TargetIdentification targetIdentification;

  /**
   * Data Item I062/380, Aircraft Derived Data
   *
   * <p>Definition : Data derived directly by the aircraft.
   *
   * <p>Format : Compound Data Item, comprising a primary subfield of up to four octets, followed by
   * the indicated subfields.
   */
  private AircraftDerivedData aircraftDerivedData;

  /**
   * Data Item I062/040, Track Number
   *
   * <p>Definition : Identification of a track
   *
   * <p>Format : Two-Octet fixed length data item
   */
  private TrackNumber trackNumber;

  /**
   * Data Item I062/080, Track Status
   *
   * <p>Definition : Status of a track.
   *
   * <p>Format : Variable length data item comprising a first part of one Octet, followed by 1-Octet
   * extents as necessary.
   */
  private TrackStatus trackStatus;

  /**
   * Data Item I062/290, System Track Update Ages
   *
   * <p>Definition : Ages of the last plot/local track/target report update for each sensor type.
   *
   * <p>Format : Compound Data Item, comprising a primary subfield of up to two octets, followed by
   * the indicated subfields.
   */
  private SystemTrackUpdateAge systemTrackUpdateAge;

  /**
   * Data Item I062/200, Mode of Movement
   *
   * <p>Definition : Calculated Mode of Movement of a target.
   *
   * <p>Format : One-Octet fixed length data item.
   */
  private ModeOfMovement modeOfMovement;

  /**
   * Data Item I062/295, Track Data Ages
   *
   * <p>Definition : Ages of the data provided.
   *
   * <p>Format : Compound Data Item, comprising a primary subfield of up to five octets, followed by
   * the indicated subfields.
   */
  private TrackDataAge trackDataAge;

  /**
   * Data Item I062/136, Measured Flight Level
   *
   * <p>Definition : Last valid and credible flight level used to update the track, in two’s
   * complement form.
   *
   * <p>Structure: Two-Octet fixed length data item.
   */
  private FlightLevel measuredFlightLevel;

  /**
   * Data Item I062/130, Calculated Track Geometric Altitude
   *
   * <p>Definition : Vertical distance between the target and the projection of its position on the
   * earth’s ellipsoid, as defined by WGS84, in two’s complement form.
   *
   * <p>Format : Two-Octet fixed length data item.
   *
   * <p>MH 4008 I003/090
   *
   * <p>用二进制数表示的C 模式高度
   */
  private GeometricAltitude trackGeometricAltitude;

  /**
   * Data Item I062/135, Calculated Track Barometric Altitude
   *
   * <p>Definition : Calculated Barometric Altitude of the track, in two’s complement form.
   *
   * <p>Format : Two-Octet fixed length data item.
   */
  private BarometricAltitude trackBarometricAltitude;

  /**
   * Data Item I062/220, Calculated Rate Of Climb/Descent
   *
   * <p>Definition : Calculated rate of Climb/Descent of an aircraft in two’s complement form.
   *
   * <p>Format : Two-Octet fixed length data item.
   */
  private RateOfClimbOrDescent rateOfClimbOrDescent;

  /**
   * Data Item I062/390, Flight Plan Related Data
   *
   * <p>Definition : All flight plan related information, provided by ground-based systems.
   *
   * <p>Format : Compound Data Item, comprising a primary subfield of up to three octets, followed
   * by the indicated subfields.
   */
  private FlightPlanRelatedData flightPlanRelatedData;

  /**
   * Data Item I062/270, Target Size & Orientation
   *
   * <p>Definition: Target size defined as length and width of the detected target, and orientation.
   *
   * <p>Format: Variable length Data Item comprising a first part of one octet, followed by
   * one-octet extents as necessary.
   */
  private TargetSizeAndOrientation targetSizeAndOrientation;

  /**
   * Data Item I062/300, Vehicle Fleet Identification
   *
   * <p>Definition: Vehicle fleet identification number.
   *
   * <p>Format: One octet fixed length Data Item.
   */
  private VehicleFleetIdentification vehicleFleetIdentification;

  /**
   * Data Item I062/110, Mode 5 Data reports & Extended Mode 1 Code
   *
   * <p>Definition : Mode 5 Data reports & Extended Mode 1 Code
   *
   * <p>Format : Compound Data Item, comprising a primary subfield of one octet, followed by the
   * indicated subfields.
   */
  private Mode5AndExtendedMode1 mode5AndExtendedMode1;

  /**
   * Data Item I062/120, Track Mode 2 Code
   *
   * <p>Definition : Mode 2 code associated to the track
   *
   * <p>Format : Two-Octet fixed length data item.
   */
  private Mode2Code mode2Code;

  /**
   * Data Item I062/510, Composed Track Number
   *
   * <p>Definition : Identification of a system track
   *
   * <p>Structure: Extendible data item, comprising a first part of three octets (Master Track
   * Number), followed by three-octet extents (Slave Tracks Numbers).
   */
  private ComposedTrackNumber composedTrackNumber;

  /**
   * Data Item I062/500, Estimated Accuracies
   *
   * <p>Definition : Overview of all important accuracies
   *
   * <p>Format : Compound Data Item, comprising a primary subfield of up to two octets, followed by
   * the indicated subfields.
   */
  private EstimatedAccuracy estimatedAccuracy;

  /**
   * Data Item I062/340, Measured Information
   *
   * <p>Definition : All measured data related to the last report used to update the track.
   *
   * <p>Format : Compound Data Item, comprising a primary subfield of one octet, followed by the
   * indicated subfields.
   */
  private MeasuredInformation measuredInformation;



}
