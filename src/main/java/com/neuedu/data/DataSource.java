package com.neuedu.data;

import com.neuedu.entity.*;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

	//定义商品集合
	public static List<Product> products=new ArrayList<Product>();
	//定义商品类别集合
	public static List<CateGory> categorys=new ArrayList<CateGory>();
	//购物车集合
	public  static List<Cart> carts=new ArrayList<Cart>();
	
	//我的订单集合
	public  static  List<UserOrder> orders=new ArrayList<UserOrder>();
	//订单明细结合
	public  static  List<UserOrderItem> orderItems=new ArrayList<UserOrderItem>();
	
	
	
	
	
}
