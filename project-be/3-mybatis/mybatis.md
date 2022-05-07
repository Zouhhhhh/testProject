mybatis
	
## mybatis的核心组件分为四个部分：
	1. SqlSessionFactoryBuilder（构造器）：它会根据配置或者代码来生成SqlSessonFactory，采用的是分步构建的Builder模式。
	2， SqlSessionFactory（工厂接口）：依靠它来生成SqlSession，采用的是工厂模式。
	3. SqlSession（会话）：一个既可以发送SQL执行返回结果，也可以获取Mapper的接口。在现有的技术中，一般我们会让其在业务逻辑代码中“消失”，而使用的是Mybatis提供的SQLMapper接口编程技术。
	4. SQLMapper（映射器）：它由一个Java接口和XML文件（或注解）构成，需要给出对应的SQL和映射规则，它负责发送SQL去执行，并返回结果。

## SqlSessionFactory
	每个基于Mybatis的应用都是以一个SqlSessionFactory的实例为中心的，而SqlSessionFactory唯一的作用就是生产Mybatis的核心接口对象SqlSession，所以它的责任是唯一的，通常采用单例模式处理。下面讨论使用配置文件和Java代码两种形式去生成SqlSessionFactory。
	
	使用MyBatis首先是使用配置或者代码去生产SqlSessionFactory，而MyBatis提供了构造器SqlSessionFactoryBuilder它提供了一个类。apache.ibatis.session.Configuration作为引导，采用的是Builder模式。具体的分步则是在Configuration 类里面完成的
	
	1. 配置文件XML方式
		在Mybatis的XML分为两类，一类是基础配置文件，通常只有一个（mabtis-config.xml），主要是配置一些最基本的上下文参数和运行环境；另一类是映射文件(XXXMapper.xml)，它可以配置映射关系、SQL、参数等信息。
		
		首先读取mybatis—config.xml，然后通过SqlSessionFactoryBuilder的build方法去创建SqlSessionFactory。
	
	2. 使用代码创建SqlSessionFactory
		与XML方式是类似的，先创建好数据源dataSource和事务管理器，然后通过这两个构建一个Environment，通过Environment再去创建Configuration，再创建SqlSessionFactoryBuild（前面已经说过，是通过configuration来引导创建SqlSessionFactory的）

## SqlSession
	SqlSession是Mybatis中的核心接口，有两个实现类DefaultSqlSession（单线程）和SqlSessionManager（多线程）
	sqlSession = sqlSessionFactory.openSession();
	在try中提交事务commit()，在catch中回滚rollback()，在finally中关闭连接close();


​	

## 映射器
