package Interface;

import bibliotheque.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class AjouterM extends JFrame implements ActionListener {
	JPanel pan;
	JTextField ID;
	JTextField Nom;
	JTextField Prenom;
	JTextField Adresse;
	JTextField Tel;
	JLabel IDl;
	JLabel Noml;
	JLabel Prenoml;
	JLabel Date_Naissancel;
	JLabel Date_Inscriptionl;
	JLabel Adressel;
	JLabel Tell;
	JButton Ajouter;
	JButton Anuler;
	JButton Retour;
	String[] jours = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11", "12", "13", "14", "15", "16", "17", "18", "19", "20","21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	String[] mois = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11", "12"};
	String[] years = {"1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959","1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969","1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979","1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989","1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999","2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009","2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019","2020", "2021", "2022", "2023", "2024", "2025", "2026","2027","2028","2029","2030"};
	JComboBox<String> J;
	JComboBox<String> M;
	JComboBox<String> Y;
	JComboBox<String> Ji;
	JComboBox<String> Mi;
	JComboBox<String> Yi;
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
	public AjouterM(Nav n,Gestion g,DB db) {
		this.g=g;
		this.db=db;
		this.n=n;
		setTitle("Ajouter Membre");
		setSize(800,500);
		setLocationRelativeTo(null);
		pan= new JPanel();
		pan.setBackground(couleur10);
		add(pan);
		
		IDl = new JLabel("ID :");
        IDl.setBounds(20, 20, 100, 20);
        IDl.setFont(new Font("Monospaced",Font.PLAIN,12));
        IDl.setForeground(couleur0);
        pan.add(IDl);

        Noml = new JLabel("Nom :");
        Noml.setBounds(20, 50, 100, 20);
        Noml.setFont(new Font("Monospaced",Font.PLAIN,12));
        Noml.setForeground(couleur0);
        pan.add(Noml);

        Prenoml = new JLabel("Prenom :");
        Prenoml.setBounds(20, 80, 100, 20);
        Prenoml.setFont(new Font("Monospaced",Font.PLAIN,12));
        Prenoml.setForeground(couleur0);
        pan.add(Prenoml);
        
        Date_Naissancel = new JLabel("Date Naissance :");
        Date_Naissancel.setBounds(20, 110, 150, 20);
        Date_Naissancel.setFont(new Font("Monospaced",Font.PLAIN,12));
        Date_Naissancel.setForeground(couleur0);
        pan.add(Date_Naissancel);

        Date_Inscriptionl = new JLabel("Date Inscription :");
        Date_Inscriptionl.setBounds(20, 140, 150, 20);
        Date_Inscriptionl.setFont(new Font("Monospaced",Font.PLAIN,12));
        Date_Inscriptionl.setForeground(couleur0);
        pan.add(Date_Inscriptionl);

        Adressel = new JLabel("Adresse :");
        Adressel.setBounds(20, 170, 210, 20);
        Adressel.setFont(new Font("Monospaced",Font.PLAIN,12));
        Adressel.setForeground(couleur0);
        pan.add(Adressel);
        
        Tell =new JLabel("Tel :");
        Tell.setBounds(20,200,100,20);
        Tell.setFont(new Font("Monospaced",Font.PLAIN,12));
        Tell.setForeground(couleur0);
        pan.add(Tell);
        
        
        ID = new JTextField();
        ID.setBounds(300, 20, 100, 20);
        ID.setText("");
        ID.setBackground(couleur2);
        ID.setBorder(border);
        ID.setForeground(couleur0);
        pan.add(ID);

        Nom = new JTextField();
        Nom.setBounds(300, 50, 100, 20);
        Nom.setText("");
        Nom.setBackground(couleur2);
        Nom.setBorder(border);
        Nom.setForeground(couleur0);
        pan.add(Nom);

        Prenom = new JTextField();
        Prenom.setBounds(300, 80, 100, 20);
        Prenom.setText("");
        Prenom.setBackground(couleur2);
        Prenom.setBorder(border);
        Prenom.setForeground(couleur0);
        pan.add(Prenom);
        
        J = new JComboBox<>(jours);
        J.setSelectedIndex(0);
        J.setBounds(300,110,50,20);
        J.setBackground(couleur2);
        J.setBorder(border);
        J.setForeground(couleur0);
        pan.add(J);
        
        M = new JComboBox<>(mois);
        M.setSelectedIndex(0);
        M.setBounds(370,110,50,20);
        M.setBackground(couleur2);
        M.setBorder(border);
        M.setForeground(couleur0);
        pan.add(M);
        
        Y = new JComboBox<>(years);
        Y.setSelectedIndex(0);
        Y.setBounds(470,110,100,20);
        Y.setBackground(couleur2);
        Y.setBorder(border);
        Y.setForeground(couleur0);
        pan.add(Y);
        
        Ji = new JComboBox<>(jours);
        Ji.setSelectedIndex(0);
        Ji.setBounds(300,140,50,20);
        Ji.setBackground(couleur2);
        Ji.setBorder(border);
        Ji.setForeground(couleur0);
        pan.add(Ji);
        
        Mi = new JComboBox<>(mois);
        Mi.setSelectedIndex(0);
        Mi.setBounds(370,140,50,20);
        Mi.setBackground(couleur2);
        Mi.setBorder(border);
        Mi.setForeground(couleur0);
        pan.add(Mi);
        
        Yi = new JComboBox<>(years);
        Yi.setSelectedIndex(0);
        Yi.setBounds(470,140,100,20);
        Yi.setBackground(couleur2);
        Yi.setBorder(border);
        Yi.setForeground(couleur0);
        pan.add(Yi);

        Adresse = new JTextField();
        Adresse.setBounds(300, 170, 200, 20);
        Adresse.setText("");
        Adresse.setBackground(couleur2);
        Adresse.setBorder(border);
        Adresse.setForeground(couleur0);
        pan.add(Adresse);
        
        Tel = new JTextField();
        Tel.setBounds(300,200,200,20);
        Tel.setText("");
        Tel.setBackground(couleur2);
        Tel.setBorder(border);
        Tel.setForeground(couleur0);
        pan.add(Tel);
        
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
		String IDa=ID.getText();
		String Noma=Nom.getText();
		String Prenoma=Prenom.getText();
		String Date_Naissancea=J.getSelectedItem()+"/"+M.getSelectedItem()+"/"+Y.getSelectedItem();
		String Date_Inscriptiona=Ji.getSelectedItem()+"/"+Mi.getSelectedItem()+"/"+Yi.getSelectedItem();
		String Adressea= Adresse.getText();
		String Tela=Tel.getText();
		
		
		if (!IDa.isEmpty() && !Noma.isEmpty() && !Prenoma.isEmpty() && !Date_Naissancea.isEmpty() && !Date_Inscriptiona.isEmpty() && !Adressea.isEmpty() && !Tela.isEmpty()) {
	        
			 try {
			    int tela = Integer.parseInt(Tela);
			    Membre m = new Membre(IDa,Noma,Prenoma,Date_Naissancea,Date_Inscriptiona,Adressea,tela);
				if(g.getMembreMap().containsKey(m.getID())) {
					JOptionPane.showMessageDialog(this, "ID deja existant");
				}else {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					try {
						//Date M = sdf.parse()
						Date I = sdf.parse(Date_Inscriptiona);
						Date N = sdf.parse(Date_Naissancea);
						if(I.after(N)) {
							m.ajoutM(g, db);
					    	JOptionPane.showMessageDialog(this, "Membre ajouté avec succès");
						}else {
							JOptionPane.showMessageDialog(this, "Probléme avec vos Date");
						}
					} catch (ParseException e1) {
						
						e1.printStackTrace();
					}
					
				}
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "Tel invalide");
	        }
	}else {
			JOptionPane.showMessageDialog(this, "Erreur");
	}
	}else {
		if(e.getSource()==Anuler) {
			ID.setText("");
			Nom.setText("");
			Prenom.setText("");
			Adresse.setText("");
			Tel.setText("");
		}else {
			n.setVisible(true);
			this.dispose();
		}
	}
	}
		
}

