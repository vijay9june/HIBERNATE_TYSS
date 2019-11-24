package com.tyss.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.onetomany.Pencil;
import com.tyss.jpawithhibernateapp.onetomany.PencilBox;
import com.tyss.jpawithhibernateapp.onetoone.VoterCard;

public class TestOneToMany {

	public static void main(String[] args) {
		PencilBox peBox = new PencilBox();
		peBox.setBid(2);
		peBox.setBname("Natraj");
		
		Pencil pencil = new Pencil();
		pencil.setPid(13);
		pencil.setColor("yellow");
		pencil.setPencilBox(peBox);
		
		Pencil pencil1 = new Pencil();
		pencil1.setPid(14);
		pencil1.setColor("red");
		pencil1.setPencilBox(peBox);
		
		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(pencil1);
			entityManager.persist(pencil);
			System.out.println("Inserted success");
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}finally {
			entityManager.close();
		}

	}

}
