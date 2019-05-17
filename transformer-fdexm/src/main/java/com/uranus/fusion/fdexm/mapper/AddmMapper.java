package com.uranus.fusion.fdexm.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.uranus.fusion.common.fdexm.FdexmTextTransformer;
import com.uranus.fusion.common.fdexm.dom.AddmDom;
import com.uranus.fusion.common.util.DateTypeEnum;
import com.uranus.fusion.common.util.DateUtil;
import com.uranus.fusion.tfr.cat062.dto.AddmDTO;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * AddmMapper
 *
 * @author tellxp@github.com
 * @date 2018/11/23
 */
@Slf4j
public class AddmMapper {

  public static AddmDTO toAddmDTO(String fdexmText) {

    String addmText = FdexmTextTransformer.fdexm2Json(fdexmText);

    ObjectMapper mapper = new ObjectMapper();

    try {
      AddmDom dom = mapper.readValue(addmText, AddmDom.class);

      if (AddmValidator.isValidAddsMessageDom(dom)) {
        AddmDTO addmDTO = new AddmDTO();

        addmDTO.setTitle(dom.getTitle());
        addmDTO.setSendingTime(DateUtil.String2Time(dom.getFiltim(), DateTypeEnum.TimeToSecond));
        addmDTO.setSource(dom.getSource());
        addmDTO.setSourceMessageId(dom.getSouremsgid());
        addmDTO.setText(addmText);
        addmDTO.setReceivedTime(DateUtil.now());
        addmDTO.setReceivedTimeNano(DateUtil.nano());
        return addmDTO;
      }

    } catch (IOException e) {
      e.printStackTrace();
      log.error("解析Json出错!");
      log.error("解析的Json是：" + addmText);
    }
    return null;
  }


}
