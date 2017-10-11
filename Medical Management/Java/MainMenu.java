import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;
import java.lang.*;

public class MainMenu extends JFrame implements ActionListener
{ 
 	 JFrame jf;
	JMenuBar mbar;
	JMenu m1,m2,m3,m5,m6;
	JMenuItem m1_1,m1_2,m1_3,m1_4,m1_5,m2_1,m2_2,m2_3,m2_4,m2_5,m3_1,m3_2,m5_1,m6_1;
	JLabel l1,LogoColl;
	GridBagLayout gbl;

	public MainMenu()
	{
        		jf=new JFrame();
		jf.setLayout(null);

		l1=new JLabel("***WELCOME TO MEDICAL STOCK MANAGEMENT SYSTEM***");
		l1.setFont(new Font("Times New Roman",Font.BOLD,40));
		l1.setBounds(0,30,1300,40);l1.setForeground(Color.cyan);
		jf.add(l1);

		mbar = new JMenuBar();
		jf.setJMenuBar(mbar);

		m1=new JMenu("Supplier");
		mbar.add(m1);
		m1_1 = new JMenuItem("Add New Supplier",new ImageIcon("images//addnew.png"));
		m1.add(m1_1);
		m1_2 = new JMenuItem("search Supplier",new ImageIcon("images//search.png"));
		m1.add(m1_2);
		m1_3 = new JMenuItem("Update Supplier",new ImageIcon("images//update.png"));
		m1.add(m1_3);
		m1_4 = new JMenuItem("Delete Supplier",new ImageIcon("images//delete.png"));
		m1.add(m1_4);
		m1_5 = new JMenuItem("List of Supplier",new ImageIcon("images//all.png"));
		m1.add(m1_5);

		m2=new JMenu("Medicine");
		mbar.add(m2);
		m2_1 = new JMenuItem("Add New Medicine",new ImageIcon("images//addnew.png"));
		m2.add(m2_1);
		m2_2 = new JMenuItem("search Medicine",new ImageIcon("images//search.png"));
		m2.add(m2_2);
		m2_3 = new JMenuItem("Update Medicine",new ImageIcon("images//update.png"));
		m2.add(m2_3);
		m2_4 = new JMenuItem("Delete Medicine",new ImageIcon("images//delete.png"));
		m2.add(m2_4);
		m2_5 = new JMenuItem("Stock of Medicine",new ImageIcon("images//all.png"));
		m2.add(m2_5);


		m3=new JMenu("Report");
		mbar.add(m3);
		m3_1 = new JMenuItem("Daily Purchase Report",new ImageIcon("images//report.png"));
		m3.add(m3_1);
		m3_2 = new JMenuItem("Suplier wise medicine Report",new ImageIcon("images//report.png"));
		m3.add(m3_2);

		/*m4=new JMenu("Print");
		mbar.add(m4);
		m4_1 = new JMenuItem("Print Supplier Details",new ImageIcon("images//help.png"));
		m4.add(m4_1);
		m4_1 = new JMenuItem("Print Medicine Details",new ImageIcon("images//help.png"));
		m4.add(m4_2);*/

		m5=new JMenu("About");
		mbar.add(m5);
		m5_1 = new JMenuItem("About System",new ImageIcon("images//help.png"));
		m5.add(m5_1);
	
		m6=new JMenu("Exit");
		mbar.add(m6);
		m6_1 = new JMenuItem("Exit",new ImageIcon("images//exit.png"));
		m6.add(m6_1);


		m1_1.addActionListener(this); //supplier
		m1_2.addActionListener(this);
		m1_3.addActionListener(this);
		m1_4.addActionListener(this);
	    	m1_5.addActionListener(this);

		m2_1.addActionListener(this);//medicine
		m2_2.addActionListener(this);
		m2_3.addActionListener(this);
		m2_4.addActionListener(this);
		m2_5.addActionListener(this);

		m3_1.addActionListener(this);//daily
		m3_2.addActionListener(this);

		//m4_1.addActionListener(this);//print
		//m4_2.addActionListener(this);

		m5_1.addActionListener(this);//about
	
		m6_1.addActionListener(this);//exit

		jf.setTitle("Main Menu");
		jf.setLocation(0,0);
		jf.setSize(1370,760);
		jf.setResizable(true);
		jf.getContentPane().setBackground(Color.MAGENTA);
		jf.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae)
	{

		  if(ae.getSource()==m1_1)
		{
		  new AddNewSupplier();
		}
		else if(ae.getSource()==m1_2)
		{
		 new SearchSupplier();
		}
		else if(ae.getSource()==m1_3)
		{
		new UpdateSupplier();
		}
		else if(ae.getSource()==m1_4)
		{
		new DeleteSupplier();
		}
		  else if(ae.getSource()==m1_5)
		{
		  new SupplierList();
		}


		else if(ae.getSource()==m2_1)
		{
			new AddNewMedicine();
		}
		else if(ae.getSource()==m2_2)
		{
			new SearchMedicine();
		}
		else if(ae.getSource()==m2_3)
		{
			new UpdateMedicine();
		}
		else if(ae.getSource()==m2_4)
		{
			new DeleteMedicine();
		}
		else if(ae.getSource()==m2_5)
		{
			new MedicineList();
		}

		 else if(ae.getSource()==m3_1)
		 {
		   new DailyPurchaseReport();
		 }

		  else if(ae.getSource()==m3_2)
		 {
		   new SupplierWiseMedList();
		 }

		/*else if(ae.getSource()==m4_1)
		{
		        new printer();
		}
		else if(ae.getSource()==m4_2)
		{
		        new printer();
		}
		*/

		else if(ae.getSource()==m5_1)
			{
			new About();
			}

			
		else if(ae.getSource()==m6_1)
		{
			  System.exit(0);
		}

  }

	public static void main(String args[])
	{
	
		new MainMenu();
	}
}
