package com.uranus.transition.common.asterix.cat062.accuracy;

import com.uranus.transition.common.asterix.spec.DataSpecParameter;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DxIndicationEnum;

/**
 * @author tellxp@github.com
 * @date 2019/4/28 23:39
 */
public class EstimatedAccuracyDataSpecParameter implements DataSpecParameter {


  @Override
  public Integer maxDrn() {
    return EstimatedAccuracyConfig.MAX_DRN;
  }

  @Override
  public Integer defaultDpIndicatorSize() {
    return EstimatedAccuracyConfig.DEFAULT_DP_INDICATOR_SIZE;
  }

  @Override
  public DpIndicationEnum defaultDpIndication() {
    return EstimatedAccuracyConfig.DEFAULT_DP_INDICATION;
  }

  @Override
  public Integer drnStartNumber() {
    return EstimatedAccuracyConfig.DRN_START_NUM;
  }

  @Override
  public Integer drnStepSize() {
    return EstimatedAccuracyConfig.DRN_STEP_SIZE;
  }

  @Override
  public Integer maxDxn() {
    return EstimatedAccuracyConfig.MAX_DXN;
  }

  @Override
  public DxIndicationEnum defaultDxIndication() {
    return EstimatedAccuracyConfig.DEFAULT_DX_INDICATION;
  }

  @Override
  public Integer dxnStartNumber() {
    return EstimatedAccuracyConfig.DXN_START_NUM;
  }

  @Override
  public Integer dxnOctetIndex() {
    return EstimatedAccuracyConfig.DXN_OCTET_INDEX;
  }

  @Override
  public String dxPrefix() {
    return EstimatedAccuracyConfig.DX_PREFIX;
  }
}
