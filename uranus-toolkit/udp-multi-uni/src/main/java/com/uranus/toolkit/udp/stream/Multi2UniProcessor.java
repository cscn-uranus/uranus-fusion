package com.uranus.toolkit.udp.stream;

import com.uranus.toolkit.udp.config.Multi2UniProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.List;

/**
 * @author tellxp@github.com
 * @date 2019/5/29 9:25
 */
@MessageEndpoint
@Slf4j
public class Multi2UniProcessor {

  private final Multi2UniProperty multi2UniProperty;
  private final List<UnicastSendingMessageHandler> senders;

  public Multi2UniProcessor(
    Multi2UniProperty multi2UniProperty, List<UnicastSendingMessageHandler> senders) {
    this.multi2UniProperty = multi2UniProperty;
    this.senders = senders;
  }

  @ServiceActivator(inputChannel = "inboundChannel")
  public void handleMessage(Message<byte[]> message) {
    byte[] payload = message.getPayload();

    log.info(message.hashCode()+"");

    for (int i = 0; i< multi2UniProperty.getSenders().size(); i++) {
      Message<byte[]> newMessage=MessageBuilder.withPayload(payload).build();
      if (multi2UniProperty.getSenders().get(i).getEnabled()) {
        senders.get(i).handleMessage(newMessage);
      }
    }
  }
}
