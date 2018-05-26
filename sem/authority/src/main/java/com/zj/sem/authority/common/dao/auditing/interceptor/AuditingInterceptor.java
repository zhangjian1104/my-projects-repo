package com.zj.sem.authority.common.dao.auditing.interceptor;

import com.zj.sem.authority.common.dao.auditing.AuditWare;
import com.zj.sem.authority.common.dao.auditing.annotation.CreatedBy;
import com.zj.sem.authority.common.dao.auditing.annotation.LastModifiedBy;
import com.zj.sem.authority.common.dao.auditing.annotation.CreatedDateTime;
import com.zj.sem.authority.common.dao.auditing.annotation.LastModifiedDateTime;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AuditingInterceptor
 * <p>
 * 审计功能对Mybatis的拦截器实现.
 * 审计接口，自动注入用户id以及自动获取注入更新时间和创建时间.
 * 注意:该实现如果其它工程需要使用,请根据参数类型修改具体内容
 * 默认类型:LocadateTime,Long
 * </p>
 *
 * @author zhangjian  2018/5/26  14:29
 */
@Intercepts({
    @Signature(type = Executor.class, method = "update", 
               args = {MappedStatement.class, Object.class})
    })
public class AuditingInterceptor implements Interceptor {
  
  @Override
  public Object intercept(Invocation invocation) throws Throwable {    
    MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
    SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
    Object parameter = invocation.getArgs()[1];
    //获取所有该类所有字段,递归获取,包括父类
    List<Field> fieldList = new ArrayList<>() ;
    Class tempClass = parameter.getClass();
    while (tempClass != null && !tempClass.getName().toLowerCase().equals("java.lang.object")) {//当父类为null的时候说明到达了最上层的父类(Object类).
      fieldList.addAll(Arrays.asList(tempClass .getDeclaredFields()));
      tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己
    }    
    //设定系统当前时间以及当前操作者ID
    LocalDateTime currentDateTime = LocalDateTime.now();
    Long currentUserId = AuditWare.getCurrentOperatorId();
//    Long currentUserId = auditWare.getCurrentOperatorId();
        
    if(SqlCommandType.UPDATE==sqlCommandType) {
      for (Field field : fieldList) {
        
        if (field.isAnnotationPresent( LastModifiedBy.class)) {
          field.setAccessible(true);
          field.set(parameter,currentUserId);
          field.setAccessible(false);
        }
        if (field.isAnnotationPresent( LastModifiedDateTime.class)) {
          field.setAccessible(true);
          field.set(parameter,currentDateTime);
          field.setAccessible(false);
        }        
      }
    } else if(SqlCommandType.INSERT==sqlCommandType){
      for (Field field : fieldList) {
        
        if (field.isAnnotationPresent( CreatedBy.class)) {
          field.setAccessible(true);
          field.set(parameter,currentUserId);
          field.setAccessible(false);
        }
        if (field.isAnnotationPresent( CreatedDateTime.class)) {
          field.setAccessible(true);
          field.set(parameter,currentDateTime);
          field.setAccessible(false);
        }
        if (field.isAnnotationPresent( LastModifiedBy.class)) {
          field.setAccessible(true);
          field.set(parameter,currentUserId);
          field.setAccessible(false);
        }
        if (field.isAnnotationPresent( LastModifiedDateTime.class)) {
          field.setAccessible(true);
          field.set(parameter,currentDateTime);
          field.setAccessible(false);
        }
      }
    }
    return invocation.proceed();
  }

  @Override
  public Object plugin(Object target) {
    if (target instanceof Executor) {
      return Plugin.wrap(target, this);
    } else {
      return target;
    }
  }

  @Override
  public void setProperties(Properties properties) {
    String auditWare = properties.getProperty("auditWare");    
  }
}
