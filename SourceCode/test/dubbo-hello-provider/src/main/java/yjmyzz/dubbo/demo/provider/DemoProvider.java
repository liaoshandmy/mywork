package yjmyzz.dubbo.demo.provider;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;
 
public class DemoProvider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/*.xml");
        context.start();
        System.out.println("�����Ѿ�����...");
        System.in.read();
    }
}