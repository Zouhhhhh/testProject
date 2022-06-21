package annocation_aspectj.aspect;

import annocation_aspectj.service.RoleVerifier;
import annocation_aspectj.service.impl.RoleVerifierImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

// 2. 创建切面
@Aspect
public class RoleAspect {

    @DeclareParents(value = "annocation_aspectj.service.impl.RoleServiceImpl+", defaultImpl = RoleVerifierImpl.class)
    public RoleVerifier roleVerifier;

    @Before("execution(* annocation_aspectj.service.impl.RoleServiceImpl.printRole(..))")
    public void before() {
        System.out.println("before...");
    }

    @After("execution(* annocation_aspectj.service.impl.RoleServiceImpl.printRole(..))")
    public void after() {
        System.out.println("after...");
    }

    @AfterReturning("execution(* annocation_aspectj.service.impl.RoleServiceImpl.printRole(..))")
    public void afterReturing() {
        System.out.println("afterReturing...");
    }

    @AfterThrowing("execution(* annocation_aspectj.service.impl.RoleServiceImpl.printRole(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }

    // 设置连接点的正则表达式需要重复书写多次，比较麻烦，引入另一个注解可解决。
    @Pointcut("execution(* annocation_aspectj.service.impl.RoleServiceImpl.printRole(..))")
    public void print() {

    }

    @Before("print()")
    public void before2() {
        System.out.println("用print的before2...");
    }

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

}
