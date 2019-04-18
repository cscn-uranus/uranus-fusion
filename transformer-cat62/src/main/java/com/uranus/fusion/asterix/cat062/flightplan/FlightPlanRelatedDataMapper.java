package com.uranus.fusion.asterix.cat062.flightplan;

import com.uranus.fusion.asterix.cat062.config.Cat062Config;
import com.uranus.fusion.asterix.spec.*;
import com.uranus.fusion.asterix.uap.emitter.mode3.PreEmergencyMode3;
import com.uranus.fusion.asterix.uap.flightplan.*;
import com.uranus.fusion.asterix.uap.identification.SystemIdentification;
import com.uranus.fusion.asterix.uap.measure.altitude.FlightLevel;

import java.util.List;

/**
 * FlightPlanRelatedDataMapper
 *
 * @author 肖鹏 tellxp@github.com
 */
public class FlightPlanRelatedDataMapper {

  public static FlightPlanRelatedData read(List<Byte> uap, FieldSpec fieldSpec) {

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(Cat062Config.FLIGHT_PLAN_RELATED_DATA_FRN);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateIndexByFrn(Cat062Config.FLIGHT_PLAN_RELATED_DATA_FRN);

      FlightPlanRelatedData flightPlanRelatedData = new FlightPlanRelatedData();

      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.CAT062_FLIGHT_PLAN_RELATED_DATA);
      dataSpec.readValue(uap, index);
      flightPlanRelatedData.setDataSpec(dataSpec);

      SystemIdentification fppsIdentificationTag = FppsIdentificationTagMapper.read(uap, dataSpec);
      flightPlanRelatedData.setFppsIdentificationTag(fppsIdentificationTag);

      Callsign callsign = CallsignMapper.read(uap, dataSpec);
      flightPlanRelatedData.setCallsign(callsign);

      IfpsFlightId ifpsFlightId = IfpsFlightIdMapper.read(uap, dataSpec);
      flightPlanRelatedData.setIfpsFlightId(ifpsFlightId);

      FlightCategory flightCategory = FlightCategoryMapper.read(uap, dataSpec);
      flightPlanRelatedData.setFlightCategory(flightCategory);

      AircraftType aircraftType = AircraftTypeMapper.read(uap, dataSpec);
      flightPlanRelatedData.setAircraftType(aircraftType);

      WakeTurbulenceCategory wakeTurbulenceCategory =
          WakeTurbulenceCategoryMapper.readDepartureAirport(uap, dataSpec);
      flightPlanRelatedData.setWakeTurbulenceCategory(wakeTurbulenceCategory);

      DepartureAerodrome departureAerodrome =
          DepartureAerodromeMapper.readDepartureAirport(uap, dataSpec);
      flightPlanRelatedData.setDepartureAerodrome(departureAerodrome);

      DestinationAerodrome destinationAerodrome =
          DestinationAerodromeMapper.readDestinationAirport(uap, dataSpec);
      flightPlanRelatedData.setDestinationAerodrome(destinationAerodrome);

      Runway runwayDesignation = RunwayMapper.read(uap, dataSpec);
      flightPlanRelatedData.setRunwayDesignation(runwayDesignation);

      FlightLevel currentClearedFlightLevel = CurrentClearedFlightLevelMapper.read(uap, dataSpec);
      flightPlanRelatedData.setCurrentClearedFlightLevel(currentClearedFlightLevel);

      ControlPosition currentControlPosition = ControlPositionMapper.read(uap, dataSpec);
      flightPlanRelatedData.setCurrentControlPosition(currentControlPosition);

      FlightPlanTimeData flightPlanTimeData = FlightPlanTimeDataMapper.read(uap, dataSpec);
      flightPlanRelatedData.setFlightPlanTimeData(flightPlanTimeData);

      AircraftStand aircraftStand = AircraftStandMapper.read(uap, dataSpec);
      flightPlanRelatedData.setAircraftStand(aircraftStand);

      StandStatus standStatus = StandStatusMapper.read(uap, dataSpec);
      flightPlanRelatedData.setStandStatus(standStatus);

      StandardInstrumentDeparture standardInstrumentDeparture =
          FlightProcedureMapper.readDeparture(uap, dataSpec);
      flightPlanRelatedData.setStandardInstrumentDeparture(standardInstrumentDeparture);

      StandardInstrumentArrival standardInstrumentArrival =
          FlightProcedureMapper.readArrival(uap, dataSpec);
      flightPlanRelatedData.setStandardInstrumentArrival(standardInstrumentArrival);

      PreEmergencyMode3 preEmergencyMode3 = PreEmergencyMode3Mapper.read(uap, dataSpec);
      flightPlanRelatedData.setPreEmergencyMode3(preEmergencyMode3);

      PreEmergencyCallsign preEmergencyCallsign = PreEmergencyCallsignMapper.read(uap, dataSpec);
      flightPlanRelatedData.setPreEmergencyCallsign(preEmergencyCallsign);

      fpIndicator.setSize(dataSpec.calculateTotalSize());
      return flightPlanRelatedData;
    }
    return null;
  }
}
