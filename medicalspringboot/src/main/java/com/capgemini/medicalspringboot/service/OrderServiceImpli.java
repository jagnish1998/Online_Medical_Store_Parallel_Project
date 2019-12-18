package com.capgemini.medicalspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalspringboot.bean.OrderBean;
import com.capgemini.medicalspringboot.dao.OrderDAO;

@Service
public class OrderServiceImpli implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	public boolean addOrder(OrderBean orderBean) {
		return orderDAO.addOrder(orderBean);
	}

	@Override
	public List<OrderBean> getOrder(int uid) {
		return orderDAO.getOrder(uid);
	}
}
