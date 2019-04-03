package com.uranus.tdp.xml.track.mapper;

import com.uranus.tdp.xml.track.dto.FlightTrackDTO;
import com.uranus.tdp.xml.track.entity.FlightTrackDO;
import org.springframework.beans.BeanUtils;

public class FlightTrackMapper {
  public static FlightTrackDO toDO(FlightTrackDTO flightTrackDTO) {
    FlightTrackDO flightTrackDO = new FlightTrackDO();
    BeanUtils.copyProperties(flightTrackDTO, flightTrackDO);
    return flightTrackDO;
  }
}
