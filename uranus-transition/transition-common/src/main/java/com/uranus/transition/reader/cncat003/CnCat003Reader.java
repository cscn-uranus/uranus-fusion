package com.uranus.transition.reader.cncat003;

import com.uranus.transition.common.asterix.AsterixConfig;
import com.uranus.transition.common.asterix.AsterixValidator;
import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.uap.cncat003.CnCat003DataBlock;
import com.uranus.transition.common.asterix.uap.cncat003.CnCat003Uap;
import com.uranus.transition.reader.AsterixReader;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tellxp@github.com
 * @date 2019/6/19
 */
@Slf4j
public class CnCat003Reader {

  private CnCat003DataBlock readCnCat003DataBlock(List<Byte> message, int beginIndex) {
    CnCat003DataBlock cnCat003DataBlock = new CnCat003DataBlock();
    FieldSpec fieldSpec =
      AsterixReader.readFspec(message, beginIndex, new CnCat003FieldSpecParameter());

    cnCat003DataBlock.setFieldSpec(fieldSpec);

    cnCat003DataBlock.setDatasourceIdentifier(DataSourceIdentifierReader.read(message, fieldSpec));
    cnCat003DataBlock.setTargetReportInformation(TargetReportInfomationReader.read(message,fieldSpec));
    cnCat003DataBlock.setCallsign(CallsignReader.read(message,fieldSpec));
    cnCat003DataBlock.setTrackNumber(TrackNumberReader.read(message,fieldSpec));
    cnCat003DataBlock.setCartesianPosition(CartesianCalculatedTrackPositionReader.read(message,fieldSpec));
    cnCat003DataBlock.setMode3Code(TrackMode3CodeReader.read(message,fieldSpec));
    cnCat003DataBlock.setTrackAccuracy(TrackAccuracyReader.read(message,fieldSpec));
    cnCat003DataBlock.setReportedFlightLevel(ReportFlightLevelReader.read(message,fieldSpec));
    cnCat003DataBlock.setTimeOfTrack(TimeOfTrackReader.read(message,fieldSpec));
    cnCat003DataBlock.setRateOfClimbOrDescent(CalculatedRateOfClimbOrDescentReader.read(message,fieldSpec));
    cnCat003DataBlock.setMode2Code(TrackMode2CodeReader.read(message,fieldSpec));
    cnCat003DataBlock.setDestinationAirport(DestinationAirportReader.read(message,fieldSpec));
    cnCat003DataBlock.setControlledStatus(ControlledStatusReader.read(message,fieldSpec));
    cnCat003DataBlock.setWakeTurbulenceCategory(WakeTurbulenceCategoryReader.read(message,fieldSpec));

    return cnCat003DataBlock;
  }

  /**
   * 读取多个DataBlock
   *
   * @param message 符合 Asterix 规范的报文
   * @return DataBlock 集合
   */
  private List<CnCat003DataBlock> readCnCat003DataBlocks(List<Byte> message) {

    List<CnCat003DataBlock> cnCat003DataBlocks = new ArrayList<>();
    int messageSize = message.size();

    int beginIndex = AsterixConfig.ASTERIX_FIRST_FSPEC_INDEX;

    while (beginIndex < messageSize) {

      CnCat003DataBlock cnCat003DataBlock = readCnCat003DataBlock(message, beginIndex);

      beginIndex += cnCat003DataBlock.getFieldSpec().calculateCurrentDataBlockLength();

      cnCat003DataBlocks.add(cnCat003DataBlock);
    }
    return cnCat003DataBlocks;
  }

  /**
   * @param message 符合 Eurocontrol Asterix CAT062 规范的报文
   * @return EuCat062Uap 对象实例
   */
  public CnCat003Uap readValue(List<Byte> message) {
    CnCat003Uap cnCat003Uap = new CnCat003Uap();
    cnCat003Uap.setMessageSize(message.size());
    cnCat003Uap.setCategory(AsterixReader.readCategory(message));
    cnCat003Uap.setLength(AsterixReader.readLength(message));
    cnCat003Uap.setCnCat003DataBlocks(readCnCat003DataBlocks(message));

    if (!AsterixValidator.isValidAsterixUap(
      cnCat003Uap, CnCat003Config.CATEGORY_VALUE, CnCat003Config.SPARE_FRN)) {
      return null;
    }
    return cnCat003Uap;
  }
}
