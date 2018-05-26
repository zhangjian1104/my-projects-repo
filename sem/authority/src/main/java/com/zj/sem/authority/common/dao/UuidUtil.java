package com.zj.sem.authority.common.dao;

import java.util.UUID;

/**
 * com.zj.sem.authority.common.dao.UuidUtil
 * <p>
 * 类的简述.
 * </p>
 *
 * @author zhangjian  2018/5/26  9:37
 */
public abstract class UuidUtil {
  /**
   * 生成16位数字的UUID
   * @return 16位数字唯一值
   */
  public static Long getNewUUId() {
    int machineId = 1;//最大支持1-9个集群机器部署
    int hashCodeV = UUID.randomUUID().toString().hashCode();
    if(hashCodeV < 0) {//有可能是负数
      hashCodeV = - hashCodeV;
    }
    // 0 代表前面补充0
    // 4 代表长度为4
    // d 代表参数为正数型
    return Long.valueOf(machineId + String.format("%015d", hashCodeV));
  }
}
