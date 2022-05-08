package config.typehandler.enumordinaltypehandler;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;

public class TestSexEnum {

    public static void main(String[] args) {
        String resource = "config/typehandler/enumordinaltypehandler/mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUser(12L);
            System.err.println(user.getSex().getName());
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
