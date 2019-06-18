package com.uranus.transition.common.fdexm;

import com.uranus.transition.common.fdexm.dto.FdexmDTO;
import com.uranus.transition.common.fdexm.dto.FdexmParser;
import com.uranus.transition.common.fdexm.dto.ifpl.IfplDTO;
import com.uranus.transition.common.fdexm.dto.ifpl.IfplParser;
import com.uranus.transition.common.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author tellxp@github.com
 * @date 2019/6/4 17:02
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FdexmTest {
  @Test
  public void ifplParserTest() {
    String text = FileUtil.readStringFromFile("src/test/resources/sample-data/fdexm/ifpl.txt");
    FdexmDTO fdexmDTO = FdexmParser.parse(text);
    IfplDTO ifplDTO = IfplParser.parse(fdexmDTO);
    Assert.assertEquals("IFPL",ifplDTO.getTitle());
  }
}
