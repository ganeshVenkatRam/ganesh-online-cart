package com.onlineShop.onlineCart.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.onlineShop.onlineCart.entity.CartInfo;

public class CartRowMapper implements RowMapper<CartInfo>{

	@Override
	public CartInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		CartInfo cartInfo = new CartInfo();
		cartInfo.setCustomerName(rs.getString("customerName"));
		cartInfo.setProdName(rs.getString("prodName"));
		cartInfo.setQuantity(rs.getInt("quantity"));
		return cartInfo;
	}

}
