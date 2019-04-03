package com.uranus.fusion.transformer.asterix.aircraft;

import com.uranus.fusion.transformer.asterix.aircraft.fcu.FinalStateSelectedAltitude;
import com.uranus.fusion.transformer.asterix.aircraft.fcu.FinalStateSelectedAltitudeMapper;
import com.uranus.fusion.transformer.asterix.aircraft.fcu.SelectedAltitude;
import com.uranus.fusion.transformer.asterix.aircraft.fcu.SelectedAltitudeMapper;
import com.uranus.fusion.transformer.asterix.aircraft.identity.TargetAddress;
import com.uranus.fusion.transformer.asterix.aircraft.identity.TargetAddressMapper;
import com.uranus.fusion.transformer.asterix.aircraft.identity.TargetIdentification;
import com.uranus.fusion.transformer.asterix.aircraft.identity.TargetIdentificationMapper;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.EmitterCategoryEnum;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.EmitterCategoryMapper;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.acas.AcasResolutionReport;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.acas.AcasResolutionReportMapper;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.adsb.StatusByAdsBroadcast;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.adsb.StatusByAdsBroadcastMapper;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.comm.CommAndStatusByModeSel;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.comm.CommAndStatusByModeSelMapper;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.modeselective.ModeSelMapper;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.modeselective.ModeSelMbData;
import com.uranus.fusion.transformer.asterix.aircraft.nd.MagneticHeading;
import com.uranus.fusion.transformer.asterix.aircraft.nd.MagneticHeadingMapper;
import com.uranus.fusion.transformer.asterix.aircraft.nd.PositionMapper;
import com.uranus.fusion.transformer.asterix.aircraft.nd.PositionUncertainty;
import com.uranus.fusion.transformer.asterix.aircraft.nd.PositionUncertaintyMapper;
import com.uranus.fusion.transformer.asterix.aircraft.nd.TrajectoryIntentData;
import com.uranus.fusion.transformer.asterix.aircraft.nd.TrajectoryIntentStatus;
import com.uranus.fusion.transformer.asterix.aircraft.nd.TrajectoryMapper;
import com.uranus.fusion.transformer.asterix.aircraft.nd.VelocityUncertainty;
import com.uranus.fusion.transformer.asterix.aircraft.nd.VelocityUncertaintyMapper;
import com.uranus.fusion.transformer.asterix.aircraft.pfd.SpeedMapper;
import com.uranus.fusion.transformer.asterix.aircraft.pfd.BarometricPressureSetting;
import com.uranus.fusion.transformer.asterix.aircraft.pfd.BarometricPressureSettingMapper;
import com.uranus.fusion.transformer.asterix.measure.BarometricVerticalRate;
import com.uranus.fusion.transformer.asterix.aircraft.pfd.BarometricVerticalRateMapper;
import com.uranus.fusion.transformer.asterix.aircraft.pfd.GeometricAltitudeMapper;
import com.uranus.fusion.transformer.asterix.aircraft.pfd.GeometricVerticalRateMapper;
import com.uranus.fusion.transformer.asterix.aircraft.pfd.MeteorologicalData;
import com.uranus.fusion.transformer.asterix.aircraft.pfd.MeteorologicalDataMapper;
import com.uranus.fusion.transformer.asterix.aircraft.pfd.RollAngleMapper;
import com.uranus.fusion.transformer.asterix.aircraft.pfd.TrackAngleMapper;
import com.uranus.fusion.transformer.asterix.aircraft.pfd.TrackAngleRateMapper;
import com.uranus.fusion.transformer.asterix.measure.GeometricAltitude;
import com.uranus.fusion.transformer.asterix.measure.GeometricVerticalRate;
import com.uranus.fusion.transformer.asterix.measure.GroundSpeed;
import com.uranus.fusion.transformer.asterix.measure.IndicatedAirspeed;
import com.uranus.fusion.transformer.asterix.measure.RollAngle;
import com.uranus.fusion.transformer.asterix.measure.TrackAngle;
import com.uranus.fusion.transformer.asterix.measure.TrackAngleRate;
import com.uranus.fusion.transformer.asterix.measure.TrueAirspeed;
import com.uranus.fusion.transformer.asterix.measure.Wgs84Position;
import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.message.spec.DataSpecTypeEnum;
import com.uranus.fusion.transformer.asterix.message.spec.FieldSpec;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicator;
import java.util.List;

/**
 * AircraftDerivedDataMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/16
 */
public class AircraftDerivedDataMapper {

  public static AircraftDerivedData readAircraftDerivedData(
      List<Byte> uap, FieldSpec fieldSpec) {
    // Aircraft Derived Data frn=11
    final int frn = 11;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int startIndex = fieldSpec.calculateOctetIndexByFrn(frn);

      AircraftDerivedData aircraftDerivedData = new AircraftDerivedData();

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.AIRCRAFT_DERIVED_DATA);
      dataSpec.readValue(uap, startIndex);

