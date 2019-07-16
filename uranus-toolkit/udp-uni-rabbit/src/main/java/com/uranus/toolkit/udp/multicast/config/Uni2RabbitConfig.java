package com.uranus.toolkit.udp.multicast.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.ip.udp.UnicastReceivingChannelAdapter;
import org.springframework.messaging.MessageChannel;

/**
 * @author tellxp@github.com
 * @date 2019/5/29 15:40
 */
@Configuration
@EnableConfigurationProperties(Uni2RabbitProperties.class)
@Slf4j
public class Uni2RabbitConfig {
  private final Uni2RabbitProperties uni2RabbitProperties;

  public Uni2RabbitConfig(Uni2RabbitProperties uni2RabbitProperties) {
    this.uni2RabbitProperties = uni2RabbitProperties;
  }

  @Bean
  public MessageChannel inboundChannel() {
    return new DirectChannel();
  }

  @Bean
  public UnicastReceivingChannelAdapter udpInAdapter() {
    log.info("建立 Udp 单播侦听:" + uni2RabbitProperties.getHost() + ":" + uni2RabbitProperties.getPort());
    UnicastReceivingChannelAdapter adapter =
        new UnicastReceivingChannelAdapter(uni2RabbitProperties.getPort());
    adapter.setLocalAddress(uni2RabbitProperties.getHost());

    log.info("配置 Udp 单播接口 ---> Spring integration inboundChannel");
    adapter.setReceiveBufferSize(8192);
    adapter.setOutputChannel(inboundChannel());
    return adapter;
  }
}
