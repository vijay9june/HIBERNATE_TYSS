package com.tyss.jpawithhibernatepractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.tyss.jpawithhibernatepractice.dto.EmployeeInfo;

public class ReadDemo {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EmployeeInfo employeeInfo = entityManager.find(EmployeeInfo.class, 1);
		System.out.println("ID--"+employeeInfo.getEid());
		System.out.println("Name--"+employeeInfo.getEname());
		System.out.println("Quantity--"+employeeInfo.getSalary());
		entityManager.close();

	}

}
