package test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import pojo.Role;
import utils.MybatisUtils;

import javax.sql.DataSource;

public class Test {
    public static void main(String[] args) {
        DataSource dataSource = MybatisUtils.getDataSource();
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        SqlSessionTemplate sqlSessionTemplate = MybatisUtils.getSqlSessionTemplate();

//        Role role = sqlSessionTemplate.selectOne("mapper.RoleMapper.getRole", 1L);
//        System.out.println(role.getRoleName());

        Role role = new Role();
        role.setRoleName("role_name_sqlSessionTemplate");
        role.setNote("note_sqlSessionTemplate");
        sqlSessionTemplate.insert("mapper.RoleMapper.insertRole", role);
//        Long id = role.getId();
//        sqlSessionTemplate.selectOne("mapper.RoleMapper.getRole", id);
//        role.setNote("update_sqlSessionTemplate");


//        System.out.println(sqlSessionTemplate);
    }
}
