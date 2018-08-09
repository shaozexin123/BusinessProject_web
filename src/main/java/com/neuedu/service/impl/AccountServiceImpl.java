package com.neuedu.service.impl;

import com.neuedu.dao.ILoginDao;
import com.neuedu.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource(name="loginMybatisImpl")
    ILoginDao loginDao;
    @Override
    public void transfer(String fromusername, String tousername, double money) {
        loginDao.updataAccount(fromusername,2000-money);
//        int y=1/0;
        loginDao.updataAccount(tousername,2000+money);
    }
}
