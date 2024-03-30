package bibliotheque;

import Interface.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

public class Gestion {
	private HashMap <String,Livre> livresMap=new HashMap<>();
	private HashMap <String,Membre> membreMap=new HashMap<>();
	private HashMap <String,Emprunt> empruntMap=new HashMap<>();
	
	public Gestion(HashMap <String,Livre> livres,HashMap <String,Membre> membres,HashMap <String,Emprunt> emprunts) {
		this.livresMap=livres;
		this.membreMap=membres;
		this.empruntMap=emprunts;
	}

	public HashMap <String,Livre> getLivre() {
		return livresMap;
	}

	public void setLivre(HashMap <String,Livre> livres) {
		this.livresMap = livres;
	}
	
	
	public void ajoutLivre(Livre livre) {
		this.livresMap.put(livre.getISBN(), livre);
		
	}
	
	public void ajoutExemplaires(Livre livre,DB db) {
		Livre l=this.livresMap.get(livre.getISBN());
		l.setNb_Exemplaires_Disponibles(l.getNb_Exemplaires_Disponibles()+livre.getNb_Exemplaires_Disponibles());
		this.livresMap.replace(livre.getISBN(), l);
		db.ajouterExemplaires(l);
	}
	
	public boolean suppLivre(Livre l) {
		
		Iterator<Entry<String, Emprunt>> iterator = empruntMap.entrySet().iterator();
		boolean r =false;
		
        while (iterator.hasNext()) {
            Entry<String, Emprunt> entry = iterator.next();
            if(entry.getValue().getISBNl().equals(l.getISBN())){
            	r=true;
            	break;
            }
        }
        if(r==false) {
        	this.livresMap.remove(l.getISBN());
    		
    		JOptionPane.showMessageDialog(null, "Retirer avec succées");
    	
        }else {
        	JOptionPane.showMessageDialog(null, "Ce livre a été emprunter veuillez consulter la liste des emprunt");
        }
		return r;
	}

	public HashMap <String,Membre> getMembreMap() {
		return membreMap;
	}

	public void setMembreMap(HashMap <String,Membre> membreMap) {
		this.membreMap = membreMap;
	}

	public void ajoutMembre(Membre membre) {
		
		this.membreMap.put(membre.getID(), membre);
		
		
	}
	
	public boolean suppMembre(Membre membre) {
		Iterator<Entry<String, Emprunt>> iterator = empruntMap.entrySet().iterator();
		boolean r =false;
		
        while (iterator.hasNext()) {
            Entry<String, Emprunt> entry = iterator.next();
            if(entry.getValue().getIDe().equals( membre.getID())){
            	r=true;
            	break;
            }
        }
        if(r==false) {
			this.membreMap.remove(membre.getID());
			JOptionPane.showMessageDialog(null, "Retirer avec succées");
        }else {
        	JOptionPane.showMessageDialog(null, "Ce membre a emprunté un livre veuillez consulter la liste des emprunt");
        }
        return r;
		
	}
	
	public HashMap <String,Emprunt> getEmpruntMap() {
		return empruntMap;
	}

	public void setEmpruntMap(HashMap <String,Emprunt> empruntMap) {
		this.empruntMap = empruntMap;
	}
	
	public boolean ajoutEmprunt(Emprunt emprunt) {
		boolean r=false;
		if(membreMap.containsKey(emprunt.getIDm()) && livresMap.containsKey(emprunt.getISBNl())) {
			if(this.livresMap.get(emprunt.getISBNl()).getNb_Exemplaires_Disponibles()>0) {
					Livre l =this.livresMap.get(emprunt.getISBNl());
					l.setNb_Exemplaires_Disponibles(l.getNb_Exemplaires_Disponibles()-1);
					this.livresMap.replace(emprunt.getISBNl(), l);
					this.empruntMap.put(emprunt.getIDe(), emprunt);
					r=true;
					JOptionPane.showMessageDialog(null, "Emprunt ajouté avec succée");
			}else {
				JOptionPane.showMessageDialog(null, "Exemplaire indisponible");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Le Membre ou La clée n'existe pas");
		}
		return r;
	}
	
	public void suppEmprunt(Emprunt emprunt) {
		Livre l =this.livresMap.get(emprunt.getISBNl());
		l.setNb_Exemplaires_Disponibles(l.getNb_Exemplaires_Disponibles()+1);
		this.livresMap.replace(emprunt.getISBNl(), l);
		this.empruntMap.remove(emprunt.getIDe());
		
		
	}
	

}
