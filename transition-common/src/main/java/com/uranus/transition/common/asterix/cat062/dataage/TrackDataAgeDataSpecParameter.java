package com.uranus.transition.common.asterix.cat062.dataage;

import com.uranus.transition.common.asterix.spec.DataSpecParameter;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DxIndicationEnum;

/**
 * @author tellxp@github.com
 * @date 2019/6/12
 */

public class TrackDataAgeDataSpecParameter implements DataSpecParameter {
  @Override
  public Integer maxDrn() {
    return TrackDataAgeConfig.MAX_DRN;
  }

  @Override
  public Integer defaultDpIndicatorSize() {
    return TrackDataAgeConfig.DEFAULT_DP_INDICATOR_SIZE;
  }

  @Override
  public DpIndicationEnum defaultDpIndication() {
    return TrackDataAgeConfig.DEFAULT_DP_INDICATION;
  }

  @Override
  public Integer drnStartNumber() {
    return TrackDataAgeConfig.DRN_START_NUM;
  }

  @Override
  public Integer drnStepSize() {
    return TrackDataAgeConfig.DRN_STEP_SIZE;
  }

  @Override
  public Integer maxDxn() {
    return TrackDataAgeConfig.MAX_DXN;
  }

  @Override
  public DxIndicationEnum defaultDxIndication() {
    return TrackDataAgeConfig.DEFAULT_DX_INDICATION;
  }

  @Override
  public Integer dxnStartNumber() {
    return TrackDataAgeConfig.DXN_START_NUM;
  }

  @Override
  public Integer dxnOctetIndex() {
    return TrackDataAgeConfig.DXN_OCTET_INDEX;
  }

  @Override
  public String dxPrefix() {
    return TrackDataAgeConfig.DX_PREFIX;
  }
}
