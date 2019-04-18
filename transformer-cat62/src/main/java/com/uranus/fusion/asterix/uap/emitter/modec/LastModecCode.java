package com.uranus.fusion.asterix.uap.emitter.modec;

import com.uranus.fusion.asterix.uap.emitter.mode3.CodeGarbledStatusEnum;
import com.uranus.fusion.asterix.uap.emitter.mode3.CodeValidatedStatusEnum;
import lombok.Data;

/**
 * LastModeCCode
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
@Data
public class LastModecCode {

  private CodeValidatedStatusEnum codeValidatedStatusEnum;
  private CodeGarbledStatusEnum codeGarbledStatusEnum;
  private Double height;
}
