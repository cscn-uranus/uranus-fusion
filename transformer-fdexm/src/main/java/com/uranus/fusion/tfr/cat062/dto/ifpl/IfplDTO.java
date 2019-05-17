package com.uranus.fusion.tfr.cat062.dto.ifpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * IfplDTO
 *
 * @author tellxp@github.com
 * @date 2018/11/23
 */
public class IfplDTO {

  /**
   * Primary
   */
  private String title;
  private LocalTime sendingTime;
  private String source;
  private String sourceMessageId;
  private String ifplId;

  /**
   * RoutePoints
   */
  private Set<RoutePointDTO> routePointDTOS;

  /**
   * Flight departure
   */
  private String flightIdentification;

  private String actualDepartureAerodrome;

  private String actualDestinationAerodrome;

  private LocalDate estimatedOffBlockDate;

  private LocalTime estimatedOffBlockTime;

  private LocalDateTime estimatedTimeOfArrival;

  private String routeTrajectory;

  private String flightPlanCurrentStatus;

  private String originalActualDestinationAerodrome;

  private String alternateAerodrome1;

  private String alternateAerodrome2;

  private String ssrCode;

  private String flightRule;

  private String flightType;

  private LocalDate actualDepartureDate;

  private LocalTime actualTimeOfDeparture;

  private String task;

  private String remark;

  private LocalTime estimatedElapsedTime;

  private LocalDate dateOfFlight;

  /**
   * Flight enroute
   */
  private String requestLevel;

  private String clearedLevel;

  private String handoffLevel;

  private String speed;

  private String controlSector;

  private String information;

  private String team18;

  private FlightDataCoupleStatusEnum coupleType;

  /**
   * Flight arrival
   */
  private LocalDate actualDateOfArrival;

  private LocalTime actualTimeOfArrival;

  /**
   * Aircraft
   */

  private String aircraftIdentification;

  private String aircraftType;

  private String wakeTurbulenceCategory;

  private String aircraftRegistration;

  private String communicationCapabilityCode;

  private String surveillanceCapabilityCode;

  private String navigationCapabilityCode;

  private String performanceBasedNavigationCapabilityCode;

  private String datalinkCommunicationCapabilityCode;

  private String selectiveCallingCode;

  private String performanceProfile;

  private String aircraftOperator;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalTime getSendingTime() {
    return sendingTime;
  }

