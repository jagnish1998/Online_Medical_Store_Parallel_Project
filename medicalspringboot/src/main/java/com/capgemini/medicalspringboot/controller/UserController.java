package com.capgemini.medicalspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.medicalspringboot.bean.ResponseBean;
import com.capgemini.medicalspringboot.bean.UserBean;
import com.capgemini.medicalspringboot.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/getUser")
	public ResponseBean getEmployee(int userId) {
		UserBean userBean = service.getUser(userId);
		ResponseBean response = new ResponseBean();
		if (userBean != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("User Found");
			response.setUserBean(userBean);
		} else {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription("User Id " + userId + " Not Found");
		}
		return response;
	}

	@PostMapping("/addUser")
	public ResponseBean addUser(@RequestBody UserBean bean) {
		bean.setUserType("user");
		boolean isAdded = service.addUser(bean);
		ResponseBean response = new ResponseBean();
		if (isAdded) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("User Added SuccessFully");
		} else {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription("Email Already Exist Try With Diffrent Email");
		}
		return response;
	}

	@PostMapping("/addadmin")
	public ResponseBean addadmin(@RequestBody UserBean bean) {
		bean.setUserType("admin");
		boolean isAdded = service.addUser(bean);
		ResponseBean response = new ResponseBean();
		if (isAdded) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("User Added SuccessFully");
		} else {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription("Email Already Exist Try With Diffrent Email");
		}
		return response;
	}

	@GetMapping(path = "/getAllUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getallUser() {
		List<UserBean> userList = service.getAllUser();
		ResponseBean response = new ResponseBean();
		if (userList != null && !userList.isEmpty()) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Users List Found");
			response.setUserList(userList);
		} else {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription("User Not Found");
		}
		return response;
	}

	@DeleteMapping("/removeUser")
	public ResponseBean removeUser(int userId) {
		boolean isDeleted = service.removeUser(userId);
		ResponseBean response = new ResponseBean();
		if (isDeleted) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("User Deleted SuccessFul");
		} else {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription("User Id " + userId + " Not Found");
		}
		return response;
	}

	@PostMapping(path = "/updateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean updateUser(@RequestBody UserBean bean) {
		boolean isAdded = service.updateUser(bean);
		ResponseBean response = new ResponseBean();
		if (isAdded) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Password change SuccessFully");
		} else {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription("Unable To Update user");
		}
		return response;
	}

	@PostMapping(path = "/loginuser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean userLogin(@RequestBody UserBean bean) {
		UserBean userBean = service.userLogin(bean.getUserEmail(), bean.getUserPassword());
		ResponseBean response = new ResponseBean();
		if (userBean != null) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Login SuccessFul");
			response.setUserBean(userBean);
		} else {
			response.setStatusCode(400);
			response.setMessage("Failed");
			response.setDescription("Invalid Username And Password");
		}
		return response;
	}
}
