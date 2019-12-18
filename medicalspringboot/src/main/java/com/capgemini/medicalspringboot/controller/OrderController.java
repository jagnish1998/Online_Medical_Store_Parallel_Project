package com.capgemini.medicalspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.medicalspringboot.bean.CartBean;
import com.capgemini.medicalspringboot.bean.OrderBean;
import com.capgemini.medicalspringboot.bean.ResponseBean;
import com.capgemini.medicalspringboot.service.CartService;
import com.capgemini.medicalspringboot.service.OrderService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private CartService cartService;

	@GetMapping(path = "/orderHistory", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean orderHistory(int uid) {
		List<OrderBean> orderlist = orderService.getOrder(uid);
		ResponseBean response = new ResponseBean();
		if (orderlist != null && !orderlist.isEmpty()) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Order List Found");
			response.setOrderList(orderlist);
		} else {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription("No Previous Order");
		}
		return response;
	}

	@PostMapping(path = "/addToOrder", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean addToOrder(@RequestBody OrderBean orderBean) {
		boolean isAdded = orderService.addOrder(orderBean);
		cartService.removeAllcart(orderBean.getUid());
		ResponseBean response = new ResponseBean();
		if (isAdded) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Order Placed SuccessFul");
		} else {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription("Unable to Place Order");
		}
		return response;
	}
}
