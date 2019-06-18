package com.uranus.transition.common.asterix.uap.emitter.modesel;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ModeSelMbData
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/24
 */
@Data
public class ModeSelMbData {

  private Integer repeatIndicator;
  private List<ModeSelMb> modeSelMbs = new ArrayList<>();

  public void add(ModeSelMb modeSelMb) {
    modeSelMbs.add(modeSelMb);
  }
}
