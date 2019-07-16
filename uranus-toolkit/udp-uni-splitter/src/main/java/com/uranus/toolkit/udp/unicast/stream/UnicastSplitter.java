package com.uranus.toolkit.udp.unicast.stream;

import com.uranus.toolkit.udp.unicast.property.UnicastOutboundProperty;
import com.uranus.toolkit.udp.unicast.property.UnicastSplitterProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;

/**
 * @author tellxp@github.com
 * @date 2019/5/29 9:25
 */
@MessageEndpoint
@Slf4j
public class UnicastSplitter {

  private final Map<String, UnicastSendingMessageHandler> outboundAdapterMap;
  private final UnicastSplitterProperty property;

  public UnicastSplitter(
      Map<String, UnicastSendingMessageHandler> outboundAdapterMap,
      UnicastSplitterProperty property) {
    this.outboundAdapterMap = outboundAdapterMap;
    this.property = property;
  }

  @ServiceActivator(inputChannel = "inboundChannel")
  public void handleMessage(Message<byte[]> message) {
    byte[] payload = message.getPayload();
    Map<String, UnicastOutboundProperty> outboundPropertyMap = property.getOutbounds();

    for (Map.Entry<String, UnicastOutboundProperty> entry : outboundPropertyMap.entrySet()) {
      UnicastOutboundProperty outboundProperty = entry.getValue();
      if (outboundProperty.getEnabled()) {
        UnicastSendingMessageHandler outboundAdapter = outboundAdapterMap.get(entry.getKey());
        outboundAdapter.handleMessage(MessageBuilder.withPayload(payload).build());
        log.info("转发了 Udp 报文：" + message.toString());
      }
    }
  }
}
