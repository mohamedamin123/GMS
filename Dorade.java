package GestionStock;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.table.JTableHeader;
public class Dorade extends JFrame {
	
	protected int id_Dorade;
	protected Date date;
	protected String type;
	protected float quantite;
	
	
	
	
	
	
	 String []tab1;
	  String [][] tab2;
	 JTable tab;
	 JScrollPane js;
	 JLabel l1=new JLabel("Stock de Daurade");
	 JButton bt1=new JButton("Retour");
	 JButton bt2=new JButton("Imprimer");
	 LocalDate e=LocalDate.now();
	public Dorade()
	{

		 int nb1;
		 int nb11;
		 int nbc;
		 int i;
		 int nb2=15;
		
		new JFrame();
		String [][]tab2=null;
		String []  tab1=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection db=DriverManager.getConnection("jdbc:mysql://localhost/dbstock", "root", "");
			Statement st=db.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			 
	         

			
			ResultSet rs=st.executeQuery("select * from bone where typeE like 'D%' and dateE =DATE( NOW() )");
			
			rs.last();
			 nb1=rs.getRow();
			 nb1++;
			rs.beforeFirst();
			ResultSet rs1=st.executeQuery("select * from bons where typeS like 'D%' and dateS =DATE( NOW() )");
			rs1.last();
			nb11=rs1.getRow();
	        nb11=nb11+3;
	        nbc=nb1+nb11;
			 rs=st.executeQuery("select * from bone where typeE like 'D%' and dateE =DATE( NOW() )");

			tab2=new String[nbc][nb2];
			String id;
			String ref;
			String Designation;
			String DateE;
			String Client;
			String Qtes;
			String DateS;
			String Fournisseur;
			String QteE = null;
			 i=1;
			while(rs.next())
				
			{
				 id=rs.getString(1);
				 DateE=rs.getString(2);
				 Fournisseur=rs.getString(3);
				 QteE=rs.getString(4);
				 ref=rs.getString(5);
				 Designation=rs.getString(6);
				 
				
				 
				switch(ref){
				case "D5P":
					
					tab2[i][2]=QteE;
					tab2[i][0]=DateE;
				
					break;
				case "D4P":
					tab2[i][3]=QteE;
					tab2[i][0]=DateE;

					break;
				case "D3P":
					tab2[i][4]=QteE;
					tab2[i][0]=DateE;

					break;
				case "D2P":
					tab2[i][5]=QteE;
					tab2[i][0]=DateE;

					break;
				case "DP":
					tab2[i][6]=QteE;
					tab2[i][0]=DateE;

					break;
				case "DM":
					tab2[i][7]=QteE;
					tab2[i][0]=DateE;

					break;
				case "DG":
					tab2[i][8]=QteE;
					tab2[i][0]=DateE;

					break;
				case "D2G":
					tab2[i][9]=QteE;
					tab2[i][0]=DateE;

					break;
				case "D3G":
					tab2[i][10]=QteE;
					tab2[i][0]=DateE;

					break;
				case "D4G":
					tab2[i][11]=QteE;
					tab2[i][0]=DateE;

					break;
				case "D5G":
					tab2[i][12]=QteE;
					tab2[i][0]=DateE;

					break;
				case "D6G":
					tab2[i][13]=QteE;
					tab2[i][0]=DateE;

					break;
				case "DDF":
					tab2[i][14]=QteE;
					tab2[i][0]=DateE;

					break;
				}
				tab2[i][1]=Fournisseur;			
				i++;
			}
		
			int cc=i;
			int nbb1=nb1;
			tab2[i][1]="Total-Entrées";
			

		float s=0;
			for(int k=2;k<nb2;k++)
			{
				s=0; 
				for(int j=0;j<nbb1;j++)
				{
					 if(tab2[j][k]!=null)
						s=s+Float.parseFloat(tab2[j][k]);
					 
				}
				tab2[nbb1][k]=Float.toString(s);
			  int a=nbb1;
			}
			
			
			 rs1=st.executeQuery("select * from bons where typeS like 'D%' and dateS =DATE( NOW() )");
			 
			 i=cc+1;
				rs1.beforeFirst();
				while(rs1.next())
					
				{
					 id=rs1.getString(1);
					 DateS=rs1.getString(2);
					 Client=rs1.getString(3);
					 Qtes=rs1.getString(4);
					 ref=rs1.getString(5);
					 Designation=rs1.getString(6);
					 
					
					 
					switch(ref){
					case "D5P":
						
						tab2[i][2]=Qtes;
						tab2[i][0]=DateS;
					
						break;
					case "D4P":
						tab2[i][3]=Qtes;
						tab2[i][0]=DateS;

						break;
					case "D3P":
						tab2[i][4]=Qtes;
						tab2[i][0]=DateS;

						break;
					case "D2P":
						tab2[i][5]=Qtes;
						tab2[i][0]=DateS;

						break;
					case "DP":
						tab2[i][6]=Qtes;
						tab2[i][0]=DateS;

						break;
					case "DM":
						tab2[i][7]=Qtes;
						tab2[i][0]=DateS;

						break;
					case "DG":
						tab2[i][8]=Qtes;
						tab2[i][0]=DateS;

						break;
					case "D2G":
						tab2[i][9]=Qtes;
						tab2[i][0]=DateS;

						break;
					case "D3G":
						tab2[i][10]=Qtes;
						tab2[i][0]=DateS;

						break;
					case "D4G":
						tab2[i][11]=Qtes;
						tab2[i][0]=DateS;

						break;
					case "D5G":
						tab2[i][12]=Qtes;
						tab2[i][0]=DateS;

						break;
					case "D6G":
						tab2[i][13]=Qtes;
						tab2[i][0]=DateS;

						break;
					case "DDF":
						tab2[i][14]=Qtes;
						tab2[i][0]=DateS;

						break;
					}
					tab2[i][1]=Client;			
					i++;
				}
				
				int b=nbc-2;
				
				tab2[i][1]="Total-Sorties";
				

			
				for(int k=2;k<nb2;k++)
				{
					s=0; 
					for(int j=cc+1;j<nbc;j++)
					{
						 if(tab2[j][k]!=null)
							s=s+Float.parseFloat(tab2[j][k]);
						 
					}
					tab2[nbc-2][k]=Float.toString(s);
					 
				}
				int y=i+1;
				tab2[y][1]="Total";
			
				for(int k=2;k<nb2;k++)
				{
					s=0;
			        s=Float.parseFloat(tab2[nbb1][k])-Float.parseFloat(tab2[b][k])+Float.parseFloat(tab2[b][k]);
				    
			        tab2[y][k]=Float.toString(s);
				}
				 tab2[y][0]=e.toString();
				ResultSet rs2=st.executeQuery("select date,type from ems where type='D'");
				
				String dd="";
				String ddd="";
				rs2.last();
				
				dd=rs2.getString(1);
				ddd=rs2.getString(2);
			
				  if(e.toString().equals(dd.toString())&& ddd.equals("D"))
		             {
	                	st.executeUpdate("update ems set 5P='"+tab2[y][2]+"',4P='"+tab2[y][3]+"',3P='"+tab2[y][4]+"',2P='"+tab2[y][5]+"',P='"+tab2[y][6]+"',M='"+tab2[y][7]+"',G='"+tab2[y][8]+"',2G='"+tab2[y][9]+"',3G='"+tab2[y][10]+"',4G='"+tab2[y][11]+"',5G='"+tab2[y][12]+"',6G='"+tab2[y][13]+"',DF='"+tab2[y][14]+"' where date='"+rs2.getString(1)+"' and type='D' ");
		             }
		             else
		             {
		            	
							st.executeUpdate("insert into ems (date,type,5P,4P,3P,2P,P,M,G,2G,3G,4G,5G,6G,DF) values ('"+e+"','D','"+tab2[y][2]+"','"+tab2[y][3]+"','"+tab2[y][4]+"','"+tab2[y][5]+"','"+tab2[y][6]+"','"+tab2[y][7]+"','"+tab2[y][8]+"','"+tab2[y][9]+"','"+tab2[y][10]+"','"+tab2[y][11]+"','"+tab2[y][12]+"','"+tab2[y][13]+"','"+tab2[y][14]+"')");

		             }
				  ResultSet rs3=st.executeQuery("SELECT  DATEDIFF ( DATE( NOW() ), date ) FROM ems where type='D' and date !='"+e+"'");
				  rs3.last();
				  String a=rs3.getString(1);
				 int bb=Integer.parseInt(a);
				 System.out.println(e);
				 System.out.println(bb);
	                System.out.println(e.minusDays(bb));
				  rs2=st.executeQuery("select * from ems where date='"+e.minusDays(bb)+"' and type='D'");
				  rs2.last();
				  rs2.beforeFirst();
				  String idEMS;
				  String Date;
				  String type;
				  String P5="";
				  String P4="";
				  String P3="";
				  String P2="";
				  String P="";
				  String M="";
				  String G="";
				  String G2="";
				  String G3="";
				  String G4="";
				  String G5="";
				  String G6="";
				  String DF="";
				  while(rs2.next())
				  {
					    idEMS=rs2.getString(1);
					    Date=rs2.getString(2);
					    type=rs2.getString(3);
					    P5=rs2.getString(4);
					    P4=rs2.getString(5);
					    P3=rs2.getString(6);
					    P2=rs2.getString(7);
					    P=rs2.getString(8);
					    M=rs2.getString(9);
					    G=rs2.getString(10);
					    G2=rs2.getString(11);
					    G3=rs2.getString(12);
					    G4=rs2.getString(13);
					    G5=rs2.getString(14);
					    G6=rs2.getString(15);
					    DF=rs2.getString(16);
			       
				  }
				  tab2[0][0]=e.minusDays(1).toString();
				  tab2[0][1]="Reste";
				  tab2[0][2]=P5;
				  tab2[0][3]=P4;
				  tab2[0][4]=P3;
				  tab2[0][5]=P2;
				  tab2[0][6]=P;
				  tab2[0][7]=M;
				  tab2[0][8]=G;
				  tab2[0][9]=G2;
				  tab2[0][10]=G3;
				  tab2[0][11]=G4;
				  tab2[0][12]=G5;
				  tab2[0][13]=G6;
				  tab2[0][14]=DF;
				  for(int k=2;k<nb2;k++)
					{ if(tab2[0][k]=="")
						tab2[0][k]="0";
						s=0;
						
				       s=Float.parseFloat(tab2[nbb1][k])-Float.parseFloat(tab2[b][k])+Float.parseFloat(tab2[0][k]);
				       
				        tab2[y][k]=Float.toString(s);
				      
					}

	          	st.executeUpdate("update ems set 5P='"+tab2[y][2]+"',4P='"+tab2[y][3]+"',3P='"+tab2[y][4]+"',2P='"+tab2[y][5]+"',P='"+tab2[y][6]+"',M='"+tab2[y][7]+"',G='"+tab2[y][8]+"',2G='"+tab2[y][9]+"',3G='"+tab2[y][10]+"',4G='"+tab2[y][11]+"',5G='"+tab2[y][12]+"',6G='"+tab2[y][13]+"',DF='"+tab2[y][14]+"' where date='"+e.toString()+"'and type='D' ");

			db.close();
			

			tab1=new String []{"Date","Nom","5P","4P","3P","2P","P","M","G","2G","3G","4G","5G","6G","DF"};
			
		
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 tab=new JTable(tab2,tab1);
		
	    js=new JScrollPane(tab);
	    JPanel p=new JPanel();
		   
	    p.setBounds(40, 130, 1000, 1000);
	    GridLayout g =new GridLayout(2,3,10,10);
	    FlowLayout fl=new FlowLayout(FlowLayout.CENTER);
	    p.setLayout(fl);
	    p.setLayout(g);
	  
	     p.add(js);
	     add(p);

	     l1.setFont(new Font(Font.SERIF,Font.BOLD,27));
		    l1.setBounds(450,0, 300, 100);
	     bt1.setBounds(300, 75, 100, 25);
	     bt2.setBounds(700, 75, 100, 25);
	     bt1.setBackground(new Color(44,62,150));
	     JTableHeader header = tab.getTableHeader();
	     getContentPane().setBackground(new Color(164, 194, 244));
	     tab.setBackground(Color.WHITE);
	     tab.setForeground(Color.BLACK);
	     tab.setFont(new Font(Font.SANS_SERIF,Font.BOLD,12));
	        p.setBackground(new Color(164, 194, 244));
	        bt1.setForeground(new Color(236,240,241));
	        bt2.setBackground(new Color(44,62,150));
	        bt2.setForeground(new Color(236,240,241));
	        header.setBackground(new Color(217, 217, 217));
	        header.setForeground(Color.BLACK);
	        header.setFont(new Font(Font.SANS_SERIF,Font.BOLD,12));
	        l1.setForeground(Color.BLACK);
	     bt1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new EMS();
				}});
	     bt2.addActionListener( new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					imprimer();
					}});
	     JMenuBar MenuBar=new JMenuBar();
		    JMenu m1 =new JMenu("File");
		    JMenu m2 =new JMenu("Accueil");
		    JMenuItem m22=new JMenuItem("Test");
		    MenuBar.add(m2);
		    m2.add(m22);
		    JMenuItem mi1=new JMenuItem("Article");
			JMenuItem mi2=new JMenuItem("Bon Entrées");
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
		    mi2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new BonE();
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
		   
		    mi31.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new Loup();
					setVisible(false);
					
				}});
		    m22.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new accueil();
				}});
	     add(l1);add(bt1);add(bt2);
	     setLayout(null);
	   
	     
		setTitle("EMS");
		setSize(1100,700);
		setVisible(true);
	}
	public void imprimer()
	{
		MessageFormat header =new MessageFormat("Liste des Loup");
		MessageFormat footer=new MessageFormat("Page{0,number,integer}");
		try {
			tab.print(JTable.PrintMode.FIT_WIDTH,header, footer);
		} catch (PrinterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Dorade();

	}

}
