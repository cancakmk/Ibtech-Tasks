package com.ibtech.util;


import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.ibtech.model.Account;
import com.ibtech.model.Address;
import com.ibtech.model.Customer;
import com.ibtech.model.Phone;


public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/tasks?serverTimezone=UTC");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "12345");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

//				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//
//				settings.put(Environment.HBM2DDL_AUTO, "none");

				configuration.setProperties(settings);
				
				configuration.addAnnotatedClass(Account.class);
				configuration.addAnnotatedClass(Address.class);
				configuration.addAnnotatedClass(Customer.class);
				configuration.addAnnotatedClass(Phone.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}