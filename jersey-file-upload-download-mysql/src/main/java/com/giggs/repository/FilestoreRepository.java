package com.giggs.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.giggs.entity.Filestore;
import com.giggs.provider.DatabaseException;

public class FilestoreRepository {

	@PersistenceContext
	private EntityManager em;

	public void save(Filestore filestore) throws DatabaseException {

		try {
			em.getTransaction().begin();
			em.persist(filestore);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new DatabaseException("Error al guardar la entidad en la base de datos", e);
		}

	}

}
