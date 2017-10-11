import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*; 
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;
import java.lang.*;




class About extends JFrame
{
 JFrame jf;

	JLabel l1,l2,l3,l4,l5,l6,l7,l31,l32,l33;
	JButton b3;


	About()
	{
		jf=new JFrame();

		jf.setLayout(null);

		l1 = new JLabel("-----------Medical Stock Manangement System----------");
		l1.setFont(new Font("Times New Roman",Font.BOLD,30));
		l1.setBounds(330,30,600,40);l1.setForeground(Color.blue);
		jf.add(l1);


		l2 = new JLabel("This System is developed by,");
		l2.setFont(new Font("Times New Roman",Font.BOLD,20));
		l2.setBounds(480,150,600,40);
		jf.add(l2);

		l3 = new JLabel("Mr.Kaushal S.Dhabadge.");
		l3.setFont(new Font("Times New Roman",Font.BOLD,25));
		l3.setBounds(470,200,400,40);l3.setForeground(Color.MAGENTA );
		jf.add(l3);

		l31 = new JLabel("Mr.Vaibhav Kakade .");
		l31.setFont(new Font("Times New Roman",Font.BOLD,25));
		l31.setBounds(470,230,400,40);l31.setForeground(Color.red);
		jf.add(l31);

		l32 = new JLabel("Mr.Rushikesh Wagh.");
		l32.setFont(new Font("Times New Roman",Font.BOLD,25));
		l32.setBounds(470,260,400,40);l32.setForeground(Color.red);
		jf.add(l32);

		l33 = new JLabel("Mr.Harshad Godse.");
		l33.setFont(new Font("Times New Roman",Font.BOLD,25));
		l33.setBounds(470,290,400,40);l33.setForeground(Color.red);
		jf.add(l33);

		l4 = new JLabel(".....Under the guidance of Mr.Rahul Ubhale Sir. & My Group Members");
		l4.setFont(new Font("Times New Roman",Font.BOLD,25));l4.setForeground(Color.yellow);
		l4.setBounds(390,320,800,40);
		jf.add(l4);

		l5 = new JLabel("> In this system we can add details of Medicines and Suppliers.");
		l5.setFont(new Font("Times New Roman",Font.BOLD,20));
		l5.setBounds(380,350,800,40);
		jf.add(l5);

		l6 = new JLabel("> We can also upadte,delete & search the existing details.");
		l6.setFont(new Font("Times New Roman",Font.BOLD,20));
		l6.setBounds(380,380,800,40);
		jf.add(l6);

		l7 = new JLabel("> It is helpfull for stock of Medicine & whrere we placed the medicine in store.");
		l7.setFont(new Font("Times New Roman",Font.BOLD,20));
		l7.setBounds(380,410,800,40);
		jf.add(l7);

		b3 = new JButton("Home",new ImageIcon("images//open.png"));
	    	b3.setBounds(1200,30,110,35);
		b3.setToolTipText("click to go to Homepage");
	   	jf.add(b3); 
		b3.addActionListener(new b3ActionListener());

       		jf.setTitle("About System");
		jf.setSize(1370,760);
		jf.setLocation(0,0);
		jf.setResizable(true);
		jf.getContentPane().setBackground(Color.green);
		jf.setVisible(true);
	}

private class b3ActionListener implements ActionListener 
{
public void actionPerformed(ActionEvent ae)
{
      if(ae.getSource()==b3)
{
jf.setVisible(false);
//MainMenu m=new MainMenu();

}
}
}
//m.setVisible(false);
	public static void main(String args[])
	{
                new About();
}
}
