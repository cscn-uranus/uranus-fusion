package com.uranus.fusion.transformer.asterix;

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
import com.uranus.fusion.transformer.asterix.aircraft.AircraftDerivedData;
import com.uranus.fusion.transformer.asterix.aircraft.AircraftDerivedDataMapper;
import com.uranus.fusion.transformer.asterix.aircraft.identity.TargetIdentification;
import com.uranus.fusion.transformer.asterix.aircraft.identity.TargetIdentificationMapper;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode2.Mode2Code;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode2.Mode2CodeMapper;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode3.Mode3Code;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode3.Mode3CodeMapper;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode5.Mode5AndExtendedMode1Data;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode5.Mode5AndExtendedMode1DataMapper;
import com.uranus.fusion.transformer.asterix.flightplan.FlightPlanRelatedData;
import com.uranus.fusion.transformer.asterix.flightplan.FlightPlanRelatedDataMapper;
import com.uranus.fusion.transformer.asterix.measure.BarometricAltitude;
import com.uranus.fusion.transformer.asterix.measure.CartesianAcceleration;
import com.uranus.fusion.transformer.asterix.measure.CartesianPosition;
import com.uranus.fusion.transformer.asterix.measure.CartesianVelocity;
import com.uranus.fusion.transformer.asterix.measure.FlightLevel;
import com.uranus.fusion.transformer.asterix.measure.GeometricAltitude;
import com.uranus.fusion.transformer.asterix.measure.RateOfClimbOrDescent;
import com.uranus.fusion.transformer.asterix.measure.Wgs84Position;
import com.uranus.fusion.transformer.asterix.util.ByteUtil;
import com.uranus.fusion.transformer.asterix.vehicle.TargetSizeAndOrientation;
import com.uranus.fusion.transformer.asterix.vehicle.TargetSizeAndOrientationMapper;
import com.uranus.fusion.transformer.asterix.vehicle.VehicleFleetIdentification;
import com.uranus.fusion.transformer.asterix.vehicle.VehicleFleetIdentificationMapper;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Cat62Mapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
public class Cat62Mapper {

  private static final Logger logger = LoggerFactory.getLogger(Cat62Mapper.class);
  private List<Byte> uap = new ArrayList<>();

  public Cat62Mapper(byte[] inputDataArray) {
    for (byte inputData : inputDataArray) {
      Byte data = inputData;
      this.uap.add(data);
    }
  }

