package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.HelloWord;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWord helloWord = applicationContext.getBean(HelloWord.class, "helloWorld");
        System.out.println(helloWord.getName());

    }
}
