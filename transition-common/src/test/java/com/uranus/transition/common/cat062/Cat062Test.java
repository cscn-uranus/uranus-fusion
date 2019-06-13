package com.uranus.transition.common.cat062;

import com.google.common.primitives.Ints;
import com.uranus.transition.common.asterix.AsterixDataBlock;
import com.uranus.transition.common.asterix.AsterixUap;
import com.uranus.transition.common.asterix.cat062.Cat062Mapper;
import com.uranus.transition.common.asterix.dto.FlightDTO;
import com.uranus.transition.common.asterix.dto.FlightParser;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author tellxp@github.com
 * @date 2019/6/4 19:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Cat062Test {
  @Test
  public void commonTest() {
    byte b1 =(byte) 0b10000000;
    byte b2 =(byte) 0b00000000;
    byte b3 =(byte) 0b00000000;
    byte b4 =(byte) 0b00000000;

    int value1 = (int) ByteUtil.unsignedValueOf("100000");
    long value = Ints.fromBytes(b1,b2,b3,b4);
  }
  @Test
  public void cdatcCat062ParseTest() {

  }

  @Test
  public void indraCat062ParseTest() {
    byte[] message =
      hexStringToByteArray(
        "3e07f8bf7da460650016a680004f5b000131130009eea8f711420211ffd704a5000d1238d72de0c07810e60d1238d72de003ba01010156f801daff51bf4da460650016a680004edbc001304820091c2ff674230021feb600df03180101015ef801d8ffcbbf7da460650016a680004fbb40012f8c20084ee8f77907ffbc036a007f000d8078db1c60ef07f14c780f0e0d8078db1c60fc2101ae03b003b0fff6fffbff380000fcd707930000012a005600d801010146f003b00000bf7da460650016a680004f0240013046a00919b2f6a2080047fc6a081d000d33b3cb1da0ef07f14c7800f70d33b3cb1da082af01c4052c052c0029fffbff9c00007db607f70000010d005f017e01010146f0052c0000bf7da460650016a680004faa8001303da0090ac6f7696e003cfcb50364000c54f2cb6c60ef07f14c7812290c54f2cb6c6082af019403880388ffd7fffb006400007e6c074a000001240050044201010146f0033c0000bf7da460650016a68000504d400130348008fc88f82b2c0040fca60825000c41f4e76ce0ef07f14c7808210c41f4e76ce081f901a003d803d8ffcd000f000000007db6075c0000011b005406ae01010146f003d70000bf3da460650016a680004f5c000130f7a009d1f2f71142ff9e01ac00444079e36d60c0780fc8444079e36d6007a601010176f80111ffb5bf7da460650016a68000516520013024e008e370f977bb004bfc51081a000d33b3cb2da0ef07f14c7808c00d33b3cb2da0836401ca052c052c00240005000000007db6082e000001140062060b01010146f0052c0000bf7da460650016a680005288200130160008cb05fad1650034fcfa0366000c41f1c77de0ef07f14c78063b0c41f1c77de07f21017002000200ffec0005006400007db606af0000012b0047075701010146f001ff0000bf7da460650016a6800052ac40012f430007ed3efaf6b3fe5bfce30e3e000c41f4e37ce0ef07f14c780ff40c41f4e37ce0952601b805a405a40005003808fc00088ca0079c000000fb005f07eb01010146f405a6004ebf7da460650016a6800053182001300ec008bf0afb7c4f0034fcfc0d2300049475d77820ef07f14c880452049475d77820808d016a02000200000f000fff9c00007e6c06a6000001280046061701010146f002000000bf7da460650016a68000535c20012f484007ee26fbc87f0025fc75060d000c54f5df5d20ef07f14c7805590c54f5df5d2084d001ba04b404b4ff76ff61000000007f2107e500000110005d06b001010146f804e8ff5ebf7da460650016a68000540f40012f44e007e58efc9d010021fc6a084f000c54f2d78de0ef07f14c7815af0c54f2d78de0858601ba05a405a4000f0005000000007f2107e5000000fc005f0ab401010146f005a40000bf7da460650016a68000557a600131442009ecd9fe5b470298fe9d0aee0030b179d74e20ef07f14c78101b30b179d74e205484016402000200fff6fffb08fc000a50f7068b00000122004507fb01010146f002000000bf7da460650016a68000552b400130b420095a20fdf8b5fe4e01be0cd8000c54f5d33de0ef07f14c7808ef0c54f5d33de0e290013601d801d8ff2eff4dff9c0000e124055e000000fa003c048701010146f8021bff5cbf5da460650016a6800055e9e0012ff120088a5dfed643019503570370ef07f14c7807b80c21f8e79d60ffaf0000000000000000000000000000ffaf000000000000000004390101014ef004dd0000bf7da460650016a68000558340012f5de007f528fe5890ff5cfdc5062d000c3071d32e60ef07f14c7800bb0c3071d32e608ca0011000ec00ecffbdffe1ff9c00008bea04f1000000ec003507a401010146f0015d0000bf7da460650016a68000556e400130a640094966fe4849fdaa026d02f8000d8078d32ce0ef07f14c780e490d8078d32ce0e12401c604b404b4000f000500000000e12407650000011e005f043201010146f004b40000bf7da460650016a68000555340012febc0088976fe22c20011fc51082400202233cb5d60ef07f14c7812cb202233cb5d60863c01c805040504000f0005000000007fd7082e00000116006006a501010146f005040000bf7da460650016a68000561440012f9e4008338dff06a4ff01fdff04fe00502079e70de0ef07f14c7804c8502079e70de09747010601640164ff66ff6600640000947004d6000000dc003203ef01010146f8019fff7dbf7da460650016a6800055e960012fb0e0084820fed40002abfd40035700502079e34d60ef07f14c7811dd502079e34d60642401c003d803d8ffe6fff600640000614d088900000133005b022c01010146f003d80000bf7da460650016a68000561f20012f76e0080a68ff122b0260fd930f2700545072df1ce0ef07f14c781278545072df1ce064da018c04280428ffd2fffbff9c0000614d0781000001050051076901010146f004280000bf7da460650016a6800056bc20012f96800826aaffcdd0ff26fdaa0032000c54f2cb4d20ef07f14c780ec00c54f2cb4d209304013e01880188ff2efef6f6a000f49304057a000000fc003f0a8d01010146f80254ff32bf7da460650016a68000547580012f60c007ff8efd17fdfff603850afd000c54f2c75c20ef07f14c79a0130c54f2c75c2000b601be04dc04dcfff6000a01f4000202d707d200000113005e095f01010146f004dc0000bf7da460650016a680005654c001301f6008b6e7ff56acfecbfcb7081f000c54f2cf0c60ef07f14c780b7a0c54f2cf0c6095dc01c205540554ffe1fffbff9c00008f7707c00000010a006008c501010146f005540000");

    Cat062Mapper cat062Mapper = new Cat062Mapper(message);
    AsterixUap asterixUap = cat062Mapper.readValue();
    Assert.assertEquals(Integer.valueOf(62), asterixUap.getCategory());
    Assert.assertEquals(Integer.valueOf(message.length),asterixUap.getLength());
  }

  private static byte[] hexStringToByteArray(String hexString) {
    int radix = 2;
    if (Math.ceil(hexString.length() / radix) != Math.floor(hexString.length() / radix)) {
      log.error("hex字符串不完整");
    }

    int length = (int) Math.ceil(hexString.length() / radix);
    byte[] byteArray = new byte[length];

    for (int i = 0; i < length; i++) {
      int beginIndex = i * radix;
      int endIndex = i * radix + radix;

      byte byteItem = (byte)Integer.parseInt(hexString.substring(beginIndex, endIndex), 16);
      byteArray[i] = byteItem;
    }
    return byteArray;
  }
}