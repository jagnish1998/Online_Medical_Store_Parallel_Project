package com.capgemini.medicalspringboot.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBean {
	private int statusCode;
	private String message;
	private String description;
	private Double totalPrice;
	private UserBean userBean;
	private List<UserBean> userList;
	private MedicineBean medicineBean;
	private List<MedicineBean> medicineList;
	private CartBean cartBean;
	private List<CartBean> cartBeans;
	private List<MessageBean> messagelList;
	private List<OrderBean> orderList;

	
	
	
	
	public List<OrderBean> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderBean> orderList) {
		this.orderList = orderList;
	}

	public List<MessageBean> getMessagelList() {
		return messagelList;
	}

	public void setMessagelList(List<MessageBean> messagelList) {
		this.messagelList = messagelList;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CartBean getCartBean() {
		return cartBean;
	}

	public void setCartBean(CartBean cartBean) {
		this.cartBean = cartBean;
	}

	public List<CartBean> getCartBeans() {
		return cartBeans;
	}

	public void setCartBeans(List<CartBean> cartBeans) {
		this.cartBeans = cartBeans;
	}

	public MedicineBean getMedicineBean() {
		return medicineBean;
	}

	public void setMedicineBean(MedicineBean medicineBean) {
		this.medicineBean = medicineBean;
	}

	public List<MedicineBean> getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(List<MedicineBean> medicineList) {
		this.medicineList = medicineList;
	}

	public List<UserBean> getUserList() {
		return userList;
	}

	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

}
