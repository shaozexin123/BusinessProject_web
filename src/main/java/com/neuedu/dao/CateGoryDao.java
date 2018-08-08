package com.neuedu.dao;

import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageMode;

import java.util.List;

public interface CateGoryDao {
	 /**
	  * ������
	  * */
	boolean  addCateGory(CateGory category);
	/**
	 * �鿴���
	 * */
	List<CateGory> findAll();
	/**
	 * �޸����
	 * */
	boolean  updateCateGory(CateGory category);
	/**
	 * ɾ�����
	 * */
	boolean  deleteCateGory(int id);
	
	/**����id��ѯ���*/
	CateGory  findById(int id);
   PageMode<CateGory> findCateGoryByPage(int pageno, int pagesize);
}
