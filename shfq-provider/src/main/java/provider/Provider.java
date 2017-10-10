package provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shifengqiang on 17/3/10.
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        System.out.println("start");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring-config.xml"});
        context.start();
        System.out.println("end");
        System.in.read(); //为保证服务一直开着，利用输入流的阻塞来模拟,按任意键退出

    }


}
