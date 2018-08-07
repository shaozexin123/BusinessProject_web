package com.neuedu.test;


import com.neuedu.controller.ProductController;
import com.neuedu.dao.ILoginDao;
import com.neuedu.dao.impl.mybatis.LoginMybatisImpl;
import com.neuedu.dao.impl.mybatis.ProductMybatisImpl;
import com.neuedu.service.impl.ProductServiceImpl;
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
    @Test
    public void testFindbyid(){
        ProductController ps=new ProductController();
        System.out.println(ps.deleteProduct(1));
    }
}
