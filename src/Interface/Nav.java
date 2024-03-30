package Interface;

import bibliotheque.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Nav extends JFrame implements ActionListener {
	
	
	ActionListener A;
	ActionListener Al;
	ActionListener Am;
	ActionListener Ae;
	JPanel pan;
	JPanel pan1;
	JButton Ajouter;
	JButton Retirer;
	JButton Rechercher;
	Gestion g;
	DB db;
	AjouterL ajouterL;
	AjouterM ajouterM;
	AjouterE ajouterE;
	RetirerL retirerL;
	RetirerM retirerM;
	RetirerE retirerE;
	RechercherL rechercherL;
	RechercherM rechercherM;
	RechercherE rechercherE;
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
	JButton Livre;
	JButton Membre;
	JButton Emprunt;
	JButton Retour;
	Login a;
	ImageIcon iconl;
	ImageIcon iconm;
	ImageIcon icone;
	JLabel l;
	JLabel m;
	JLabel e;
	public Nav(Login a,Gestion g,DB db) {
		this.g=g;
		this.db=db;
		ajouterL=new AjouterL (this,g,db);
		ajouterM=new AjouterM (this,g,db);
		ajouterE=new AjouterE (this,g,db);
		retirerL=new RetirerL (this,g,db);
		retirerM=new RetirerM (this,g,db);
		retirerE=new RetirerE (this,g,db);
		rechercherL=new RechercherL (this,g,db);
		rechercherM=new RechercherM (this,g,db);
		rechercherE=new RechercherE (this,g,db);
		Al= new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==Ajouter) {
					ajouterL.setVisible(true);
					Nav.this.dispose();
				}else {
					if(e.getSource()==Retirer) {
						retirerL.setVisible(true);
						Nav.this.dispose();
					}else {
						if(e.getSource()==Rechercher) {
							rechercherL.setVisible(true);
							Nav.this.dispose();
						}
					}
				}
			}
        	
        };
        Am= new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==Ajouter) {
					ajouterM.setVisible(true);
					Nav.this.dispose();
				}else {
					if(e.getSource()==Retirer) {
						retirerM.setVisible(true);
						Nav.this.dispose();
					}else {
						if(e.getSource()==Rechercher) {
							rechercherM.setVisible(true);
							Nav.this.dispose();
						}
					}
				}
			}
        	
        };
        Ae= new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==Ajouter) {
					ajouterE.setVisible(true);
					Nav.this.dispose();
				}else {
					if(e.getSource()==Retirer) {
						retirerE.setVisible(true);
						Nav.this.dispose();
					}else {
						if(e.getSource()==Rechercher) {
							rechercherE.setVisible(true);
							Nav.this.dispose();
						}
					}
				}
			}
        	
        };
		
		setTitle("Accueil");
		setSize(1000,650);
		setLocationRelativeTo(null);
		pan= new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    BufferedImage image = ImageIO.read(new File("C:/Users/HP/eclipse-workspace/Gestion_Bibliotheque/src/Interface/background2.jpg"));
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        pan.setOpaque(true);
		add(pan);

		Ajouter=new JButton("Ajouter");
		Retirer=new JButton("Retirer");
		Rechercher=new JButton("Recherche");
		Ajouter.setBackground(couleur8); 
        Ajouter.setForeground(couleur6); 
        Ajouter.setFont(new Font("Monospaced", Font.BOLD, 17)); 
        Ajouter.setFocusPainted(false);
        Retirer.setBackground(couleur8); 
        Retirer.setForeground(couleur6); 
        Retirer.setFont(new Font("Monospaced", Font.BOLD, 17)); 
        Retirer.setFocusPainted(false);
        Rechercher.setBackground(couleur8); 
        Rechercher.setForeground(couleur6); 
        Rechercher.setFont(new Font("Monospaced", Font.BOLD, 17)); 
        Rechercher.setFocusPainted(false);
        Ajouter.setBounds(475,100,250,50);
		Retirer.setBounds(475,160,250,50);
		Rechercher.setBounds(475,220,250,50);
		
		
		Ajouter.addActionListener(Al);
		Retirer.addActionListener(Al);
		Rechercher.addActionListener(Al);
		
		
		pan.add(Ajouter);
		pan.add(Retirer);
		pan.add(Rechercher);
		
        pan1=new JPanel();
        pan1.setBounds(0,0,200,650);
        pan1.setBackground(couleur8);
        pan.add(pan1);
        
        iconl = new ImageIcon("C:/Users/HP/eclipse-workspace/Gestion_Bibliotheque/src/Interface/livre.png");
		Livre=new JButton(iconl);
        Livre.setBorderPainted(false);
        Livre.setFocusPainted(false);
        Livre.setContentAreaFilled(false);
        
        l= new JLabel ("Gestion de Livre");
        l.setFont(new Font("Monospaced",Font.BOLD,16));
        l.setForeground(couleur0);
        l.setBackground(couleur4);
        l.setOpaque(true);
        
		iconm = new ImageIcon("C:/Users/HP/eclipse-workspace/Gestion_Bibliotheque/src/Interface/membre.png");
		Membre=new JButton(iconm);
        Membre.setBorderPainted(false);
        Membre.setFocusPainted(false);
        Membre.setContentAreaFilled(false);
        
        m= new JLabel ("Gestion de Membre");
        m.setFont(new Font("Monospaced",Font.BOLD,16));
        m.setForeground(couleur0);
        m.setBackground(couleur5);
        m.setOpaque(true);
        
		icone = new ImageIcon("C:/Users/HP/eclipse-workspace/Gestion_Bibliotheque/src/Interface/emprunt.png");
		Emprunt=new JButton(icone);
        Emprunt.setBorderPainted(false);
        Emprunt.setFocusPainted(false);
        Emprunt.setContentAreaFilled(false);
        
        e= new JLabel ("Gestion d'Emprunt");
        e.setFont(new Font("Monospaced",Font.BOLD,16));
        e.setForeground(couleur0);
        e.setBackground(couleur5);
        e.setOpaque(true);
		
		Livre.setBounds(25,0,150,150);
		l.setBounds(5,160,190,25);
		Membre.setBounds(25,200,150,150);
		m.setBounds(5,360,190,25);
		Emprunt.setBounds(25,400,150,150);
		e.setBounds(5,560,190,25);
		
		
        Livre.addActionListener(this);
        Membre.addActionListener(this);
        Emprunt.addActionListener(this);
        
        
        
        
        pan1.add(Livre);
        pan1.add(l);
        pan1.add(Membre);
        pan1.add(m);
        pan1.add(Emprunt);
        pan1.add(e);
        
       
        
		pan1.setLayout(null);
		pan.setLayout(null);
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Livre) {
			l.setBackground(couleur4);
			m.setBackground(couleur5);
			this.e.setBackground(couleur5);
			ActionListener[] listeners = Ajouter.getActionListeners();
			for (ActionListener listener : listeners) {
			    Ajouter.removeActionListener(listener);
			    Retirer.removeActionListener(listener);
			    Rechercher.removeActionListener(listener);
			}
			Ajouter.addActionListener(Al);
			Retirer.addActionListener(Al);
			Rechercher.addActionListener(Al);
			
			
		}else {
			if(e.getSource()==Membre) {
				l.setBackground(couleur5);
				m.setBackground(couleur4);
				this.e.setBackground(couleur5);
				ActionListener[] listeners = Ajouter.getActionListeners();
				for (ActionListener listener : listeners) {
				    Ajouter.removeActionListener(listener);
				    Retirer.removeActionListener(listener);
				    Rechercher.removeActionListener(listener);
				}
				Ajouter.addActionListener(Am);
				Retirer.addActionListener(Am);
				Rechercher.addActionListener(Am);
				
			}else {
				if(e.getSource()==Emprunt) {
					l.setBackground(couleur5);
					m.setBackground(couleur5);
					this.e.setBackground(couleur4);
					ActionListener[] listeners = Ajouter.getActionListeners();
					for (ActionListener listener : listeners) {
					    Ajouter.removeActionListener(listener);
					    Retirer.removeActionListener(listener);
					    Rechercher.removeActionListener(listener);
					}
					Ajouter.addActionListener(Ae);
					Retirer.addActionListener(Ae);
					Rechercher.addActionListener(Ae);
					
				}
			}
		}
		
	}
	

}
