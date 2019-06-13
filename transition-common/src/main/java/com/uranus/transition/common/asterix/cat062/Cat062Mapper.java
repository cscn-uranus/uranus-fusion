package com.uranus.transition.common.asterix.cat062;

import com.uranus.transition.common.asterix.AsterixConfig;
import com.uranus.transition.common.asterix.AsterixDataBlock;
import com.uranus.transition.common.asterix.AsterixReader;
import com.uranus.transition.common.asterix.AsterixUap;
import com.uranus.transition.common.asterix.cat062.accuracy.EstimatedAccuracyReader;
import com.uranus.transition.common.asterix.cat062.aircraftdata.AircraftDerivedDataReader;
import com.uranus.transition.common.asterix.cat062.dataage.TrackDataAgeMapper;
import com.uranus.transition.common.asterix.cat062.flightplan.FlightPlanRelatedDataMapper;
import com.uranus.transition.common.asterix.cat062.measured.MeasuredInformationReader;
import com.uranus.transition.common.asterix.cat062.mode5.Mode5AndMode1Reader;
import com.uranus.transition.common.asterix.cat062.updateage.SystemTrackUpdateAgeReader;
import com.uranus.transition.common.asterix.spec.FieldSpec;
import com.uranus.transition.common.asterix.spec.FieldSpecParameter;
import com.uranus.transition.common.asterix.spec.FpIndicationEnum;
import com.uranus.transition.common.asterix.spec.FpIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Cat062Mapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
public class Cat062Mapper {

  private FieldSpecParameter fieldSpecParameter = new Cat062FieldSpecParameter();
  private List<Byte> message = new ArrayList<>();
  private AsterixUap uap = new AsterixUap();

  public Cat062Mapper(byte[] input) {
    for (byte octet : input) {
      this.message.add(octet);
    }
  }

  private List<AsterixDataBlock> readAsterixDataBlocks(List<Byte> message) {
    List<AsterixDataBlock> asterixDataBlocks = new ArrayList<>();
    int messageSize = this.message.size();

    int beginIndex = AsterixConfig.ASTERIX_FIRST_FSPEC_INDEX;

    while (beginIndex < messageSize) {
      AsterixDataBlock asterixDataBlock = new AsterixDataBlock();

      FieldSpec fieldSpec = AsterixReader.read(message, beginIndex, fieldSpecParameter);
      if (!isValidCat062FieldSpec(fieldSpec)) {
        return null;
      }
      asterixDataBlock.setFieldSpec(fieldSpec);

      asterixDataBlock.setSystemIdentification(DataSourceIdentifierReader.read(message, fieldSpec));

      asterixDataBlock.setServiceIdentification(
          ServiceIdentificationReader.read(message, fieldSpec));

      asterixDataBlock.setTimeOfTrack(TimeOfTrackReader.read(message, fieldSpec));

      asterixDataBlock.setWgs84Position(
          Wgs84CalculatedTrackPositionReader.read(message, fieldSpec));

      asterixDataBlock.setCartesianPosition(
          CartesianCalculatedTrackPositionReader.read(message, fieldSpec));

      asterixDataBlock.setCartesianVelocity(
          CartesianCalculatedTrackVelocityReader.read(message, fieldSpec));

      asterixDataBlock.setCartesianAcceleration(
          CartesianCalculatedTrackAccelerationReader.read(message, fieldSpec));

      asterixDataBlock.setMode3Code(TrackMode3ACodeReader.read(message, fieldSpec));

      asterixDataBlock.setTargetIdentification(TargetIdentificationReader.read(message, fieldSpec));

      asterixDataBlock.setAircraftDerivedData(AircraftDerivedDataReader.read(message, fieldSpec));

      asterixDataBlock.setTrackNumber(TrackNumberReader.readTrackNumber(message, fieldSpec));

      asterixDataBlock.setTrackStatus(TrackStatusReader.readTrackStatus(message, fieldSpec));

      asterixDataBlock.setSystemTrackUpdateAge(SystemTrackUpdateAgeReader.read(message, fieldSpec));

      asterixDataBlock.setModeOfMovement(
          ModeOfMovementReader.readModeOfMovement(message, fieldSpec));

      asterixDataBlock.setTrackDataAge(TrackDataAgeMapper.read(message, fieldSpec));

      asterixDataBlock.setMeasuredFlightLevel(MeasuredFlightLevelReader.read(message, fieldSpec));

      asterixDataBlock.setTrackGeometricAltitude(
          CalculatedTrackGeometricAltitudeReader.read(message, fieldSpec));

      asterixDataBlock.setTrackBarometricAltitude(
          CalculatedTrackBarometricAltitudeReader.read(message, fieldSpec));

      asterixDataBlock.setRateOfClimbOrDescent(
          CalculatedRateOfClimbOrDescentReader.read(message, fieldSpec));

      asterixDataBlock.setFlightPlanRelatedData(
          FlightPlanRelatedDataMapper.read(message, fieldSpec));

      asterixDataBlock.setTargetSizeAndOrientation(
          TargetSizeAndOrientationReader.read(message, fieldSpec));

      asterixDataBlock.setVehicleFleetIdentification(
          VehicleFleetIdentificationReader.read(message, fieldSpec));

      asterixDataBlock.setMode5AndExtendedMode1(Mode5AndMode1Reader.read(message, fieldSpec));

      asterixDataBlock.setMode2Code(TrackMode2CodeReader.read(message, fieldSpec));

      asterixDataBlock.setComposedTrackNumber(ComposedTrackNumberReader.read(message, fieldSpec));

      asterixDataBlock.setEstimatedAccuracy(EstimatedAccuracyReader.read(message, fieldSpec));

      asterixDataBlock.setMeasuredInformation(MeasuredInformationReader.read(message, fieldSpec));

      beginIndex += fieldSpec.calculateCurrentDataBlockLength();

      asterixDataBlocks.add(asterixDataBlock);
    }
    return asterixDataBlocks;
  }

