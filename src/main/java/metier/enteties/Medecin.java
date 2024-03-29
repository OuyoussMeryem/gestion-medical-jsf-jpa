package metier.enteties;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MEDECIN")
public class Medecin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MEDECIN")
	private long id;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "SPECIALITE")
	private String specialite;
	@OneToMany(mappedBy = "medecin")
	private Collection<RendezVous> rendezVous;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Collection<RendezVous> getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(Collection<RendezVous> rendezVous) {
		this.rendezVous = rendezVous;
	}

}
