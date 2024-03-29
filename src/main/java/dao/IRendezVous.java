package dao;

import java.util.List;


import metier.enteties.RendezVous;

public interface IRendezVous {
	public RendezVous getRendezVous(long id);

	public void save(RendezVous rendezVous);

	public RendezVous update(RendezVous rendezVous);

	public void delete(long id);

	public List<RendezVous> selectAll();
	
	public List<RendezVous> fingByWrd(String word);
}
