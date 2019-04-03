package com.uranus.fusion.transformer.asterix.sensor.info;

import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode3.CodeGarbledStatusEnum;
import com.uranus.fusion.transformer.asterix.aircraft.transponder.mode3.CodeValidatedStatusEnum;

/**
 * LastModeCCode
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class LastModeCharlieCode {

  private CodeValidatedStatusEnum codeValidatedStatusEnum;
  private CodeGarbledStatusEnum codeGarbledStatusEnum;
  private Double height;

  public CodeValidatedStatusEnum getCodeValidatedStatusEnum() {
    return codeValidatedStatusEnum;
  }

  public void setCodeValidatedStatusEnum(CodeValidatedStatusEnum codeValidatedStatusEnum) {
    this.codeValidatedStatusEnum = codeValidatedStatusEnum;
  }

  public CodeGarbledStatusEnum getCodeGarbledStatusEnum() {
    return codeGarbledStatusEnum;
  }

  public void setCodeGarbledStatusEnum(CodeGarbledStatusEnum codeGarbledStatusEnum) {
    this.codeGarbledStatusEnum = codeGarbledStatusEnum;
  }

  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }
}
