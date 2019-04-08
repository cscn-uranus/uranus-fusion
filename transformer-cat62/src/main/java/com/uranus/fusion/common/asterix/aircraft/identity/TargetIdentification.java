package com.uranus.fusion.common.asterix.aircraft.identity;

/**
 * TargetIdentification
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/30
 */
public class TargetIdentification {

  private TargetIdentificationEnum targetIdentificationEnum;
  private String identification;

  public TargetIdentificationEnum getTargetIdentificationEnum() {
    return targetIdentificationEnum;
  }

  public void setTargetIdentificationEnum(TargetIdentificationEnum targetIdentificationEnum) {
    this.targetIdentificationEnum = targetIdentificationEnum;
  }

  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }
}
