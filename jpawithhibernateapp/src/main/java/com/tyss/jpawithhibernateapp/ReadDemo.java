package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.dto.ProductInfo;

public class ReadDemo {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ProductInfo productDetails = entityManager.find(ProductInfo.class, 101);
		System.out.println("ID--"+productDetails.getPid());
		System.out.println("Name--"+productDetails.getPname());
		System.out.println("Quantity--"+productDetails.getQuantity());
		entityManager.close();
	}//end of main()
}//end of ReadDemo class
