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
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class RechercherM extends JFrame implements ActionListener {
	JPanel pan;
	JLabel IDlR;
	JTextField IDR;
	JLabel NomlR;
	JTextField NomR;
	JLabel PrenomlR;
	JTextField PrenomR;
	JLabel IDl;
	JLabel Noml;
	JLabel Prenoml;
	JLabel Date_Naissancel;
	JLabel Date_Inscriptionl;
	JLabel Adressel;
	JLabel Tell;
	JLabel ID;
	JLabel Nom;
	JLabel Prenom;
	JLabel Date_Naissance;
	JLabel Date_Inscription;
	JLabel Adresse;
	JLabel Tel;
	JButton Rechercher;
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
	JButton Retour;
	Nav n;
	Object donnee [][];
	String colonne[]= {"ID","Nom","Prénom","DN","DI","Adresse","Tel"};
	JTable table;
	JScrollPane scrollPane;
	JButton refresh;
	
	public RechercherM(Nav n,Gestion g,DB db) {
		this.g=g;
		this.db=db;
		this.n=n;
		
		donnee = new Object[g.getMembreMap().size()][7];
		int i =0;
		for(Map.Entry<String,Membre> mapentry : g.getMembreMap().entrySet()) {
			Membre lt=mapentry.getValue();
			donnee[i][0]=lt.getID();
			donnee[i][1]=lt.getNom();
			donnee[i][2]=lt.getPrenom();
			donnee[i][3]=lt.getDate_Naissance();
			donnee[i][4]=lt.getDate_Inscription();
			donnee[i][5]=lt.getAdresse();
			donnee[i][6]=lt.getTel();
			i++;
					}
		
		setTitle("Recherhcer Membre");
		setSize(1600,500);
		setLocationRelativeTo(null);
		pan= new JPanel();
		pan.setBackground(couleur10);
		add(pan);
		
		table=new JTable(donnee,colonne);
		table.setEnabled(false);
		table.setBackground(couleur2);
		table.setForeground(couleur0);
		table.setFont(new Font("Monospaced",Font.BOLD,12));
		scrollPane= new JScrollPane (table);
		scrollPane.setBounds(650,50,700,400);
		pan.add(scrollPane);
		
		refresh =new JButton("Refresh");
		refresh.setBackground(couleur2); 
        refresh.setForeground(couleur6); 
        refresh.setFont(new Font("Monospaced", Font.BOLD, 10)); 
        refresh.setFocusPainted(false);
        refresh.addActionListener(this);
        refresh.setBounds(650,10,150,20);
        pan.add(refresh);
		
		
		IDlR = new JLabel("ID :");
        IDlR.setBounds(20, 20, 100, 20);
        IDlR.setFont(new Font("Monospaced",Font.BOLD,12));
        IDlR.setForeground(couleur0);
        pan.add(IDlR);
        
        NomlR = new JLabel("Nom :");
        NomlR.setBounds(20, 50, 100, 20);
        NomlR.setFont(new Font("Monospaced",Font.BOLD,12));
        NomlR.setForeground(couleur0);
        pan.add(NomlR);
        
        PrenomlR = new JLabel("Prenom :");
        PrenomlR.setBounds(20,80,100,20);
        PrenomlR.setFont(new Font("Monospaced",Font.BOLD,12));
        PrenomlR.setForeground(couleur0);
        pan.add(PrenomlR);
        
        IDR = new JTextField();
        IDR.setBounds(300, 20, 100, 20);
        IDR.setFont(new Font("Monospaced",Font.BOLD,12));
        IDR.setText("");
        IDR.setBackground(couleur2);
        IDR.setBorder(border);
        IDR.setForeground(couleur0);
        pan.add(IDR);
        
        NomR = new JTextField();
        NomR.setBounds(300, 50, 100, 20);
        NomR.setFont(new Font("Monospaced",Font.BOLD,12));
        NomR.setText("");
        NomR.setBackground(couleur2);
        NomR.setBorder(border);
        NomR.setForeground(couleur0);
        pan.add(NomR);
        
        PrenomR =new JTextField();
        PrenomR.setBounds(300,80,100,20);
        PrenomR.setFont(new Font("Monospaced",Font.BOLD,12));
        PrenomR.setText("");
        PrenomR.setBackground(couleur2);
        PrenomR.setBorder(border);
        PrenomR.setForeground(couleur0);
        pan.add(PrenomR);
        
        
		IDl = new JLabel("ID :");
        IDl.setBounds(20, 110, 100, 20);
        IDl.setFont(new Font("Monospaced",Font.BOLD,12));
        IDl.setForeground(couleur0);
        pan.add(IDl);
        
        Prenoml =new JLabel("Prenom");
        Prenoml.setBounds(20,140,100,20);
        Prenoml.setFont(new Font("Monospaced",Font.BOLD,12));
        Prenoml.setForeground(couleur0);
        pan.add(Prenoml);

        Noml = new JLabel("Nom :");
        Noml.setBounds(20, 170, 100, 20);
        Noml.setFont(new Font("Monospaced",Font.BOLD,12));
        Noml.setForeground(couleur0);
        pan.add(Noml);

        Date_Naissancel = new JLabel("Date Naissance :");
        Date_Naissancel.setBounds(20, 200, 150, 20);
        Date_Naissancel.setFont(new Font("Monospaced",Font.BOLD,12));
        Date_Naissancel.setForeground(couleur0);
        pan.add(Date_Naissancel);
        
        Date_Inscriptionl = new JLabel("Date inscription :");
        Date_Inscriptionl.setBounds(20, 230, 150, 20);
        Date_Inscriptionl.setFont(new Font("Monospaced",Font.BOLD,12));
        Date_Inscriptionl.setForeground(couleur0);
        pan.add(Date_Inscriptionl);

        Adressel = new JLabel("Adresse :");
        Adressel.setBounds(20, 260, 150, 20);
        Adressel.setFont(new Font("Monospaced",Font.BOLD,12));
        Adressel.setForeground(couleur0);
        pan.add(Adressel);

        Tell = new JLabel("Tel :");
        Tell.setBounds(20, 290, 210, 20);
        Tell.setFont(new Font("Monospaced",Font.BOLD,12));
        Tell.setForeground(couleur0);
        pan.add(Tell);
        
        
        ID = new JLabel("");
        ID.setBounds(300, 110, 100, 20);
        ID.setFont(new Font("Monospaced",Font.BOLD,12));
        ID.setForeground(couleur0);
        pan.add(ID);

        Nom = new JLabel("");
        Nom.setBounds(300, 140, 100, 20);
        Nom.setFont(new Font("Monospaced",Font.BOLD,12));
        Nom.setForeground(couleur0);
        pan.add(Nom);
        
        Prenom =new JLabel("");
        Prenom.setBounds(300,170,100,20);
        Prenom.setFont(new Font("Monospaced",Font.BOLD,12));
        Prenom.setForeground(couleur0);
        pan.add(Prenom);

        Date_Naissance = new JLabel("");
        Date_Naissance.setBounds(300, 200, 100, 20);
        Date_Naissance.setFont(new Font("Monospaced",Font.BOLD,12));
        Date_Naissance.setForeground(couleur0);
        pan.add(Date_Naissance);
        
        Date_Inscription = new JLabel("");
        Date_Inscription.setBounds(300, 230, 100, 20);
        Date_Inscription.setFont(new Font("Monospaced",Font.BOLD,12));
        Date_Inscription.setForeground(couleur0);
        pan.add(Date_Inscription);

        Adresse = new JLabel("");
        Adresse.setBounds(300, 260, 150, 20);
        Adresse.setFont(new Font("Monospaced",Font.BOLD,12));
        Adresse.setForeground(couleur0);
        pan.add(Adresse);

        Tel = new JLabel("");
        Tel.setBounds(300, 290, 200, 20);
        Tel.setFont(new Font("Monospaced",Font.BOLD,12));
        Tel.setForeground(couleur0);
        pan.add(Tel);
        
        Rechercher=new JButton("Recherhcer");
        Rechercher.setBackground(couleur2); 
        Rechercher.setForeground(couleur6); 
        Rechercher.setFont(new Font("Monospaced", Font.BOLD, 16)); 
        Rechercher.setFocusPainted(false);
        
        Rechercher.addActionListener(this);
        
        Rechercher.setBounds(300,350,150,50);
        pan.add(Rechercher);
		
        Retour=new JButton("<");
        Retour.setBackground(couleur2); 
        Retour.setForeground(couleur6); 
        Retour.setFont(new Font("Monospaced", Font.BOLD, 16)); 
        Retour.setFocusPainted(false);
        
        Retour.addActionListener(this);
        
        Retour.setBounds(0,400,50,50);
        pan.add(Retour);
        
		pan.setLayout(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Rechercher) {
			if(g.getMembreMap().containsKey(IDR.getText())) {
				Membre m=g.getMembreMap().get(IDR.getText());
				if(m.getNom().equals(NomR.getText()) && m.getPrenom().equals(PrenomR.getText())) {
					ID.setText(m.getID());
					Nom.setText(m.getNom());
					Prenom.setText(m.getPrenom());
					Date_Naissance.setText(m.getDate_Naissance());
					Date_Inscription.setText(m.getDate_Inscription());
					Adresse.setText(m.getAdresse());
					Tel.setText(Integer.toString(m.getTel()));
				}else {
					JOptionPane.showMessageDialog(this, "ID ne correspont pas avec le Nom et le Prénom");
				}
			}else {
				JOptionPane.showMessageDialog(this, "L'ID n'existe pas");
			}
		}else {
			if(e.getSource()==refresh) {
				
				donnee = new Object[g.getMembreMap().size()][7];
				int i =0;
				for(Map.Entry<String,Membre> mapentry : g.getMembreMap().entrySet()) {
					Membre lt=mapentry.getValue();
					donnee[i][0]=lt.getID();
					donnee[i][1]=lt.getNom();
					donnee[i][2]=lt.getPrenom();
					donnee[i][3]=lt.getDate_Naissance();
					donnee[i][4]=lt.getDate_Inscription();
					donnee[i][5]=lt.getAdresse();
					donnee[i][6]=lt.getTel();
					i++;
							}

			    DefaultTableModel model = new DefaultTableModel(donnee, colonne);

			    table.setModel(model);
				
			}else {
				n.setVisible(true);
				this.dispose();
			}
		}
		
	}

}
