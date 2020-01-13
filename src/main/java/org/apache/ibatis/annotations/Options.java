/**
 *    Copyright 2009-2019 the original author or authors.
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

import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.mapping.StatementType;

/**
 * @author Clinton Begin
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Options {
  /**
   * The options for the {@link Options#flushCache()}.
   * The default is {@link FlushCachePolicy#DEFAULT}
   *
   * 刷新缓存的策略
   */
  enum FlushCachePolicy {
    /** <code>false</code> for select statement; <code>true</code> for insert/update/delete statement. */
    // select 语句不刷新缓存，而其他则刷新缓存
    DEFAULT,
    /** Flushes cache regardless of the statement type. */
    // 所有的操作都会刷新缓存
    TRUE,
    /** Does not flush cache regardless of the statement type. */
    // 所有的操作都不会刷新缓存
    FALSE
  }

  /**
   * 是否使用缓存
   * @return
   */
  boolean useCache() default true;

  /**
   * 刷新缓存的策略，默认为 DEFAULT
   * @return
   */
  FlushCachePolicy flushCache() default FlushCachePolicy.DEFAULT;

  /**
   * 结果集类型，默认为 DEFAULT
   * @return
   */
  ResultSetType resultSetType() default ResultSetType.DEFAULT;

  /**
   * SQL 语句类型， 默认为 PREPARED
   * @return
   */
  StatementType statementType() default StatementType.PREPARED;

  /**
   * 加载的数量
   * @return
   */
  int fetchSize() default -1;

  /**
   * 超时时间
   * @return
   */
  int timeout() default -1;

  /**
   * 是否生成注解，默认为 false
   * @return
   */
  boolean useGeneratedKeys() default false;

  /**
   * 主键对应的属性
   * @return
   */
  String keyProperty() default "";

  /**
   * 主键在数据库中的字段名
   * @return
   */
  String keyColumn() default "";

  /**
   * 结果集
   * @return
   */
  String resultSets() default "";
}
