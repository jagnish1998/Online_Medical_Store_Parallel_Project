package com.capgemini.medicalspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.medicalspringboot.bean.MessageBean;
import com.capgemini.medicalspringboot.bean.ResponseBean;
import com.capgemini.medicalspringboot.service.MessageService;

@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@GetMapping(path = "/showadminmessage",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean showAdminMessage() {
		List<MessageBean> messageBean = messageService.viewMessage();
		ResponseBean response = new ResponseBean();
		if (messageBean != null && !messageBean.isEmpty()) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Users Questions Are");
			response.setMessagelList(messageBean);
		
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("No User Question");
		}
		return response;
	}
	
	@GetMapping(path = "/showUserMessage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean showUserMessage(@RequestParam int uid) {
		List<MessageBean> messageBeans= messageService.viewResponse(uid);
		ResponseBean response=new ResponseBean();
		if (messageBeans!=null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setMessagelList(messageBeans);
			response.setDescription("User Queries acquired.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Queries Not Acquired........");
		}
		return response;
	}//End of getUserMessage()
	
	@PutMapping(path = "/adminResponse",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean adminResponse(@RequestParam int uid, @RequestParam String message) {
		boolean isSent = messageService.sendResponse(message , uid);
		ResponseBean response=new ResponseBean();
		if (isSent) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User Queries Replied.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Queries Not Replied........");
		}
		return response;
	}//End of adminResponse()
	
	@PutMapping(path = "/userResponse")
	public ResponseBean userResponse(@RequestParam int uid,@RequestParam String message) {
		boolean isSent = messageService.sendMessage(message, uid);
		ResponseBean response=new ResponseBean();
		if (isSent) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("User Queries Sent.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Queries Not Sent........");
		}
		return response;
	}
}
