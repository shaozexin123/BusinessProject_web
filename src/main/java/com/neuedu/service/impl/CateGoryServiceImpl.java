package com.neuedu.service.impl;

import com.neuedu.dao.CateGoryDao;
import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageMode;
import com.neuedu.service.CateGoryService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("cService")
@Scope("singleton")
public class CateGoryServiceImpl implements CateGoryService {
@Resource(name = "categoryMybatisImpl")
	CateGoryDao categoryDao;

	public void setCategoryDao(CateGoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public boolean addCateGory(CateGory category) {
		// TODO Auto-generated method stub
		return categoryDao.addCateGory(category);
	}

	@Override
	public List<CateGory> findAll() {
		// TODO Auto-generated method stub
		return categoryDao. findAll();
	}

	@Override
	public boolean updateCateGory(CateGory category) {
		// TODO Auto-generated method stub
		return categoryDao.updateCateGory(category);
	}

	@Override
	public boolean deleteCateGory(int id) {
		// TODO Auto-generated method stub
		return categoryDao.deleteCateGory(id);
	}

	@Override
	public CateGory findCateGoryById(int id) {
		// TODO Auto-generated method stub
		return categoryDao.findById(id);
	}

	@Override
	public PageMode<CateGory> findCateGoryByPage(int pageno, int pagesize) {
		// TODO Auto-generated method stub
		return categoryDao.findCateGoryByPage(pageno, pagesize);
	}

}
