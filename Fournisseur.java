package GestionStock;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
public class Fournisseur extends Personne {
	ResultSet rs;
	Connection db;
	Statement st;
	JTable tab;
	String [] tab1;
	String [][]tab2;
	public Fournisseur()
	{
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
			st=db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);

			rs=st.executeQuery("select * from fournisseur");

			rs.last();
			int nb1=rs.getRow();
			rs.beforeFirst();
			tab2=new String[nb1][4];

			int i=0;
			while(rs.next())

			{
				String id=rs.getString(2);
				String nom=rs.getString(1);
				String email=rs.getString(3);
				String telephone=rs.getString(4);
				tab2[i][0]=id;
				tab2[i][1]=nom;
				tab2[i][2]=telephone;
				tab2[i][3]=email;
				i++;
			}
			db.close();
			tab1=new String []{"Nom","CIN","Email","Telephone"};


		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JPanel p =new JPanel();
		tab=new JTable(tab2,tab1);
		js=new JScrollPane(tab);
		p.add(js);
		p.setBounds(0, 150, 500, 500);
		add(p);


		tab.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				f=new JFrame("Ajouer/Modification");
				b1=new JRadioButton(" Personne Physique");
				b2=new JRadioButton(" Personne Morale");
				l1=new JLabel("Nom");
				t1=new JTextField();
				l2=new JLabel("Matricule");
				t2=new JTextField();
				l3=new JLabel("Email");
				t3=new JTextField();
				l4=new JLabel("Telephone");
				t4=new JTextField();
				bt3=new JButton("Enregistrer");


				bt2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						modifier();

					}});
				bt5.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						supprimer();

					}});
			}});
		getContentPane().setBackground(new Color(164, 194, 244));
		p.setBackground(new Color(164, 194, 244));
		tab.setBackground(Color.WHITE);
		tab.setForeground(Color.BLACK);
		tab.setFont(new Font(Font.SANS_SERIF,Font.BOLD,11));
		JTableHeader header = tab.getTableHeader();
		header.setBackground(new Color(217, 217, 217));
		header.setForeground(Color.BLACK);
		header.setFont(new Font(Font.SERIF,Font.BOLD,12));
		bt1.setBackground(new Color(44,62,150));
		bt1.setForeground(new Color(236,240,241));
		bt2.setBackground(new Color(44,62,150));
		bt2.setForeground(new Color(236,240,241));
		bt5.setBackground(new Color(44,62,150));
		bt5.setForeground(new Color(236,240,241));
		l01.setForeground(Color.BLACK);
		l01.setFont(new Font(Font.SERIF,Font.BOLD,21));
		l01.setText("Listes des Fournisseur");

		l01.setBounds(160,5, 280, 100);
		JMenuBar MenuBar=new JMenuBar();
		JMenu m1 =new JMenu("File");
		JMenu m2 =new JMenu("Accueil");
		JMenuItem m22=new JMenuItem("Test");
		MenuBar.add(m2);
		m2.add(m22);
		JMenuItem mi1=new JMenuItem("Article");
		JMenuItem mi2=new JMenuItem("Bon Entr es");
		JMenuItem mi3=new JMenuItem("Bon Sorties");
		JMenuItem mi4=new JMenuItem("Client");
		JMenuItem mi5=new JMenuItem("Fournisseur");
		JMenu mi6=new JMenu("EMS");
		JMenuItem mi11=new JMenuItem("Maigre");
		JMenuItem mi21=new JMenuItem("Dorade");
		JMenuItem mi31=new JMenuItem("Loup");
		JMenuItem mi33=new JMenuItem("Type");
		mi6.add(mi33);mi6.add(mi11);mi6.add(mi21);mi6.add(mi31);
		m1.add(mi1);m1.add(mi2);m1.add(mi3);m1.add(mi4);m1.add(mi5);m1.add(mi6);
		MenuBar.add(m1);
		add(MenuBar);
		setJMenuBar(MenuBar);
		m22.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new accueil();
			}});
		mi33.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new EMS();
			}});
		mi2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new BonE();
			}});
		mi3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new BonS();
			}});
		mi4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Client();
			}});
		mi1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Article();
			}});
		mi11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Maigre();
			}});
		mi21.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Dorade();
			}});
		mi31.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Loup();
			}});

	}
	public void modifier()
	{
		l02=new JLabel("Ajouter/Modification");
		l02.setBounds(180, 5, 125, 125);



		b1.setBounds(35,90,150,35);

		b2.setBounds(35,120, 150, 35);
		ButtonGroup bg =new ButtonGroup();
		bg.add(b1);
		bg.add(b2);



		l1.setBounds(35, 165, 120,20);
		t1.setBounds(100, 165, 120,20);




		l2.setBounds(35, 195, 120,20);
		t2.setBounds(100, 195, 120,20);




		l3.setBounds(35, 225, 120,20);
		t3.setBounds(100, 225, 120,20);




		l4.setBounds(35, 255, 120,20);
		t4.setBounds(100, 255, 120,20);
		int i = tab.getSelectedRow();
		t1.setText((String)tab.getValueAt(i, 0));
		t2.setText((String)tab.getValueAt(i, 1));
		t3.setText((String)tab.getValueAt(i, 2));
		t4.setText((String)tab.getValueAt(i, 3));


		bt3.setBounds(325, 90, 100, 25);
		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
					Statement st=db.createStatement();

					st.executeUpdate("update fournisseur set email='"+t3.getText()+"',nom='"+t1.getText()+"',idF='"+t2.getText()+"',telephone='"+t4.getText()+"'where nom='"+tab.getValueAt(i, 0)+"'");

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
	public void supprimer()
	{
		int i = tab.getSelectedRow();
		t1.setText((String)tab.getValueAt(i, 0));
		t2.setText((String)tab.getValueAt(i, 1));
		t3.setText((String)tab.getValueAt(i, 2));
		t4.setText((String)tab.getValueAt(i, 3));
		try {


			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
			Statement st=db.createStatement();
			st.executeUpdate("delete from fournisseur where idF='"+tab.getValueAt(i, 1)+"'");


			f.setVisible(false);
			setVisible(false);


		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Fournisseur();
	}
}
