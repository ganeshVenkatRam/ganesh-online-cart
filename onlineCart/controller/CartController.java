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
import org.springframework.web.bind.annotation.RestController;

import com.onlineShop.onlineCart.entity.CartInfo;
import com.onlineShop.onlineCart.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/cartInfo/{customerName}")
	public List<CartInfo> showCart(@PathVariable String customerName) {
		return cartService.showCart(customerName);
	}
	
	@PostMapping("/newCart")
	public int addCart(@RequestBody CartInfo cartInfo) {
		return cartService.addCart(cartInfo);
	}
	
	@PutMapping("/changeCart")
	public int updateCart(@RequestBody CartInfo cartInfo) {
		return cartService.updateCart(cartInfo);
	}
	
	@DeleteMapping("/removeCart/{customerName}&{productName}")
	public int removeCart(@PathVariable String customerName, @PathVariable String productName) {
		return cartService.removeCart(customerName, productName);
	}
}
