package com.uranus.transition.common.fdexm.dto;


import com.uranus.transition.common.fdexm.FdexmFormatter;
import com.uranus.transition.common.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * FdexmParser
 *
 * @author tellxp@github.com
 * @date 2018/11/23
 */
@Slf4j
public class FdexmParser {

  public static FdexmDTO parse(String fdexmText) {

    String jsonText = FdexmFormatter.fdexm2Json(fdexmText);

    FdexmDTO fdexmDTO = null;
    try {
      fdexmDTO = JacksonUtil.jsonToPojo(jsonText, FdexmDTO.class);
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (FdexmValidator.isValidAddsMessageDom(fdexmDTO)) {
        fdexmDTO.setText(jsonText);
        return fdexmDTO;
      }


    return null;
  }


}
