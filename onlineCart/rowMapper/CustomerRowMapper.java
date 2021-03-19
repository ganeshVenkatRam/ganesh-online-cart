package com.onlineShop.onlineCart.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.onlineShop.onlineCart.entity.Customer;

public class CustomerRowMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getInt("id"));
		customer.setCustomerName(rs.getString("customername"));
		customer.setAge(rs.getInt("age"));
		customer.setAddress(rs.getString("address"));
		return customer;
	}
	
	
}
