package com.uranus.transition.common.asterix.cat062.flightplan;

import com.uranus.transition.common.asterix.cat062.Cat062Config;
import com.uranus.transition.common.asterix.uap.emitter.mode3.PreEmergencyMode3;
import com.uranus.transition.common.asterix.uap.identification.SystemIdentification;
import com.uranus.transition.common.asterix.uap.measure.altitude.FlightLevel;
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
      int beginIndex = fieldSpec.calculateIndexByFrn(Cat062Config.FLIGHT_PLAN_RELATED_DATA_FRN);

      FlightPlanRelatedData flightPlanRelatedData = new FlightPlanRelatedData();

      DataSpecParameter dataSpecParameter = new FlightPlanRelatedDataSpecParameter();
        DataSpec dataSpec = new DataSpec(beginIndex,dataSpecParameter);
      dataSpec.readValue(message);
      flightPlanRelatedData.setDataSpec(dataSpec);

      SystemIdentification fppsIdentificationTag =
          FppsIdentificationTagReader.read(message, dataSpec);
      flightPlanRelatedData.setFppsIdentificationTag(fppsIdentificationTag);

      Callsign callsign = CallsignReader.read(message, dataSpec);
      flightPlanRelatedData.setCallsign(callsign);

      IfpsFlightId ifpsFlightId = IfpsFlightIdReader.read(message, dataSpec);
      flightPlanRelatedData.setIfpsFlightId(ifpsFlightId);

      FlightCategory flightCategory = FlightCategoryReader.read(message, dataSpec);
      flightPlanRelatedData.setFlightCategory(flightCategory);

      TypeOfAircraft typeOfAircraft = TypeOfAircraftReader.read(message, dataSpec);
      flightPlanRelatedData.setTypeOfAircraft(typeOfAircraft);

      WakeTurbulenceCategory wakeTurbulenceCategory =
          WakeTurbulenceCategoryReader.read(message, dataSpec);
      flightPlanRelatedData.setWakeTurbulenceCategory(wakeTurbulenceCategory);

      DepartureAirport departureAirport = DepartureAirportReader.read(message, dataSpec);
      flightPlanRelatedData.setDepartureAirport(departureAirport);

      DestinationAirport destinationAirport = DestinationAirportReader.read(message, dataSpec);
      flightPlanRelatedData.setDestinationAirport(destinationAirport);

      RunwayDesignation runwayDesignation = RunwayDesignationReader.read(message, dataSpec);
      flightPlanRelatedData.setRunwayDesignation(runwayDesignation);

      FlightLevel currentClearedFlightLevel =
          CurrentClearedFlightLevelReader.read(message, dataSpec);
      flightPlanRelatedData.setCurrentClearedFlightLevel(currentClearedFlightLevel);

      ControlPosition currentControlPosition = CurrentControlPositionReader.read(message, dataSpec);
      flightPlanRelatedData.setCurrentControlPosition(currentControlPosition);

      FlightPlanTimeData flightPlanTimeData =
          TimeOfDepartureOrArrivalMapper.read(message, dataSpec);
      flightPlanRelatedData.setFlightPlanTimeData(flightPlanTimeData);

      AircraftStand aircraftStand = AircraftStandReader.read(message, dataSpec);
      flightPlanRelatedData.setAircraftStand(aircraftStand);

      StandStatus standStatus = StandStatusReader.read(message, dataSpec);
      flightPlanRelatedData.setStandStatus(standStatus);

      StandardInstrumentDeparture standardInstrumentDeparture =
          StandardInstrumentDepartureReader.read(message, dataSpec);
      flightPlanRelatedData.setStandardInstrumentDeparture(standardInstrumentDeparture);

      StandardInstrumentArrival standardInstrumentArrival =
          StandardInstrumentArrivalReader.read(message, dataSpec);
      flightPlanRelatedData.setStandardInstrumentArrival(standardInstrumentArrival);

      PreEmergencyMode3 preEmergencyMode3 = PreEmergencyMode3Reader.read(message, dataSpec);
      flightPlanRelatedData.setPreEmergencyMode3(preEmergencyMode3);

      PreEmergencyCallsign preEmergencyCallsign =
          PreEmergencyCallsignReader.read(message, dataSpec);
      flightPlanRelatedData.setPreEmergencyCallsign(preEmergencyCallsign);

      fpIndicator.setSize(dataSpec.calculateTotalSize());
      return flightPlanRelatedData;
    }
    return null;
  }
}
