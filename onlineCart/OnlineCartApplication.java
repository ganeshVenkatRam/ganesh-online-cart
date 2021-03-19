package com.onlineShop.onlineCart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.onlineShop.onlineCart.entity.Customer;
import com.onlineShop.onlineCart.rowMapper.CustomerRowMapper;

@SpringBootApplication
public class OnlineCartApplication implements CommandLineRunner{
	
	@Autowired
	private JdbcTemplate jdbcTmplate;
	public static void main(String[] args) {
		SpringApplication.run(OnlineCartApplication.class, args);
		System.out.println("CRUD in SpringBoot web App with Postgresql DB");
	}
	@Override
	public void run(String... args) throws Exception {
		String selectSql = "SELECT * FROM dbo.\"customerDetails\"";
		List<Customer> customerList = jdbcTmplate.query(selectSql, new CustomerRowMapper());
		System.out.println("data from customerDetails table : \n");
		customerList.forEach((info) -> 
			System.out.println(info.getCustomerName() + " " + info.getAge() + " " + info.getAddress()));
	}

}
