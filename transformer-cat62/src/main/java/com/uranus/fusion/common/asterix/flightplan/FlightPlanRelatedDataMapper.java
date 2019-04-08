package com.uranus.fusion.common.asterix.flightplan;

import com.uranus.fusion.common.asterix.SystemIdentifier;
import com.uranus.fusion.common.asterix.measure.FlightLevel;
import com.uranus.fusion.common.asterix.message.spec.DataSpec;
import com.uranus.fusion.common.asterix.message.spec.DataSpecTypeEnum;
import com.uranus.fusion.common.asterix.message.spec.FieldSpec;
import com.uranus.fusion.common.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.common.asterix.message.spec.FpIndicator;
import java.util.List;

/**
 * FlightPlanRelatedDataMapper
 *
 * @author 肖鹏 tellxp@github.com
 */

public class FlightPlanRelatedDataMapper {


  public static FlightPlanRelatedData read(List<Byte> uap, FieldSpec fieldSpec) {
    final int frn = 21;

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);
    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      int index = fieldSpec.calculateOctetIndexByFrn(frn);

      FlightPlanRelatedData flightPlanRelatedData = new FlightPlanRelatedData();


      DataSpec dataSpec = new DataSpec(DataSpecTypeEnum.FLIGHT_PLAN_RELATED_DATA);
      dataSpec.readValue(uap, index);
      flightPlanRelatedData.setDataSpec(dataSpec);


      SystemIdentifier fppsIdentificationTag = FppsIdentificationTagMapper.read(uap, dataSpec);
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

      StandardInstrumentDeparture standardInstrumentDeparture = FlightProcedureMapper
          .readDeparture(uap, dataSpec);
      flightPlanRelatedData.setStandardInstrumentDeparture(standardInstrumentDeparture);

      StandardInstrumentArrival standardInstrumentArrival = FlightProcedureMapper
          .readArrival(uap, dataSpec);
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
