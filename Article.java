package GestionStock;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;


public class Article  extends JFrame {
	
	protected String calibre;
	protected String ref;
 JButton bt1;
 JButton bt2;
 JLabel l01;
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
 JTable tab;
 JButton bt3;
 JButton bt4;
 JButton bt5;
 JFrame f;
public Article()
{
	String [][]tab2=null;
	String []  tab1=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
		Statement st=db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=st.executeQuery("select * from article");

		rs.last();
		int nb1=rs.getRow(); //numero de ligne
		
		rs.beforeFirst();
		tab2=new String[nb1][2];
		 
		int i=0;
		while(rs.next())
			
		{
			 ref=rs.getString(1);
			 calibre=rs.getString(2);
			tab2[i][0]=ref;
			tab2[i][1]=calibre;
			i++;
		}
		db.close();
		tab1=new String []{"Ref","Designation"};
	     
	
	} catch (ClassNotFoundException | SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 JPanel p =new JPanel();
	 p.setBounds(0, 150, 500, 500);
	 tab=new JTable(tab2,tab1);
    js=new JScrollPane(tab);
    p.add(js);
	
	setTitle("Liste des Articles");
    l01=new JLabel("Liste des Articles");
    
    l01.setFont(new Font(Font.SERIF,Font.BOLD,20));
    l01.setBounds(175,5, 180, 120);
  
    bt1=new JButton("Ajouter");
    bt1.setBounds(50,100, 100, 25);
    ajouter();
     
     bt2=new JButton("Modifier");
     bt2.setBounds(200,100, 100, 25);
     bt5=new JButton("Supprimer");
     bt5.setBounds(350,100, 100, 25);
    
    tab.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			f=new JFrame("Ajouer/Modification");
			l1=new JLabel("Nom");
			bt3=new JButton("Enregistrer");
			l2=new JLabel("Description ");
			t2=new JTextField();
			t1=new JTextField();
			
			
			bt5.addActionListener(new ActionListener() { //supprimer

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					supprimer();
				}});
		
