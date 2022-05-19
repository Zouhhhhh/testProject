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



## 2、select语句

## 3、insert语句

## 4、 update和delete语句

## 5、sql元素

## 6、参数


## 7、resultMap元素
    resultMap的作用是定义映射规则、级联的更新、定制类型转化器等。
    resultMap定义的主要是一个结果集的映射关系，也就是SQL到Java Bean的映射关系定义，它也支持级联等特性。
 - resultMap元素的构成
``` xml
<resultMap>
    
    <constructor>
    	<idArg/>
        <arg/>
    </constructor>
    
    <id/>
    <result/>
    <association/>
    <collection/>
    <discriminator>
    	<case/>
    </discriminator>
    
</resultMap>
```



- 使用map存储结果集

    可读性差，不推荐



- 使用POJO存储结果集

    和select标签中的resultMap对应使用

``` xml

<mapper namespace=”com.learn . ssm . chapterS .mapper . RoleMapper”>
	<resultMap id= ” roleMap” type= ” role ” >
        <id property= ” id” column= ” id” />
        <result property= ” roleName ” column= ” role name ” />
        <result property= ” note ” column= ” note ” />
    </resultMap> 

</mapper>

```

resultMap元素属性id代表这个resultMap的标识，type代表着需要映射的pojo（可以使用别名）。

在映射关系中，id元素标识这个对象的主键，property代表着pojo的属性名称，column标识数据库SQL的列名



## 8、级联

级联是resultMap中的配置，比较复杂。当级联的层级超过3层时，就不要考虑使用级联了。



### 8.1 Mybatis中的级联

- 鉴别器（discriminator）：它是一个根据某些条件决定采用具体实现类级联的方案。
- 一对一（association）：比如学生和学生证。
- 一对多（collection）：比如班主任和学生。

（注意：没有多对多级联，可以通过两个一对多替换）