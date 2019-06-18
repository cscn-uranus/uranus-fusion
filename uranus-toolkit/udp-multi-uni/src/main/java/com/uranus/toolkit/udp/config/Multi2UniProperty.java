package com.uranus.toolkit.udp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.List;

/**
 * @author tellxp@github.com
 * @date 2019/5/27 21:36
 */
@ConfigurationProperties(prefix = "uranus")
@Data
public class Multi2UniProperty {
  @NestedConfigurationProperty
  private ReceiverProperty receiver;

  @NestedConfigurationProperty
  private List<SenderProperty> senders;

}
