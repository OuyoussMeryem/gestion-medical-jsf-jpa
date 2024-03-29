package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import metier.enteties.Consultation;

public class ConsultationImpl implements IConsultation {
	private EntityManager em=JPAutil.getEntityManager("medimanageUnit");

	@Override
	public Consultation getConsultation(long id) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Consultation consultation=em.find(Consultation.class, id);
		tx.commit();
		return consultation;
	}

	@Override
	public void save(Consultation consultation) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(consultation);
		tx.commit();	
	}

	@Override
	public Consultation update(Consultation consultation) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.merge(consultation);
		tx.commit();
		return consultation;
	}

	@Override
	public void delete(long id) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Consultation consultation=em.find(Consultation.class,id);
		em.remove(consultation);
		tx.commit();
		
	}

	@Override
	public List<Consultation> selectAll() {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Query query=em.createQuery("select c from Consultation c ");
		tx.commit();
		return query.getResultList();
	}

	@Override
	public List<Consultation> fingByWrd(String word) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Query query=em.createQuery("select c from Consultation c where c.date like :x");
		query.setParameter("x","%"+word+"%");
		tx.commit();
		return query.getResultList();
	}

}
