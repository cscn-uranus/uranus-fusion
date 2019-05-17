package com.uranus.fusion.tfr.cat062.modesel.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author tellxp@github.com
 * @date 2019/5/13 11:30
 */

@Data
public class AircraftDTO implements Serializable {
  private LocalDateTime timeOfTrack;
  private String aircraftAddress;
  private String flightIdentification;
  private Double selectedAltitude;
  private Double finalStateSelectedAltitude;
  private Double trueAirspeed;
  private Double indicatedAirspeed;
  private Double machNumber;
}
