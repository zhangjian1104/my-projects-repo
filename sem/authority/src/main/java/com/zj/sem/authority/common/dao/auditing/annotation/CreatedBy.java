package com.zj.sem.authority.common.dao.auditing.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * com.zj.sem.authority.common.dao.auditing.annotation.CreatedBy
 * <p>
 * 标注该注解的字段,在mybatis插入时,会自动将当前操作者ID注入.
 * 该注解只在insert执行时起作用.该注解只可用于Feild中.
 * </p>
 *
 * @author zhangjian  2018/5/26  14:17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD,ElementType.ANNOTATION_TYPE})
public @interface CreatedBy {

}
