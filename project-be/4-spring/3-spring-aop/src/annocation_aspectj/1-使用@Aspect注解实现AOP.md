# AOP
## 使用@Aspect注解实现AOP
1. 创建切点（目标对象的方法）
    - RoleService
    - RoleServiceImpl
2. 创建切面（类似拦截器）
    - RoleAspect
3. 连接点
    - 在切面中设置好了，就是execution(* annocation_aspectj.service.impl.RoleServiceImpl.printRole(..)
4. 测试AOP
    - 从context中获取**切点**的bean，然后调用目标对象的方法，启用**切面**，可以看到各种**通知**的输出

5. 用到的注解：
   - @Aspect
   - @Before
   - @After
   - @AfterReturning
   - @AfterThrowing
   - @Point

## 使用XML
切点、切面、通知都相同，就是AopConfig换成了XML方式


## 环绕通知



## 织入
织入是生成代理对象的过程。当切点方法所在的类拥有接口时，Spring提供JDK动态代理；当类不存在接口时，Spring采用CGLIB来生成代理对象。



## 给通知传递参数



## 引入













