package com.uranus.toolkit.udp.unicast.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tellxp@github.com
 * @date 2019/5/27 21:36
 */
@ConfigurationProperties(prefix = "uranus.udp.unicast.splitter")
@Data
public class UnicastSplitterProperty {
  @NestedConfigurationProperty private UnicastInboundProperty inbound;

  private Map<String, UnicastOutboundProperty> outbounds = new HashMap<>();
}
