package com.capgemini.medicalspringboot.service;

import java.util.List;

import com.capgemini.medicalspringboot.bean.OrderBean;


public interface OrderService {

	boolean addOrder(OrderBean orderBean);

	List<OrderBean> getOrder(int uid);

}
