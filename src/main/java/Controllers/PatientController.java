package Controllers;

import metier.enteties.Patient;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.PatientImpl;

@ManagedBean(name = "patientController")
@SessionScoped
public class PatientController {

	Patient patient = new Patient();
	PatientImpl metier = new PatientImpl();

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Patient> findAllPatient() {
		List<Patient> patients = metier.selectAll();
		return patients;
	}

	public String deletePatient(Patient patient) {
		metier.delete(patient.getId());
		return "patients";
	}

	public String ModifyPatient(Patient p) {
		this.patient = metier.getPatient(p.getId());
		return "patient-update";
	}

	public String SaveUpdatePatient() {
		metier.update(patient);
		return "patients";
	}

}
