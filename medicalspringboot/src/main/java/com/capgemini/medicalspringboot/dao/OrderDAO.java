package com.capgemini.medicalspringboot.dao;

import java.util.List;

import com.capgemini.medicalspringboot.bean.OrderBean;


public interface OrderDAO {
	
	public boolean addOrder(OrderBean orderBean);
	public List<OrderBean> getOrder(int uid);
}
