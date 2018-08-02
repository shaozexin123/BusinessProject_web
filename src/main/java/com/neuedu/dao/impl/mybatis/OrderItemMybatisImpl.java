package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class OrderItemMybatisImpl implements OrderItemDao {
    @Override
    public boolean addOrderItems(List<UserOrderItem> orederItems) {
        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=factory.openSession();
        int i=sqlSession.insert("com.neuedu.entity.UserOrderItem.addOrderItems",orederItems);
        sqlSession.commit();
        if(i==1){
            return true;}
        return false;
    }

    @Override
    public int generateOrderItemId() {
        return 0;
    }
}
