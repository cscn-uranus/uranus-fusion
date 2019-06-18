package com.uranus.service.filter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tellxp@github.com
 * @date 2019/5/29 21:59
 */

@ConfigurationProperties(prefix = "filter")
@Data
public class FlightFilterProperties {
  private String queue;
  private String callsignPrefixRestriction;
}
