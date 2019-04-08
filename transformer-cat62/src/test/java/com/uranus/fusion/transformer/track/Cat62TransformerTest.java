package com.uranus.fusion.transformer.track;

import com.uranus.fusion.common.asterix.Cat062Mapper;
import com.uranus.fusion.transformer.Cat62TransformerTestApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Cat62TransformerTestApp.class)
public class Cat62TransformerTest {

  private final Logger logger = LoggerFactory.getLogger(Cat62TransformerTestApp.class);

  @Test
  public void fspecTrans() {
    byte[] data = genRealCat62Uap();
//    byte[] cat1 = genCat1Pack();

    String hexString = "";
    for (byte oc: data) {
      Integer value = Byte.toUnsignedInt(oc);
      String valueString =Integer.toHexString(value);
      if (valueString.length()<2) {
        valueString = "0"+valueString;
      }
      hexString+=valueString;
    }
    String raw = hexString.toString();
    Cat062Mapper decoder = new Cat062Mapper(data);
    decoder.readValue();
  }
  private byte[] genCat1Pack() {
    return new byte[] {
        (byte)0x00,
        (byte)0x00,
        (byte)0x01,
        (byte)0x00,
        (byte)0x6B,
        (byte)0xFF,
        (byte)0xC4,
        (byte)0x08,
        (byte)0x22,
        (byte)0xA0,
        (byte)0x07,
        (byte)0xF3,
        (byte)0x23,
        (byte)0xE4,
        (byte)0xEB,
        (byte)0xCF,
        (byte)0xF7,
        (byte)0x75,
        (byte)0x0F,
        (byte)0xC8,
        (byte)0x06,
        (byte)0xB2,
        (byte)0xBA,
        (byte)0xBC,
        (byte)0x08,
        (byte)0xA1,
        (byte)0x04,
        (byte)0x00,
        (byte)0xFB,
        (byte)0x7A,
        (byte)0x40,
        (byte)0xFF,
        (byte)0xC4,
        (byte)0x08,
        (byte)0x22,
        (byte)0xA0,
        (byte)0x04,
        (byte)0xD0,
        (byte)0x26,
        (byte)0xB1,
        (byte)0xEF,
        (byte)0x61,
        (byte)0xF8,
        (byte)0x58,
        (byte)0x11,
        (byte)0xC5,
        (byte)0x08,
        (byte)0xCB,
        (byte)0x4D,
        (byte)0xEA,
        (byte)0x03,
        (byte)0x4E,
        (byte)0x03,
        (byte)0xD8,
        (byte)0xFB,
        (byte)0x81,
        (byte)0x40,
        (byte)0xFF,
        (byte)0xC4,
        (byte)0x08,
        (byte)0x22,
        (byte)0xA0,
        (byte)0x01,
        (byte)0xEE,
        (byte)0x3E,
        (byte)0x89,
        (byte)0xED,
        (byte)0xBD,
        (byte)0xF2,
        (byte)0x74,
        (byte)0x1C,
        (byte)0x2E,
        (byte)0x04,
        (byte)0x90,
        (byte)0xA6,
        (byte)0xD1,
        (byte)0x06,
        (byte)0xC4,
        (byte)0x02,
        (byte)0x74,
        (byte)0xFB,
        (byte)0x7E,
        (byte)0x40,
        (byte)0xFF,
        (byte)0xC4,
        (byte)0x08,
        (byte)0x22,
        (byte)0xA0,
        (byte)0x07,
        (byte)0x1D,
        (byte)0x32,
        (byte)0x49,
        (byte)0xEA,
        (byte)0xE5,
        (byte)0xF3,
        (byte)0x8C,
        (byte)0x15,
        (byte)0xD7,
        (byte)0x08,
        (byte)0x50,
        (byte)0x2D,
        (byte)0xF6,
        (byte)0x0F,
        (byte)0x29,
        (byte)0x03,
        (byte)0xF8,
        (byte)0xFB,
        (byte)0x78,
        (byte)0x40,
        (byte)0x02,
        (byte)0x00,
        (byte)0x0B,
        (byte)0xF0,
        (byte)0x08,
        (byte)0x22,
        (byte)0x02,
        (byte)0xF0,
        (byte)0x30,
        (byte)0xFB,
        (byte)0x83,
        (byte)0x4F,
        (byte)0x42
    };
  }
  public byte[] genSimulatedFullCat62Uap() {

    return new byte[] {
        (byte)0b00111110, //0
        (byte)0b00000000, //1
        (byte)0b01011010, //2
        (byte)0b10111111, //3
        (byte)0b11111111, //4
        (byte)0b11111111, //5
        (byte)0b11111111, //6
        (byte)0b00000000, //7
        (byte)0b10010000, //8
        (byte)0b10010000, //9
        (byte)0b00000001, //10
        (byte)0b00101110, //11
        (byte)0b10011000, //12
        (byte)0b01011001, //13
        (byte)0b00000000, //14
        (byte)0b01001111, //15
        (byte)0b01011000, //16
        (byte)0b01110000, //17
        (byte)0b00000001, //18
        (byte)0b00100111, //19
        (byte)0b11101111, //20
        (byte)0b11101110, //21
        (byte)0b00000000, //22
        (byte)0b01000110, //23
        (byte)0b11011111, //24
        (byte)0b11110110, //25
        (byte)0b11101100, //26
        (byte)0b01011000, //27
        (byte)0b00000001, //28
        (byte)0b11010011, //29
        (byte)0b00000011, //30
        (byte)0b01101111, //31
        (byte)0b01100100, //32
        (byte)0b01100100, //33
        (byte)0b00000111, //34
        (byte)0b01010011, //35
        (byte)0b00000000, //36
        (byte)0b11000011, //37
        (byte)0b00001100, //38
        (byte)0b00110000, //39
        (byte)0b11000011, //40
        (byte)0b00001100, //41
        (byte)0b00110000, //42
        (byte)0b11111111, //43
        (byte)0b11111111, //44
        (byte)0b11111111, //45
        (byte)0b11111110, //46
        (byte)0b00000000, //47
        (byte)0b00000000, //48
        (byte)0b00000001, //49
        (byte)0b11000011, //50
        (byte)0b00001100, //51
        (byte)0b00110000, //52
        (byte)0b11000011, //53
        (byte)0b00001100, //54
        (byte)0b00110000, //55
        (byte)0b00000000, //56
        (byte)0b01100100, //57
        (byte)0b00100111, //58
        (byte)0b00010000, //59
        (byte)0b00000000, //60
        (byte)0b01100100, //61
        (byte)0b01000000, //62
        (byte)0b01100100, //63
        (byte)0b11100000, //64
        (byte)0b01100100, //65
        (byte)0b00000000, //66
        (byte)0b00000101, //67
        (byte)0b00000001, //68
        (byte)0b00000000, //69
        (byte)0b01100100, //70
        (byte)0b00000000, //71
        (byte)0b00100111, //72
        (byte)0b00010000, //73
        (byte)0b00000000, //74
        (byte)0b00100111, //75
        (byte)0b00010000, //76
        (byte)0b00011110, //77
        (byte)0b00000000, //78
        (byte)0b00100111, //79
        (byte)0b00010000, //80
        (byte)0b00000000, //81
        (byte)0b01100100, //82
        (byte)0b00000010, //83
        (byte)0b00000000, //84
        (byte)0b01100100, //85
        (byte)0b00000000, //86
        (byte)0b00100111, //87
        (byte)0b00010000, //88
        (byte)0b00000000, //89
        (byte)0b00100111, //90
        (byte)0b00010000, //91
        (byte)0b00011110, //92
        (byte)0b00000000, //93
        (byte)0b00100111, //94
        (byte)0b00010000, //95
        (byte)0b00000000, //96
        (byte)0b01100100, //97
        (byte)0b00000011, //98
        (byte)0b00000000, //99
        (byte)0b01100100, //100
        (byte)0b00000000, //101
        (byte)0b00100111, //102
        (byte)0b00010000, //103
        (byte)0b00000000, //104
        (byte)0b00100111, //105
        (byte)0b00010000, //106
        (byte)0b00011110, //107
        (byte)0b00000000, //108
        (byte)0b00100111, //109
        (byte)0b00010000, //110
        (byte)0b00000000, //111
        (byte)0b01100100, //112
        (byte)0b00000100, //113
        (byte)0b00000000, //114
        (byte)0b01100100, //115
        (byte)0b00000000, //116
        (byte)0b00100111, //117
        (byte)0b00010000, //118
        (byte)0b00000000, //119
        (byte)0b00100111, //120
        (byte)0b00010000, //121
        (byte)0b00011110, //122
        (byte)0b00000000, //123
        (byte)0b00100111, //124
        (byte)0b00010000, //125
        (byte)0b00000000, //126
        (byte)0b01100100, //127
        (byte)0b00000101, //128
        (byte)0b00000000, //129
        (byte)0b01100100, //130
        (byte)0b00000000, //131
        (byte)0b00100111, //132
        (byte)0b00010000, //133
        (byte)0b00000000, //134
        (byte)0b00100111, //135
        (byte)0b00010000, //136
        (byte)0b00011110, //137
        (byte)0b00000000, //138
        (byte)0b00100111, //139
        (byte)0b00010000, //140
        (byte)0b00000000, //141
        (byte)0b01100100, //142
        (byte)0b00100100, //143
        (byte)0b11111111, //144
        (byte)0b10100110, //145
        (byte)0b00000001, //146
        (byte)0b00000000, //147
        (byte)0b00000000, //148
        (byte)0b00000000, //149
        (byte)0b00000000, //150
        (byte)0b00000000, //151
        (byte)0b00000000, //152
        (byte)0b00000001, //153
        (byte)0b00100111, //154
        (byte)0b00010000, //155
        (byte)0b00100111, //156
        (byte)0b00010000, //157
        (byte)0b00100111, //158
        (byte)0b00010000, //159
        (byte)0b11000000, //160
        (byte)0b00000010, //161
        (byte)0b00100111, //162
        (byte)0b00010000, //163
        (byte)0b00100111, //164
        (byte)0b00010000, //165
        (byte)0b00000001, //166
        (byte)0b11110000, //167
        (byte)0b00000000, //168
        (byte)0b00000001, //169
        (byte)0b00000000, //170
        (byte)0b00000001, //171
        (byte)0b00000000, //172
        (byte)0b00000001, //173
        (byte)0b00000001, //174
        (byte)0b00000001, //175
        (byte)0b00000000, //176
        (byte)0b00100111, //177
        (byte)0b00010000, //178
        (byte)0b00000000, //179
        (byte)0b00100111, //180
        (byte)0b00010000, //181
        (byte)0b00100111, //182
        (byte)0b00010000, //183
        (byte)0b00000001, //184
        (byte)0b00000011, //185
        (byte)0b00000000, //186
        (byte)0b00000000, //187
        (byte)0b00000000, //188
        (byte)0b00000000, //189
        (byte)0b00000000, //190
        (byte)0b00000000, //191
        (byte)0b00000001, //192
        (byte)0b00010001, //193
        (byte)0b00000000, //194
        (byte)0b00000000, //195
        (byte)0b00000000, //196
        (byte)0b00000000, //197
        (byte)0b00000000, //198
        (byte)0b00000000, //199
        (byte)0b00000010, //200
        (byte)0b00100010, //201
        (byte)0b00000000, //202
        (byte)0b00000000, //203
        (byte)0b00000000, //204
        (byte)0b00000000, //205
        (byte)0b00000000, //206
        (byte)0b00000000, //207
        (byte)0b00000011, //208
        (byte)0b00110011, //209
        (byte)0b00100111, //210
        (byte)0b00010000, //211
        (byte)0b00100111, //212
        (byte)0b00010000, //213
        (byte)0b00000000, //214
        (byte)0b00000001, //215
        (byte)0b00000001, //216
        (byte)0b00011101, //217
        (byte)0b00010101, //218
        (byte)0b10010001, //219
        (byte)0b10100011, //220
        (byte)0b00000001, //221
        (byte)0b00001001, //222
        (byte)0b00000000, //223
        (byte)0b11111111, //224
        (byte)0b11100000, //225
        (byte)0b00000001, //226
        (byte)0b00000001, //227
        (byte)0b00000001, //228
        (byte)0b00000001, //229
        (byte)0b00000000, //230
        (byte)0b00000001, //231
        (byte)0b00000001, //232
        (byte)0b00000001, //233
        (byte)0b00000001, //234
        (byte)0b00000001, //235
        (byte)0b00000001, //236
        (byte)0b00010100, //237
        (byte)0b11111111, //238
        (byte)0b11111111, //239
        (byte)0b11111111, //240
        (byte)0b11111111, //241
        (byte)0b11100000, //242
        (byte)0b00000001, //243
        (byte)0b00000001, //244
        (byte)0b00000001, //245
        (byte)0b00000001, //246
        (byte)0b00000001, //247
        (byte)0b00000001, //248
        (byte)0b00000001, //249
        (byte)0b00000001, //250
        (byte)0b00000001, //251
        (byte)0b00000001, //252
        (byte)0b00000001, //253
        (byte)0b00000001, //254
        (byte)0b00000001, //255
        (byte)0b00000001, //256
        (byte)0b00000001, //257
        (byte)0b00000001, //258
        (byte)0b00000001, //259
        (byte)0b00000001, //260
        (byte)0b00000001, //261
        (byte)0b00000001, //262
        (byte)0b00000001, //263
        (byte)0b00000001, //264
        (byte)0b00000001, //265
        (byte)0b00000001, //266
        (byte)0b00000001, //267
        (byte)0b00000001, //268
        (byte)0b00000001, //269
        (byte)0b00000001, //270
        (byte)0b00000001, //271
        (byte)0b00000001, //272
        (byte)0b00000001, //273
        (byte)0b00100111, //274
        (byte)0b00010000, //275
        (byte)0b00100111, //276
        (byte)0b00010000, //277
        (byte)0b10100111, //278
        (byte)0b00010000, //279
        (byte)0b00000000, //280
        (byte)0b01100100, //281
        (byte)0b11111111, //282
        (byte)0b11111111, //283
        (byte)0b11110000, //284
        (byte)0b00000001, //285
        (byte)0b00000001, //286
        (byte)0b01011010, //287
        (byte)0b01011010, //288
        (byte)0b01011010, //289
        (byte)0b01011010, //290
        (byte)0b01011010, //291
        (byte)0b01011010, //292
        (byte)0b01011010, //293
        (byte)0b10000000, //294
        (byte)0b00000000, //295
        (byte)0b00000000, //296
        (byte)0b00000001, //297
        (byte)0b10000100, //298
        (byte)0b01011010, //299
        (byte)0b01011010, //300
        (byte)0b01011010, //301
        (byte)0b01011010, //302
        (byte)0b01001101, //303
        (byte)0b01011010, //304
        (byte)0b01011010, //305
        (byte)0b01011010, //306
        (byte)0b01011010, //307
        (byte)0b01011010, //308
        (byte)0b01011010, //309
        (byte)0b01011010, //310
        (byte)0b01011010, //311
        (byte)0b00000001, //312
        (byte)0b00000001, //313
        (byte)0b01011010, //314
        (byte)0b00000011, //315
        (byte)0b11101000, //316
        (byte)0b00000001, //317
        (byte)0b00000001, //318
        (byte)0b00000011, //319
        (byte)0b00000000, //320
        (byte)0b00000110, //321
        (byte)0b00000110, //322
        (byte)0b00000110, //323
        (byte)0b00001000, //324
        (byte)0b00000110, //325
        (byte)0b00000110, //326
        (byte)0b00000110, //327
        (byte)0b00010000, //328
        (byte)0b00000110, //329
        (byte)0b00000110, //330
        (byte)0b00000110, //331
        (byte)0b01011010, //332
        (byte)0b01011010, //333
        (byte)0b01011010, //334
        (byte)0b01011010, //335
        (byte)0b01011010, //336
        (byte)0b01011010, //337
        (byte)0b01000000, //338
        (byte)0b01011010, //339
        (byte)0b01011010, //340
        (byte)0b01011010, //341
        (byte)0b01011010, //342
        (byte)0b01011010, //343
        (byte)0b01011010, //344
        (byte)0b01011010, //345
        (byte)0b01011010, //346
        (byte)0b01011010, //347
        (byte)0b01011010, //348
        (byte)0b01011010, //349
        (byte)0b01011010, //350
        (byte)0b01011010, //351
        (byte)0b01011010, //352
        (byte)0b00010000, //353
        (byte)0b00000001, //354
        (byte)0b01011010, //355
        (byte)0b01011010, //356
        (byte)0b01011010, //357
        (byte)0b01011010, //358
        (byte)0b01011010, //359
        (byte)0b01011010, //360
        (byte)0b01011010, //361
        (byte)0b00000011, //362
        (byte)0b00000011, //363
        (byte)0b00000010, //364
        (byte)0b00000001, //365
        (byte)0b11111110, //366
        (byte)0b11111111, //367
        (byte)0b00000000, //368
        (byte)0b00000001, //369
        (byte)0b00000001, //370
        (byte)0b00000001, //371
        (byte)0b00000000, //372
        (byte)0b00000011, //373
        (byte)0b11101000, //374
        (byte)0b00000000, //375
        (byte)0b00000011, //376
        (byte)0b11101000, //377
        (byte)0b01000011, //378
        (byte)0b11101000, //379
        (byte)0b00000000, //380
        (byte)0b00000001, //381
        (byte)0b00000001, //382
        (byte)0b00011111, //383
        (byte)0b00000000, //384
        (byte)0b00000001, //385
        (byte)0b00000001, //386
        (byte)0b00000000, //387
        (byte)0b00000011, //388
        (byte)0b00000010, //389
        (byte)0b00000000, //390
        (byte)0b00000100, //391
        (byte)0b11111111, //392
        (byte)0b10000000, //393
        (byte)0b00000000, //394
        (byte)0b00000001, //395
        (byte)0b00000000, //396
        (byte)0b00000001, //397
        (byte)0b00000000, //398
        (byte)0b00000001, //399
        (byte)0b00000000, //400
        (byte)0b00000001, //401
        (byte)0b00000000, //402
        (byte)0b00000001, //403
        (byte)0b00000001, //404
        (byte)0b00000001, //405
        (byte)0b00000001, //406
        (byte)0b00000001, //407
        (byte)0b00000001, //408
        (byte)0b00000001, //409
        (byte)0b00000001, //410
        (byte)0b11111100, //411
        (byte)0b00000001, //412
        (byte)0b00000001, //413
        (byte)0b00000011, //414
        (byte)0b11101000, //415
        (byte)0b00000011, //416
        (byte)0b11101000, //417
        (byte)0b00000011, //418
        (byte)0b11101000, //419
        (byte)0b00000000, //420
        (byte)0b01100100, //421
        (byte)0b00000000, //422
        (byte)0b00000001, //423
        (byte)0b01111100  //424

    };
  }

