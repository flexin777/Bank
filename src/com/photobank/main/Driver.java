package com.photobank.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.util.Date;

public class Driver {

	public static void main(String[] args) {

         info("hello");
		 SessionFactory sessionFactory;
		 ServiceRegistry serviceRegistry;

        Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(
	            configuration.getProperties()).build();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);

	}




        public static void info(Object obj){
            Date date = new Date();
            System.out.println(date + " " +obj.toString());
        }

}
