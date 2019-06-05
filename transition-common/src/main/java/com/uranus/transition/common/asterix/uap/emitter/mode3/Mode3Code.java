package com.uranus.transition.common.asterix.uap.emitter.mode3;

import lombok.Data;

/**
 * Mode3Code
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/12
 */
@Data
public class Mode3Code {

  private CodeValidatedStatusEnum codeValidatedStatusEnum;
  private CodeGarbledStatusEnum codeGarbledStatusEnum;
  private CodeChangeStatusEnum codeChangeStatusEnum;

  private String code;
}