      TargetAddress targetAddress = TargetAddressMapper.read(uap, dataSpec);
      aircraftDerivedData.setTargetAddress(targetAddress);

      TargetIdentification targetIdentification = TargetIdentificationMapper.read(uap, dataSpec);
      aircraftDerivedData.setTargetIdentification(targetIdentification);

      MagneticHeading magneticHeading = MagneticHeadingMapper.read(uap, dataSpec);
      aircraftDerivedData.setMagneticHeading(magneticHeading);

      IndicatedAirspeed airspeed = SpeedMapper.readIndicatedAirspeed(uap, dataSpec);
      aircraftDerivedData.setIndicatedAirspeed(airspeed);

      TrueAirspeed trueAirspeed = SpeedMapper.readTrueAirspeed(uap, dataSpec);
      aircraftDerivedData.setTrueAirspeed(trueAirspeed);

      SelectedAltitude selectedAltitude =
          SelectedAltitudeMapper.readSelectedAltitude(uap, dataSpec);
      aircraftDerivedData.setSelectedAltitude(selectedAltitude);

      FinalStateSelectedAltitude finalStateSelectedAltitude =
          FinalStateSelectedAltitudeMapper
              .readFinalStateSelectedAltitude(uap, dataSpec);
      aircraftDerivedData.setFinalStateSelectedAltitude(finalStateSelectedAltitude);

      TrajectoryIntentStatus trajectoryIntentStatus =
          TrajectoryMapper.readTrajectoryIntentStatus(uap, dataSpec);
      aircraftDerivedData.setTrajectoryIntentStatus(trajectoryIntentStatus);

      TrajectoryIntentData trajectoryIntentData =
          TrajectoryMapper.readTrajectoryIntentData(uap, dataSpec);
      aircraftDerivedData.setTrajectoryIntentData(trajectoryIntentData);

      CommAndStatusByModeSel commAndStatusByModeSel =
          CommAndStatusByModeSelMapper.read(
              uap, dataSpec);
      aircraftDerivedData.setCommunicationCapability(commAndStatusByModeSel);

      StatusByAdsBroadcast statusByAdsBroadcast = StatusByAdsBroadcastMapper
          .readStatusReportedByAdsB(uap, dataSpec);
      aircraftDerivedData.setStatusByAdsBroadcast(statusByAdsBroadcast);

      AcasResolutionReport acasResolutionReport =
          AcasResolutionReportMapper
              .readAcasResolutionAdvisoryReport(uap, dataSpec);
      aircraftDerivedData.setAcasResolutionAdvisory(acasResolutionReport);

      BarometricVerticalRate barometricVerticalRate =
          BarometricVerticalRateMapper.readBarometricVerticalRate(uap, dataSpec);
      aircraftDerivedData.setBarometricVerticalRate(barometricVerticalRate);

      GeometricVerticalRate geometricVerticalRate =
          GeometricVerticalRateMapper.readGeometricVerticalRate(uap, dataSpec);
      aircraftDerivedData.setGeometricVerticalRate(geometricVerticalRate);

      RollAngle rollAngle = RollAngleMapper.readRollAngle(uap, dataSpec);
      aircraftDerivedData.setRollAngle(rollAngle);

      TrackAngleRate trackAngleRate = TrackAngleRateMapper
          .readTrackAngleRate(uap, dataSpec);
      aircraftDerivedData.setTrackAngleRate(trackAngleRate);

      TrackAngle trackAngle = TrackAngleMapper.readTrackAngle(uap, dataSpec);
      aircraftDerivedData.setTrackAngle(trackAngle);

      GroundSpeed groundAirspeed = SpeedMapper.readGroundSpeed(uap, dataSpec);
      aircraftDerivedData.setGroundAirspeed(groundAirspeed);

      VelocityUncertainty velocityUncertainty =
          VelocityUncertaintyMapper.readVelocityUncertainty(uap, dataSpec);
      aircraftDerivedData.setVelocityUncertainty(velocityUncertainty);

      MeteorologicalData meteorologicalData = MeteorologicalDataMapper.readMetData(uap, dataSpec);
      aircraftDerivedData.setMeteorologicalData(meteorologicalData);

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

      IndicatedAirspeed indicatedAirspeed = SpeedMapper.readIndicatedAirSpeedOfKt(uap, dataSpec);
      aircraftDerivedData.setIndicatedIndicatedAirspeedOfKt(indicatedAirspeed);

      IndicatedAirspeed mach = SpeedMapper.readIndicatedAirspeedOfMach(uap, dataSpec);
      aircraftDerivedData.setIndicatedIndicatedAirspeedOfMach(mach);

      BarometricPressureSetting barometricPressureSetting =
          BarometricPressureSettingMapper
              .readBarometricPressureSetting(uap, dataSpec);
      aircraftDerivedData.setBarometricPressureSetting(barometricPressureSetting);

      fpIndicator.setSize(dataSpec.calculateTotalSize());

      return aircraftDerivedData;
    }
    return null;
  }

}
