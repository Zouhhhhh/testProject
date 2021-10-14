
## 常用依赖



## 注解说明
- @AutoWired: 自动装配属性，默认byType
    如果Autowired不能唯一自动装配上属性，则需要通过@Qualifier(value="xxx")
- @Nullable: 字段标记了这个注解，说明这个字段可以为null
- @Resource：自动装配属性，默认byName

- @Component: 组件，放在类上，说明这个类被spring管理了，就是bean
- @Value("xxx")
- @Scope("prototype")
- @Service
- @Repository
- @Controller

- @Configuration
- @Bean
