package bibliotheque;

import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import Interface.*;

public class Membre {
	private String ID;
	private String Nom;
	private String Prenom;
	private String Date_Naissance;
	private String Date_Inscription;
	private String Adresse;
	private int Tel;
	public Membre(String ID,String Nom,String Prenom,String Date_Naissance,String Date_Inscription,String Adresse,int Tel) {
		this.setID(ID);
		this.setNom(Nom);
		this.setPrenom(Prenom);
		this.setDate_Naissance(Date_Naissance);
		this.setDate_Inscription(Date_Inscription);
		this.setAdresse(Adresse);
		this.setTel(Tel);
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getDate_Naissance() {
		return Date_Naissance;
	}
	public void setDate_Naissance(String date_Naissance) {
		Date_Naissance = date_Naissance;
	}
	public String getDate_Inscription() {
		return Date_Inscription;
	}
	public void setDate_Inscription(String date_Inscription) {
		Date_Inscription = date_Inscription;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public int getTel() {
		return Tel;
	}
	public void setTel(int tel) {
		Tel = tel;
	}


	
	public void ajoutM(Gestion g,DB db) {
		
		g.ajoutMembre(this);
		db.ajouterMembre(this);
		
	}
	
	public void suppM(Gestion g,DB db) {
		if(!g.suppMembre(this)) {
			db.supprimerMembre(ID);
		}
		
	}
	
	
}
