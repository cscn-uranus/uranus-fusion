package com.uranus.transition.common.asterix.uap.emitter.modec;

import com.uranus.transition.common.asterix.uap.emitter.mode3.CodeGarbledStatusEnum;
import com.uranus.transition.common.asterix.uap.emitter.mode3.CodeValidatedStatusEnum;
import lombok.Data;

/**
 * LastModeCCode
 *
 * <p>Data Item I062/340, Measured Information
 *
 * <p>Structure of Subfield # 4: Last Measured Mode C Code
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
@Data
public class LastModecCode {

  /** bit-16 (V) = 0 Code validated = 1 Code not validated */
  private CodeValidatedStatusEnum codeValidatedStatusEnum;

  /** bit-15 (G) = 0 Default = 1 Garbled code */
  private CodeGarbledStatusEnum codeGarbledStatusEnum;

  /**
   * bit 14/1 Last Measured Mode C Code, in two’s complement form (LSB) = 1/4 FL Vmin = -12 FL Vmax
   * = 1270 FL
   */
  private Double fl;
}
