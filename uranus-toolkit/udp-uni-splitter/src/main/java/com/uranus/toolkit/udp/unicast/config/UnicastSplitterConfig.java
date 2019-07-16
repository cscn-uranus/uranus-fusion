package com.uranus.toolkit.udp.unicast.config;

import com.uranus.toolkit.udp.unicast.property.UnicastInboundProperty;
import com.uranus.toolkit.udp.unicast.property.UnicastOutboundProperty;
import com.uranus.toolkit.udp.unicast.property.UnicastSplitterProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.ip.udp.UnicastReceivingChannelAdapter;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;
import org.springframework.messaging.MessageChannel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tellxp@github.com
 * @date 2019/5/27 22:29
 */

@Configuration
@EnableConfigurationProperties({UnicastSplitterProperty.class})
@Slf4j
public class UnicastSplitterConfig {

  private static final String DEFAULT_HOST = "127.0.0.1";
  private static final Integer DEFAULT_PORT = 10000;
  private static final Integer DEFAULT_POOL_SIZE = 128;
  private static final Integer DEFAULT_BUFFER_SIZE = 10240;
  private final UnicastSplitterProperty property;

  public UnicastSplitterConfig(UnicastSplitterProperty property) {
    this.property = property;
  }

  @Bean
  public MessageChannel inboundChannel() {
    return new PublishSubscribeChannel();
  }

  @Bean(name = "inboundAdapter")
  public UnicastReceivingChannelAdapter inboundAdapter() {

    UnicastInboundProperty inboundProperty = property.getInbound();

    String host =
        null == inboundProperty.getLocalAddress()
            ? DEFAULT_HOST
            : inboundProperty.getLocalAddress();

    int port = null == inboundProperty.getPort() ? DEFAULT_PORT : inboundProperty.getPort();

    int poolSize =
        null == inboundProperty.getPoolSize() ? DEFAULT_POOL_SIZE : inboundProperty.getPoolSize();

    int bufferSize =
        null == inboundProperty.getBufferSize()
            ? DEFAULT_BUFFER_SIZE
            : inboundProperty.getBufferSize();

    log.info("建立单播侦听:" + host + ":" + port);

    UnicastReceivingChannelAdapter adapter = new UnicastReceivingChannelAdapter(port);

    log.info("设置网卡IP为：" + host);
    adapter.setLocalAddress(host);

    log.info("设置pool大小为：" + poolSize);
    adapter.setPoolSize(poolSize);

    log.info("设置缓冲区大小为：" + bufferSize);
    adapter.setReceiveBufferSize(bufferSize);

    log.info("设置输出 Channel 为：inboundChannel");
    adapter.setOutputChannel(inboundChannel());

    log.info("Udp 组播 ---> Spring integration配置完成!");
    return adapter;
  }

  @Bean(name = "outboundAdapters")
  public Map<String, UnicastSendingMessageHandler> outboundAdapters() {
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
