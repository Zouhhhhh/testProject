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



### 1. 简单例子：

``` xml
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.zouhhhhh.bymapper.mapper.RoleMapper">
    <select id="countUserByFirstName" parameterType="string" resultType="int">
        SELECT COUNT(*) total FROM t_user WHERE user_name LIKE CONCAT(#{firstName}, '%')
    </select>
</mapper>



<!--
    - id配合mapper的全限定名，联合成为一个唯一的标识，用于标识这条sql
    - parameterType表示这条SQL接受的参数类型，可以是系统定义或者自定义的别名
    - resultType表示这条SQL的返回值类型，可以是系统定义或者自定义的别名
    - #{firstName}是被传递进去的参数

-->
```



### 2. 传递多个参数

（1）使用map接口传递参数

``` java
public List<Role> findRolesByMap(Map<String, Object> parameterMap); 
```

``` xml
<mapper namespace="com.zouhhhhh.bymapper.mapper.RoleMapper">
    <select id="findRolesByMap" parameterType="map" resultType="role">
        SELECT id, role_name AS roleName, note FROM t_role
        WHERE role_name LIKE concat('%', #{role_name}, '%')
        AND note LIKE CONCAT('%', #{note}, '%')
    </select>
</mapper>
```

可读性差，不推荐使用



（2）使用注解传递多个参数

提供了一个注解@Param，可以通过它去定义映射器的参数名称，接口方法为

``` java
public List<Role> findRolesByAnnotation(@Param("roleName") String rolename, @Param("note") String note);
```

此时，映射文件的代码不需要给出parameterType，mybatis会自动探索（涉及参数底层）



（3）通过JavaBean传递多个参数

相当于把参数都装在一个bean里面，传递bean进去，parameterType=“bean的全限定名或别名”



### 3. 使用resultMap映射结果集

``` xml
<mapper namespace=”com.learn . ssm . chapterS .mapper . RoleMapper”>
	<resultMap id= ” roleMap” type= ” role ” >
        <id property= ” id” column= ” id” />
        <result property= ” roleName ” column= ” role name ” />
        <result property= ” note ” column= ” note ” />
    </resultMap> 
    <select id= ” getRoleUseResultMap” parameterType= ” long” resultMap= ” roleMap ” >
        select id, role name, note from t role where id = #{id} 
    </select> 
</mapper>
```



### 4. 分页参数RowBounds

Mybatis不仅支持分页，它还内置了一个专门处理分页的类——RowBounds。只要给接口增加一个RowBounds参数即可使用。

``` java
public List<Role> findByRowBounds(@Param("roleName") String rolename, @Param("note") String note, RowBounds rowBounds);
```

注意只能运用于一些小数据量的查询，原理是执行SQL的查询后，按照偏移量和限制条数返回结果（就是先把全部查出来了，再去做减法）。

对于大量的数据查询，可以通过分页插件去处理。

