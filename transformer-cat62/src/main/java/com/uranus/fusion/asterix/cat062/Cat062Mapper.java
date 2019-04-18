package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.AsterixConfig;
import com.uranus.fusion.asterix.AsterixMapper;
import com.uranus.fusion.asterix.UserAccessProfile;
import com.uranus.fusion.asterix.cat062.aircraft.AircraftDerivedDataMapper;
import com.uranus.fusion.asterix.cat062.dataage.TrackDataAgeMapper;
import com.uranus.fusion.asterix.cat062.flightplan.FlightPlanRelatedDataMapper;
import com.uranus.fusion.asterix.cat062.updateage.SystemTrackUpdateAgeMapper;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Cat062Mapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
public class Cat062Mapper {

  private static final Logger LOGGER = LoggerFactory.getLogger(Cat062Mapper.class);

  private static final List<Integer> SPARE_FRN = Arrays.asList(2, 29, 30, 31, 32, 33, 34, 35);

  private List<Byte> message = new ArrayList<>();
  private UserAccessProfile uap = new UserAccessProfile();

  public Cat062Mapper(byte[] input) {
    for (byte octet : input) {
      this.message.add(octet);
    }
  }

  private void readCategory() {
    int category = AsterixMapper.readCategory(this.message);

    if (AsterixConfig.CAT062_CATEGORY_VALUE != category) {
      LOGGER.error("非法的CAT062报文,CAT062报文中Category值应该为62,当前报文的Category值为: " + category);
      return;
    }
    this.uap.setCategory(category);
  }

  private void readLength() {
    int length = AsterixMapper.readLength(this.message);
    if (this.message.size() != length) {
      LOGGER.warn("报文的LEN声明值与报文实际长度不一致. 报文中声明的长度为:" + length + ",实际报文长度为:" + this.message.size());
    }
    this.uap.setLength(length);
  }

  private void readFSPEC() {
    FieldSpec fieldSpec = AsterixMapper.readFieldSpec(this.message);
    for (int frn : SPARE_FRN) {
      FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
      if (FpIndicationEnum.PRESENCE == fpIndicator.getIndication()) {
        LOGGER.error(
            "非法的CAT062报文,CAT062报文中FRN=" + frn + "的数据项为预留项, FSPEC中该数据项应该为ABSENCE, 当前值为PRESENCE");
        return;
      }
    }
    this.uap.setFieldSpec(fieldSpec);
  }

  private void readDataSourceIdentifier() {
    SystemIdentification dataSourceIdentifier =
        DataSourceIdentifierMapper.readDataSourceIdentifier(this.message, this.uap.getFieldSpec());
    this.uap.setDataSourceIdentifier(dataSourceIdentifier);
  }

  private void readServiceIdentification() {
    ServiceIdentification serviceIdentification =
        ServiceIdentifierMapper.readServiceIdentification(this.message, this.uap.getFieldSpec());
    this.uap.setServiceIdentification(serviceIdentification);
  }

  private void readTimeOfTrackInformation() {
    TimeOfTrack timeOfTrackInformation =
        TimeOfTrackMapper.readTimeOfTrackInformation(this.message, this.uap.getFieldSpec());
    this.uap.setTimeOfTrack(timeOfTrackInformation);
  }

  private void readWgs84CalculatedTrackPosition() {
    Wgs84Position wgs84CalculatedTrackPosition =
        Wgs84CalculatedTrackPositionMapper.readWgs84CalculatedTrackPosition(
            this.message, this.uap.getFieldSpec());
    this.uap.setWgs84Position(wgs84CalculatedTrackPosition);
  }

  private void readCartesianCalculatedTrackPosition() {

    CartesianPosition cartesianPosition =
        CartesianCalculatedTrackPositionMapper.readCartesianCalculatedTrackPosition(
            this.message, this.uap.getFieldSpec());
    this.uap.setCartesianPosition(cartesianPosition);
  }

  private void readCartesianCalculatedTrackVelocity() {
    CartesianVelocity cartesianVelocity =
        CartesianCalculatedTrackVelocityMapper.readCartesianCalculatedTrackVelocity(
            this.message, this.uap.getFieldSpec());
    this.uap.setCartesianVelocity(cartesianVelocity);
  }

  private void readCartesianCalculatedAcceleration() {
    CartesianAcceleration cartesianAcceleration =
        CartesianCalculatedTrackAccelerationMapper.readCartesianCalculatedAcceleration(
            this.message, this.uap.getFieldSpec());
    this.uap.setCartesianAcceleration(cartesianAcceleration);
  }

  private void readTrackMode3ACode() {
    Mode3Code trackMode3Code =
        TrackMode3ACodeMapper.readTrackMode3Code(this.message, this.uap.getFieldSpec());
    this.uap.setMode3Code(trackMode3Code);
  }

  private void readTargetIdentification() {
    TargetIdentification targetIdentification =
        TargetIdentificationMapper.read(this.message, this.uap.getFieldSpec());
    this.uap.setTargetIdentification(targetIdentification);
  }

  private void readAircraftDerivedData() {
    AircraftDerivedData aircraftDerivedData =
        AircraftDerivedDataMapper.readAircraftDerivedData(this.message, this.uap.getFieldSpec());
    this.uap.setAircraftDerivedData(aircraftDerivedData);
  }

  private void readTrackNumber() {
    TrackNumber trackNumber =
        TrackNumberMapper.readTrackNumber(this.message, this.uap.getFieldSpec());
    this.uap.setTrackNumber(trackNumber);
  }