  public void setSendingTime(LocalTime sendingTime) {
    this.sendingTime = sendingTime;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getSourceMessageId() {
    return sourceMessageId;
  }

  public void setSourceMessageId(String sourceMessageId) {
    this.sourceMessageId = sourceMessageId;
  }

  public String getIfplId() {
    return ifplId;
  }

  public void setIfplId(String ifplId) {
    this.ifplId = ifplId;
  }

  public Set<RoutePointDTO> getRoutePointDTOS() {
    return routePointDTOS;
  }

  public void setRoutePointDTOS(
      Set<RoutePointDTO> routePointDTOS) {
    this.routePointDTOS = routePointDTOS;
  }

  public String getFlightIdentification() {
    return flightIdentification;
  }

  public void setFlightIdentification(String flightIdentification) {
    this.flightIdentification = flightIdentification;
  }

  public String getActualDepartureAerodrome() {
    return actualDepartureAerodrome;
  }

  public void setActualDepartureAerodrome(String actualDepartureAerodrome) {
    this.actualDepartureAerodrome = actualDepartureAerodrome;
  }

  public String getActualDestinationAerodrome() {
    return actualDestinationAerodrome;
  }

  public void setActualDestinationAerodrome(String actualDestinationAerodrome) {
    this.actualDestinationAerodrome = actualDestinationAerodrome;
  }

  public LocalDate getEstimatedOffBlockDate() {
    return estimatedOffBlockDate;
  }

  public void setEstimatedOffBlockDate(LocalDate estimatedOffBlockDate) {
    this.estimatedOffBlockDate = estimatedOffBlockDate;
  }

  public LocalTime getEstimatedOffBlockTime() {
    return estimatedOffBlockTime;
  }

  public void setEstimatedOffBlockTime(LocalTime estimatedOffBlockTime) {
    this.estimatedOffBlockTime = estimatedOffBlockTime;
  }

  public LocalDateTime getEstimatedTimeOfArrival() {
    return estimatedTimeOfArrival;
  }

  public void setEstimatedTimeOfArrival(LocalDateTime estimatedTimeOfArrival) {
    this.estimatedTimeOfArrival = estimatedTimeOfArrival;
  }

  public String getRouteTrajectory() {
    return routeTrajectory;
  }

  public void setRouteTrajectory(String routeTrajectory) {
    this.routeTrajectory = routeTrajectory;
  }

  public String getFlightPlanCurrentStatus() {
    return flightPlanCurrentStatus;
  }

  public void setFlightPlanCurrentStatus(String flightPlanCurrentStatus) {
    this.flightPlanCurrentStatus = flightPlanCurrentStatus;
  }

  public String getOriginalActualDestinationAerodrome() {
    return originalActualDestinationAerodrome;
  }

  public void setOriginalActualDestinationAerodrome(String originalActualDestinationAerodrome) {
    this.originalActualDestinationAerodrome = originalActualDestinationAerodrome;
  }

  public String getAlternateAerodrome1() {
    return alternateAerodrome1;
  }

  public void setAlternateAerodrome1(String alternateAerodrome1) {
    this.alternateAerodrome1 = alternateAerodrome1;
  }

  public String getAlternateAerodrome2() {
    return alternateAerodrome2;
  }

  public void setAlternateAerodrome2(String alternateAerodrome2) {
    this.alternateAerodrome2 = alternateAerodrome2;
  }

  public String getSsrCode() {
    return ssrCode;
  }

  public void setSsrCode(String ssrCode) {
    this.ssrCode = ssrCode;
  }

  public String getFlightRule() {
    return flightRule;
  }

  public void setFlightRule(String flightRule) {
    this.flightRule = flightRule;
  }

  public String getFlightType() {
    return flightType;
  }

  public void setFlightType(String flightType) {
    this.flightType = flightType;
  }

  public LocalDate getActualDepartureDate() {
    return actualDepartureDate;
  }

  public void setActualDepartureDate(LocalDate actualDepartureDate) {
    this.actualDepartureDate = actualDepartureDate;
  }

  public LocalTime getActualTimeOfDeparture() {
    return actualTimeOfDeparture;
  }

  public void setActualTimeOfDeparture(LocalTime actualTimeOfDeparture) {
    this.actualTimeOfDeparture = actualTimeOfDeparture;
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public LocalDate getDateOfFlight() {
    return dateOfFlight;
  }

  public void setDateOfFlight(LocalDate dateOfFlight) {
    this.dateOfFlight = dateOfFlight;
  }

  public LocalTime getEstimatedElapsedTime() {
    return estimatedElapsedTime;
  }

  public void setEstimatedElapsedTime(LocalTime estimatedElapsedTime) {
    this.estimatedElapsedTime = estimatedElapsedTime;
  }

  public String getRequestLevel() {
    return requestLevel;
  }

  public void setRequestLevel(String requestLevel) {
    this.requestLevel = requestLevel;
  }

  public String getClearedLevel() {
    return clearedLevel;
  }

  public void setClearedLevel(String clearedLevel) {
    this.clearedLevel = clearedLevel;
  }

  public String getHandoffLevel() {
    return handoffLevel;
  }

  public void setHandoffLevel(String handoffLevel) {
    this.handoffLevel = handoffLevel;
  }

  public String getSpeed() {
    return speed;
  }

  public void setSpeed(String speed) {
    this.speed = speed;
  }

  public String getControlSector() {
    return controlSector;
  }

  public void setControlSector(String controlSector) {
    this.controlSector = controlSector;
  }

  public String getInformation() {
    return information;
  }

  public void setInformation(String information) {
    this.information = information;
  }

  public String getTeam18() {
    return team18;
  }

  public void setTeam18(String team18) {
    this.team18 = team18;
  }

  public FlightDataCoupleStatusEnum getCoupleType() {
    return coupleType;
  }

  public void setCoupleType(FlightDataCoupleStatusEnum coupleType) {
    this.coupleType = coupleType;
  }

  public LocalDate getActualDateOfArrival() {
    return actualDateOfArrival;
  }

  public void setActualDateOfArrival(LocalDate actualDateOfArrival) {
    this.actualDateOfArrival = actualDateOfArrival;
  }

  public LocalTime getActualTimeOfArrival() {
    return actualTimeOfArrival;
  }

  public void setActualTimeOfArrival(LocalTime actualTimeOfArrival) {
    this.actualTimeOfArrival = actualTimeOfArrival;
  }

  public String getAircraftIdentification() {
    return aircraftIdentification;
  }

  public void setAircraftIdentification(String aircraftIdentification) {
    this.aircraftIdentification = aircraftIdentification;
  }

  public String getAircraftType() {
    return aircraftType;
  }

  public void setAircraftType(String aircraftType) {
    this.aircraftType = aircraftType;
  }

  public String getWakeTurbulenceCategory() {
    return wakeTurbulenceCategory;
  }

  public void setWakeTurbulenceCategory(String wakeTurbulenceCategory) {
    this.wakeTurbulenceCategory = wakeTurbulenceCategory;
  }

  public String getAircraftRegistration() {
    return aircraftRegistration;
  }

  public void setAircraftRegistration(String aircraftRegistration) {
    this.aircraftRegistration = aircraftRegistration;
  }

  public String getCommunicationCapabilityCode() {
    return communicationCapabilityCode;
  }

  public void setCommunicationCapabilityCode(String communicationCapabilityCode) {
    this.communicationCapabilityCode = communicationCapabilityCode;
  }

  public String getSurveillanceCapabilityCode() {
    return surveillanceCapabilityCode;
  }

  public void setSurveillanceCapabilityCode(String surveillanceCapabilityCode) {
    this.surveillanceCapabilityCode = surveillanceCapabilityCode;
  }

  public String getNavigationCapabilityCode() {
    return navigationCapabilityCode;
  }

  public void setNavigationCapabilityCode(String navigationCapabilityCode) {
    this.navigationCapabilityCode = navigationCapabilityCode;
  }

  public String getPerformanceBasedNavigationCapabilityCode() {
    return performanceBasedNavigationCapabilityCode;
  }

  public void setPerformanceBasedNavigationCapabilityCode(
      String performanceBasedNavigationCapabilityCode) {
    this.performanceBasedNavigationCapabilityCode = performanceBasedNavigationCapabilityCode;
  }

  public String getDatalinkCommunicationCapabilityCode() {
    return datalinkCommunicationCapabilityCode;
  }

  public void setDatalinkCommunicationCapabilityCode(String datalinkCommunicationCapabilityCode) {
    this.datalinkCommunicationCapabilityCode = datalinkCommunicationCapabilityCode;
  }

  public String getSelectiveCallingCode() {
    return selectiveCallingCode;
  }

  public void setSelectiveCallingCode(String selectiveCallingCode) {
    this.selectiveCallingCode = selectiveCallingCode;
  }

  public String getPerformanceProfile() {
    return performanceProfile;
  }

  public void setPerformanceProfile(String performanceProfile) {
    this.performanceProfile = performanceProfile;
  }

  public String getAircraftOperator() {
    return aircraftOperator;
  }

  public void setAircraftOperator(String aircraftOperator) {
    this.aircraftOperator = aircraftOperator;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof IfplDTO)) {
      return false;
    }
    IfplDTO that = (IfplDTO) o;
    return
        Objects.equals(routePointDTOS, that.routePointDTOS) &&
            Objects.equals(flightIdentification, that.flightIdentification) &&
            Objects.equals(actualDepartureAerodrome, that.actualDepartureAerodrome) &&
            Objects.equals(actualDestinationAerodrome, that.actualDestinationAerodrome) &&
            Objects.equals(estimatedOffBlockDate, that.estimatedOffBlockDate) &&
            Objects.equals(estimatedOffBlockTime, that.estimatedOffBlockTime) &&
            Objects.equals(estimatedTimeOfArrival, that.estimatedTimeOfArrival) &&
            Objects.equals(routeTrajectory, that.routeTrajectory) &&
            Objects.equals(flightPlanCurrentStatus, that.flightPlanCurrentStatus) &&
            Objects
                .equals(originalActualDestinationAerodrome, that.originalActualDestinationAerodrome)
            &&
            Objects.equals(alternateAerodrome1, that.alternateAerodrome1) &&
            Objects.equals(alternateAerodrome2, that.alternateAerodrome2) &&
            Objects.equals(ssrCode, that.ssrCode) &&
            Objects.equals(flightRule, that.flightRule) &&
            Objects.equals(flightType, that.flightType) &&
            Objects.equals(actualDepartureDate, that.actualDepartureDate) &&
            Objects.equals(actualTimeOfDeparture, that.actualTimeOfDeparture) &&
            Objects.equals(task, that.task) &&
            Objects.equals(remark, that.remark) &&
            Objects.equals(estimatedElapsedTime, that.estimatedElapsedTime) &&
            Objects.equals(dateOfFlight, that.dateOfFlight) &&
            Objects.equals(requestLevel, that.requestLevel) &&
            Objects.equals(clearedLevel, that.clearedLevel) &&
            Objects.equals(handoffLevel, that.handoffLevel) &&
            Objects.equals(speed, that.speed) &&
            Objects.equals(controlSector, that.controlSector) &&
            Objects.equals(information, that.information) &&
            Objects.equals(team18, that.team18) &&
            coupleType == that.coupleType &&
            Objects.equals(actualDateOfArrival, that.actualDateOfArrival) &&
            Objects.equals(actualTimeOfArrival, that.actualTimeOfArrival) &&
            Objects.equals(aircraftIdentification, that.aircraftIdentification) &&
            Objects.equals(aircraftType, that.aircraftType) &&
            Objects.equals(wakeTurbulenceCategory, that.wakeTurbulenceCategory) &&
            Objects.equals(aircraftRegistration, that.aircraftRegistration) &&
            Objects.equals(communicationCapabilityCode, that.communicationCapabilityCode) &&
            Objects.equals(surveillanceCapabilityCode, that.surveillanceCapabilityCode) &&
            Objects.equals(navigationCapabilityCode, that.navigationCapabilityCode) &&
            Objects.equals(performanceBasedNavigationCapabilityCode,
                that.performanceBasedNavigationCapabilityCode) &&
            Objects
                .equals(datalinkCommunicationCapabilityCode,
                    that.datalinkCommunicationCapabilityCode)
            &&
            Objects.equals(selectiveCallingCode, that.selectiveCallingCode) &&
            Objects.equals(performanceProfile, that.performanceProfile) &&
            Objects.equals(aircraftOperator, that.aircraftOperator);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(routePointDTOS, flightIdentification, actualDepartureAerodrome,
            actualDestinationAerodrome, estimatedOffBlockDate, estimatedOffBlockTime,
            estimatedTimeOfArrival, routeTrajectory, flightPlanCurrentStatus,
            originalActualDestinationAerodrome, alternateAerodrome1, alternateAerodrome2, ssrCode,
            flightRule, flightType, actualDepartureDate, actualTimeOfDeparture, task, remark,
            estimatedElapsedTime, dateOfFlight, requestLevel, clearedLevel, handoffLevel, speed,
            controlSector, information, team18, coupleType, actualDateOfArrival,
            actualTimeOfArrival,
            aircraftIdentification, aircraftType, wakeTurbulenceCategory, aircraftRegistration,
            communicationCapabilityCode, surveillanceCapabilityCode, navigationCapabilityCode,
            performanceBasedNavigationCapabilityCode, datalinkCommunicationCapabilityCode,
            selectiveCallingCode, performanceProfile, aircraftOperator);
  }

