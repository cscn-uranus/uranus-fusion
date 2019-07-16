package com.uranus.toolkit.udp.multicast.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tellxp@github.com
 * @date 2019/5/27 21:36
 */
@ConfigurationProperties(prefix = "uranus.udp.multicast.splitter")
@Data
public class MulticastSplitterProperty {
  @NestedConfigurationProperty
  private MulticastInboundProperty inbound;

  private Map<String,UnicastOutboundProperty> outbounds = new HashMap<>();

}
