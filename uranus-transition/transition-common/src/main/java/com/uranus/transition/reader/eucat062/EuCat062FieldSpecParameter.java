package com.uranus.transition.reader.eucat062;

import com.uranus.transition.common.asterix.spec.FieldSpecParameter;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FxIndicationEnum;

/**
 * @author tellxp@github.com
 * @date 2019/4/28 23:39
 */
class EuCat062FieldSpecParameter implements FieldSpecParameter {

  @Override
  public Integer maxFrn() {
    return EuCat062Config.MAX_FRN;
  }

  @Override
  public Integer defaultFpIndicatorSize() {
    return EuCat062Config.DEFAULT_FP_INDICATOR_SIZE;
  }

  @Override
  public FpIndicationEnum defaultFpIndication() {
    return EuCat062Config.DEFAULT_FP_INDICATION;
  }

  @Override
  public Integer frnStartNumber() {
    return EuCat062Config.FRN_START_NUMBER;
  }

  @Override
  public Integer frnStepSize() {
    return EuCat062Config.FRN_OCTET_SIZE;
  }

  @Override
  public Integer maxFxn() {
    return EuCat062Config.MAX_FXN;
  }

  @Override
  public FxIndicationEnum defaultFxIndication() {
    return EuCat062Config.DEFAULT_FX_INDICATION;
  }

  @Override
  public Integer fxnStartNumber() {
    return EuCat062Config.FXN_START_NUMBER;
  }

  @Override
  public Integer fxnOctetIndex() {
    return EuCat062Config.FXN_OCTET_INDEX;
  }

  @Override
  public String fxPrefix() {
    return EuCat062Config.FX_PREFIX;
  }
}
