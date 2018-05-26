package com.zj.sem.authority.common.dao.auditing;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * com.zj.sem.authority.common.dao.auditing.AuditWare
 * <p>
 * 审计功能,获取登陆用户ID接口.
 * </p>
 *
 * @author zhangjian  2018/5/26  18:29
 */
public abstract class AuditWare {

  /**
   * 取得当前操作者的ID
   *
   * @return 返回当前操作者ID
   */
  public static Long getCurrentOperatorId() {
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    if (authentication == null || !authentication.isAuthenticated()) {
//      return null;
//    }
//
//    return ((MyUserDetails) authentication.getPrincipal()).getUser();
    return 4332L;
  }
}
