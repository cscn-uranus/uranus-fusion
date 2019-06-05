package com.uranus.transition.common.asterix.cat062.dataage;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.spec.*;
import com.uranus.transition.common.asterix.uap.track.DataAge;
import com.uranus.transition.common.asterix.uap.track.status.TrackDataAge;
import com.uranus.transition.common.asterix.cat062.dataage.sub.*;

import java.util.List;

/**
 * TrackDataAgeMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
public class TrackDataAgeMapper {

  public static TrackDataAge read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(Cat062Config.TRACK_DATA_AGES_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int startIndex = fieldSpec.calculateIndexByFrn(Cat062Config.TRACK_DATA_AGES_FRN);

      TrackDataAge trackDataAge = new TrackDataAge();

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.CAT062_TRACK_DATA_AGES);
      dataSpec.readValue(uap, startIndex);

      DataAge measuredFlightLevelAge = MeasuredFlightLevelDataAgeMapper.read(uap, dataSpec);
      DataAge mode1Age = Mode1DataAgeMapper.read(uap, dataSpec);
      DataAge mode2Age = Mode2DataAgeMapper.read(uap, dataSpec);
      DataAge mode3Age = Mode3DataAgeMapper.read(uap, dataSpec);
      DataAge mode4Age = Mode4DataAgeMapper.read(uap, dataSpec);
      DataAge mode5Age = Mode5DataAgeMapper.read(uap, dataSpec);
      DataAge magneticHeadingAge = MagneticHeadingDataAgeMapper.read(uap, dataSpec);
      trackDataAge.setMeasuredFlightLevelAge(measuredFlightLevelAge);
      trackDataAge.setMode1Age(mode1Age);
      trackDataAge.setMode2Age(mode2Age);
      trackDataAge.setMode3Age(mode3Age);
      trackDataAge.setMode4Age(mode4Age);
      trackDataAge.setMode5Age(mode5Age);
      trackDataAge.setMagneticHeadingAge(magneticHeadingAge);

      DataAge airspeedAge = AirspeedDataAgeMapper.read(uap, dataSpec);
      DataAge trueAirspeedAge = TrueAirspeedDataAgeMapper.read(uap, dataSpec);
      DataAge selectedAltitudeAge = SelectedAltitudeDataAgeMapper.read(uap, dataSpec);
      DataAge finalSelectedAltitudeAge =
          FinalStateSelectedAltitudeDataAgeMapper.read(uap, dataSpec);
      DataAge trajectoryIntentAge = TrajectoryIntentDataAgeMapper.read(uap, dataSpec);
      DataAge commAndStatusByModeSelectiveAge =
          CommAndFlightStatusDataAgeMapper.read(uap, dataSpec);
      DataAge statusByAdsbAge = StatusReportByAdsbDataAgeMapper.read(uap, dataSpec);
      trackDataAge.setAirspeedAge(airspeedAge);
      trackDataAge.setTrueAirspeedAge(trueAirspeedAge);
      trackDataAge.setSelectedAltitudeAge(selectedAltitudeAge);
      trackDataAge.setFinalSelectedAltitudeAge(finalSelectedAltitudeAge);
      trackDataAge.setTrajectoryIntentAge(trajectoryIntentAge);
      trackDataAge.setCommAndStatusByModeSelectiveAge(commAndStatusByModeSelectiveAge);
      trackDataAge.setStatusByAdsBroadcastAge(statusByAdsbAge);

      DataAge acasAdvisoryReportAge = AcasResolutionAdvisoryReportDataAgeMapper.read(uap, dataSpec);
      DataAge barometricVerticalRateAge = BarometricVerticalRateDataAgeMapper.read(uap, dataSpec);
      DataAge geometricalVerticalRateAge = GeometricalVerticalRateDataAgeMapper.read(uap, dataSpec);
      DataAge rollAngleAge = RollAngleDataAgeMapper.read(uap, dataSpec);
      DataAge trackAngleRateAge = TrackAngleRateDataAgeMapper.read(uap, dataSpec);
      DataAge trackAngleAge = TrackAngleDataAgeMapper.read(uap, dataSpec);
      DataAge groundSpeedAge = GroundSpeedDataAgeMapper.read(uap, dataSpec);
      trackDataAge.setAcasAdvisoryReportAge(acasAdvisoryReportAge);
      trackDataAge.setBarometricVerticalRateAge(barometricVerticalRateAge);
      trackDataAge.setGeometricalVerticalRateAge(geometricalVerticalRateAge);
      trackDataAge.setRollAngleAge(rollAngleAge);
      trackDataAge.setTrackAngleRateAge(trackAngleRateAge);
      trackDataAge.setTrackAngleAge(trackAngleAge);
      trackDataAge.setGroundSpeedAge(groundSpeedAge);

      DataAge velocityUncertaintyAge = VelocityUncertaintyDataAgeMapper.read(uap, dataSpec);
      DataAge metDataAge = MetDataAgeMapper.read(uap, dataSpec);
      DataAge emitterCategoryAge = EmitterCategoryDataAgeMapper.read(uap, dataSpec);
      DataAge positionAge = PositionDataAgeMapper.read(uap, dataSpec);
      DataAge geometricAltitudeAge = GeometricAltitudeDataAgeMapper.read(uap, dataSpec);
      DataAge positionUncertaintyAge = PositionUncertaintyDataAgeMapper.read(uap, dataSpec);
      DataAge modeSelMbDataAge = ModeSelMbDataAgeMapper.read(uap, dataSpec);
      trackDataAge.setVelocityUncertaintyAge(velocityUncertaintyAge);
      trackDataAge.setMeteorologicalDataAge(metDataAge);
      trackDataAge.setEmitterCategoryAge(emitterCategoryAge);
      trackDataAge.setPositionAge(positionAge);
      trackDataAge.setGeometricAltitudeAge(geometricAltitudeAge);
      trackDataAge.setPositionUncertaintyAge(positionUncertaintyAge);
      trackDataAge.setModeSelMbDataAge(modeSelMbDataAge);

      DataAge indicatedAirspeedDataAge = IndicatedAirspeedDataAgeMapper.read(uap, dataSpec);
      DataAge machNumberDataAge = MachNumberDataAgeMapper.read(uap, dataSpec);
      DataAge barometricPressureSettingDataAge =
          BarometricPressureSettingDataAgeMapper.read(uap, dataSpec);
      trackDataAge.setIndicatedAirspeedDataAge(indicatedAirspeedDataAge);
      trackDataAge.setMachNumberDataAge(machNumberDataAge);
      trackDataAge.setBarometricPressureSettingDataAge(barometricPressureSettingDataAge);

      fpIndicator.setSize(dataSpec.calculateTotalSize());
      return trackDataAge;
    }
    return null;
  }
}
