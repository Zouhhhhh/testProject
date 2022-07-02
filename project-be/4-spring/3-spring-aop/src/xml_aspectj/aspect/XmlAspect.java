package xml_aspectj.aspect;

import annocation_aspectj.service.RoleVerifier;
import annocation_aspectj.service.impl.RoleVerifierImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import xml_aspectj.pojo.Role;

// 2. 创建切面
// 没有任何注解，需要我们使用XML去向Spring Ioc容器描述他们
public class XmlAspect {

    public void before() {
        System.out.println("before..." );
    }

//    public void before(Role role) {
//        System.out.println("before..." + role.getRoleName());
//    }

    public void after() {
        System.out.println("after...");
    }

    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }

    public void around(ProceedingJoinPoint jp) {
        System.out.println("around before ...");

        try {
            jp.proceed();
        } catch (Throwable e) {
            new RuntimeException("回调原有流程，产生异常...");
        }
        System.out.println("around after ...");
    }

}
