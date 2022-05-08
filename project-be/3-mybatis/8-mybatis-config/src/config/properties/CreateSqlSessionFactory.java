package config.properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CreateSqlSessionFactory {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        InputStream in = Resources.getResourceAsStream("jdbc.properties");
        Properties props = new Properties();
        props.load(in);
        String username = props.getProperty("database.username");
        String password = props.getProperty("database.password");
        // 解密用户和密码，并在属性中重置
//        props.put("database.username", CodeUtils.decode(username));
//        props.put("database.password", CodeUtils.decode(password));
        inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, props);

    }
}
