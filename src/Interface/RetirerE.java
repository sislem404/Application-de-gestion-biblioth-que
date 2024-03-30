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

public class RetirerE extends JFrame implements ActionListener {
	JPanel pan;
	JTextField IDe;
	JLabel IDel;
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
	Nav n;
	JButton Retour;
	public RetirerE(Nav n,Gestion g,DB db) {
		this.g=g;
		this.db=db;
		this.n=n;
		setTitle("Retirer Emprunt");
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
        
        IDe = new JTextField();
        IDe.setBounds(300, 20, 100, 20);
        IDe.setBackground(couleur2);
        IDe.setBorder(border);
        IDe.setForeground(couleur0);
        IDe.setText("");
        pan.add(IDe);
        
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
			if(g.getEmpruntMap().containsKey(IDe.getText())) {
				Emprunt E=g.getEmpruntMap().get(IDe.getText());
				E.suppE(g, db);
				JOptionPane.showMessageDialog(this, "Retirer avec succées");
			}else {
				JOptionPane.showMessageDialog(this, "L'Emprunt n'existe pas");
			}
	}else {
		n.setVisible(true);
		this.dispose();
	}
	}

}
