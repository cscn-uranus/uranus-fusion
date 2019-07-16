package com.uranus.transition.reader.eucat048;



import java.util.HashMap;
import java.util.Map;

/**
 * ByteUtil
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/9
 */
final class ByteUtil {

  public static final Byte BYTE_ZERO = 0b00000000;

  public static String toString(Byte singleByte) {
    return String.valueOf((singleByte >> 7) & 0x1)
        + ((singleByte >> 6) & 0x1)
        + ((singleByte >> 5) & 0x1)
        + ((singleByte >> 4) & 0x1)
        + ((singleByte >> 3) & 0x1)
        + ((singleByte >> 2) & 0x1)
        + ((singleByte >> 1) & 0x1)
        + ((singleByte) & 0x1);
  }

  public static Byte valueOf(String byteString) {
    return (byte) Integer.parseInt(byteString, 2);
  }

  public static String getBitByIndex(Byte singleByte, int index) {
    return toString(singleByte).substring(index, index + 1);
  }

  public static String getB0(Byte singleByte) {
    return toString(singleByte).substring(0, 1);
  }

  public static String getB1(Byte singleByte) {
    return toString(singleByte).substring(1, 2);
  }

  public static String getB2(Byte singleByte) {
    return toString(singleByte).substring(2, 3);
  }

  public static String getB3(Byte singleByte) {
    return toString(singleByte).substring(3, 4);
  }

  public static String getB4(Byte singleByte) {
    return toString(singleByte).substring(4, 5);
  }

  public static String getB5(Byte singleByte) {
    return toString(singleByte).substring(5, 6);
  }

  public static String getB6(Byte singleByte) {
    return toString(singleByte).substring(6, 7);
  }

  public static String getB7(Byte singleByte) {
    return toString(singleByte).substring(7, 8);
  }

  public static String f(String string) {
    //TODO Auto-generated method stub
    String s="";
    for (int i = 0; i < string.length(); i++) {
      s+=g(string.charAt(i));
    }
    return s;
  }

