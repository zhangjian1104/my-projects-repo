package com.zj.sem.authority.common.dao.auditing.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * com.zj.sem.authority.common.dao.auditing.annotation.CreatedDateTime
 * <p>
 * 标注该注解的字段,在mybatis插入时,会自动将当前系统时间注入.
 * 该注解只在insert执行时起作用.该注解只可用于Feild中.
 * </p>
 *
 * @author zhangjian  2018/5/26  14:26
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { FIELD, ANNOTATION_TYPE })
public @interface CreatedDateTime {
}
