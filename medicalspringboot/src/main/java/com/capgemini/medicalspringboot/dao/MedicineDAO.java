package com.capgemini.medicalspringboot.dao;

import java.util.List;

import com.capgemini.medicalspringboot.bean.MedicineBean;


public interface MedicineDAO {

	public MedicineBean getMedicine(int medicineId);
	public boolean addMedicine(MedicineBean medicineBean);
	public boolean deleteMedicine(int medicineId);
	public boolean updateMedicine(MedicineBean medicineBean);
	public List<MedicineBean> getAllMedicine();
}
