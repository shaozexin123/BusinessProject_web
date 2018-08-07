package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.dao.impl.mybatis.ProductMybatisImpl;
import com.neuedu.entity.PageMode;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("pService")
@Scope("singleton")
public class ProductServiceImpl implements ProductService {
	@Resource(name="productMybatisImpl")
	
	ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		
		return productDao.addProduct(product);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(id);
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub

		return productDao.findById(id);
	}

	@Override
	public PageMode<Product> findProductByPage(int pageno, int pagesize) {
		// TODO Auto-generated method stub
		return productDao.findProductByPage(pageno, pagesize);
		
	}


}
