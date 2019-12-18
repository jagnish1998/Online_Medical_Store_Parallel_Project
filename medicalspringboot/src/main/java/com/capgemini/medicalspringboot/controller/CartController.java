package com.capgemini.medicalspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.medicalspringboot.bean.CartBean;
import com.capgemini.medicalspringboot.bean.ResponseBean;
import com.capgemini.medicalspringboot.service.CartService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping(path = "/addtocart", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean addToCart(@RequestBody CartBean cartToAdd) {
		boolean isAdded = cartService.addTOCart(cartToAdd);
		ResponseBean response = new ResponseBean();
		if (isAdded) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Medicine Added To Cart successful..!!");
		} else {
			response.setStatusCode(400);
			response.setMessage("Failed");
		}
		return response;
	}

	@GetMapping(path = "/getcart", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getCart(int uid) {
		List<CartBean> cartList = cartService.getAll(uid);
		double totalprice = cartService.getPrice(uid);
		ResponseBean response = new ResponseBean();
		if (cartList != null && !cartList.isEmpty()) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Cart Item Found");
			response.setTotalPrice(totalprice);
			response.setCartBeans(cartList);
						
		} else {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription("No Item Present In Your Cart");
		}
		return response;
	}
	
	@DeleteMapping(path = "/removecart",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean removeCart(int cartId) {
		boolean isRemoved = cartService.removecart(cartId);
		ResponseBean response = new ResponseBean();
		if (isRemoved) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Medicine Removed From Cart successful..!!");
		} else {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription("Unable to Remove Item From Cart");
		}
		return response;
	}
	
	@GetMapping(path = "/removeallcart", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean removeAllCart(int uid) {
		boolean isRemoved = cartService.removeAllcart(uid);
		ResponseBean response = new ResponseBean();
		if (isRemoved) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("All Item Removed From Cart");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Remove Item From Cart");
		}
		return response;
	}
}
