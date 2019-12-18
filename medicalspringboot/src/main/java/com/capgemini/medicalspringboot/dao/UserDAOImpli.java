package com.capgemini.medicalspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalspringboot.bean.UserBean;


@Repository
public class UserDAOImpli implements UserDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public UserBean getUser(int userId) {
		EntityManager manager = emf.createEntityManager();
		UserBean userBean = manager.find(UserBean.class, userId);
		manager.close();
		return userBean;
	}

	@Override
	public boolean addUser(UserBean bean) {
		try {
			EntityManager manager = emf.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<UserBean> getAllUser() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from UserBean";
		Query query = manager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<UserBean> userList = query.getResultList();
		return userList;
	}

	@Override
	public boolean removeUser(int userId) {
		try {
			EntityManager manager = emf.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			UserBean bean = manager.find(UserBean.class, userId);
			transaction.begin();
			manager.remove(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateUser(UserBean userBean) {
		try {
			EntityManager manager = emf.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			UserBean bean = manager.find(UserBean.class, userBean.getUserId());
			if (bean != null) {
				if (userBean.getUserName() != null) {
					bean.setUserName(userBean.getUserName());
				}
				if (userBean.getUserEmail() != null) {
					bean.setUserEmail(userBean.getUserEmail());
				}
				if (userBean.getUserPassword() != null) {
					bean.setUserPassword(userBean.getUserPassword());
				}
			}
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public UserBean userLogin(String email, String password) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Query query = manager.createQuery("from UserBean where userEmail = :email and userPassword = :password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		UserBean bean = null;
		try {
		 bean = (UserBean)query.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return bean;
	}
}
