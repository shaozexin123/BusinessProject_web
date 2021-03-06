//package com.neuedu.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.neuedu.dao.CartDao;
//import com.neuedu.dao.OrderDao;
//import com.neuedu.dao.OrderItemDao;
//import com.neuedu.dao.impl.jdbc.OrderDaoImpl;
//import com.neuedu.dao.impl.jdbc.OrderItemDaoImpl;
//import com.neuedu.dao.impl.mybatis.CartMybatisImpl;
//import com.neuedu.dao.impl.mybatis.OrderMybatisImpl;
//import com.neuedu.entity.Cart;
//import com.neuedu.entity.PageMode;
//import com.neuedu.entity.Product;
//import com.neuedu.entity.UserOrder;
//import com.neuedu.entity.UserOrderItem;
//import com.neuedu.service.OrderService;
//import com.neuedu.utils.Utils;
//
//public class OrderServiceImpl implements OrderService {
//
//	CartDao cartDao=new CartMybatisImpl();
//	OrderDao orderDao=new OrderMybatisImpl();
//	OrderItemDao orderItemDao=new OrderItemDaoImpl();
//	@Override
//	public boolean createOrder(UserOrder userorder) {
//		return orderDao.createOrder(userorder);
////		// TODO Auto-generated method stub
////
////		//step1:获取购物车中的购物信息  List<Cart>
////		List<Cart> carts= cartDao.findAllCart();
////		 if(carts==null||carts.size()<=0) {
////			 return false;
////		 }
////		//step2:生成订单实体类 UserOrder
////		   UserOrder   userOrder=createUserOrder();
////
////		//step3:将购物信息集合转成订单明细集合List<UserOrderItem>
////		  List<UserOrderItem> orderItems=new ArrayList<UserOrderItem>();
//// 		   for(int i=0;i<carts.size();i++) {
//// 			   Cart cart=carts.get(i);
//// 			   UserOrderItem orderItem= Utils.convertToOrderItem(orderItemDao.generateOrderItemId(), userOrder.getOrder_no(), cart);
////
//// 			  //step4:检验库存
//// 			   if(orderItem.getQuantity()<=cart.getProduct().getStock()) {
//// 				   //库存充足
//// 				  orderItems.add(orderItem);
//// 			   }else {//库存不足
//// 				  return false;
//// 			   }
////
////
//// 		   }
////		 //step5:计算订单价格
//// 		   userOrder.setPayment(getOrderPrice(orderItems));
////		//step5:下单
//// 		   orderDao.createOrder(userOrder);
//// 		   orderItemDao.addOrderItems(orderItems);
////
////		//step6:扣库存
////
//// 		   for(int  i=0;i<carts.size();i++) {
//// 			   Cart cart=carts.get(i);
//// 			   Product product=cart.getProduct();
//// 			   int leftStock=product.getStock()-cart.getProductNum();
//// 			   product.setStock(leftStock);
//// 		   }
////
////		//step7:清空购物车
////
////		cartDao.clearCart();
////
////
////
////
////		return true;
//	}
//
//
//	/**
//	 * 生成订单对象
//	 * */
//	public  UserOrder createUserOrder() {
//
//		UserOrder order=new UserOrder();
//		//设置订单id
//		order.setId(orderDao.generateOrderId());
//		// 1s=1000ms  1970 1.1 - 当前
//		order.setOrder_no(generateOrderNo());
////		order.setCreate_time(System.currentTimeMillis());
//
//		return order;
//	}
//
//	/**
//	 * 生成订单号
//	 * */
//
//	@Override
//	public long generateOrderNo() {
//		// TODO Auto-generated method stub
//		return System.currentTimeMillis();
//	}
//
//	/**
//	 * 计算订单价格
//	 * */
//	public  double  getOrderPrice(List<UserOrderItem> items) {
//		double  totalPrice=0.0;
//		for(int i=0;i<items.size();i++) {
//			totalPrice+=items.get(i).getTotal_price();
//		}
//		return  totalPrice;
//	}
//
//
//	@Override
//	public PageMode<UserOrder> findUserOrderByPage(int pageno, int pagesize) {
//		// TODO Auto-generated method stub
//		return orderDao.findUserOrderByPage(pageno, pagesize);
//	}
//
//
//	@Override
//	public boolean deleteUserOrder(int id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//	@Override
//	public UserOrder findUserOrderById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//}















