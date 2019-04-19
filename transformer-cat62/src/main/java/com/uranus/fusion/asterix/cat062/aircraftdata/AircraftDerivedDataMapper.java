package com.uranus.fusion.asterix.cat062.aircraftdata;

import com.uranus.fusion.asterix.cat062.aircraftdata.sub.*;
import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.*;
import com.uranus.fusion.asterix.uap.aircraft.AircraftDerivedData;
import com.uranus.fusion.asterix.uap.aircraft.MagneticHeading;
import com.uranus.fusion.asterix.uap.comm.AcasResolutionReport;
import com.uranus.fusion.asterix.uap.emitter.EmitterCategoryEnum;
import com.uranus.fusion.asterix.uap.emitter.adsb.StatusByAdsb;
import com.uranus.fusion.asterix.uap.emitter.modesel.CommAndStatusByModeSel;
import com.uranus.fusion.asterix.uap.emitter.modesel.ModeSelMbData;
import com.uranus.fusion.asterix.uap.identification.TargetAddress;
import com.uranus.fusion.asterix.uap.identification.TargetIdentification;
import com.uranus.fusion.asterix.uap.measure.SelectedAltitude;
import com.uranus.fusion.asterix.uap.measure.VelocityUncertainty;
import com.uranus.fusion.asterix.uap.measure.altitude.BarometricVerticalRate;
import com.uranus.fusion.asterix.uap.measure.altitude.FinalStateSelectedAltitude;
import com.uranus.fusion.asterix.uap.measure.altitude.GeometricAltitude;
import com.uranus.fusion.asterix.uap.measure.altitude.GeometricVerticalRate;
import com.uranus.fusion.asterix.uap.measure.angle.RollAngle;
import com.uranus.fusion.asterix.uap.measure.angle.TrackAngle;
import com.uranus.fusion.asterix.uap.measure.angle.TrackAngleRate;
import com.uranus.fusion.asterix.uap.measure.position.PositionUncertainty;
import com.uranus.fusion.asterix.uap.measure.position.Wgs84Position;
import com.uranus.fusion.asterix.uap.measure.speed.Airspeed;
import com.uranus.fusion.asterix.uap.measure.speed.GroundSpeed;
import com.uranus.fusion.asterix.uap.measure.speed.TrueAirspeed;
import com.uranus.fusion.asterix.uap.meteorology.BarometricPressureSetting;
import com.uranus.fusion.asterix.uap.meteorology.MetData;
import com.uranus.fusion.asterix.uap.trajectory.TrajectoryIntentData;
import com.uranus.fusion.asterix.uap.trajectory.TrajectoryIntentStatus;

import java.util.List;

/**
 * AircraftDerivedDataMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/16
 */
public class AircraftDerivedDataMapper {

