package com.uranus.proxy.fdexm.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

/**
 * FdexmProxyProcessor
 *
 * @author tellxp@github.com
 * @date 2018/11/23
 */
@MessageEndpoint
public class FdexmProxyProcessor {

  private static final Logger logger = LoggerFactory.getLogger(FdexmProxyProcessor.class);

  private FdexmProxyChannel fdexmProxyChannel;

  public FdexmProxyProcessor(FdexmProxyChannel fdexmProxyChannel) {
    this.fdexmProxyChannel = fdexmProxyChannel;
  }

  @ServiceActivator(inputChannel = "inboundChannel")
  public void handeMessage(Message<String> message) {
    String fdexmText = message.getPayload();
    if (!fdexmText.endsWith("NNNN")) {
      logger.warn(String.valueOf(fdexmText.length()));
    } else {
//      logger.info(String.valueOf(fdexmText.length()));
    }
    fdexmProxyChannel.fdexm().send(MessageBuilder.withPayload(fdexmText).build());

  }
}
