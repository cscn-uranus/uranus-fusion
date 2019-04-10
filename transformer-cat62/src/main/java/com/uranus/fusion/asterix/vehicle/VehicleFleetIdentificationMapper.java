package com.uranus.fusion.asterix.vehicle;

import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.util.IntegerUtil;

import java.util.List;

/**
 * VehicleFleetIdentificationMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/11/13
 */
public class VehicleFleetIdentificationMapper {

  public static VehicleFleetIdentification read(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 23;
    final int size = 1;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(size);

      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      VehicleFleetIdentification vehicleFleetIdentification = new VehicleFleetIdentification();

      int vfiValue = IntegerUtil.valueOf(uap.get(index));
      switch (vfiValue) {
        case 0:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.UNKNOWN);
          break;
        case 1:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.ATC_EQUIPMENT_MAINTENANCE);
          break;
        case 2:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.AIRPORT_MAINTENANCE);
          break;
        case 3:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.FIRE);
          break;
        case 4:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.BIRD_SCARER);
          break;
        case 5:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.SNOW_PLOUGH);
          break;
        case 6:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.RUNWAY_SWEEPER);
          break;
        case 7:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.EMERGENCY);
          break;
        case 8:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.POLICE);
          break;
        case 9:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.BUS);
          break;
        case 10:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.TUG);
          break;
        case 11:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.GRASS_CUTTER);
          break;
        case 12:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.FUEL);
          break;
        case 13:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.BAGGAGE);
          break;
        case 14:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.CATERING);
          break;
        case 15:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.AIRCRAFT_MAINTENANCE);
          break;
        case 16:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.FLYCO);
          break;
        default:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.UNKNOWN);
          break;
      }
      return vehicleFleetIdentification;
    }
    return null;
  }

}
