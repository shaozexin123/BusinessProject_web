package com.neuedu.entity;

import java.io.Serializable;

/**
 * 购物车实体类
 * */
public class Cart  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5117733379863943502L;
	private  int id;
	private  Product  product;
//	private  int productid;
	private  int  productNum;//商品数量
	private  double productprice;
	private  double totalprice;
	public double getProductprice() {
		return productprice;
	}
	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	
//	public Cart(int id, int productid, int productNum, double productprice, double totalprice) {
//		super();
//		this.id = id;
//		this.productid = productid;
//		this.productNum = productNum;
//		this.productprice = productprice;
//		this.totalprice = totalprice;
//	}
//	public Cart(int id, Product product, int productid, int productNum, double productprice, double totalprice) {
//		super();
//		this.id = id;
//		this.product = product;
//		this.productid = productid;
//		this.productNum = productNum;
//		this.productprice = productprice;
//		this.totalprice = totalprice;
//	}
//	public int getProductid() {
//		return productid;
//	}
//	public void setProductid(int productid) {
//		this.productid = productid;
//	}
//	public Cart(int id, int productid, int productNum) {
//		super();
//		this.id = id;
//		this.productid = productid;
//		this.productNum = productNum;
//	}
	public Cart(int id, Product product, int productNum) {
		super();
		this.id = id;
		this.product = product;
		this.productNum = productNum;
	}
	public Cart() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
//	@Override
//	public String toString() {
//		return "Cart [id=" + id + ", productid=" + productid + ", productNum=" + productNum + ", productprice=" + productprice + ", totalprice=" + totalprice+ "]";
//	}
	
	
	
	
	
	
}
