package Controllers;

import metier.enteties.Consultation;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.ConsultationImpl;

@ManagedBean(name = "consultationController")
@SessionScoped
public class ConsultationController {

	Consultation consultation = new Consultation();
	ConsultationImpl metier = new ConsultationImpl();

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public List<Consultation> findAllConsultation() {
		List<Consultation> consultations = metier.selectAll();
		return consultations;
	}

	public String deleteConsultation(Consultation consultation) {
		metier.delete(consultation.getId());
		return "consultations";
	}

	public String ModifyConsultation(Consultation c) {
		this.consultation = metier.getConsultation(c.getId());
		return "consultation-update";
	}

	public String SaveUpdateconsultation() {
		metier.update(consultation);
		return "consultations";
	}
}
