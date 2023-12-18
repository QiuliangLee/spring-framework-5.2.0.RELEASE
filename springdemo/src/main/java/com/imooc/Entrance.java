package com.imooc;

import com.imooc.aspect.OutSide;
import com.imooc.service.HelloService;
import com.imooc.service.HiService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@Import(OutSide.class)
@ComponentScan("com.imooc")
public class Entrance {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Entrance.class);
        HiService hiService = (HiService) applicationContext.getBean("hiServiceImpl");
        hiService.sayHi();
        System.out.println("---------------------------HelloService-------------------------------");
        HelloService helloService = (HelloService) applicationContext.getBean("helloServiceImpl");
        helloService.sayHello();
    }
}
