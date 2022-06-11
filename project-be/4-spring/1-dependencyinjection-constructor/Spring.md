# Spring

# 1.核心组件
- Bean组件
- Context组件
- Core组件
## 1.1 核心组件如何协同工作
把Bean比作一场演出中的演员，Context就是这场演出的舞台背景，而Core应该就是演出的道具。

## 1.2 Bean组件
Spring的org.springframework.beans包下，在这个包下的所有类主要解决了3件事：Bean的定义、Bean的创建、Bean的解析。
每个接口都有它使用的场合，主要是为了区分在Spirng内部对象的传递和转化过程中，**对对象的数据访问所做的限制**。
接口关系：
    - BeanFactory
        - ListableBeanFactory（Bean的集合）
        - HierarchicalBeanFactory（Bean的关系）
        - AutowireCapableBeanFactory（Bean的行为）

## 1.3 Context组件
Spring的org.springframework.context包下，它实际上就是给Spring提供一个运行时的环境，用以保存各个对象的状态。
ApplicationContext是Context的顶级父类，它除了能标识一个应用环境的基本信息外，还继承了5个接口扩展了Context的功能。
Context的任务：
    - 标识一个应用环境
    - 利用BeanFactory创建Bean对象
    - 保存对象关系表
    - 能够捕获各种事件

## 1.4 Core组件
Core组件作为Spring的核心组件，其中包含了很多关键类，一个重要的组成部分就是定义了资源的访问方式。
    - InputStreamSource
        - Resource
            - ResourcePatternResolver
                - ApplicationContext



