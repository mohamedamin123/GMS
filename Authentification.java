package GestionStock;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;



public class Authentification extends JFrame {
	protected String Username;
	protected String motPasse;
	JLabel l1=new JLabel("UserName");
	JTextField t1=new JTextField();
	JLabel l2=new JLabel("Password");
	JButton bt1=new JButton("Valider");
	JPasswordField  t2=new JPasswordField ();
	JLabel l3=new JLabel("");
	JLabel l4=new JLabel(" Form Login");
public Authentification()
{
	setTitle("Connexion");
	//username
	l1.setBounds(90, 50, 100, 100);
	 l1.setFont(new Font(Font.SERIF,Font.BOLD,17));
	 l1.setForeground(new Color(236,240,241));
	//place de username
	t1.setBounds(200, 90, 125, 25);
	t1.setBackground(new Color(108,122,137));
	t1.setForeground(Color.WHITE);
	
	//password
	l2.setBounds(90, 110, 100, 100);
	l2.setFont(new Font(Font.SERIF,Font.BOLD,17));
	l2.setForeground(new Color(236,240,241));
	
	//place de password
	t2.setBounds(200, 150, 125, 25);
	t2.setBackground(new Color(108,122,137));
	t2.setForeground(Color.WHITE);
	
	//place de erreur
    l3.setBounds(130, 280, 280, 55);
    l3.setFont(new Font(Font.SERIF,Font.BOLD,17));
    l3.setForeground(Color.RED);
	
    //button valider
	bt1.setBounds(190, 220, 125, 35);
	bt1.setBackground(new Color(34,167,240));
	
	//form login
	l4.setBounds(0, 0, 600, 55);
	l4.setForeground(new Color(236,240,241));
	l4.setFont(new Font(Font.SERIF,Font.BOLD,19));
	l4.setBackground(new Color(248,148,6));
	l4.setOpaque(true); //nzidha bech yo9ed orange
    getContentPane().setBackground(new Color(44,62,80));

	add(l1);add(t1);add(l2);add(t2);add(bt1);add(l3);add(l4);

	valider();
	setLayout(null);
	setSize(500,440);
	setVisible(true);
	
}
public void valider()
{
	bt1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
//				Statement st=db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
//				ResultSet rs=st.executeQuery("select * from employees");
//               rs.beforeFirst();
//				while(rs.next())
//				{
//                	String b1=rs.getString(2);
//                	String b2=rs.getString(3);
//
                	String pass = String.valueOf(t2.getPassword());
                	Username="admin";
                	motPasse="admin";
                	
                	if(Username.equals(t1.getText()) && motPasse.equals(pass))
                	{
                		setVisible(false);
                		new accueil();
                	}
                		else
                		{
                			 l3.setText("UserName or PassWord is wrong");
                			
                		}
                	
			//	}
//			} catch (ClassNotFoundException | SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			 
			
		}});
	
}

	public static void main(String[] args) {
		new Authentification();
		

	}

}
