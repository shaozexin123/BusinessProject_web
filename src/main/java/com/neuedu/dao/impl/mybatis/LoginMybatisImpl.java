package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.ILoginDao;
import com.neuedu.entity.Account;
import com.neuedu.utils.MD5Utils;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
@Repository
public class LoginMybatisImpl implements ILoginDao {

    @Override
    public Account doLogin(String _username, String _password) {
//        1读取配置文件
       String resource="mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        2生成SqlSessionFactory 为SqlSession的工厂,用于建立与数据库的会话。
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        3建立SqlSession 用于执行sql语句
        session = sqlSessionFactory.openSession();
//        4调用MyBatis提供的 提供的api
//        5查询MAP配置
//        6返回结果
        /**
         * 第一个参数：namespace+id
         * 第二个参数:map
         * **/
        Map<String,String> map=new HashMap<String,String>();
        map.put("username",_username);
        map.put("password", _password);
        Account account = session.selectOne("com.neuedu.entity.Account.findByUserNameAndPassword",map);

//        7关闭SqlSession

        System.out.println(account);
        session.close();

        return account;
    }

    @Override
    public void addToken(String token, Account acc) {
        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=factory.openSession();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("token",token);
        map.put("accountid",acc.getAccountId());
        Object o=sqlSession.selectOne("com.neuedu.entity.Account.addToken",map);

        sqlSession.commit();
        MyBatisUtils.close(sqlSession);

    }

    @Override
    public String findTokenByAccountid(int _accountid) {
        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=factory.openSession();
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("accountid",_accountid);
        Object o=sqlSession.selectOne("com.neuedu.entity.Account.findTokenByAccountid",map);
        if (o instanceof  String){
            return (String)o;
        }
        sqlSession.commit();
        MyBatisUtils.close(sqlSession);
        return null;
    }

    @Override
    public boolean addAccount(Account acc) {
        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=factory.openSession();
//        Map<String,Integer> map=new HashMap<String,Integer>();
//        map.put("accountid",_accountid);
        int i=sqlSession.insert("com.neuedu.entity.Account.addAccount",acc);
        sqlSession.commit();
        if(i==1){
        return true;}
        return false;
    }
    public static  void  main(String[] args){
        LoginMybatisImpl i=new LoginMybatisImpl();
//        System.out.println(i.findTokenByAccountid(1));
        Account acc=new Account();
        acc.setPassword("6");
        acc.setUsername("6");
        acc.setIp("1");
        acc.setSex("nan");
        System.out.println(i.addAccount(acc));
    }
}
