package com.uranus.toolkit.udp.config;

import lombok.Data;

/**
 * @author tellxp@github.com
 * @date 2019/5/27 22:04
 */
@Data
public class ReceiverProperty {
  private String ip;
  private String group;
  private Integer port;
  private Integer poolSize;
}
