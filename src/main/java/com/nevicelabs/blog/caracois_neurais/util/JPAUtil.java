package com.nevicelabs.blog.caracois_neurais.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	// Passamos o nome da persistence unit para createEntityManagerFactory()
	private static final EntityManagerFactory emf = 
		Persistence.createEntityManagerFactory("default");

	public static EntityManager getEntityManager() {
		// O objeto EntityManager representa uma conexão com o database, entre outras coisas
		return emf.createEntityManager();
	}
}