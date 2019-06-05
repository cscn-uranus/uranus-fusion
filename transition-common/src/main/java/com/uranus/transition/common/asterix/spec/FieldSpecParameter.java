package com.uranus.transition.common.asterix.spec;

/**
 * @author tellxp@github.com
 * @date 2019/4/28 17:11
 */
public interface FieldSpecParameter {

  Integer maxFrn();

  Integer defaultFpIndicatorSize();

  FpIndicationEnum defaultFpIndication();

  Integer frnStartNumber();

  Integer frnOctetSize();

  Integer maxFxn();

  FxIndicationEnum defaultFxIndication();

  Integer fxnStartNumber();

  Integer fxnOctetIndex();

  String fxPrefix();
}
