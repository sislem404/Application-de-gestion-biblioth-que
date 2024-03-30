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

public class AjouterE extends JFrame implements ActionListener {
	JPanel pan;
	JTextField IDe;
	JTextField IDm;
	JTextField ISBNl;
	JLabel IDel;
	JLabel IDml;
	JLabel ISBNll;
	JLabel Date_Empruntl;
	JLabel Date_Limitel;
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
	public AjouterE(Nav n,Gestion g,DB db) {
		this.g=g;
		this.db=db;
		this.n=n;
		setTitle("Ajouter Emprunt");
		setSize(800,500);
		setLocationRelativeTo(null);
		pan= new JPanel();
		pan.setBackground(couleur10);
		add(pan);
		
		IDel = new JLabel("IDe :");
        IDel.setBounds(20, 20, 100, 20);
        IDel.setFont(new Font("Monospaced",Font.PLAIN,12));
        IDel.setForeground(couleur0);
        pan.add(IDel);

        IDml = new JLabel("IDm :");
        IDml.setBounds(20, 50, 100, 20);
        IDml.setFont(new Font("Monospaced",Font.PLAIN,12));
        IDml.setForeground(couleur0);
        pan.add(IDml);

        ISBNll = new JLabel("ISBNl :");
        ISBNll.setBounds(20, 80, 100, 20);
        ISBNll.setFont(new Font("Monospaced",Font.PLAIN,12));
        ISBNll.setForeground(couleur0);
        pan.add(ISBNll);
        
        Date_Empruntl = new JLabel("Date Emprunt :");
        Date_Empruntl.setBounds(20, 110, 150, 20);
        Date_Empruntl.setFont(new Font("Monospaced",Font.PLAIN,12));
        Date_Empruntl.setForeground(couleur0);
        pan.add(Date_Empruntl);

        Date_Limitel = new JLabel("Date Limite :");
        Date_Limitel.setBounds(20, 140, 150, 20);
        Date_Limitel.setFont(new Font("Monospaced",Font.PLAIN,12));
        Date_Limitel.setForeground(couleur0);
        pan.add(Date_Limitel);
                
        IDe = new JTextField();
        IDe.setBounds(300, 20, 100, 20);
        IDe.setText("");
        IDe.setBackground(couleur2);
        IDe.setBorder(border);
        IDe.setForeground(couleur0);
        pan.add(IDe);

        IDm = new JTextField();
        IDm.setBounds(300, 50, 100, 20);
        IDm.setText("");
        IDm.setBackground(couleur2);
        IDm.setBorder(border);
        IDm.setForeground(couleur0);
        pan.add(IDm);

        ISBNl = new JTextField();
        ISBNl.setBounds(300, 80, 100, 20);
        ISBNl.setText("");
        ISBNl.setBackground(couleur2);
        ISBNl.setBorder(border);
        ISBNl.setForeground(couleur0);
        pan.add(ISBNl);
        
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
		// TODO Auto-generated method stub
		if(e.getSource()== Ajouter) {
			String IDea = IDe.getText();
			String IDma =IDm.getText();
			String ISBNla=ISBNl.getText();
			String Date_Emprunta=J.getSelectedItem()+"/"+M.getSelectedItem()+"/"+Y.getSelectedItem();;
			String Date_Limitea=Ji.getSelectedItem()+"/"+Mi.getSelectedItem()+"/"+Yi.getSelectedItem();
			String Date_IM = g.getMembreMap().get(IDma).getDate_Inscription();
			String Date_PL = g.getLivre().get(ISBNla).getDate_Publication();
			
			
			if(!IDea.isEmpty() && !IDma.isEmpty() && !ISBNla.isEmpty() && !Date_Emprunta.isEmpty() && !Date_Limitea.isEmpty()) {
				Emprunt emprunt = new Emprunt(IDea,IDma,ISBNla,Date_Emprunta,Date_Limitea);
				if(g.getEmpruntMap().containsKey(emprunt.getIDe())) {
					JOptionPane.showMessageDialog(this, "IDe deja existant");
				}else {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					try {
						//Date M = sdf.parse()
						Date IM= sdf.parse(Date_IM);
						Date PL= sdf.parse(Date_PL);
						Date L = sdf.parse(Date_Limitea);
						Date E = sdf.parse(Date_Emprunta);
						if((L.after(E) || L.equals(E)) && (E.after(PL) || E.equals(PL)) && (E.after(IM) || E.equals(IM))) {
							emprunt.ajouterE(g, db);
						}else {
							JOptionPane.showMessageDialog(this, "Probléme avec vos Date");
						}
					} catch (ParseException e1) {
						
						e1.printStackTrace();
					}
		           
					

				}
			}else {
				JOptionPane.showMessageDialog(this, "Erreur");
			}
		}else {
			if(e.getSource()==Anuler) {
				IDe.setText("");
				IDm.setText("");
				ISBNl.setText("");
			}else {
				n.setVisible(true);
				this.dispose();
			}
		}
		
	}
}
