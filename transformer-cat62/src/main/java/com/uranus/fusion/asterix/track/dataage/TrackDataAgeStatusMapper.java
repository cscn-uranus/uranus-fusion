package com.uranus.fusion.asterix.track.dataage;

import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DataSpecTypeEnum;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import java.util.List;

/**
 * TrackDataAgeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/9
 */
public class TrackDataAgeStatusMapper {

  public static TrackDataAgeStatus readTrackDataAge(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 16;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int startIndex = fieldSpec.calculateOctetIndexByFrn(frn);

      TrackDataAgeStatus trackDataAgeStatus = new TrackDataAgeStatus();

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.TRACK_DATA_AGES);
      dataSpec.readValue(uap, startIndex);

      TrackDataAge measuredFlightLevelAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 1);
      TrackDataAge mode1Age = TrackDataAgeMapper.readByDrn(uap, dataSpec, 2);
      TrackDataAge mode2Age = TrackDataAgeMapper.readByDrn(uap, dataSpec, 3);
      TrackDataAge mode3Age = TrackDataAgeMapper.readByDrn(uap, dataSpec, 4);
      TrackDataAge mode4Age = TrackDataAgeMapper.readByDrn(uap, dataSpec, 5);
      TrackDataAge mode5Age = TrackDataAgeMapper.readByDrn(uap, dataSpec, 6);
      TrackDataAge magneticHeadingAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 7);
      trackDataAgeStatus.setMeasuredFlightLevelAge(measuredFlightLevelAge);
      trackDataAgeStatus.setMode1Age(mode1Age);
      trackDataAgeStatus.setMode2Age(mode2Age);
      trackDataAgeStatus.setMode3Age(mode3Age);
      trackDataAgeStatus.setMode4Age(mode4Age);
      trackDataAgeStatus.setMode5Age(mode5Age);
      trackDataAgeStatus.setMagneticHeadingAge(magneticHeadingAge);

      TrackDataAge airspeedAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 8);
      TrackDataAge trueAirspeedAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 9);
      TrackDataAge selectedAltitudeAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 10);
      TrackDataAge finalSelectedAltitudeAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 11);
      TrackDataAge trajectoryIntentAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 12);
      TrackDataAge commAndStatusByModeSelectiveAge = TrackDataAgeMapper
          .readByDrn(uap, dataSpec, 13);
      TrackDataAge statusByAdsBroadcastAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 14);
      trackDataAgeStatus.setAirspeedAge(airspeedAge);
      trackDataAgeStatus.setTrueAirspeedAge(trueAirspeedAge);
      trackDataAgeStatus.setSelectedAltitudeAge(selectedAltitudeAge);
      trackDataAgeStatus.setFinalSelectedAltitudeAge(finalSelectedAltitudeAge);
      trackDataAgeStatus.setTrajectoryIntentAge(trajectoryIntentAge);
      trackDataAgeStatus.setCommAndStatusByModeSelectiveAge(commAndStatusByModeSelectiveAge);
      trackDataAgeStatus.setStatusByAdsBroadcastAge(statusByAdsBroadcastAge);

      TrackDataAge acasAdvisoryReportAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 15);
      TrackDataAge barometricVerticalRateAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 16);
      TrackDataAge geometricalVerticalRateAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 17);
      TrackDataAge rollAngleAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 18);
      TrackDataAge trackAngleRateAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 19);
      TrackDataAge trackAngleAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 20);
      TrackDataAge groundSpeedAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 21);
      trackDataAgeStatus.setAcasAdvisoryReportAge(acasAdvisoryReportAge);
      trackDataAgeStatus.setBarometricVerticalRateAge(barometricVerticalRateAge);
      trackDataAgeStatus.setGeometricalVerticalRateAge(geometricalVerticalRateAge);
      trackDataAgeStatus.setRollAngleAge(rollAngleAge);
      trackDataAgeStatus.setTrackAngleRateAge(trackAngleRateAge);
      trackDataAgeStatus.setTrackAngleAge(trackAngleAge);
      trackDataAgeStatus.setGroundSpeedAge(groundSpeedAge);


      TrackDataAge velocityUncertaintyAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 22);
      TrackDataAge meteorologicalDataAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 23);
      TrackDataAge emitterCategoryAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 24);
      TrackDataAge positionAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 25);
      TrackDataAge geometricAltitudeAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 26);
      TrackDataAge positionUncertaintyAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 27);
      TrackDataAge modeSelMbDataAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 28);
      trackDataAgeStatus.setVelocityUncertaintyAge(velocityUncertaintyAge);
      trackDataAgeStatus.setMeteorologicalDataAge(meteorologicalDataAge);
      trackDataAgeStatus.setEmitterCategoryAge(emitterCategoryAge);
      trackDataAgeStatus.setPositionAge(positionAge);
      trackDataAgeStatus.setGeometricAltitudeAge(geometricAltitudeAge);
      trackDataAgeStatus.setPositionUncertaintyAge(positionUncertaintyAge);
      trackDataAgeStatus.setModeSelMbDataAge(modeSelMbDataAge);

      TrackDataAge indicatedAirspeedDataAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 29);
      TrackDataAge machNumberDataAge = TrackDataAgeMapper.readByDrn(uap, dataSpec, 30);
      TrackDataAge barometricPressureSettingDataAge = TrackDataAgeMapper
          .readByDrn(uap, dataSpec, 31);
      trackDataAgeStatus.setIndicatedAirspeedDataAge(indicatedAirspeedDataAge);
      trackDataAgeStatus.setMachNumberDataAge(machNumberDataAge);
      trackDataAgeStatus.setBarometricPressureSettingDataAge(barometricPressureSettingDataAge);

      fpIndicator.setSize(dataSpec.calculateTotalSize());
      return trackDataAgeStatus;
    }
    return null;
  }
}
