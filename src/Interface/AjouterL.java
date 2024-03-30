package Interface;

import bibliotheque.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class AjouterL extends JFrame implements ActionListener {
	JPanel pan;
	JTextField ISBN;
	JTextField Titre;
	JTextField Auteur;
	JTextField Genre;
	JTextField Nb_Exemplaires_Disponibles;
	JLabel ISBNl;
	JLabel Titrel;
	JLabel Auteurl;
	JLabel Genrel;
	JLabel Date_Publicationl;
	JLabel Nb_Exemplaires_Disponiblesl;
	String[] jours = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11", "12", "13", "14", "15", "16", "17", "18", "19", "20","21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	String[] mois = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11", "12"};
	String[] years = {"1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959","1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969","1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979","1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989","1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999","2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009","2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019","2020", "2021", "2022", "2023", "2024", "2025", "2026","2027","2028","2029","2030"};
	JComboBox<String> J;
	JComboBox<String> M;
	JComboBox<String> Y;
	JButton Ajouter;
	JButton Anuler;
	JButton Retour;
	Color couleur0 = new Color(200,200,200);
	Color couleur1 = new Color(48, 83, 95);   // 30535F
	Color couleur2 = new Color(9, 15, 19);    // 090F13
	Color couleur3 = new Color(21, 59, 71);   // 153B47
	Color couleur4 = new Color(61, 96, 110);  // 3D606E
	Color couleur5 = new Color(9, 25, 31);    // 09191F
	Color couleur6 = new Color(171,164,170);  // ABA4AA
	Color couleur7 = new Color(96,99,100);    // 606364
	Color couleur9 = new Color(102, 66, 41);  
	Color couleur8 = new Color(29, 19, 14);
	Color couleur10 =new Color (18, 30, 30);
	LineBorder border = new LineBorder(couleur7, 1);
	Gestion g;
	DB db;
	Nav n;
	public AjouterL(Nav n,Gestion g,DB db) {
		this.g=g;
		this.db=db;
		this.n=n;
		setTitle("Ajouter Livre");
		setSize(800,500);
		setLocationRelativeTo(null);
		pan= new JPanel();
		pan.setBackground(couleur10);
		add(pan);
		
		ISBNl = new JLabel("ISBN :");
        ISBNl.setBounds(20, 20, 100, 20);
        ISBNl.setFont(new Font("Monospaced",Font.PLAIN,12));
        ISBNl.setForeground(couleur0);
        pan.add(ISBNl);

        Titrel = new JLabel("Titre :");
        Titrel.setBounds(20, 50, 100, 20);
        Titrel.setFont(new Font("Monospaced",Font.PLAIN,12));
        Titrel.setForeground(couleur0);
        pan.add(Titrel);

        Auteurl = new JLabel("Auteur :");
        Auteurl.setBounds(20, 80, 100, 20);
        Auteurl.setForeground(couleur0);
        Auteurl.setFont(new Font("Monospaced",Font.PLAIN,12));
        pan.add(Auteurl);
        
        Genrel = new JLabel("Genre :");
        Genrel.setBounds(20, 110, 100, 20);
        Genrel.setFont(new Font("Monospaced",Font.PLAIN,12));
        Genrel.setForeground(couleur0);
        pan.add(Genrel);

        Date_Publicationl = new JLabel("Date Publication :");
        Date_Publicationl.setBounds(20, 140, 150, 20);
        Date_Publicationl.setFont(new Font("Monospaced",Font.PLAIN,12));
        Date_Publicationl.setForeground(couleur0);
        pan.add(Date_Publicationl);

        Nb_Exemplaires_Disponiblesl = new JLabel("Nombre d'Exemplaires Disponibles :");
        Nb_Exemplaires_Disponiblesl.setBounds(20, 170, 210, 20);
        Nb_Exemplaires_Disponiblesl.setFont(new Font("Monospaced",Font.PLAIN,12));
        Nb_Exemplaires_Disponiblesl.setForeground(couleur0);
        pan.add(Nb_Exemplaires_Disponiblesl);
        
        
        ISBN = new JTextField();
        ISBN.setBounds(300, 20, 100, 20);
        ISBN.setText("");
        ISBN.setBackground(couleur2);
        ISBN.setBorder(border);
        ISBN.setForeground(couleur0);
        pan.add(ISBN);

        Titre = new JTextField();
        Titre.setBounds(300, 50, 100, 20);
        Titre.setText("");
        Titre.setBackground(couleur2);
        Titre.setBorder(border);
        Titre.setForeground(couleur0);
        pan.add(Titre);

        Auteur = new JTextField();
        Auteur.setBounds(300, 80, 100, 20);
        Auteur.setText("");
        Auteur.setBackground(couleur2);
        Auteur.setBorder(border);
        Auteur.setForeground(couleur0);
        pan.add(Auteur);
        
        Genre = new JTextField();
        Genre.setBounds(300, 110, 100, 20);
        Genre.setText("");
        Genre.setBackground(couleur2);
        Genre.setBorder(border);
        Genre.setForeground(couleur0);
        pan.add(Genre);
        
        
        J = new JComboBox<>(jours);
        J.setSelectedIndex(0);
        J.setBounds(300,140,50,20);
        J.setBackground(couleur2);
        J.setBorder(border);
        J.setForeground(couleur0);
        pan.add(J);
        
        M = new JComboBox<>(mois);
        M.setSelectedIndex(0);
        M.setBounds(370,140,50,20);
        M.setBackground(couleur2);
        M.setBorder(border);
        M.setForeground(couleur0);
        pan.add(M);
        
        Y = new JComboBox<>(years);
        Y.setSelectedIndex(0);
        Y.setBounds(470,140,100,20);
        Y.setBackground(couleur2);
        Y.setBorder(border);
        Y.setForeground(couleur0);
        pan.add(Y);

        Nb_Exemplaires_Disponibles = new JTextField();
        Nb_Exemplaires_Disponibles.setBounds(300, 170, 200, 20);
        Nb_Exemplaires_Disponibles.setText("");
        Nb_Exemplaires_Disponibles.setBackground(couleur2);
        Nb_Exemplaires_Disponibles.setBorder(border);
        Nb_Exemplaires_Disponibles.setForeground(couleur0);
        pan.add(Nb_Exemplaires_Disponibles);
        
        Ajouter=new JButton("Ajouter");
        Ajouter.setBackground(couleur2); 
        Ajouter.setForeground(couleur6); 
        Ajouter.setFont(new Font("Monospaced", Font.BOLD, 16)); 
        Ajouter.setFocusPainted(false);
        
        Anuler=new JButton("Anuler");
        Anuler.setBackground(couleur2); 
        Anuler.setForeground(couleur6); 
        Anuler.setFont(new Font("Monospaced", Font.BOLD, 16)); 
        Anuler.setFocusPainted(false);
        
        Ajouter.addActionListener(this);
        
        Ajouter.setBounds(500,350,200,100);
        pan.add(Ajouter);
        
        Anuler.addActionListener(this);
        
        Anuler.setBounds(200,350,200,100);
        pan.add(Anuler);
        
        Retour=new JButton("<");
        Retour.setBackground(couleur2); 
        Retour.setForeground(couleur6); 
        Retour.setFont(new Font("Monospaced", Font.BOLD, 20)); 
        Retour.setFocusPainted(false);
        
        Retour.addActionListener(this);
        
        Retour.setBounds(0,400,50,50);
        pan.add(Retour);
        
        
        
		pan.setLayout(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Ajouter) {
		String ISBNa=ISBN.getText();
		String Titrea=Titre.getText();
		String Auteura=Auteur.getText();
		String Genrea=Genre.getText();
		String Date_Publicationa=J.getSelectedItem()+"/"+M.getSelectedItem()+"/"+Y.getSelectedItem();
		String Nb_Exemplaires_Disponiblesa= Nb_Exemplaires_Disponibles.getText();
		
		
		if (!ISBNa.isEmpty() && !Titrea.isEmpty() && !Auteura.isEmpty() && !Genrea.isEmpty() && !Date_Publicationa.isEmpty() && !Nb_Exemplaires_Disponiblesa.isEmpty()) {
	        
			 try {
				 int nbExemplaires = Integer.parseInt(Nb_Exemplaires_Disponiblesa);
		         Livre l = new Livre(ISBNa, Titrea, Auteura, Genrea, Date_Publicationa, nbExemplaires);
		         if(g.getLivre().containsKey(ISBNa)) {
		        	 if(l.equals(g.getLivre().get(ISBNa))) {
		        		 
		        		 g.ajoutExemplaires(l, db);
		        		 JOptionPane.showMessageDialog(this, "ISBN deja existant des exemplaires vont étre ajouter");
		        	 }else {
		        		 JOptionPane.showMessageDialog(this, "ISBN deja existant mais les informations ne correspondent pas"); 
		        	 }
		         }else {
		        	 if(nbExemplaires<= 0) {
		        		 JOptionPane.showMessageDialog(this, "Nombre d'exemplaires invalide");
		        	 }else {
		        	 l.ajoutL(g, db);
	             
		        	 JOptionPane.showMessageDialog(this, "Livre ajouté avec succès");
		        	 }
		         }
		        
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "Nombre d'exemplaires invalide");
	        }
	}else {
			JOptionPane.showMessageDialog(this, "Erreur");
	}
	}else {
		if(e.getSource()==Anuler) {
			ISBN.setText("");
			Titre.setText("");
			Auteur.setText("");
			Genre.setText("");
			Nb_Exemplaires_Disponibles.setText("");
		}else {
			n.setVisible(true);
			this.dispose();
		}
	}
	}
		
}
