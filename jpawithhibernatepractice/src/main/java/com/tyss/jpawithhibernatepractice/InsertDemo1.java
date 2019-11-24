package com.tyss.jpawithhibernatepractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernatepractice.dto.EmployeeInfo;

public class InsertDemo1 { 
	public static void main(String[] args) {
		EmployeeInfo employeeInfo = new EmployeeInfo();
		employeeInfo.setEid(2);
		employeeInfo.setEname("Vijay");
		employeeInfo.setSalary(16000);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employeeInfo);
		System.out.println("Inserted Success");
		entityTransaction.commit();
		entityManager.close();
	}//end of main()
}//end of EmployeeInfo 
