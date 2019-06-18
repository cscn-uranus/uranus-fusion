package com.uranus.toolkit.forward.stream;

import com.uranus.toolkit.forward.config.ForwarderProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author tellxp@github.com
 * @date 2019/5/29 11:43
 */
@Component
@EnableConfigurationProperties(ForwarderProperties.class)
@EnableBinding(RabbitInChannel.class)
@Slf4j
public class Rabbit2ActiveMqProcessor {
  private final JmsTemplate jmsTemplate;
  private final ForwarderProperties forwarderProperties;

  public Rabbit2ActiveMqProcessor(JmsTemplate jmsTemplate, ForwarderProperties forwarderProperties) {
    this.jmsTemplate = jmsTemplate;
    this.forwarderProperties = forwarderProperties;
  }

  @StreamListener(RabbitInChannel.INPUT)
  public void process(Message<String> message) {
    jmsTemplate.convertAndSend(forwarderProperties.getQueue(),message);
  }
}
