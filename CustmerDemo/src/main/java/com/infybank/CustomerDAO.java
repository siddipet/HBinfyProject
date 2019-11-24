package com.infybank;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerDAO implements ICustomer {
	/* Method to create a customer record */
	public void addCustomer(Customer c1) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(c1);
		tx.commit();
		session.close();
	}

	
	 /* Method to read customer details */
	public void readCustomer(int customerId) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Customer cust=(Customer) session.get(Customer.class, customerId);
		System.out.println("Name "+ cust.getCustomerName());
		session.close();
	}

    /* Method to update a customer record */
	public void updateCustomer(Integer customerId, String customerName) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Customer cust=(Customer) session.get(Customer.class, customerId);
		cust.setCustomerName(customerName);
		session.update(cust);
		tx.commit();
		session.close();
		
	}


	public void deleteCustomer(Integer customerId) {

		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Customer cust=(Customer) session.get(Customer.class, customerId);
		session.delete(cust);
		tx.commit();
		session.close();
	}
		
}
