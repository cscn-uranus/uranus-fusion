package com.uranus.transition.reader.eucat062.aircraftdata;

import com.uranus.transition.reader.eucat062.EuCat062Config;
import com.uranus.transition.common.asterix.uap.eucat062.AircraftDerivedData;
import com.uranus.transition.common.asterix.uap.shared.aircraft.MagneticHeading;
import com.uranus.transition.common.asterix.uap.shared.comm.AcasResolutionReport;
import com.uranus.transition.common.asterix.uap.shared.emitter.EmitterCategoryEnum;
import com.uranus.transition.common.asterix.uap.shared.emitter.adsb.StatusByAdsb;
import com.uranus.transition.common.asterix.uap.shared.emitter.modesel.CommAndStatusByModeSel;
import com.uranus.transition.common.asterix.uap.shared.emitter.modesel.ModeSelMbData;
import com.uranus.transition.common.asterix.uap.shared.identification.TargetAddress;
import com.uranus.transition.common.asterix.uap.shared.identification.TargetIdentification;
import com.uranus.transition.common.asterix.uap.shared.measure.SelectedAltitude;
import com.uranus.transition.common.asterix.uap.shared.measure.VelocityUncertainty;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.BarometricVerticalRate;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.FinalStateSelectedAltitude;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.GeometricAltitude;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.GeometricVerticalRate;
import com.uranus.transition.common.asterix.uap.shared.measure.angle.RollAngle;
import com.uranus.transition.common.asterix.uap.shared.measure.angle.TrackAngle;
import com.uranus.transition.common.asterix.uap.shared.measure.angle.TrackAngleRate;
import com.uranus.transition.common.asterix.uap.shared.measure.position.PositionUncertainty;
import com.uranus.transition.common.asterix.uap.shared.measure.position.Wgs84Position;
import com.uranus.transition.common.asterix.uap.shared.measure.speed.Airspeed;
import com.uranus.transition.common.asterix.uap.shared.measure.speed.GroundSpeed;
import com.uranus.transition.common.asterix.uap.shared.measure.speed.TrueAirspeed;
import com.uranus.transition.common.asterix.uap.shared.meteorology.BarometricPressureSetting;
import com.uranus.transition.common.asterix.uap.shared.meteorology.MetData;
import com.uranus.transition.common.asterix.uap.shared.trajectory.TrajectoryIntentData;
import com.uranus.transition.common.asterix.uap.shared.trajectory.TrajectoryIntentStatus;
import com.uranus.transition.common.asterix.spec.*;

import java.util.List;

/**
 * AircraftDerivedDataReader
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/16
 */
public class AircraftDerivedDataReader {

