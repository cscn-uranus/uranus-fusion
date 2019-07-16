package com.uranus.transition.common.asterix.uap.eucat062;

import com.uranus.transition.common.asterix.AsterixUap;
import lombok.Data;

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
 * <p>参考 All-purpose structured EUROCONTROL surveillance information exchange (ASTERIX)
 *
 * @author XiaoPeng
 * @date 2019/6/11
 */
@Data
public class EuCat062Uap implements AsterixUap {


  @Override
  public Integer messageSize() {
    return messageSize;
  }

  @Override
  public Integer category() {
    return category;
  }

  @Override
  public Integer length() {
    return length;
  }

  @Override
  public List<EuCat062DataBlock> asterixDataBlocks() {
    return euCat062DataBlocks;
  }

  private Integer messageSize;
  /**
   * Category
   *
   * <p>标识报文的类型，如 CAT001、CAT002、CAT048、CAT062等
   *
   * <p>参考 EUROCONTROL Specification for Surveillance Data Exchange - Part I
   */
  private Integer category;
  /**
   * Length
   *
   * <p>标识报文的总长度
   *
   * <p>参考 EUROCONTROL Specification for Surveillance Data Exchange - Part I
   */
  private Integer length;

  /**
   * 报文的数据块，每个数据块由 FSPEC 和 Data Record 组成
   *
   * <p>参考 EUROCONTROL Specification for Surveillance Data Exchange - Part I
   */
  private List<EuCat062DataBlock> euCat062DataBlocks;
}
