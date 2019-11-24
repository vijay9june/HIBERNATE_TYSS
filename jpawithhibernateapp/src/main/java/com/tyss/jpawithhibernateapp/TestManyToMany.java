package com.tyss.jpawithhibernateapp;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernateapp.manytomany.Course;
import com.tyss.jpawithhibernateapp.manytomany.Student;

public class TestManyToMany {

	public static void main(String[] args) {
		Course course1 = new Course();
		course1.setCid(1);
		course1.setCname("java");

		Course course2 = new Course();
		course2.setCid(2);
		course2.setCname("jdbc");
		
		ArrayList<Course> li = new ArrayList();
		li.add(course1);
		li.add(course2);
		
		
		Student student = new Student();
		student.setSid(1);
		student.setSname("Vijay");
		student.setCourse(li);

		EntityTransaction entityTransaction = null;
		EntityManager entityManager = null;

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			System.out.println("Inserted success");
			entityManager.persist(student);
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		entityManager.close();

	}

}
