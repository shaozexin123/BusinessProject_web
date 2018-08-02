package com.neuedu.dao.impl.mybatis;

import com.alibaba.fastjson.JSONArray;
import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageMode;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartMybatisImpl implements CartDao {
    @Override
    public boolean addCart(Cart cart) {
        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=factory.openSession();
//        Map<String,Integer> map=new HashMap<String,Integer>();
//        map.put("accountid",_accountid);
        int i=sqlSession.insert("com.neuedu.entity.Cart.addCart",cart);
        sqlSession.commit();
        if(i==1){
            return true;}
        return false;
    }

    @Override
    public boolean deleteCart(int id) {
        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=factory.openSession();
        int o=sqlSession.delete("com.neuedu.entity.Cart.delectCart",id);
        sqlSession.commit();
        MyBatisUtils.close(sqlSession);
        if(o==1){
            return true;}
        return false;
    }

    @Override
    public boolean updataeCart(Cart cart) {
        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=factory.openSession();
        int o=sqlSession.update("com.neuedu.entity.Cart.updataeCart",cart);
        sqlSession.commit();
        MyBatisUtils.close(sqlSession);
        if(o==1){
            return true;}
        return false;
    }
    @Override
    public boolean updateCart(int id, int num) {
        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=factory.openSession();
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("productNum",num);
        map.put("id",id);
        int o=sqlSession.update("com.neuedu.entity.Cart.updateCart",map);
        sqlSession.commit();
        MyBatisUtils.close(sqlSession);
        if(o==1){
            return true;}
        return false;
    }
    @Override
    public List<Cart> findAllCart() {
        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=factory.openSession();
//        Map<String,Integer> map=new HashMap<String,Integer>();
//        map.put("accountid",_accountid);
        List<Cart> carts=sqlSession.selectList("com.neuedu.entity.Cart.findAllCart");

        MyBatisUtils.close(sqlSession);
        return carts;
    }

    @Override
    public int getCartNum() {
        return 0;
    }



    @Override
    public void clearCart() {

    }

    @Override
    public Cart findById(int id) {
        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=factory.openSession();

        Cart cart=sqlSession.selectOne("com.neuedu.entity.Cart.findById",id);

        MyBatisUtils.close(sqlSession);
        return cart;
    }

    @Override
    public PageMode<Cart> findCartByPage(int pageno, int pagesize) {
        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
        SqlSession sqlSession=factory.openSession();
        int totalcount=sqlSession.selectOne("com.neuedu.entity.Cart.findTotalCount");
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("offset",(pageno-1)*pagesize);
        map.put("pageSize",pagesize);
        List<Cart> carts=sqlSession.selectList("com.neuedu.entity.Cart.findProductByPage",map);
        PageMode<Cart> pageMode=new PageMode<Cart>();
        pageMode.setTotalPage((totalcount%pagesize)==0?totalcount/pagesize:(totalcount/pagesize+1));
        pageMode.setData(carts);
        return  pageMode;
    }

    public static void main(String[] args) {
        CartMybatisImpl c=new CartMybatisImpl();
        Cart cart=c.findById(26);
        cart.setProductNum(2);
        cart.setTotalprice(20.0);
        System.out.println(c.findAllCart());
        String json = JSONArray.toJSONString(c.findCartByPage(1,4));
       System.out.println(json);

    }
}
