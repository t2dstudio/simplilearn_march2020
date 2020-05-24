package com.product.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.dbutil.OracleConnection;
import com.product.dao.ProductDAO;
import com.product.exception.BusinessException;
import com.product.model.Product;

public class ProductDaoImpl implements ProductDAO {

	private static Map<Integer, Product> productmap = new LinkedHashMap<>();

	@Override
	public Product addProduct(Product product) throws BusinessException {
		try (Connection connection = OracleConnection.getConnection()) {
			String sql = "{call ADDPRODUCT(?,?,?,?,?,?)}";
			CallableStatement callableStatement = connection.prepareCall(sql);
			callableStatement.setString(2, product.getName());
			callableStatement.setDouble(3, product.getCost());
			callableStatement.setFloat(4, product.getRating());
			callableStatement.setString(5, product.getManufacturerName());

			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);

			callableStatement.execute();

			product.setId(callableStatement.getInt(1));
			product.setUniqueId(callableStatement.getString(6));

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internall error occured kindly contact sysadmin");
		}

		return product;
	}

	@Override
	public Product getProductById(int id) throws BusinessException {
		Product product = null;
		try (Connection connection = OracleConnection.getConnection()) {
			String sql = "select name,cost,manufacturername,uniqueid,rating from product where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				product = new Product(id, resultSet.getString("name"), resultSet.getDouble("cost"),
						resultSet.getFloat("rating"), resultSet.getString("manufacturerName"));
				product.setUniqueId(resultSet.getString("uniqueid"));
			} else {
				throw new BusinessException("Product Id " + id + " doesnt exist");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internall error occured kindly contact sysadmin");
		}
		return product;
	}

	@Override
	public List<Product> getProductByManufacturerName(String manufacturerName) throws BusinessException {
		List<Product> productList = new ArrayList<>();
		for (Entry<Integer, Product> e : productmap.entrySet()) {
			if (e.getValue().getManufacturerName().equalsIgnoreCase(manufacturerName)) {
				productList.add(e.getValue());
			}
		}
		if (productList.size() == 0) {
			throw new BusinessException("No products found by the manufacturer name " + manufacturerName);
		}
		return productList;
	}

	@Override
	public Product updateProductsPrice(int id, double newCost) throws BusinessException {

		if (productmap.containsKey(id)) {
			Product product = productmap.get(id);
			product.setCost(newCost);
			productmap.put(id, product);
			return product;
		} else {
			throw new BusinessException("No product with id " + id);
		}
		// return null;
	}

	@Override
	public void deleteProduct(int id) throws BusinessException {
		try (Connection connection = OracleConnection.getConnection()) {
			String sql="delete from product where id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int c=preparedStatement.executeUpdate();
			if(c!=1) {
				throw new BusinessException("Deletion Failed");
			}
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internall error occured kindly contact sysadmin");
		}

	}

	@Override
	public List<Product> getAllProducts() throws BusinessException {
		List<Product> productList = new ArrayList<>();
		try (Connection connection = OracleConnection.getConnection()) {
			String sql = "select id,name,cost,manufacturername,uniqueid,rating from product";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Product product = new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDouble("cost"),
						resultSet.getFloat("rating"), resultSet.getString("manufacturerName"));
				product.setUniqueId(resultSet.getString("uniqueid"));
				productList.add(product);
			}
			
			if(productList.size()==0) {
				throw new BusinessException("No products YET");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internall error occured kindly contact sysadmin");
		}
		return productList;
	}

}
