package com.uranus.transformer.fdexm.stream;

import com.uranus.transformer.fdexm.dto.AddmDTO;
import com.uranus.transformer.fdexm.dto.ifpl.IfplDTO;
import com.uranus.transformer.fdexm.mapper.AddmMapper;
import com.uranus.transformer.fdexm.mapper.IfplMapper;
import com.uranus.transformer.fdexm.util.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@EnableBinding(FdexmTransformerChannel.class)
public class AddmTransformer {

  private final Logger logger = LoggerFactory.getLogger(AddmTransformer.class);

  private final FdexmTransformerChannel fdexmTransformerChannel;

  public AddmTransformer(FdexmTransformerChannel fdexmTransformerChannel) {
    this.fdexmTransformerChannel = fdexmTransformerChannel;
  }

  @StreamListener(FdexmTransformerChannel.INPUT)
  public void process(Message<String> fdexm) {
    String fdexmText = fdexm.getPayload();

    AddmDTO addmDTO = AddmMapper.toAddmDTO(fdexmText);

    if (addmDTO != null) {
      String title = addmDTO.getTitle();

      switch (title) {
//        case "BCWP":
//          this.addmTransformerChannel.bcwp().send(MessageUtil.toMessage(addmDTO));
//          break;
//        case "BRTA":
//          this.addmTransformerChannel.brta().send(MessageUtil.toMessage(addmDTO));
//          break;
//        case "BRWY":
//          this.addmTransformerChannel.brwy().send(MessageUtil.toMessage(addmDTO));
//          break;
//        case "BSEC":
//          this.addmTransformerChannel.bsec().send(MessageUtil.toMessage(addmDTO));
//          break;
//        case "BSSR":
//          this.addmTransformerChannel.bssr().send(MessageUtil.toMessage(addmDTO));
//          break;
//        case "CFPL":
//          this.addmTransformerChannel.cfpl().send(MessageUtil.toMessage(addmDTO));
//          break;
//        case "CHRP":
//          this.addmTransformerChannel.chrp().send(MessageUtil.toMessage(addmDTO));
//          break;
//        case "CHRQ":
//          this.addmTransformerChannel.chrq().send(MessageUtil.toMessage(addmDTO));
//          break;
//        case "CLAM":
//          this.addmTransformerChannel.clam().send(MessageUtil.toMessage(addmDTO));
//          break;
//        case "ICNL":
//          this.addmTransformerChannel.icnl().send(MessageUtil.toMessage(addmDTO));
//          break;
//        case "IDEL":
//          this.addmTransformerChannel.idel().send(MessageUtil.toMessage(addmDTO));
//          break;
        case "IFPL":
          IfplDTO ifplDTO = IfplMapper.toIfplDTO(addmDTO);
          this.fdexmTransformerChannel.ifpl().send(MessageUtil.toMessage(ifplDTO));
          break;
//        case "BQNH":
//          this.addmTransformerChannel.bqnh().send(MessageUtil.toMessage(addmDTO));
//          break;
        default:
          logger.warn("未知的消息|" + addmDTO.getTitle() + "|");
      }
    }
  }
}
