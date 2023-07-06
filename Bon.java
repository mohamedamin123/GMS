package GestionStock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;


import javax.swing.*;

import javax.swing.table.JTableHeader;

import javax.swing.table.TableColumn;
public class Bon extends JFrame  {
	protected String refB;
	protected Date date;
	protected float qteB;
	protected String type;
	protected String calibre;
	
	
	 int nb1;
	 JLabel l01;
	 JLabel l02;
	 JLabel l1;
	 JLabel l2;
	 JLabel l3;
	 JLabel l4;
	 JTextField t1;
	 JTextField t2;
	 JTextField t3;
	 JTextField t4;
	 JTextField t001;
	 JTextField t002;
	 String []tab1= {"Num Bon","id","Date","Nom","Ref","Designation","Qte"};
	 String [][]tab2=new String[7][7];
	 String []tab3;
	 String []tab4= {"Ref","Designation","Qte"};
	 String [][]tab5=new String[5][3];
	 String [][]tab6=new String[5][3];
	 JComboBox cb;
	 JComboBox jc2;
	 JButton bt1;
	 JButton bt2;
	 JButton bt3;
	 JButton bt4;
	 JButton bt5;
	 JPanel p;
	 JPanel p2;
	 JTable tab;
	 JTable tab66;
	 JScrollPane js;
	 JFrame f;
	 JRadioButton b1;
	 JRadioButton b2;
	 JLabel l001;
	 JLabel l002;
	 JLabel l003;
	 ResultSet rs,rs2,rs11,rs12,rs33;
	 Connection db;
	 Statement st;
	 int idE,idS,ik,nb14;
	 String idEE,ides;
	 
	 TableColumn col;

	public Bon()
	{
		setTitle("Liste des Bon");
	    l01=new JLabel("Liste des Bon");
	    l01.setFont(new Font(Font.SERIF,Font.BOLD,19));
	    l01.setBounds(160,5, 190, 100);
	    l01.setForeground(new Color(236,240,241));
	  
	    bt1=new JButton("Ajouter");
	    bt1.setBounds(50,90, 100, 25);
	    bt2=new JButton("Modifier");
	    bt2.setBounds(200,90, 100, 25);
	    bt5=new JButton("Supprimer");
	    bt5.setBounds(350,90, 100, 25);
	    
	    getContentPane().setBackground(new Color(104, 109, 204));
	   
	    bt1.setBackground(new Color(44,62,110));
	    bt1.setForeground(new Color(236,240,241));
	    bt2.setBackground(new Color(44,62,110));
	    bt2.setForeground(new Color(236,240,241));
	    bt5.setBackground(new Color(44,62,110));
	    bt5.setForeground(new Color(236,240,241));
			
	     bt1.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e1) {
		    	ajouter();
			}
	    	 
	     });
	    
	    

	    
	    
	    
	     setLayout(null);
	   
	     add(l01);add(bt1);add(bt2);add(bt5);
	     
	     setSize(520,650);
	     setVisible(true);
	}

	public void ajouter()
	{
		System.out.println(l01.getText().toString());
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
				 st=db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);	 
				 
				 st=db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				 if(l01.getText()=="Liste de Bons entres")
				 rs=st.executeQuery("select nom from fournisseur");
				 else
				rs=st.executeQuery("select nom from client");
				 
				 rs.last();
				 nb1=rs.getRow();
				 rs.beforeFirst();
				 tab3=new String[nb1];
				 int nb=0;
				    while (rs.next()) {
				 String nom = rs.getString("nom");
				
				 tab3[nb]=nom;
					nb++;
				    }
				    db.close();
			} catch (ClassNotFoundException | SQLException e2) {
				
				e2.printStackTrace();
			}
		 f=new JFrame("Ajouer/Modification");
		 l02=new JLabel("Ajouter/Modification");
		l02.setBounds(180, 5, 125, 125);
		
		 p2 =new JPanel();

	      JTable tab=new JTable(tab5,tab4);
	      col = tab.getColumnModel().getColumn(0);
	      cb = new JComboBox();

	   
	     
	     js=new JScrollPane(tab);
	     tab.setFillsViewportHeight(true);
	     p2.add(js);
	     p2.setBounds(0, 200, 500, 500);  
		 try {
		 		Class.forName("com.mysql.cj.jdbc.Driver");
		 		Connection db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
		 		Statement st=db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		 		ResultSet rs=st.executeQuery("select * from article");
		 		rs.last();
		 		int nb1=rs.getRow();
		 		rs.beforeFirst();
		 		
		 		int i=0;
		 		 
		 		while(rs.next())
		 			
		 			
		 		{
		 			String refARt=rs.getString(1);
		 			String designation=rs.getString(2);
		 			cb.addItem(refARt);
		 			
		 		   
		 			i++;
		 		}
		 		
		 	
		 	} catch (ClassNotFoundException | SQLException e4) {
		 		// TODO Auto-generated catch block
		 		e4.printStackTrace();
		 	}
		 col.setCellEditor(new DefaultCellEditor(cb));
		 cb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
                  try {
					
                 	 if(cb.getSelectedItem() != null)
						{
					rs=st.executeQuery("select designation from article where refART ='"+cb.getSelectedItem()+"'");
					rs.last();
					
					String aa=rs.getString(1);
				
					int i= tab.getSelectedRow();
               		
               		tab.setValueAt(aa, i, 1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}});
      
      
	     
	    
		l001=new JLabel("Date");
		l001.setBounds(35,90,120,20);
		t001=new JTextField();
		t001.setEditable(false);
		t001.setBounds(100, 90, 120,20);
		l002=new JLabel("Nom");
		l002.setBounds(35,120, 120, 20);
		jc2=new JComboBox(tab3);
		jc2.setBounds(100, 120, 120,20);

		l2=new JLabel("Num Bon");
		t2=new JTextField();
		l2.setBounds(35, 150, 120,20);
		t2.setBounds(100, 150, 120,20);
		t2.setEditable(false);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
			 st=db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);	 
			 if(l01.getText()=="List de Bons Entres")
			 rs=st.executeQuery("select idBE from bone");
			 else
			 rs=st.executeQuery("select idBS from bons");

			 rs.last();

