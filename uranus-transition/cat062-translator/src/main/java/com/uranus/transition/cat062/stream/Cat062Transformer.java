package com.uranus.transition.cat062.stream;

import com.uranus.transition.common.asterix.AsterixDataBlock;
import com.uranus.transition.common.asterix.AsterixUap;
import com.uranus.transition.common.asterix.cat062.Cat062Parser;
import com.uranus.transition.common.asterix.dto.FlightDTO;
import com.uranus.transition.common.asterix.dto.FlightParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author XiaoPeng
 */
@Component
@EnableBinding(Cat062TransformerChannel.class)
@Slf4j
public class Cat062Transformer {

  private final Cat062TransformerChannel cat062TransformerChannel;

  public Cat062Transformer(Cat062TransformerChannel cat062TransformerChannel) {
    this.cat062TransformerChannel = cat062TransformerChannel;
  }

  @StreamListener(Cat062TransformerChannel.INPUT)
  public void process(Message<byte[]> message) {

    byte[] receivedBytes = message.getPayload();
    Cat062Parser mapper = new Cat062Parser(receivedBytes);
    AsterixUap asterixUap = mapper.readValue();
    List<AsterixDataBlock> asterixDataBlocks = asterixUap.getAsterixDataBlocks();

    for (AsterixDataBlock asterixDataBlock: asterixDataBlocks) {
      FlightDTO flightDTO = FlightParser.parse(asterixDataBlock);

      if (null != flightDTO) {
        log.info("发送FlightDTO："+flightDTO.getFlightIdentification());
        this.cat062TransformerChannel.flight().send(MessageBuilder.withPayload(flightDTO).build());
      }
    }
  }
}
