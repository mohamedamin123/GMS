package GestionStock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class BonE extends Bon{	
	protected int idBE;
	public BonE()
	{

		super();

		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
				 st=db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			 
				 rs=st.executeQuery("select * from bone order by refBE");
				 
				rs.last();
				 nb14=rs.getRow();
				 if(nb14>0)
				 {
					 rs.beforeFirst();
					 tab2=new String[nb14][7];
					 System.out.println(nb14);
					 int i=0;
					 while(rs.next())

					 {   String idBE=rs.getString(7);
						 String dateE=rs.getString(2);
						 String refBE=rs.getString(1);
						 String nomF=rs.getString(3);
						 String qte=rs.getString(5);
						 String typeE=rs.getString(4);
						 String calibre=rs.getString(6);
						 tab2[i][0]=idBE ;
						 tab2[i][1]=refBE ;
						 tab2[i][2]=dateE;
						 tab2[i][3]=nomF;
						 tab2[i][4]=qte;
						 tab2[i][5]=calibre;
						 tab2[i][6]=typeE;
						 i++;
					 }
					 db.close();
				 }

				tab1=new String []{"Nbon","Id","Date","Fournisseur","Ref","Designation","Qte"};
			     
			
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		 p =new JPanel();
       
	     tab=new JTable(tab2,tab1);
	     
	     js=new JScrollPane(tab);
	   
			
       
	     p.add(js);
	     p.setBounds(0, 150, 500, 500);
		  add(p);
		setTitle("Liste de Bons Entres");
		super.l01.setText("Liste de Bons entres");
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
				 
				 st=db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				 rs=st.executeQuery("select nom from fournisseur");
				
				 
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
		 tab.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					f=new JFrame("Ajouer/Modification");

					bt4=new JButton("Fermer");
					bt3=new JButton("Enregistrer");
					l001=new JLabel("Date");
					t001=new JTextField();
					l002=new JLabel("Nom");
					 l02=new JLabel("Ajouter/Modification");
					JTable tab66=new JTable(tab6,tab4);
				     TableColumn col = tab66.getColumnModel().getColumn(0);
				      cb = new JComboBox();
						 p2 =new JPanel();
						 jc2 = new JComboBox(tab3);
				     js=new JScrollPane(tab66);
					l2=new JLabel("Num Bon");
					t2=new JTextField();
				    bt5.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							supprimer();
						}});

					bt2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							
							
								l02.setBounds(180, 5, 125, 125);
								

							    
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
												
												
											    int a=tab66.getSelectedRow();
												
					                          		if(a!=-1)
					                          		{
					                          			String aa=rs.getString(1);
					                          			tab66.setValueAt(aa, a, 1);
					                          		}
					                          		
												}
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											
											
										}});
					                 
					                 
									l001.setBounds(35,90,120,20);
									t001.setEditable(false);
									t001.setBounds(100, 90, 120,20);
									l002.setBounds(35,120, 120, 20);
									l2.setBounds(35, 150, 120,20);
									t2.setBounds(100, 150, 120,20);
									t2.setEditable(false);
									jc2.setBounds(100, 120, 120,20);
							     
									try {
										Class.forName("com.mysql.cj.jdbc.Driver");
										db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
										 st=db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);	 
										 rs=st.executeQuery("select idBE from bone");
										
										 rs.last();
										 nb1=(int) rs.getLong(1);
									} catch (ClassNotFoundException | SQLException e2) {
										// TODO Auto-generated catch block
										e2.printStackTrace();
									}
									 
									String nb2=Integer.toString(nb1+1);
									
									t2.setText( nb2);

									t001.setText(""+LocalDate.now());
									
									bt3.setBounds(325, 90, 100, 25);
									   ik = tab.getSelectedRow();
									  t001.setText((String)tab.getValueAt(ik, 2));
									  t2.setText((String)tab.getValueAt(ik, 0));
									  jc2.setSelectedItem(tab.getValueAt(ik, 3));
									
									   
									   int km=0;
									   int lm=0;
									 
									  for(lm=0;lm<nb14;lm++)
									  {   System.out.println(tab.getValueAt(ik, 0));
										 
										  if(tab.getValueAt(lm, 0).equals(tab.getValueAt(ik, 0)))
										  {
											   tab66.setValueAt(tab.getValueAt(lm, 4),km,0);
											   
										       tab66.setValueAt(tab.getValueAt(lm, 5),km,1);
										       
										       tab66.setValueAt(tab.getValueAt(lm, 6),km,2);
												km++;	
										        
									  }
										  
										  }
									  
									   
									
									  
									bt3.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											try {
												
												
								      			Class.forName("com.mysql.cj.jdbc.Driver");
												Connection db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
												Statement st=db.createStatement();
												System.out.println(tab66.getValueAt(0, 0));
												System.out.println(tab66.getValueAt(0, 1));
												System.out.println(tab66.getValueAt(0, 2));
												int ll=ik;
												for(int m=0;m<=4;m++)
												{
													if(tab66.getValueAt(m, 0)!=null && tab66.getValueAt(m, 1)!=null && tab66.getValueAt(m, 2)!=null)
	
									            st.executeUpdate("update bone set dateE='"+t001.getText()+"',nomF='"+jc2.getSelectedItem()+"',typeE='"+tab66.getValueAt(m, 0)+"',calibre='"+tab66.getValueAt(m, 1)+"',qte='"+tab66.getValueAt(m, 2)+"' where idBE='"+t2.getText()+"'and refBE='"+tab.getValueAt(ll,1)+"'");
												ll++;
												}
												db.close();
												
												f.setVisible(false);
												setVisible(false);
												
												
											} catch (ClassNotFoundException | SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
									
							    
											
										}});
									modifier();
									f.getContentPane().setBackground(new Color(164, 194, 244));				
									  tab66.setBackground(Color.WHITE);
									     tab66.setForeground(Color.BLACK);
									     tab66.setFont(new Font(Font.SERIF,Font.BOLD,12));
									     JTableHeader header = tab66.getTableHeader();
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
									f.add(t2);f.add(p2);
									f.add(t001);f.add(jc2);f.add(bt3);f.add(bt4);
									 f.add(l02);f.add(l001);f.add(l002);f.add(l2);							     f.setLayout(null);
									 f.setSize(550,700);
									f.setVisible(true);
									
						}});
				  
				}});
			
              
		        tab.setSize(500,500);
		       
		        System.out.println(tab.getSize());
			   
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
		    mi33.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new EMS();
				}});
		    mi1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new Article();
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
		    m22.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new accueil();
				}});
	}
	public void modifier()
	{
		bt4.setBounds(325, 130, 100, 25);
	    
		bt4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				
			}});
	}
	public void supprimer()
	{
		 int i = tab.getSelectedRow();
		 
         try {
				
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
				Statement st=db.createStatement();
				
				st.executeUpdate("delete from  bone where refBE='"+tab.getValueAt(i, 1)+"'");
				
					
				f.setVisible(false);
				setVisible(false);
				
				
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
           
			
	}
	
	public static void main(String[] args) {
		new BonE();

	}

}
