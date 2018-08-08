package com.neuedu.service;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageMode;

import java.util.List;


public interface CartService {

	/**
	 * ��ӹ��ﳵ
	 **/
	boolean  addCart(Cart cart);
	/**
	 * ɾ��
	 * */
	boolean  deleteCart(int id);
	/**
	 * �޸Ĺ��ﳵ
	 * */
	boolean  updataeCart(Cart cart);
	/**
	 * ��ѯ���ﳵ
	 * */
	List<Cart> findAllCart();
	
	/**
	 * ��ȡ���ﳵ����Ʒ����
	 * */
	int  getCartNum();
	/**�޸Ĺ��ﳵ��Ʒ����
	 * @param  id  Ҫ�޸ĵĹ��ﳵ��Id
	 * @param  num �޸ĺ������
	 * */
	boolean  updateCart(int id, int num);
	/**����id��ѯ���ﳵ��Ϣ*/
    public  Cart  findCartById(int id);
    /**
   	 * ��ҳ��ѯ
   	 * pageno:�ڼ�ҳ
   	 * pagesize:�ж�����
   	 * */
   	public PageMode<Cart> findCartByPage(int pageno, int pagesize);
}
