package com.uranus.transition.common.asterix.uap.track.status;

import com.uranus.transition.common.asterix.spec.DataSpec;
import com.uranus.transition.common.asterix.uap.track.UpdateAge;
import lombok.Data;

/**
 * SystemTrackUpdateAge
 *
 * <p>Data Item I062/290, System Track Update Ages
 *
 * <p>Definition : Ages of the last plot/local track/target report update for each sensor type.
 *
 * <p>Format : Compound Data Item, comprising a primary subfield of up to two octets, followed by
 * the indicated subfields.
 *
 * @author 肖鹏 tellxp@github.com date 2018/11/8
 */
@Data
public class SystemTrackUpdateAge {

  /**
   * Structure of Primary Subfield:
   *
   * <p>bit-16 (TRK) Subfield #1: Track age = 0 Absence of Subfield #1 = 1 Presence of Subfield #1
   *
   * <p>bit-15 (PSR) Subfield #2: PSR age = 0 Absence of Subfield #2 = 1 Presence of Subfield #2
   *
   * <p>bit-14 (SSR) Subfield #3: SSR age = 0 Absence of Subfield #3 = 1 Presence of Subfield #3
   *
   * <p>bit-13 (MDS) Subfield #4: Mode S age = 0 Absence of Subfield #4 = 1 Presence of Subfield #4
   *
   * <p>bit-12 (ADS) Subfield #5: ADS-C age = 0 Absence of Subfield #5 = 1 Presence of Subfield #5
   *
   * <p>bit-11 (ES) Subfield #6: ADS-B Extended Squitter age = 0 Absence of Subfield #6 = 1 Presence
   * of Subfield #6
   *
   * <p>bit-10 (VDL) Subfield #7: ADS-B VDL Mode 4 age = 0 Absence of Subfield #7 = 1 Presence of
   * Subfield #7
   *
   * <p>bit-9 FX Extension indicator = 0 no extension = 1 extension
   *
   * <p>bit-8 (UAT) Subfield #8: ADS-B UAT age = 0 Absence of Subfield #8 = 1 Presence of Subfield
   * #8
   *
   * <p>bit-7 (LOP) Subfield #9: Loop age = 0 Absence of Subfield #9 = 1 Presence of Subfield #9
   *
   * <p>bit-6 (MLT) Subfield #10: Multilateration age = 0 Absence of Subfield #10 = 1 Presence of
   * Subfield #10 bits-5/2 spare bits set to zero
   *
   * <p>bit-1 FX Extension indicator = 0 no extension = 1 extension
   */
  private DataSpec dataSpec;

  /**
   * Structure of Subfield # 1:
   *
   * <p>Track Age
   *
   * <p>bits-8/1 (TRK) Actual track age since first occurrence bit-1 (LSB) = 1/4 s Maximum value
   * =63.75s
   */
  private UpdateAge updateAge;

  /**
   * Structure of Subfield # 2:
   *
   * <p>PSR Age
   *
   * <p>bits-8/1 (PSR) Age of the last primary detection used to update the track bit-1 (LSB) = 1/4
   * s Maximum value =63.75s
   */
  private UpdateAge psrAge;

  /**
   * Structure of Subfield # 3:
   *
   * <p>SSR Age 3
   *
   * <p>bits-8/1 (SSR) Age of the last secondary detection used to update the track bit-1 (LSB) =
   * 1/4 s Maximum value = 63.75s
   */
  private UpdateAge ssrAge;

  /**
   * Structure of Subfield # 4:
   *
   * <p>Mode S Age
   *
   * <p>bits-8/1 (MDS) Age of the last Mode S detection used to update the track bit-1 (LSB) = 1/4 s
   * Maximum value = 63.75s
   */
  private UpdateAge modeSelAge;

  /**
   * Structure of Subfield # 5:
   *
   * <p>ADS-C Age
   *
   * <p>bits-8/1 (ADS) Age of the last ADS-C report used to update the track bit-1 (LSB) = 1/4 s
   * Max. value = 16383.75s (> 4 hours)
   */
  private UpdateAge adsContractAge;

  /**
   * Structure of Subfield # 6:
   *
   * <p>ES Age
   *
   * <p>bits-8/1 (ES) Age of the last 1090 Extended Squitter ADS-B report used to update the track
   * bit-1 (LSB) = 1/4 s Maximum value = 63.75s
   */
  private UpdateAge esAge;

  /**
   * Structure of Subfield # 7:
   *
   * <p>VDL Age
   *
   * <p>bits-8/1 (VDL) Age of the last VDL Mode 4 ADSB report used to update the track bit-1 (LSB) =
   * 1/4 s Maximum value = 63.75s
   */
  private UpdateAge vdlAge;

  /**
   * Structure of Subfield # 8:
   *
   * <p>UAT Age
   *
   * <p>bits-8/1 (UAT) Age of the last UAT ADS-B report used to update the track bit-1 (LSB) = 1/4 s
   * Maximum value = 63.75s
   */
  private UpdateAge uatAge;

  /**
   * Structure of Subfield # 9:
   *
   * <p>Loop Age
   *
   * <p>bits-8/1 (LOP) Age of the last magnetic loop detection bit-1 (LSB) = 1/4 s Maximum value =
   * 63.75s
   */
  private UpdateAge loopAge;

  /**
   * Structure of Subfield # 10:
   *
   * <p>Multilateration Age
   *
   * <p>bits-8/1 (MLT) Age of the last MLT detection bit-1 (LSB) = 1/4 s Maximum value = 63.75s
   */
  private UpdateAge multilaterationAge;
}
