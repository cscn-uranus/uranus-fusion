package com.uranus.toolkit.udp.multicast.config;

import com.uranus.toolkit.udp.multicast.property.MulticastSplitterProperty;
import com.uranus.toolkit.udp.multicast.property.MulticastInboundProperty;
import com.uranus.toolkit.udp.multicast.property.UnicastOutboundProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.ip.udp.MulticastReceivingChannelAdapter;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;
import org.springframework.messaging.MessageChannel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tellxp@github.com
 * @date 2019/7/9
 */
@Configuration
@EnableConfigurationProperties(MulticastSplitterProperty.class)
@Slf4j
public class MulticastSplitterConfig {

  private static final String DEFAULT_HOST = "127.0.0.1";
  private static final Integer DEFAULT_PORT = 10000;
  private static final Integer DEFAULT_POOL_SIZE = 128;
  private static final Integer DEFAULT_BUFFER_SIZE = 10240;

  private final MulticastSplitterProperty property;

  public MulticastSplitterConfig(MulticastSplitterProperty property) {
    this.property = property;
  }


  @Bean
  public MessageChannel inboundChannel() {
    return new DirectChannel();
  }

  @Bean(name = "inboundAdapter")
  public MulticastReceivingChannelAdapter inboundAdapter() {
    MulticastInboundProperty multicastInboundProperty = property.getInbound();
    String group = multicastInboundProperty.getGroup();
    String host = multicastInboundProperty.getLocalAddress();
    Integer port = multicastInboundProperty.getPort();
    Integer poolSize = multicastInboundProperty.getPoolSize();

    log.info("建立组播侦听:" + group + ":" + port);
    MulticastReceivingChannelAdapter adapter = new MulticastReceivingChannelAdapter(group, port);

    log.info("设置网卡IP为：" + host);
    adapter.setLocalAddress(host);
    adapter.setReceiveBufferSize(DEFAULT_BUFFER_SIZE);
    if (null != poolSize) {
      adapter.setPoolSize(poolSize);
    } else {
      adapter.setPoolSize(DEFAULT_POOL_SIZE);
    }

    adapter.setOutputChannel(inboundChannel());

    log.info("Udp 组播 ---> Spring integration配置完成!");
    return adapter;
  }
  @Bean(name = "outboundAdapters")
  public Map<String,UnicastSendingMessageHandler> outboundAdapters() {
    Map<String, UnicastOutboundProperty> outboundPropertyMap = property.getOutbounds();
    int size = outboundPropertyMap.size();
    Map<String, UnicastSendingMessageHandler> outboundAdapterMap = new HashMap<>(size);

    for (Map.Entry<String, UnicastOutboundProperty> entry : outboundPropertyMap.entrySet()) {
      String outboundAdapterKey = entry.getKey();
      UnicastOutboundProperty outboundProperty = entry.getValue();
      String host = null == outboundProperty.getHost() ? DEFAULT_HOST : outboundProperty.getHost();

      String localAddress =
        null == outboundProperty.getLocalAddress()
          ? DEFAULT_HOST
          : outboundProperty.getLocalAddress();

      int port = null == outboundProperty.getPort() ? DEFAULT_PORT : outboundProperty.getPort();

      log.info("配置 Udp 转发器 ：" + host + ":" + port);
      UnicastSendingMessageHandler handler = new UnicastSendingMessageHandler(host, port);
      handler.setLocalAddress(localAddress);
      outboundAdapterMap.put(outboundAdapterKey, handler);
    }
    return outboundAdapterMap;
  }
}
