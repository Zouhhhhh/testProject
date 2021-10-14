package com.kuang.config;

import com.kuang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//这个也会交给Spring容器托管，注册到容器中，因为他本身就是一个@Component
//@Configuration代表这是一个配置类，和beans.xml一样
@Configuration
@ComponentScan("com.kuang.pojo")
@Import(MyConfig2.class)
public class MyConfig {

    //注册一个bean
    @Bean
    public User user() {
        return new User();
    }

}
