package com.uranus.transition.fdexm;

import com.uranus.transition.common.fdexm.dto.FdexmDTO;
import com.uranus.transition.common.fdexm.dto.FdexmParser;
import com.uranus.transition.common.fdexm.dto.ifpl.IfplDTO;
import com.uranus.transition.common.fdexm.dto.ifpl.IfplParser;
import com.uranus.transition.common.util.MessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * @author XiaoPeng
 */
@Slf4j
@EnableBinding(FdexmTransformerChannel.class)
public class FdexmTransformer {


  private final FdexmTransformerChannel fdexmTransformerChannel;

  public FdexmTransformer(FdexmTransformerChannel fdexmTransformerChannel) {
    this.fdexmTransformerChannel = fdexmTransformerChannel;
  }

  @StreamListener(FdexmTransformerChannel.INPUT)
  public void process(Message<String> fdexm) {
    String fdexmText = fdexm.getPayload();

    FdexmDTO fdexmDTO = FdexmParser.parse(fdexmText);

    if (fdexmDTO != null) {
      String title = fdexmDTO.getTitle();

      switch (title) {
//        case "BCWP":
//          this.addmTransformerChannel.bcwp().send(MessageUtil.toMessage(fdexmDTO));
//          break;
//        case "BRTA":
//          this.addmTransformerChannel.brta().send(MessageUtil.toMessage(fdexmDTO));
//          break;
//        case "BRWY":
//          this.addmTransformerChannel.brwy().send(MessageUtil.toMessage(fdexmDTO));
//          break;
//        case "BSEC":
//          this.addmTransformerChannel.bsec().send(MessageUtil.toMessage(fdexmDTO));
//          break;
//        case "BSSR":
//          this.addmTransformerChannel.bssr().send(MessageUtil.toMessage(fdexmDTO));
//          break;
//        case "CFPL":
//          this.addmTransformerChannel.cfpl().send(MessageUtil.toMessage(fdexmDTO));
//          break;
//        case "CHRP":
//          this.addmTransformerChannel.chrp().send(MessageUtil.toMessage(fdexmDTO));
//          break;
//        case "CHRQ":
//          this.addmTransformerChannel.chrq().send(MessageUtil.toMessage(fdexmDTO));
//          break;
//        case "CLAM":
//          this.addmTransformerChannel.clam().send(MessageUtil.toMessage(fdexmDTO));
//          break;
//        case "ICNL":
//          this.addmTransformerChannel.icnl().send(MessageUtil.toMessage(fdexmDTO));
//          break;
//        case "IDEL":
//          this.addmTransformerChannel.idel().send(MessageUtil.toMessage(fdexmDTO));
//          break;
        case "IFPL":
          IfplDTO ifplDTO = IfplParser.parse(fdexmDTO);
          this.fdexmTransformerChannel.ifpl().send(MessageUtil.toMessage(ifplDTO));
          break;
//        case "BQNH":
//          this.addmTransformerChannel.bqnh().send(MessageUtil.toMessage(fdexmDTO));
//          break;
        default:
          log.warn("未知的消息|" + fdexmDTO.getTitle() + "|");
      }
    }
  }
}
