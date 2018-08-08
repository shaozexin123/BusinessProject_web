package com.neuedu.dao.impl.mybatis;

import com.alibaba.fastjson.JSONArray;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageMode;
import com.neuedu.entity.Product;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductMybatisImpl implements ProductDao {
    @Resource(name="sqlSession")
    private SqlSession sqlSession;
    @Override
    public boolean addProduct(Product product) {
//        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
//        SqlSession sqlSession=factory.openSession();
//        Map<String,Integer> map=new HashMap<String,Integer>();
//        map.put("accountid",_accountid);
        int i=sqlSession.insert("com.neuedu.entity.Product.addProduct",product);
//        sqlSession.commit();
        if(i==1){
            return true;}
        return false;
    }

    @Override
    public List<Product> findAll() {
//        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
//        SqlSession sqlSession=factory.openSession();
//        Map<String,Integer> map=new HashMap<String,Integer>();
//        map.put("accountid",_accountid);
        List<Product> products=sqlSession.selectList("com.neuedu.entity.Product.findAll");

//        MyBatisUtils.close(sqlSession);
        return products;
    }


    public String findAllJson() {
        ProductMybatisImpl pm=new ProductMybatisImpl();
        List<Product> users = pm.findAll();
        String json = JSONArray.toJSONString(users);
        return json;
    }

    @Override
    public boolean updateProduct(Product product) {
//        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
//        SqlSession sqlSession=factory.openSession();

        int o=sqlSession.update("com.neuedu.entity.Product.updateProduct",product);
//        sqlSession.commit();
//        MyBatisUtils.close(sqlSession);
        if(o==1){
            return true;}
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
//        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
//        SqlSession sqlSession=factory.openSession();
        int o=sqlSession.delete("com.neuedu.entity.Product.deleteProduct",id);
//        sqlSession.commit();
//        MyBatisUtils.close(sqlSession);
        if(o==1){
            return true;}
        return false;
    }

    @Override
    public Product findById(int id) {
//        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
//        SqlSession sqlSession=factory.openSession();

        Product product=sqlSession.selectOne("com.neuedu.entity.Product.findById",id);

//        MyBatisUtils.close(sqlSession);
        return product;
    }

    @Override
    public PageMode<Product> findProductByPage(int pageno, int pagesize) {
//        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
//        SqlSession sqlSession=factory.openSession();
        int totalcount=sqlSession.selectOne("com.neuedu.entity.Product.findTotalCount");
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("offset",(pageno-1)*pagesize);
        map.put("pageSize",pagesize);
        List<Product> products=sqlSession.selectList("com.neuedu.entity.Product.findProductByPage",map);
        PageMode<Product> pageMode=new PageMode<Product>();
        pageMode.setTotalPage((totalcount%pagesize)==0?totalcount/pagesize:(totalcount/pagesize+1));
        pageMode.setData(products);
        return  pageMode;
    }
    public static  void  main(String[] args){
        ProductMybatisImpl pm=new ProductMybatisImpl();
//        Product p=new Product();
        Product p=pm.findById(23);
        p.setCategoryid(1);
        p.setDesc("1");
        p.setImage("1");
        p.setName("zhangsan");
        p.setRule("4");
        p.setStock(4);
        p.setPrice(1.0);
//        System.out.println(pm.addProduct(p));
//        System.out.println(pm.findById(1));

    }
}
