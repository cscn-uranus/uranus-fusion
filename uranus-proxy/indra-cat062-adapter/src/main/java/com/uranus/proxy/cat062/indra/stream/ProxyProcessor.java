package com.uranus.proxy.cat062.indra.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.time.LocalDateTime;

/**
 * FdexmProxyProcessor
 *
 * @author tellxp@github.com
 * @date 2018/11/23
 */
@MessageEndpoint
@EnableBinding(ProxyChannel.class)
public class ProxyProcessor {

  private static final Logger logger = LoggerFactory.getLogger(ProxyProcessor.class);

  private final ProxyChannel proxyChannel;

  public ProxyProcessor(ProxyChannel proxyChannel) {
    this.proxyChannel = proxyChannel;
  }


  @ServiceActivator(inputChannel = "inboundChannel")
  public void handleMessage(Message message) {
//   byte[] payload = message.getPayload();
    logger.info(LocalDateTime.now().toString());
//   this.proxyChannel.indraCat062().send(MessageBuilder.withPayload(payload).build());
  }
}
