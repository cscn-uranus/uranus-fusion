package com.uranus.transition.common.dto;

import lombok.Data;

/**
 * @author tellxp@github.com
 * @date 2019/4/29 18:18
 */
@Data
public class CartesianCoordinateDTO {
  /** X 坐标 */
  private Double x;

  /** Y 坐标 */
  private Double y;

  /** X 方向速率 */
  private Double velocityX;

  /** Y 方向速率 */
  private Double velocityY;

  /** X 方向加速度 */
  private Double accelerationX;

  /** Y 方向加速度 */
  private Double accelerationY;
}
