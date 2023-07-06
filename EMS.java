package GestionStock;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class EMS extends JFrame {
	JLabel l1;
	JButton bt1,bt2,bt3;
public EMS()
{
	 l1=new JLabel("choisir type de Poisson");
	 l1.setFont(new Font(Font.SERIF,Font.BOLD,27));
	 l1.setBounds(190, 75, 320, 30);
	 bt1=new JButton("Maigre");
	 bt1.setBounds(75, 150, 120, 30);
	 bt2=new JButton("Loup");
	 bt2.setBounds(250, 150, 120, 30);
	 bt3=new JButton("Dorade");
	 bt3.setBounds(425, 150, 120, 30);
	   getContentPane().setBackground(new Color(164, 194, 244));
	    l1.setForeground(Color.BLACK);
	    bt1.setBackground(new Color(44,62,150));
	    bt1.setForeground(new Color(236,240,241));
	    bt2.setBackground(new Color(44,62,150));
	    bt2.setForeground(new Color(236,240,241));
	    bt3.setBackground(new Color(44,62,150));
	    bt3.setForeground(new Color(236,240,241));
	 bt1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Afficher_Maigre();
			setVisible(false);
		}});
	 
	 bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Afficher_Loup();
				setVisible(false);
			}});
	 bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Afficher_Dorade();
				setVisible(false);
			}});
	 
	add(bt1);add(bt2);add(bt3);add(l1);
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
			Afficher_Maigre();
		}});
    mi21.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			Afficher_Dorade();
		}});
    mi31.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			Afficher_Loup();
		}});
	

	setLayout(null);
	setSize(650,550);
	setVisible(true);
	
}
public Loup Afficher_Loup()
{
	return new Loup();
}
public Maigre Afficher_Maigre()
{
	return new Maigre();
}
public Dorade Afficher_Dorade()
{
	return new Dorade();
}
public static void main(String[] args) {
	new EMS();
	
	}

}