  public static cat34DTO analysisFrom34FSPEC(String fspeccode,String cat34Behindfspec,cat34DTO cat34) {
    Map<Integer, Integer> fspecMap = new HashMap<>();
    int c = 0;
    if (fspeccode.length() > 7) {
      if (fspeccode.charAt(0) == '1') {
        fspecMap.put(1, 2);
        String dsi = f(cat34Behindfspec.substring(c, c + 2)) + f(cat34Behindfspec.substring(c + 2, c + 4));
        c = c + 4;
        System.out.println("dsi:" + dsi);
        cat34.setDataSourceIdentifier(dsi);
      } else {
        fspecMap.put(1, 0);
      }
      if (fspeccode.charAt(1) == '1') {
        fspecMap.put(2, 1);
        String mt = f(cat34Behindfspec.substring(c, c + 2));
        c += 2;
        cat34.setMessageType(mt);
        System.out.println("md:" + mt);
      } else {
        fspecMap.put(2, 0);
      }
      if (fspeccode.charAt(2) == '1') {
        fspecMap.put(3, 3);
        String tod = f(cat34Behindfspec.substring(c, c + 2)) + f(cat34Behindfspec.substring(c + 2, c + 4)) + f(cat34Behindfspec.substring(c + 4, c + 6));
        c = c + 6;
        cat34.setTimeOfDay(tod);
        System.out.println("tod:" + tod);
      } else {
        fspecMap.put(3, 0);
      }
      if (fspeccode.charAt(3) == '1') {
        fspecMap.put(4, 1);
        String sn = f(cat34Behindfspec.substring(c, c + 2));
        c += 2;
        cat34.setSectorNumber(sn);
        System.out.println("sn:" + sn);
      } else {
        fspecMap.put(4, 0);
      }
      if (fspeccode.charAt(4) == '1') {
        fspecMap.put(5, 2);
        String arp = f(cat34Behindfspec.substring(c, c + 2)) + f(cat34Behindfspec.substring(c + 2, c + 4));
        c = c + 4;
        System.out.println("arp:" + arp);
        cat34.setAntennaRotationPeriod(arp);
      } else {
        fspecMap.put(5, 0);
      }
      if (fspeccode.charAt(5) == '1') {
        int scsCount = get1plusCount(cat34Behindfspec, fspecMap);
        String scs = "";
        int i = 0;
        for (int t = 0; t < scsCount; t++) {
          scs += f(cat34Behindfspec.substring(c + t * 2, c + t * 2 + 2));
        }

        int length = scs.length();
        for (int a = 0; a < length; a++) {
          if (scs.charAt(a) == '1') {
            i += 1;
            scs += f(cat34Behindfspec.substring(c + i * 2, c + 2 + i * 2));
          }
        }
        fspecMap.put(6, scsCount + i);
        cat34.setSystemConfigurationAndStatus(scs);
        System.out.println("scs:" + scs);
        c = c + scsCount * 2 + i * 2;
      } else {
        fspecMap.put(6, 0);
      }
      if (fspeccode.charAt(6) == '1') {
        int spmCount = get1plusCount(cat34Behindfspec, fspecMap);
        String spm = "";
        for (int t = 0; t < spmCount; t++) {
          spm += f(cat34Behindfspec.substring(c + t * 2, c + t * 2 + 2));
        }
        fspecMap.put(7, spmCount);
        cat34.setSystemProcessingMode(spm);
        System.out.println("spm:" + spm);
        c = c + spmCount * 2;
      } else {
        fspecMap.put(7, 0);
      }
      if (fspeccode.charAt(7) == '1') {
        int mcvcount = Integer.parseInt(f(cat34Behindfspec.substring(c, c + 2)));
        String mcv = "";
        for (int i = 1; i <= 2 * mcvcount; i++) {
          mcv += f(cat34Behindfspec.substring(c + 2 * i, c + 2 * i + 2));
        }
        cat34.setMessageCountValues(mcv + mcvcount);
        fspecMap.put(8, 1 + 2 * mcvcount);
        c += 2 * (1 + 2 * mcvcount);
      } else {
        fspecMap.put(7, 0);
      }
    }
    if(fspeccode.length()>8){

      if(fspeccode.charAt(8) == '1'){
        String gpw = "";
        for(int i = 0 ; i < 4 ; i ++){
          gpw += f(cat34Behindfspec.substring(c+2*i,c+2*i+2));
        }
        cat34.setGenericPolarWindow(gpw);
        fspecMap.put(9,4);
        c += 8;
      }else {fspecMap.put(9,0);}

      if (fspeccode.charAt(9) == '1') {
        fspecMap.put(10, 1);
        String df = f(cat34Behindfspec.substring(c, c + 2));
        c += 2;
        cat34.setDataFilter(df);
        System.out.println("df:" + df);
      } else {
        fspecMap.put(10, 0);}
      if(fspeccode.charAt(10) == '1'){
        String threeDPDS = "";
        for(int i = 0 ; i < 4 ; i ++){
          threeDPDS += f(cat34Behindfspec.substring(c+2*i,c+2*i+2));
        }
        cat34.setThreeDPositionOfDataSource(threeDPDS);
        fspecMap.put(11,4);
        c += 8;
      }else {fspecMap.put(11,0);}

      if (fspeccode.charAt(11) == '1') {
        fspecMap.put(12, 2);
        String ce = f(cat34Behindfspec.substring(c, c + 2)) + f(cat34Behindfspec.substring(c + 2, c + 4));
        c = c + 4;
        System.out.println("ce:" + ce);
        cat34.setCollimationError(ce);
      } else {
        fspecMap.put(12, 0);
      }

      if(fspeccode.charAt(12) == '1'  && fspeccode.length()>6){
        String ref = "";
        int refnumber = get1ppCount(cat34Behindfspec,fspecMap);
        for (int i = 0 ; i < refnumber ; i++){
          ref += f(cat34Behindfspec.substring(c+2*i,c+i*2+2));
        }
        System.out.println("ref:" + ref);
        cat34.setReservedExpansionField(ref);
        c = c + refnumber*2;
        fspecMap.put(13,refnumber);
      }else{fspecMap.put(13,0);}

      if(fspeccode.charAt(13) == '1'  && fspeccode.length()>6){
        String spf = "";
        int spfnumber = get1ppCount(cat34Behindfspec,fspecMap);
        for (int i = 0 ; i < spfnumber ; i++){
          spf += f(cat34Behindfspec.substring(c+2*i,c+i*2+2));
        }
        System.out.println("spf:" + spf);
        cat34.setSpecialPurposeField(spf);
        c = c + spfnumber*2;
        fspecMap.put(14,spfnumber);
      }else{fspecMap.put(14,0);}
    }
    return cat34;
  }

