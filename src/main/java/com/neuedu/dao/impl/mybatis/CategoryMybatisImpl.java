package com.neuedu.dao.impl.mybatis;

import com.neuedu.dao.CateGoryDao;
import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageMode;
import com.neuedu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CategoryMybatisImpl implements CateGoryDao {
    @Resource(name="sqlSession")
    private SqlSession sqlSession;
    @Override
    public boolean addCateGory(CateGory category) {
//        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
//        SqlSession sqlSession=factory.openSession();
        int i=sqlSession.insert("com.neuedu.entity.CateGory.addCateGory",category);
//        sqlSession.commit();
        if(i==1){
            return true;}
        return false;
    }

    @Override
    public List<CateGory> findAll() {
        return null;
    }

    @Override
    public boolean updateCateGory(CateGory category) {
//        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
//        SqlSession sqlSession=factory.openSession();
        int o=sqlSession.update("com.neuedu.entity.CateGory.updateCateGory",category);
//        sqlSession.commit();
//        MyBatisUtils.close(sqlSession);
        if(o==1){
            return true;}
        return false;
    }

    @Override
    public boolean deleteCateGory(int id) {
//        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
//        SqlSession sqlSession=factory.openSession();
        int o=sqlSession.delete("com.neuedu.entity.CateGory.deleteCateGory",id);
//        sqlSession.commit();
//        MyBatisUtils.close(sqlSession);
        if(o==1){
            return true;}
        return false;
    }

    @Override
    public CateGory findById(int id) {
//        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
//        SqlSession sqlSession=factory.openSession();

        CateGory cateGory=sqlSession.selectOne("com.neuedu.entity.CateGory.findById",id);

//        MyBatisUtils.close(sqlSession);
        return cateGory;
    }

    @Override
    public PageMode<CateGory> findCateGoryByPage(int pageno, int pagesize) {
//        SqlSessionFactory factory= MyBatisUtils.getSqlSessionFactory();
//        SqlSession sqlSession=factory.openSession();
        int totalcount=sqlSession.selectOne("com.neuedu.entity.CateGory.findTotalCount");
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("offset",(pageno-1)*pagesize);
        map.put("pageSize",pagesize);
        List<CateGory> cateGories=sqlSession.selectList("com.neuedu.entity.CateGory.findProductByPage",map);
        PageMode<CateGory> pageMode=new PageMode<CateGory>();
        pageMode.setTotalPage((totalcount%pagesize)==0?totalcount/pagesize:(totalcount/pagesize+1));
        pageMode.setData(cateGories);
        return  pageMode;
    }

    public static void main(String[] args) {
        CategoryMybatisImpl c=new CategoryMybatisImpl();
        CateGory cateGory=c.findById(11);
        cateGory.setName("2");
        cateGory.setParent_id(2);
        cateGory.setSort_order(2);
        cateGory.setStatus(2);
        System.out.println(c.updateCateGory(cateGory));

    }
}
