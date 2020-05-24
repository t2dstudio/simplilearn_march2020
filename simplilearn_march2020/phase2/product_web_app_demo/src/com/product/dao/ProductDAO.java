package com.product.dao;

import java.util.List;

import com.product.exception.BusinessException;
import com.product.model.Product;

public interface ProductDAO {

	public Product addProduct(Product product) throws BusinessException;
	public Product getProductById(int id) throws BusinessException;
	public List<Product> getProductByManufacturerName(String manufacturerName) throws BusinessException;
	public Product updateProductsPrice(int id, double newCost) throws BusinessException;
	public void deleteProduct(int id) throws BusinessException;
	public List<Product> getAllProducts() throws BusinessException;
}
