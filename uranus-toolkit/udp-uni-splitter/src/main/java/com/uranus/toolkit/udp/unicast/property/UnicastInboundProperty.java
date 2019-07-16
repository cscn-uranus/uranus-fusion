package com.uranus.toolkit.udp.unicast.property;

import lombok.Data;

/**
 * @author tellxp@github.com
 * @date 2019/7/15
 */
@Data
public class UnicastInboundProperty {
  private String localAddress;
  private Integer port;
  private Integer poolSize;
  private Integer bufferSize;
}
