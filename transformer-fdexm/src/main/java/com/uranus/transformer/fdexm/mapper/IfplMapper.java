package com.uranus.transformer.fdexm.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uranus.transformer.fdexm.dom.AddmIfplDom;
import com.uranus.transformer.fdexm.dom.AddmRoutePointDom;
import com.uranus.transformer.fdexm.dto.AddmDTO;
import com.uranus.transformer.fdexm.dto.ifpl.FlightDataCoupleStatusEnum;
import com.uranus.transformer.fdexm.dto.ifpl.IfplDTO;
import com.uranus.transformer.fdexm.dto.ifpl.RoutePointDTO;
import com.uranus.transformer.fdexm.dto.ifpl.RoutePointPassEnum;
import com.uranus.transformer.fdexm.util.AddmValidator;
import com.uranus.transformer.fdexm.util.DateTypeEnum;
import com.uranus.transformer.fdexm.util.DateUtil;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IfplMapper
 *
 * @author tellxp@github.com
 * @date 2018/11/23
 */
public class IfplMapper {
  private static final Logger logger = LoggerFactory.getLogger(IfplMapper.class);
  private static final String YES_STR = "Y";
  private static AddmIfplDom toIfplDom(AddmDTO ifplAddmDTO) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      AddmIfplDom ifplDom = mapper.readValue(ifplAddmDTO.getText(), AddmIfplDom.class);

      if (AddmValidator.isValidAddmIfpl(ifplDom)) {
        return ifplDom;
      } else {
        logger.error("从Addm中解析FlightData失败|非法的schema");
        return null;
      }

    } catch (IOException e) {
      logger.error("从Addm中解析AddmIfplDom失败|文件IO错误");
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Dom to DTO
    */
  public static IfplDTO toIfplDTO(AddmDTO addmDTO) {
    AddmIfplDom dom = toIfplDom(addmDTO);


    if (dom == null) {
      return null;
    }
    IfplDTO ifplDTO = new IfplDTO();

    if (dom.getRtepts() != null) {
      ifplDTO.addAllRoutePointDTO(toRoutePointDTOS(dom.getRtepts()));
    }
    // Primary
    ifplDTO.setTitle(dom.getTitle());
    ifplDTO.setSendingTime(DateUtil.String2Time(dom.getFiltim(),DateTypeEnum.TimeToSecond));
    ifplDTO.setSource(dom.getSource());
    ifplDTO.setSourceMessageId(dom.getSourcemsgid());
    ifplDTO.setIfplId(dom.getIfplid());


    // Flight departure
    ifplDTO.setFlightIdentification(dom.getArcid());
    ifplDTO.setActualDepartureAerodrome(dom.getAdep());
    ifplDTO.setActualDestinationAerodrome(dom.getAdes());
    ifplDTO.setEstimatedOffBlockDate(
        DateUtil.String2Date(dom.getEobd(), DateTypeEnum.Date));
    ifplDTO.setEstimatedOffBlockTime(
        DateUtil.String2Time(dom.getEobt(), DateTypeEnum.TimeToMinute));
    ifplDTO.setEstimatedTimeOfArrival(
        DateUtil.String2DateTime(dom.getEta(), DateTypeEnum.DateTimeToSecond));
    ifplDTO.setRouteTrajectory(dom.getRoute());
    ifplDTO.setFlightPlanCurrentStatus(dom.getFpctst());
    ifplDTO.setOriginalActualDestinationAerodrome(dom.getAdesold());
    ifplDTO.setAlternateAerodrome1(dom.getAltrnt1());
    ifplDTO.setAlternateAerodrome2(dom.getAltrnt2());
    ifplDTO.setSsrCode(dom.getSsrcode());
    ifplDTO.setFlightRule(dom.getFltrul());
    ifplDTO.setFlightType(dom.getFlttyp());
    ifplDTO.setActualDepartureDate(DateUtil.String2Date(dom.getAdd(), DateTypeEnum.Date));
    ifplDTO.setActualTimeOfDeparture(
        DateUtil.String2Time(dom.getAtd(), DateTypeEnum.TimeToMinute));
    ifplDTO.setTask(dom.getTask());
    ifplDTO.setRemark(dom.getRmk());
    ifplDTO.setEstimatedElapsedTime(
        DateUtil.String2Time(dom.getTtleet(), DateTypeEnum.TimeToMinute));
    ifplDTO.setDateOfFlight(DateUtil.String2Date(dom.getDof(), DateTypeEnum.ShortDate));

    // Flight enroute
    ifplDTO.setRequestLevel(dom.getRfl());
    ifplDTO.setClearedLevel(dom.getCfl());
    ifplDTO.setHandoffLevel(dom.getXfl());
    ifplDTO.setSpeed(dom.getSpeed());
    ifplDTO.setControlSector(dom.getSector());
    ifplDTO.setInformation(dom.getTxt());
    ifplDTO.setTeam18(dom.getTeam());
    if (YES_STR.equals(dom.getIscouple())) {
      ifplDTO.setCoupleType(FlightDataCoupleStatusEnum.Y);
    } else {
      ifplDTO.setCoupleType(FlightDataCoupleStatusEnum.N);
    }

    // Flight arrival
    ifplDTO.setActualDateOfArrival(DateUtil.String2Date(dom.getAda(), DateTypeEnum.Date));
    ifplDTO.setActualTimeOfArrival(
        DateUtil.String2Time(dom.getAta(), DateTypeEnum.TimeToMinute));

    // Aircraft
    ifplDTO.setAircraftType(dom.getArctyp());
    ifplDTO.setWakeTurbulenceCategory(dom.getWktrc());
    ifplDTO.setAircraftRegistration(dom.getReg());
    ifplDTO.setCommunicationCapabilityCode(dom.getCeqpt());
    ifplDTO.setSurveillanceCapabilityCode(dom.getSeqpt());
    ifplDTO.setNavigationCapabilityCode(dom.getNav());
    ifplDTO.setPerformanceBasedNavigationCapabilityCode(dom.getPbn());
    ifplDTO.setDatalinkCommunicationCapabilityCode(dom.getDat());
    ifplDTO.setSelectiveCallingCode(dom.getSel());
    ifplDTO.setPerformanceProfile(dom.getPer());
    ifplDTO.setAircraftOperator(dom.getOpr());

    return ifplDTO;
  }

  /**
   * DOM to DTO
    */
  private static RoutePointDTO toRoutePointDTO(AddmRoutePointDom dom) {
    RoutePointDTO routePointDTO = new RoutePointDTO();
    routePointDTO.setPointId(dom.getPtid());
    routePointDTO.setFlightLevel(dom.getFl());
    routePointDTO.setEstimatedTimeOver(
        DateUtil.String2DateTime(dom.getEto(), DateTypeEnum.DateTimeToSecond));

    if (YES_STR.equals(dom.getIspass())) {
      routePointDTO.setPassedType(RoutePointPassEnum.Y);
    } else {
      routePointDTO.setPassedType(RoutePointPassEnum.N);
    }
    return routePointDTO;
  }

  /**
   * toRoutePointDTOS
   * @param doms
   * @return
   */
  private static Set<RoutePointDTO> toRoutePointDTOS(List<AddmRoutePointDom> doms) {
    Set<RoutePointDTO> routePointDTOS = new HashSet<>();
    for (AddmRoutePointDom dom : doms) {
      RoutePointDTO routePointDTO = toRoutePointDTO(dom);
      routePointDTOS.add(routePointDTO);
    }
    return routePointDTOS;
  }
}
