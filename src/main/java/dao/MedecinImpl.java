package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import metier.enteties.Medecin;

public class MedecinImpl implements IMedecin{
	private EntityManager em=JPAutil.getEntityManager("medimanageUnit");

	@Override
	public Medecin getMedecin(long id) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Medecin medecin =em.find(Medecin.class,id);
		tx.commit();
		return medecin;
	}

	@Override
	public void save(Medecin medecin) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(medecin);
		tx.commit();
	}

	@Override
	public Medecin update(Medecin medecin) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.merge(medecin);
		tx.commit();
		return medecin;
	}

	@Override
	public void delete(long id) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Medecin medecin =em.find(Medecin.class,id);
		em.remove(medecin);
		tx.commit();
		
	}

	@Override
	public List<Medecin> selectAll() {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Query query=em.createQuery("select m from Medecin m ");
		tx.commit();
		return query.getResultList();
	}

	@Override
	public List<Medecin> fingByWrd(String word) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Query query=em.createNamedQuery("select m from Medecin m where m.nom like :x");
		query.setParameter("x", "%"+word+"%");
		tx.commit();
		return query.getResultList();
	}

}
