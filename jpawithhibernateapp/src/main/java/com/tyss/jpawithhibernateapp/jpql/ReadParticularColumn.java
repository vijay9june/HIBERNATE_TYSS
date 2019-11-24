package com.tyss.jpawithhibernateapp.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernate.dto.ProductInfo;

public class ReadParticularColumn {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select pname from ProductInfo";
		Query query = entityManager.createQuery(jpql);
		List<String> productInfos = query.getResultList();
		for(String productInfo : productInfos) {
			System.out.println(productInfo);
		}

		entityManager.close();

	}

}
