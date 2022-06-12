package ioc.annotation_config.pojo;

import ioc.annotation_config.service.impl.RoleServiceImpl;
import org.springframework.context.annotation.ComponentScan;

// 简单扫描当前包下的所有pojo作为spring的bean
 @ComponentScan
public class PojoConfig {

}
