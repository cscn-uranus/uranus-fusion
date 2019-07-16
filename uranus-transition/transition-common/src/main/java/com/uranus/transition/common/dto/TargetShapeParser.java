package com.uranus.transition.common.dto;

import com.uranus.transition.common.asterix.uap.eucat062.EuCat062DataBlock;

/**
 * @author tellxp@github.com
 * @date 2019/5/20 21:39
 */
public class TargetShapeParser {
  public static TargetShapeDTO parse(EuCat062DataBlock euCat062DataBlock) {
    if (null == euCat062DataBlock.getTargetSizeAndOrientation()) {
      return null;
    }
    TargetShapeDTO targetShapeDTO = new TargetShapeDTO();

    targetShapeDTO.setOrientation(euCat062DataBlock.getTargetSizeAndOrientation().getOrientation());
    targetShapeDTO.setLength(euCat062DataBlock.getTargetSizeAndOrientation().getLength());
    targetShapeDTO.setWidth(euCat062DataBlock.getTargetSizeAndOrientation().getWidth());

    return targetShapeDTO;
  }
}