  public static AircraftDerivedData read(List<Byte> message, FieldSpec fieldSpec) {
    // Aircraft Derived Data: frn=11, size=1+

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(EuCat062Config.AIRCRAFT_DERIVED_DATA_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int startIndex = fieldSpec.calculateIndexByFrn(EuCat062Config.AIRCRAFT_DERIVED_DATA_FRN);

      AircraftDerivedData aircraftDerivedData = new AircraftDerivedData();

      DataSpecParameter dataSpecParameter = new AircraftDerivedDataSpecParameter();
      DataSpec dataSpec = new DataSpec(startIndex,dataSpecParameter);
      dataSpec.readValue(message);
      aircraftDerivedData.setDataSpec(dataSpec);

      TargetAddress targetAddress = TargetAddressReader.read(message, dataSpec);
      aircraftDerivedData.setTargetAddress(targetAddress);

      TargetIdentification targetIdentification =
          TargetIdentificationReader.read(message, dataSpec);
      aircraftDerivedData.setTargetIdentification(targetIdentification);


      MagneticHeading magneticHeading = MagneticHeadingReader.read(message, dataSpec);
      aircraftDerivedData.setMagneticHeading(magneticHeading);

      Airspeed airspeed = AirspeedReader.read(message, dataSpec);
      aircraftDerivedData.setAirspeed(airspeed);

      TrueAirspeed trueAirspeed = TrueAirspeedReader.read(message, dataSpec);
      aircraftDerivedData.setTrueAirspeed(trueAirspeed);

      SelectedAltitude selectedAltitude = SelectedAltitudeReader.read(message, dataSpec);
      aircraftDerivedData.setSelectedAltitude(selectedAltitude);

      FinalStateSelectedAltitude finalStateSelectedAltitude =
          FinalStateSelectedAltitudeReader.read(message, dataSpec);
      aircraftDerivedData.setFinalStateSelectedAltitude(finalStateSelectedAltitude);

      TrajectoryIntentStatus trajectoryIntentStatus =
          TrajectoryStatusReader.read(message, dataSpec);
      aircraftDerivedData.setTrajectoryIntentStatus(trajectoryIntentStatus);

      TrajectoryIntentData trajectoryIntentData = TrajectoryDataReader.read(message, dataSpec);
      aircraftDerivedData.setTrajectoryIntentData(trajectoryIntentData);

      CommAndStatusByModeSel commAndStatusByModeSel =
          CommAndStatusByModeselReader.read(message, dataSpec);
      aircraftDerivedData.setCommunicationCapability(commAndStatusByModeSel);

      StatusByAdsb statusByAdsb = StatusByAdsbReader.read(message, dataSpec);
      aircraftDerivedData.setStatusByAdsb(statusByAdsb);

      AcasResolutionReport acasResolutionReport =
          AcasResolutionReportReader.read(message, dataSpec);
      aircraftDerivedData.setAcasResolutionAdvisory(acasResolutionReport);

      BarometricVerticalRate barometricVerticalRate =
          BarometricVerticalRateReader.read(message, dataSpec);
      aircraftDerivedData.setBarometricVerticalRate(barometricVerticalRate);

      GeometricVerticalRate geometricVerticalRate =
          GeometricVerticalRateReader.read(message, dataSpec);
      aircraftDerivedData.setGeometricVerticalRate(geometricVerticalRate);

      RollAngle rollAngle = RollAngleReader.read(message, dataSpec);
      aircraftDerivedData.setRollAngle(rollAngle);

      TrackAngleRate trackAngleRate = TrackAngleRateReader.read(message, dataSpec);
      aircraftDerivedData.setTrackAngleRate(trackAngleRate);

      TrackAngle trackAngle = TrackAngleReader.read(message, dataSpec);
      aircraftDerivedData.setTrackAngle(trackAngle);

      GroundSpeed groundAirspeed = GroundAirspeedReader.read(message, dataSpec);
      aircraftDerivedData.setGroundSpeed(groundAirspeed);

      VelocityUncertainty velocityUncertainty =
          VelocityUncertaintyReader.readVelocityUncertainty(message, dataSpec);
      aircraftDerivedData.setVelocityUncertainty(velocityUncertainty);

      MetData metData = MetDataReader.read(message, dataSpec);
      aircraftDerivedData.setMetData(metData);

      EmitterCategoryEnum emitterCategoryEnum =
          EmitterCategoryReader.read(message, dataSpec);
      aircraftDerivedData.setEmitterCategory(emitterCategoryEnum);

      Wgs84Position position = PositionReader.read(message, dataSpec);
      aircraftDerivedData.setPosition(position);

      GeometricAltitude geometricAltitude =
          GeometricAltitudeReader.read(message, dataSpec);
      aircraftDerivedData.setGeometricAltitude(geometricAltitude);

      PositionUncertainty positionUncertainty =
          PositionUncertaintyReader.read(message, dataSpec);
      aircraftDerivedData.setPositionUncertainty(positionUncertainty);

      ModeSelMbData modeSelMbData = ModeselReader.read(message, dataSpec);
      aircraftDerivedData.setModesMbData(modeSelMbData);

      Airspeed indicatedAirspeed = IndicatedAirspeedReader.read(message, dataSpec);
      aircraftDerivedData.setIndicatedAirspeed(indicatedAirspeed);

      Airspeed mach = MachNumberReader.read(message, dataSpec);
      aircraftDerivedData.setMachNumber(mach);

      BarometricPressureSetting barometricPressureSetting =
          BarometricPressureSettingReader.read(message, dataSpec);
      aircraftDerivedData.setBarometricPressureSetting(barometricPressureSetting);

      fpIndicator.setSize(dataSpec.calculateTotalSize());

      return aircraftDerivedData;
    }
    return null;
  }
}
