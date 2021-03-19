package com.onlineShop.onlineCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineShop.onlineCart.entity.Customer;
import com.onlineShop.onlineCart.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getDetails() {
		return customerRepository.getDetails();
	}
	
	public int addDetails(Customer customer) {
		return customerRepository.addDetails(customer);
	}
	
	public int updateDetails(Customer customer) {
		return customerRepository.updateDetails(customer);
	}
	
	public int deleteDetails(int id) {
		return customerRepository.deleteDetails(id);
	}

	public List<Customer> getCustomer(String customerName) {
		return customerRepository.getCustomer(customerName);
	}
}
