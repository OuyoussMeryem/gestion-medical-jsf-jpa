package Controllers;

import metier.enteties.Medecin;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.MedecinImpl;

@ManagedBean(name = "medecinController")
@SessionScoped
public class MedecinController {

	Medecin medecin = new Medecin();
	MedecinImpl metier = new MedecinImpl();

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public List<Medecin> findAllMedecin() {
		List<Medecin> medecins = metier.selectAll();
		return medecins;
	}

	public String deleteMedecin(Medecin medecin) {
		metier.delete(medecin.getId());
		return "medecins";
	}

	public String ModifyMedecin(Medecin m) {
		this.medecin = metier.getMedecin(m.getId());
		return "medecin-update";
	}

	public String SaveUpdateMedecin() {
		metier.update(medecin);
		return "medecins";
	}
}
