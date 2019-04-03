package com.uranus.fusion.transformer.asterix.message.spec;


/**
 * FxIndicator
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/24
 */
public class FxIndicator {

  private String fxn;
  private FxIndicationEnum indication;

  public String getFxn() {
    return fxn;
  }

  public void setFxn(String fxn) {
    this.fxn = fxn;
  }

  public FxIndicationEnum getIndication() {
    return indication;
  }

  public void setIndication(FxIndicationEnum indication) {
    this.indication = indication;
  }
}
