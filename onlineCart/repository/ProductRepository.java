package com.onlineShop.onlineCart.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.onlineShop.onlineCart.entity.ProductInfo;
import com.onlineShop.onlineCart.rowMapper.ProductRowMapper;

@Repository
public class ProductRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ProductInfo> getProductDetails(){
		String selectSql = "SELECT * FROM dbo.\"productInfo\"";
		List<ProductInfo> productList = jdbcTemplate.query(selectSql, new ProductRowMapper());
		return productList;
	}

	public List<ProductInfo> getProduct(String productName) {
		String selectSql = "SELECT * FROM dbo.\"productInfo\" where \"prodName\" = \'" + productName + "\'";
		List<ProductInfo> productList = jdbcTemplate.query(selectSql, new ProductRowMapper());
		return productList;
	}
	
	
}
