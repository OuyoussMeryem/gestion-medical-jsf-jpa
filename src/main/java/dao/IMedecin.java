package dao;

import java.util.List;

import metier.enteties.Medecin;


public interface IMedecin {
	public Medecin getMedecin(long id);

	public void save(Medecin medecin);

	public Medecin update(Medecin medecin);

	public void delete(long id);

	public List<Medecin> selectAll();
	
	public List<Medecin> fingByWrd(String word);
	

}
