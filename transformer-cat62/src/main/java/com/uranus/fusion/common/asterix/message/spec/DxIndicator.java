package com.uranus.fusion.common.asterix.message.spec;

/**
 * DxIndicator
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/24
 */
public class DxIndicator {

  private String dxn;
  private DxIndicationEnum indication;

  public String getDxn() {
    return dxn;
  }

  public void setDxn(String fxn) {
    this.dxn = fxn;
  }

  public DxIndicationEnum getIndication() {
    return indication;
  }

  public void setIndication(DxIndicationEnum indication) {
    this.indication = indication;
  }
}
