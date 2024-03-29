package Controllers;

import metier.enteties.Medecin;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import dao.MedecinImpl;

@ManagedBean(name = "medecinAddController")
@ViewScoped
public class MedecinAddController {

	Medecin medecin = new Medecin();
	MedecinImpl metier = new MedecinImpl();

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public String AddMedecin() {
		metier.save(medecin);
		return "medecins";
	}
}
