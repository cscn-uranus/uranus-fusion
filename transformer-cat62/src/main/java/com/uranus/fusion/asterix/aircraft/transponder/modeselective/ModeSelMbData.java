package com.uranus.fusion.asterix.aircraft.transponder.modeselective;

import java.util.HashSet;
import java.util.Set;

/**
 * ModeSelMbData
 *
 * @author 肖鹏 tellxp@github.com
 * date 2018/10/24
 */
public class ModeSelMbData {

  private Integer repeatIndicator;
  private Set<ModeSelMb> modeSelMbs;

  public ModeSelMbData() {
    this.modeSelMbs = new HashSet<>();
  }

  public Integer getRepeatIndicator() {
    return repeatIndicator;
  }

  public void setRepeatIndicator(Integer repeatIndicator) {
    this.repeatIndicator = repeatIndicator;
  }

  public Set<ModeSelMb> getModeSelMbs() {
    return modeSelMbs;
  }

  public void setModeSelMbs(Set<ModeSelMb> modeSelMbs) {
    this.modeSelMbs = modeSelMbs;
  }

  public void add(ModeSelMb modesMb) {
    this.modeSelMbs.add(modesMb);
  }
}
