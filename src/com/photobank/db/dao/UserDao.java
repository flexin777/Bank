package com.photobank.db.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.photobank.db.entities.Password;
import com.photobank.db.entities.User;

public class UserDao {
	public List<User> selectAll() {
		// Query
		return null;

	}

	public Boolean checkPass(Integer userId, String pass) {
		SessionFactory sessionFactory;
		ServiceRegistry serviceRegistry;
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		Session session = sessionFactory.openSession();
		org.hibernate.Query query = session
				.createQuery("FROM UserDetails Where userId = :userId");
		query.setInteger("userId", userId);

		List<User> users = (List<User>) query.list();
		//If user does not exist
		if(users.isEmpty()) {
			return false;
		}
		
		query = session
				.createQuery("FROM Password Where userId = :userId");
		query.setInteger("userId", userId);
		List<Password> password = (List<Password>) query.list();
		if (password.get(0).equals(pass)) return true;
		
		
		return true;

	}

	public User selectById(Integer userId) {
		// Query
		return null;

	}

	public void addUser() {

	}

	public void deleteUser(User userId) {

	}

	public void updateUser(User userId) {
		// Query
	}

}
