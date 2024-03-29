package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import metier.enteties.Patient;

public class PatientImpl implements IPatient{
	private EntityManager em=JPAutil.getEntityManager("medimanageUnit");

	@Override
	public Patient getPatient(long id) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Patient patient=em.find(Patient.class, id);
		tx.commit();
		return patient;
	}

	@Override
	public void save(Patient patient) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(patient);
		tx.commit();
		
	}

	@Override
	public Patient update(Patient patient) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.merge(patient);
		tx.commit();
		return patient;
	}

	@Override
	public void delete(long id) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Patient p=em.find(Patient.class,id);
		em.remove(p);
		tx.commit();
		
	}

	@Override
	public List<Patient> selectAll() {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Query query=em.createQuery("select p from Patient p");
		tx.commit();
		return query.getResultList();
	}

	@Override
	public List<Patient> fingByWrd(String word) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Query query=em.createQuery("select p from Patient p where p.nom like :x");
		query.setParameter("x", "%"+word+"%");
		tx.commit();
		return query.getResultList();
	}

}