  public static AircraftDerivedData read(List<Byte> uap, FieldSpec fieldSpec) {
    // Aircraft Derived Data: frn=11, size=1+

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(Cat062Config.AIRCRAFT_DERIVED_DATA_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int startIndex = fieldSpec.calculateIndexByFrn(Cat062Config.AIRCRAFT_DERIVED_DATA_FRN);

      AircraftDerivedData aircraftDerivedData = new AircraftDerivedData();

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.CAT062_AIRCRAFT_DERIVED_DATA);
      dataSpec.readValue(uap, startIndex);

      TargetAddress targetAddress = TargetAddressMapper.read(uap, dataSpec);
      aircraftDerivedData.setTargetAddress(targetAddress);

      TargetIdentification targetIdentification = TargetIdentificationMapper.read(uap, dataSpec);
      aircraftDerivedData.setTargetIdentification(targetIdentification);

      MagneticHeading magneticHeading = MagneticHeadingMapper.read(uap, dataSpec);
      aircraftDerivedData.setMagneticHeading(magneticHeading);

      Airspeed airspeed = AirspeedMapper.readAirspeed(uap, dataSpec);
      aircraftDerivedData.setAirspeed(airspeed);

      TrueAirspeed trueAirspeed = TrueAirspeedMapper.readTrueAirspeed(uap, dataSpec);
      aircraftDerivedData.setTrueAirspeed(trueAirspeed);

      SelectedAltitude selectedAltitude =
          SelectedAltitudeMapper.readSelectedAltitude(uap, dataSpec);
      aircraftDerivedData.setSelectedAltitude(selectedAltitude);

      FinalStateSelectedAltitude finalStateSelectedAltitude =
          FinalStateSelectedAltitudeMapper.readFinalStateSelectedAltitude(uap, dataSpec);
      aircraftDerivedData.setFinalStateSelectedAltitude(finalStateSelectedAltitude);

      TrajectoryIntentStatus trajectoryIntentStatus =
          TrajectoryStatusMapper.readTrajectoryIntentStatus(uap, dataSpec);
      aircraftDerivedData.setTrajectoryIntentStatus(trajectoryIntentStatus);

      TrajectoryIntentData trajectoryIntentData =
          TrajectoryDataMapper.readTrajectoryIntentData(uap, dataSpec);
      aircraftDerivedData.setTrajectoryIntentData(trajectoryIntentData);

      CommAndStatusByModeSel commAndStatusByModeSel =
          CommAndStatusByModeSelMapper.read(uap, dataSpec);
      aircraftDerivedData.setCommunicationCapability(commAndStatusByModeSel);

      StatusByAdsb statusByAdsb = StatusByAdsbMapper.readStatusReportedByAdsB(uap, dataSpec);
      aircraftDerivedData.setStatusByAdsb(statusByAdsb);

      AcasResolutionReport acasResolutionReport =
          AcasResolutionReportParser.readAcasResolutionAdvisoryReport(uap, dataSpec);
      aircraftDerivedData.setAcasResolutionAdvisory(acasResolutionReport);

      BarometricVerticalRate barometricVerticalRate =
          BarometricVerticalRateMapper.readBarometricVerticalRate(uap, dataSpec);
      aircraftDerivedData.setBarometricVerticalRate(barometricVerticalRate);

      GeometricVerticalRate geometricVerticalRate =
          GeometricVerticalRateMapper.readGeometricVerticalRate(uap, dataSpec);
      aircraftDerivedData.setGeometricVerticalRate(geometricVerticalRate);

      RollAngle rollAngle = RollAngleMapper.readRollAngle(uap, dataSpec);
      aircraftDerivedData.setRollAngle(rollAngle);

      TrackAngleRate trackAngleRate = TrackAngleRateMapper.readTrackAngleRate(uap, dataSpec);
      aircraftDerivedData.setTrackAngleRate(trackAngleRate);

      TrackAngle trackAngle = TrackAngleMapper.readTrackAngle(uap, dataSpec);
      aircraftDerivedData.setTrackAngle(trackAngle);

      GroundSpeed groundAirspeed = GroundAirspeedMapper.read(uap, dataSpec);
      aircraftDerivedData.setGroundAirspeed(groundAirspeed);

      VelocityUncertainty velocityUncertainty =
          VelocityUncertaintyMapper.readVelocityUncertainty(uap, dataSpec);
      aircraftDerivedData.setVelocityUncertainty(velocityUncertainty);

      MetData metData = MetDataMapper.read(uap, dataSpec);
      aircraftDerivedData.setMetData(metData);

      EmitterCategoryEnum emitterCategoryEnum =
          EmitterCategoryMapper.readEmitterCategory(uap, dataSpec);
      aircraftDerivedData.setEmitterCategory(emitterCategoryEnum);

      Wgs84Position position = PositionMapper.readPosition(uap, dataSpec);
      aircraftDerivedData.setPosition(position);

      GeometricAltitude geometricAltitude =
          GeometricAltitudeMapper.readGeometricAltitude(uap, dataSpec);
      aircraftDerivedData.setGeometricAltitude(geometricAltitude);

      PositionUncertainty positionUncertainty =
          PositionUncertaintyMapper.readPositionUncertainty(uap, dataSpec);
      aircraftDerivedData.setPositionUncertainty(positionUncertainty);

      ModeSelMbData modeSelMbData = ModeSelMapper.readModeSMbData(uap, dataSpec);
      aircraftDerivedData.setModesMbData(modeSelMbData);

      Airspeed indicatedAirspeed = IndicatedAirspeedMapper.read(uap, dataSpec);
      aircraftDerivedData.setIndicatedAirspeed(indicatedAirspeed);

      Airspeed mach = MachNumberMapper.read(uap, dataSpec);
      aircraftDerivedData.setMachNumber(mach);

      BarometricPressureSetting barometricPressureSetting =
          BarometricPressureSettingMapper.readBarometricPressureSetting(uap, dataSpec);
      aircraftDerivedData.setBarometricPressureSetting(barometricPressureSetting);

      fpIndicator.setSize(dataSpec.calculateTotalSize());

      return aircraftDerivedData;
    }
    return null;
  }
}
