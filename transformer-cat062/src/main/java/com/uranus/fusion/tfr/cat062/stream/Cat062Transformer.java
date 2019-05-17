package com.uranus.fusion.tfr.cat062.stream;

import com.uranus.fusion.common.asterix.AsterixUap;
import com.uranus.fusion.common.asterix.cat062.Cat062Mapper;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author XiaoPeng
 */
@Component
@EnableBinding(Cat062TransformerChannel.class)
public class Cat062Transformer {

  @StreamListener(Cat062TransformerChannel.INPUT)
  public void process(Message<byte[]> message) {

    byte[] receivedBytes = message.getPayload();
    Cat062Mapper mapper = new Cat062Mapper(receivedBytes);
    AsterixUap asterixUap = mapper.readValue();
  }

}
