package com.uranus.fusion.asterix.sensor.info;

import com.uranus.fusion.asterix.aircraft.transponder.mode3.CodeGarbledStatusEnum;
import com.uranus.fusion.asterix.aircraft.transponder.mode3.CodeSourceTypeEnum;
import com.uranus.fusion.asterix.aircraft.transponder.mode3.CodeValidatedStatusEnum;

/**
 * LastModeCCode
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class LastMode3Code {

  private CodeValidatedStatusEnum codeValidatedStatusEnum;
  private CodeGarbledStatusEnum codeGarbledStatusEnum;
  private CodeSourceTypeEnum codeSourceTypeEnum;
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

  public CodeSourceTypeEnum getCodeSourceTypeEnum() {
    return codeSourceTypeEnum;
  }

  public void setCodeSourceTypeEnum(CodeSourceTypeEnum codeSourceTypeEnum) {
    this.codeSourceTypeEnum = codeSourceTypeEnum;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
