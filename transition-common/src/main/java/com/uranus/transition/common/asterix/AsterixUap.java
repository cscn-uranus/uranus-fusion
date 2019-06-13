package com.uranus.transition.common.asterix;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Asterix Uap ( Asterix User Application Profile )
 *
 * <p>对象的基础来源是 Eurocontrol Asterix CAT 062 的定义，
 *
 * <p>兼容 Asterix 其他 CATEGORY 的报文
 *
 * <p>兼容中国民用航空 空管雷达及管制中心设施间协调移交 数据规范 MH/T 4008-2000 规范
 *
 * 参考  All-purpose structured EUROCONTROL surveillance information exchange (ASTERIX)
 *
 * @author XiaoPeng
 * @date 2019/6/11
 */
@Data
public class AsterixUap {
  /**
   * Category
   *
   * 标识报文的类型，如 CAT001、CAT002、CAT048、CAT062等
   *
   * 参考 EUROCONTROL Specification for Surveillance Data Exchange - Part I
   */
  private Integer category;

  /**
   * Length
   *
   * 标识报文的总长度
   *
   * 参考 EUROCONTROL Specification for Surveillance Data Exchange - Part I
   */
  private Integer length;

  /**
   * 报文的数据块，每个数据块又 FSPEC 和 Data Record 组成
   *
   * 参考 EUROCONTROL Specification for Surveillance Data Exchange - Part I
   */
  private List<AsterixDataBlock> asterixDataBlocks;

}
