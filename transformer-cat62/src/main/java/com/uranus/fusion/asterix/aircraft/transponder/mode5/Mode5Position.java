package com.uranus.fusion.asterix.aircraft.transponder.mode5;

import com.uranus.fusion.asterix.measure.Wgs84Position;

/**
 * Mode5Position
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
 */
public class Mode5Position {

  private Wgs84Position position;

  public Wgs84Position getPosition() {
    return position;
  }

  public void setPosition(Wgs84Position position) {
    this.position = position;
  }
}
