package com.uranus.transition.reader.eucat062.measured;

import com.uranus.transition.reader.eucat062.EuCat062Config;
import com.uranus.transition.common.asterix.spec.*;
import com.uranus.transition.common.asterix.uap.shared.datainfo.MeasuredInformation;
import com.uranus.transition.common.asterix.uap.shared.datainfo.ReportType;
import com.uranus.transition.common.asterix.uap.shared.emitter.mode3.LastMode3Code;
import com.uranus.transition.common.asterix.uap.shared.emitter.modec.ModecCode;
import com.uranus.transition.common.asterix.uap.shared.identification.SystemIdentification;
import com.uranus.transition.common.asterix.uap.shared.measure.altitude.Measured3dHeight;
import com.uranus.transition.common.asterix.uap.shared.measure.position.MeasuredPosition;

import java.util.List;

/**
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/15
 */
public class MeasuredInformationReader {

  public static MeasuredInformation read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(EuCat062Config.MEASURED_INFORMATION_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateIndexByFrn(EuCat062Config.MEASURED_INFORMATION_FRN);

      MeasuredInformation measuredInformation = new MeasuredInformation();

      DataSpecParameter dataSpecParameter = new MeasuredInformationDataSpecParameter();
        DataSpec dataSpec = new DataSpec(index,dataSpecParameter);
      dataSpec.readValue(message);

      SystemIdentification sensorIdentification = SensorIdentificationReader.read(message, dataSpec);
      measuredInformation.setSensorIdentification(sensorIdentification);

      MeasuredPosition measuredPosition = MeasuredPositionReader.read(message, dataSpec);
      measuredInformation.setMeasuredPosition(measuredPosition);

      Measured3dHeight measured3DHeight = Measured3dHeightReader.read(message, dataSpec);
      measuredInformation.setMeasured3dHeight(measured3DHeight);

      ModecCode modecCode = LastMeasuredModecCodeReader.read(message, dataSpec);
      measuredInformation.setModecCode(modecCode);

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
