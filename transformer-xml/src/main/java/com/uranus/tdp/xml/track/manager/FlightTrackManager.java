package com.uranus.tdp.xml.track.manager;

import com.uranus.tdp.xml.track.dto.FlightTrackDTO;
import com.uranus.tdp.xml.track.entity.FlightTrackDO;
import com.uranus.tdp.xml.track.mapper.FlightTrackMapper;
import com.uranus.tdp.xml.util.DateUtil;
import org.springframework.stereotype.Service;

@Service
public class FlightTrackManager {
  private  final FlightTrackRepo flightTrackRepo;

  public FlightTrackManager(FlightTrackRepo flightTrackRepo) {
    this.flightTrackRepo = flightTrackRepo;
  }

  public void saveFlightTrackDTO(FlightTrackDTO flightTrackDTO) {
    FlightTrackDO flightTrackDO = FlightTrackMapper.toDO(flightTrackDTO);
    flightTrackDO.setPersistTime(DateUtil.now());
    flightTrackDO.setUpdateTime(DateUtil.now());
    this.flightTrackRepo.save(flightTrackDO);
  }
}
