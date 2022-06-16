package properties.annotation2;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = {"properties.annotation2"})
@PropertySource(value = {"classpath:properties/annotation2/database-config.properties"},ignoreResourceNotFound = false)
public class ApplicationConfig {

    // 定义了一个PropertySourcesPlaceholderConfigurer类的Bean，作用是为了让Spring能够解析属性占位符
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
