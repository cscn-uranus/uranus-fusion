package com.uranus.fusion.tfr.cat062.stream;

import com.uranus.fusion.tfr.cat062.dto.AddmDTO;
import com.uranus.fusion.tfr.cat062.dto.ifpl.IfplDTO;
import com.uranus.fusion.common.util.MessageUtil;
import com.uranus.fusion.fdexm.mapper.AddmMapper;
import com.uranus.fusion.fdexm.mapper.IfplMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@Slf4j
@EnableBinding(FdexmTransformerChannel.class)
public class AddmTransformer {


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
          log.warn("未知的消息|" + addmDTO.getTitle() + "|");
      }
    }
  }
}
