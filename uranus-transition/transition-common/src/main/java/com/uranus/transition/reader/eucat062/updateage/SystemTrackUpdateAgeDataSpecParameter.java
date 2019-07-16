package com.uranus.transition.reader.eucat062.updateage;

import com.uranus.transition.common.asterix.spec.DataSpecParameter;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DxIndicationEnum;

/**
 * @author tellxp@github.com
 * @date 2019/6/12
 */

public class SystemTrackUpdateAgeDataSpecParameter implements DataSpecParameter {
  @Override
  public Integer maxDrn() {
    return SystemTrackUpdateAgeConfig.MAX_DRN;
  }

  @Override
  public Integer defaultDpIndicatorSize() {
    return SystemTrackUpdateAgeConfig.DEFAULT_DP_INDICATOR_SIZE;
  }

  @Override
  public DpIndicationEnum defaultDpIndication() {
    return SystemTrackUpdateAgeConfig.DEFAULT_DP_INDICATION;
  }

  @Override
  public Integer drnStartNumber() {
    return SystemTrackUpdateAgeConfig.DRN_START_NUM;
  }

  @Override
  public Integer drnStepSize() {
    return SystemTrackUpdateAgeConfig.DRN_STEP_SIZE;
  }

  @Override
  public Integer maxDxn() {
    return SystemTrackUpdateAgeConfig.MAX_DXN;
  }

  @Override
  public DxIndicationEnum defaultDxIndication() {
    return SystemTrackUpdateAgeConfig.DEFAULT_DX_INDICATION;
  }

  @Override
  public Integer dxnStartNumber() {
    return SystemTrackUpdateAgeConfig.DXN_START_NUM;
  }

  @Override
  public Integer dxnOctetIndex() {
    return SystemTrackUpdateAgeConfig.DXN_OCTET_INDEX;
  }

  @Override
  public String dxPrefix() {
    return SystemTrackUpdateAgeConfig.DX_PREFIX;
  }
}
