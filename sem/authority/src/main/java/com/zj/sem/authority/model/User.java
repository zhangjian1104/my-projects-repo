package com.zj.sem.authority.model;

import com.zj.sem.authority.common.dao.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * com.zj.sem.authority.model.UserController
 * <p>
 * 类的简述.
 * </p>
 *
 * @author zhangjian  2018/5/25  20:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseModel {
  String name;
  String password;
  String email;
  Integer valid;
}
