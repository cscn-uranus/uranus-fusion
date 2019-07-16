package com.uranus.transition.reader.eucat062.aircraftdata;

import com.uranus.transition.common.asterix.spec.*;

/**
 * @author tellxp@github.com
 * @date 2019/4/28 23:39
 */
public class AircraftDerivedDataSpecParameter implements DataSpecParameter {


  @Override
  public Integer maxDrn() {
    return AircraftDerivedDataConfig.MAX_DRN;
  }

  @Override
  public Integer defaultDpIndicatorSize() {
    return AircraftDerivedDataConfig.DEFAULT_DP_INDICATOR_SIZE;
  }

  @Override
  public DpIndicationEnum defaultDpIndication() {
    return AircraftDerivedDataConfig.DEFAULT_DP_INDICATION;
  }

  @Override
  public Integer drnStartNumber() {
    return AircraftDerivedDataConfig.DRN_START_NUMBER;
  }

  @Override
  public Integer drnStepSize() {
    return AircraftDerivedDataConfig.DRN_STEP_SIZE;
  }

  @Override
  public Integer maxDxn() {
    return AircraftDerivedDataConfig.MAX_DXN;
  }

  @Override
  public DxIndicationEnum defaultDxIndication() {
    return AircraftDerivedDataConfig.DEFAULT_DX_INDICATION;
  }

  @Override
  public Integer dxnStartNumber() {
    return AircraftDerivedDataConfig.DXN_START_NUMBER;
  }

  @Override
  public Integer dxnOctetIndex() {
    return AircraftDerivedDataConfig.DXN_OCTET_INDEX;
  }

  @Override
  public String dxPrefix() {
    return AircraftDerivedDataConfig.DX_PREFIX;
  }
}