  //通过fspecCode找到值对应为1的字段
  public static cat48DTO analysisFrom48FSPEC(String fspeccode,String cat48Behindfspec,cat48DTO cat48){
    Map<Integer, Integer> fspecMap = new HashMap<>() ;
    int c= 0 ;
    if(fspeccode.length() > 7) {
      if (fspeccode.charAt(0) == '1') {
        fspecMap.put(1, 2);
        String dsi = f(cat48Behindfspec.substring(c, c + 2)) + f(cat48Behindfspec.substring(c + 2, c + 4));
        c = c + 4;
        System.out.println("dsi:" + dsi);
        cat48.setDatasourceIdentifier(dsi);
      } else {
        fspecMap.put(1, 0);
      }
      if (fspeccode.charAt(1) == '1' && fspeccode.length() > 1) {
        fspecMap.put(2, 3);
        String tod = f(cat48Behindfspec.substring(c, c + 2)) + f(cat48Behindfspec.substring(c + 2, c + 4)) + f(cat48Behindfspec.substring(c + 4, c + 6));
        c = c + 6;
        cat48.setTimeOfDay(tod);
        System.out.println("tod:" + tod);
      } else {
        fspecMap.put(2, 0);
      }
      if (fspeccode.charAt(2) == '1' && fspeccode.length() > 2) {
        int trdcount = get1plusCount(cat48Behindfspec, fspecMap);
        String trd = "";
        for (int t = 0; t < trdcount; t++) {
          trd += f(cat48Behindfspec.substring(c + t * 2, c + t * 2 + 2));
        }
        fspecMap.put(3, trdcount);
        cat48.setTargetReportDescriptor(trd);
        System.out.println("trd:" + trd);
        c = c + trdcount * 2;
      } else {
        fspecMap.put(3, 0);
      }

      if (fspeccode.charAt(3) == '1' && fspeccode.length() > 3) {
        fspecMap.put(4, 4);
        String MPinSPC = "";
        for (int i = 0; i < 4; i++) {
          MPinSPC += f(cat48Behindfspec.substring(c + 2 * i, c + 2 * i + 2));
        }
        System.out.println("MPinSPC:" + MPinSPC);
        cat48.setMeasuredPositioninSlantPolarCoordinates(MPinSPC);
        c = c + 8;
      } else {
        fspecMap.put(4, 0);
      }
      //更改位数判断方法，加int参数为第几位，关于如何获得substring开头，可以使用for循环返回数字
      if (fspeccode.charAt(4) == '1' && fspeccode.length() > 4) {
        fspecMap.put(5, 2);
        String mode3A = "";
        for (int i = 0; i < 2; i++) {
          mode3A += f(cat48Behindfspec.substring(c + 2 * i, c + i * 2 + 2));
        }
        System.out.println("mode3A:" + mode3A);
        cat48.setMode3ACodeinOctalRepresentation(mode3A);
        c = c + 4;
      } else {
        fspecMap.put(5, 0);
      }
      if (fspeccode.charAt(5) == '1' && fspeccode.length() > 5) {
        fspecMap.put(6, 2);
        String flbr = "";
        for (int i = 0; i < 2; i++) {
          flbr += f(cat48Behindfspec.substring(c + 2 * i, c + i * 2 + 2));
        }
        System.out.println("flbr:" + flbr);
        cat48.setFlightLevelinBinaryRepresentation(flbr);
        c = c + 4;
      } else {
        fspecMap.put(6, 0);
      }
      if (fspeccode.charAt(6) == '1' && fspeccode.length() > 6) {
        String rpc = "";
        int rpcnumber = get1ppCount(cat48Behindfspec, fspecMap);
        for (int i = 0; i < rpcnumber; i++) {
          rpc += f(cat48Behindfspec.substring(c + 2 * i, c + i * 2 + 2));
        }
        System.out.println("rpc:" + rpc);
        cat48.setRadarPlotCharacteristics(rpc);
        c = c + rpcnumber * 2;
        fspecMap.put(7, rpcnumber);
      } else {
        fspecMap.put(7, 0);
      }
    }
    if(fspeccode.length() > 8) {

      if (fspeccode.charAt(8) == '1') {
        fspecMap.put(8, 3);
        String aircraftAd = "";
        for (int i = 0; i < 3; i++) {
          aircraftAd += f(cat48Behindfspec.substring(c + 2 * i, c + i * 2 + 2));
        }
        System.out.println("address:" + aircraftAd);
        cat48.setAircraftAddress(aircraftAd);
        c += 6;
      } else {
        fspecMap.put(8, 0);
      }

      if (fspeccode.charAt(9) == '1' && fspeccode.length() > 8) {
        fspecMap.put(9, 6);
        String aircraftId = "";
        for (int i = 0; i < 6; i++) {
          aircraftId += f(cat48Behindfspec.substring(c + 2 * i, c + 2 * i + 2));
        }
        c += 12;
        System.out.println("aircraftId:" + aircraftId);
        cat48.setAircraftIdentification(aircraftId);
      } else {
        fspecMap.put(9, 0);
      }

      //Mode S
      int rep = Integer.parseInt(f(cat48Behindfspec.substring(c, c + 2)), 2);
      if (fspeccode.charAt(10) == '1' && fspeccode.length() > 9) {
        String modeS = "";
        if (rep > 0) {
          for (int i = 0; i < rep * 8; i++) {
            modeS += f(cat48Behindfspec.substring(c + 2 * i + 2, c + 2 * i + 4));
          }
        }
        System.out.println("modeS:" + modeS);
        c += 16 * rep + 2;
        fspecMap.put(10, rep * 8 + 1);
        cat48.setModeSMBData(modeS);
      } else {
        fspecMap.put(10, rep);
      }

      if (fspeccode.charAt(11) == '1' && fspeccode.length() > 10) {
        String trackNum = "";
        trackNum = f(cat48Behindfspec.substring(c, c + 2)) + f(cat48Behindfspec.substring(c + 2, c + 4));
        fspecMap.put(11, 2);
        c += 4;
        System.out.println("trackNum:" + trackNum);
        cat48.setTrackNumber(trackNum);
      } else {
        fspecMap.put(11, 0);
      }

      if (fspeccode.charAt(12) == '1' && fspeccode.length() > 11) {
        String cpcc = "";
        cpcc = f(cat48Behindfspec.substring(c, c + 2)) + f(cat48Behindfspec.substring(c + 2, c + 4)) + f(cat48Behindfspec.substring(c + 4, c + 6)) + f(cat48Behindfspec.substring(c + 6, c + 8));
        fspecMap.put(12, 4);
        c += 8;
        System.out.println("cpcc:" + cpcc);
        cat48.setCalculatedPositioninCartesianCoordinates(cpcc);
      } else {
        fspecMap.put(12, 0);
      }

      if (fspeccode.charAt(13) == '1' && fspeccode.length() > 12) {
        String ctvpr = "";
        ctvpr = f(cat48Behindfspec.substring(c, c + 2)) + f(cat48Behindfspec.substring(c + 2, c + 4)) + f(cat48Behindfspec.substring(c + 4, c + 6)) + f(cat48Behindfspec.substring(c + 6, c + 8));
        fspecMap.put(13, 4);
        c += 8;
        System.out.println("ctvpr:" + ctvpr);
        cat48.setCalculatedTrackVelocityinPolarRepresentation(ctvpr);
      } else {
        fspecMap.put(13, 0);
      }

      if (fspeccode.charAt(14) == '1' ) {
        String ts = "";
        int tscount = get1plusCount(cat48Behindfspec, fspecMap);
        for (int i = 0; i < tscount; i++) {
          ts += f(cat48Behindfspec.substring(c + 2 * i, c + 2 * i + 2));
        }
        c += tscount * 2;
        System.out.println("ts:" + ts);
        cat48.setTrackStatus(ts);
        fspecMap.put(14, tscount);
      } else {
        fspecMap.put(14, 0);
      }
    }
      if(fspeccode.length()>16) {

      if (fspeccode.charAt(16) == '1') {
          String tq = "";
          for (int i = 0; i < 4; i++) {
            tq += f(cat48Behindfspec.substring(c + 2 * i, c + 2 * i + 2));
          }
          c += 8;
          fspecMap.put(15, 4);
          System.out.println("tq:" + tq);
          cat48.setTrackQuality(tq);
        } else {
          fspecMap.put(15, 0);
        }

      if (fspeccode.charAt(17) == '1' && fspeccode.length() > 15) {
        String ecc = "";
        int eccCount = get1plusCount(cat48Behindfspec, fspecMap);
        for (int i = 0; i < eccCount; i++) {
          ecc += f(cat48Behindfspec.substring(c + 2 * i, c + 2 * i + 2));
        }
        fspecMap.put(16, eccCount);
        c += eccCount * 2;
        System.out.println("ecc:" + ecc);
        cat48.setErrorConditionsClassfication(ecc);
      } else {
        fspecMap.put(16, 0);
      }

      if (fspeccode.charAt(18) == '1') {
        String mode3Acci = "";
        for (int i = 0; i < 2; i++) {
          mode3Acci += f(cat48Behindfspec.substring(c + 2 * i, c + i * 2 + 2));
        }
        c += 4;
        fspecMap.put(17, 2);
        System.out.println("mode3Acci:" + mode3Acci);
        cat48.setMode3ACodeConfidenceIndicator(mode3Acci);
      } else {
        fspecMap.put(17, 0);
      }
      if (fspeccode.charAt(19) == '1') {
        String modeCcci = "";
        for (int i = 0; i < 4; i++) {
          modeCcci += f(cat48Behindfspec.substring(c + 2 * i, c + i * 2 + 2));
        }
        c += 8;
        fspecMap.put(18, 4);
        System.out.println("modeCcci:" + modeCcci);
        cat48.setModeCCodeConfidenceIndicator(modeCcci);
      } else {
        fspecMap.put(18, 0);
      }

      if (fspeccode.charAt(20) == '1') {
        String hm = "";
        for (int i = 0; i < 2; i++) {
          hm += f(cat48Behindfspec.substring(c + 2 * i, c + i * 2 + 2));
        }
        c += 4;
        System.out.println("hm:" + hm);
        cat48.setHeightMeasuredby3DRadar(hm);
        fspecMap.put(19, 2);
      } else {
        fspecMap.put(19, 0);
      }

      if (fspeccode.charAt(21) == '1') {
        String rds = "";
        int rdsCount = get1plusCount(cat48Behindfspec, fspecMap);
        for (int i = 0; i < rdsCount; i++) {
          rds += f(cat48Behindfspec.substring(c + 2 * i, c + i * 2 + 2));
        }
        c += rdsCount * 2;
        System.out.println(rds);
        cat48.setRadialDopplerSpeed(rds);
        fspecMap.put(20, rdsCount);
      } else {
        fspecMap.put(20, 0);
      }

          if (fspeccode.charAt(22) == '1') {
            String ccfs = "";
            for (int i = 0; i < 2; i++) {
              ccfs += f(cat48Behindfspec.substring(c + 2 * i, c + i * 2 + 2));
            }
            c += 4;
            fspecMap.put(21, 2);
            System.out.println("ccfs:" + ccfs);
            cat48.setCommunicationsCapabilityandFlightStatus(ccfs);
          } else {
            fspecMap.put(21, 0);
          }
        }

      if(fspeccode.length() > 24) {
      if(fspeccode.charAt(24) == '1' ){
        String acasRAR = "";
        for(int i = 0 ; i < 7 ; i ++){
          acasRAR += f(cat48Behindfspec.substring(c + 2*i , c + i*2 +2));
        }
        c += 14;
        fspecMap.put(22,7);
        System.out.println("acasRAR:"+acasRAR);
        cat48.setACASResolutionAdvisoryReport(acasRAR);
      }else {fspecMap.put(22,0);}

      if(fspeccode.charAt(25) == '1' ){
        String mode1COR = "";
        mode1COR += f(cat48Behindfspec.substring(c ,c +2));
        c += 2 ;
        fspecMap.put(23,1);
        System.out.println("mode1COR:"+mode1COR);
        cat48.setMode1CodeinOctalRepresentation(mode1COR);
      }else {fspecMap.put(23,0);}

      if(fspeccode.charAt(26) == '1' ){
        String mode2COR = "";
        for(int i = 0 ; i < 2 ; i++){
          mode2COR += f(cat48Behindfspec.substring(c + 2*i , c + i*2 +2));
        }
        c += 4 ;
        fspecMap.put(24 , 2);
        System.out.println("mode2COR:"+mode2COR);
        cat48.setMode2CodeinOctalRepresentation(mode2COR);
      }else {fspecMap.put(24,0);}
      if(fspeccode.charAt(27) == '1' ){
        String mode1CCI = "";
        mode1CCI += f(cat48Behindfspec.substring(c ,c +2));
        c += 2 ;
        fspecMap.put(25,1);
        System.out.println("mode1CCI:"+mode1CCI);
        cat48.setMode1CondeConfidenceIndicator(mode1CCI);
      }else {fspecMap.put(25,0);}

      if(fspeccode.charAt(28) == '1' ){
        String mode2CCI = "";
        for(int i = 0 ; i < 2 ; i++){
          mode2CCI += f(cat48Behindfspec.substring(c + 2*i , c + i*2 +2));
        }
        c += 4 ;
        System.out.println("mode2CCI:"+mode2CCI);
        cat48.setMode2CondeConfidenceIndicator(mode2CCI);
        fspecMap.put(26 , 2);
      }else {fspecMap.put(26,0);}

      if(fspeccode.charAt(29) == '1'  ){
        String spf = "";
        int spfCount = get1ppCount(cat48Behindfspec,fspecMap);
        for(int i = 0 ; i < spfCount ; i ++){
          spf += f(cat48Behindfspec.substring(c + 2*i , c + i*2 +2));
        }
        c += 2 * spfCount;
        fspecMap.put(27,spfCount);
        System.out.println("spf:"+spf);
        cat48.setSpecialPurposeField(spf);
      }else {fspecMap.put(27,0);}

      if(fspeccode.charAt(30) == '1'  ){
        String ref = "";
        int refCount = get1ppCount(cat48Behindfspec,fspecMap);
        for(int i = 0 ; i < refCount ; i ++){
          ref += f(cat48Behindfspec.substring(c + 2*i , c + i*2 +2));
        }
        c += 2 * refCount;
        System.out.println("ref:"+ref);
        cat48.setReservedExpansionField(ref);
        fspecMap.put(28,refCount);
      }else {fspecMap.put(28,0);}
    }

    return cat48;
  }


