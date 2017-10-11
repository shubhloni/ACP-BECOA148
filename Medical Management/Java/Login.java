import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class InvalidException extends Exception
{
}

class Login extends JFrame implements ActionListener
{
	JFrame jf;
	JButton b1,b2,b3;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2;
	JPasswordField p1;
	Font f;
	int cnt=0,cnt1=0;

	Login()
	{
       	 jf=new JFrame();
        	 f = new Font("Times New Roman",Font.BOLD,20);
	 jf.setLayout(null);

        	l5 = new JLabel("***** WELCOME ADMINISTRATOR*****");
	l5.setFont(new Font("Times New Roman",Font.BOLD,30));
        	l5.setBounds(350,20,600,300);
	//l5.setBackgroundImage("your.jpg");
	jf.add(l5);


		l1 = new JLabel("User Name : "); 
		l1.setFont(f);
		l1.setBounds(430,250,200,25);
		jf.add(l1);

		l2 = new JLabel("Password    : ");
		l2.setFont(f);
		l2.setBounds(430,300,200,25);
		jf.add(l2);


		l3 = new JLabel(new ImageIcon("images//users.png"));
		l3.setBounds(380,250,50,25);
		jf.add(l3);

		l4 = new JLabel(new ImageIcon("images//pass.png"));
		l4.setBounds(380,300,50,25);
		jf.add(l4);

		t1 = new JTextField(20);
		t1.setBounds(570,250,200,30);
		t1.setToolTipText("Enter Username");
		jf.add(t1);

		p1 = new JPasswordField(20);
		p1.setBounds(570,300,200,30);
		p1.setToolTipText("Enter Password");
		jf.add(p1);

		b1 = new JButton("Login",new ImageIcon("images//Login.png"));//Login Button
		b1.setBounds(440,350,100,35);
		jf.add(b1);
		b1.addActionListener(this);

		b2 = new JButton("Clear",new ImageIcon("images//clear.png"));//Clear Button
		b2.setBounds(560,350,100,35);
		jf.add(b2);
		b2.addActionListener(this);

		b3 = new JButton("Exit",new ImageIcon("images//exit.png"));//Exit Button
		b3.setBounds(680,350,100,35);
		jf.add(b3);b3.addActionListener(this);

		jf.setTitle("Login");//Frame
		jf.setLocation(0,0);
		jf.setSize(1370,760);
		jf.setResizable(true);
		jf.getContentPane().setBackground(Color.pink);
		jf.setVisible(true);
	}

public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b1)
	{
		try
		{
			String s=t1.getText();
			String s1=new String(p1.getPassword());
			if((s.compareTo("kaushal")==0)&&(s1.compareTo("kaushal")==0))
			{
			   JOptionPane.showMessageDialog(null," Welcome!!!Now You are in Medical...!!! ");// ","WELCOME",JOptionPane.INFORMATION_MESSAGE);
		                      jf.setVisible(false);
                       		   new MainMenu();
			}
			else
			{
				throw new InvalidException();
			}
		}
		catch(Exception e1)
		{
		    cnt++;
		    JOptionPane.showMessageDialog(null," Sorry ??? You are not valid user ...!!!");//,"WARNING",JOptionPane.ERROR_MESSAGE);
		    t1.setText("");//clear field
		    p1.setText("");//clear field

		    if(cnt==3)
		    {
		      JOptionPane.showMessageDialog(null,"Sorry !!! Your 3 attempts are over ...!!!");//,"WARNING",JOptionPane.ERROR_MESSAGE);
		       System.exit(0);
		    }
          		}

	               }

		else if(ae.getSource()==b2)
		{
			t1.setText("");//clear
			p1.setText("");//clear

		}

		else if(ae.getSource()==b3)
		{
		    System.exit(0);//exit
		}
	}

	public static void main(String args[])
	{
		new Login();
	}

}
