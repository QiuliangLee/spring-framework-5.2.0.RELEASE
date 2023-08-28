package com.imooc;

import com.imooc.aspect.OutSide;
import com.imooc.controller.HelloController;
import com.imooc.controller.HiController;
import com.imooc.controller.WelcomeController;
import com.imooc.dao.impl.Company;
import com.imooc.entity.User;
import com.imooc.entity.factory.UserFactoryBean;
import com.imooc.introduction.LittleUniverse;
import com.imooc.service.HelloService;
import com.imooc.service.HiService;
import com.imooc.service.WelcomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@Configuration
@EnableAspectJAutoProxy
@Import(OutSide.class)
@ComponentScan("com.imooc")
public class Entrance {

	public static void main(String[] args) {
		System.out.println("我2是你猜");
	}
}
