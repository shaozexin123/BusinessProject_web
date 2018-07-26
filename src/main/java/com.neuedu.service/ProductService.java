package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.PageMode;
import com.neuedu.entity.Product;

public interface ProductService {

	/**�����Ʒ*/
    public  boolean addProduct(Product product);	
    /**��ѯ��Ʒ*/
    public  List<Product> findAll();
    /**�޸���Ʒ*/
    public  boolean  updateProduct(Product product);
    /**ɾ����Ʒ*/
    public  boolean deleteProduct(int id);
    /**����id��ѯ��Ʒ��Ϣ*/
    public  Product  findProductById(int id);
    /**
	 * ��ҳ��ѯ
	 * pageno:�ڼ�ҳ
	 * pagesize:�ж�����
	 * */
	public PageMode<Product> findProductByPage(int pageno, int pagesize);
}
