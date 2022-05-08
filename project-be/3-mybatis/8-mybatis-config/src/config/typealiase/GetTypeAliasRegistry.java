package config.typealiase;

import com.zouhhhhh.pojo.Role;
import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.TypeAliasRegistry;

import java.io.IOException;
import java.io.InputStream;

public class GetTypeAliasRegistry {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 通过sqlSessionFactory可以拿到configuration，进而拿到typeAliasRegistry
        Configuration configuration = sqlSessionFactory.getConfiguration();
        TypeAliasRegistry typeAliasRegistry = configuration.getTypeAliasRegistry();
        typeAliasRegistry.registerAlias("role", Role.class);
    }
}
