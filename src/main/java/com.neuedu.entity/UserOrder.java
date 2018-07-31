package com.neuedu.entity;

import java.io.Serializable;

/**
 * 订单实体类
 * */
public class UserOrder  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5144155657522917012L;
	private  int  id;
	private long order_no;
	private int user_id;
	private int shipping_id;
	private double  payment;//实际付款金额
	private int payment_type;
	private int  postage;
	private int  status;
	private String  payment_time;
	private String  send_time;
	private String  end_time;
	private String close_time;
	private String  create_time;
	private String update_time;
	public UserOrder(int id, long order_no, int user_id, int shipping_id, double payment, int payment_type, int postage,
			int status, String payment_time, String send_time, String end_time, String close_time, String create_time,
			String update_time) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.user_id = user_id;
		this.shipping_id = shipping_id;
		this.payment = payment;
		this.payment_type = payment_type;
		this.postage = postage;
		this.status = status;
		this.payment_time = payment_time;
		this.send_time = send_time;
		this.end_time = end_time;
		this.close_time = close_time;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public UserOrder() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(long order_no) {
		this.order_no = order_no;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getShipping_id() {
		return shipping_id;
	}
	public void setShipping_id(int shipping_id) {
		this.shipping_id = shipping_id;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public int getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(int payment_type) {
		this.payment_type = payment_type;
	}
	public int getPostage() {
		return postage;
	}
	public void setPostage(int postage) {
		this.postage = postage;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getClose_time() {
		return close_time;
	}
	public void setClose_time(String close_time) {
		this.close_time = close_time;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public UserOrder(long order_no, int user_id, int shipping_id, double payment, int payment_type, int postage, int status) {
		this.order_no = order_no;
		this.user_id = user_id;
		this.shipping_id = shipping_id;
		this.payment = payment;
		this.payment_type = payment_type;
		this.postage = postage;
		this.status = status;
	}

	public UserOrder(int id, long order_no, int user_id, int shipping_id, double payment, int payment_type, int postage,
					 int status, String payment_time, String create_time, String update_time) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.user_id = user_id;
		this.shipping_id = shipping_id;
		this.payment = payment;
		this.payment_type = payment_type;
		this.postage = postage;
		this.status = status;
		this.payment_time = payment_time;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	@Override
//	public String toString() {
//		return "UserOrder [id=" + id + ", order_no=" + order_no + ", user_id=" + user_id + ", shipping_id="
//				+ shipping_id + ", payment=" + payment + ", payment_type=" + payment_type + ", postage=" + postage
//				+ ", status=" + status + ", payment_time=" + payment_time + ", send_time=" + send_time + ", end_time="
//				+ end_time + ", close_time=" + close_time + ", create_time=" + create_time + ", update_time="
//				+ update_time + "]";
//	}
	public String toString() {
		return "UserOrder [id=" + id + ", order_no=" + order_no + ", user_id=" + user_id + ", shipping_id="
				+ shipping_id + ", payment=" + payment + ", payment_type=" + payment_type + ", postage=" + postage
				+ ", status=" + status + ", payment_time=" + payment_time + ", send_time=" + send_time + ", end_time="
				+ end_time + ", close_time=" + close_time + ", create_time=" + create_time + ", update_time="
				+ update_time + "]";
	}
	
	
	
	
}
