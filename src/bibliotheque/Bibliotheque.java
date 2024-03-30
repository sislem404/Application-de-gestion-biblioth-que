package bibliotheque;

import Interface.*;
import java.io.IOException;
import java.util.HashMap;

import Interface.Nav;

public class Bibliotheque {

	public static void main(String[] args) {
		/*Contrainte à ajouter:contrainte de date dans AjouterE*/
		DB db =new DB("jdbc:mysql://localhost:3306/bibliotheque","root","2002");
		HashMap <String,Livre> livresMap=new HashMap<>();
		HashMap <String,Membre> membresMap=new HashMap<>();
		HashMap <String,Emprunt> empruntsMap=new HashMap<>();
		db.remplirMap(livresMap,membresMap,empruntsMap);
		Gestion G=new Gestion(livresMap,membresMap,empruntsMap);
		
		Login accueil =new Login(G,db);
		accueil.setVisible(true);
		
	}

}
