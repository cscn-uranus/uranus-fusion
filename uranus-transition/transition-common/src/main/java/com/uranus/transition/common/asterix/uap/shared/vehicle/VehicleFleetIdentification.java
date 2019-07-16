package com.uranus.transition.common.asterix.uap.shared.vehicle;

import lombok.Data;

/**
 * VehicleFleetIdentification
 *
 * <p>Data Item I062/300, Vehicle Fleet Identification
 *
 * Definition: Vehicle fleet identification
 * number.
 *
 * Format: One octet fixed length Data Item.
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/13
 */
@Data
public class VehicleFleetIdentification {

  /**
   * bits 8-1 (VFI) = 0 Unknown = 1 ATC equipment maintenance = 2 Airport maintenance = 3 Fire = 4
   * Bird scarer = 5 Snow plough = 6 Runway sweeper = 7 Emergency = 8 Police = 9 Bus = 10 Tug
   * (push/tow) = 11 Grass cutter = 12 Fuel = 13 Baggage = 14 Catering = 15 Aircraft maintenance =
   * 16 Flyco (follow me)
   */
  private VehicleFleetEnum vehicleFleetEnum;
}
