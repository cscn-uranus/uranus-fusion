package com.uranus.transition.common.asterix.cat062.measured;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.spec.*;
import com.uranus.transition.common.asterix.uap.datainfo.MeasuredInformation;
import com.uranus.transition.common.asterix.uap.datainfo.ReportType;
import com.uranus.transition.common.asterix.uap.emitter.mode3.LastMode3Code;
import com.uranus.transition.common.asterix.uap.emitter.modec.LastModecCode;
import com.uranus.transition.common.asterix.uap.identification.SystemIdentification;
import com.uranus.transition.common.asterix.uap.measure.altitude.Measured3DHeight;
import com.uranus.transition.common.asterix.uap.measure.position.MeasuredPosition;
import com.uranus.transition.common.asterix.cat062.measured.sub.*;

import java.util.List;

/**
 * MeasuredInformationMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class MeasuredInformationMapper {

  public static MeasuredInformation read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(Cat062Config.MEASURED_INFORMATION_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateIndexByFrn(Cat062Config.MEASURED_INFORMATION_FRN);

      MeasuredInformation measuredInformation = new MeasuredInformation();

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.CAT062_MEASURED_INFORMATION);
      dataSpec.readValue(uap, index);

      SystemIdentification sensorIdentification = SensorIdentificationMapper.read(uap, dataSpec);
      measuredInformation.setSensorIdentification(sensorIdentification);

      MeasuredPosition measuredPosition = MeasuredPositionMapper.read(uap, dataSpec);
      measuredInformation.setMeasuredPosition(measuredPosition);

      Measured3DHeight measured3DHeight = Measured3DHeightMapper.read(uap, dataSpec);
      measuredInformation.setMeasured3DHeight(measured3DHeight);

      LastModecCode lastModecCode = LastMeasuredModecCodeMapper.read(uap, dataSpec);
      measuredInformation.setLastModecCode(lastModecCode);

      LastMode3Code lastMode3Code = LastMeasuredMode3CodeMapper.read(uap, dataSpec);
      measuredInformation.setLastMode3Code(lastMode3Code);

      ReportType reportType = ReportTypeMapper.read(uap, dataSpec);
      measuredInformation.setReportType(reportType);

      fpIndicator.setSize(dataSpec.calculateTotalSize());
      return measuredInformation;
    }
    return null;
  }
}
