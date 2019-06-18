package com.uranus.transition.common.fdexm.dto.ifpl;

import com.uranus.transition.common.fdexm.dto.FdexmDTO;
import com.uranus.transition.common.fdexm.dto.ifpl.IfplDTO;
import com.uranus.transition.common.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;


/**
 * IfplParser
 *
 * @author tellxp@github.com
 * @date 2018/11/23
 */
@Slf4j
public class IfplParser {
  public static IfplDTO parse(FdexmDTO fdexmDTO) {
    try {
      return JacksonUtil.jsonToPojo(fdexmDTO.getText(), IfplDTO.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
