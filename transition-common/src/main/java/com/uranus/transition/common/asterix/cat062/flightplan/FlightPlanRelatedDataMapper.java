package com.uranus.transition.common.asterix.cat062.flightplan;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.uap.emitter.mode3.PreEmergencyMode3;
import com.uranus.transition.common.asterix.uap.identification.SystemIdentification;
import com.uranus.transition.common.asterix.uap.measure.altitude.FlightLevel;
import com.uranus.transition.common.asterix.cat062.flightplan.sub.*;
import com.uranus.transition.common.asterix.spec.*;
import com.uranus.transition.common.asterix.uap.flightplan.*;

import java.util.List;

/**
 * FlightPlanRelatedDataMapper
 *
 * @author 肖鹏 tellxp@github.com
 */
public class FlightPlanRelatedDataMapper {

  public static FlightPlanRelatedData read(List<Byte> message, FieldSpec fieldSpec) {

    FpIndicator fpIndicator =
        fieldSpec.findFpIndicatorByFrn(Cat062Config.FLIGHT_PLAN_RELATED_DATA_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateIndexByFrn(Cat062Config.FLIGHT_PLAN_RELATED_DATA_FRN);

      FlightPlanRelatedData flightPlanRelatedData = new FlightPlanRelatedData();

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.CAT062_FLIGHT_PLAN_RELATED_DATA);
      dataSpec.readValue(message, index);
      flightPlanRelatedData.setDataSpec(dataSpec);

      SystemIdentification fppsIdentificationTag =
          FppsIdentificationTagMapper.read(message, dataSpec);
      flightPlanRelatedData.setFppsIdentificationTag(fppsIdentificationTag);

      Callsign callsign = CallsignMapper.read(message, dataSpec);
      flightPlanRelatedData.setCallsign(callsign);

      IfpsFlightId ifpsFlightId = IfpsFlightIdMapper.read(message, dataSpec);
      flightPlanRelatedData.setIfpsFlightId(ifpsFlightId);

      FlightCategory flightCategory = FlightCategoryMapper.read(message, dataSpec);
      flightPlanRelatedData.setFlightCategory(flightCategory);

      TypeOfAircraft typeOfAircraft = TypeOfAircraftMapper.read(message, dataSpec);
      flightPlanRelatedData.setTypeOfAircraft(typeOfAircraft);

      WakeTurbulenceCategory wakeTurbulenceCategory =
          WakeTurbulenceCategoryMapper.read(message, dataSpec);
      flightPlanRelatedData.setWakeTurbulenceCategory(wakeTurbulenceCategory);

      DepartureAirport departureAirport = DepartureAirportMapper.read(message, dataSpec);
      flightPlanRelatedData.setDepartureAirport(departureAirport);

      DestinationAirport destinationAirport = DestinationAirportMapper.read(message, dataSpec);
      flightPlanRelatedData.setDestinationAirport(destinationAirport);

      RunwayDesignation runwayDesignation = RunwayDesignationMapper.read(message, dataSpec);
      flightPlanRelatedData.setRunwayDesignation(runwayDesignation);

      FlightLevel currentClearedFlightLevel =
          CurrentClearedFlightLevelMapper.read(message, dataSpec);
      flightPlanRelatedData.setCurrentClearedFlightLevel(currentClearedFlightLevel);

      ControlPosition currentControlPosition = CurrentControlPositionMapper.read(message, dataSpec);
      flightPlanRelatedData.setCurrentControlPosition(currentControlPosition);

      FlightPlanTimeData flightPlanTimeData =
          TimeOfDepartureOrArrivalMapper.read(message, dataSpec);
      flightPlanRelatedData.setFlightPlanTimeData(flightPlanTimeData);

      AircraftStand aircraftStand = AircraftStandMapper.read(message, dataSpec);
      flightPlanRelatedData.setAircraftStand(aircraftStand);

      StandStatus standStatus = StandStatusMapper.read(message, dataSpec);
      flightPlanRelatedData.setStandStatus(standStatus);

      StandardInstrumentDeparture standardInstrumentDeparture =
          StandardInstrumentDepartureMapper.read(message, dataSpec);
      flightPlanRelatedData.setStandardInstrumentDeparture(standardInstrumentDeparture);

      StandardInstrumentArrival standardInstrumentArrival =
          StandardInstrumentArrivalMapper.read(message, dataSpec);
      flightPlanRelatedData.setStandardInstrumentArrival(standardInstrumentArrival);

      PreEmergencyMode3 preEmergencyMode3 = PreEmergencyMode3Mapper.read(message, dataSpec);
      flightPlanRelatedData.setPreEmergencyMode3(preEmergencyMode3);

      PreEmergencyCallsign preEmergencyCallsign =
          PreEmergencyCallsignMapper.read(message, dataSpec);
      flightPlanRelatedData.setPreEmergencyCallsign(preEmergencyCallsign);

      fpIndicator.setSize(dataSpec.calculateTotalSize());
      return flightPlanRelatedData;
    }
    return null;
  }
}
