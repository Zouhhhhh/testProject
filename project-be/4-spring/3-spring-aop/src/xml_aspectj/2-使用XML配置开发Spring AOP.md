
## 2 使用XML实现AOP

### 2.1 使用
1. pojo类
2. service接口和实现类
3. aspect切面类
4. 在XML中注册切面，并根据约定织入到流程中
```xml
    <aop:config>
        <!-- 引用xmlAspect作为切面 -->
        <aop:aspect ref="xmlAspect">
            <!-- 定义切点 -->
            <aop:pointcut id="printRole"
                          expression="execution(* xml_aspectj.service.impl.RoleServiceImpl.printRole(..))"/>

            <!-- 定义通知 -->
            <aop:before method="before"
                        pointcut-ref="printRole"/>
            <aop:after method="after"
                       pointcut-ref="printRole" />
            <aop:after-throwing method="afterThrowing"
                                pointcut-ref="printRole"/>
            <aop:after-returning method="afterReturning"
                                 pointcut-ref="printRole"/>
        </aop:aspect>
    </aop:config>
```
5. 测试一下


### 2.2 环绕通知
在XmlAspect类中增加环绕方法around
在配置文件增加织入通知


### 2.3 发现了一个坑
在加入环绕通知之前，可以发现aop的执行顺序是
@Before -> @After -> @AfterReturning -> @AfterThrowing
```
// 这顺序应该是正常的，after（后置通知）在afterReturning（返回通知）前
before...
roleName :管理员
after...
afterReturning...
```


加入环绕之后顺序变成了
@Around -> @Before -> @AfterReturning -> @AfterThrowing -> @After
```
// 这里开始有问题了
// after跑到afterReturning后面去了
before...
around before ...
roleName :管理员
around after ...
afterReturning...
after...
```



当把before方法去掉后，after和afterReturning又到了around方法里面去了？？？
```
// 没有before方法时
// after和afterReturning跑到around after前了
around before ...
roleName :管理员
after...
afterReturning...
around after ...
```

### 2.4 再看注解方式的aop执行顺序
不加around时
```
// after跑到afterReturning后面去了，有问题吧？
before...
roleName :管理员
afterReturing...
after...
```

加了around
```
// 全跑around里面去了
around before...
before...
roleName :管理员
afterReturing...
after...
around after...
```

还对比了是不是定义了pointCut和直接用execution的区别，发现不加around时，注解和XML的执行顺序确实不一样