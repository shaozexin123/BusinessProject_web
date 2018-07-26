package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageMode;


public interface CateGoryService {
	/**������*/
    public  boolean addCateGory(CateGory category);	
    /**��ѯ���*/
    public  List<CateGory> findAll();
    /**�޸����*/
    public  boolean  updateCateGory(CateGory category);
    /**ɾ�����*/
    public  boolean deleteCateGory(int id);
    /**����id��ѯ��Ʒ���*/
    public  CateGory  findCateGoryById(int id);
    /**
	 * ��ҳ��ѯ
	 * pageno:�ڼ�ҳ
	 * pagesize:�ж�����
	 * */
	public PageMode<CateGory> findCateGoryByPage(int pageno, int pagesize);
}
