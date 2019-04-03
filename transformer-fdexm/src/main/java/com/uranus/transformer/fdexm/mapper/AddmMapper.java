package com.uranus.transformer.fdexm.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.uranus.transformer.fdexm.dom.AddmDom;
import com.uranus.transformer.fdexm.dom.AddmIfplDom;
import com.uranus.transformer.fdexm.dom.AddmRoutePointDom;
import com.uranus.transformer.fdexm.dto.AddmDTO;
import com.uranus.transformer.fdexm.dto.ifpl.IfplDTO;
import com.uranus.transformer.fdexm.dto.ifpl.RoutePointDTO;
import com.uranus.transformer.fdexm.util.AddmValidator;
import com.uranus.transformer.fdexm.util.DateTypeEnum;
import com.uranus.transformer.fdexm.util.DateUtil;
import com.uranus.transformer.fdexm.util.FdexmTextTransformer;
import java.io.IOException;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AddmMapper
 *
 * @author tellxp@github.com
 * @date 2018/11/23
 */
public class AddmMapper {
  private static final Logger logger = LoggerFactory.getLogger(AddmMapper.class);

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
      logger.error("解析Json出错!");
      logger.error("解析的Json是：" + addmText);
    }
    return null;
  }


}
