package com.uranus.toolkit.udp.config;

import lombok.Data;


/**
 * @author tellxp@github.com
 * @date 2019/5/27 21:24
 */
@Data
public class SenderProperty {
  private String ip;
  private Integer port;
  private Boolean enabled;
}
