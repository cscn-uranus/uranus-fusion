package com.uranus.transition.common.asterix.dto;

import com.uranus.transition.common.asterix.AsterixDataBlock;

/**
 * @author tellxp@github.com
 * @date 2019/5/20 21:39
 */
public class TargetShapeParser {
  public static TargetShapeDTO parse(AsterixDataBlock asterixDataBlock) {
    if (null == asterixDataBlock.getTargetSizeAndOrientation()) {
      return null;
    }
    TargetShapeDTO targetShapeDTO = new TargetShapeDTO();

    targetShapeDTO.setOrientation(asterixDataBlock.getTargetSizeAndOrientation().getOrientation());
    targetShapeDTO.setLength(asterixDataBlock.getTargetSizeAndOrientation().getLength());
    targetShapeDTO.setWidth(asterixDataBlock.getTargetSizeAndOrientation().getWidth());

    return targetShapeDTO;
  }
}
