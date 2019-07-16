package com.uranus.transition.common.asterix.uap.shared.emitter.mode3;

import com.uranus.transition.common.asterix.uap.shared.datainfo.DataValidEnum;
import lombok.Data;

/**
 * PreEmergencyMode3
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
@Data
public class PreEmergencyMode3 {

  /** bit-13
   *
   * (VA) Validity = 0 No valid Mode 3/A available = 1 Valid Mode 3/A available */
  private DataValidEnum dataValidEnum;

  /** bits-12/1
   *
   * Mode-3/A reply in octal representation */
  private String code;
}
