package com.uranus.proxy.fdexm.config;

import com.uranus.proxy.fdexm.stream.FdexmProxyChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.ip.udp.UnicastReceivingChannelAdapter;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableBinding(FdexmProxyChannel.class)
public class FdexmInAdapterConfig {

  private final FdexmProxyChannel fdexmProxyChannel;
  private final Logger logger = LoggerFactory.getLogger(FdexmInAdapterConfig.class);

  public FdexmInAdapterConfig(FdexmProxyChannel fdexmProxyChannel) {
    this.fdexmProxyChannel = fdexmProxyChannel;
  }
  @Bean
  public MessageChannel inboundChannel() {
    return new DirectChannel();
  }

  @Bean(name = "fdexmInAdapter")
  public UnicastReceivingChannelAdapter udpInAdapter() {
    logger.info("fdexm udp端口号为:10100");
    UnicastReceivingChannelAdapter adapter = new UnicastReceivingChannelAdapter(
        10100);
    adapter.setReceiveBufferSize(8192);
    adapter.setOutputChannel(inboundChannel());
    logger.info("fdexm udp接口->消息队列配置完成!");
    return adapter;
  }
}
