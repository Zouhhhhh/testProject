# AOP
## 1 使用@Aspect注解实现AOP
### 1.1 扫描切面的注解
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

### 1.2 使用XML注册切面
切点、切面、通知都相同，就是AopConfig换成了XML方式


### 1.3 环绕通知
@Around()，环绕通知是在包裹了整个切面的
```java
    @Around("print()")
    public void around(ProceedingJoinPoint jp) {
        System.out.println("around before...");
        try {
            jp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("around after...");
    }
```
这里的两个输出是在最前面和最后面

### 1.4 织入
织入是生成代理对象的过程。当切点方法所在的类拥有接口时，Spring提供JDK动态代理；当类不存在接口时，Spring采用CGLIB来生成代理对象。


### 1.5 给通知传递参数
如果切点上有多个参数，则在连接点（PointCut）的定义需要追加参数
```java
// 切点
public void printRole(Role role, int sort);

// 通知和连接点
@Before("execution(* annocation_aspectj.service.impl.RoleServiceImpl.printRole(..))" + "&& args(role, sort)")
public void before(Role role, int sort) {
        System.out.println("before...");
        }
```

### 1.6 引入
目标对象：RoleServiceImpl
代理对象 是会实现目标对象的接口（RoleService） 进而调用其方法，但是现在想给代理对象再增强一下，继续实现一个接口（RoleVerifier）。
在切面中加一个属性：
```java
    @DeclareParents(value = "annocation_aspectj.service.impl.RoleServiceImpl+", defaultImpl = RoleVerifierImpl.class)
    public RoleVerifier roleVerifier;
```











