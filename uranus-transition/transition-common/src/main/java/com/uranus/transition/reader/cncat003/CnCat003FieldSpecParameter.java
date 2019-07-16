package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.spec.FieldSpecParameter;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FxIndicationEnum;

/**
 * @author tellxp@github.com
 * @date 2019/4/28 23:39
 */
class CnCat003FieldSpecParameter implements FieldSpecParameter {

  @Override
  public Integer maxFrn() {
    return CnCat003Config.MAX_FRN;
  }

  @Override
  public Integer defaultFpIndicatorSize() {
    return CnCat003Config.DEFAULT_FP_INDICATOR_SIZE;
  }

  @Override
  public FpIndicationEnum defaultFpIndication() {
    return CnCat003Config.DEFAULT_FP_INDICATION;
  }

  @Override
  public Integer frnStartNumber() {
    return CnCat003Config.FRN_START_NUMBER;
  }

  @Override
  public Integer frnStepSize() {
    return CnCat003Config.FRN_OCTET_SIZE;
  }

  @Override
  public Integer maxFxn() {
    return CnCat003Config.MAX_FXN;
  }

  @Override
  public FxIndicationEnum defaultFxIndication() {
    return CnCat003Config.DEFAULT_FX_INDICATION;
  }

  @Override
  public Integer fxnStartNumber() {
    return CnCat003Config.FXN_START_NUMBER;
  }

  @Override
  public Integer fxnOctetIndex() {
    return CnCat003Config.FXN_OCTET_INDEX;
  }

  @Override
  public String fxPrefix() {
    return CnCat003Config.FX_PREFIX;
  }
}
