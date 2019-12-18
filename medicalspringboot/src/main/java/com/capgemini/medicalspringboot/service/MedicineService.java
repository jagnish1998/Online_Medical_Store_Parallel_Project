package com.capgemini.medicalspringboot.service;

import java.util.List;

import com.capgemini.medicalspringboot.bean.MedicineBean;


public interface MedicineService {

	public MedicineBean getMedicine(int medicineId);
	public boolean addMedicine(MedicineBean medicineBean);
	public boolean deleteMedicine(int medicineId);
	public boolean updateMedicine(MedicineBean medicineBean);
	public List<MedicineBean> getAllMedicine();
	
}
