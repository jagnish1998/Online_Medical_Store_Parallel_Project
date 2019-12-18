package com.capgemini.medicalspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.medicalspringboot.bean.MedicineBean;
import com.capgemini.medicalspringboot.bean.ResponseBean;
import com.capgemini.medicalspringboot.service.MedicineService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicineController {

	@Autowired
	MedicineService service;

	@GetMapping(path = "/getMedicine", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean getMedicie(int medId) {
		MedicineBean medicineBean = service.getMedicine(medId);
		ResponseBean response = new ResponseBean();
		if (medicineBean != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Medicine record Found..!!");
			response.setMedicineBean(medicineBean);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Didn't Found Medicine record");
		}
		return response;
	}

	@PostMapping(path = "/addMedicine", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean addMedicine(@RequestBody MedicineBean medicineBean) {
		boolean isAdded = service.addMedicine(medicineBean);
		ResponseBean response = new ResponseBean();
		if (isAdded) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Medicine Added successful..!!");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable TO Add Medicine");
		}
		return response;
	}

	@PostMapping(path = "/updateMedicine", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseBean updateMedicine(@RequestBody MedicineBean medicineBean) {
		boolean isUpdated = service.updateMedicine(medicineBean);
		ResponseBean response = new ResponseBean();
		if (isUpdated) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Medicine Updated Successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Update Medicine");
		}
		return response;
	}

	@DeleteMapping("/deleteMedicine")
	public ResponseBean deleteMedicine(int medId) {
		boolean isDeleted = service.deleteMedicine(medId);
		ResponseBean response = new ResponseBean();
		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Medicine Deleted Successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable to Delete Medicine");
		}
		return response;
	}

	@GetMapping(path = "/getAllMedicine", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseBean getAllUser() {
		List<MedicineBean> medicineList = service.getAllMedicine();
		ResponseBean response = new ResponseBean();
		if (medicineList != null && !medicineList.isEmpty()) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Medicine List Found..!!");
			response.setMedicineList(medicineList);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Medicine List Not Found..!!");
		}
		return response;
	}

}
