package com.uranus.transition.common.asterix.cat062.dataage;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.spec.*;
import com.uranus.transition.common.asterix.uap.track.DataAge;
import com.uranus.transition.common.asterix.uap.track.status.TrackDataAge;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
public class TrackDataAgeMapper {

  public static TrackDataAge read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(Cat062Config.TRACK_DATA_AGES_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int startIndex = fieldSpec.calculateIndexByFrn(Cat062Config.TRACK_DATA_AGES_FRN);

      TrackDataAge trackDataAge = new TrackDataAge();

      DataSpecParameter dataSpecParameter = new TrackDataAgeDataSpecParameter();
      DataSpec dataSpec = new DataSpec(startIndex, dataSpecParameter);
      dataSpec.readValue(message);

      DataAge measuredFlightLevelAge = MeasuredFlightLevelDataAgeMapper.read(message, dataSpec);
      DataAge mode1Age = Mode1DataAgeReader.read(message, dataSpec);
      DataAge mode2Age = Mode2DataAgeReader.read(message, dataSpec);
      DataAge mode3Age = Mode3DataAgeReader.read(message, dataSpec);
      DataAge mode4Age = Mode4DataAgeReader.read(message, dataSpec);
      DataAge mode5Age = Mode5DataAgeReader.read(message, dataSpec);
      DataAge magneticHeadingAge = MagneticHeadingDataAgeReader.read(message, dataSpec);
      trackDataAge.setMeasuredFlightLevelAge(measuredFlightLevelAge);
      trackDataAge.setMode1Age(mode1Age);
      trackDataAge.setMode2Age(mode2Age);
      trackDataAge.setMode3Age(mode3Age);
      trackDataAge.setMode4Age(mode4Age);
      trackDataAge.setMode5Age(mode5Age);
      trackDataAge.setMagneticHeadingAge(magneticHeadingAge);

      DataAge airspeedAge = AirspeedDataAgeReader.read(message, dataSpec);
      DataAge trueAirspeedAge = TrueAirspeedDataAgeReader.read(message, dataSpec);
      DataAge selectedAltitudeAge = SelectedAltitudeDataAgeReader.read(message, dataSpec);
      DataAge finalSelectedAltitudeAge =
          FinalStateSelectedAltitudeDataAgeReader.read(message, dataSpec);
      DataAge trajectoryIntentAge = TrajectoryIntentDataAgeReader.read(message, dataSpec);
      DataAge commAndStatusByModeSelectiveAge =
          CommAndFlightStatusDataAgeReader.read(message, dataSpec);
      DataAge statusByAdsbAge = StatusReportByAdsbDataAgeReader.read(message, dataSpec);
      trackDataAge.setAirspeedAge(airspeedAge);
      trackDataAge.setTrueAirspeedAge(trueAirspeedAge);
      trackDataAge.setSelectedAltitudeAge(selectedAltitudeAge);
      trackDataAge.setFinalSelectedAltitudeAge(finalSelectedAltitudeAge);
      trackDataAge.setTrajectoryIntentAge(trajectoryIntentAge);
      trackDataAge.setCommAndStatusByModeSelectiveAge(commAndStatusByModeSelectiveAge);
      trackDataAge.setStatusByAdsBroadcastAge(statusByAdsbAge);

      DataAge acasAdvisoryReportAge = AcasResolutionAdvisoryReportDataAgeReader.read(message, dataSpec);
      DataAge barometricVerticalRateAge = BarometricVerticalRateDataAgeReader.read(message, dataSpec);
      DataAge geometricalVerticalRateAge = GeometricalVerticalRateDataAgeReader.read(message, dataSpec);
      DataAge rollAngleAge = RollAngleDataAgeReader.read(message, dataSpec);
      DataAge trackAngleRateAge = TrackAngleRateDataAgeReader.read(message, dataSpec);
      DataAge trackAngleAge = TrackAngleDataAgeReader.read(message, dataSpec);
      DataAge groundSpeedAge = GroundSpeedDataAgeReader.read(message, dataSpec);
      trackDataAge.setAcasAdvisoryReportAge(acasAdvisoryReportAge);
      trackDataAge.setBarometricVerticalRateAge(barometricVerticalRateAge);
      trackDataAge.setGeometricalVerticalRateAge(geometricalVerticalRateAge);
      trackDataAge.setRollAngleAge(rollAngleAge);
      trackDataAge.setTrackAngleRateAge(trackAngleRateAge);
      trackDataAge.setTrackAngleAge(trackAngleAge);
      trackDataAge.setGroundSpeedAge(groundSpeedAge);

      DataAge velocityUncertaintyAge = VelocityUncertaintyDataAgeReader.read(message, dataSpec);
      DataAge metDataAge = MetDataAgeReader.read(message, dataSpec);
      DataAge emitterCategoryAge = EmitterCategoryDataAgeReader.read(message, dataSpec);
      DataAge positionAge = PositionDataAgeReader.read(message, dataSpec);
      DataAge geometricAltitudeAge = GeometricAltitudeDataAgeReader.read(message, dataSpec);
      DataAge positionUncertaintyAge = PositionUncertaintyDataAgeReader.read(message, dataSpec);
      DataAge modeSelMbDataAge = ModeselMbDataAgeReader.read(message, dataSpec);
      trackDataAge.setVelocityUncertaintyAge(velocityUncertaintyAge);
      trackDataAge.setMeteorologicalDataAge(metDataAge);
      trackDataAge.setEmitterCategoryAge(emitterCategoryAge);
      trackDataAge.setPositionAge(positionAge);
      trackDataAge.setGeometricAltitudeAge(geometricAltitudeAge);
      trackDataAge.setPositionUncertaintyAge(positionUncertaintyAge);
      trackDataAge.setModeSelMbDataAge(modeSelMbDataAge);

      DataAge indicatedAirspeedDataAge = IndicatedAirspeedDataAgeReader.read(message, dataSpec);
      DataAge machNumberDataAge = MachNumberDataAgeReader.read(message, dataSpec);
      DataAge barometricPressureSettingDataAge =
          BarometricPressureSettingDataAgeReader.read(message, dataSpec);
      trackDataAge.setIndicatedAirspeedDataAge(indicatedAirspeedDataAge);
      trackDataAge.setMachNumberDataAge(machNumberDataAge);
      trackDataAge.setBarometricPressureSettingDataAge(barometricPressureSettingDataAge);

      fpIndicator.setSize(dataSpec.calculateTotalSize());
      return trackDataAge;
    }
    return null;
  }
}
