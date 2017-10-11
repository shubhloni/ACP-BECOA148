import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;
import java.lang.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.ResultSet;


public class SupplierList extends JFrame
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

 SupplierList()
  {

    jf.setLayout(null);
  	ln = new JLabel("List Of Supplier Details");
    ln.setFont(new Font("Times New Roman",Font.BOLD,25));
    ln.setForeground(Color.blue);
    ln.setBounds(450,30,350,25);
    jf.add(ln);


        b0 = new JButton("Home",new ImageIcon("images//open.png"));
	    b0.setBounds(1200,30,110,35);b0.setToolTipText("click to open supplier details");
	    jf.add(b0); b0.addActionListener(new b0ActionListener());


    scrlPane.setBounds(0,80,1330,600);
    jf.add(scrlPane);
    tabGrid.setFont(new Font ("Times New Roman",0,15));
    tabGrid.setBackground(Color.yellow);

   	model.addColumn("S_ID");
   	model.addColumn("S_NAME");
  	model.addColumn("S_Address");
  	model.addColumn("S_PhNo");
  	model.addColumn("S_EmailId");

  		int r = 0;
    jf.setTitle("Supplier List");
    jf.setSize(1370,760);

	 jf.setLocation(0,0);
	jf.setResizable(true);
    jf.getContentPane().setBackground(Color.red);
    jf.setVisible(true);

     try
     {

     	Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
		System.out.println("Connected to database.");
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        rs = stmt.executeQuery("select * from DDDD");
          while(rs.next())
            {
            	model.insertRow(r++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});

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
private class b0ActionListener implements ActionListener 
{
public void actionPerformed(ActionEvent ae)
{
      if(ae.getSource()==b0)
{
jf.setVisible(false);
//MainMenu m=new MainMenu();
}}}

  public static void main(String args[])
    {
    	new SupplierList();
    }
}
