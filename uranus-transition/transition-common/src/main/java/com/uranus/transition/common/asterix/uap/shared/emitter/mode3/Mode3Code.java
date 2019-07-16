package com.uranus.transition.common.asterix.uap.shared.emitter.mode3;

import lombok.Data;

/**
 * Mode3Code
 *
 * <p>Data Item I062/060, Track Mode 3/A Code
 *
 * <p>Definition : Mode-3/A code converted into octal representation.
 *
 * <p>Format : Two-octet fixed length Data Item.
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/12
 */
@Data
public class Mode3Code {

  /**
   * bit 16
   *
   * <p>(V) = 0 Code validated = 1 Code not validated
   */
  private CodeValidatedStatusEnum codeValidatedStatusEnum;

  /**
   * bit 15
   *
   * <p>(G) = 0 Default = 1 Garbled Code
   */
  private CodeGarbledStatusEnum codeGarbledStatusEnum;

  private CodeSourceTypeEnum codeSourceTypeEnum;

  /**
   * bit 14
   *
   * <p>(CH) Change in Mode 3/A = 0 No Change = 1 Mode 3/A has changed
   */
  private CodeChangeStatusEnum codeChangeStatusEnum;

  /**
   * bits-12/1
   *
   * <p>Mode-3/A reply in octal representation
   */
  private String code;
}
