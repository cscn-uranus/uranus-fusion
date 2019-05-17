package com.uranus.fusion.common.asterix.cat062;

import com.uranus.fusion.common.asterix.AsterixConfig;
import com.uranus.fusion.common.asterix.AsterixDataBlock;
import com.uranus.fusion.common.asterix.AsterixMapper;
import com.uranus.fusion.common.asterix.AsterixUap;
import com.uranus.fusion.common.asterix.cat062.accuracy.EstimatedAccuracyMapper;
import com.uranus.fusion.common.asterix.cat062.aircraftdata.AircraftDerivedDataMapper;
import com.uranus.fusion.common.asterix.cat062.dataage.TrackDataAgeMapper;
import com.uranus.fusion.common.asterix.cat062.flightplan.FlightPlanRelatedDataMapper;
import com.uranus.fusion.common.asterix.cat062.measured.MeasuredInformationMapper;
import com.uranus.fusion.common.asterix.cat062.mode5.Mode5AndMode1Mapper;
import com.uranus.fusion.common.asterix.cat062.spec.Cat062FieldSpecParameter;
import com.uranus.fusion.common.asterix.cat062.sub.*;
import com.uranus.fusion.common.asterix.cat062.updateage.SystemTrackUpdateAgeMapper;
import com.uranus.fusion.common.asterix.spec.FieldSpec;
import com.uranus.fusion.common.asterix.spec.FieldSpecParameter;
import com.uranus.fusion.common.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.common.asterix.spec.FpIndicator;

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

      FieldSpec fieldSpec = AsterixMapper.readFieldSpec(message, beginIndex, fieldSpecParameter);
      if (!isValidCat062FieldSpec(fieldSpec)) {
        return null;
      }
      asterixDataBlock.setFieldSpec(fieldSpec);

      asterixDataBlock.setSystemIdentification(DataSourceIdentifierMapper.read(message, fieldSpec));

      asterixDataBlock.setServiceIdentification(
          ServiceIdentificationMapper.read(message, fieldSpec));

      asterixDataBlock.setTimeOfTrack(TimeOfTrackMapper.read(message, fieldSpec));

      asterixDataBlock.setWgs84Position(
          Wgs84CalculatedTrackPositionMapper.read(message, fieldSpec));

      asterixDataBlock.setCartesianPosition(
          CartesianCalculatedTrackPositionMapper.read(message, fieldSpec));

      asterixDataBlock.setCartesianVelocity(
          CartesianCalculatedTrackVelocityMapper.read(message, fieldSpec));

      asterixDataBlock.setCartesianAcceleration(
          CartesianCalculatedTrackAccelerationMapper.read(message, fieldSpec));

      asterixDataBlock.setMode3Code(TrackMode3ACodeMapper.read(message, fieldSpec));

      asterixDataBlock.setTargetIdentification(TargetIdentificationMapper.read(message, fieldSpec));

      asterixDataBlock.setAircraftDerivedData(AircraftDerivedDataMapper.read(message, fieldSpec));

      asterixDataBlock.setTrackNumber(TrackNumberMapper.readTrackNumber(message, fieldSpec));

      asterixDataBlock.setTrackStatus(TrackStatusMapper.readTrackStatus(message, fieldSpec));

      asterixDataBlock.setSystemTrackUpdateAge(SystemTrackUpdateAgeMapper.read(message, fieldSpec));

      asterixDataBlock.setModeOfMovement(
          ModeOfMovementMapper.readModeOfMovement(message, fieldSpec));

      asterixDataBlock.setTrackDataAge(TrackDataAgeMapper.read(message, fieldSpec));

      asterixDataBlock.setMeasuredFlightLevel(MeasuredFlightLevelMapper.read(message, fieldSpec));

      asterixDataBlock.setTrackGeometricAltitude(
          CalculatedTrackGeometricAltitudeMapper.read(message, fieldSpec));

      asterixDataBlock.setTrackBarometricAltitude(
          CalculatedTrackBarometricAltitudeMapper.read(message, fieldSpec));

      asterixDataBlock.setRateOfClimbOrDescent(
          CalculatedRateOfClimbOrDescentMapper.read(message, fieldSpec));

      asterixDataBlock.setFlightPlanRelatedData(
          FlightPlanRelatedDataMapper.read(message, fieldSpec));

      asterixDataBlock.setTargetSizeAndOrientation(
          TargetSizeAndOrientationMapper.read(message, fieldSpec));

      asterixDataBlock.setVehicleFleetIdentification(
          VehicleFleetIdentificationMapper.read(message, fieldSpec));

      asterixDataBlock.setMode5AndExtendedMode1(Mode5AndMode1Mapper.read(message, fieldSpec));

      asterixDataBlock.setMode2Code(TrackMode2CodeMapper.read(message, fieldSpec));

      asterixDataBlock.setComposedTrackNumber(ComposedTrackNumberMapper.read(message, fieldSpec));

      asterixDataBlock.setEstimatedAccuracy(EstimatedAccuracyMapper.read(message, fieldSpec));

      asterixDataBlock.setMeasuredInformation(MeasuredInformationMapper.read(message, fieldSpec));

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
    int category = AsterixMapper.readCategory(this.message);

    if (AsterixConfig.CAT062_CATEGORY_VALUE != category) {
      System.out.println("非法的CAT062报文,CAT062报文中Category值应该为62,当前报文的Category值为: " + category);
      return null;
    }
    this.uap.setCategory(category);

    int length = AsterixMapper.readLength(this.message);
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
