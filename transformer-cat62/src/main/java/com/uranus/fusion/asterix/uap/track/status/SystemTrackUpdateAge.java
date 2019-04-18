package com.uranus.fusion.asterix.uap.track.status;

import com.uranus.fusion.asterix.uap.track.UpdateAge;
import lombok.Data;

/**
 * SystemTrackUpdateAge
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
@Data
public class SystemTrackUpdateAge {

  private UpdateAge updateAge;
  private UpdateAge psrAge;
  private UpdateAge ssrAge;
  private UpdateAge modeSelAge;
  private UpdateAge adsContractAge;
  private UpdateAge esAge;
  private UpdateAge vdlAge;
  private UpdateAge uatAge;
  private UpdateAge loopAge;
  private UpdateAge multilaterationAge;
}
