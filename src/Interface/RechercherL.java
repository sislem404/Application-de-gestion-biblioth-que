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

public class RechercherL extends JFrame implements ActionListener {
	JPanel pan;
	JLabel ISBNlR;
	JTextField ISBNR;
	JLabel TitrelR;
	JTextField TitreR;
	JLabel ISBNl;
	JLabel Titrel;
	JLabel Auteurl;
	JLabel Genrel;
	JLabel Date_Publicationl;
	JLabel Nb_Exemplaires_Disponiblesl;
	JLabel ISBN;
	JLabel Titre;
	JLabel Auteur;
	JLabel Genre;
	JLabel Date_Publication;
	JLabel Nb_Exemplaires_Disponibles;
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
	String colonne[]= {"ISBN","Titre","Auteur","Genre","DP","Nb Ex"};
	JTable table;
	JScrollPane scrollPane;
	JButton refresh;
	public RechercherL(Nav n,Gestion g,DB db) {
		this.g=g;
		this.db=db;
		this.n=n;
		donnee = new Object[g.getLivre().size()][6];
		int i =0;
		for(Map.Entry<String,Livre> mapentry : g.getLivre().entrySet()) {
			Livre lt=mapentry.getValue();
			donnee[i][0]=lt.getISBN();
			donnee[i][1]=lt.getTitre();
			donnee[i][2]=lt.getAuteur();
			donnee[i][3]=lt.getGenre();
			donnee[i][4]=lt.getDate_Publication();
			donnee[i][5]=lt.getNb_Exemplaires_Disponibles();
			i++;
					}
		
		setTitle("Recherche Livre");
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
		
		ISBNlR = new JLabel("ISBN :");
        ISBNlR.setBounds(20, 20, 100, 20);
        ISBNlR.setFont(new Font("Monospaced",Font.BOLD,12));
        ISBNlR.setForeground(couleur0);
        pan.add(ISBNlR);
        
        TitrelR = new JLabel("Titre :");
        TitrelR.setBounds(20, 50, 100, 20);
        TitrelR.setFont(new Font("Monospaced",Font.BOLD,12));
        TitrelR.setForeground(couleur0);
        pan.add(TitrelR);
        
        ISBNR = new JTextField();
        ISBNR.setBounds(300, 20, 100, 20);
        ISBNR.setFont(new Font("Monospaced",Font.BOLD,12));
        ISBNR.setText("");
        ISBNR.setBackground(couleur2);
        ISBNR.setBorder(border);
        ISBNR.setForeground(couleur0);
        pan.add(ISBNR);
        
        TitreR = new JTextField();
        TitreR.setBounds(300, 50, 100, 20);
        TitreR.setFont(new Font("Monospaced",Font.BOLD,12));
        TitreR.setText("");
        TitreR.setBackground(couleur2);
        TitreR.setBorder(border);
        TitreR.setForeground(couleur0);
        pan.add(TitreR);
        
        
		ISBNl = new JLabel("ISBN :");
        ISBNl.setBounds(20, 80, 100, 20);
        ISBNl.setFont(new Font("Monospaced",Font.BOLD,12));
        ISBNl.setForeground(couleur0);
        pan.add(ISBNl);

        Titrel = new JLabel("Titre :");
        Titrel.setBounds(20, 110, 100, 20);
        Titrel.setFont(new Font("Monospaced",Font.BOLD,12));
        Titrel.setForeground(couleur0);
        pan.add(Titrel);

        Auteurl = new JLabel("Auteur :");
        Auteurl.setBounds(20, 140, 100, 20);
        Auteurl.setFont(new Font("Monospaced",Font.BOLD,12));
        Auteurl.setForeground(couleur0);
        pan.add(Auteurl);
        
        Genrel = new JLabel("Genre :");
        Genrel.setBounds(20, 170, 100, 20);
        Genrel.setFont(new Font("Monospaced",Font.BOLD,12));
        Genrel.setForeground(couleur0);
        pan.add(Genrel);

        Date_Publicationl = new JLabel("Date Publication :");
        Date_Publicationl.setBounds(20, 200, 150, 20);
        Date_Publicationl.setFont(new Font("Monospaced",Font.BOLD,12));
        Date_Publicationl.setForeground(couleur0);
        pan.add(Date_Publicationl);

        Nb_Exemplaires_Disponiblesl = new JLabel("Nombre d'Exemplaires Disponibles :");
        Nb_Exemplaires_Disponiblesl.setBounds(20, 230, 250, 20);
        Nb_Exemplaires_Disponiblesl.setFont(new Font("Monospaced",Font.BOLD,12));
        Nb_Exemplaires_Disponiblesl.setForeground(couleur0);
        pan.add(Nb_Exemplaires_Disponiblesl);
        
        
        ISBN = new JLabel("");
        ISBN.setBounds(300, 80, 100, 20);
        ISBN.setFont(new Font("Monospaced",Font.BOLD,12));
        ISBN.setForeground(couleur0);
        pan.add(ISBN);

        Titre = new JLabel("");
        Titre.setBounds(300, 110, 100, 20);
        Titre.setFont(new Font("Monospaced",Font.BOLD,12));
        Titre.setForeground(couleur0);
        pan.add(Titre);

        Auteur = new JLabel("");
        Auteur.setBounds(300, 140, 100, 20);
        Auteur.setFont(new Font("Monospaced",Font.BOLD,12));
        Auteur.setForeground(couleur0);
        pan.add(Auteur);
        
        Genre = new JLabel("");
        Genre.setBounds(300, 170, 100, 20);
        Genre.setFont(new Font("Monospaced",Font.BOLD,12));
        Genre.setForeground(couleur0);
        pan.add(Genre);

        Date_Publication = new JLabel("");
        Date_Publication.setBounds(300, 200, 150, 20);
        Date_Publication.setFont(new Font("Monospaced",Font.BOLD,12));
        Date_Publication.setForeground(couleur0);
        pan.add(Date_Publication);

        Nb_Exemplaires_Disponibles = new JLabel("");
        Nb_Exemplaires_Disponibles.setBounds(300, 230, 200, 20);
        Nb_Exemplaires_Disponibles.setFont(new Font("Monospaced",Font.BOLD,12));
        Nb_Exemplaires_Disponibles.setForeground(couleur0);
        pan.add(Nb_Exemplaires_Disponibles);
        
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
			if(g.getLivre().containsKey(ISBNR.getText())) {
				Livre l=g.getLivre().get(ISBNR.getText());
				if(l.getTitre().equals(TitreR.getText())) {
					ISBN.setText(l.getISBN());
					Titre.setText(l.getTitre());
					Auteur.setText(l.getAuteur());
					Genre.setText(l.getGenre());
					Date_Publication.setText(l.getDate_Publication());
					Nb_Exemplaires_Disponibles.setText(Integer.toString(l.getNb_Exemplaires_Disponibles()));
				}else {
					JOptionPane.showMessageDialog(this, "L'ISBN ne correspont pas au titre");
				}
			}else {
				JOptionPane.showMessageDialog(this, "L'ISBN n'existe pas");
			}
		}else {
			if(e.getSource()==refresh) {
				
				donnee = new Object[g.getLivre().size()][6];
				int i =0;
				for(Map.Entry<String,Livre> mapentry : g.getLivre().entrySet()) {
					Livre lt=mapentry.getValue();
					donnee[i][0]=lt.getISBN();
					donnee[i][1]=lt.getTitre();
					donnee[i][2]=lt.getAuteur();
					donnee[i][3]=lt.getGenre();
					donnee[i][4]=lt.getDate_Publication();
					donnee[i][5]=lt.getNb_Exemplaires_Disponibles();
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
