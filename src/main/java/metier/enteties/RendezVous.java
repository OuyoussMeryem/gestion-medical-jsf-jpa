package metier.enteties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RENDEZVOUS")
public class RendezVous {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RENDEZVOUS")
	private long id;
	@Column(name = "DATE")
	private String date;
	@Column(name = "HEURE")
	private String heure;
	@ManyToOne
	@JoinColumn(name = "ID_PATIENT")
	private Patient patient;
	@ManyToOne
	@JoinColumn(name = "ID_MEDECIN")
	private Medecin medecin;
	@ManyToOne
	@JoinColumn(name = "ID_CONSULTATION")
	private Consultation consultation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

}
