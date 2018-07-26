package com.neuedu.dao;

import com.neuedu.entity.CateGory;
import com.neuedu.entity.PageMode;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrder;

public interface OrderDao {

	/**
	 * ��������
	 * */
	
   boolean  createOrder(UserOrder userOrder);
   
   /**
    * ���ɶ���id
    * */
   int  generateOrderId();
   public PageMode<UserOrder> findUserOrderByPage(int pageno, int pagesize);
   /**
	 * ɾ������
	 * */
	boolean  deleteUserOrder(int id);
	
	/**����id��ѯ����*/
	UserOrder  findById(int id);
}
