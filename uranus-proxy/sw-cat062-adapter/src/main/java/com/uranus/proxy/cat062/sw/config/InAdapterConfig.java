package com.uranus.proxy.cat062.sw.config;

import com.uranus.proxy.cat062.sw.stream.ProxyChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.ip.udp.UnicastReceivingChannelAdapter;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableBinding(ProxyChannel.class)
public class InAdapterConfig {

  private final ProxyChannel proxyChannel;
  private final Logger logger = LoggerFactory.getLogger(InAdapterConfig.class);

  @Value("${cat62In.udp.ip}")
  private String cat62InIP;

  @Value("${cat62In.udp.port}")
  private Integer cat62InPort;

  @Value("${cat62Out.udp.ip}")
  private String cat62OutIP;

  @Value("${cat62Out.udp.port}")
  private Integer cat62OutPort;

  public InAdapterConfig(ProxyChannel proxyChannel) {
    this.proxyChannel = proxyChannel;
  }

  @Bean
  public MessageChannel inboundChannel() {
    return new DirectChannel();
  }

  @Bean(name = "cat62InAdapter")
  public UnicastReceivingChannelAdapter udpInAdapter() {
    logger.info("cat062 udp端口号为:" + this.cat62InIP);
    UnicastReceivingChannelAdapter adapter = new UnicastReceivingChannelAdapter(this.cat62InPort);
    adapter.setReceiveBufferSize(8192);
    adapter.setOutputChannel(inboundChannel());
    logger.info("cat062 udp接口->spring integration配置完成!");
    return adapter;
  }

  @Bean
  public UnicastSendingMessageHandler udpSendingAdapter() {
    logger.info(
        "cat062 udp 转发器配置完成, 对端IP为:"
            + this.cat62OutIP
            + "| 对端port为:"
            + this.cat62OutPort.toString());
    return new UnicastSendingMessageHandler(this.cat62OutIP, this.cat62OutPort);
  }
}
