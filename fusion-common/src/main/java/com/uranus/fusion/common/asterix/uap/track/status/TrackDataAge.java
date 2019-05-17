package com.uranus.fusion.common.asterix.uap.track.status;

import com.uranus.fusion.common.asterix.uap.track.DataAge;
import lombok.Data;

/**
 * TrackDataAge
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/9
 */
@Data
public class TrackDataAge {

  private DataAge measuredFlightLevelAge;
  private DataAge mode1Age;
  private DataAge mode2Age;
  private DataAge mode3Age;
  private DataAge mode4Age;
  private DataAge mode5Age;
  private DataAge magneticHeadingAge;

  private DataAge airspeedAge;
  private DataAge trueAirspeedAge;
  private DataAge selectedAltitudeAge;
  private DataAge finalSelectedAltitudeAge;
  private DataAge trajectoryIntentAge;
  private DataAge commAndStatusByModeSelectiveAge;
  private DataAge statusByAdsBroadcastAge;

  private DataAge acasAdvisoryReportAge;
  private DataAge barometricVerticalRateAge;
  private DataAge geometricalVerticalRateAge;
  private DataAge rollAngleAge;
  private DataAge trackAngleRateAge;
  private DataAge trackAngleAge;
  private DataAge groundSpeedAge;

  private DataAge velocityUncertaintyAge;
  private DataAge meteorologicalDataAge;
  private DataAge emitterCategoryAge;
  private DataAge positionAge;
  private DataAge geometricAltitudeAge;
  private DataAge positionUncertaintyAge;
  private DataAge modeSelMbDataAge;

  private DataAge indicatedAirspeedDataAge;
  private DataAge machNumberDataAge;
  private DataAge barometricPressureSettingDataAge;
}
