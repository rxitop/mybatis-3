/**
 *    Copyright 2009-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.UnknownTypeHandler;

/**
 * @author Clinton Begin
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Result {

  /**
   * @return 是否为 id 属性，来标识应该被用于比较（和在 XML 映射中的<id>相似）的属性
   */
  boolean id() default false;

  /**
   * @return 字段名
   */
  String column() default "";

  /**
   * @return Java 属性名
   */
  String property() default "";

  /**
   * Java 类型
   * @return
   */
  Class<?> javaType() default void.class;

  /**
   * JDBC 类型
   * @return
   */
  JdbcType jdbcType() default JdbcType.UNDEFINED;

  /**
   * 类型处理器
   * @return
   */
  Class<? extends TypeHandler> typeHandler() default UnknownTypeHandler.class;

  /**
   * @return @One 注解
   */
  One one() default @One;

  /**
   * @return @Many 注解
   */
  Many many() default @Many;
}
