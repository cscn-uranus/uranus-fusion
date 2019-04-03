package com.uranus.tdp.xml.track.manager;

import com.uranus.tdp.xml.track.entity.FlightTrackDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightTrackRepo extends JpaRepository<FlightTrackDO, String> {

}
