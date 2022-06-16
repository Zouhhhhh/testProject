package properties.annotation;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:properties/annotation/database-config.properties"},ignoreResourceNotFound = false)
public class ApplicationConfig {

}
