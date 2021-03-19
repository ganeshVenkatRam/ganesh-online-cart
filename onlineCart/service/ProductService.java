package com.onlineShop.onlineCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineShop.onlineCart.entity.ProductInfo;
import com.onlineShop.onlineCart.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<ProductInfo> getProductDetails(){
		return productRepository.getProductDetails();
	}

	public List<ProductInfo> getProduct(String productName) {
		return productRepository.getProduct(productName);
	}
}
