package dao;

import java.util.List;

import metier.enteties.Patient;

public interface IPatient {
	public Patient getPatient(long id);

	public void save(Patient patient);

	public Patient update(Patient patient);

	public void delete(long id);

	public List<Patient> selectAll();

	public List<Patient> fingByWrd(String word);
}
