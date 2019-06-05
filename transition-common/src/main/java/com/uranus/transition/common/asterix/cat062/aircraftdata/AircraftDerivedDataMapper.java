package com.uranus.transition.common.asterix.cat062.aircraftdata;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.cat062.aircraftdata.sub.*;
import com.uranus.transition.common.asterix.uap.aircraft.AircraftDerivedData;
import com.uranus.transition.common.asterix.uap.aircraft.MagneticHeading;
import com.uranus.transition.common.asterix.uap.comm.AcasResolutionReport;
import com.uranus.transition.common.asterix.uap.emitter.EmitterCategoryEnum;
import com.uranus.transition.common.asterix.uap.emitter.adsb.StatusByAdsb;
import com.uranus.transition.common.asterix.uap.emitter.modesel.CommAndStatusByModeSel;
import com.uranus.transition.common.asterix.uap.emitter.modesel.ModeSelMbData;
import com.uranus.transition.common.asterix.uap.identification.TargetAddress;
import com.uranus.transition.common.asterix.uap.identification.TargetIdentification;
import com.uranus.transition.common.asterix.uap.measure.SelectedAltitude;
import com.uranus.transition.common.asterix.uap.measure.VelocityUncertainty;
import com.uranus.transition.common.asterix.uap.measure.altitude.BarometricVerticalRate;
import com.uranus.transition.common.asterix.uap.measure.altitude.FinalStateSelectedAltitude;
import com.uranus.transition.common.asterix.uap.measure.altitude.GeometricAltitude;
import com.uranus.transition.common.asterix.uap.measure.altitude.GeometricVerticalRate;
import com.uranus.transition.common.asterix.uap.measure.angle.RollAngle;
import com.uranus.transition.common.asterix.uap.measure.angle.TrackAngle;
import com.uranus.transition.common.asterix.uap.measure.angle.TrackAngleRate;
import com.uranus.transition.common.asterix.uap.measure.position.PositionUncertainty;
import com.uranus.transition.common.asterix.uap.measure.position.Wgs84Position;
import com.uranus.transition.common.asterix.uap.measure.speed.Airspeed;
import com.uranus.transition.common.asterix.uap.measure.speed.GroundSpeed;
import com.uranus.transition.common.asterix.uap.measure.speed.TrueAirspeed;
import com.uranus.transition.common.asterix.uap.meteorology.BarometricPressureSetting;
import com.uranus.transition.common.asterix.uap.meteorology.MetData;
import com.uranus.transition.common.asterix.uap.trajectory.TrajectoryIntentData;
import com.uranus.transition.common.asterix.uap.trajectory.TrajectoryIntentStatus;
import com.uranus.transition.common.asterix.spec.*;

import java.util.List;

/**
 * AircraftDerivedDataMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/16
 */
public class AircraftDerivedDataMapper {

