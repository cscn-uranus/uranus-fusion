package com.uranus.transition.reader.eucat062;

import com.uranus.transition.common.asterix.AsterixConfig;
import com.uranus.transition.reader.AsterixReader;
import com.uranus.transition.common.asterix.AsterixValidator;
import com.uranus.transition.reader.eucat062.accuracy.EstimatedAccuracyReader;
import com.uranus.transition.reader.eucat062.aircraftdata.AircraftDerivedDataReader;
import com.uranus.transition.reader.eucat062.dataage.TrackDataAgeMapper;
import com.uranus.transition.reader.eucat062.flightplan.FlightPlanRelatedDataMapper;
import com.uranus.transition.reader.eucat062.measured.MeasuredInformationReader;
import com.uranus.transition.reader.eucat062.mode5.Mode5AndMode1Reader;
import com.uranus.transition.reader.eucat062.updateage.SystemTrackUpdateAgeReader;
import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.uap.eucat062.EuCat062DataBlock;
import com.uranus.transition.common.asterix.uap.eucat062.EuCat062Uap;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
@Slf4j
public class EuCat062Reader {

  private EuCat062DataBlock readEuCat062DataBlock(List<Byte> message, int beginIndex) {
    EuCat062DataBlock euCat062DataBlock = new EuCat062DataBlock();
    FieldSpec fieldSpec =
        AsterixReader.readFspec(message, beginIndex, new EuCat062FieldSpecParameter());

    euCat062DataBlock.setFieldSpec(fieldSpec);

    euCat062DataBlock.setSystemIdentification(DataSourceIdentifierReader.read(message, fieldSpec));
    euCat062DataBlock.setServiceIdentification(
        ServiceIdentificationReader.read(message, fieldSpec));
    euCat062DataBlock.setTimeOfTrack(TimeOfTrackReader.read(message, fieldSpec));
    euCat062DataBlock.setWgs84Position(Wgs84CalculatedTrackPositionReader.read(message, fieldSpec));
    euCat062DataBlock.setCartesianPosition(
        CartesianCalculatedTrackPositionReader.read(message, fieldSpec));
    euCat062DataBlock.setCartesianVelocity(
        CartesianCalculatedTrackVelocityReader.read(message, fieldSpec));
    euCat062DataBlock.setCartesianAcceleration(
        CartesianCalculatedTrackAccelerationReader.read(message, fieldSpec));
    euCat062DataBlock.setMode3Code(TrackMode3CodeReader.read(message, fieldSpec));
    euCat062DataBlock.setTargetIdentification(TargetIdentificationReader.read(message, fieldSpec));
    euCat062DataBlock.setAircraftDerivedData(AircraftDerivedDataReader.read(message, fieldSpec));
    euCat062DataBlock.setTrackNumber(TrackNumberReader.readTrackNumber(message, fieldSpec));
    euCat062DataBlock.setTrackStatus(TrackStatusReader.readTrackStatus(message, fieldSpec));
    euCat062DataBlock.setSystemTrackUpdateAge(SystemTrackUpdateAgeReader.read(message, fieldSpec));
    euCat062DataBlock.setModeOfMovement(
        ModeOfMovementReader.readModeOfMovement(message, fieldSpec));
    euCat062DataBlock.setTrackDataAge(TrackDataAgeMapper.read(message, fieldSpec));
    euCat062DataBlock.setMeasuredFlightLevel(MeasuredFlightLevelReader.read(message, fieldSpec));
    euCat062DataBlock.setTrackGeometricAltitude(
        CalculatedTrackGeometricAltitudeReader.read(message, fieldSpec));
    euCat062DataBlock.setTrackBarometricAltitude(
        CalculatedTrackBarometricAltitudeReader.read(message, fieldSpec));
    euCat062DataBlock.setRateOfClimbOrDescent(
        CalculatedRateOfClimbOrDescentReader.read(message, fieldSpec));
    euCat062DataBlock.setFlightPlanRelatedData(
        FlightPlanRelatedDataMapper.read(message, fieldSpec));
    euCat062DataBlock.setTargetSizeAndOrientation(
        TargetSizeAndOrientationReader.read(message, fieldSpec));
    euCat062DataBlock.setVehicleFleetIdentification(
        VehicleFleetIdentificationReader.read(message, fieldSpec));
    euCat062DataBlock.setMode5AndExtendedMode1(Mode5AndMode1Reader.read(message, fieldSpec));
    euCat062DataBlock.setMode2Code(TrackMode2CodeReader.read(message, fieldSpec));
    euCat062DataBlock.setComposedTrackNumber(ComposedTrackNumberReader.read(message, fieldSpec));
    euCat062DataBlock.setEstimatedAccuracy(EstimatedAccuracyReader.read(message, fieldSpec));
    euCat062DataBlock.setMeasuredInformation(MeasuredInformationReader.read(message, fieldSpec));
    return euCat062DataBlock;
  }

  /**
   * 读取多个DataBlock
   *
   * @param message 符合 Asterix 规范的报文
   * @return DataBlock 集合
   */
  private List<EuCat062DataBlock> readEuCat062DataBlocks(List<Byte> message) {

    List<EuCat062DataBlock> euCat062DataBlocks = new ArrayList<>();
    int messageSize = message.size();

    int beginIndex = AsterixConfig.ASTERIX_FIRST_FSPEC_INDEX;

    while (beginIndex < messageSize) {

      EuCat062DataBlock euCat062DataBlock = readEuCat062DataBlock(message, beginIndex);

      beginIndex += euCat062DataBlock.getFieldSpec().calculateCurrentDataBlockLength();

      euCat062DataBlocks.add(euCat062DataBlock);
    }
    return euCat062DataBlocks;
  }

  /**
   * @param message 符合 Eurocontrol Asterix CAT062 规范的报文
   * @return EuCat062Uap 对象实例
   */
  public EuCat062Uap readValue(List<Byte> message) {
    EuCat062Uap euCat062Uap = new EuCat062Uap();
    euCat062Uap.setMessageSize(message.size());
    euCat062Uap.setCategory(AsterixReader.readCategory(message));
    euCat062Uap.setLength(AsterixReader.readLength(message));
    euCat062Uap.setEuCat062DataBlocks(readEuCat062DataBlocks(message));

    if (!AsterixValidator.isValidAsterixUap(
        euCat062Uap, EuCat062Config.CATEGORY_VALUE, EuCat062Config.SPARE_FRN)) {
      return null;
    }
    return euCat062Uap;
  }
}
