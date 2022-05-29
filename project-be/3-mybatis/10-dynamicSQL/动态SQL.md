# 动态SQL
本章目标：
1. 掌握Mybatis动态SQL的基本使用
2. 掌握Mybatis动态SQL的基本元素：if、set、where、bind、foreach等的用法
3. 掌握Mybatis动态SQL的条件判断方法


## if元素
```xml
<select id="findRoles" parameterType="string" resultMap="roleResultMap">
    select role_no, role_name, note from t_role where 1=1
    <if test="roleName != null and roleName !=''">
        and role_name like concat('%', #{roleName}, '%')
    </if>
</select>
```

## choose、when、otherwise元素
```xml
<select id="findRoles" parameterType="string" resultMap="roleResultMap">
    select role_no, role_name, note from t_role where 1=1
    <choose>
        <when test="roleNo != null and roleNo !=''">
            and role_no = #{roleNo}
        </when>
        <when test="roleName != null and roleName !=''">
            and role_name like concat('%', #{roleName}, '%')
        </when>
        <otherwise>
            and note is not null
        </otherwise>
    </choose>
</select>
```

## trim、where、set元素

省去了where 1=1条件

```xml
<select id="findRoles" parameterType="string" resultMap="roleResultMap">
    select role_no, role_name, note from t_role
    <where>
        <if test="roleName != null and roleName != ''">
            and role_name like concat('%', #{roleName}, '%')
        </if>
        <if test="note != null and note != ''">
            and note like concat('%', #{note}, '%')
        </if>
    </where>
</select>
```



trim元素意味着要去掉一些特殊的字符串，prefix代表语句的前缀，而prefixOverride代表的是需要去掉哪种字符串

```xml
<select id="findRoles" parameterType="string" resultMap="roleResultMap">
    select role_no, role_name, note from t_role
    <trim prefix="where" prefixOverrides="and">
        <if test="roleName != null and roleName != ''">
            and role_name like concat('%', #{roleName}, '%')
        </if>
    </trim>
</select>
```



set元素遇到逗号会去掉

```xml
<update id="updateRole" parameterType="role">
    update t_role
    <set>
        <if test="roleName != null and roleName !=''">
            role_name = #{roleName},
        </if>
        <if test="note != null and note !=''">
            note = #{note}
        </if>
    </set>
    where role_no = #{roleNo}
</update>
```

## foreach元素
主要用于查询条件的in，传入多个参数
item：配置的是循环中当前的元素
index：配置的是当前元素在集合的位置下标
collection：配置的是传递进来的参数名称，可以是数组、List、Set等集合
open和close：配置的是以什么符号将集合元素包装起来
separator：配置的是各个元素的间隔符
```xml
<select id="findUserBySex" resultType="user">
    select * from t_role where role_no in
    <foreach item="roleNo" index="index" collection="roleNoList" open="(" separator="," colse=")">
        #{roleNo}
    </foreach>
</select>
```

## test元素
看上面的，不做例子


## bind元素
用作查询条件时，有时需要concat('%', #{roleName}, '%')，这只是mysql的写法，oracle用的是”||“。
所以使用bind元素将查询参数先拼接好，查询条件中直接like #{pattern}即可
```xml
<select id="findRole" parameterType="string" resultType="roleBean">
    <bind name="pattern" value="'%' + _parameter + '%'"/>
        select id, role_name as roleName from t_role
        where role_name like #{pattern}
</select>
```
_parameter表示传进来的参数
