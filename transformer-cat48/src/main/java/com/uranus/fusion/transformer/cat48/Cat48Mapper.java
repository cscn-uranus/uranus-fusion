package com.uranus.fusion.transformer.cat48;

import com.google.common.base.Strings;
import com.google.common.primitives.Bytes;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Cat48Mapper {

  @Scheduled(fixedRate = 1000)
  public void proc() {
    String hexString =
        "30003bfff702460c707ffba01f0de12b24470337e01303b8780eb6545072cb2d200297100030a400004080105b2fe00cb95000260784061b4620f5";
    byte[] value = new byte[100];
    int index=0;
    for (int i = 0; i<hexString.length();i=i+2) {
      String octectString = hexString.substring(i,i+2);
      value[index] = (byte)Integer.parseInt(octectString,16);
      index++;
    }
    System.out.println("debug");
  }
}
