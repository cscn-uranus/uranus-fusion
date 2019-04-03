package com.uranus.transformer.fdexm.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * FdexmTransformerChannel
 *
 * @author tellxp@github.com
 * @date 2018/11/23
 */
@Component
public interface FdexmTransformerChannel {
  String INPUT = "fdexm-transformer-input";
  String OUTPUT_BCWP="fdexm-transformer-bcwp-output";
  String OUTPUT_BRTA="fdexm-transformer-brta-output";
  String OUTPUT_BRWY="fdexm-transformer-brwy-output";
  String OUTPUT_BSEC="fdexm-transformer-bsec-output";
  String OUTPUT_BSSR="fdexm-transformer-bssr-output";
  String OUTPUT_CFPL="fdexm-transformer-cfpl-output";
  String OUTPUT_CHRP="fdexm-transformer-chrp-output";
  String OUTPUT_CHRQ="fdexm-transformer-chrq-output";
  String OUTPUT_CLAM="fdexm-transformer-clam-output";
  String OUTPUT_ICNL="fdexm-transformer-icnl-output";
  String OUTPUT_IDEL="fdexm-transformer-idel-output";
  String OUTPUT_IFPL="fdexm-transformer-ifpl-output";
  String OUTPUT_BQNH="fdexm-transformer-bqnh-output";

  @Input(INPUT)
  SubscribableChannel fdexm();

  @Output(OUTPUT_BCWP)
  MessageChannel bcwp();

  @Output(OUTPUT_BRTA)
  MessageChannel brta();

  @Output(OUTPUT_BRWY)
  MessageChannel brwy();

  @Output(OUTPUT_BSEC)
  MessageChannel bsec();

  @Output(OUTPUT_BSSR)
  MessageChannel bssr();

  @Output(OUTPUT_CFPL)
  MessageChannel cfpl();

  @Output(OUTPUT_CHRP)
  MessageChannel chrp();

  @Output(OUTPUT_CHRQ)
  MessageChannel chrq();

  @Output(OUTPUT_CLAM)
  MessageChannel clam();

  @Output(OUTPUT_ICNL)
  MessageChannel icnl();

  @Output(OUTPUT_IDEL)
  MessageChannel idel();

  @Output(OUTPUT_IFPL)
  MessageChannel ifpl();

  @Output(OUTPUT_BQNH)
  MessageChannel bqnh();
}
