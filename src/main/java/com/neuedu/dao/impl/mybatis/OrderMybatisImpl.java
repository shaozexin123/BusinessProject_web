package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.PageMode;
import com.neuedu.entity.UserOrder;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMybatisImpl implements OrderDao {
    @Override
    public boolean createOrder(UserOrder userOrder) {
        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=factory.openSession();
        int i=sqlSession.insert("com.neuedu.entity.UserOrder.createOrder",userOrder);
        sqlSession.commit();
        if(i==1){
            return true;}
        return false;
    }

    @Override
    public int generateOrderId() {
        return 0;
    }

    @Override
    public PageMode<UserOrder> findUserOrderByPage(int pageno, int pagesize) {
        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=factory.openSession();
        int totalcount=sqlSession.selectOne("com.neuedu.entity.UserOrder.findTotalCount");
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("offset",(pageno-1)*pagesize);
        map.put("pageSize",pagesize);
        List<UserOrder> orders=sqlSession.selectList("com.neuedu.entity.UserOrder.findProductByPage",map);
        PageMode<UserOrder> pageMode=new PageMode<UserOrder>();
        pageMode.setTotalPage((totalcount%pagesize)==0?totalcount/pagesize:(totalcount/pagesize+1));
        pageMode.setData(orders);
        return  pageMode;
    }

    @Override
    public boolean deleteUserOrder(int id) {
        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=factory.openSession();
        int o=sqlSession.delete("com.neuedu.entity.UserOrder.deleteUserOrder",id);
        sqlSession.commit();
        MyBatisUtils.close(sqlSession);
        if(o==1){
            return true;}
        return false;
    }

    @Override
    public UserOrder findById(int id) {
        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=factory.openSession();

        UserOrder order=sqlSession.selectOne("com.neuedu.entity.UserOrder.findById",id);

        MyBatisUtils.close(sqlSession);
        return order;
    }

    public static void main(String[] args) {
        OrderMybatisImpl o=new OrderMybatisImpl();
        UserOrder userOrder=new UserOrder();
        userOrder.setOrder_no(1);
        userOrder.setPayment(1);
        userOrder.setPayment_type(1);
        userOrder.setPostage(1);
        userOrder.setShipping_id(1);
        userOrder.setStatus(1);
        userOrder.setUser_id(1);
        System.out.println(o.findUserOrderByPage(1,4));
    }
}
