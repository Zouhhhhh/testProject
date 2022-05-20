3、insert元素—插入语句

insert语句可配置属性

| **元素**          | **说明**                                                     | **备注**                                          |
| ----------------- | ------------------------------------------------------------ | ------------------------------------------------- |
| **id**            | SQL编号，用于标识这条SQL                                     | 如果命名空间和id结合起来不唯一，Mybatis将抛出异常 |
| **parameterType** | 参数类型，同select                                           | 可以选择JavaBean、Map等简单的参数类型传递给SQL    |
| ~~parameterMap~~  | 即将废弃的元素，不讨论                                       |                                                   |
| flushCache        | 是否刷新缓存，可以配置true/false，为true时插入时会刷新一级和二级缓存，否则不刷新 | 默认为true                                        |
| timeout           | 设置超时参数，超时将抛出异常，单位是秒                       | 默认值是数据库厂商提供的JDBC驱动所设置的秒数      |
| statementType     | 告诉Mybatis使用哪个JDBC的Statement工作，取值为Statement、preparedStatement、CallableStatement | 默认值为preparedStatement                         |
| useGeneratedKeys  | 是否启用JDBC的getGeneratedKeys方法来取出数据库内部生成的主键 | 默认为false                                       |
| keyProperty       | （仅对insert和update有用）唯一标记一个属性，mybatis会将getGeneratedKeys的返回值设置到对应的属性中 | 不能和keyColumn同时使用                           |
| keyColumn         |                                                              |                                                   |
| databaseId        | 它的使用参考前面                                             |                                                   |
|                   |                                                              |                                                   |
|                   |                                                              |                                                   |
|                   |                                                              |                                                   |
|                   |                                                              |                                                   |



### 1. 简单例子：

``` xml
<insert id=” insertRole” parameterType=” r ole ” >
	insert into t role(role name , note) values(#{roleName} , #{note}) 
</ insert>
```



### 2. 主键回填

当执行完insert语句后，有时候还要拿到这个insert记录的id，可以通过getGeneratedKeys方法获得。用userGeneratedKeys属性打开这个功能，同时还要配置其属性keyProperty或keyColumn，告诉系统把生成的主键放入哪个属性中，如果存在多个主键，就要用逗号隔开。

``` xml
    <insert id="insertRole" parameterType="role" userGeneratedKeys="true" keyProperty="id">
        
        INSERT INTO t_role (role_name, note) values(#{roleName}, #{note})
    </insert>
```



### 3. 自定义主键

没看懂场景





