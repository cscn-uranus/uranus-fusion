package com.uranus.fusion.asterix.cat062.aircraft;

import com.uranus.fusion.asterix.cat062.config.AircraftDerivedDataConfig;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.uap.datainfo.DataValidEnum;
import com.uranus.fusion.asterix.uap.meteorology.MetData;
import com.uranus.fusion.util.ByteUtil;
import com.uranus.fusion.util.DecimalUtil;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * MetDataMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/26
 */
public class MetDataMapper {

  public static MetData read(List<Byte> uap, DataSpec dataSpec) {

    DpIndicator dpIndicator = dataSpec.getDpIndicator(AircraftDerivedDataConfig.MET_DATA_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(AircraftDerivedDataConfig.MET_DATA_SIZE);

      int index = dataSpec.calculateOctetIndexByDrn(AircraftDerivedDataConfig.MET_DATA_DRN);

      MetData metData = new MetData();

      String windSpeedStatusBit = ByteUtil.toString(uap.get(index)).substring(0, 1);
      metData.setWindSpeedStatus(
          ByteUtil.ZERO_BIT.equals(windSpeedStatusBit)
              ? DataValidEnum.NOT_VALID
              : DataValidEnum.VALID);

      String windDirectionStatusBit = ByteUtil.toString(uap.get(index)).substring(1, 2);
      metData.setWindDirectionStatus(
          ByteUtil.ZERO_BIT.equals(windDirectionStatusBit)
              ? DataValidEnum.NOT_VALID
              : DataValidEnum.VALID);

      String temperatureStatusBit = ByteUtil.toString(uap.get(index)).substring(2, 3);
      metData.setTemperatureStatus(
          ByteUtil.ZERO_BIT.equals(temperatureStatusBit)
              ? DataValidEnum.NOT_VALID
              : DataValidEnum.VALID);

      String turbulenceStatusBit = ByteUtil.toString(uap.get(index)).substring(3, 4);
      metData.setTurbulenceStatus(
          ByteUtil.ZERO_BIT.equals(turbulenceStatusBit)
              ? DataValidEnum.NOT_VALID
              : DataValidEnum.VALID);

      int windSpeedValue = IntegerUtil.valueOf(uap.get(index + 1), uap.get(index + 2));
      double windSpeed = DecimalUtil.multiply(windSpeedValue, 1);
      metData.setWindSpeed(windSpeed);

      int windDirectionValue = IntegerUtil.valueOf(uap.get(index + 3), uap.get(index + 4));
      double windDirection = DecimalUtil.multiply(windDirectionValue, 1);
      metData.setWindDirection(windDirection);

      int temperatureValue = IntegerUtil.valueOf(uap.get(index + 5), uap.get(index + 6));
      double temperature = DecimalUtil.multiply(temperatureValue, 0.25);
      metData.setTemperature(temperature);

      int turbulence = IntegerUtil.valueOf(uap.get(index + 7));
      metData.setTurbulence(turbulence);

      return metData;
    }
    return null;
  }
}
