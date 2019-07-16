package com.uranus.transition.common.asterix.uap.shared.emitter.mode3;

import lombok.Data;

/**
 * LastModeCCode
 *
 *
 * Data Item I062/340, Measured Information
 *
 * <p>Structure of Subfield # 4: Last Measured Mode C Code
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
@Data
public class LastMode3Code {

  /** bit 16 (V) = 0 Code Validated = 1 Code not Validated */
  private CodeValidatedStatusEnum codeValidatedStatusEnum;

  /** bit 15 (G) = 0 Default = 1 Garbled code */
  private CodeGarbledStatusEnum codeGarbledStatusEnum;

  /**
   * bit 14 (L) = 0 MODE 3/A code as derived from the reply of the transponder, = 1 Smoothed MODE
   * 3/A code as provided by a sensor local tracker.
   */
  private CodeSourceTypeEnum codeSourceTypeEnum;

  /** bits 12/1 Mode 3/A reply under the form of 4 digits in octal representation */
  private String code;
}
