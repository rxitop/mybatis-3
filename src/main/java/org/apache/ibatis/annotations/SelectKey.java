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
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.ibatis.mapping.StatementType;

/**
 * @author Clinton Begin
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SelectKey {

  /**
   * SQL 语句数组
   * @return
   */
  String[] statement();

  /**
   * 主键属性名
   * @return
   */
  String keyProperty();

  /**
   * 主键列名
   * @return
   */
  String keyColumn() default "";

  /**
   * 指明 SQL 语句应被在插入语句的之前还是之后执行
   * @return
   */
  boolean before();

  /**
   * 返回类型
   * @return
   */
  Class<?> resultType();

  /**
   * SQL 语句类型，默认为 PREPARED
   * @return
   */
  StatementType statementType() default StatementType.PREPARED;
}
