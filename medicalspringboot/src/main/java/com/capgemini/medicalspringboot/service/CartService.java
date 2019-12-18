package com.capgemini.medicalspringboot.service;

import java.util.List;

import com.capgemini.medicalspringboot.bean.CartBean;


public interface CartService {

	boolean addTOCart(CartBean cart);

	List<CartBean> getAll(int userId);

	boolean removecart(int cartId);

	boolean removeAllcart(int userId);

	double getPrice(int userId);
}
