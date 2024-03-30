package Interface;

import bibliotheque.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedString;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Login extends JFrame implements ActionListener {
	
	JPanel pan;
	JLabel usernamel,passwordl;
	JTextField username,password;
	JButton Log;
	DB db;
	Gestion g;
	Nav nav;
	
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
	
	public Login(Gestion g,DB db) {
		this.g=g;
		this.db=db;
		nav = new Nav(this,g,db);
		setTitle("Login");
		setSize(500,500);
		setLocationRelativeTo(null);
		pan= new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    BufferedImage image = ImageIO.read(new File("C:/Users/HP/eclipse-workspace/Gestion_Bibliotheque/src/Interface/log.jpg"));
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        pan.setOpaque(true);
        add(pan);
        
		usernamel= new JLabel("Username :");
        usernamel.setFont(new Font("Monospaced",Font.PLAIN,12));
        usernamel.setForeground(couleur0);
		passwordl= new JLabel("Password :");
		passwordl.setFont(new Font("Monospaced",Font.PLAIN,12));
        passwordl.setForeground(couleur0);
		username=new JTextField("");
		username.setBackground(couleur2);
        username.setBorder(border);
        username.setForeground(couleur0);
		password=new JTextField("");
		password.setBackground(couleur2);
        password.setBorder(border);
        password.setForeground(couleur0);
		Log= new JButton ("Se Connecter");
		Log.setBackground(couleur2); 
        Log.setForeground(couleur6); 
        Log.setFont(new Font("Monospaced", Font.BOLD, 16)); 
        Log.setFocusPainted(false);
		Log.addActionListener(this);
		usernamel.setBounds(150, 150, 100, 50);
		passwordl.setBounds(150,200,100,50);
		username.setBounds(250, 165, 100, 25);
		password.setBounds(250,215,100,25);
		Log.setBounds(150,400,200,50);
		pan.add(usernamel);
		pan.add(passwordl);
		pan.add(username);
		pan.add(password);
		pan.add(Log);
		pan.setLayout(null);		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(db.Log(username.getText(), password.getText())) {
			nav.setVisible(true);
			this.dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "username ou mdp incorrect");
		}
	}
	

}
