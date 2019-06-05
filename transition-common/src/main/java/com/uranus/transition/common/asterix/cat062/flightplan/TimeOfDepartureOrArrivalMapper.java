package com.uranus.transition.common.asterix.cat062.flightplan;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.spec.DpIndicationEnum;
import com.uranus.transition.common.asterix.spec.DpIndicator;
import com.uranus.transition.common.asterix.uap.datainfo.DataAvailableEnum;
import com.uranus.transition.common.asterix.uap.flightplan.FlightPlanDayEnum;
import com.uranus.transition.common.asterix.uap.flightplan.FlightPlanTime;
import com.uranus.transition.common.asterix.uap.flightplan.FlightPlanTimeData;
import com.uranus.transition.common.asterix.uap.flightplan.FlightPlanTimeTypeEnum;
import com.uranus.transition.common.util.ByteUtil;
import com.uranus.transition.common.util.IntegerUtil;

import java.util.List;

/**
 * TimeOfDepartureOrArrivalMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/12
 */
public class TimeOfDepartureOrArrivalMapper {

  public static FlightPlanTimeData read(List<Byte> uap, DataSpec dataSpec) {
    DpIndicator dpIndicator =
        dataSpec.getDpIndicator(FlightPlanRelatedDataConfig.TIME_OF_DEPARTURE_OR_ARRIVAL_DRN);
    if (dpIndicator.getIndication().equals(DpIndicationEnum.PRESENCE)) {
      int index =
          dataSpec.calculateOctetIndexByDrn(
              FlightPlanRelatedDataConfig.TIME_OF_DEPARTURE_OR_ARRIVAL_DRN);

      FlightPlanTimeData flightPlanTimeData = new FlightPlanTimeData();
      final int repNum = IntegerUtil.unsignedValueOf(uap.get(index));
      flightPlanTimeData.setRepeatIndicator(repNum);

      for (int i = 0; i < repNum; i++) {
        FlightPlanTime flightPlanTime = new FlightPlanTime();

        // region typBits
        String typBits = ByteUtil.toString(uap.get(index + 1)).substring(0, 5);
        int typValue = IntegerUtil.unsignedValueOf(ByteUtil.unsignedValueOf(typBits));
        switch (typValue) {
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
          case 0:
          default:
            flightPlanTime.setFlightPlanTimeTypeEnum(FlightPlanTimeTypeEnum.SOBT);
            break;
        }
        // endregion

        // region dayBits
        String dayBits = ByteUtil.toString(uap.get(index + 1)).substring(5, 7);
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
          default:
            flightPlanTime.setFlightPlanDayEnum(FlightPlanDayEnum.INVALID);
            break;
        }
        // endregion

        String horBits = ByteUtil.toString(uap.get(index + 2)).substring(3, 8);
        int hour = IntegerUtil.unsignedValueOf(ByteUtil.unsignedValueOf(horBits));
        flightPlanTime.setHour(hour);

        String minBits = ByteUtil.toString(uap.get(index + 3)).substring(2, 8);
        int minute = IntegerUtil.unsignedValueOf(ByteUtil.unsignedValueOf(minBits));
        flightPlanTime.setMinute(minute);

        String avsBit = ByteUtil.toString(uap.get(index + 4)).substring(0, 1);
        flightPlanTime.setSecondAvailableStatus(
            ByteUtil.ZERO_BIT.equals(avsBit)
                ? DataAvailableEnum.AVAILABLE
                : DataAvailableEnum.NOT_AVAILABLE);

        String secBits = ByteUtil.toString(uap.get(index + 4)).substring(2, 8);
        int second = IntegerUtil.unsignedValueOf(ByteUtil.unsignedValueOf(secBits));
        flightPlanTime.setSecond(second);

        flightPlanTimeData.add(flightPlanTime);
        index += FlightPlanRelatedDataConfig.TIME_OF_DEPARTURE_OR_ARRIVAL_REPEAT_SIZE;
      }

      dpIndicator.setSize(
          repNum * FlightPlanRelatedDataConfig.TIME_OF_DEPARTURE_OR_ARRIVAL_REPEAT_SIZE + 1);

      return flightPlanTimeData;
    }
    return null;
  }
}