  public static AircraftDerivedData read(List<Byte> message, FieldSpec fieldSpec) {
    // Aircraft Derived Data: frn=11, size=1+

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(Cat062Config.AIRCRAFT_DERIVED_DATA_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int startIndex = fieldSpec.calculateIndexByFrn(Cat062Config.AIRCRAFT_DERIVED_DATA_FRN);

      AircraftDerivedData aircraftDerivedData = new AircraftDerivedData();

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.CAT062_AIRCRAFT_DERIVED_DATA);
      dataSpec.readValue(message, startIndex);
      aircraftDerivedData.setDataSpec(dataSpec);

      TargetAddress targetAddress = TargetAddressMapper.read(message, dataSpec);
      aircraftDerivedData.setTargetAddress(targetAddress);

      TargetIdentification targetIdentification =
          TargetIdentificationMapper.read(message, dataSpec);
      aircraftDerivedData.setTargetIdentification(targetIdentification);


      MagneticHeading magneticHeading = MagneticHeadingMapper.read(message, dataSpec);
      aircraftDerivedData.setMagneticHeading(magneticHeading);

      Airspeed airspeed = AirspeedMapper.read(message, dataSpec);
      aircraftDerivedData.setAirspeed(airspeed);

      TrueAirspeed trueAirspeed = TrueAirspeedMapper.read(message, dataSpec);
      aircraftDerivedData.setTrueAirspeed(trueAirspeed);

      SelectedAltitude selectedAltitude = SelectedAltitudeMapper.read(message, dataSpec);
      aircraftDerivedData.setSelectedAltitude(selectedAltitude);

      FinalStateSelectedAltitude finalStateSelectedAltitude =
          FinalStateSelectedAltitudeMapper.read(message, dataSpec);
      aircraftDerivedData.setFinalStateSelectedAltitude(finalStateSelectedAltitude);

      TrajectoryIntentStatus trajectoryIntentStatus =
          TrajectoryStatusMapper.read(message, dataSpec);
      aircraftDerivedData.setTrajectoryIntentStatus(trajectoryIntentStatus);

      TrajectoryIntentData trajectoryIntentData = TrajectoryDataMapper.read(message, dataSpec);
      aircraftDerivedData.setTrajectoryIntentData(trajectoryIntentData);

      CommAndStatusByModeSel commAndStatusByModeSel =
          CommAndStatusByModeSelMapper.read(message, dataSpec);
      aircraftDerivedData.setCommunicationCapability(commAndStatusByModeSel);

      StatusByAdsb statusByAdsb = StatusByAdsbMapper.read(message, dataSpec);
      aircraftDerivedData.setStatusByAdsb(statusByAdsb);

      AcasResolutionReport acasResolutionReport =
          AcasResolutionReportParser.read(message, dataSpec);
      aircraftDerivedData.setAcasResolutionAdvisory(acasResolutionReport);

      BarometricVerticalRate barometricVerticalRate =
          BarometricVerticalRateMapper.read(message, dataSpec);
      aircraftDerivedData.setBarometricVerticalRate(barometricVerticalRate);

      GeometricVerticalRate geometricVerticalRate =
          GeometricVerticalRateMapper.read(message, dataSpec);
      aircraftDerivedData.setGeometricVerticalRate(geometricVerticalRate);

      RollAngle rollAngle = RollAngleMapper.read(message, dataSpec);
      aircraftDerivedData.setRollAngle(rollAngle);

      TrackAngleRate trackAngleRate = TrackAngleRateMapper.read(message, dataSpec);
      aircraftDerivedData.setTrackAngleRate(trackAngleRate);

      TrackAngle trackAngle = TrackAngleMapper.read(message, dataSpec);
      aircraftDerivedData.setTrackAngle(trackAngle);

      GroundSpeed groundAirspeed = GroundAirspeedMapper.read(message, dataSpec);
      aircraftDerivedData.setGroundSpeed(groundAirspeed);

      VelocityUncertainty velocityUncertainty =
          VelocityUncertaintyMapper.readVelocityUncertainty(message, dataSpec);
      aircraftDerivedData.setVelocityUncertainty(velocityUncertainty);

      MetData metData = MetDataMapper.read(message, dataSpec);
      aircraftDerivedData.setMetData(metData);

      EmitterCategoryEnum emitterCategoryEnum =
          EmitterCategoryMapper.read(message, dataSpec);
      aircraftDerivedData.setEmitterCategory(emitterCategoryEnum);

      Wgs84Position position = PositionMapper.read(message, dataSpec);
      aircraftDerivedData.setPosition(position);

      GeometricAltitude geometricAltitude =
          GeometricAltitudeMapper.read(message, dataSpec);
      aircraftDerivedData.setGeometricAltitude(geometricAltitude);

      PositionUncertainty positionUncertainty =
          PositionUncertaintyMapper.readPositionUncertainty(message, dataSpec);
      aircraftDerivedData.setPositionUncertainty(positionUncertainty);

      ModeSelMbData modeSelMbData = ModeSelMapper.read(message, dataSpec);
      aircraftDerivedData.setModesMbData(modeSelMbData);

      Airspeed indicatedAirspeed = IndicatedAirspeedMapper.read(message, dataSpec);
      aircraftDerivedData.setIndicatedAirspeed(indicatedAirspeed);

      Airspeed mach = MachNumberMapper.read(message, dataSpec);
      aircraftDerivedData.setMachNumber(mach);

      BarometricPressureSetting barometricPressureSetting =
          BarometricPressureSettingMapper.read(message, dataSpec);
      aircraftDerivedData.setBarometricPressureSetting(barometricPressureSetting);

      fpIndicator.setSize(dataSpec.calculateTotalSize());

      return aircraftDerivedData;
    }
    return null;
  }
}
