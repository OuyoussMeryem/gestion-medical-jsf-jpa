package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;

	public static EntityManager getEntityManager(String persistenceUnit) {

		if (entityManager == null) {
			factory = Persistence.createEntityManagerFactory(persistenceUnit);
			entityManager = factory.createEntityManager();

		}

		return entityManager;
	}

}
