package com.capgemini.medicalspringboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.medicalspringboot.bean.MessageBean;


@Service
public interface MessageService {

	boolean sendMessage(String message, int uId);

	List<MessageBean> viewResponse(int uId);

	List<MessageBean> viewMessage();

	boolean sendResponse(String message, int uId);
	
}
