package com.neuedu.entity;

import java.io.Serializable;

/**
 * javaʵ���� javaBean
 * ����JavaBean
 * (1)����˽��
 * (2)�ṩ�в�/�޲εĹ��췽��
 * ��3���ṩget/set����
 * ��4��ʵ�����л��ӿ�
 * */
public class Product implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6185202905228190806L;
	private  int  id; //��Ʒid
	private  String  name;//��Ʒ����
	private  String  pdesc;//��Ʒ����
	private  double  price;//��Ʒ�۸�
	private  String  rule;//��Ʒ���
	private String  image;
	private int categoryid;
	private  int  stock=100;//���
	
	
	public Product() {
		super();
	}

	public Product(String name, String desc, double price, String rule, String image, int stock, int categoryid) {
		this.name = name;
		this.pdesc = desc;
		this.price = price;
		this.rule = rule;
		this.image = image;
		this.categoryid = categoryid;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return pdesc;
	}

	public void setDesc(String desc) {
		this.pdesc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Product(int id, String name, String desc, double price, String rule, String image, int stock, int categoryid) {
		this.id = id;
		this.name = name;
		this.pdesc = desc;
		this.price = price;
		this.rule = rule;
		this.image = image;
		this.categoryid = categoryid;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + pdesc + ", price=" + price + ", rule=" + rule + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}