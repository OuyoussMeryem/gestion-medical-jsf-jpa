package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import dao.IMedecin;
import dao.MedecinImpl;
import metier.enteties.Medecin;

@FacesConverter(forClass = Medecin.class)
public class MedecinConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				IMedecin metier = new MedecinImpl();
				Medecin medecin = metier.getMedecin(Integer.parseInt(value));
				return medecin;
			} catch (Exception e) {

				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if (object != null) {
			return String.valueOf(((Medecin) object).getId());
		} else
			return null;

	}
}
