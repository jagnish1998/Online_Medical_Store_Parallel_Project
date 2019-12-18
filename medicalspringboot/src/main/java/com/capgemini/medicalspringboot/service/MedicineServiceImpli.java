package com.capgemini.medicalspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalspringboot.bean.MedicineBean;
import com.capgemini.medicalspringboot.dao.MedicineDAO;

@Service
public class MedicineServiceImpli implements MedicineService {
	@Autowired
	private MedicineDAO medDAO;

	@Override
	public MedicineBean getMedicine(int medicineId) {
		return medDAO.getMedicine(medicineId);
	}

	@Override
	public boolean addMedicine(MedicineBean medicineBean) {
		return medDAO.addMedicine(medicineBean);
	}

	@Override
	public boolean deleteMedicine(int medicineId) {
		return medDAO.deleteMedicine(medicineId);
	}

	@Override
	public boolean updateMedicine(MedicineBean medicineBean) {
		return medDAO.updateMedicine(medicineBean);
	}

	@Override
	public List<MedicineBean> getAllMedicine() {
		return medDAO.getAllMedicine();
	}
}
