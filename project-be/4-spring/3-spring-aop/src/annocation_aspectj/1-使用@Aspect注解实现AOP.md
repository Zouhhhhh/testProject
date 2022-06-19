# 使用@Aspect注解实现AOP
1. 创建切点（目标对象的方法）
    - RoleService
    - RoleServiceImpl
2. 创建切面（类似拦截器）
    - RoleAspect
3. 连接点
    - 在切面中设置好了，就是execution(* annocation_aspectj.service.impl.RoleServiceImpl.printRole(..)
4. 测试AOP

5. 用到的注解：
   - @Aspect
   - @Before
   - @After
   - @AfterReturning
   - @AfterThrowing
   - @Point














