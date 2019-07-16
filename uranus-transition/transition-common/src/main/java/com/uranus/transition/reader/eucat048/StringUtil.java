package com.uranus.transition.reader.eucat048;

/**
 * StringUtil
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/25
 */
public class StringUtil {

  public static String asciiValueOf(byte... byteArray) {
    StringBuilder asciiBuilder = new StringBuilder();
    for (byte byteItem : byteArray) {
      asciiBuilder.append((char) (int) byteItem);
    }
    return asciiBuilder.toString();
  }


  public static String valueOf(int... intArray) {
    StringBuilder intBuilder = new StringBuilder();
    for (int intItem: intArray) {
      intBuilder.append(intItem);
    }
    return intBuilder.toString();
  }

  //解析FSPEC有1的位置
  public static String fspechasValueCount(String fcode){
    String value = "";
    for(int i = 0 ; i < fcode.length(); i ++){
      if(fcode.charAt(i) == '1'){
        value += String.valueOf(i);
      }
    }
    return value;
  }


}
