package com.onlineShop.onlineCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShop.onlineCart.entity.Customer;
import com.onlineShop.onlineCart.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class MainController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customerInfo")
	public List<Customer> getDetails() {
		return customerService.getDetails();
	}
	
	@GetMapping("/{customerName}")
	public List<Customer> getCustomer(@PathVariable String customerName){
		return customerService.getCustomer(customerName);
	}
	
	@PostMapping("/newCustomer")
	public int addDetails(@RequestBody Customer customer) {
		return customerService.addDetails(customer);
	}
	
	@PutMapping("/details")
	public int updateDetails(@RequestBody Customer customer) {
		return customerService.updateDetails(customer);
	}
	
	@DeleteMapping("/customer/{id}")
	public int deleteDetails(@PathVariable int id) {
		return customerService.deleteDetails(id);
	}
}
