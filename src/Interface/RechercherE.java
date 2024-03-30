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

public class RechercherE extends JFrame implements ActionListener {
	JPanel pan;
	JLabel IDelR;
	JTextField IDeR;
	JLabel IDel;
	JLabel IDml;
	JLabel ISBNll;
	JLabel Date_Empruntl;
	JLabel Date_Limitel;
	JLabel IDe;
	JLabel IDm;
	JLabel ISBNl;
	JLabel Date_Emprunt;
	JLabel Date_Limite;
	JButton Rechercher;
	Gestion g;
	DB db;
	JButton Retour;
	Nav n;
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
	Object donnee [][];
	String colonne[]= {"IDe","IDm","ISBNl","DE","DL"};
	JTable table;
	JScrollPane scrollPane;
	JButton refresh;
	
	public RechercherE(Nav n,Gestion g,DB db) {
		this.g=g;
		this.db=db;
		this.n=n;
		
		donnee = new Object[g.getEmpruntMap().size()][5];
		int i =0;
		for(Map.Entry<String,Emprunt> mapentry : g.getEmpruntMap().entrySet()) {
			Emprunt lt=mapentry.getValue();
			donnee[i][0]=lt.getIDe();
			donnee[i][1]=lt.getIDm();
			donnee[i][2]=lt.getISBNl();
			donnee[i][3]=lt.getDate_Emprunt();
			donnee[i][4]=lt.getDate_Limite();
			i++;
					}
		
		setTitle("Rechercher Emprunt");
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
		
		IDelR = new JLabel("IDe :");
        IDelR.setBounds(20, 20, 100, 20);
        IDelR.setFont(new Font("Monospaced",Font.BOLD,12));
        IDelR.setForeground(couleur0);
        pan.add(IDelR);
        
        IDeR = new JTextField();
        IDeR.setBounds(300, 20, 100, 20);
        IDeR.setFont(new Font("Monospaced",Font.BOLD,12));
        IDeR.setText("");
        IDeR.setBackground(couleur2);
        IDeR.setBorder(border);
        IDeR.setForeground(couleur0);
        pan.add(IDeR);
        
		IDel = new JLabel("IDe :");
        IDel.setBounds(20, 80, 100, 20);
        IDel.setFont(new Font("Monospaced",Font.BOLD,12));
        IDel.setForeground(couleur0);
        pan.add(IDel);

        IDml = new JLabel("IDm :");
        IDml.setBounds(20, 110, 100, 20);
        IDml.setFont(new Font("Monospaced",Font.BOLD,12));
        IDml.setForeground(couleur0);
        pan.add(IDml);

        ISBNll = new JLabel("ISBNl :");
        ISBNll.setBounds(20, 140, 100, 20);
        ISBNll.setFont(new Font("Monospaced",Font.BOLD,12));
        ISBNll.setForeground(couleur0);
        pan.add(ISBNll);
        
        Date_Empruntl = new JLabel("DateEmprunt :");
        Date_Empruntl.setBounds(20, 170, 100, 20);
        Date_Empruntl.setFont(new Font("Monospaced",Font.BOLD,12));
        Date_Empruntl.setForeground(couleur0);
        pan.add(Date_Empruntl);

        Date_Limitel = new JLabel("Date Publication :");
        Date_Limitel.setBounds(20, 200, 150, 20);
        Date_Limitel.setFont(new Font("Monospaced",Font.BOLD,12));
        Date_Limitel.setForeground(couleur0);
        pan.add(Date_Limitel);        
        
        IDe = new JLabel("");
        IDe.setBounds(300, 80, 100, 20);
        IDe.setFont(new Font("Monospaced",Font.BOLD,12));
        IDe.setForeground(couleur0);
        pan.add(IDe);

        IDm = new JLabel("");
        IDm.setBounds(300, 110, 100, 20);
        IDm.setFont(new Font("Monospaced",Font.BOLD,12));
        IDm.setForeground(couleur0);
        pan.add(IDm);

        ISBNl = new JLabel("");
        ISBNl.setBounds(300, 140, 100, 20);
        ISBNl.setFont(new Font("Monospaced",Font.BOLD,12));
        ISBNl.setForeground(couleur0);
        pan.add(ISBNl);
        
        Date_Emprunt = new JLabel("");
        Date_Emprunt.setBounds(300, 170, 100, 20);
        Date_Emprunt.setFont(new Font("Monospaced",Font.BOLD,12));
        Date_Emprunt.setForeground(couleur0);
        pan.add(Date_Emprunt);

        Date_Limite = new JLabel("");
        Date_Limite.setBounds(300, 200, 150, 20);
        Date_Limite.setFont(new Font("Monospaced",Font.BOLD,12));
        Date_Limite.setForeground(couleur0);
        pan.add(Date_Limite);
        
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
			if(g.getEmpruntMap().containsKey(IDeR.getText())) {
				Emprunt E=g.getEmpruntMap().get(IDeR.getText());
				IDe.setText(E.getIDe());
				IDm.setText(E.getIDm());
				ISBNl.setText(E.getISBNl());
				Date_Emprunt.setText(E.getDate_Emprunt());
				Date_Limite.setText(E.getDate_Limite());
			}else {
				JOptionPane.showMessageDialog(this, "L'IDe n'existe pas");
			}
		}else {
			if(e.getSource()==refresh) {
				
				donnee = new Object[g.getEmpruntMap().size()][5];
			    int i = 0;
			    for (Map.Entry<String, Emprunt> mapentry : g.getEmpruntMap().entrySet()) {
			        Emprunt lt = mapentry.getValue();
			        donnee[i][0] = lt.getIDe();
			        donnee[i][1] = lt.getIDm();
			        donnee[i][2] = lt.getISBNl();
			        donnee[i][3] = lt.getDate_Emprunt();
			        donnee[i][4] = lt.getDate_Limite();
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
