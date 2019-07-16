package com.uranus.transition.common.asterix.uap.shared.emitter.mode2;

import com.uranus.transition.common.asterix.uap.shared.datainfo.DataValidEnum;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode3.CodeGarbledStatusEnum;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode3.CodeSourceTypeEnum;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode3.CodeValidatedStatusEnum;
import lombok.Data;

/**
 * Mode2Code
 *
 * <p>Data Item I062/120, Track Mode 2 Code
 *
 * Definition : Mode 2 code associated to the track
 *
 * Format
 * : Two-Octet fixed length data item.
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/14
 */
@Data
public class Mode2Code {

  private CodeValidatedStatusEnum codeValidatedStatusEnum;
  private CodeGarbledStatusEnum codeGarbledStatusEnum;
  private CodeSourceTypeEnum codeSourceTypeEnum;
  /**
   * bits-12/1 Mode-2 code in octal representation
   */
  private String code;
}
