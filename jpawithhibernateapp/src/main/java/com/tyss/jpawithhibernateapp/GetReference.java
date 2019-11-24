package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.dto.ProductInfo;

public class GetReference {

	public static void main(String[] args) {
		EntityManager entityManager = null;
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		entityManager = entityManagerFactory.createEntityManager();
		//ProductInfo ProductInfo = entityManager.getReference(ProductInfo.class, 101);
		
		ProductInfo ProductInfo = entityManager.find(ProductInfo.class, 103);
		System.out.println(ProductInfo.getClass());
//		System.out.println(ProductInfo.getPid());
//		System.out.println(ProductInfo.getPname());
//		System.out.println(ProductInfo.getQuantity());
		entityManager.close();
	}

}
