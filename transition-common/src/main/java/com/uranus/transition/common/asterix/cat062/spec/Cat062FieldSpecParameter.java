package com.uranus.transition.common.asterix.cat062.spec;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.spec.FieldSpecParameter;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FxIndicationEnum;

/**
 * @author tellxp@github.com
 * @date 2019/4/28 23:39
 */
public class Cat062FieldSpecParameter implements FieldSpecParameter {

  @Override
  public Integer maxFrn() {
    return Cat062Config.MAX_FRN;
  }

  @Override
  public Integer defaultFpIndicatorSize() {
    return Cat062Config.DEFAULT_FP_INDICATOR_SIZE;
  }

  @Override
  public FpIndicationEnum defaultFpIndication() {
    return Cat062Config.DEFAULT_FP_INDICATION;
  }

  @Override
  public Integer frnStartNumber() {
    return Cat062Config.FRN_START_NUMBER;
  }

  @Override
  public Integer frnOctetSize() {
    return Cat062Config.FRN_OCTET_SIZE;
  }

  @Override
  public Integer maxFxn() {
    return Cat062Config.MAX_FXN;
  }

  @Override
  public FxIndicationEnum defaultFxIndication() {
    return Cat062Config.DEFAULT_FX_INDICATION;
  }

  @Override
  public Integer fxnStartNumber() {
    return Cat062Config.FXN_START_NUMBER;
  }

  @Override
  public Integer fxnOctetIndex() {
    return Cat062Config.FXN_OCTET_INDEX;
  }

  @Override
  public String fxPrefix() {
    return Cat062Config.FX_PREFIX;
  }
}
