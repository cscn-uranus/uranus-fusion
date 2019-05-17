package com.uranus.fusion.tfr.cat062.modesel.stream;

import com.uranus.fusion.common.asterix.AsterixDataBlock;
import com.uranus.fusion.common.asterix.AsterixUap;
import com.uranus.fusion.common.asterix.cat062.Cat062Mapper;
import com.uranus.fusion.tfr.cat062.modesel.dto.AircraftDTO;
import com.uranus.fusion.tfr.cat062.modesel.mapper.AsterixDataBlockMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XiaoPeng
 */
@Component
@EnableBinding(ModeSelTransformerChannel.class)
@Slf4j
public class ModeSelTransformer {

  @StreamListener(ModeSelTransformerChannel.INPUT)
  public void process(Message<byte[]> message) {
    byte[] receivedBytes = message.getPayload();
    Cat062Mapper mapper = new Cat062Mapper(receivedBytes);
    AsterixUap cat62UapDTO = mapper.readValue();
  }

  private List<AircraftDTO> doTransform(AsterixUap asterixUap) {
    List<AsterixDataBlock> asterixDataBlocks = asterixUap.getAsterixDataBlocks();
    List<AircraftDTO> aircraftDTOS = new ArrayList<>();
    for(AsterixDataBlock data: asterixDataBlocks) {
      if (null!=data.getAircraftDerivedData()) {
        AircraftDTO aircraftDTO = AsterixDataBlockMapper.toAircraftDTO(data);
        aircraftDTOS.add(aircraftDTO);
      }
    }
    return aircraftDTOS;
  }
}
