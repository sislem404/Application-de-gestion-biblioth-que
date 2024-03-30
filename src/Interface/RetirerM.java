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

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class RetirerM extends JFrame implements ActionListener{
	JPanel pan;
	JTextField ID;
	JLabel IDl;
	JTextField Nom;
	JLabel Noml;
	JTextField Prenom;
	JLabel Prenoml;
	JButton Retirer;
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
	public RetirerM(Nav n,Gestion g,DB db) {
		this.g=g;
		this.db=db;
		this.n=n;
		setTitle("Retirer Membre");
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
        Prenoml.setBounds(20,80,100,20);
        Prenoml.setFont(new Font("Monospaced",Font.PLAIN,12));
        Prenoml.setForeground(couleur0);
        pan.add(Prenoml);
        
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
        
        Retirer=new JButton("Retirer");
        Retirer.setBackground(couleur2);
        Retirer.setForeground(couleur6);
        Retirer.setFont(new Font("Monospaced", Font.BOLD, 16));
        Retirer.setFocusPainted(false);
        
        Retirer.addActionListener(this);
        
        Retirer.setBounds(300,350,200,100);
        pan.add(Retirer);
        
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
		if(e.getSource()==Retirer) {
			if(g.getMembreMap().containsKey(ID.getText())) {
				Membre M=g.getMembreMap().get(ID.getText());
				if(M.getNom().equals(Nom.getText()) && M.getPrenom().equals(Prenom.getText())) {
					M.suppM(g, db);
				}else
					JOptionPane.showMessageDialog(this, "L'ID ne correspont pas au nom et prenom");
			}else
					JOptionPane.showMessageDialog(this, "Il n'y a pas de membre qui correspont");
			
	}else {
		n.setVisible(true);
		this.dispose();
	}
	}
	

}
