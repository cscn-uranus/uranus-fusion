package com.uranus.transition.cat062.stream;

import com.uranus.transition.common.asterix.AsterixDataBlock;
import com.uranus.transition.common.asterix.uap.eucat062.EuCat062DataBlock;
import com.uranus.transition.common.asterix.uap.eucat062.EuCat062Uap;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.reader.eucat062.EuCat062Reader;
import com.uranus.transition.common.dto.FlightDTO;
import com.uranus.transition.common.dto.FlightParser;
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
    List<Byte> messageList = ByteUtil.asList(receivedBytes);
    EuCat062Reader mapper = new EuCat062Reader();
    EuCat062Uap euCat062Uap = mapper.readValue(messageList);
    List<EuCat062DataBlock> asterixDataBlocks = euCat062Uap.getEuCat062DataBlocks();

    for (EuCat062DataBlock asterixDataBlock: asterixDataBlocks) {
      FlightDTO flightDTO = FlightParser.parse(asterixDataBlock);

      if (null != flightDTO) {
        log.info("发送FlightDTO："+flightDTO.getFlightIdentification());
        this.cat062TransformerChannel.flight().send(MessageBuilder.withPayload(flightDTO).build());
      }
    }
  }
}
