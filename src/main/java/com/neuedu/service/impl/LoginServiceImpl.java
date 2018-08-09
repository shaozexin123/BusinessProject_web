package com.neuedu.service.impl;

import com.neuedu.dao.ILoginDao;
import com.neuedu.dao.impl.mybatis.LoginMybatisImpl;
import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {
	@Resource(name="loginMybatisImpl")
	ILoginDao loginDao;
			//=new LoginMybatisImpl();


	public Account  doLogin(String  username,String password) {
		//���е�¼��ҵ���߼�����
		 //LoginDao loginDao=new LoginDao(); 
		//LoginDaoMysql loginDao=new LoginDaoMysql();
		System.out.println(username+password);
		return loginDao.doLogin(username,password);
		
		
	}

	@Override
	public void addToken(String token,Account acc) {
		// TODO Auto-generated method stub
		
		loginDao.addToken(token, acc);
	}

	@Override
	public String findTokenByAccountid(int accountid) {
		// TODO Auto-generated method stub
		return loginDao.findTokenByAccountid(accountid);
	}

	@Override
	public boolean addAccount(Account acc) {
		// TODO Auto-generated method stub
		return loginDao.addAccount(acc);
	}
	
}
