package com.uranus.toolkit.udp.multicast.property;

import lombok.Data;

/**
 * @author tellxp@github.com
 * @date 2019/7/15
 */
@Data
public class UnicastOutboundProperty {
  private String host;
  private String localAddress;
  private Integer port;
  private Boolean enabled;
}
