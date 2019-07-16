package com.uranus.transition.common.asterix.uap.shared.measure;

import com.uranus.transition.common.asterix.uap.shared.datainfo.SourceInformationEnum;
import com.uranus.transition.common.asterix.uap.shared.datainfo.SourceTypeEnum;
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
