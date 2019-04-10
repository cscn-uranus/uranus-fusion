package com.uranus.fusion.asterix;

import com.uranus.fusion.asterix.accuracy.EstimatedAccuracy;
import com.uranus.fusion.asterix.accuracy.EstimatedAccuracyMapper;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.sensor.MeasuredFlightLevelMapper;
import com.uranus.fusion.asterix.sensor.RateOfClimbOrDescentMapper;
import com.uranus.fusion.asterix.sensor.TrackBarometricAltitudeMapper;
import com.uranus.fusion.asterix.sensor.TrackGeometricAltitudeMapper;
import com.uranus.fusion.asterix.sensor.info.MeasuredInformation;
import com.uranus.fusion.asterix.sensor.info.MeasuredInformationMapper;
import com.uranus.fusion.asterix.track.ComposedTrackNumber;
import com.uranus.fusion.asterix.track.ComposedTrackNumberMapper;
import com.uranus.fusion.asterix.track.TrackNumber;
import com.uranus.fusion.asterix.track.TrackNumberMapper;
import com.uranus.fusion.asterix.track.dataage.TrackDataAgeStatus;
import com.uranus.fusion.asterix.track.dataage.TrackDataAgeStatusMapper;
import com.uranus.fusion.asterix.track.movement.ModeOfMovement;
import com.uranus.fusion.asterix.track.movement.ModeOfMovementMapper;
import com.uranus.fusion.asterix.track.status.TrackStatus;
import com.uranus.fusion.asterix.track.status.TrackStatusMapper;
import com.uranus.fusion.asterix.track.updateage.TrackUpdateAgeStatus;
import com.uranus.fusion.asterix.track.updateage.TrackUpdateAgeStatusMapper;
import com.uranus.fusion.asterix.aircraft.AircraftDerivedData;
import com.uranus.fusion.asterix.aircraft.AircraftDerivedDataMapper;
import com.uranus.fusion.asterix.aircraft.identity.TargetIdentification;
import com.uranus.fusion.asterix.aircraft.identity.TargetIdentificationMapper;
import com.uranus.fusion.asterix.aircraft.transponder.mode2.Mode2Code;
import com.uranus.fusion.asterix.aircraft.transponder.mode2.Mode2CodeMapper;
import com.uranus.fusion.asterix.aircraft.transponder.mode3.Mode3Code;
import com.uranus.fusion.asterix.aircraft.transponder.mode3.Mode3CodeMapper;
import com.uranus.fusion.asterix.aircraft.transponder.mode5.Mode5AndExtendedMode1Data;
import com.uranus.fusion.asterix.aircraft.transponder.mode5.Mode5AndExtendedMode1DataMapper;
import com.uranus.fusion.asterix.flightplan.FlightPlanRelatedData;
import com.uranus.fusion.asterix.flightplan.FlightPlanRelatedDataMapper;
import com.uranus.fusion.asterix.measure.BarometricAltitude;
import com.uranus.fusion.asterix.measure.CartesianAcceleration;
import com.uranus.fusion.asterix.measure.CartesianPosition;
import com.uranus.fusion.asterix.measure.CartesianVelocity;
import com.uranus.fusion.asterix.measure.FlightLevel;
import com.uranus.fusion.asterix.measure.GeometricAltitude;
import com.uranus.fusion.asterix.measure.RateOfClimbOrDescent;
import com.uranus.fusion.asterix.measure.Wgs84Position;
import com.uranus.fusion.asterix.vehicle.TargetSizeAndOrientation;
import com.uranus.fusion.asterix.vehicle.TargetSizeAndOrientationMapper;
import com.uranus.fusion.asterix.vehicle.VehicleFleetIdentification;
import com.uranus.fusion.asterix.vehicle.VehicleFleetIdentificationMapper;

import java.util.ArrayList;
import java.util.List;

import com.uranus.fusion.transformer.dto.FlightDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Cat062Mapper
 *
 * @author 肖鹏 tellxp@github.com
 * date 2018/10/15
 */
public class Cat062Mapper {

  private static final Logger logger = LoggerFactory.getLogger(Cat062Mapper.class);
  private List<Byte> uap = new ArrayList<>();

  public Cat062Mapper(byte[] inputDataArray) {
    for (byte inputData : inputDataArray) {
      Byte data = inputData;
      this.uap.add(data);
    }
  }

