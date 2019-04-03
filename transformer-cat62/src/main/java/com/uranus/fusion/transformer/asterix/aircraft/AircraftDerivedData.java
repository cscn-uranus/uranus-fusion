package com.uranus.fusion.transformer.asterix.aircraft;

import com.uranus.fusion.transformer.asterix.aircraft.fcu.FinalStateSelectedAltitude;
import com.uranus.fusion.transformer.asterix.aircraft.fcu.SelectedAltitude;
import com.uranus.fusion.transformer.asterix.aircraft.identity.TargetAddress;
import com.uranus.fusion.transformer.asterix.aircraft.identity.TargetIdentification;
import com.uranus.fusion.transformer.asterix.aircraft.pfd.BarometricPressureSetting;
import com.uranus.fusion.transformer.asterix.aircraft.pfd.MeteorologicalData;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.EmitterCategoryEnum;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.acas.AcasResolutionReport;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.adsb.StatusByAdsBroadcast;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.comm.CommAndStatusByModeSel;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.modeselective.ModeSelMbData;
import com.uranus.fusion.transformer.asterix.message.spec.DataSpec;
import com.uranus.fusion.transformer.asterix.aircraft.nd.MagneticHeading;
import com.uranus.fusion.transformer.asterix.aircraft.nd.PositionUncertainty;
import com.uranus.fusion.transformer.asterix.aircraft.nd.TrajectoryIntentData;
import com.uranus.fusion.transformer.asterix.aircraft.nd.TrajectoryIntentStatus;
import com.uranus.fusion.transformer.asterix.aircraft.nd.VelocityUncertainty;
import com.uranus.fusion.transformer.asterix.measure.BarometricVerticalRate;
import com.uranus.fusion.transformer.asterix.measure.GeometricAltitude;
import com.uranus.fusion.transformer.asterix.measure.GeometricVerticalRate;
import com.uranus.fusion.transformer.asterix.measure.GroundSpeed;
import com.uranus.fusion.transformer.asterix.measure.IndicatedAirspeed;
import com.uranus.fusion.transformer.asterix.measure.RollAngle;
import com.uranus.fusion.transformer.asterix.measure.TrackAngle;
import com.uranus.fusion.transformer.asterix.measure.TrackAngleRate;
import com.uranus.fusion.transformer.asterix.measure.TrueAirspeed;
import com.uranus.fusion.transformer.asterix.measure.Wgs84Position;

