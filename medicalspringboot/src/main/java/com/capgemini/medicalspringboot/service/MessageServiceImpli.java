package com.capgemini.medicalspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalspringboot.bean.MessageBean;
import com.capgemini.medicalspringboot.dao.MessageDAO;

@Service
public class MessageServiceImpli implements MessageService {

	@Autowired
	private MessageDAO messagedao;
	
	@Override
	public boolean sendMessage(String message, int uId) {
		return messagedao.sendMessage(message, uId);
	}

	@Override
	public List<MessageBean> viewResponse(int uId) {
		return messagedao.viewResponse(uId);
	}

	@Override
	public List<MessageBean> viewMessage() {
		return messagedao.viewMessage();
	}

	@Override
	public boolean sendResponse(String message,  int uId) {
		return messagedao.sendResponse(message,  uId);
	}
}
