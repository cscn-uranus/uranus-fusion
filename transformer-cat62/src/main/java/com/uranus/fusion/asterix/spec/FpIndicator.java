package com.uranus.fusion.asterix.spec;

/**
 * FpIndicator
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
public class FpIndicator {

  private Integer frn;
  private FpIndicationEnum indication;
  private Integer size;

  public Integer getFrn() {
    return frn;
  }

  public void setFrn(Integer frn) {
    this.frn = frn;
  }

  public FpIndicationEnum getIndication() {
    return indication;
  }

  public void setIndication(FpIndicationEnum indication) {
    this.indication = indication;
  }


  public Integer getSize() {
    return size;
  }

  public void setSize(Integer length) {
    this.size = length;
  }

}