  public static byte[] genRealCat62Uap() {
    return new byte[] {
      (byte)0b00111110,
      (byte)0b00000000,
      (byte)0b01011100,
      (byte)0b10111111,
      (byte)0b01001101,
      (byte)0b00101110,
      (byte)0b10010000,
      (byte)0b10010000,
      (byte)0b00000001,
      (byte)0b01100110,
      (byte)0b00111101,
      (byte)0b11110000,
      (byte)0b00000000,
      (byte)0b01000110,
      (byte)0b00001011,
      (byte)0b00111110,
      (byte)0b00000001,
      (byte)0b00100000,
      (byte)0b10001110,
      (byte)0b01111110,
      (byte)0b11111000,
      (byte)0b01000000,
      (byte)0b11011111,
      (byte)0b11101011,
      (byte)0b11110010,
      (byte)0b10011001,
      (byte)0b00000011,
      (byte)0b01111010,
      (byte)0b00000000,
      (byte)0b10011101,
      (byte)0b00000100,
      (byte)0b01000111,
      (byte)0b00000000,
      (byte)0b00000011,
      (byte)0b00000001,
      (byte)0b00010001,
      (byte)0b00000001,
      (byte)0b00000000,
      (byte)0b00000011,
      (byte)0b01111111,
      (byte)0b00000011,
      (byte)0b01111111,
      (byte)0b11111111,
      (byte)0b01101111,
      (byte)0b11011111,
      (byte)0b10101000,
      (byte)0b00000000,
      (byte)0b00000000,
      (byte)0b01000011,
      (byte)0b01000101,
      (byte)0b01010011,
      (byte)0b00110101,
      (byte)0b00111001,
      (byte)0b00110111,
      (byte)0b00110100,
      (byte)0b01101000,
      (byte)0b01000010,
      (byte)0b00110111,
      (byte)0b00110011,
      (byte)0b00110111,
      (byte)0b01001101,
      (byte)0b01011010,
      (byte)0b01010000,
      (byte)0b01001101,
      (byte)0b01010011,
      (byte)0b01011010,
      (byte)0b01010000,
      (byte)0b01010000,
      (byte)0b01010000,
      (byte)0b00000000,
      (byte)0b00000000,
      (byte)0b00000101,
      (byte)0b00001000,
      (byte)0b00001010,
      (byte)0b00000000,
      (byte)0b10000000,
      (byte)0b00010000,
      (byte)0b00001010,
      (byte)0b00000000,
      (byte)0b10000000,
      (byte)0b00111000,
      (byte)0b00000000,
      (byte)0b00111100,
      (byte)0b10000000,
      (byte)0b01000000,
      (byte)0b00000000,
      (byte)0b00000000,
      (byte)0b10000000,
      (byte)0b01010000,
      (byte)0b00000000,
      (byte)0b00000000,
      (byte)0b10000000
    };
  }


}
