package Controllers;

import metier.enteties.Consultation;
import metier.enteties.Medecin;
import metier.enteties.Patient;
import metier.enteties.RendezVous;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import dao.ConsultationImpl;
import dao.MedecinImpl;
import dao.PatientImpl;
import dao.RendezVousImpl;

@ManagedBean(name = "rendezVousAddController")
@ViewScoped

public class RendezVousAddController {
	Patient patient = new Patient();
	PatientImpl metierPatient = new PatientImpl();
	Medecin medecin = new Medecin();
	MedecinImpl metierMedecin = new MedecinImpl();
	Consultation consultation = new Consultation();
	ConsultationImpl metierConsultation = new ConsultationImpl();
	RendezVous rendezVous = new RendezVous();
	RendezVousImpl metier = new RendezVousImpl();

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public RendezVous getRendezVous() {
		return rendezVous;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public RendezVous getMedecin() {
		return rendezVous;
	}

	public void setRendezVous(RendezVous rendezVous) {
		this.rendezVous = rendezVous;
	}

	public List<Patient> listPatients() {
		List<Patient> patients = metierPatient.selectAll();
		return patients;

	}

	public List<Medecin> listMedecins() {
		List<Medecin> medecins = metierMedecin.selectAll();
		return medecins;

	}

	public List<Consultation> listConsultations() {
		List<Consultation> consultations = metierConsultation.selectAll();
		return consultations;
	}

	public String AddRendezVous() {
		metier.save(rendezVous);
		return "rendezVous";
	}
}
