package com.uranus.transition.common.asterix.uap.cncat003;

import com.uranus.transition.common.asterix.AsterixUap;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tellxp@github.com
 * @date 2019/6/25
 */
@Data
public class CnCat003Uap implements AsterixUap {
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
  public List<CnCat003DataBlock> asterixDataBlocks() {

    return new ArrayList<>();
  }

  private Integer messageSize;

  private Integer category;
  private Integer length;
  private List<CnCat003DataBlock> cnCat003DataBlocks;
}
