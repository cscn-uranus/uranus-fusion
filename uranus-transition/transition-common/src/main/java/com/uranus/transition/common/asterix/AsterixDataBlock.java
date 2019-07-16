package com.uranus.transition.common.asterix;

import com.uranus.transition.common.asterix.spec.FieldSpec;

/**
 * AsterixDataBlock 是所有 Asterix 中 Data Record 的外部包装对象
 *
 * <p>每个 AsterixDataBlock 由 FieldSpec 和关联的数据项构成
 *
 * @author XiaoPeng
 * @date 2019/06/11
 */
public interface  AsterixDataBlock {
  FieldSpec fieldSpec();
}
