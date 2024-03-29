package Controllers;

import metier.enteties.Consultation;
import metier.enteties.Medecin;
import metier.enteties.Patient;
import metier.enteties.RendezVous;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.ConsultationImpl;
import dao.MedecinImpl;
import dao.PatientImpl;
import dao.RendezVousImpl;

@ManagedBean(name = "rendezVousController")
@SessionScoped
public class RendezVousController {

	Patient patient = new Patient();
	PatientImpl metierPatient = new PatientImpl();
	Medecin medecin = new Medecin();
	MedecinImpl metierMedecin = new MedecinImpl();
	Consultation consultation = new Consultation();
	ConsultationImpl metierConsultation = new ConsultationImpl();

	RendezVous rendezVous = new RendezVous();
	RendezVousImpl metier = new RendezVousImpl();

	public RendezVous getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(RendezVous rendezVous) {
		this.rendezVous = rendezVous;
	}

	public List<RendezVous> findAllRendezVous() {
		List<RendezVous> rendezVouss = metier.selectAll();
		return rendezVouss;
	}

	public String ModifyRendezVous(RendezVous r) {
		this.rendezVous = metier.getRendezVous(r.getId());
		return "rendezVous-update";
	}

	public String SaveUpdateRendezVous() {
		metier.update(rendezVous);
		return "rendezVous";
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

	public String deleteRendezVous(RendezVous rendezVous) {
		metier.delete(rendezVous.getId());
		return "rendezVous";
	}

}
