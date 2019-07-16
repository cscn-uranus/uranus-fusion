package com.uranus.toolkit.udp.multicast.stream;

import com.uranus.toolkit.udp.multicast.property.MulticastSplitterProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author tellxp@github.com
 * @date 2019/5/29 9:25
 */
@MessageEndpoint
@Slf4j
public class MulticastSplitter {

  private final MulticastSplitterProperty multicastSplitterProperty;

  public MulticastSplitter(
    MulticastSplitterProperty multicastSplitterProperty) {
    this.multicastSplitterProperty = multicastSplitterProperty;
  }

  @ServiceActivator(inputChannel = "inboundChannel")
  public void handleMessage(Message<byte[]> message) {
    byte[] payload = message.getPayload();

    log.info(message.hashCode()+"");

    for (int i = 0; i< multicastSplitterProperty.getOutbounds().size(); i++) {
      Message<byte[]> newMessage=MessageBuilder.withPayload(payload).build();
      if (multicastSplitterProperty.getOutbounds().get(i).getEnabled()) {
      }
    }
  }
}
