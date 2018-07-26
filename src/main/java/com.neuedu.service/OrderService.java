package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageMode;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrder;

public interface OrderService {

	/**
	 * �û��µ�
	 * */
	boolean  createOrder(UserOrder userorder);
	
	/**
	 * 
	 * ���ɶ������order_no
	 * */
  long  generateOrderNo();
  /**ɾ������*/
  public  boolean deleteUserOrder(int id);
  /**����id��ѯ����*/
  public  UserOrder  findUserOrderById(int id);

//	List<UserOrder> findAllOrder();
  /**
	 * ��ҳ��ѯ
	 * pageno:�ڼ�ҳ
	 * pagesize:�ж�����
	 * */
	public PageMode<UserOrder> findUserOrderByPage(int pageno, int pagesize);
}
