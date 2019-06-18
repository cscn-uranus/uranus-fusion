package com.uranus.transition.common.asterix.dto;

import com.uranus.transition.common.asterix.AsterixDataBlock;

/**
 * @author tellxp@github.com
 * @date 2019/5/20 21:39
 */
public class CartesianCoordinateParser {
  public static CartesianCoordinateDTO parse(AsterixDataBlock asterixDataBlock) {

    if (null == asterixDataBlock) {
      return null;
    }
    if (null == asterixDataBlock.getCartesianPosition()
        && null == asterixDataBlock.getCartesianVelocity()
        && null == asterixDataBlock.getCartesianAcceleration()) {
      return null;
    }
    CartesianCoordinateDTO cartesianCoordinateDTO = new CartesianCoordinateDTO();

    if (null != asterixDataBlock.getCartesianPosition()) {
      cartesianCoordinateDTO.setX(asterixDataBlock.getCartesianPosition().getX());
      cartesianCoordinateDTO.setY(asterixDataBlock.getCartesianPosition().getY());
    }

    if (null != asterixDataBlock.getCartesianVelocity()) {
      cartesianCoordinateDTO.setVelocityX(asterixDataBlock.getCartesianVelocity().getVelocityX());
      cartesianCoordinateDTO.setVelocityY(asterixDataBlock.getCartesianVelocity().getVelocityY());
    }

    if (null != asterixDataBlock.getCartesianAcceleration()) {
      cartesianCoordinateDTO.setAccelerationX(
          asterixDataBlock.getCartesianAcceleration().getAccelerationX());
      cartesianCoordinateDTO.setAccelerationY(
          asterixDataBlock.getCartesianAcceleration().getAccelerationY());
    }
    return cartesianCoordinateDTO;
  }
}
