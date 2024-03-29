package dao;

import java.util.List;

import metier.enteties.Consultation;
import metier.enteties.Medecin;
import metier.enteties.Patient;
import metier.enteties.RendezVous;

public class TestEntities {

	public static void main(String[] args) {
	    IPatient metier=new PatientImpl();
        Patient patient=new Patient();
//        patient.setEmail("ouyoussKaltouma@gmail.com");
//        patient.setNom("kaltouma");
//        metier.save(patient);
//        System.out.println("element inserer avec success");
//        List<Patient> patients=metier.selectAll();
//        for(Patient p:patients) {
//        	System.out.println("le nom est "+p.getNom());
//        	System.out.println("Email est "+p.getEmail());
//        }
//        patient=metier.getPatient(1);
//        System.out.println("le nom de patient est :"+patient.getNom());
//        System.out.println("le email de patient est :"+patient.getEmail());
//          patient=metier.getPatient(1);
//          Patient patientNew;
//          patient.setEmail("ensaEnsa@gmail.com");
//          patient.setNom("ensa");
//          patientNew=metier.update(patient);
//          System.out.println("le nom de patient est :"+patientNew.getNom());
//          System.out.println("le email de patient est :"+patientNew.getEmail());
          
//          metier.delete(3);
//          System.out.println("Element supprimer avec success");
          
          
		Consultation cons=new Consultation();
		IConsultation metier1=new ConsultationImpl();
//		cons.setRappot("You are very very very or not good");
//		cons.setDate("2024-03-20");
//		cons.setPrix(500.00);
//		metier1.save(cons);
//		System.out.println("element ajouter avec success");

		Medecin medecin = new Medecin();
		IMedecin metier2=new MedecinImpl();
//		medecin.setNom("Fatima Fatima");
//		medecin.setEmail("FatimaFatima@gmail.com");
//		medecin.setSpecialite("Cardiologie");
//		metier2.save(medecin);
//		System.out.println("element ajouter avec success");
		Patient p1=metier.getPatient(5);
		System.out.println(p1);
		Medecin m1=metier2.getMedecin(4);
		System.out.println(m1);
		Consultation c1=metier1.getConsultation(5);
		System.out.println(c1);
		RendezVous rend=new RendezVous();
		rend.setPatient(p1);
		rend.setMedecin(m1);
		rend.setConsultation(c1);
		rend.setDate("2024-03-20");
		rend.setHeure("03:28:13");
		IRendezVous metierR=new RendezVousImpl();
		metierR.save(rend);
		System.out.println("Element inserer avec success");
		
		

	}

}
