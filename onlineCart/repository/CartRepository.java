package com.onlineShop.onlineCart.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.onlineShop.onlineCart.entity.CartInfo;
import com.onlineShop.onlineCart.entity.ProductInfo;
import com.onlineShop.onlineCart.rowMapper.CartRowMapper;
import com.onlineShop.onlineCart.rowMapper.ProductRowMapper;

@Repository
public class CartRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	ProductInfo productInfo;
	public int addCart(CartInfo cartInfo) {
		String updateSql;
		String selectSql = "SELECT * FROM dbo.\"productInfo\" where \"prodName\" = \'" + cartInfo.getProdName() + "\'";
		List<ProductInfo> productList = jdbcTemplate.query(selectSql, new ProductRowMapper());
		int oldQuantity = productList.get(0).getQuantity();
		int cartQuantity = cartInfo.getQuantity();
		int updatedQuantity = 0;
		int insertStatus = 0;
		
		insertStatus = jdbcTemplate.update("INSERT INTO dbo.\"cartInfo\"( \"customerName\", \"prodName\", quantity)"
					+ " VALUES (?, ?, ?)",
				 cartInfo.getCustomerName(), cartInfo.getProdName(), cartInfo.getQuantity());
		
		
		int updateStatus = 0;
		int status;
		
		if(insertStatus == 1) {
			updatedQuantity = oldQuantity - cartQuantity;
			updateSql = "UPDATE dbo.\"productInfo\" SET quantity = "
					+ updatedQuantity + " WHERE \"prodName\"= \'" + cartInfo.getProdName() + "\'";
			updateStatus = jdbcTemplate.update(updateSql);
		}else {
			updateSql = "";
		}
		status = ((insertStatus == 1) && (updateStatus == 1)) ? 1: 0;
		return status;
	}
	
	public int removeCart(String customerName, String productName) {
		String selectProductSql = "SELECT * FROM dbo.\"productInfo\" where \"prodName\" = \'" 
									+ productName + "\'";
		List<ProductInfo> productList = jdbcTemplate.query(selectProductSql, new ProductRowMapper());
		int oldQuantity = productList.get(0).getQuantity();
		String selectSql = "select * from dbo.\"cartInfo\" WHERE \"customerName\" = \'" 
				+ customerName + "\' and \"prodName\" = \'" + productName + "\'";
		List<CartInfo> cartList = jdbcTemplate.query(selectSql, new CartRowMapper());
		int cartQuantity = cartList.get(0).getQuantity();
		int updatedQuantity = oldQuantity + cartQuantity;
		String deleteSql = "DELETE FROM dbo.\"cartInfo\" WHERE \"customerName\" = \'" 
				+ customerName + "\' and \"prodName\" = \'" + productName + "\'";
		String updateSql = "UPDATE dbo.\"productInfo\" SET quantity = "
				+ updatedQuantity + " WHERE \"prodName\"= \'" + productName + "\'";
		int updateStatus = jdbcTemplate.update(updateSql);
		int deleteStatus = jdbcTemplate.update(deleteSql);
		int status = (deleteStatus == 1 && updateStatus == 1) ? 1 : 0;
		return status;
	}

	public int updateCart(CartInfo cartInfo) {
		String updateSql;
		String selectSql = "SELECT * FROM dbo.\"productInfo\" where \"prodName\" = \'" + cartInfo.getProdName() + "\'";
		List<ProductInfo> productList = jdbcTemplate.query(selectSql, new ProductRowMapper());
		int oldQuantity = productList.get(0).getQuantity();
		String existQuery = "select count(*) from dbo.\"cartInfo\" where \"customerName\" = \'"
				+ cartInfo.getCustomerName() + "\' and \"prodName\" = \'" + cartInfo.getProdName() + "\'";
		long count = (long) (jdbcTemplate.queryForMap(existQuery)).get("count");
		String existProductQuantity;
		int existProductQuantityCount;
		int cartQuantity = cartInfo.getQuantity();
		int updatedQuantity = 0;
		String updateCart;
		int insertStatus = 0;
		int updateStatus = 0;
		int status = 0;
		if(count == 1) {
			existProductQuantity = "select quantity from dbo.\"cartInfo\" where \"customerName\" = \'" + cartInfo.getCustomerName()
			+"\' and \"prodName\" = \'" + cartInfo.getProdName() + "\'";
			existProductQuantityCount = (int) jdbcTemplate.queryForMap(existProductQuantity).get("quantity");
			if(cartQuantity > existProductQuantityCount) {
				cartQuantity = cartQuantity - existProductQuantityCount;
				updatedQuantity = oldQuantity - cartQuantity;
			}else if(cartQuantity < existProductQuantityCount) {
				cartQuantity = existProductQuantityCount - cartQuantity;
				updatedQuantity = oldQuantity + cartQuantity;
			}
			updateCart = "update dbo.\"cartInfo\" set quantity = "
					+ cartInfo.getQuantity() + " where \"customerName\" = \'" + cartInfo.getCustomerName() +"\' and \"prodName\" = \'"
					+ cartInfo.getProdName() + "\'";
			insertStatus = jdbcTemplate.update(updateCart);
			
			System.out.println("update...");
		}
		if(insertStatus == 1) {
			updateSql = "UPDATE dbo.\"productInfo\" SET quantity = "
					+ updatedQuantity + " WHERE \"prodName\"= \'" + cartInfo.getProdName() + "\'";
			updateStatus = jdbcTemplate.update(updateSql);
		}
		
		status = ((insertStatus == 1) && (updateStatus == 1)) ? 1: 0;
		return status;
	}

	public List<CartInfo> showCart(String customerName) {
		String selectSql = "select * from dbo.\"cartInfo\" where \"customerName\" =  \'" + customerName + "\'";
		List<CartInfo> cartList = jdbcTemplate.query(selectSql, new CartRowMapper());
		return cartList;
	}
	
}