  public Cat62UapDTO readValue() {
    Cat62UapDTO cat62UapDTO = new Cat62UapDTO();

    int category = AsterixMapper.readCat(this.uap);
    cat62UapDTO.setCategory(category);

    int length = AsterixMapper.readLen(this.uap);
    cat62UapDTO.setLength(length);

    FieldSpec fieldSpec = AsterixMapper.readFieldSpecification(this.uap, 3);
    cat62UapDTO.setFieldSpec(fieldSpec);


    SystemIdentifier dataSourceIdentifier = DataSourceIdentifierMapper
        .readDataSourceIdentifier(this.uap, fieldSpec);
    cat62UapDTO.setDataSourceIdentifier(dataSourceIdentifier);

    ServiceIdentifier serviceIdentification =
        ServiceIdentifierMapper.readServiceIdentification(this.uap, fieldSpec);
    cat62UapDTO.setServiceIdentification(serviceIdentification);


    TimeOfTrack timeOfTrackInformation =
        TrackTimeMapper.readTimeOfTrackInformation(this.uap, fieldSpec);
    cat62UapDTO.setTimeOfTrack(timeOfTrackInformation);

    Wgs84Position wgs84CalculatedTrackPosition =
        CalculatedTrackMapper.readWgs84CalculatedTrackPosition(this.uap, fieldSpec);
    cat62UapDTO.setWgs84Position(wgs84CalculatedTrackPosition);

    CartesianPosition cartesianPosition =
        CalculatedTrackMapper.readCartesianCalculatedTrackPosition(this.uap, fieldSpec);
    cat62UapDTO.setCartesianPosition(cartesianPosition);

    CartesianVelocity cartesianVelocity =
        CalculatedTrackMapper.readCartesianCalculatedTrackVelocity(this.uap, fieldSpec);
    cat62UapDTO.setCartesianVelocity(cartesianVelocity);

    CartesianAcceleration cartesianAcceleration =
        CalculatedTrackMapper.readCartesianCalculatedAcceleration(this.uap, fieldSpec);
    cat62UapDTO.setCartesianAcceleration(cartesianAcceleration);

    Mode3Code trackMode3Code = Mode3CodeMapper.readTrackMode3Code(this.uap, fieldSpec);
    cat62UapDTO.setMode3Code(trackMode3Code);

    TargetIdentification targetIdentification =
        TargetIdentificationMapper.read(this.uap, fieldSpec);
    cat62UapDTO.setTargetIdentification(targetIdentification);


    AircraftDerivedData aircraftDerivedData =
        AircraftDerivedDataMapper.readAircraftDerivedData(this.uap, fieldSpec);
    cat62UapDTO.setAircraftDerivedData(aircraftDerivedData);

    TrackNumber trackNumber = TrackNumberMapper.readTrackNumber(this.uap, fieldSpec);
    cat62UapDTO.setTrackNumber(trackNumber);

    TrackStatus trackStatus = TrackStatusMapper.readTrackStatus(this.uap, fieldSpec);
    cat62UapDTO.setTrackStatus(trackStatus);

    TrackUpdateAgeStatus trackUpdateAgeStatus = TrackUpdateAgeStatusMapper
        .readTrackUpdateAge(this.uap, fieldSpec);
    cat62UapDTO.setTrackUpdateAgeStatus(trackUpdateAgeStatus);

    ModeOfMovement modeOfMovement = ModeOfMovementMapper.readModeOfMovement(this.uap, fieldSpec);
    cat62UapDTO.setModeOfMovement(modeOfMovement);

    TrackDataAgeStatus trackDataAgeStatus = TrackDataAgeStatusMapper.readTrackDataAge(this.uap, fieldSpec);
    cat62UapDTO.setTrackDataAgeStatus(trackDataAgeStatus);

    FlightLevel measuredFlightLevel = MeasuredFlightLevelMapper.read(this.uap, fieldSpec);
    cat62UapDTO.setMeasuredFlightLevel(measuredFlightLevel);

    GeometricAltitude trackGeometricAltitude = TrackGeometricAltitudeMapper.read(this.uap, fieldSpec);
    cat62UapDTO.setTrackGeometricAltitude(trackGeometricAltitude);

    BarometricAltitude trackBarometricAltitude = TrackBarometricAltitudeMapper.read(this.uap, fieldSpec);
    cat62UapDTO.setTrackBarometricAltitude(trackBarometricAltitude);

    RateOfClimbOrDescent rateOfClimbOrDescent = RateOfClimbOrDescentMapper.read(this.uap, fieldSpec);
    cat62UapDTO.setRateOfClimbOrDescent(rateOfClimbOrDescent);

    FlightPlanRelatedData flightPlanRelatedData = FlightPlanRelatedDataMapper.read(this.uap, fieldSpec);
    cat62UapDTO.setFlightPlanRelatedData(flightPlanRelatedData);

    TargetSizeAndOrientation targetSizeAndOrientation =
        TargetSizeAndOrientationMapper.read(this.uap, fieldSpec);
    cat62UapDTO.setTargetSizeAndOrientation(targetSizeAndOrientation);

    VehicleFleetIdentification vehicleFleetIdentification =
        VehicleFleetIdentificationMapper.read(this.uap, fieldSpec);
    cat62UapDTO.setVehicleFleetIdentification(vehicleFleetIdentification);

    Mode5AndExtendedMode1Data mode5AndExtendedMode1Data =
        Mode5AndExtendedMode1DataMapper.read(this.uap, fieldSpec);
    cat62UapDTO.setMode5AndExtendedMode1Data(mode5AndExtendedMode1Data);

    Mode2Code mode2Code = Mode2CodeMapper.read(this.uap, fieldSpec);
    cat62UapDTO.setMode2Code(mode2Code);

    ComposedTrackNumber composedTrackNumber = ComposedTrackNumberMapper.read(this.uap, fieldSpec);
    cat62UapDTO.setComposedTrackNumber(composedTrackNumber);

    EstimatedAccuracy estimatedAccuracy = EstimatedAccuracyMapper.read(this.uap, fieldSpec);
    cat62UapDTO.setEstimatedAccuracy(estimatedAccuracy);

    MeasuredInformation measuredInformation = MeasuredInformationMapper.read(this.uap, fieldSpec);
    cat62UapDTO.setMeasuredInformation(measuredInformation);

    byte[] debugUap = new byte[100];
    for (int i = 0; i<this.uap.size();i++) {
      debugUap[i] = this.uap.get(i);
    }

    return cat62UapDTO;
  }
}
