package com.uranus.transformer.fdexm.util;

import com.uranus.transformer.fdexm.dom.AddmBrwyDom;
import com.uranus.transformer.fdexm.dom.AddmDom;
import com.uranus.transformer.fdexm.dom.AddmIfplDom;
import com.uranus.transformer.fdexm.dom.AddmRoutePointDom;
import com.uranus.transformer.fdexm.dom.AddmSsrInfoDom;

/**
 * AddmValidator
 *
 * @author tellxp@github.com
 * @date 2018/11/23
 */
public class AddmValidator {
  private final String EQUIPMENTCODE_REGEX = "[A-Z0-9]{1,}";
  private final String FLIGHTLEVEL_REGEX = "[F|A[0-9]{3}]|[S|M[0-9]{4}]";
  private final String FLIGHTPLANSTATUS_REGEX = "[A-Z0-9]{1,20}";
  private final String FLIGHTRULE_REGEX = "[I|V|Y|Z]";
  private final String FLIGHTTYPE_REGEX = "[S|N|G|M|X]";
  private final String HEADING_REGEX = "[0-9]{3}";
  private final String ICAOAIRCRAFTTYPE_REGEX = "[A-Z][A-Z0-9]{1,3}";
  private final String LONGITUDELONG_REGEX = "[0-9]{7}";
  private final String LPSCODE_REGEX = "[A-Z0-9]{1,8}";
  private final String MACHNUMBER_REGEX = "M[0-9]{3}";
  private final String MONTH_REGEX = "[0|1][0-9]";
  private final String POINT_REGEX = "[A-Z0-9]{2,5}";
  private final String PLANSTATUS_REGEX = "[A-Z]{3,5}";
  private final String RUNWAYCODE_REGEX = "[0-9]{2}[L|C|R]";
  private final String SECONDS_REGEX = "[0|1|2|3|4|5][0-9]";
  private final String SECTORCODE_REGEX = "[A-Z0-9]{1,8}";
  private final String SPD_REGEX = "[K|N][0-9]{4}";
  private final String SPLDCAP_REGEX = "[0-9]{3}";
  private final String SPLDCOL_REGEX = "[\\s\\S]{1,50}";
  private final String SPLDNB_REGEX = "[0-9]{2}";
  private final String SSREQUIPMENT_REGEX = "[A-Z0-9]{1-20}";
  private final String SURVIVALEQPT_REGEX = "[P|D|M|J]{1-4}";
  private final String TEXT20_REGEX = "[\\s\\S]{1-20}";
  private final String TIMEHHMM_REGEX = "[0|1|2][0-9]{1}[0|1|2|3|4|5][0-9]";
  private final String TIMEHHMMELAPSED_REGEX = "[0-9][0-9][0|1|2|3|4|5][0-9]";
  private final String TITLEID_REGEX = "[A-Z]{4,6}";
  private final String WAKETURBCAT_REGEX = "[J|H|M|L]";
  private final String YEAR_REGEX = "[0-9]{4}";

  private final String AIDEQUIPMENT_REGEX = "[N|S]" + EQUIPMENTCODE_REGEX;
  private final String ATSROUTE_REGEX = "[A-Z0-9]{2,7}";
  private final String DATALINK_REGEX = "[S|H|V|M]{1,4}";

  private static final String TITLE_REGEX = "[A-Z]{4,6}";
  private static final String DATETIME_TO_SECOND_REGEX = "[0-9]{14}";
  private static final String DATETIME_TO_MINUTE_REGEX = "[0-9]{12}";
  private static final String DATE_REGEX = "[0-9]{8}";
  private static final String TIME_TO_SECOND_REGEX = "[0-9]{6}";
  private static final String TIME_TO_MINUTE_REGEX = "[0-9]{4}";

  private static final String IFPL_ID_REGEX = "[0-9]+";

  private static final String SSR_CODE_REGEX = "A[0-7]{4}";
  private static final String SSR_OPERATION_REGEX = "DST|REC";
  private static final String FLIGHT_ID_REGEX = "[A-Z0-9]{2,8}";

  private static final String ICAO_AERODROME_REGEX = "[A-Z]{4}";

  private final String PAYLOAD_REGEX = "ZCZC[\\s]*(?<content>[\\s\\S]*)NNNN[\\s]*";
  private final String ISCOUPLE_REGEX = "[\\s\\S]*-ISCOUPLE\\s(?<isCouple>[Y|N])";

  public static boolean isValidAddmBrwy(AddmBrwyDom dom) {
    if (null == dom.getTitle()
        || null == dom.getFiltim()
        || null == dom.getAirport()
        || null == dom.getRwylist()) {
      return false;
    }
    return dom.getTitle().equals("BRWY")
        && dom.getFiltim().matches(TIME_TO_SECOND_REGEX)
        && dom.getAirport().matches(ICAO_AERODROME_REGEX);
  }

  public static boolean isValidAddmIfpl(AddmIfplDom dom) {
    if (null == dom.getTitle() || null == dom.getFiltim() || null == dom.getIfplid()) {
      return false;
    }
    return dom.getTitle().equals("IFPL")
        && dom.getFiltim().matches(TIME_TO_SECOND_REGEX)
        && dom.getIfplid().matches(IFPL_ID_REGEX);
  }

  public static boolean isValidAddsSsrInfoDom(AddmSsrInfoDom dom) {
    if (null == dom.getTitle()
        || null == dom.getFiltim()
        || null == dom.getSsrcode()
        || null == dom.getSsroper()
        || null == dom.getOpertime()
        || null == dom.getAdep()
        || null == dom.getAdes()
        || null == dom.getArcid()
        || null == dom.getEobd()
        || null == dom.getEobt()) {
      return false;
    }
    boolean value = true;

    return dom.getTitle().equals("BSSR")
        && dom.getFiltim().matches(TIME_TO_SECOND_REGEX)
        && dom.getSsrcode().matches(SSR_CODE_REGEX)
        && dom.getSsroper().matches(SSR_OPERATION_REGEX)
        && dom.getOpertime().matches(DATETIME_TO_MINUTE_REGEX)
        && dom.getAdep().matches(ICAO_AERODROME_REGEX)
        && dom.getAdes().matches(ICAO_AERODROME_REGEX)
        && dom.getArcid().matches(FLIGHT_ID_REGEX)
        && dom.getEobd().matches(DATE_REGEX)
        && dom.getEobt().matches(TIME_TO_MINUTE_REGEX);
  }

  public static boolean isValidAddsMessageDom(AddmDom dom) {
    if (null == dom.getTitle() || null == dom.getFiltim()) {
      return false;
    }
    return dom.getTitle().matches(TITLE_REGEX) && dom.getFiltim().matches(TIME_TO_SECOND_REGEX);
  }

  public static boolean isValidAddsRoutePointDom(AddmRoutePointDom dom) {
    return dom.getEto().matches(DATETIME_TO_SECOND_REGEX);
  }
}
