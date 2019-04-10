package com.uranus.fusion.asterix.aircraft;

import com.uranus.fusion.asterix.aircraft.fcu.FinalStateSelectedAltitude;
import com.uranus.fusion.asterix.aircraft.fcu.SelectedAltitude;
import com.uranus.fusion.asterix.aircraft.identity.TargetAddress;
import com.uranus.fusion.asterix.aircraft.identity.TargetIdentification;
import com.uranus.fusion.asterix.aircraft.nd.*;
import com.uranus.fusion.asterix.aircraft.pfd.BarometricPressureSetting;
import com.uranus.fusion.asterix.aircraft.pfd.MeteorologicalData;
import com.uranus.fusion.asterix.aircraft.transponder.EmitterCategoryEnum;
import com.uranus.fusion.asterix.aircraft.transponder.acas.AcasResolutionReport;
import com.uranus.fusion.asterix.aircraft.transponder.adsb.StatusByAdsBroadcast;
import com.uranus.fusion.asterix.aircraft.transponder.comm.CommAndStatusByModeSel;
import com.uranus.fusion.asterix.aircraft.transponder.modeselective.ModeSelMbData;
import com.uranus.fusion.asterix.measure.*;
import com.uranus.fusion.asterix.spec.DataSpec;
import lombok.Data;

/**
 * AircraftDerivedData
 *
 * @author 肖鹏 tellxp@github.com
 * date 2018/10/15
 */
@Data
public class AircraftDerivedData {

  private DataSpec dataSpec;

  private TargetAddress targetAddress;
  private TargetIdentification targetIdentification;
  private MagneticHeading magneticHeading;
  private IndicatedAirspeed indicatedAirspeed;
  private TrueAirspeed trueAirspeed;
  private SelectedAltitude selectedAltitude;
  private FinalStateSelectedAltitude finalStateSelectedAltitude;

  private TrajectoryIntentStatus trajectoryIntentStatus;
  private TrajectoryIntentData trajectoryIntentData;

  private CommAndStatusByModeSel communicationCapability;

  private StatusByAdsBroadcast statusByAdsBroadcast;
  private AcasResolutionReport acasResolutionAdvisory;

  private BarometricVerticalRate barometricVerticalRate;
  private GeometricVerticalRate geometricVerticalRate;

  private RollAngle rollAngle;
  private TrackAngleRate trackAngleRate;
  private TrackAngle trackAngle;

  private GroundSpeed groundAirspeed;

  private VelocityUncertainty velocityUncertainty;

  private MeteorologicalData meteorologicalData;
  private EmitterCategoryEnum emitterCategory;
  private Wgs84Position position;
  private GeometricAltitude geometricAltitude;

  private PositionUncertainty positionUncertainty;
  private ModeSelMbData modesMbData;
  private IndicatedAirspeed indicatedIndicatedAirspeedOfKt;
  private IndicatedAirspeed indicatedIndicatedAirspeedOfMach;
  private BarometricPressureSetting barometricPressureSetting;


}
