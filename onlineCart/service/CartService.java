package com.onlineShop.onlineCart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineShop.onlineCart.entity.CartInfo;
import com.onlineShop.onlineCart.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	public int addCart(CartInfo cartInfo) {
		return cartRepository.addCart(cartInfo);
	}
	public int removeCart(String customerName, String productName) {
		return cartRepository.removeCart(customerName, productName);
	}
	public int updateCart(CartInfo cartInfo) {
		return cartRepository.updateCart(cartInfo);
	}
	public List<CartInfo> showCart(String customerName) {
		return cartRepository.showCart(customerName);
	}
}
