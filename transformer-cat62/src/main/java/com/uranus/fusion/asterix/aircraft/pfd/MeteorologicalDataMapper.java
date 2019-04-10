package com.uranus.fusion.asterix.aircraft.pfd;

import com.uranus.fusion.asterix.aircraft.type.DataValidEnum;
import com.uranus.fusion.asterix.spec.DataSpec;
import com.uranus.fusion.asterix.spec.DpIndicationEnum;
import com.uranus.fusion.asterix.spec.DpIndicator;
import com.uranus.fusion.asterix.util.ByteUtil;
import com.uranus.fusion.asterix.util.DecimalUtil;
import com.uranus.fusion.asterix.util.IntegerUtil;

import java.util.List;

/**
 * MeteorologicalDataMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/26
 */
public class MeteorologicalDataMapper {

  public static MeteorologicalData readMetData(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 20;
    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      dpIndicator.setSize(8);

      int index = dataSpec.calculateOctetIndexByDrn(drn);

      MeteorologicalData meteorologicalData = new MeteorologicalData();

      String windSpeedStatusBit = ByteUtil.toString(uap.get(index)).substring(0, 1);
      meteorologicalData.setWindSpeedStatus(
          zeroBit.equals(windSpeedStatusBit) ? DataValidEnum.NOT_VALID : DataValidEnum.VALID);

      String windDirectionStatusBit = ByteUtil.toString(uap.get(index)).substring(1, 2);
      meteorologicalData.setWindDirectionStatus(
          zeroBit.equals(windDirectionStatusBit) ? DataValidEnum.NOT_VALID : DataValidEnum.VALID);

      String temperatureStatusBit = ByteUtil.toString(uap.get(index)).substring(2, 3);
      meteorologicalData.setTemperatureStatus(
          zeroBit.equals(temperatureStatusBit) ? DataValidEnum.NOT_VALID : DataValidEnum.VALID);

      String turbulenceStatusBit = ByteUtil.toString(uap.get(index)).substring(3, 4);
      meteorologicalData.setTurbulenceStatus(
          zeroBit.equals(turbulenceStatusBit) ? DataValidEnum.NOT_VALID : DataValidEnum.VALID);

      int windSpeedValue = IntegerUtil.valueOf(uap.get(index + 1), uap.get(index + 2));
      double windSpeed = DecimalUtil.multiply(windSpeedValue, 1);
      meteorologicalData.setWindSpeed(windSpeed);

      int windDirectionValue = IntegerUtil.valueOf(uap.get(index + 3), uap.get(index + 4));
      double windDirection = DecimalUtil.multiply(windDirectionValue, 1);
      meteorologicalData.setWindDirection(windDirection);

      int temperatureValue = IntegerUtil.valueOf(uap.get(index + 5), uap.get(index + 6));
      double temperature = DecimalUtil.multiply(temperatureValue, 0.25);
      meteorologicalData.setTemperature(temperature);

      int turbulence = IntegerUtil.valueOf(uap.get(index + 7));
      meteorologicalData.setTurbulence(turbulence);

      return meteorologicalData;
    }
    return null;
  }
}
