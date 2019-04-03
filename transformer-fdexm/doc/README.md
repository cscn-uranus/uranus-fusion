# uranus transformer
## 目的
将外部数据转换内部标准格式

## 结构

```
queue 1 --->
           |
queue 2 --->
           |
queue N ------> uranus-transformer ---> rabbitmq ---> transformer.queue1
                                                    |
                                                 ---> transformer.queue2
                                                    |
                                                 ---> transformer.queueN
```

## 实现
### FDEXM的转换

#### 原始的FDEXM报文
- 下面是一个原始的IFPL报文, 详情参见规范[MH/T-4029.3](./docs/民用航空空中交通管制自动化系统+第3部分：飞行数据交换.pdf)

``` fdexm
ZCZC -TITLE IFPL
-FILTIM 093903
-SOURCE CDATC_AIRNET_ZUUU
-IFPLID 907723584
-ADEP ZSNB
-ADES ZUCK
-ARCID CES2395
-EOBD 20181123
-EOBT 0710
-SOURCEMSGID 139942324
-ETA 20181123100900
-ROUTE P448/H0938 P127/H0940 K0864S0840 SAKPU
-FPCTST ACT
-ALTRNT1 ZUUU
-SSRCODE A7027
-FLTRUL I
-FLTTYP S
-RMK TCAS II CAT II APPROVED
-ADD 20181123 -ATD 0748
-TTLEET 0240
-ARCTYP A320
-WKTRC M
-REG B6011
-CEQPT SWDE2E3FGHIR
-SEQPT LB1
-PBN A1B2C1D1L1O2S2
-ARCADDR 79A060
-SEL CFRS
-PER C1
-RFL S0980
-CFL S0840
-XFL
-STAR SAK20A
-SPEED K0864
-SECTOR AC13
-TXT T084
-DOF 181123
-TEAM18 PBN/A1B2C1D1L1O2S2 DOF/181123 REG/B6011 EET/ZGZU0115 ZPKM0200 SEL/CFRS CODE/79A060 PER/C1 RMK/TCAS II CAT II APPROVED
-TASK W/Z
-ISCOUPLE Y
-BEGIN RTEPTS
-PT -PTID ZSNB -FL S0841 -ETO 20181123074800 -ISPASS Y
-PT -PTID P448 -FL S0841 -ETO 20181123093901 -ISPASS Y
-PT -PTID P127 -FL S0980 -ETO 20181123094053 -ISPASS N
-PT -PTID SAKPU -FL S0647 -ETO 20181123094824 -ISPASS N
-PT -PTID ZUCK -FL S0042 -ETO 20181123102800 -ISPASS N
-END RTEPTS NNNN
```

#### 转换方式
通过正则表达式将原始报文转换为json进行处理, 使用静态类FdexmTextTransformer.fdexmToJson(String input)得到json文本, 再使用json的mapper转换为pojo

```
FDEXM ---> json ---> addmDom ---> addmDTO ---> ifplDom ---> ifplDTO
                                          ---> brwyDom ---> brwyDTO
                                          ---> ......
```

#### 最终转换结果
- 一个IFPL原始报文转换为json后的示例
``` json
{
  "TITLE": "IFPL",
  "FILTIM": "093903",
  "SOURCE": "CDATC_AIRNET_ZUUU",
  "IFPLID": "907723584",
  "ADEP": "ZSNB",
  "ADES": "ZUCK",
  "ARCID": "CES2395",
  "EOBD": "20181123",
  "EOBT": "0710",
  "SOURCEMSGID": "139942324",
  "ETA": "20181123100900",
  "ROUTE": "P448/H0938 P127/H0940 K0864S0840 SAKPU",
  "FPCTST": "ACT",
  "ALTRNT1": "ZUUU",
  "SSRCODE": "A7027",
  "FLTRUL": "I",
  "FLTTYP": "S",
  "RMK": "TCAS II CAT II APPROVED",
  "ADD": "20181123",
  "ATD": "0748",
  "TTLEET": "0240",
  "ARCTYP": "A320",
  "WKTRC": "M",
  "REG": "B6011",
  "CEQPT": "SWDE2E3FGHIR",
  "SEQPT": "LB1",
  "PBN": "A1B2C1D1L1O2S2",
  "ARCADDR": "79A060",
  "SEL": "CFRS",
  "PER": "C1",
  "RFL": "S0980",
  "CFL": "S0840",
  "XFL": "",
  "STAR": "SAK20A",
  "SPEED": "K0864",
  "SECTOR": "AC13",
  "TXT": "T084",
  "DOF": "181123",
  "TEAM18": "PBN/A1B2C1D1L1O2S2 DOF/181123 REG/B6011 EET/ZGZU0115 ZPKM0200 SEL/CFRS CODE/79A060 PER/C1 RMK/TCAS II CAT II APPROVED",
  "TASK": "W/Z",
  "ISCOUPLE": "Y",
  "RTEPTS": [
    {
      "PTID": "ZSNB",
      "FL": "S0841",
      "ETO": "20181123074800",
      "ISPASS": "Y"
    },
    {
      "PTID": "P448",
      "FL": "S0841",
      "ETO": "20181123093901",
      "ISPASS": "Y"
    },
    {
      "PTID": "P127",
      "FL": "S0980",
      "ETO": "20181123094053",
      "ISPASS": "N"
    },
    {
      "PTID": "SAKPU",
      "FL": "S0647",
      "ETO": "20181123094824",
      "ISPASS": "N"
    },
    {
      "PTID": "ZUCK",
      "FL": "S0042",
      "ETO": "20181123102800",
      "ISPASS": "N"
    }
  ]
}

```

### 程序结构
```
com.uranus.transformer.fdexm
  |
  - dom
  - dto
  - mapper
  - stream
  - util
```
#### dom
对应的不同FDEXM报文的json dom映射, 包括:
- ifpl
- icnl
- brwy
- bssr
- ......

#### dto
- ifpl
  - ifplDTO和其他pojo
- AddmDTO

#### mapper
- AddmMapper
  - 将原始报文转换为中间的AddmDTO
  - 使用AddmDTO的原因是需要根据Title来判断消息类型, 映射不同的Dom
- IfplMapper
  - 将AddmDTO转为IfplDTO

#### stream
与rabbitmq信道的接口和处理, 相当于消息路由, 根据AddmDTO的Title来判断是什么类型的消息, 然后使用不同的转换器变为不同的pojo, 最后再发送到不同的rabbitmq的队列中
``` java
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
```

## 下一步工作
- [x] FDEXM转换为json的静态方法
- [x] Ifpl的转换和发送
- [ ] 其他dom和DTO的构建和映射, 包括runway, qnh, ssr, sector......
- [ ] 重构, 优化pojo的数据结构
- [ ] 考虑transformer处理的时候是否应该存库
- [ ] 考虑分离proxy的消息队列和transformer的消息队列