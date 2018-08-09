package com.neuedu.test;


import com.neuedu.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountServiceTest {
    ApplicationContext applicationContext=null;
    //    @Autowired
    AccountService accountService;
    @Before
    public  void  before(){
        applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        accountService=(AccountService)applicationContext.getBean("accountServiceImpl");
    }


    @Test
    public void testTransfer(){
//        ILoginDao ilogindao=new LoginMybatisImpl();
//        ilogindao.doLogin("admin","admin");
        accountService.transfer("zhangsan","lisi",600);
    }
}
