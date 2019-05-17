package com.uranus.fusion.common.util;

import com.uranus.fusion.common.fdexm.FdexmTextTransformer;
import com.uranus.fusion.transformer.FdexmTransformerAppTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * FdexmTextTransformerTest
 *
 * @author tellxp@github.com
 * @date 2018/11/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FdexmTransformerAppTest.class)
@Slf4j
public class FdexmTextTransformerTest {


  @Test
  public void fdexmToJsonTest() {
    String fdexmText = FileUtil.readStringFromFile("./src/test/resources/sample-data/ifpl.txt");

    String json = FdexmTextTransformer.fdexm2Json(fdexmText);

    log.info(json);
  }
}
