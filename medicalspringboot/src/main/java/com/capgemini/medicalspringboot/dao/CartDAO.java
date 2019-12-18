package com.capgemini.medicalspringboot.dao;

import java.util.List;

import com.capgemini.medicalspringboot.bean.CartBean;



public interface CartDAO {

	boolean addTOCart(CartBean cart);

	List<CartBean> getAll(int userId);

	boolean removecart(int cartId);

	boolean removeAllcart(int userId);
	
	double getPrice(int userId);

	
}
