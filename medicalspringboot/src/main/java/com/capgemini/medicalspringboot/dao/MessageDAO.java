package com.capgemini.medicalspringboot.dao;

import java.util.List;

import com.capgemini.medicalspringboot.bean.MessageBean;




public interface MessageDAO {

	
	boolean sendMessage(String message, int uId);

	List<MessageBean> viewResponse(int uId);

	List<MessageBean> viewMessage();

	boolean sendResponse(String message,  int uId);

}
