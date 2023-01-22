//Screen2
//modified code

package mcq;
import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignInPageDemo extends JFrame implements ActionListener{
	
	public static String un;
	JLabel l1,l2;
	JButton b;
	static JTextField t1;
	JPasswordField t2;

	public SignInPageDemo() {
		setSize(600,400);
		setTitle("Sign-in");
        setLayout(null);
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        t1 = new JTextField();
        t2 = new JPasswordField();
        t2.setEchoChar('*');
        b = new JButton("Sign-in");
        l1.setBounds(100,100,100,50);
        l2.setBounds(100,200,100,50);
        t1.setBounds(210,100,200,50);
        t2.setBounds(210,200,200,50);
        b.setBounds(400,300,100,30);
        add(l1); add(l2); add(t1); add(t2); add(b);
        b.addActionListener(this);
        setResizable(false);
        setVisible(true);
        
	}
	

	
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				PreparedStatement ps=con.prepareStatement("select * from userinfo where uname=? and upass=?");
				ps.setString(1,t1.getText());
				ps.setString(2,t2.getText());
				un = t1.getText();
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					new DisplayOp();
					setVisible(false);
				}
				con.close();
			}catch(Exception ee) {System.out.println("Hello");}
		}
		
	}
	
	public static void main(String args[]) {
		new SignInPageDemo();
	}

}