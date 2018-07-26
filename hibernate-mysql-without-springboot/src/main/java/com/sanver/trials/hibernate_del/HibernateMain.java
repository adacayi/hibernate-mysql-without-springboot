package com.sanver.trials.hibernate_del;

import java.util.Date;

import org.hibernate.Session;

import com.sanver.trials.hibernate_del.model.Employee;
import com.sanver.trials.hibernate_del.util.HibernateUtil;

public class HibernateMain {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setName("Pankaj");
		emp.setRole("CEO");
		emp.setInsertTime(new Date());

		// Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// start transaction
		session.beginTransaction();
		// Save the Model object
		session.save(emp);
		// Commit transaction
		session.getTransaction().commit();
		System.out.println("Employee ID=" + emp.getId());

		// terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
	}

}
