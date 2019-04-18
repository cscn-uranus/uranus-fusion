package com.uranus.fusion.asterix.uap.aircraft;

import com.uranus.fusion.asterix.spec.DataSpec;
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
import lombok.Data;

/**
 * AircraftDerivedData
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
@Data
public class AircraftDerivedData {

  private DataSpec dataSpec;

  private TargetAddress targetAddress;
  private TargetIdentification targetIdentification;
  private MagneticHeading magneticHeading;
  private Airspeed airspeed;
  private TrueAirspeed trueAirspeed;
  private SelectedAltitude selectedAltitude;
  private FinalStateSelectedAltitude finalStateSelectedAltitude;

  private TrajectoryIntentStatus trajectoryIntentStatus;
  private TrajectoryIntentData trajectoryIntentData;

  private CommAndStatusByModeSel communicationCapability;

  private StatusByAdsb statusByAdsb;
  private AcasResolutionReport acasResolutionAdvisory;

  private BarometricVerticalRate barometricVerticalRate;
  private GeometricVerticalRate geometricVerticalRate;

  private RollAngle rollAngle;
  private TrackAngleRate trackAngleRate;
  private TrackAngle trackAngle;

  private GroundSpeed groundAirspeed;

  private VelocityUncertainty velocityUncertainty;

  private MetData metData;
  private EmitterCategoryEnum emitterCategory;
  private Wgs84Position position;
  private GeometricAltitude geometricAltitude;

  private PositionUncertainty positionUncertainty;
  private ModeSelMbData modesMbData;
  private Airspeed indicatedAirspeed;
  private Airspeed machNumber;
  private BarometricPressureSetting barometricPressureSetting;
}
