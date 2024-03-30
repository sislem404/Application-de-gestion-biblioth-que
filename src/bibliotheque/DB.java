package bibliotheque;
import Interface.*;
import java.sql.*;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class DB {
	 private Connection connection;

	    public DB(String url, String user, String password) {
	        try {
	            connection = DriverManager.getConnection(url, user, password);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    

	    public void closeConnection() {
	        try {
	            if (connection != null) {
	                connection.close();
	                System.out.println("Database connection closed.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public boolean Log(String u,String p) {
	    	try {
	            String query = "SELECT username,password FROM log";

	            try (Statement statement = connection.createStatement();
	                 ResultSet resultSet = statement.executeQuery(query)) {

	                while (resultSet.next()) {
	                    String us = resultSet.getString("username");
	                    String ps = resultSet.getString("password");
	                    if(us.equals(u) && ps.equals(ps)) {
	                    	return true;
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    	return false;

	    	
	    }
	    
	    public void remplirMap(HashMap<String, Livre> livreMap,HashMap<String, Membre> membreMap,HashMap <String,Emprunt> empruntMap) {
	        try {
	            String query = "SELECT Titre, ISBN, Auteur, Genre, Date_Publication, Nb_Exemplaires_Disponibles FROM livre";

	            try (Statement statement = connection.createStatement();
	                 ResultSet resultSet = statement.executeQuery(query)) {

	                while (resultSet.next()) {
	                    String titre = resultSet.getString("Titre");
	                    String isbn = resultSet.getString("ISBN");
	                    String auteur = resultSet.getString("Auteur");
	                    String genre = resultSet.getString("Genre");
	                    String datePublication = resultSet.getString("Date_Publication");
	                    int nbExemplaires = resultSet.getInt("Nb_Exemplaires_Disponibles");

	                    Livre livre = new Livre(isbn, titre, auteur, genre, datePublication, nbExemplaires);
	                    livreMap.put(isbn, livre);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        try {
	            String query = "SELECT ID, Nom, Prenom, Date_Naissance, Date_Inscription, Adresse, Tel FROM membre";

	            try (Statement statement = connection.createStatement();
	                 ResultSet resultSet = statement.executeQuery(query)) {

	                while (resultSet.next()) {
	                    String id=resultSet.getString("ID");
	                	String nom = resultSet.getString("Nom");
	                    String prenom = resultSet.getString("Prenom");
	                    String date_naissance = resultSet.getString("Date_Naissance");
	                    String date_inscription = resultSet.getString("Date_Inscription");
	                    String adresse = resultSet.getString("Adresse");
	                    int tel = resultSet.getInt("Tel");

	                    Membre membre = new Membre(id, nom, prenom, date_naissance, date_inscription, adresse,tel);
	                    membreMap.put(id, membre);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        try {
	            String query = "SELECT IDe, IDm, ISBNl, Date_Emprunt, Date_Limite FROM emprunt";

	            try (Statement statement = connection.createStatement();
	                 ResultSet resultSet = statement.executeQuery(query)) {

	                while (resultSet.next()) {
	                    String IDe = resultSet.getString("IDe");
	                    String IDm = resultSet.getString("IDm");
	                    String ISBNl =resultSet.getString("ISBNl");
	                    String Date_Emprunt = resultSet.getString("Date_Emprunt");
	                    String Date_Limite = resultSet.getString("Date_Limite");

	                    Emprunt emprunt = new Emprunt(IDe,IDm,ISBNl,Date_Emprunt,Date_Limite);
	                    empruntMap.put(IDe, emprunt);
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	    }
	    
	    public void ajouterLivre(Livre livre) {
	        try {
	            String query = "INSERT INTO livre (ISBN, Titre, Auteur, Genre, Date_Publication, Nb_Exemplaires_Disponibles) " +
	                           "VALUES (?, ?, ?, ?, ?, ?)";

	            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                preparedStatement.setString(1, livre.getISBN());
	                preparedStatement.setString(2, livre.getTitre());
	                preparedStatement.setString(3, livre.getAuteur());
	                preparedStatement.setString(4, livre.getGenre());
	                preparedStatement.setString(5, livre.getDate_Publication());
	                preparedStatement.setInt(6, livre.getNb_Exemplaires_Disponibles());
	                
	                preparedStatement.executeUpdate();
	            }
	        } catch (SQLException e) {
	        	
	        	System.out.print("ici");
	            e.printStackTrace();
	        }
	        
	        
	    }
	    
	    public void ajouterExemplaires(Livre livre) {
	        try {
	            
	                String query = "UPDATE livre SET Nb_Exemplaires_Disponibles=? WHERE ISBN=?";

	                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                    preparedStatement.setInt(1, livre.getNb_Exemplaires_Disponibles());
	                    preparedStatement.setString(2, livre.getISBN());

	                    preparedStatement.executeUpdate();
	                }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public void supprimerLivre(String ISBN) {
	        try {
	            String query = "DELETE FROM livre WHERE ISBN = ?";

	            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                preparedStatement.setString(1, ISBN);

	                preparedStatement.executeUpdate();
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void ajouterMembre(Membre membre) {
	        try {
	            String query = "INSERT INTO membre (ID, Nom, Prenom, Date_Naissance, Date_Inscription, Adresse, Tel) " +
	                           "VALUES (?, ?, ?, ?, ?, ?, ?)";

	            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                preparedStatement.setString(1, membre.getID());
	                preparedStatement.setString(2, membre.getNom());
	                preparedStatement.setString(3, membre.getPrenom());
	                preparedStatement.setString(4, membre.getDate_Naissance());
	                preparedStatement.setString(5, membre.getDate_Inscription());
	                preparedStatement.setString(6, membre.getAdresse());
	                preparedStatement.setInt(7, membre.getTel());
	                
	                preparedStatement.executeUpdate();
	            }
	        } catch (SQLException e) {
	        	
	        	System.out.print("ici");
	            e.printStackTrace();
	        }
	    }
	    
	    public void supprimerMembre(String ID) {
	        try {
	            String query = "DELETE FROM membre WHERE ID = ?";

	            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                preparedStatement.setString(1, ID);

	                preparedStatement.executeUpdate();
	            }
	        } catch (SQLException e) {
	        	
	            e.printStackTrace();
	        }
	    }
	    
	    public void ajouterEmprunt(Emprunt emprunt) {
	        try {

	            String insertQuery = "INSERT INTO emprunt (IDe, IDm, ISBNl, Date_Emprunt, Date_Limite) " +
	                                "VALUES (?, ?, ?, ?, ?)";

	            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
	                insertStatement.setString(1, emprunt.getIDe());
	                insertStatement.setString(2, emprunt.getIDm());
	                insertStatement.setString(3, emprunt.getISBNl());
	                insertStatement.setString(4, emprunt.getDate_Emprunt());
	                insertStatement.setString(5, emprunt.getDate_Limite());

	                insertStatement.executeUpdate();
	            }

	            String updateQuery = "UPDATE livre AS l SET Nb_Exemplaires_Disponibles = Nb_Exemplaires_Disponibles - 1 " +
	                                "WHERE l.ISBN = ?";

	            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
	                updateStatement.setString(1, emprunt.getISBNl());
	                
	                updateStatement.executeUpdate();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    public void supprimerEmprunt(String IDe) {
	        try {
	            String updateQuery = "UPDATE livre AS l SET Nb_Exemplaires_Disponibles = Nb_Exemplaires_Disponibles + 1 " +
	                                 "WHERE l.ISBN = (SELECT e.ISBNl FROM emprunt AS e WHERE e.IDe = ?)";

	            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
	                updateStatement.setString(1, IDe);

	                updateStatement.executeUpdate();
	            }

	            String deleteQuery = "DELETE FROM emprunt WHERE IDe = ?";

	            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
	                deleteStatement.setString(1, IDe);

	                deleteStatement.executeUpdate();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