  private void readTrackStatus() {
    TrackStatus trackStatus =
        TrackStatusMapper.readTrackStatus(this.message, this.uap.getFieldSpec());
    this.uap.setTrackStatus(trackStatus);
  }

  private void readSystemTrackUpdateAges() {
    SystemTrackUpdateAge systemTrackUpdateAge =
        SystemTrackUpdateAgeMapper.read(this.message, this.uap.getFieldSpec());
    this.uap.setSystemTrackUpdateAge(systemTrackUpdateAge);
  }

  private void readModeOfMovement() {
    ModeOfMovement modeOfMovement =
        ModeOfMovementMapper.readModeOfMovement(this.message, this.uap.getFieldSpec());
    this.uap.setModeOfMovement(modeOfMovement);
  }

  private void readTrackDataAges() {
    TrackDataAge trackDataAge =
        TrackDataAgeMapper.read(this.message, this.uap.getFieldSpec());
    this.uap.setTrackDataAge(trackDataAge);
  }

  private void readMeasuredFlightLevel() {
    FlightLevel measuredFlightLevel =
        MeasuredFlightLevelMapper.read(this.message, this.uap.getFieldSpec());
    this.uap.setMeasuredFlightLevel(measuredFlightLevel);
  }

  private void readCalculatedTrackGeometricAltitude() {
    GeometricAltitude trackGeometricAltitude =
        TrackGeometricAltitudeMapper.read(this.message, this.uap.getFieldSpec());
    this.uap.setTrackGeometricAltitude(trackGeometricAltitude);
  }

  private void readCalculatedTrackBarometricAltitude() {
    BarometricAltitude trackBarometricAltitude =
        TrackBarometricAltitudeMapper.read(this.message, this.uap.getFieldSpec());
    this.uap.setTrackBarometricAltitude(trackBarometricAltitude);
  }

  private void readCalculatedRateOfClimbDescent() {
    RateOfClimbOrDescent rateOfClimbOrDescent =
        RateOfClimbOrDescentMapper.read(this.message, this.uap.getFieldSpec());
    this.uap.setRateOfClimbOrDescent(rateOfClimbOrDescent);
  }

  private void readFlightPlanRelatedData() {
    FlightPlanRelatedData flightPlanRelatedData =
        FlightPlanRelatedDataMapper.read(this.message, this.uap.getFieldSpec());
    this.uap.setFlightPlanRelatedData(flightPlanRelatedData);
  }

  private void readTargetSizeAndOrientation() {
    TargetSizeAndOrientation targetSizeAndOrientation =
        TargetSizeAndOrientationMapper.read(this.message, this.uap.getFieldSpec());
    this.uap.setTargetSizeAndOrientation(targetSizeAndOrientation);
  }

  private void readVehicleFleetIdentification() {
    VehicleFleetIdentification vehicleFleetIdentification =
        VehicleFleetIdentificationMapper.read(this.message, this.uap.getFieldSpec());
    this.uap.setVehicleFleetIdentification(vehicleFleetIdentification);
  }

  private void readMode5DataReportsAndExtendedMode1Code() {
    Mode5AndExtendedMode1Data mode5AndExtendedMode1Data =
        Mode5AndExtendedMode1DataMapper.read(this.message, this.uap.getFieldSpec());
    this.uap.setMode5AndExtendedMode1Data(mode5AndExtendedMode1Data);
  }

  private void readTrackMode2Code() {
    Mode2Code mode2Code = Mode2CodeMapper.read(this.message, this.uap.getFieldSpec());
    this.uap.setMode2Code(mode2Code);
  }

  private void readComposedTrackNumber() {
    ComposedTrackNumber composedTrackNumber =
        ComposedTrackNumberMapper.read(this.message, this.uap.getFieldSpec());
    this.uap.setComposedTrackNumber(composedTrackNumber);
  }

  private void readEstimatedAccuracies() {
    EstimatedAccuracy estimatedAccuracy =
        EstimatedAccuracyMapper.read(this.message, this.uap.getFieldSpec());
    this.uap.setEstimatedAccuracy(estimatedAccuracy);
  }

  private void readMeasuredInformation() {
    MeasuredInformation measuredInformation =
        MeasuredInformationMapper.read(this.message, this.uap.getFieldSpec());
    this.uap.setMeasuredInformation(measuredInformation);
  }

  public UserAccessProfile readValue() {
    this.readCategory();
    this.readLength();
    this.readFSPEC();

    this.readDataSourceIdentifier();
    this.readServiceIdentification();
    this.readTimeOfTrackInformation();
    this.readWgs84CalculatedTrackPosition();
    this.readCartesianCalculatedTrackPosition();
    this.readCartesianCalculatedTrackVelocity();
    this.readCartesianCalculatedAcceleration();
    this.readTrackMode3ACode();
    this.readTargetIdentification();
    this.readAircraftDerivedData();
    this.readTrackNumber();
    this.readTrackStatus();
    this.readSystemTrackUpdateAges();
    this.readModeOfMovement();
    this.readTrackDataAges();
    this.readMeasuredFlightLevel();
    this.readCalculatedTrackGeometricAltitude();
    this.readCalculatedTrackBarometricAltitude();
    this.readCalculatedRateOfClimbDescent();
    this.readFlightPlanRelatedData();
    this.readTargetSizeAndOrientation();
    this.readVehicleFleetIdentification();
    this.readMode5DataReportsAndExtendedMode1Code();
    this.readTrackMode2Code();
    this.readComposedTrackNumber();
    this.readEstimatedAccuracies();
    this.readMeasuredInformation();
    return this.uap;
  }
}
