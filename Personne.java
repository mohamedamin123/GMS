package GestionStock;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;

import java.util.*;
public class Personne extends JFrame implements ActionListener {
	
	protected int CIN;
	protected String nom;
	protected String telephone;
	protected String Email;
	
	

 JButton bt1;
 JButton bt2;
 JRadioButton b1;
 JRadioButton b2;
  JLabel l01=new JLabel();
 JLabel l02;
 JLabel l03;
 JLabel l1;
 JLabel l2;
 JLabel l3;
 JLabel l4;
 JTextField t1;
 JTextField t2;
 JTextField t3;
 JTextField t4;
 JScrollPane js;
 JButton bt3;
 JButton bt4;
 JButton bt5;
 JFrame f;


public Personne()
{   

    
    l01.setFont(new Font(Font.SERIF,Font.BOLD,15));
    l01.setBounds(200,5, 160, 100);
    
    bt1=new JButton("Ajouter");
    bt1.setBounds(50,90, 100, 25);
    bt5=new JButton("Supprimer");
    bt5.setBounds(350,90, 100, 25);
    bt2=new JButton("Modifier");
    bt2.setBounds(200,90, 100, 25);
    

 
		 	
		

   
		
     bt1.addActionListener(new ActionListener () {

		@Override
		public void actionPerformed(ActionEvent e) {
	ajouter();
		}
    	 
     });
    
    
    
  		

    
    add(l01);add(bt1);add(bt2);add(bt5);
    setLayout(null);
    setSize(550,700);
    setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
	
	if(b1.isSelected()) 
		l1.setText("CIN");
		else
		l1.setText("Matricule");		
}
public void ajouter()
{
	 f=new JFrame("Ajouer/Modification");
	 l02=new JLabel("Ajouter/Modification");
	l02.setBounds(180, 5, 125, 125);
	
	
	b1=new JRadioButton(" Personne Physique");
	b1.setBounds(35,90,150,35);
	b2=new JRadioButton(" Personne Morale");
	b2.setBounds(35,120, 150, 35);
	ButtonGroup bg =new ButtonGroup();
	bg.add(b1);
	bg.add(b2);
	
	l1=new JLabel("Nom");
	t1=new JTextField();
	l1.setBounds(35, 165, 120,20);
	t1.setBounds(100, 165, 120,20);

	
	l2=new JLabel("Matricule");
	t2=new JTextField();
	l2.setBounds(35, 195, 120,20);
	t2.setBounds(100, 195, 120,20);

	
	l3=new JLabel("Email");
	t3=new JTextField();
	l3.setBounds(35, 225, 120,20);
	t3.setBounds(100, 225, 120,20);

				
	l4=new JLabel("Telephone");
	t4=new JTextField();
	l4.setBounds(35, 255, 120,20);
	t4.setBounds(100, 255, 120,20);
	
	bt3=new JButton("Enregistrer");
	bt3.setBounds(325, 90, 100, 25);
	bt3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				
				
      			Class.forName("com.mysql.cj.jdbc.Driver");
				Connection db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
				Statement st=db.createStatement();
				if(l01.getText()=="Liste de Client")
				{
	            st.executeUpdate("insert into client (idC,nom,telephone,email) values ('"+t2.getText()+"','"+t1.getText()+"','"+t4.getText()+"','"+t3.getText()+"')");
				
				}
				else
				{
				st.executeUpdate("insert into fournisseur (idF,nom,telephone,email) values ('"+t2.getText()+"','"+t1.getText()+"','"+t4.getText()+"','"+t3.getText()+"')");
				
				}
				db.close();
				
				f.setVisible(false);
				setVisible(false);
				
				
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	

			
		}});
	bt4=new JButton("Fermer");
	bt4.setBounds(325, 130, 100, 25);
    b1.addActionListener(new ActionListener () {

		@Override
		
		public void actionPerformed(ActionEvent e) {
			b2.addActionListener(this);
			if(b1.isSelected()) 
				l2.setText("CIN");
				else
				l2.setText("Matricule");
		}});
	bt4.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			f.setVisible(false);
			
		}});
	f.getContentPane().setBackground(new Color(164, 194, 244));				
	 l02.setFont(new Font(Font.SERIF,Font.BOLD,20));
	  l02.setBounds(150,0, 300, 100);
	b1.setBackground(new Color(164, 194, 244));
    b1.setForeground(Color.BLACK);
    b2.setBackground(new Color(164, 194, 244));
    b2.setForeground(Color.BLACK);
    t1.setForeground(Color.BLACK);
    t2.setForeground(Color.BLACK);
    t3.setForeground(Color.BLACK);
    t4.setForeground(Color.BLACK);
	        bt3.setBackground(new Color(44,62,150));
	        bt3.setForeground(new Color(236,240,241));
	        bt4.setBackground(new Color(44,62,150));
	        bt4.setForeground(new Color(236,240,241));
	      
	
	f.setLayout(null);
	f.add(t1);f.add(t2);f.add(t3);f.add(t4);f.add(bt3);f.add(bt4);
	 f.add(l02);f.add(b1);f.add(b2);f.add(l1);f.add(l2);f.add(l3);f.add(l4);
	f.setSize(500,500);
	f.setVisible(true);
}
}

