package com.uranus.tdp.xml.track.mapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.uranus.tdp.xml.track.dom.FlightTrackDom;
import com.uranus.tdp.xml.track.dto.FlightTrackDTO;
import com.uranus.tdp.xml.util.DateTypeEnum;
import com.uranus.tdp.xml.util.DateUtil;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightTrackDomMapper {

  private static final Logger logger = LoggerFactory.getLogger(FlightTrackDomMapper.class);

  private static FlightTrackDom toFlightTrackDom(String flightTrackText) {
    XmlMapper xmlMapper = new XmlMapper();
    flightTrackText = flightTrackText.replaceAll("[\\u0000-\\u001F]+", "");
    try {
      return xmlMapper.readValue(flightTrackText, FlightTrackDom.class);
    } catch (IOException e) {
      logger.error(e.getMessage());
      return null;
    }
  }

  public static FlightTrackDTO toDTO(String flightTrackText) {
    FlightTrackDom dom = toFlightTrackDom(flightTrackText);
    if (dom == null) {
      return null;
    }
    FlightTrackDTO flightTrackDTO = new FlightTrackDTO();

    // Primary
    flightTrackDTO.setDataSource(dom.getDataSource());
    flightTrackDTO.setDataType(dom.getDataType());
    flightTrackDTO.setTimestamp(DateUtil.String2Date(dom.getTimeStamp(), DateTypeEnum.FOURTEEN));

    // Position
    flightTrackDTO.setReportTrackId(dom.getPositionReportDom().getTrackId());
    flightTrackDTO.setFlightIdentification(dom.getPositionReportDom().getCallSign());
    flightTrackDTO.setAircraftRegistration(dom.getPositionReportDom().getRegId());
    flightTrackDTO.setSsrCode(dom.getPositionReportDom().getRspId());
    flightTrackDTO.setGroundSpeed(dom.getPositionReportDom().getGroundSpeed());
    flightTrackDTO.setHeight(dom.getPositionReportDom().getHeight());
    flightTrackDTO.setAltitude(dom.getPositionReportDom().getAltitude());
    flightTrackDTO.setLongitude(dom.getPositionReportDom().getLongitude());
    flightTrackDTO.setLatitude(dom.getPositionReportDom().getLatitude());
    flightTrackDTO.setVector(dom.getPositionReportDom().getVector());
    flightTrackDTO.setVerticalRate(dom.getPositionReportDom().getVerticalRate());

    return flightTrackDTO;
  }
}
