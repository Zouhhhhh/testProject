# 装配Spring Bean
本章目标：
1. 掌握3种依赖注入的方式
2. 掌握如何使用XML装配Bean
3. 掌握如何使用注解方式装配Bean及消除歧义性
4. 掌握如何使用Profile和条件装配Bean
5. 掌握Bean的作用域
6. 了解Spring EL的简易使用

## 1.1 依赖注入的3种方式
注意看applicationContext.xml和Role构造方法的不同。
- 构造器注入
- setter注入
- 接口注入

前两个都好理解，接口注入没用过，书里写的是通过从tomcat服务器获取数据库连接对象注入到应用中；网上写的是一个接口，有多个实现类，注入时指定哪个实现类到接口中。

## 1.2 装配 Spring 概述
如何将自己开发的Bean装配到Spring IOC容器中。
- 在XML中显示配置
- 在JAVA的接口和类中实现配置（注解）
- 隐式Bean的发现机制和自动装配原则(@Autowired)

### 1.2.1 XML配置装配Bean
- 装配简单值
- 装配集合
- 命名空间装配

### 1.2.2 通过注解装配Bean
此时Context组件用的是AnnotationConfigApplicationContext作为IOC容器
- @Component
- @Value
- @ComponentScan

### 1.2.3 自动装配——@Autowired
通过学习SpringIoc容器，我们知道Spring是先完成Bean的定义和生成，然后寻找需要注入的资源。也就是当Spring生成所有的Bean后，如果发现这个注解，它就会在Bean中查找，然后找到对应的类型，将其注入进来。
- @Autowired(required=false)
- @Primary（一个接口多个实现类，设置其中一个实现类为主要）
- @Qualifier（通过名称注入）

如RoleService有两个实现类RoleServiceImpl、RoleServiceImpl3。此时RoleController注入了一个RoleService，Spring不知道该注入哪个实现类。
1. 在RoleServiceImpl3上设置@Primary，以这个为主
2. 在RoleController的@Autowired下再加@Qualifier("roleService3")则可以消除歧义性


## 1.3 使用Profile