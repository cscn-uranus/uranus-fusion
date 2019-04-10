package com.uranus.fusion.asterix.sensor.info;

import com.uranus.fusion.asterix.SystemIdentifier;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DataSpecTypeEnum;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import java.util.List;

/**
 * MeasuredInformationMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/15
 */
public class MeasuredInformationMapper {

  public static MeasuredInformation read(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 28;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      MeasuredInformation measuredInformation = new MeasuredInformation();

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.MEASURED_INFORMATION);
      dataSpec.readValue(uap, index);

      SystemIdentifier sensorIdentification = SensorIdentificationMapper.read(uap, dataSpec);
      MeasuredPosition measuredPosition = MeasuredPositionMapper.read(uap, dataSpec);
      MeasuredD3Height measuredD3Height = MeasuredD3HeightMapper.read(uap, dataSpec);
      LastModeCharlieCode lastModeCharlieCode = LastModeCharlieCodeMapper.read(uap, dataSpec);
      LastMode3Code lastMode3Code = LastMode3CodeMapper.read(uap, dataSpec);
      ReportStatus reportStatus = ReportStatusMapper.read(uap, dataSpec);

      fpIndicator.setSize(dataSpec.calculateTotalSize());
      return measuredInformation;
    }
    return null;
  }

}
