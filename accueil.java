package GestionStock;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.util.Properties;
public class accueil extends JFrame {
	 public accueil() {
		 super("Application");
		 getContentPane().setBackground(new Color(164, 194, 244));
	 JButton bt1=new JButton("Fourniseur");
	 bt1.setBounds(130, 70, 120, 30);
	  bt1.setBackground(new Color(44,62,150));
	    bt1.setForeground(new Color(236,240,241)); //lon ktiba
	 JButton bt2=new JButton("Client");
	 bt2.setBounds(330, 70, 120, 30);
	  bt2.setBackground(new Color(44,62,150));
	    bt2.setForeground(new Color(236,240,241));
	 JButton bt3=new JButton("Bons Entrés");
	 bt3.setBounds(130, 170, 120, 30);
	  bt3.setBackground(new Color(44,62,150));
	    bt3.setForeground(new Color(236,240,241));
	 JButton bt4=new JButton("Bons Sorties");
	 bt4.setBounds(330, 170, 120, 30);
	  bt4.setBackground(new Color(44,62,150));
	    bt4.setForeground(new Color(236,240,241));
	 JButton bt5=new JButton("Article");
	 bt5.setBounds(130, 270, 120, 30);
	  bt5.setBackground(new Color(44,62,150));
	    bt5.setForeground(new Color(236,240,241));
	 JButton bt6=new JButton("EMS");
	  bt6.setBackground(new Color(44,62,150));
	    bt6.setForeground(new Color(236,240,241));
	 bt6.setBounds(330, 270, 120, 30);
	 
	 bt1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Afficher_Fournisseur();
			
			
		}});
	 bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Afficher_Client();
				
				
			}});
	 bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Afficher_bonE();
			
				
			}});
	 bt4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Afficher_bonS();
				
				
			}});
	 bt5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Afficher_Article();
				
				
			}});
	 bt6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Afficher_EMS();
				
				
			}});
	 
	 
	 add(bt1);add(bt2); add(bt3);add(bt4); add(bt5);add(bt6);
	 setLayout(null);
	 setSize(600,500);
	 setVisible(true);
	 
	 
	 }
	 public void Afficher_Article()
	 {
		 new Article();
	 }
	 public void Afficher_Client()
	 {
		 new Client();
	 }
	 public void Afficher_Fournisseur()
	 {
		 new Fournisseur();
	 }
	 public void Afficher_bonE()
	 {
		 new BonE();
	 }public void Afficher_bonS()
	 {
		 new BonS();
	 }public void Afficher_EMS()
	 {
		 new EMS();
	 }
	public static void main(String[] args) {
	new accueil();
	
	}

	

}
