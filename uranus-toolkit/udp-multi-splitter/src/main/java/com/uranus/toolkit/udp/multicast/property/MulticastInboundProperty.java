package com.uranus.toolkit.udp.multicast.property;

import lombok.Data;

/**
 * @author tellxp@github.com
 * @date 2019/5/27 22:04
 */
@Data
public class MulticastInboundProperty {
  private String localAddress;
  private String group;
  private Integer port;
  private Integer poolSize;
}
