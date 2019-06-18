package com.uranus.proxy.cat062.sw.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

/**
 * FdexmProxyProcessor
 *
 * @author tellxp@github.com
 * @date 2018/11/23
 */
@MessageEndpoint
public class ProxyProcessor {

  private static final Logger logger = LoggerFactory.getLogger(ProxyProcessor.class);

  private final ProxyChannel proxyChannel;
  private final UnicastSendingMessageHandler udpSendingAdapter;

  public ProxyProcessor(ProxyChannel proxyChannel, UnicastSendingMessageHandler udpSendingAdapter) {
    this.proxyChannel = proxyChannel;
      this.udpSendingAdapter = udpSendingAdapter;
  }


  @ServiceActivator(inputChannel = "inboundChannel")
  public void handleMessage(Message<byte[]> message) {
   byte[] payload = message.getPayload();

   logger.info(String.valueOf(payload.length));

   byte[] payloadForTransformer = payload.clone();
   byte[] payloadForSystemConvert = payload.clone();

   this.proxyChannel.cat62().send(MessageBuilder.withPayload(payloadForTransformer).build());
   this.udpSendingAdapter.handleMessage(MessageBuilder.withPayload(payloadForSystemConvert).build());
  }
}
