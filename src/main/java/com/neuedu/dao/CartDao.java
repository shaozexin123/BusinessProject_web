package com.neuedu.dao;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageMode;

import java.util.List;

/**
 * 
 * 
 * ���ﳵ
 * */
public interface CartDao {

	/**
	 * ��ӹ��ﳵ
	 **/
	boolean  addCart(Cart cart);
	/**
	 * ɾ��������Ϣ��Id
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
	 * @param  id  Ҫ�޸ĵ���Ʒ��Id
	 * @param  num �޸ĺ������
	 * */
	boolean  updateCart(int id, int num);
	

	/**
	 * ��չ��ﳵ
	 * */
	void  clearCart() ;
	/**����id��ѯ���ﳵ*/
	Cart  findById(int id);
	
	/**
	 * ��ҳ��ѯ
	 * pageno:�ڼ�ҳ
	 * pagesize:�ж�����
	 * */
	public PageMode<Cart> findCartByPage(int pageno, int pagesize);
	
	
}
