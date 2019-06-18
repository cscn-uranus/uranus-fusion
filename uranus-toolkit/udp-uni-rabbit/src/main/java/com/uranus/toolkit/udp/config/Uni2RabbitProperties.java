package com.uranus.toolkit.udp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tellxp@github.com
 * @date 2019/5/29 15:44
 */
@ConfigurationProperties(prefix = "uranus")
@Data
public class Uni2RabbitProperties {
  private String host;
  private Integer port;
}
