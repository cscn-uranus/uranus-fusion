package com.uranus.fusion.common.asterix.aircraft.transponder.mode3;

/**
 * Mode3Code
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/12
 */
public class Mode3Code {

  private CodeValidatedStatusEnum codeValidatedStatusEnum;
  private CodeGarbledStatusEnum codeGarbledStatusEnum;
  private CodeChangeStatusEnum codeChangeStatusEnum;

  private String code;

  public CodeValidatedStatusEnum getCodeValidatedStatusEnum() {
    return codeValidatedStatusEnum;
  }

  public void setCodeValidatedStatusEnum(
      CodeValidatedStatusEnum codeValidatedStatusEnum) {
    this.codeValidatedStatusEnum = codeValidatedStatusEnum;
  }

  public CodeGarbledStatusEnum getCodeGarbledStatusEnum() {
    return codeGarbledStatusEnum;
  }

  public void setCodeGarbledStatusEnum(
      CodeGarbledStatusEnum codeGarbledStatusEnum) {
    this.codeGarbledStatusEnum = codeGarbledStatusEnum;
  }

  public CodeChangeStatusEnum getCodeChangeStatusEnum() {
    return codeChangeStatusEnum;
  }

  public void setCodeChangeStatusEnum(CodeChangeStatusEnum codeChangeStatusEnum) {
    this.codeChangeStatusEnum = codeChangeStatusEnum;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
