package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;

public class PageMode<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8028736974276076229L;
	private List<T> data;
	private int totalPage;
	private int currentpage;
	
	public PageMode(List<T> data, int totalPage, int currentpage) {
		super();
		this.data = data;
		this.totalPage = totalPage;
		this.currentpage = currentpage;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public PageMode(List<T> data, int totalPage) {
		super();
		this.data = data;
		this.totalPage = totalPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public PageMode() {
		super();
	}
}
