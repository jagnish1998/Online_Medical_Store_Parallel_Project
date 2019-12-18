package com.capgemini.medicalspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalspringboot.bean.OrderBean;


@Repository
public class OrderDAOImpli implements OrderDAO{

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean addOrder(OrderBean orderBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(orderBean);
			transaction.commit();
			return true;
		}catch (Exception e) {
			transaction.rollback();
			return true;
		}
	}

	@Override
	public List<OrderBean> getOrder(int uid) {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from OrderBean where uid=:uid";
		try {
		Query query = manager.createQuery(jpql);
		query.setParameter("uid", uid);
		List<OrderBean> orderList = query.getResultList();
		return orderList;
		}catch (Exception e) {
			return null;
		}
	}
}
