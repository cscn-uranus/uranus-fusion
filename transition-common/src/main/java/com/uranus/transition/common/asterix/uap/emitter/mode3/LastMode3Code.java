package com.uranus.transition.common.asterix.uap.emitter.mode3;

import lombok.Data;

/**
 * LastModeCCode
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
@Data
public class LastMode3Code {

  private CodeValidatedStatusEnum codeValidatedStatusEnum;
  private CodeGarbledStatusEnum codeGarbledStatusEnum;
  private CodeSourceTypeEnum codeSourceTypeEnum;
  private String code;
}
