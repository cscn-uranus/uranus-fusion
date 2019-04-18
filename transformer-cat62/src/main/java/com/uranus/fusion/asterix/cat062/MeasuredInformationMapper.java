package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.spec.*;
import com.uranus.fusion.asterix.uap.datainfo.MeasuredInformation;
import com.uranus.fusion.asterix.uap.datainfo.ReportType;
import com.uranus.fusion.asterix.uap.emitter.mode3.LastMode3Code;
import com.uranus.fusion.asterix.uap.emitter.modec.LastModecCode;
import com.uranus.fusion.asterix.uap.identification.SystemIdentification;
import com.uranus.fusion.asterix.uap.measure.altitude.Measured3DHeight;
import com.uranus.fusion.asterix.uap.measure.position.MeasuredPosition;

import java.util.List;

/**
 * MeasuredInformationMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class MeasuredInformationMapper {

  public static MeasuredInformation read(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 28;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateIndexByFrn(frn);

      MeasuredInformation measuredInformation = new MeasuredInformation();

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.CAT062_MEASURED_INFORMATION);
      dataSpec.readValue(uap, index);

      SystemIdentification sensorIdentification = SensorIdentificationMapper.read(uap, dataSpec);
      measuredInformation.setSensorIdentification(sensorIdentification);

      MeasuredPosition measuredPosition = MeasuredPositionMapper.read(uap, dataSpec);
      measuredInformation.setMeasuredPosition(measuredPosition);

      Measured3DHeight measured3DHeight = MeasuredD3HeightMapper.read(uap, dataSpec);
      measuredInformation.setMeasured3DHeight(measured3DHeight);

      LastModecCode lastModecCode = LastModeCharlieCodeMapper.read(uap, dataSpec);
      measuredInformation.setLastModecCode(lastModecCode);

      LastMode3Code lastMode3Code = LastMode3CodeMapper.read(uap, dataSpec);
      measuredInformation.setLastMode3Code(lastMode3Code);

      ReportType reportType = ReportStatusMapper.read(uap, dataSpec);
      measuredInformation.setReportType(reportType);

      fpIndicator.setSize(dataSpec.calculateTotalSize());
      return measuredInformation;
    }
    return null;
  }
}
