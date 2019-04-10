package com.uranus.fusion.asterix.spec;

/**
 * DpIndicator
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/8
 */
public class DpIndicator {

  private Integer drn;
  private DpIndicationEnum indication;
  private Integer size;

  public Integer getDrn() {
    return drn;
  }

  public void setDrn(Integer drn) {
    this.drn = drn;
  }

  public DpIndicationEnum getIndication() {
    return indication;
  }

  public void setIndication(DpIndicationEnum indication) {
    this.indication = indication;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }
}
