import com.kuang.dao.UserDaoMysqlImpl;
import com.kuang.dao.UserDaoOracleImpl;
import com.kuang.service.UserService;
import com.kuang.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        //用户实际调用的是业务层，不需要接触dao层
//        UserService userService = new UserServiceImpl();
////        ((UserServiceImpl) userService).setUserDao(new UserDaoMysqlImpl());
//        ((UserServiceImpl) userService).setUserDao(new UserDaoOracleImpl());
//        userService.getUser();


        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl userService = (UserServiceImpl) context.getBean("UserServiceImpl");
        userService.getUser();

    }

}
