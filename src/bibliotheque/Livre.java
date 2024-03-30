package bibliotheque;

import java.util.Iterator;
import java.util.Objects;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import Interface.*;

public class Livre {
	private String ISBN;
	private String Titre;
	private String Auteur;
	private String Genre;
	private String Date_Publication;
	private int Nb_Exemplaires_Disponibles;
	public Livre(String ISBN,String Titre,String Auteur,String Genre,String Date_Publication,int Nb_Exemplaire_Disponibles) {
		this.ISBN=ISBN;
		this.Titre=Titre;
		this.Auteur=Auteur;
		this.Genre=Genre;
		this.Date_Publication=Date_Publication;
		this.Nb_Exemplaires_Disponibles=Nb_Exemplaire_Disponibles;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getAuteur() {
		return Auteur;
	}
	public void setAuteur(String auteur) {
		Auteur = auteur;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getDate_Publication() {
		return Date_Publication;
	}
	public void setDate_Publication(String date_Publication) {
		Date_Publication = date_Publication;
	}
	public int getNb_Exemplaires_Disponibles() {
		return Nb_Exemplaires_Disponibles;
	}
	public void setNb_Exemplaires_Disponibles(int nb_Exemplaires_Disponibles) {
		Nb_Exemplaires_Disponibles = nb_Exemplaires_Disponibles;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Livre autreLivre = (Livre) obj;

        return Objects.equals(ISBN, autreLivre.ISBN) &&
               Objects.equals(Titre, autreLivre.Titre) &&
               Objects.equals(Auteur, autreLivre.Auteur) &&
               Objects.equals(Genre, autreLivre.Genre) &&
               Objects.equals(Date_Publication, autreLivre.Date_Publication);
    }
	
	public void ajoutL(Gestion g,DB db) {
		g.ajoutLivre(this);
		db.ajouterLivre(this);
		
	}
	
	
	public void suppL(Gestion g,DB db) {
		
		if(!g.suppLivre(this)){
			db.supprimerLivre(ISBN);
		}
		
	}

	
}