  private Boolean isValidCat062FieldSpec(FieldSpec fieldSpec) {

    if (null == fieldSpec) {
      return false;
    }
    for (int frn : Cat062Config.SPARE_FRN) {
      FpIndicator fpIndicator = fieldSpec.findFpIndicatorByFrn(frn);
      if (FpIndicationEnum.PRESENCE == fpIndicator.getIndication()) {
        System.out.println(
            "非法的CAT062报文,CAT062报文中FRN=" + frn + "的数据项为预留项, FSPEC中该数据项应该为ABSENCE, 当前值为PRESENCE");
        return false;
      }
    }
    return true;
  }

  public AsterixUap readValue() {
    int category = AsterixReader.readCategory(this.message);

    if (AsterixConfig.CAT062_CATEGORY_VALUE != category) {
      System.out.println("非法的CAT062报文,CAT062报文中Category值应该为62,当前报文的Category值为: " + category);
      return null;
    }
    this.uap.setCategory(category);

    int length = AsterixReader.readLength(this.message);
    if (this.message.size() != length) {
      System.out.println(
          "报文的LEN声明值与报文实际长度不一致. 报文中声明的长度为:" + length + ",实际报文长度为:" + this.message.size());
    }
    this.uap.setLength(length);

    List<AsterixDataBlock> asterixDataBlocks = this.readAsterixDataBlocks(message);
    this.uap.setAsterixDataBlocks(asterixDataBlocks);

    int totalSize = AsterixConfig.ASTERIX_CATEGORY_SIZE + AsterixConfig.ASTERIX_LENGTH_SIZE;

    assert asterixDataBlocks != null;
    for (AsterixDataBlock block : asterixDataBlocks) {
      totalSize += block.getFieldSpec().calculateCurrentDataBlockLength();
    }

    if (totalSize != this.message.size()) {
      System.out.println(
          "读取的长度和报文长度不一致, 存在解析问题. 读取的长度是:" + totalSize + ". 报文长度是:" + this.message.size());
    }
    return this.uap;
  }
}
