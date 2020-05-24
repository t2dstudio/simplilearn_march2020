package com.product.bo;

import java.util.List;

import com.product.exception.BusinessException;
import com.product.model.Product;

public interface ProductBO {

	public Product addProduct(Product product) throws BusinessException;
	public Product getProductById(int id) throws BusinessException;
	public List<Product> getProductByManufacturerName(String manufacturerName) throws BusinessException;
	public Product updateProductsPrice(int id, double newCost) throws BusinessException;
	public void deleteProduct(int id) throws BusinessException;
	
	//public List<Product> getByProductsRating(float rating);
	//public List<Product> getByProductsBetweenRatingRange(float minValue, float maxValue);
	//public List<Product> getProductsByName(String name);
}
