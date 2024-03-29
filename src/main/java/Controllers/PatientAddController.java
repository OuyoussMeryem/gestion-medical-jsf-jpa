package Controllers;

import metier.enteties.Patient;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import dao.PatientImpl;

@ManagedBean(name = "patientAddController")
@ViewScoped
public class PatientAddController {

	Patient patient = new Patient();
	PatientImpl metier = new PatientImpl();

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String AddPatient() {
		metier.save(patient);
		return "patients";
	}
}
