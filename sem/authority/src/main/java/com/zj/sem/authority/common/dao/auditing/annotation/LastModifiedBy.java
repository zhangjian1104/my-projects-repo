package com.zj.sem.authority.common.dao.auditing.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * com.zj.sem.authority.common.dao.auditing.annotation.LastModifiedBy
 * <p>
 * 标注该注解的字段,在mybatis更新数据时,会自动将当前操作者ID注入.
 * 该注解在insert和update执行时起作用.该注解只可用于FIELD中.
 * </p>
 *
 * @author zhangjian  2018/5/26  14:23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD,ElementType.ANNOTATION_TYPE})
public @interface LastModifiedBy {

}
