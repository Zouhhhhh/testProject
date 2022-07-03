package jdbc_template.test;

import jdbc_template.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc_template/applicationContext.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        Long id = 1L;
        String sql = "select id, role_name, note from role where id = " + id;
        Role role = jdbcTemplate.queryForObject(sql, (rs, rownum) -> {
            Role result = new Role();
            result.setId(rs.getLong("id"));
            result.setRoleName(rs.getString("role_name"));
            result.setNote(rs.getString("note"));
            return result;
        });
        System.out.println(role.getRoleName());

    }

}
