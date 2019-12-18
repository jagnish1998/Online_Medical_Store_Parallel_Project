package com.capgemini.medicalspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.capgemini.medicalspringboot.bean.CartBean;


@Service
public class CartDAOImpli implements CartDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean addTOCart(CartBean cart) {
		boolean isAdded = false;
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
	
		try {
			entityTransaction.begin();
			entityManager.persist(cart);
			isAdded = true;
			entityTransaction.commit();
		} catch (Exception e) {
			isAdded = false;
			entityTransaction.rollback();
		}
		return isAdded;
	}

	@Override
	public List<CartBean> getAll(int userId) {
		EntityManager entityManager = emf.createEntityManager();
		try {
				String jpql = " from CartBean where uid = :userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			List<CartBean> bean = query.getResultList();
			return bean;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean removecart(int cartId) {
		boolean isDeleted = false;
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			CartBean cart = entityManager.find(CartBean.class, cartId);
			entityManager.remove(cart);
			isDeleted = true;
			entityTransaction.commit();
		} catch (Exception e) {
			isDeleted = false;
			entityTransaction.rollback();
		}
		return isDeleted;
	}

	@Override
	public boolean removeAllcart(int userId) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			String jpql = "delete from CartBean where uid = : userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			query.executeUpdate();
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
			return false;
		}
	}

	@Override
	public double getPrice(int userId) {
		EntityManager entityManager = emf.createEntityManager();
		try {
			String jpql = "select sum(price) from CartBean where uid =: userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			double price = (double) query.getSingleResult();
			return price;
		}catch(Exception e){
			return 0;
		}
	}
}
