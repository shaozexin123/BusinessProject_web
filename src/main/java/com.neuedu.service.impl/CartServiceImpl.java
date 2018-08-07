package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.impl.mybatis.CartMybatisImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageMode;
import com.neuedu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("cartService")
@Scope("singleton")
public class CartServiceImpl implements CartService {



	@Resource(name="cartMybatisImpl")
	CartDao cartDao;

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.addCart(cart);
	}

	@Override
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		return cartDao.deleteCart(id);
	}

	@Override
	public boolean updataeCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.updataeCart(cart);
	}

	@Override
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub
		return cartDao.findAllCart();
	}

	@Override
	public int getCartNum() {
		// TODO Auto-generated method stub
		return cartDao.getCartNum();
	}

	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		return cartDao.updateCart(id, num);
	}

	@Override
	public Cart findCartById(int id) {
		// TODO Auto-generated method stub
		return cartDao.findById(id);
	}

	@Override
	public PageMode<Cart> findCartByPage(int pageno, int pagesize) {
		// TODO Auto-generated method stub
		return cartDao.findCartByPage(pageno, pagesize);
	}

}
