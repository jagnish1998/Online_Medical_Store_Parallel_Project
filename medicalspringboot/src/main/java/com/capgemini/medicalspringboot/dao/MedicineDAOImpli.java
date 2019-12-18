package com.capgemini.medicalspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalspringboot.bean.MedicineBean;


@Repository
public class MedicineDAOImpli implements MedicineDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public MedicineBean getMedicine(int medicineId) {
		EntityManager manager = emf.createEntityManager();
		MedicineBean medicineBean = manager.find(MedicineBean.class, medicineId);
		manager.close();
		return medicineBean;
	}

	@Override
	public boolean addMedicine(MedicineBean medicineBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(medicineBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteMedicine(int medicineId) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			MedicineBean medicineBean = manager.find(MedicineBean.class, medicineId);
			manager.remove(medicineBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateMedicine(MedicineBean medicineBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isUpdated = false;
		MedicineBean medicineBean2 = manager.find(MedicineBean.class, medicineBean.getMedId());
		if (medicineBean2 != null) {

			if (medicineBean.getMedPrice() != 0) {
				medicineBean2.setMedPrice(medicineBean.getMedPrice());
			}

			

			try {
				tx.begin();
				manager.persist(medicineBean2);
				tx.commit();
				isUpdated = true;

			} catch (Exception e) {
				e.printStackTrace();
			}
			manager.close();

		}
		return isUpdated;
	}

	@Override
	public List<MedicineBean> getAllMedicine() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from MedicineBean";
		Query query = manager.createQuery(jpql);

		List<MedicineBean> medicineList = null;
		try {
			medicineList = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return medicineList;
	}
}
