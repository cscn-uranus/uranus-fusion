package com.uranus.transition.common.asterix;

import java.util.List;

/**
 * @author tellxp@github.com
 * @date 2019/6/25
 */
public interface AsterixUap {
  Integer messageSize();

  Integer category();

  Integer length();

  List<? extends AsterixDataBlock> asterixDataBlocks();
}
