package com.uranus.transition.common.asterix.cat062.measured;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.spec.*;
import com.uranus.transition.common.asterix.uap.datainfo.MeasuredInformation;
import com.uranus.transition.common.asterix.uap.datainfo.ReportType;
import com.uranus.transition.common.asterix.uap.emitter.mode3.LastMode3Code;
import com.uranus.transition.common.asterix.uap.emitter.modec.LastModecCode;
import com.uranus.transition.common.asterix.uap.identification.SystemIdentification;
import com.uranus.transition.common.asterix.uap.measure.altitude.Measured3dHeight;
import com.uranus.transition.common.asterix.uap.measure.position.MeasuredPosition;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class MeasuredInformationReader {

  public static MeasuredInformation read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(Cat062Config.MEASURED_INFORMATION_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateIndexByFrn(Cat062Config.MEASURED_INFORMATION_FRN);

      MeasuredInformation measuredInformation = new MeasuredInformation();

      DataSpecParameter dataSpecParameter = new MeasuredInformationDataSpecParameter();
        DataSpec dataSpec = new DataSpec(index,dataSpecParameter);
      dataSpec.readValue(message);

      SystemIdentification sensorIdentification = SensorIdentificationReader.read(message, dataSpec);
      measuredInformation.setSensorIdentification(sensorIdentification);

      MeasuredPosition measuredPosition = MeasuredPositionReader.read(message, dataSpec);
      measuredInformation.setMeasuredPosition(measuredPosition);

      Measured3dHeight measured3DHeight = Measured3dHeightReader.read(message, dataSpec);
      measuredInformation.setMeasured3DHeight(measured3DHeight);

      LastModecCode lastModecCode = LastMeasuredModecCodeReader.read(message, dataSpec);
      measuredInformation.setLastModecCode(lastModecCode);

      LastMode3Code lastMode3Code = LastMeasuredMode3CodeReader.read(message, dataSpec);
      measuredInformation.setLastMode3Code(lastMode3Code);

      ReportType reportType = ReportTypeReader.read(message, dataSpec);
      measuredInformation.setReportType(reportType);

      fpIndicator.setSize(dataSpec.calculateTotalSize());
      return measuredInformation;
    }
    return null;
  }
}
