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

public class RetirerL extends JFrame implements ActionListener {
	JPanel pan;
	JTextField ISBN;
	JLabel ISBNl;
	JTextField Titre;
	JLabel Titrel;
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
	public RetirerL(Nav n,Gestion g,DB db) {
		this.g=g;
		this.db=db;
		this.n=n;
		setTitle("Retirer Livre");
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
			
			Livre L=g.getLivre().get(ISBN.getText());
			if(L!=null) {
				if(L.getTitre().equals(Titre.getText())) {
					L.suppL(g, db);
				}else
					JOptionPane.showMessageDialog(this, "L'ISBN ne correspont pas au titre");
			}else {
				JOptionPane.showMessageDialog(this,"Il n'y a pas de Livre avec Cette ISBN");
			}
		}else {
			n.setVisible(true);
			this.dispose();
		
		}
	}
	

}
