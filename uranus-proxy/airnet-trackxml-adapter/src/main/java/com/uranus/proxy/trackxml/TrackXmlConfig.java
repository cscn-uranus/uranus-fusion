package com.uranus.proxy.trackxml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * com.uranus.tps.TrackXmlConfig
 *
 * @author 肖鹏
 * @date 2018/11/8
 */


@Component
@ConfigurationProperties(prefix = "uranus.tps.proxy.trackxml")
@Validated
public class TrackXmlConfig {
  @NestedConfigurationProperty
  private Udp udp = new Udp();

  public Udp getUdp() {
    return udp;
  }

  public void setUdp(Udp udp) {
    this.udp = udp;
  }

  public class Udp {

    private int port;

    public int getPort() {
      return port;
    }

    public void setPort(int port) {
      this.port = port;
    }
  }
}
