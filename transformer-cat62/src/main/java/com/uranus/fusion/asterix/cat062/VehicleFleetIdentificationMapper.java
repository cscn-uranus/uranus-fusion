package com.uranus.fusion.asterix.cat062;

import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.FieldSpec;
import com.uranus.fusion.asterix.spec.FpIndicationEnum;
import com.uranus.fusion.asterix.spec.FpIndicator;
import com.uranus.fusion.asterix.uap.vehicle.VehicleFleetEnum;
import com.uranus.fusion.asterix.uap.vehicle.VehicleFleetIdentification;
import com.uranus.fusion.util.IntegerUtil;

import java.util.List;

/**
 * VehicleFleetIdentificationMapper
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
public class VehicleFleetIdentificationMapper {

  public static VehicleFleetIdentification read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.getFpIndicator(Cat062Config.VEHICLE_FLEET_IDENTIFICATION_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(Cat062Config.VEHICLE_FLEET_IDENTIFICATION_SIZE);

      int index = fieldSpec.calculateIndexByFrn(Cat062Config.VEHICLE_FLEET_IDENTIFICATION_FRN);

      VehicleFleetIdentification vehicleFleetIdentification = new VehicleFleetIdentification();

      int vfiValue = IntegerUtil.valueOf(uap.get(index));
      switch (vfiValue) {
        case 1:
          vehicleFleetIdentification.setVehicleFleetEnum(
              VehicleFleetEnum.ATC_EQUIPMENT_MAINTENANCE);
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
        case 0:
        default:
          vehicleFleetIdentification.setVehicleFleetEnum(VehicleFleetEnum.UNKNOWN);
          break;
      }
      return vehicleFleetIdentification;
    }
    return null;
  }
}
