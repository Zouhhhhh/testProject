# 映射器

本章目标：
    1. 掌握select、insert、delete和update元素的使用方法
    2. 掌握如何传递参数的各种方法和指定返回参数类型
    3. 掌握resultMap的使用方法
    4. 掌握一对一、一对多、N+1问题等级联技术
    5. 掌握一级和二级缓存的使用方法
    6. 掌握如何调用存储过程



## 1、概述

映射器的配置元素，如图

| 元素名称         | 描述                                                         | 备注                                                |
| ---------------- | ------------------------------------------------------------ | --------------------------------------------------- |
| select           | 查询语句，最常用、最复杂 元素之一                            | 可以自定义参数，返回结果集等                        |
| insert           | 插入语句                                                     | 执行后返回一个整数                                  |
| update           | 更新语句                                                     | 执行后返回一个整数                                  |
| delete           | 删除语句                                                     | 执行后返回一个整数                                  |
| ~~parameterMap~~ | 定义参数映射关系                                             | 即将被删除的元素，不建议使用                        |
| sql              | 允许定义一部分SQL，然后在各个地方引用它                      | 例如，一张表列名，一次定义，可以在多个SQL语句中使用 |
| **resultMap**    | **用来描述从数据库结果集中来加载对象，它是最复杂、最强大的元素** | 它将提供映射规则（typeHandler中用到过）             |
| cache            | 给定命名空间的缓存配置                                       |                                                     |
| cache-ref        | 其他命名空间缓存配置的引用                                   |                                                     |



## 2、select元素—查询语句

select元素的配置（加粗的是常用）

| **元素**          | **说明**                                                     | **备注**                                                   |
| ----------------- | ------------------------------------------------------------ | ---------------------------------------------------------- |
| **id**            | 它和Mapper的命名空间组合起来是唯一的，供MyBatis调用          | 如果命名空间和id结合起来不唯一，Mybatis将抛出异常          |
| **parameterType** | 可以给出类的全命名，也可以给出别名                           | 可以选择JavaBean、Map等简单的参数类型传递给SQL             |
| ~~parameterMap~~  | 即将废弃的元素，不讨论                                       |                                                            |
| **resultType**    | 定义类的全路径，在允许自动匹配的情况下，结果集将通过JavaBean的规范映射；或定义为int、double、float、map等参数；也可以使用别名，但是要符合别名规范，**且不能和resultMap同时使用** | 常用的参数之一，比如统计总条数时可以把它的值设置为int      |
| **resultMap**     | 它是映射集的引用，将执行强大的映射功能。我们可以使用resultType和resultMap其中一个，resultMap能提供自定义映射规则的机会 | Mybatis最复杂的元素，可以配置映射规则、级联、typeHandler等 |
| flushCache        | 它的作用是在调用SQL后，是否要求Mybatis清空之前查询本地缓存和二级缓存 | 取值为布尔值，默认为false                                  |
| useCache          | 启用二级缓存的开关，是否要求Mybatis将此次结果缓存            | 取值为布尔值，默认为true                                   |
| timeout           | 设置超时参数，超时将抛出异常，单位是秒                       | 默认值是数据库厂商提供的JDBC驱动所设置的秒数               |
| fetchSize         | 获取记录的总条数设定                                         | 默认值是数据库厂商提供的JDBC驱动所设置的条数               |
| statementType     | 告诉Mybatis使用哪个JDBC的Statement工作，取值为Statement、preparedStatement、CallableStatement | 默认值为preparedStatement                                  |
| resultSetType     | 这是对JDBC的resultSet接口而言的，它的值包括FORWARD_ONLY（游标允许向前访问）、SCROLL_SENSITIVE（双向滚动，但不及时更新）、SCROLL_INSENSITIVE（双向滚动，及时更新） | 默认值是数据库厂商提供的JDBC驱动所设置的                   |
| databaseId        | 它的使用参考前面                                             |                                                            |
| resultOrdered     | 这个设置仅适用于嵌套结果select语句。                         |                                                            |
| resultSets        | 适合多个结果集的情况、它将列出执行SQL后每个结果集的名称，每个名称之间用逗号分隔 | 很少使用                                                   |

