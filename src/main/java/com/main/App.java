package com.main;




import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.service.ServiceRegistry;

import com.dto.Employee;

public class App {
//	private static SessionFactory factory; 
	public static void main(String[] args) { 
		
		Configuration conf = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		SessionFactory factory = conf.buildSessionFactory(registry);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		/*Employee emp = new Employee();
        emp.setId(1023);
		emp.setFirstname("shahil");
		emp.setLastname("duby");*/
		//session.save(emp);
		//session.update(emp);
		//session.persist(emp);
		//session.saveOrUpdate(emp);
		
	/*	Transaction tx=null;
		try { 
			tx=session.beginTransaction();
			List emp=session.createQuery(("from hibernatetb").list();
			for (Iterable<= emp.iterator();Iterator.ha)
		}catch(HibernateException E) {}*/
		
		Criteria c = session.createCriteria(Employee.class);
	     c.setProjection(Projections.property("lastname"));
		List employees = c.list();

		for (Object o : employees) {
			String s = (String)o;
			System.out.println("empname :"+s);
		}/*
		Iterator itr = employees.iterator();
		while (itr.hasNext()) {

//			Employee emp = (Employee) itr.next();
			System.out.println(itr.`);
			System.out.println(emp.getFirstname());
			System.out.println(emp.getLastname());
		}
		 
		
		tx.commit();*/
		session.close();
	}  
}