			bt2.addActionListener(new ActionListener() { //modifier

				@Override
				public void actionPerformed(ActionEvent e) {
					
					 modifier();
					 }});
			
		}});
    
    JMenuBar MenuBar=new JMenuBar();
    JMenu m1 =new JMenu("File");
    JMenu m2 =new JMenu("Accueil");
    JMenuItem m22=new JMenuItem("Test");
    MenuBar.add(m2);
    m2.add(m22);
    JMenuItem mi1=new JMenuItem("Article");
	JMenuItem mi2=new JMenuItem("Bon Entr�es");
	JMenuItem mi3=new JMenuItem("Bon Sorties");
	JMenuItem mi4=new JMenuItem("Client");
	JMenuItem mi5=new JMenuItem("Fournisseur");
	JMenu mi6=new JMenu("EMS");
	JMenuItem mi11=new JMenuItem("Maigre");
	JMenuItem mi21=new JMenuItem("Dorade");
	JMenuItem mi31=new JMenuItem("Loup");
	JMenuItem mi33=new JMenuItem("Type");
	mi6.add(mi33);
	mi6.add(mi11);mi6.add(mi21);mi6.add(mi31);
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
    mi5.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new Fournisseur();
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
    getContentPane().setBackground(new Color(164, 194, 244));
    l01.setForeground(Color.BLACK);
    p.setBackground(new Color(164, 194, 244));
    tab.setBackground(Color.WHITE);
    tab.setForeground(Color.BLACK);
    tab.setFont(new Font(Font.SANS_SERIF,Font.BOLD,12));
    JTableHeader header = tab.getTableHeader();
    header.setBackground(new Color(217, 217, 217));
    header.setForeground(Color.BLACK);
    header.setFont(new Font(Font.SERIF,Font.BOLD,15));
    bt1.setBackground(new Color(44,62,150));
    bt1.setForeground(new Color(236,240,241));
    bt2.setBackground(new Color(44,62,150));
    bt2.setForeground(new Color(236,240,241));
    bt5.setBackground(new Color(44,62,150));
    bt5.setForeground(new Color(236,240,241));

    add(p);
    add(l01);add(bt1);add(bt2);add(bt5);
    setLayout(null);
    setSize(520,700);
    setVisible(true);
}
public void ajouter()
{
	bt1.addActionListener(new ActionListener () {

		@Override
		public void actionPerformed(ActionEvent e) {
			 f=new JFrame("Ajouer/Modification");
			 l02=new JLabel("Ajouter/Modification");
			l02.setBounds(180, 5, 125, 125);
			
			
			
			l1=new JLabel("Nom");
			t1=new JTextField();
			l1.setBounds(35,90,120,20);
			t1.setBounds(105, 90, 120,20);

			
			l2=new JLabel("Description ");
			t2=new JTextField();
			l2.setBounds(35,120, 120,20);
			t2.setBounds(105, 120, 120,20);

			
		
			
			bt3=new JButton("Enregistrer");
			bt3.setBounds(70, 170, 100, 25);
			bt3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
						Statement st=db.createStatement();
						st.executeUpdate("insert into article values ('"+t1.getText()+"','"+t2.getText()+"')");
						db.close();
					
						f.setVisible(false);
						setVisible(false);
						
						
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                  
				System.out.println(t1.getText());
				System.out.println(t2.getText());
				}});
			
			bt4=new JButton("Fermer");
			bt4.setBounds(300, 170, 100, 25);
	
			bt4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					f.setVisible(false);
					
				}});
			f.getContentPane().setBackground(new Color(164, 194, 244));				
			 l02.setFont(new Font(Font.SERIF,Font.BOLD,20));
			  l02.setBounds(150,0, 300, 100);
		
	      
	        t1.setForeground(Color.BLACK);
	        t2.setForeground(Color.BLACK);
	      
			        bt3.setBackground(new Color(44,62,150));
			        bt3.setForeground(new Color(236,240,241));
			        bt4.setBackground(new Color(44,62,150));
			        bt4.setForeground(new Color(236,240,241));
			
			
			f.setLayout(null);
			f.add(t1);f.add(t2);f.add(bt3);f.add(bt4);
			 f.add(l02);f.add(l1);f.add(l2);
			f.setSize(500,500);
			f.setVisible(true);
		}
    	 
     });
}
public void modifier()
{
	l02=new JLabel("Ajouter/Modification");
	l02.setBounds(180, 5, 125, 125);
	
	
	

	
	l1.setBounds(35,90,120,20);
	t1.setBounds(105, 90, 120,20);
	
	
	
	l2.setBounds(35,120, 120,20);
	t2.setBounds(105, 120, 120,20);

	int i = tab.getSelectedRow();
	t1.setText((String)tab.getValueAt(i, 0));
    t2.setText((String)tab.getValueAt(i, 1));
    

	
	
	bt3.setBounds(70, 170, 100, 25);
	bt3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
				Statement st=db.createStatement();
				st.executeUpdate("update article set refART='"+t1.getText()+"',designation='"+t2.getText()+"'where refART='"+tab.getValueAt(i, 0)+"'");
				
				f.setVisible(false);
				setVisible(false);
				
				
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
              
		//System.out.println(t1.getText());
		//System.out.println(t2.getText());	
		}});
	
	bt4=new JButton("Fermer");
	bt4.setBounds(300, 170, 100, 25);

	bt4.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			f.setVisible(false);
			
		}});
	
	f.getContentPane().setBackground(new Color(164, 194, 244));				
	 l02.setFont(new Font(Font.SERIF,Font.BOLD,20));
	  l02.setBounds(150,0, 300, 100);

  
    t1.setForeground(Color.BLACK);
    t2.setForeground(Color.BLACK);
  
	        bt3.setBackground(new Color(44,62,150));
	        bt3.setForeground(new Color(236,240,241));
	        bt4.setBackground(new Color(44,62,150));
	        bt4.setForeground(new Color(236,240,241));
	 
	f.setLayout(null);
	f.add(t1);f.add(t2);f.add(bt3);f.add(bt4);
	 f.add(l02);f.add(l1);f.add(l2);
	f.setSize(500,500);
	f.setVisible(true);
	
	
	

	
}

public void supprimer()
{
	int i = tab.getSelectedRow();
	
	t1.setText((String)tab.getValueAt(i, 0));
    t2.setText((String)tab.getValueAt(i, 1));
    try {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
		Statement st=db.createStatement();
		st.executeUpdate("delete from article where refART='"+tab.getValueAt(i, 0)+"'");
		
		f.setVisible(false);
		setVisible(false);
		
		
		
	} catch (ClassNotFoundException | SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
      
	

}





}
