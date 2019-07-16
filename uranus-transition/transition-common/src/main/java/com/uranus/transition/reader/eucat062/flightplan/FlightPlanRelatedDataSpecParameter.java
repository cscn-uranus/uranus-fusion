package com.uranus.transition.reader.eucat062.flightplan;

import com.uranus.transition.common.asterix.spec.DataSpecParameter;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DxIndicationEnum;

/**
 * @author tellxp@github.com
 * @date 2019/6/12
 */

public class FlightPlanRelatedDataSpecParameter implements DataSpecParameter {
  @Override
  public Integer maxDrn() {
    return FlightPlanRelatedDataConfig.MAX_DRN;
  }

  @Override
  public Integer defaultDpIndicatorSize() {
    return FlightPlanRelatedDataConfig.DEFAULT_DP_INDICATOR_SIZE;
  }

  @Override
  public DpIndicationEnum defaultDpIndication() {
    return FlightPlanRelatedDataConfig.DEFAULT_DP_INDICATION;
  }

  @Override
  public Integer drnStartNumber() {
    return FlightPlanRelatedDataConfig.DRN_START_NUM;
  }

  @Override
  public Integer drnStepSize() {
    return FlightPlanRelatedDataConfig.DRN_STEP_SIZE;
  }

  @Override
  public Integer maxDxn() {
    return FlightPlanRelatedDataConfig.MAX_DXN;
  }

  @Override
  public DxIndicationEnum defaultDxIndication() {
    return FlightPlanRelatedDataConfig.DEFAULT_DX_INDICATION;
  }

  @Override
  public Integer dxnStartNumber() {
    return FlightPlanRelatedDataConfig.DXN_START_NUM;
  }

  @Override
  public Integer dxnOctetIndex() {
    return FlightPlanRelatedDataConfig.DXN_OCTET_INDEX;
  }

  @Override
  public String dxPrefix() {
    return FlightPlanRelatedDataConfig.DX_PREFIX;
  }
}
