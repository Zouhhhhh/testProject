package ioc.annotation_config.pojo;

import ioc.annotation_config.controller.RoleController;
import ioc.annotation_config.service.impl.RoleServiceImpl;
import ioc.annotation_config.service.impl.RoleServiceImpl2;
import org.springframework.context.annotation.ComponentScan;

// 可以指定其他包的类为bean
@ComponentScan(basePackageClasses = {Role.class, RoleServiceImpl.class, RoleServiceImpl2.class, RoleController.class})
public class ApplicationConfig {
}
