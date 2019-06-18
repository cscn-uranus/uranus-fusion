package com.uranus.transition.common.asterix.cat062.mode5;

import com.uranus.transition.common.asterix.spec.DataSpecParameter;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DxIndicationEnum;

/**
 * @author tellxp@github.com
 * @date 2019/6/12
 */

public class Mode5AndMode1DataSpecParameter implements DataSpecParameter {
  @Override
  public Integer maxDrn() {
    return Mode5AndMode1Config.MAX_DRN;
  }

  @Override
  public Integer defaultDpIndicatorSize() {
    return Mode5AndMode1Config.DEFAULT_DP_INDICATOR_SIZE;
  }

  @Override
  public DpIndicationEnum defaultDpIndication() {
    return Mode5AndMode1Config.DEFAULT_DP_INDICATION;
  }

  @Override
  public Integer drnStartNumber() {
    return Mode5AndMode1Config.DRN_START_NUM;
  }

  @Override
  public Integer drnStepSize() {
    return Mode5AndMode1Config.DRN_STEP_SIZE;
  }

  @Override
  public Integer maxDxn() {
    return Mode5AndMode1Config.MAX_DXN;
  }

  @Override
  public DxIndicationEnum defaultDxIndication() {
    return Mode5AndMode1Config.DEFAULT_DX_INDICATION;
  }

  @Override
  public Integer dxnStartNumber() {
    return Mode5AndMode1Config.DXN_START_NUM;
  }

  @Override
  public Integer dxnOctetIndex() {
    return Mode5AndMode1Config.DXN_OCTET_INDEX;
  }

  @Override
  public String dxPrefix() {
    return Mode5AndMode1Config.DX_PREFIX;
  }
}
