package com.uranus.proxy.cat062.indra.config;

import com.uranus.proxy.cat062.indra.stream.ProxyChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.ip.udp.MulticastReceivingChannelAdapter;
import org.springframework.integration.ip.udp.UnicastReceivingChannelAdapter;
import org.springframework.messaging.MessageChannel;

/**
 * @author XiaoPeng
 */
@Configuration
@EnableBinding(ProxyChannel.class)
public class DataInAdapterConfig {

  private final Logger logger = LoggerFactory.getLogger(DataInAdapterConfig.class);

  @Value("${udp.ip}")
  private String udpIp;

  @Value("${udp.port}")
  private Integer udpPort;

  @Value("${udp.group}")
  private String udpGroup;
  private final ProxyChannel proxyChannel;

  public DataInAdapterConfig(ProxyChannel proxyChannel) {
    this.proxyChannel = proxyChannel;
  }

  @Bean
  public MessageChannel inboundChannel() {
    return new DirectChannel();
  }

  @Bean(name = "DataInAdapter")
  public MulticastReceivingChannelAdapter udpInAdapter() {
    logger.info("建立组播侦听:" + this.udpGroup +":"+ udpPort);
    MulticastReceivingChannelAdapter adapter = new MulticastReceivingChannelAdapter(udpGroup,this.udpPort);

    logger.info("设置网卡IP为："+this.udpIp);
    adapter.setLocalAddress(udpIp);
    adapter.setReceiveBufferSize(256);
    adapter.setOutputChannel(inboundChannel());
    adapter.setSoTimeout(20);
    logger.info("cat062 udp 接口->spring integration配置完成!");
    return adapter;
  }

}
