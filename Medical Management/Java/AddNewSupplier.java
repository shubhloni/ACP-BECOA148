import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;
import java.lang.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;

public class AddNewSupplier extends JFrame implements ActionListener
{
	JFrame jf;
	JTextField t1,t2,t3,t4,t5,tr,tq;
	JLabel l1,l2,l3,l4,l5,l6;
	JButton b0,b1,b2,b3;
	Font f;
    Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

	AddNewSupplier()
	{
		jf=new JFrame();
		f = new Font("Times New Roman",Font.BOLD,20);
		jf.setLayout(null);

	    l6=new JLabel("====New Supplier Details====");
	    l6.setFont(new Font("Times New Roman",Font.BOLD,30));
	    l6.setBounds(450,30,900,100);l6.setForeground(Color.blue);
	    jf.add(l6);

		l1= new JLabel("Supplier id ");
		l1.setFont(f);l1.setBounds(420,120,130,25);
		jf.add(l1);

		t1=new JTextField(20);t1.setEditable(true);
		t1.setBounds(620,120,200,25);
		jf.add(t1);

		l2 = new JLabel("Supplier name*");
		l2.setFont(f);
       		 l2.setBounds(420,160,170,25);
		jf.add(l2);

		t2=new JTextField(20);
		t2.setBounds(620,160,200,25);t2.setToolTipText("Enter supplier name");
		jf.add(t2);

		l3 = new JLabel("Supplier address*");
		l3.setFont(f);
        		l3.setBounds(420,200,210,25);
		jf.add(l3);

		t3=new JTextField(20);
		t3.setBounds(620,200,200,25);t3.setToolTipText("Enter supplier address");
		jf.add(t3);

		l4 = new JLabel("Supplier phone no*");
		l4.setFont(f);
        		l4.setBounds(420,240,250,25);
		jf.add(l4);

		t4=new JTextField(20);
		t4.setBounds(620,240,200,25);t4.setToolTipText("Enter supplier phone no");
		jf.add(t4);

		l5 = new JLabel("Supplier email id*");
		l5.setFont(f);
        		l5.setBounds(420,290,290,25);
		jf.add(l5);

		t5=new JTextField(20);
		t5.setBounds(620,280,200,25);t5.setToolTipText("Enter supplier email id");
		jf.add(t5);

	  	b0 = new JButton("Save",new ImageIcon("images//save.png"));
        		b0.setBounds(370,330,110,35);
		b0.setToolTipText("click to save supplier details");
		jf.add(b0);
		b0.addActionListener(this);

		b1 = new JButton("Clear",new ImageIcon("images//clear.png"));
		b1.setBounds(520,330,110,35);
		b1.setToolTipText("click to clear all textfilds");
	    	jf.add(b1); 
		b1.addActionListener(this);

      		b2= new JButton("All",new ImageIcon("images//all.png"));
		b2.setBounds(670,330,110,35);
		b2.setToolTipText("click to view all supplier details");
		jf.add(b2);
		b2.addActionListener(this);


		b3= new JButton("Back",new ImageIcon("images//all.png"));
		b3.setBounds(850,330,110,35);
		b3.setToolTipText("click to go Homepage");
		jf.add(b3); 
		b3.addActionListener(this);



	    scrlPane.setBounds(0,380,1330,600);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));
         tabGrid.setBackground(Color.green);

        model.addColumn("S_ID");
        model.addColumn("S_NAME");
        model.addColumn("S_ADDRESS");
        model.addColumn("S_PHONENO");
        model.addColumn("S_EMAILID");

	     jf.setTitle("Add New Supplier");
	     jf.setSize(1370,760);
		 jf.setLocation(0,0);
		 jf.setResizable(true);
		 jf.getContentPane().setBackground(Color.yellow);
	     jf.setVisible(true);
	}

public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==b0)
	 {
	 	String mob = t4.getText();
if ((t4.getText().length() <9) && (t4.getText().length() >10)) 
{
       jf.setVisible(true);
       JOptionPane.showMessageDialog(getRootPane(), "Mobile number should be 11 numbers long", "Mobile Error", JOptionPane.ERROR_MESSAGE);
       t4.requestFocus();
        
   }
   else if (t4.getText().length() == 10) {
       jf.setVisible(true);
   }


		//Pattern q=Pattern.compile("[0-9]";
		//Matcher n=q.matcher(mob);
		//boolean matchFound=n.matches();

	       	String email=t5.getText();
	       	Pattern p=Pattern.compile("[_a-z_A-Z_0-9]+[0-9]*@[a-zA-Z0-9]+.[a-zA-Z0-9]+");
	       	Matcher m=p.matcher(email);
	        boolean matchFound=m.matches();

	    	if(((t2.getText()).equals(""))||((t3.getText()).equals(""))||((t4.getText()).equals(""))||((t5.getText()).equals("")))
	        {
		    JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
	        }
	        else if(!matchFound)
	        {
	       	  JOptionPane.showMessageDialog(this,"Invalid email id!","Warning!!!",JOptionPane.WARNING_MESSAGE);
	       	}
			else
			{
			  try
			  	 {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
			System.out.println("Connected to database.");
            ps=con.prepareStatement("insert into DDDD (sid,sname,saddress,sphoneno,semailid)values(?,?,?,?,?)");
            		   ps.setString(1,t1.getText());
		    ps.setString(2,t2.getText());
		    ps.setString(3,t3.getText());
		  ps.setString(4,t4.getText());
		  ps.setString(5,t5.getText());
		  	ps.executeUpdate();

  int reply=JOptionPane.showConfirmDialog(null,"Supplier added successfully.Do you want add more supplier?","Added Supplier",JOptionPane.YES_NO_OPTION);

	             if (reply == JOptionPane.YES_OPTION)
	   			{
	   		       jf.setVisible(false);
	   		       new AddNewSupplier();
	   		    }
	   		  else if (reply == JOptionPane.NO_OPTION)
	   			{
	   			  jf.setVisible(false);
		        }con.close();
	          }
   catch(SQLException se)
   {
     System.out.println(se);
     JOptionPane.showMessageDialog(null,"SQL Error:"+se);
   }
  catch(Exception e)
  {
    System.out.println(e);
    JOptionPane.showMessageDialog(null,"Error:"+e);
  }
 }
}
  else if(ae.getSource()==b1)
     {//clear
          t1.setText("");
          t2.setText("");
          t3.setText("");
          t4.setText("");
          t5.setText("");
      }
    else if(ae.getSource()==b2)
    {//list
  	int r = 0;
     try
     {
         Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("select * from DDDD");

          while(rs.next())
            {
            	model.insertRow(0, new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5) });
            }
             con.close();
       }
      catch(SQLException se)
       {
        System.out.println(se);
        JOptionPane.showMessageDialog(null,"SQL Error:"+se);
       }
      catch(Exception e)
       {
       	   System.out.println(e);
          JOptionPane.showMessageDialog(null,"Error:"+e);
       }
	}

else if(ae.getSource()==b3)
{
jf.setVisible(false);
//MainMenu m=new MainMenu();
//m.setVisible(false);
}

 }
public static void main(String args[])
	{
	      new AddNewSupplier();
	}
}

