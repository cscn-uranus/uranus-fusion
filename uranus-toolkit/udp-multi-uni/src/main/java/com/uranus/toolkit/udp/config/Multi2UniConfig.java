package com.uranus.toolkit.udp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.ip.udp.MulticastReceivingChannelAdapter;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;
import org.springframework.messaging.MessageChannel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tellxp@github.com
 * @date 2019/5/27 22:29
 */
@Configuration
@EnableConfigurationProperties(Multi2UniProperty.class)
@Slf4j
public class Multi2UniConfig {

  private final Multi2UniProperty multi2UniProperty;

  public Multi2UniConfig(Multi2UniProperty multi2UniProperty) {
    this.multi2UniProperty = multi2UniProperty;
  }

  @Bean
  public MessageChannel inboundChannel() {
    return new PublishSubscribeChannel();
  }

  @Bean(name = "receiver")
  public MulticastReceivingChannelAdapter receiver() {
    ReceiverProperty receiverProperty = multi2UniProperty.getReceiver();
    String group = receiverProperty.getGroup();
    String host = receiverProperty.getIp();
    Integer port = receiverProperty.getPort();
    Integer poolSize = receiverProperty.getPoolSize();

    log.info("建立组播侦听:" + group + ":" + port);
    MulticastReceivingChannelAdapter adapter = new MulticastReceivingChannelAdapter(group, port);

    log.info("设置网卡IP为：" + host);
    adapter.setLocalAddress(host);
    adapter.setReceiveBufferSize(102400);
    if (null!=poolSize) {
      adapter.setPoolSize(poolSize);
    } else {
      adapter.setPoolSize(128);
    }

    adapter.setOutputChannel(inboundChannel());

    log.info("Udp 组播 ---> Spring integration配置完成!");
    return adapter;
  }

  @Bean(name = "senders")
  public List<UnicastSendingMessageHandler> senders() {
    List<UnicastSendingMessageHandler> senders = new ArrayList<>();
    for (SenderProperty senderProperty: multi2UniProperty.getSenders()) {
      log.info("配置 Udp 转发器 ：" + senderProperty.getIp() + ":" + senderProperty.getPort());
      UnicastSendingMessageHandler handler =
        new UnicastSendingMessageHandler(senderProperty.getIp(), senderProperty.getPort());
      handler.setLocalAddress(senderProperty.getIp());
      senders.add(handler);
    }

    return senders;
  }
}