//			 nb1=(int) rs.getLong(1);
//			System.out.println("idd2 "+nb1);
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 
		String nb2=Integer.toString(nb1+1);
		
		t2.setText( nb2);
     
		
		t001.setText(""+LocalDate.now());
		
		bt3=new JButton("Enregistrer");
		bt3.setBounds(325, 90, 100, 25);
		 
		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					
	      			Class.forName("com.mysql.cj.jdbc.Driver");
					Connection db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
					Statement st=db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					try {
						 rs11 = st.executeQuery("select idBE from bone");
						rs11.last();
						 idE = (int) rs11.getLong(1);

						idEE=Integer.toString(idE+1);
						
						  rs12 = st.executeQuery("select idBS from bons");
							rs12.last();


							 idS = (int) rs12.getLong(1);

							  ides=Integer.toString(idS+1);

							  
							if(l01.getText()=="Liste de Bons entres")
							{
								
								for(int m=0;m<=4;m++)
								{
									if(tab.getValueAt(m, 0)!=null && tab.getValueAt(m, 1)!=null && tab.getValueAt(m, 2)!=null)
							            st.executeUpdate("insert into bone (idBE,dateE,nomF,qte,typeE,calibre) values ('"+idEE+"','"+t001.getText()+"','"+jc2.getSelectedItem()+"','"+tab.getValueAt(m, 2)+"','"+tab.getValueAt(m, 0)+"','"+tab.getValueAt(m, 1)+"')");
								}
							}
				            else
				            {
				            	
								for(int m=0;m<=4;m++)
								{
									if(tab.getValueAt(m, 0)!=null && tab.getValueAt(m, 1)!=null && tab.getValueAt(m, 2)!=null)
							            st.executeUpdate("insert into bons (dateS,nomS,qte,typeS,calibre,idBS) values ('"+t001.getText()+"','"+jc2.getSelectedItem()+"','"+tab.getValueAt(m, 2)+"','"+tab.getValueAt(m, 0)+"','"+tab.getValueAt(m, 1)+"','"+ides+"')");
								}
				            
				            }
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
				
					f.setVisible(false);
					setVisible(false);
					db.close();
					
				
					
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
 
				
			}});
		bt4=new JButton("Fermer");
		bt4.setBounds(325, 130, 100, 25);
	    
		bt4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				
			}});
		 f.getContentPane().setBackground(new Color(164, 194, 244));				
		  tab.setBackground(Color.WHITE);
		     tab.setForeground(Color.BLACK);
		     tab.setFont(new Font(Font.SANS_SERIF,Font.BOLD,12));
		     JTableHeader header = tab.getTableHeader();
		        header.setBackground(new Color(217, 217, 217));
		        header.setForeground(Color.BLACK);
		        header.setFont(new Font(Font.SERIF,Font.BOLD,12));
		        bt3.setBackground(new Color(44,62,150));
		        bt3.setForeground(new Color(236,240,241));
		        bt4.setBackground(new Color(44,62,150));
		        bt4.setForeground(new Color(236,240,241));
				 p2.setBackground(new Color(164, 194, 244));				
				 l02.setFont(new Font(Font.SERIF,Font.BOLD,20));
				  l02.setBounds(150,0, 300, 100);
				  f.setLayout(null);
		f.add(t2);f.add(p2);
		f.add(t001);f.add(jc2);f.add(bt3);f.add(bt4);
		 f.add(l02);f.add(l001);f.add(l002);f.add(l2);
		f.setSize(500,500);
		
		f.setVisible(true);
	}
}
