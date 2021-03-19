package com.onlineShop.onlineCart.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.onlineShop.onlineCart.entity.Customer;
import com.onlineShop.onlineCart.rowMapper.CustomerRowMapper;

@Repository
public class CustomerRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<Customer> getDetails() {
		String selectSql = "SELECT * FROM dbo.\"customerDetails\"";
		List<Customer> customerList = jdbcTemplate.query(selectSql, new CustomerRowMapper());
		return customerList;
	}
	
	public int addDetails(Customer customer) {
		return jdbcTemplate.update("insert into dbo.\"customerDetails\" (id, customername, age, address) values(?, ?, ?, ?)",
				customer.getId(), customer.getCustomerName(), customer.getAge(), customer.getAddress());
	}
	
	public int updateDetails(Customer customer) {
		return jdbcTemplate.update("update dbo.\"customerDetails\" set address = ? where customername = ?",  
				customer.getAddress(), customer.getCustomerName());
	}
	
	public int deleteDetails(int id) {
		return jdbcTemplate.update("delete from dbo.\"customerDetails\" where id = ?", id);
	}

	public List<Customer> getCustomer(String customerName) {
		String selectSql = "SELECT * FROM dbo.\"customerDetails\" where \"customername\" = \'" + customerName + "\'";
		List<Customer> customerList = jdbcTemplate.query(selectSql, new CustomerRowMapper());
		return customerList;
	}
}
