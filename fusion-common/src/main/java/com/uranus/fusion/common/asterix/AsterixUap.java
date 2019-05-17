package com.uranus.fusion.common.asterix;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AsterixUap implements Serializable {
  private Integer category;
  private Integer length;
  private List<AsterixDataBlock> asterixDataBlocks;

  public void add(AsterixDataBlock asterixDataBlock) {
    this.asterixDataBlocks.add(asterixDataBlock);
  }
}
