package com.capgemini.medicalspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalspringboot.bean.MessageBean;


@Repository
public class MessageDAOImpli implements MessageDAO {
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	@Override
	public boolean sendMessage(String message, int uId) {
		boolean isAdded = false;
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			MessageBean bean = new MessageBean();
			bean.setMessage(message);
			bean.setType("Question");
			bean.setUid(uId);
			entityManager.persist(bean);
			isAdded = true;
			entityTransaction.commit();
		} catch (Exception e) {
			isAdded = false;
			e.printStackTrace();
			entityTransaction.rollback();
		}
		return isAdded;
	}

	@Override
	public List<MessageBean> viewResponse(int uId) {
		EntityManager entityManager = emf.createEntityManager();

		try {
			String jpql = " from MessageBean where uid = :uId and type = 'response'";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("uId", uId);
			List<MessageBean> bean = query.getResultList();
			return bean;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<MessageBean> viewMessage() {
		EntityManager entityManager = emf.createEntityManager();

		try {
			String jpql = " from MessageBean where Type = 'Question' ";
			Query query = entityManager.createQuery(jpql);
			List<MessageBean> bean = query.getResultList();
			return bean;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean sendResponse(String message, int uId) {
		boolean isAdded = false;
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			MessageBean bean = new MessageBean();
			bean.setMessage(message);
			bean.setType("response");
			bean.setUid(uId);
			entityManager.persist(bean);
			isAdded = true;
			entityTransaction.commit();
		} catch (Exception e) {
			isAdded = false;
			entityTransaction.rollback();
		}
		return isAdded;
	}
}
