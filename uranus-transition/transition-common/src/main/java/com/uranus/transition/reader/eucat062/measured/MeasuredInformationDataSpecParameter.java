package com.uranus.transition.reader.eucat062.measured;

import com.uranus.transition.common.asterix.spec.DataSpecParameter;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DxIndicationEnum;

/**
 * @author tellxp@github.com
 * @date 2019/6/12
 */

public class MeasuredInformationDataSpecParameter implements DataSpecParameter {
  @Override
  public Integer maxDrn() {
    return MeasuredInformationConfig.MAX_DRN;
  }

  @Override
  public Integer defaultDpIndicatorSize() {
    return MeasuredInformationConfig.DEFAULT_DP_INDICATOR_SIZE;
  }

  @Override
  public DpIndicationEnum defaultDpIndication() {
    return MeasuredInformationConfig.DEFAULT_DP_INDICATION;
  }

  @Override
  public Integer drnStartNumber() {
    return MeasuredInformationConfig.DRN_START_NUM;
  }

  @Override
  public Integer drnStepSize() {
    return MeasuredInformationConfig.DRN_STEP_SIZE;
  }

  @Override
  public Integer maxDxn() {
    return MeasuredInformationConfig.MAX_DXN;
  }

  @Override
  public DxIndicationEnum defaultDxIndication() {
    return MeasuredInformationConfig.DEFAULT_DX_INDICATION;
  }

  @Override
  public Integer dxnStartNumber() {
    return MeasuredInformationConfig.DXN_START_NUM;
  }

  @Override
  public Integer dxnOctetIndex() {
    return MeasuredInformationConfig.DXN_OCTET_INDEX;
  }

  @Override
  public String dxPrefix() {
    return MeasuredInformationConfig.DX_PREFIX;
  }
}
