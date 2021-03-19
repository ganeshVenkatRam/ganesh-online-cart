package com.onlineShop.onlineCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShop.onlineCart.entity.ProductInfo;
import com.onlineShop.onlineCart.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/details")
	public List<ProductInfo> getProductDetails(){
		System.out.println("Test - Rest API getProductDetails()...");
		return productService.getProductDetails();
	}
	
	@GetMapping("/{productName}")
	public List<ProductInfo> getProduct(@PathVariable String productName){
		System.out.println("Test - Rest API getProduct()...");
		return productService.getProduct(productName);
	}
}