package com.neuedu.service.impl;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.OrderDao;
import com.neuedu.dao.OrderItemDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.dao.impl.mybatis.CartMybatisImpl;
import com.neuedu.dao.impl.mybatis.OrderItemMybatisImpl;
import com.neuedu.dao.impl.mybatis.OrderMybatisImpl;
import com.neuedu.dao.impl.mybatis.ProductMybatisImpl;
import com.neuedu.entity.*;
import com.neuedu.service.OrderService;
import com.neuedu.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("orderService")
@Scope("singleton")
public class OrderServiceImpl implements OrderService {

//	CartDao cartDao=new CartMybatisImpl();
	@Autowired
	OrderDao orderDao;
//	OrderItemDao orderItemDao=new OrderItemMybatisImpl();
//	ProductDao productDao=new ProductMybatisImpl();
	@Override
	public boolean createOrder(UserOrder userOrder) {
		return  orderDao.createOrder(userOrder);
	}
		// TODO Auto-generated method stub

		//step1:获取购物车中的购物信息  List<Cart>
		@Override
		public boolean createOrder() {
//		List<Cart> carts= cartDao.findAllCart();
//		if(carts==null||carts.size()<=0) {
//			return false;
//		}
//		//step2:生成订单实体类 UserOrder
//		  UserOrder userOrder=createUserOrder();
//
//		//step3:将购物信息集合转成订单明细集合List<UserOrderItem>
//		List<UserOrderItem> orderItems=new ArrayList<UserOrderItem>();
//		for(int i=0;i<carts.size();i++) {
//			Cart cart=carts.get(i);
//			UserOrderItem orderItem= Utils.convertToOrderItem(orderItemDao.generateOrderItemId(), userOrder.getOrder_no(), cart);
//
//			//step4:检验库存
//			if(orderItem.getQuantity()<=cart.getProduct().getStock()) {
//				//库存充足
//				orderItems.add(orderItem);
//			}else {//库存不足
//				return false;
//			}
//
//
//		}
//		//step5:计算订单价格
//		userOrder.setPayment(getOrderPrice(orderItems));
//		//step5:下单
//		orderDao.createOrder(userOrder);
//		orderItemDao.addOrderItems(orderItems);
//
//		//step6:扣库存
//
//		for(int  i=0;i<carts.size();i++) {
//			Cart cart=carts.get(i);
//			Product product=cart.getProduct();
//			int leftStock=product.getStock()-cart.getProductNum();
//			//修改商品库存
//			product.setStock(leftStock);
//			productDao.updateProduct(product);
//		}
//
//		//step7:清空购物车
//
//		cartDao.clearCart();




		return true;
	}


	/**
	 * 生成订单对象
	 * */
	public  UserOrder createUserOrder() {

		UserOrder order=new UserOrder();

		// 1s=1000ms  1970 1.1 - 当前
		order.setOrder_no(generateOrderNo());
//		order.setCreate_time(System.currentTimeMillis());

		return order;
	}

////	@Override
//	public boolean createOrder(UserOrder userorder) {
//		return false;
//	}

	/**
	 * 生成订单号
	 * */

	@Override
	public long generateOrderNo() {
		// TODO Auto-generated method stub
		return System.currentTimeMillis();
	}

	@Override
	public boolean deleteUserOrder(int id) {
		return false;
	}

	@Override
	public UserOrder findUserOrderById(int id) {
		return null;
	}

	@Override
	public PageMode<UserOrder> findUserOrderByPage(int pageno, int pagesize) {
		return orderDao.findUserOrderByPage(pageno, pagesize);
	}

	/**
	 * 计算订单价格
	 * */
	public  double  getOrderPrice(List<UserOrderItem> items) {
		double  totalPrice=0.0;
		for(int i=0;i<items.size();i++) {
			totalPrice+=items.get(i).getTotal_price();
		}
		return  totalPrice;
	}

}
