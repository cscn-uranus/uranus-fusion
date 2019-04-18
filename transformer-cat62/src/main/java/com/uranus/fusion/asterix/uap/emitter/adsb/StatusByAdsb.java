package com.uranus.fusion.asterix.uap.emitter.adsb;

import com.uranus.fusion.asterix.uap.datainfo.CorrectionEnum;
import lombok.Data;

/**
 * StatusByAdsb
 *
 * @author 肖鹏 tellxp@github.com date 2018/10/23
 */
@Data
public class StatusByAdsb {

  private OperationalEnum acasOperationStatus;
  private OperationalEnum multiNavaidsOperationStatus;
  private CorrectionEnum differentialCorrectionEnum;
  private BitSetStatusEnum groundBitStatus;
  private AdsBroadcastFlightStatusEnum flightStatusEnum;
}
