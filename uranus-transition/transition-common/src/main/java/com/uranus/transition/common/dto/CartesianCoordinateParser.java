package com.uranus.transition.common.dto;

import com.uranus.transition.common.asterix.uap.eucat062.EuCat062DataBlock;

/**
 * @author tellxp@github.com
 * @date 2019/5/20 21:39
 */
public class CartesianCoordinateParser {
  public static CartesianCoordinateDTO parse(EuCat062DataBlock euCat062DataBlock) {

    if (null == euCat062DataBlock) {
      return null;
    }
    if (null == euCat062DataBlock.getCartesianPosition()
        && null == euCat062DataBlock.getCartesianVelocity()
        && null == euCat062DataBlock.getCartesianAcceleration()) {
      return null;
    }
    CartesianCoordinateDTO cartesianCoordinateDTO = new CartesianCoordinateDTO();

    if (null != euCat062DataBlock.getCartesianPosition()) {
      cartesianCoordinateDTO.setX(euCat062DataBlock.getCartesianPosition().getX());
      cartesianCoordinateDTO.setY(euCat062DataBlock.getCartesianPosition().getY());
    }

    if (null != euCat062DataBlock.getCartesianVelocity()) {
      cartesianCoordinateDTO.setVelocityX(euCat062DataBlock.getCartesianVelocity().getVelocityX());
      cartesianCoordinateDTO.setVelocityY(euCat062DataBlock.getCartesianVelocity().getVelocityY());
    }

    if (null != euCat062DataBlock.getCartesianAcceleration()) {
      cartesianCoordinateDTO.setAccelerationX(
          euCat062DataBlock.getCartesianAcceleration().getAccelerationX());
      cartesianCoordinateDTO.setAccelerationY(
          euCat062DataBlock.getCartesianAcceleration().getAccelerationY());
    }
    return cartesianCoordinateDTO;
  }
}
