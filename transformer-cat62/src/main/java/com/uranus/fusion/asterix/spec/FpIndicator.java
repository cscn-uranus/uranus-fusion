package com.uranus.fusion.asterix.spec;

import lombok.Data;

/**
 * FpIndicator
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/15
 */
@Data
public class FpIndicator {

  private Integer frn;
  private FpIndicationEnum indication;
  private Integer size;
}
