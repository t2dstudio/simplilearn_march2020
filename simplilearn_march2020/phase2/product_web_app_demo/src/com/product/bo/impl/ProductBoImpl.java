package com.product.bo.impl;

import java.util.List;

import com.product.bo.ProductBO;
import com.product.dao.ProductDAO;
import com.product.dao.impl.ProductDaoImpl;
import com.product.exception.BusinessException;
import com.product.model.Product;

public class ProductBoImpl implements ProductBO {

	private ProductDAO dao;

	public ProductDAO getDao() {
		if (dao == null) {
			dao = new ProductDaoImpl();
		}
		return dao;
	}

	@Override
	public Product addProduct(Product product) throws BusinessException {
		if (product == null || product.getName()==null) {
			throw new BusinessException("Product details cannot be empty");
		} else if (!product.getName().matches("[a-zA-Z ]{3,15}")) {
			throw new BusinessException("Product name " + product.getName() + " is invalid");
		} else {
			// code here for storage layer.
			product = getDao().addProduct(product);
		}

		return product;
	}

	private boolean isValidProductId(int id) {
		if ((id + "").matches("[0-9]{5}")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Product getProductById(int id) throws BusinessException {
		Product product = null;
		if (isValidProductId(id)) {
			product = getDao().getProductById(id);
		}else {
			throw new BusinessException("Entered Id "+id+" is invalid");
		}
		return product;
	}

	@Override
	public List<Product> getProductByManufacturerName(String manufacturerName) throws BusinessException {

		return getDao().getProductByManufacturerName(manufacturerName);
	}

	@Override
	public Product updateProductsPrice(int id, double newCost) throws BusinessException {
		Product product = null;
		if (isValidProductId(id)) {
			product = getDao().updateProductsPrice(id, newCost);
		}else {
			throw new BusinessException("Entered Id "+id+" is invalid");
		}
		return product;
	}

	@Override
	public void deleteProduct(int id) throws BusinessException {
		if (isValidProductId(id)) {
			getDao().deleteProduct(id);
		}else {
			throw new BusinessException("Entered Id "+id+" is invalid");
		}

	}

}
