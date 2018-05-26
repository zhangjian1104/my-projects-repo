package com.zj.sem.authority.common.dao;

import com.zj.sem.authority.common.dao.auditing.annotation.CreatedBy;
import com.zj.sem.authority.common.dao.auditing.annotation.CreatedDateTime;
import com.zj.sem.authority.common.dao.auditing.annotation.LastModifiedBy;
import com.zj.sem.authority.common.dao.auditing.annotation.LastModifiedDateTime;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * com.zj.sem.authority.common.dao.BaseModel
 * <p>
 * 类的简述.
 * </p>
 *
 * @author zhangjian  2018/5/26  9:17
 */
@Data
public abstract class BaseModel {
  Long id;
  @CreatedBy
  Long createdBy;
  @CreatedDateTime
  LocalDateTime createdTime;
  @LastModifiedBy
  Long updatedBy;
  @LastModifiedDateTime
  LocalDateTime updatedTime;
  
  public BaseModel(){
    this.setId(UuidUtil.getNewUUId());
  }
  
}
