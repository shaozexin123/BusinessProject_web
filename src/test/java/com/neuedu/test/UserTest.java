package com.neuedu.test;


import com.neuedu.dao.ILoginDao;
import com.neuedu.dao.impl.mybatis.LoginMybatisImpl;
import org.junit.Test;

public class UserTest {
    @Test
    public void testDoLogin(){
        ILoginDao ilogindao=new LoginMybatisImpl();
        ilogindao.doLogin("admin","admin");
    }
    @Test
    public void testFindTokenByAccountid(){
        ILoginDao ilogindao=new LoginMybatisImpl();
        ilogindao.findTokenByAccountid(1);
    }
}
