package bibliotheque;

import Interface.*;

public class Emprunt {
	private String IDe;
	private String IDm;
	private String ISBNl;
	private String Date_Emprunt;
	private String Date_Limite;
	
	public Emprunt(String IDe,String IDm,String ISBNl,String Date_Emprunt,String Date_Limite) {
		this.setIDe(IDe);
		this.setIDm(IDm);
		this.setISBNl(ISBNl);
		this.setDate_Emprunt(Date_Emprunt);
		this.setDate_Limite(Date_Limite);
	}

	public String getIDe() {
		return IDe;
	}

	public void setIDe(String iDe) {
		IDe = iDe;
	}

	public String getIDm() {
		return IDm;
	}

	public void setIDm(String iDm) {
		IDm = iDm;
	}

	public String getISBNl() {
		return ISBNl;
	}

	public void setISBNl(String iSBNl) {
		ISBNl = iSBNl;
	}

	public String getDate_Emprunt() {
		return Date_Emprunt;
	}

	public void setDate_Emprunt(String date_Emprunt) {
		Date_Emprunt = date_Emprunt;
	}

	public String getDate_Limite() {
		return Date_Limite;
	}

	public void setDate_Limite(String date_Limite) {
		Date_Limite = date_Limite;
	}
	
	
	public void ajouterE(Gestion g,DB db) {
		if(g.ajoutEmprunt(this)) {
			db.ajouterEmprunt(this);
		}
	}
	public void suppE(Gestion g,DB db) {
		g.suppEmprunt(this);
		db.supprimerEmprunt(IDe);
	}
}
