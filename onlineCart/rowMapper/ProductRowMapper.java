package com.onlineShop.onlineCart.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.onlineShop.onlineCart.entity.ProductInfo;

public class ProductRowMapper implements RowMapper<ProductInfo>{

	@Override
	public ProductInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setId(rs.getInt("id"));
		productInfo.setProdName(rs.getString("prodName"));
		productInfo.setProdCategory(rs.getString("prodCategory"));
		productInfo.setPrice(rs.getInt("price"));
		productInfo.setQuantity(rs.getInt("quantity"));
		productInfo.setTotalStock(rs.getInt("totalStock"));
		return productInfo;
	}
	
}
