package com.uranus.fusion.common.asterix.flightplan;

import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.DpIndicator;
import com.uranus.fusion.common.asterix.util.ByteUtil;
import com.uranus.fusion.common.asterix.util.IntegerUtil;
import com.uranus.fusion.common.asterix.aircraft.type.DataAvailableEnum;

import java.util.List;

/**
 * FlightPlanTimeDataMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/12
 */
public class FlightPlanTimeDataMapper {

  public static FlightPlanTimeData read(List<Byte> uap, DataSpec dataSpec) {
    final int drn = 12;
    final int repeatStep = 4;

    final String zeroBit = "0";

    DpIndicator dpIndicator = dataSpec.getDpIndicator(drn);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index = dataSpec.calculateOctetIndexByDrn(drn);

      FlightPlanTimeData flightPlanTimeData = new FlightPlanTimeData();
      final int repNum = IntegerUtil.valueOf(uap.get(index));
      flightPlanTimeData.setRepeatIndicator(repNum);

      for (int i = 0; i < repNum; i++) {
        FlightPlanTime flightPlanTime = new FlightPlanTime();

        // region typBits
        String typBits = ByteUtil.toString(uap.get(index + 1)).substring(0, 5);
        int typValue = IntegerUtil.valueOf(ByteUtil.valueOf(typBits));
        switch (typValue) {
          case 0:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.SOBT);
            break;
          case 1:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.EOBT);
            break;
          case 2:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.ETOT);
            break;
          case 3:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.AOBT);
            break;
          case 4:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.PTRH);
            break;
          case 5:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.ATRH);
            break;
          case 6:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.ALUT);
            break;
          case 7:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.ATOT);
            break;
          case 8:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.ETA);
            break;
          case 9:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.PLDT);
            break;
          case 10:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.ALDT);
            break;
          case 11:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.ATOR);
            break;
          case 12:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.PTTG);
            break;
          case 13:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.AIBT);
            break;
          default:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.SOBT);
            break;
        }
        // endregion

        // region dayBits
        String dayBits = ByteUtil.toString(uap.get(index+1)).substring(5, 7);
        switch (dayBits) {
          case "00":
            flightPlanTime.setFlightPlanDayEnum(FlightPlanDayEnum.TODAY);
            break;
          case "01":
            flightPlanTime.setFlightPlanDayEnum(FlightPlanDayEnum.YESTERDAY);
            break;
          case "10":
            flightPlanTime.setFlightPlanDayEnum(FlightPlanDayEnum.TOMORROW);
            break;
          case "11":
            flightPlanTime.setFlightPlanDayEnum(FlightPlanDayEnum.INVALID);
            break;
          default:
            flightPlanTime.setFlightPlanDayEnum(FlightPlanDayEnum.INVALID);
            break;
        }
        // endregion

        String horBits = ByteUtil.toString(uap.get(index + 2)).substring(3, 8);
        int hour = IntegerUtil.valueOf(ByteUtil.valueOf(horBits));
        flightPlanTime.setHour(hour);

        String minBits = ByteUtil.toString(uap.get(index + 3)).substring(2, 8);
        int minute = IntegerUtil.valueOf(ByteUtil.valueOf(minBits));
        flightPlanTime.setMinute(minute);

        String avsBit = ByteUtil.toString(uap.get(index + 4)).substring(0, 1);
        flightPlanTime.setSecondAvailableStatus(
            zeroBit.equals(avsBit) ? DataAvailableEnum.AVAILABLE : DataAvailableEnum.NOT_AVAILABLE);

        String secBits = ByteUtil.toString(uap.get(index + 4)).substring(2, 8);
        int second = IntegerUtil.valueOf(ByteUtil.valueOf(secBits));
        flightPlanTime.setSecond(second);

        flightPlanTimeData.add(flightPlanTime);
        index += repeatStep;
      }

      dpIndicator.setSize(repNum * repeatStep + 1);

      return flightPlanTimeData;
    }
    return null;
  }
}
