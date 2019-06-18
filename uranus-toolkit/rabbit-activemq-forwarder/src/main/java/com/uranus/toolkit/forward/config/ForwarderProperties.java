package com.uranus.toolkit.forward.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tellxp@github.com
 * @date 2019/5/29 12:09
 */
@ConfigurationProperties(prefix = "forwarder")
@Data
public class ForwarderProperties {
  private String queue;
}
