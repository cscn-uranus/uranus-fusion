package com.uranus.toolkit.udp.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author tellxp@github.com
 * @date 2019/5/29 15:41
 */
@MessageEndpoint
@EnableBinding(Uni2RabbitChannel.class)
@Slf4j
public class Uni2RabbitProcessor {

  private final Uni2RabbitChannel uni2RabbitChannel;

  public Uni2RabbitProcessor(Uni2RabbitChannel uni2RabbitChannel) {
    this.uni2RabbitChannel = uni2RabbitChannel;
  }

  @ServiceActivator(inputChannel = "inboundChannel")
  public void handleMessage(Message<byte[]> message) {

    byte[] payload = message.getPayload();

    log.info("转发消息："+message.toString());
    uni2RabbitChannel.bridge().send(MessageBuilder.withPayload(payload).build());
  }
}
