package com.tyss.jpawithhibernateapp.jpql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernate.dto.ProductInfo;

public class ReadDemo {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from ProductInfo";
		Query query = entityManager.createQuery(jpql);
		List<ProductInfo> productInfos = query.getResultList();
		for(ProductInfo productInfo : productInfos ) {
			System.out.println(productInfo.getPid());
			System.out.println(productInfo.getPname());
			System.out.println(productInfo.getQuantity());
		}
		entityManager.close();
	}//end of main()
}//end of class ReadDemo
