import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;
import java.lang.*;

public class MedicineList extends JFrame
 {
    JFrame jf=new JFrame();
    JLabel ln;
JButton b0;
    Connection con;
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);

  public MedicineList()
  {
    jf.setLayout(null);
    ln = new JLabel("Stock Of Medicines");
    ln.setFont(new Font("Times New Roman",Font.BOLD,25));
    ln.setForeground(Color.red);
    ln.setBounds(500,30,300,25);
    jf.add(ln);

	    b0 = new JButton("Home",new ImageIcon("images//open.png"));
	    b0.setBounds(1200,30,110,35);
	    b0.setToolTipText("click to go to homepage");
	    jf.add(b0); b0.addActionListener(new b0ActionListener());

    scrlPane.setBounds(0,80,1360,600);
    jf.add(scrlPane);
    tabGrid.setFont(new Font ("Times New Roman",0,15));
    //tabGrid.setBackGround(Color.red);
    tabGrid.setBackground(Color.yellow);


    	model.addColumn("Batchno");
	model.addColumn("Name");
	model.addColumn("Company");
	model.addColumn("Quantity");
  	model.addColumn("Type");
	model.addColumn("Purcahasedate");
	model.addColumn("Expirydate");
	model.addColumn("Purchaseprice");
  	model.addColumn("Saleprice");
	model.addColumn("Rackno");
	model.addColumn("Supplierid");
	model.addColumn("suppliername");
  		int r = 0;
     try
     {

     		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        		rs = stmt.executeQuery("select * from MyDatabase");
          while(rs.next())
            {
            	model.insertRow(r++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)});

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


    jf.setTitle("Medicine List");
    jf.setSize(1370,760);
    jf.setLocation(0,0);
    jf.setResizable(true);
    jf.getContentPane().setBackground(Color.gray);
    jf.setVisible(true);
  }

private class b0ActionListener implements ActionListener {
public void actionPerformed(ActionEvent ae)
	{
      if(ae.getSource()==b0)
{
jf.setVisible(false);
//MainMenu m=new MainMenu();
}
}
}

  public static void main(String args[])
    {
    	new MedicineList();
    }
}
