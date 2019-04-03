package com.uranus.transformer.fdexm.util;

import com.uranus.transformer.fdexm.FdexmTransformerAppTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class FdexmTextTransformerTest {

  private static final Logger logger = LoggerFactory.getLogger(FdexmTextTransformerTest.class);

  @Test
  public void fdexmToJsonTest() {
    String fdexmText = FileUtil.readStringFromFile("./src/test/resources/sample-data/ifpl.txt");

    String json = FdexmTextTransformer.fdexm2Json(fdexmText);

    logger.info(json);
  }
}
