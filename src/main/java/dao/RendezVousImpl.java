package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import metier.enteties.RendezVous;

public class RendezVousImpl implements IRendezVous{
	private EntityManager em=JPAutil.getEntityManager("medimanageUnit");

	@Override
	public RendezVous getRendezVous(long id) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		RendezVous rendezVous=em.find(RendezVous.class,id);
		tx.commit();
		return rendezVous;
	}

	@Override
	public void save(RendezVous rendezVous) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(rendezVous);
		tx.commit();
		
	}

	@Override
	public RendezVous update(RendezVous rendezVous) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.merge(rendezVous);
		tx.commit();
		return rendezVous;
	}

	@Override
	public void delete(long id) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		RendezVous rendezVous=em.find(RendezVous.class, id);
		em.remove(rendezVous);
		tx.commit();
		
	}

	@Override
	public List<RendezVous> selectAll() {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Query query=em.createQuery("select r from RendezVous r ");
		tx.commit();
		return query.getResultList();
	}

	@Override
	public List<RendezVous> fingByWrd(String word) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Query query=em.createQuery("select r from RendezVous r where r.date like :x");
		query.setParameter("x", "%"+word+"%");
		tx.commit();
		return query.getResultList();
		
	}

}