  public FlightDTO readValue() {
    FlightDTO flightDTO = new FlightDTO();

    int category = AsterixMapper.readCategory(this.uap);

    if (62!=category) {
      logger.error("不是cat062的UAP");
    }


    int length = AsterixMapper.readLength(this.uap);
    if (this.uap.size()!=length) {
      logger.warn("长度不相等");
    }

    FieldSpec fieldSpec = AsterixMapper.readFieldSpecification(this.uap, 3);


    SystemIdentifier dataSourceIdentifier = DataSourceIdentifierMapper
        .readDataSourceIdentifier(this.uap, fieldSpec);
    flightDTO.setDataSourceIdentifier(dataSourceIdentifier);

    ServiceIdentifier serviceIdentification =
        ServiceIdentifierMapper.readServiceIdentification(this.uap, fieldSpec);
    flightDTO.setServiceIdentification(serviceIdentification);


    TimeOfTrack timeOfTrackInformation =
        TrackTimeMapper.readTimeOfTrackInformation(this.uap, fieldSpec);
    flightDTO.setTimeOfTrack(timeOfTrackInformation);

    Wgs84Position wgs84CalculatedTrackPosition =
        CalculatedTrackMapper.readWgs84CalculatedTrackPosition(this.uap, fieldSpec);
    flightDTO.setWgs84Position(wgs84CalculatedTrackPosition);

    CartesianPosition cartesianPosition =
        CalculatedTrackMapper.readCartesianCalculatedTrackPosition(this.uap, fieldSpec);
    flightDTO.setCartesianPosition(cartesianPosition);

    CartesianVelocity cartesianVelocity =
        CalculatedTrackMapper.readCartesianCalculatedTrackVelocity(this.uap, fieldSpec);
    flightDTO.setCartesianVelocity(cartesianVelocity);

    CartesianAcceleration cartesianAcceleration =
        CalculatedTrackMapper.readCartesianCalculatedAcceleration(this.uap, fieldSpec);
    flightDTO.setCartesianAcceleration(cartesianAcceleration);

    Mode3Code trackMode3Code = Mode3CodeMapper.readTrackMode3Code(this.uap, fieldSpec);
    flightDTO.setMode3Code(trackMode3Code);

    TargetIdentification targetIdentification =
        TargetIdentificationMapper.read(this.uap, fieldSpec);
    flightDTO.setTargetIdentification(targetIdentification);


    AircraftDerivedData aircraftDerivedData =
        AircraftDerivedDataMapper.readAircraftDerivedData(this.uap, fieldSpec);
    flightDTO.setAircraftDerivedData(aircraftDerivedData);

    TrackNumber trackNumber = TrackNumberMapper.readTrackNumber(this.uap, fieldSpec);
    flightDTO.setTrackNumber(trackNumber);

    TrackStatus trackStatus = TrackStatusMapper.readTrackStatus(this.uap, fieldSpec);
    flightDTO.setTrackStatus(trackStatus);

    TrackUpdateAgeStatus trackUpdateAgeStatus = TrackUpdateAgeStatusMapper
        .readTrackUpdateAge(this.uap, fieldSpec);
    flightDTO.setTrackUpdateAgeStatus(trackUpdateAgeStatus);

    ModeOfMovement modeOfMovement = ModeOfMovementMapper.readModeOfMovement(this.uap, fieldSpec);
    flightDTO.setModeOfMovement(modeOfMovement);

    TrackDataAgeStatus trackDataAgeStatus = TrackDataAgeStatusMapper.readTrackDataAge(this.uap, fieldSpec);
    flightDTO.setTrackDataAgeStatus(trackDataAgeStatus);

    FlightLevel measuredFlightLevel = MeasuredFlightLevelMapper.read(this.uap, fieldSpec);
    flightDTO.setMeasuredFlightLevel(measuredFlightLevel);

    GeometricAltitude trackGeometricAltitude = TrackGeometricAltitudeMapper.read(this.uap, fieldSpec);
    flightDTO.setTrackGeometricAltitude(trackGeometricAltitude);

    BarometricAltitude trackBarometricAltitude = TrackBarometricAltitudeMapper.read(this.uap, fieldSpec);
    flightDTO.setTrackBarometricAltitude(trackBarometricAltitude);

    RateOfClimbOrDescent rateOfClimbOrDescent = RateOfClimbOrDescentMapper.read(this.uap, fieldSpec);
    flightDTO.setRateOfClimbOrDescent(rateOfClimbOrDescent);

    FlightPlanRelatedData flightPlanRelatedData = FlightPlanRelatedDataMapper.read(this.uap, fieldSpec);
    flightDTO.setFlightPlanRelatedData(flightPlanRelatedData);

    TargetSizeAndOrientation targetSizeAndOrientation =
        TargetSizeAndOrientationMapper.read(this.uap, fieldSpec);
    flightDTO.setTargetSizeAndOrientation(targetSizeAndOrientation);

    VehicleFleetIdentification vehicleFleetIdentification =
        VehicleFleetIdentificationMapper.read(this.uap, fieldSpec);
    flightDTO.setVehicleFleetIdentification(vehicleFleetIdentification);

    Mode5AndExtendedMode1Data mode5AndExtendedMode1Data =
        Mode5AndExtendedMode1DataMapper.read(this.uap, fieldSpec);
    flightDTO.setMode5AndExtendedMode1Data(mode5AndExtendedMode1Data);

    Mode2Code mode2Code = Mode2CodeMapper.read(this.uap, fieldSpec);
    flightDTO.setMode2Code(mode2Code);

    ComposedTrackNumber composedTrackNumber = ComposedTrackNumberMapper.read(this.uap, fieldSpec);
    flightDTO.setComposedTrackNumber(composedTrackNumber);

    EstimatedAccuracy estimatedAccuracy = EstimatedAccuracyMapper.read(this.uap, fieldSpec);
    flightDTO.setEstimatedAccuracy(estimatedAccuracy);

    MeasuredInformation measuredInformation = MeasuredInformationMapper.read(this.uap, fieldSpec);
    flightDTO.setMeasuredInformation(measuredInformation);


    return flightDTO;
  }
}
