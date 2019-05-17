package com.uranus.fusion.common.asterix.uap.measure;

import com.uranus.fusion.common.asterix.uap.datainfo.SourceInformationEnum;
import com.uranus.fusion.common.asterix.uap.datainfo.SourceTypeEnum;
import lombok.Data;

/**
 * SelectedAltitude
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/18
 */
@Data
public class SelectedAltitude {

  private Double altitude;
  private SourceInformationEnum sourceStatus;
  private SourceTypeEnum sourceTypeEnum;
}
