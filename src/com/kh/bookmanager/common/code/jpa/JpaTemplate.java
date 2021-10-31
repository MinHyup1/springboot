package com.kh.bookmanager.common.code.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaTemplate {

	
	private static EntityManagerFactory emf;
	
	public static void init() {
		emf = Persistence.createEntityManagerFactory("a_jpa");
	}
	
	public static EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
	
}