/**
 * AircraftDerivedData
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
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

  public DataSpec getDataSpec() {
    return dataSpec;
  }

  public void setDataSpec(DataSpec dataSpec) {
    this.dataSpec = dataSpec;
  }

  public TargetAddress getTargetAddress() {
    return targetAddress;
  }

  public void setTargetAddress(TargetAddress targetAddress) {
    this.targetAddress = targetAddress;
  }

  public TargetIdentification getTargetIdentification() {
    return targetIdentification;
  }

  public void setTargetIdentification(
      TargetIdentification targetIdentification) {
    this.targetIdentification = targetIdentification;
  }

  public MagneticHeading getMagneticHeading() {
    return magneticHeading;
  }

  public void setMagneticHeading(MagneticHeading magneticHeading) {
    this.magneticHeading = magneticHeading;
  }

  public IndicatedAirspeed getIndicatedAirspeed() {
    return indicatedAirspeed;
  }

  public void setIndicatedAirspeed(IndicatedAirspeed indicatedAirspeed) {
    this.indicatedAirspeed = indicatedAirspeed;
  }

  public TrueAirspeed getTrueAirspeed() {
    return trueAirspeed;
  }

  public void setTrueAirspeed(TrueAirspeed trueAirspeed) {
    this.trueAirspeed = trueAirspeed;
  }

  public SelectedAltitude getSelectedAltitude() {
    return selectedAltitude;
  }

  public void setSelectedAltitude(SelectedAltitude selectedAltitude) {
    this.selectedAltitude = selectedAltitude;
  }

  public FinalStateSelectedAltitude getFinalStateSelectedAltitude() {
    return finalStateSelectedAltitude;
  }

  public void setFinalStateSelectedAltitude(
      FinalStateSelectedAltitude finalStateSelectedAltitude) {
    this.finalStateSelectedAltitude = finalStateSelectedAltitude;
  }

  public TrajectoryIntentStatus getTrajectoryIntentStatus() {
    return trajectoryIntentStatus;
  }

  public void setTrajectoryIntentStatus(
      TrajectoryIntentStatus trajectoryIntentStatus) {
    this.trajectoryIntentStatus = trajectoryIntentStatus;
  }

  public TrajectoryIntentData getTrajectoryIntentData() {
    return trajectoryIntentData;
  }

  public void setTrajectoryIntentData(
      TrajectoryIntentData trajectoryIntentData) {
    this.trajectoryIntentData = trajectoryIntentData;
  }

  public CommAndStatusByModeSel getCommunicationCapability() {
    return communicationCapability;
  }

  public void setCommunicationCapability(
      CommAndStatusByModeSel communicationCapability) {
    this.communicationCapability = communicationCapability;
  }

  public StatusByAdsBroadcast getStatusByAdsBroadcast() {
    return statusByAdsBroadcast;
  }

  public void setStatusByAdsBroadcast(StatusByAdsBroadcast statusByAdsBroadcast) {
    this.statusByAdsBroadcast = statusByAdsBroadcast;
  }

  public AcasResolutionReport getAcasResolutionAdvisory() {
    return acasResolutionAdvisory;
  }

  public void setAcasResolutionAdvisory(
      AcasResolutionReport acasResolutionAdvisory) {
    this.acasResolutionAdvisory = acasResolutionAdvisory;
  }

  public BarometricVerticalRate getBarometricVerticalRate() {
    return barometricVerticalRate;
  }

  public void setBarometricVerticalRate(
      BarometricVerticalRate barometricVerticalRate) {
    this.barometricVerticalRate = barometricVerticalRate;
  }

  public GeometricVerticalRate getGeometricVerticalRate() {
    return geometricVerticalRate;
  }

  public void setGeometricVerticalRate(
      GeometricVerticalRate geometricVerticalRate) {
    this.geometricVerticalRate = geometricVerticalRate;
  }

  public RollAngle getRollAngle() {
    return rollAngle;
  }

  public void setRollAngle(RollAngle rollAngle) {
    this.rollAngle = rollAngle;
  }

  public TrackAngle getTrackAngle() {
    return trackAngle;
  }

  public void setTrackAngle(TrackAngle trackAngle) {
    this.trackAngle = trackAngle;
  }

  public GroundSpeed getGroundAirspeed() {
    return groundAirspeed;
  }

  public void setGroundAirspeed(GroundSpeed groundAirspeed) {
    this.groundAirspeed = groundAirspeed;
  }

  public VelocityUncertainty getVelocityUncertainty() {
    return velocityUncertainty;
  }

  public void setVelocityUncertainty(
      VelocityUncertainty velocityUncertainty) {
    this.velocityUncertainty = velocityUncertainty;
  }

  public MeteorologicalData getMeteorologicalData() {
    return meteorologicalData;
  }

  public void setMeteorologicalData(
      MeteorologicalData meteorologicalData) {
    this.meteorologicalData = meteorologicalData;
  }

  public EmitterCategoryEnum getEmitterCategory() {
    return emitterCategory;
  }

  public void setEmitterCategory(
      EmitterCategoryEnum emitterCategory) {
    this.emitterCategory = emitterCategory;
  }

  public Wgs84Position getPosition() {
    return position;
  }

  public void setPosition(Wgs84Position position) {
    this.position = position;
  }

  public GeometricAltitude getGeometricAltitude() {
    return geometricAltitude;
  }

  public void setGeometricAltitude(GeometricAltitude geometricAltitude) {
    this.geometricAltitude = geometricAltitude;
  }

  public PositionUncertainty getPositionUncertainty() {
    return positionUncertainty;
  }

  public void setPositionUncertainty(
      PositionUncertainty positionUncertainty) {
    this.positionUncertainty = positionUncertainty;
  }

  public ModeSelMbData getModesMbData() {
    return modesMbData;
  }

  public void setModesMbData(
      ModeSelMbData modesMbData) {
    this.modesMbData = modesMbData;
  }

  public IndicatedAirspeed getIndicatedIndicatedAirspeedOfKt() {
    return indicatedIndicatedAirspeedOfKt;
  }

  public void setIndicatedIndicatedAirspeedOfKt(IndicatedAirspeed indicatedIndicatedAirspeedOfKt) {
    this.indicatedIndicatedAirspeedOfKt = indicatedIndicatedAirspeedOfKt;
  }

  public IndicatedAirspeed getIndicatedIndicatedAirspeedOfMach() {
    return indicatedIndicatedAirspeedOfMach;
  }

  public void setIndicatedIndicatedAirspeedOfMach(
      IndicatedAirspeed indicatedIndicatedAirspeedOfMach) {
    this.indicatedIndicatedAirspeedOfMach = indicatedIndicatedAirspeedOfMach;
  }

  public BarometricPressureSetting getBarometricPressureSetting() {
    return barometricPressureSetting;
  }

  public void setBarometricPressureSetting(
      BarometricPressureSetting barometricPressureSetting) {
    this.barometricPressureSetting = barometricPressureSetting;
  }

  public TrackAngleRate getTrackAngleRate() {
    return trackAngleRate;
  }

  public void setTrackAngleRate(TrackAngleRate trackAngleRate) {
    this.trackAngleRate = trackAngleRate;
  }
}
