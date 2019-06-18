package com.uranus.transition.common.asterix.spec;

/**
 * DataSpecParameter
 *
 * @author tellxp@github.com
 * @date 2019/4/28 17:11
 */
public interface DataSpecParameter {

  /**
   * 实例化不同的 drn 最大值
   *
   * @return drn 的最大值, 由文档规范决定
   */
  Integer maxDrn();

  /**
   * 实例化不同的数据长度默认值
   *
   * @return 不同的数据长度默认值, 由文档规范决定
   */
  Integer defaultDpIndicatorSize();

  /**
   * 默认数据项的配置
   *
   * @return 默认数据项的配置, 由文档规范决定
   */
  DpIndicationEnum defaultDpIndication();

  /**
   * drn 起始计数值
   *
   * @return drn 起始计数值, 由文档规范决定
   */
  Integer drnStartNumber();

  /**
   * drn 的步长
   *
   * @return drn 的步长, 由文档规范决定
   */
  Integer drnStepSize();

  /**
   * 最大的 dxn 值
   *
   * @return 最大的 dxn 值, 由文档规范决定
   */
  Integer maxDxn();

  /**
   * 默认 dxn 配置
   *
   * @return 默认 dxn 配置, 由文档规范决定
   */
  DxIndicationEnum defaultDxIndication();

  /**
   * dxn 起始计数值
   *
   * @return dxn 起始计数值, 由文档规范决定
   */
  Integer dxnStartNumber();

  /**
   * dxn 在字节中的位置
   *
   * @return dxn 在字节中的位置, 由文档规范决定
   */
  Integer dxnOctetIndex();

  /**
   * dxn 的前缀
   *
   * @return dxn 的前缀, 由文档规范决定
   */
  String dxPrefix();
}
