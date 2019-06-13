package com.uranus.transition.common.asterix.spec;

import lombok.Data;

/**
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
@Data
public class FpIndicator {
  /**
   * FRN 编号
   *
   * 根据 Asterix 规范性文档确定
   */
  private Integer frn;

  /**
   * 数据标识
   *
   * Presence 或者 No Presence
   */
  private FpIndicationEnum indication;

  /**
   * 数据长度
   */
  private Integer size;
}
