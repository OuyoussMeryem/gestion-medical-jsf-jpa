package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

//import javax.faces.convert.FacesConverter;
import dao.IPatient;
import dao.PatientImpl;
import metier.enteties.Patient;

@FacesConverter(forClass = Patient.class)
public class PatientConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				IPatient metier = new PatientImpl();
				Patient patient = metier.getPatient(Integer.parseInt(value));
				return patient;
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
			return String.valueOf(((Patient) object).getId());
		} else
			return null;

	}
}
