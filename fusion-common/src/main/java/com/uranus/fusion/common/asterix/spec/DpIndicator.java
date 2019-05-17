package com.uranus.fusion.common.asterix.spec;

import lombok.Data;

/**
 * DpIndicator
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
@Data
public class DpIndicator {

  private Integer drn;
  private DpIndicationEnum indication;
  private Integer size;
}