  //获取fspec 1+位数
  private static int get1plusCount(String cat48Behindfspec,Map<Integer,Integer> fspecMap){
    int i = 0 ;
    int t = 0;
    for(Map.Entry<Integer,Integer> entry : fspecMap.entrySet()){
      i += entry.getValue();
    }
    String onePwithAll = cat48Behindfspec.substring(i*2,cat48Behindfspec.length());
    String trd = f(onePwithAll.substring(t,t+2));
    Map<String,String> trdMap = new HashMap<>() ;
    int count = 1;
    for(int a= 1 ; a <= trd.length() ; a ++){
      trdMap.put(String.valueOf(count) + String.valueOf(a),String.valueOf(trd.charAt(a-1)));
    }

    while (trd.charAt(trd.length() - 1) == '1'){
      count ++ ;
      //获取下一次循环的trd
      trd = f(onePwithAll.substring(t+2,t+4));
      t = t + 2 ;
      for(int j = 1 ; j <= trd.length() ; j ++){
        trdMap.put(String.valueOf(count) + String.valueOf(j) , String.valueOf(trd.charAt(j-1)) ) ;
      }
    }
    return count;
  }

  //获取fspec 1+1+位数
  private static int get1ppCount(String cat48Behindfspec,Map<Integer,Integer> fspecMap){
    int i = 0 ;
    int r= 0 ;
    for(Map.Entry<Integer,Integer> entry : fspecMap.entrySet()){
        i += entry.getValue();
    }
    String onePPwithAll = cat48Behindfspec.substring(i*2,cat48Behindfspec.length());
    String rpc = f(onePPwithAll.substring(r,r+2));
    Map<String,String> rpcMap = new HashMap<>();
    int count = 1 ;
    for(int c = 0 ;c < rpc.length() ; c++){
      if(rpc.charAt(c) == '1'){
        rpcMap.put(String.valueOf(count)+String.valueOf(c+1),String.valueOf(rpc.charAt(c)));
      }
    }
    String rpcDetail = onePPwithAll.substring(2,rpcMap.size()*2+2);
    count += rpcMap.size();
    while (rpc.charAt(rpc.length()-1) == '1'){
      count++;
      rpc = f(onePPwithAll.substring(r+2,r+4));

      r = r+2;
      for(int j = 1 ; j<=rpc.length() ; j ++){
        rpcMap.put(String.valueOf(count)+String.valueOf(j),String.valueOf(rpc.charAt(j)));
      }
    }
    return count;
  }


  public static String g(char charAt) {
    // TODO Auto-generated method stub
    switch (charAt) {
      case '0':
        return "0000";
      case '1':
        return "0001";
      case '2':
        return "0010";
      case '3':
        return "0011";
      case '4':
        return "0100";
      case '5':
        return "0101";
      case '6':
        return "0110";
      case '7':
        return "0111";
      case '8':
        return "1000";
      case '9':
        return "1001";
      case 'a':
        return "1010";
      case 'b':
        return "1011";
      case 'c':
        return "1100";
      case 'd':
        return "1101";
      case 'e':
        return "1110";
      case 'f':
        return "1111";

    }
    return null;
  }

}
