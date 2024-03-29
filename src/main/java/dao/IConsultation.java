package dao;

import java.util.List;

import metier.enteties.Consultation;


public interface IConsultation {
	public Consultation getConsultation(long id);

	public void save(Consultation consultation);

	public Consultation update(Consultation consultation);

	public void delete(long id);

	public List<Consultation> selectAll();
	
	public List<Consultation> fingByWrd(String word);
}
