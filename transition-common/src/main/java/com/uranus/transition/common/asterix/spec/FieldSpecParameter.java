package com.uranus.transition.common.asterix.spec;

/**
 * FieldSpecParameter
 *
 * @author tellxp@github.com
 * @date 2019/4/28 17:11
 */
public interface FieldSpecParameter {

  /**
   * 实例化不同的 FRN 最大值
   *
   * @return FRN 的最大值, 由文档规范决定
   */
  Integer maxFrn();

  /**
   * 实例化不同的数据长度默认值
   *
   * @return 不同的数据长度默认值, 由文档规范决定
   */
  Integer defaultFpIndicatorSize();

  /**
   * 默认数据项的配置
   *
   * @return 默认数据项的配置, 由文档规范决定
   */
  FpIndicationEnum defaultFpIndication();

  /**
   * FRN 起始计数值
   *
   * @return FRN 起始计数值, 由文档规范决定
   */
  Integer frnStartNumber();

  /**
   * FRN 的步长
   *
   * @return FRN 的步长, 由文档规范决定
   */
  Integer frnStepSize();

  /**
   * 最大的 FXN 值
   *
   * @return 最大的 FXN 值, 由文档规范决定
   */
  Integer maxFxn();

  /**
   * 默认 FXN 配置
   *
   * @return 默认 FXN 配置, 由文档规范决定
   */
  FxIndicationEnum defaultFxIndication();

  /**
   * FXN 起始计数值
   *
   * @return FXN 起始计数值, 由文档规范决定
   */
  Integer fxnStartNumber();

  /**
   * FXN 在字节中的位置
   *
   * @return FXN 在字节中的位置, 由文档规范决定
   */
  Integer fxnOctetIndex();

  /**
   * FXN 的前缀
   *
   * @return FXN 的前缀, 由文档规范决定
   */
  String fxPrefix();
}
