package com.uranus.proxy.trackxml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.ip.udp.UnicastReceivingChannelAdapter;

/**
 * TrackXmlInAdapterConfig
 *
 * @author 肖鹏
 * @date 2018/11/8
 */
@Configuration
@EnableBinding(TrackXmlPublisher.class)
public class TrackXmlInAdapterConfig {

  private final TrackXmlPublisher trackXmlPublisher;
  private final Logger logger = LoggerFactory.getLogger(TrackXmlInAdapterConfig.class);
  private final TrackXmlConfig trackXmlConfig;

  public TrackXmlInAdapterConfig(TrackXmlPublisher trackXmlPublisher,
      TrackXmlConfig trackXmlConfig) {
    this.trackXmlPublisher = trackXmlPublisher;
    this.trackXmlConfig = trackXmlConfig;
  }

  @Bean(name = "trackXmlInAdapter")
  public UnicastReceivingChannelAdapter udpInAdapter() {
    logger.info("trackXml 端口号为:" + trackXmlConfig.getUdp().getPort());
    UnicastReceivingChannelAdapter adapter = new UnicastReceivingChannelAdapter(
        trackXmlConfig.getUdp().getPort());
    adapter.setOutputChannel(trackXmlPublisher.trackXmlText());
    logger.info("trackXml udp接口->消息队列配置完成!");
    return adapter;
  }
}

