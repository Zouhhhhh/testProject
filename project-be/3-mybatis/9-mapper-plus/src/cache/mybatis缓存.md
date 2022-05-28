# 缓存
    一级缓存是在SqlSession上的缓存，二级缓存是在SqlSessionFactory上的缓存。
    默认情况下Mybatis系统会开启一级缓存，这个缓存不需要POJO对象可序列化（实现java.io.Serializable接口）
## 一级缓存
    只获取一个SqlSession，通过RoleMapper获取两次同一个Role对象，只执行了一次SQL
## 二级缓存
    开启方式：1、在RoleMapper.xml设置<cache/>。2、Role对象实现序列化接口（Serializable）
    获取两个SqlSession，第一次获取Role对象后，执行一次commit（将对象缓存到SqlSessionFactory）。再获取一次同一个Role对象
    