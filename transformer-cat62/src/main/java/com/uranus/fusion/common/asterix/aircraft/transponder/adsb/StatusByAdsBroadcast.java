package com.uranus.fusion.common.asterix.aircraft.transponder.adsb;

import com.uranus.fusion.common.asterix.aircraft.transponder.BitSetEnum;
import com.uranus.fusion.common.asterix.aircraft.transponder.CorrectionEnum;
import com.uranus.fusion.common.asterix.aircraft.transponder.OperationalEnum;

/**
 * StatusByAdsBroadcast
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/23
 */
public class StatusByAdsBroadcast {

  private OperationalEnum acasOperationStatus;
  private OperationalEnum multiNavaidsOperationStatus;
  private CorrectionEnum differentialCorrectionEnum;
  private BitSetEnum groundBitStatus;
  private AdsBroadcastFlightStatusEnum flightStatusEnum;

  public OperationalEnum getAcasOperationStatus() {
    return acasOperationStatus;
  }

  public void setAcasOperationStatus(
      OperationalEnum acasOperationStatus) {
    this.acasOperationStatus = acasOperationStatus;
  }

  public OperationalEnum getMultiNavaidsOperationStatus() {
    return multiNavaidsOperationStatus;
  }

  public void setMultiNavaidsOperationStatus(
      OperationalEnum multiNavaidsOperationStatus) {
    this.multiNavaidsOperationStatus = multiNavaidsOperationStatus;
  }

  public CorrectionEnum getDifferentialCorrectionEnum() {
    return differentialCorrectionEnum;
  }

  public void setDifferentialCorrectionEnum(
      CorrectionEnum differentialCorrectionEnum) {
    this.differentialCorrectionEnum = differentialCorrectionEnum;
  }

  public BitSetEnum getGroundBitStatus() {
    return groundBitStatus;
  }

  public void setGroundBitStatus(BitSetEnum groundBitStatus) {
    this.groundBitStatus = groundBitStatus;
  }

  public AdsBroadcastFlightStatusEnum getFlightStatusEnum() {
    return flightStatusEnum;
  }

  public void setFlightStatusEnum(
      AdsBroadcastFlightStatusEnum flightStatusEnum) {
    this.flightStatusEnum = flightStatusEnum;
  }
}
