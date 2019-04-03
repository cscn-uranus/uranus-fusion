package com.uranus.fusion.transformer.asterix.aircraft.transponder.mode3;

import com.google.common.primitives.Ints;
import com.uranus.fusion.transformer.asterix.message.spec.FieldSpec;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicationEnum;
import com.uranus.fusion.transformer.asterix.message.spec.FpIndicator;
import com.uranus.fusion.transformer.asterix.util.ByteUtil;

import java.util.List;

/**
 * Mode3CodeMapper
 *
 * @author 肖鹏 tellxp@github.com
 * @date 2018/10/15
 */
public class Mode3CodeMapper {

  public static Mode3Code readTrackMode3Code(
      List<Byte> uapOctetList, FieldSpec fieldSpec) {

    // Track Mode 3/A Code frn=9
    final int frn = 9;
    final int size = 2;
    final String zeroBit = "0";

    FpIndicator fpIndicator = fieldSpec.getFpIndicator(frn);

    if (fpIndicator.getIndication().equals(FpIndicationEnum.PRESENCE)) {
      fpIndicator.setSize(size);

      int index = fieldSpec.calculateOctetIndexByFrn(frn);
      Mode3Code mode3Code = new Mode3Code();
      String codeValidatedBit = ByteUtil.getBitByIndex(uapOctetList.get(index), 0);
      String codeGarbledBit = ByteUtil.getBitByIndex(uapOctetList.get(index), 1);
      String codeChangedBit = ByteUtil.getBitByIndex(uapOctetList.get(index), 2);

      mode3Code.setCodeValidatedStatusEnum(
          zeroBit.equals(codeValidatedBit)
              ? CodeValidatedStatusEnum.VALIDATED
              : CodeValidatedStatusEnum.NOT_VALIDATED);

      mode3Code.setCodeGarbledStatusEnum(
          zeroBit.equals(codeGarbledBit) ? CodeGarbledStatusEnum.DEFAULT
              : CodeGarbledStatusEnum.GARBLED);

      mode3Code.setCodeChangeStatusEnum(
          zeroBit.equals(codeChangedBit) ? CodeChangeStatusEnum.NO_CHANGE
              : CodeChangeStatusEnum.CHANGED);

      String codeABinaryString =
          ByteUtil.getBitByIndex(uapOctetList.get(index), 4)
              + ByteUtil.getBitByIndex(uapOctetList.get(index), 5)
              + ByteUtil.getBitByIndex(uapOctetList.get(index), 6);
      Byte codeAByte = ByteUtil.valueOf(codeABinaryString);
      String codeA = String.valueOf(
          Ints.fromBytes(ByteUtil.BYTE_ZERO, ByteUtil.BYTE_ZERO, ByteUtil.BYTE_ZERO, codeAByte));

      String codeBBinaryString =
          ByteUtil.getBitByIndex(uapOctetList.get(index), 7)
              + ByteUtil.getBitByIndex(uapOctetList.get(index + 1), 0)
              + ByteUtil.getBitByIndex(uapOctetList.get(index + 1), 1);
      Byte codeBByte = ByteUtil.valueOf(codeBBinaryString);
      String codeB = String.valueOf(
          Ints.fromBytes(ByteUtil.BYTE_ZERO, ByteUtil.BYTE_ZERO, ByteUtil.BYTE_ZERO, codeBByte));

      String codeCBinaryString =
          ByteUtil.getBitByIndex(uapOctetList.get(index + 1), 2)
              + ByteUtil.getBitByIndex(uapOctetList.get(index + 1), 3)
              + ByteUtil.getBitByIndex(uapOctetList.get(index + 1), 4);
      Byte codeCByte = ByteUtil.valueOf(codeCBinaryString);
      String codeC = String.valueOf(
          Ints.fromBytes(ByteUtil.BYTE_ZERO, ByteUtil.BYTE_ZERO, ByteUtil.BYTE_ZERO, codeCByte));

      String codeDBinaryString =
          ByteUtil.getBitByIndex(uapOctetList.get(index + 1), 5)
              + ByteUtil.getBitByIndex(uapOctetList.get(index + 1), 6)
              + ByteUtil.getBitByIndex(uapOctetList.get(index + 1), 7);
      Byte codeDByte = ByteUtil.valueOf(codeDBinaryString);
      String codeD = String.valueOf(
          Ints.fromBytes(ByteUtil.BYTE_ZERO, ByteUtil.BYTE_ZERO, ByteUtil.BYTE_ZERO, codeDByte));

      mode3Code.setCode(codeA + codeB + codeC + codeD);
      return mode3Code;
    }
    return null;
  }

}
