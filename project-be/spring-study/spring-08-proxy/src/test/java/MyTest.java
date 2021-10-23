import com.kuang.demo01.Client;
import com.kuang.demo01.Host;
import org.junit.Test;

import java.util.Random;

public class MyTest {

    public static void main(String[] args) {

    }

    @Test
    public void test() throws ReflectiveOperationException{

        String className = "com.kuang.demo01.Client";
        Class c = Class.forName(className);
        Client client = (Client) c.getConstructor().newInstance();
        client.test1();


    }


}
