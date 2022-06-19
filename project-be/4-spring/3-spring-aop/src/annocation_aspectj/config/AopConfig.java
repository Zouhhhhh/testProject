package annocation_aspectj.config;

import annocation_aspectj.aspect.RoleAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 这里不用@Configuration好像也可以？
//@Configuration
@EnableAspectJAutoProxy
@ComponentScan("annocation_aspectj")
public class AopConfig {

    @Bean
    public RoleAspect getRoleAspect() {
        return new RoleAspect();
    }

}
