package Controllers;

import metier.enteties.Consultation;

import javax.faces.bean.ManagedBean;

import javax.faces.view.ViewScoped;

import dao.ConsultationImpl;

@ManagedBean(name = "consultationAddController")
@ViewScoped
public class ConsultationAddController {

	Consultation consultation = new Consultation();
	ConsultationImpl metier = new ConsultationImpl();

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public String Addconsultation() {
		metier.save(consultation);
		return "consultations";
	}
}