  @Override
  public String toString() {
    return "IfplDTO{" +
        "routePointDTOS=" + routePointDTOS +
        ", flightIdentification='" + flightIdentification + '\'' +
        ", actualDepartureAerodrome='" + actualDepartureAerodrome + '\'' +
        ", actualDestinationAerodrome='" + actualDestinationAerodrome + '\'' +
        ", estimatedOffBlockDate=" + estimatedOffBlockDate +
        ", estimatedOffBlockTime=" + estimatedOffBlockTime +
        ", estimatedTimeOfArrival=" + estimatedTimeOfArrival +
        ", routeTrajectory='" + routeTrajectory + '\'' +
        ", flightPlanCurrentStatus='" + flightPlanCurrentStatus + '\'' +
        ", originalActualDestinationAerodrome='" + originalActualDestinationAerodrome + '\'' +
        ", alternateAerodrome1='" + alternateAerodrome1 + '\'' +
        ", alternateAerodrome2='" + alternateAerodrome2 + '\'' +
        ", ssrCode='" + ssrCode + '\'' +
        ", flightRule='" + flightRule + '\'' +
        ", flightType='" + flightType + '\'' +
        ", actualDepartureDate=" + actualDepartureDate +
        ", actualTimeOfDeparture=" + actualTimeOfDeparture +
        ", task='" + task + '\'' +
        ", remark='" + remark + '\'' +
        ", estimatedElapsedTime=" + estimatedElapsedTime +
        ", dateOfFlight=" + dateOfFlight +
        ", requestLevel='" + requestLevel + '\'' +
        ", clearedLevel='" + clearedLevel + '\'' +
        ", handoffLevel='" + handoffLevel + '\'' +
        ", speed='" + speed + '\'' +
        ", controlSector='" + controlSector + '\'' +
        ", information='" + information + '\'' +
        ", team18='" + team18 + '\'' +
        ", coupleType=" + coupleType +
        ", actualDateOfArrival=" + actualDateOfArrival +
        ", actualTimeOfArrival=" + actualTimeOfArrival +
        ", aircraftIdentification='" + aircraftIdentification + '\'' +
        ", aircraftType='" + aircraftType + '\'' +
        ", wakeTurbulenceCategory='" + wakeTurbulenceCategory + '\'' +
        ", aircraftRegistration='" + aircraftRegistration + '\'' +
        ", communicationCapabilityCode='" + communicationCapabilityCode + '\'' +
        ", surveillanceCapabilityCode='" + surveillanceCapabilityCode + '\'' +
        ", navigationCapabilityCode='" + navigationCapabilityCode + '\'' +
        ", performanceBasedNavigationCapabilityCode='" + performanceBasedNavigationCapabilityCode
        + '\'' +
        ", datalinkCommunicationCapabilityCode='" + datalinkCommunicationCapabilityCode + '\'' +
        ", selectiveCallingCode='" + selectiveCallingCode + '\'' +
        ", performanceProfile='" + performanceProfile + '\'' +
        ", aircraftOperator='" + aircraftOperator + '\'' +
        '}';
  }

  public IfplDTO() {
    this.routePointDTOS = new HashSet<>();
  }

  public void addRoutePointDTO(RoutePointDTO routePointDTO) {
    this.routePointDTOS.add(routePointDTO);
  }

  public void addAllRoutePointDTO(Set<RoutePointDTO> routePointDTOS) {
    for (RoutePointDTO routePointDTO : routePointDTOS) {
      this.addRoutePointDTO(routePointDTO);
    }
  }

  public void removeRoutePointDTO(RoutePointDTO routePointDTO) {
    this.routePointDTOS.remove(routePointDTO);
  }

  public void removeAllRoutePointDTO(Set<RoutePointDTO> routePointDTOS) {
    for (RoutePointDTO routePointDTO : routePointDTOS) {
      this.removeRoutePointDTO(routePointDTO);
    }
  }
}
