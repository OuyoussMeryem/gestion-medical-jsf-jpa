package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import dao.IConsultation;
import dao.ConsultationImpl;
import metier.enteties.Consultation;

@FacesConverter(forClass = Consultation.class)
public class ConsultationConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				IConsultation metier = new ConsultationImpl();
				Consultation consultation = metier.getConsultation(Integer.parseInt(value));
				return consultation;
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
			return String.valueOf(((Consultation) object).getId());
		} else
			return null;

	}
}
