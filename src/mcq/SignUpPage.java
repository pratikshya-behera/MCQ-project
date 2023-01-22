//Screen3

package mcq;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@SuppressWarnings("serial")
public class SignUpPage extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JButton b;

	public SignUpPage() {
		setSize(600,400);
		setTitle("Sign-up");
        setLayout(null);
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        l3 = new JLabel("Email");
        l4 = new JLabel("Mobile");
        t1 = new JTextField();
        t2 = new JTextField();
        //t2.setEchoChar('*');
        t3 = new JTextField();
        t4 = new JTextField();
        b = new JButton("Sign-up");
		l1.setBounds(100, 50, 90, 50);
		l2.setBounds(100, 110, 90, 50);
		l3.setBounds(100, 170, 90, 50);
		l4.setBounds(100, 230, 90, 50);
		t1.setBounds(210, 50, 200, 50);
		t2.setBounds(210, 110, 200, 50);
		t3.setBounds(210, 170, 200, 50);
		t4.setBounds(210, 230, 200, 50);
		b.setBounds(400,320,100,30);
		add(l1); add(l2); add(t1); add(t2); add(l3); add(l4); add(t3); add(t4); add(b);
		b.addActionListener(this);
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				PreparedStatement ps=con.prepareStatement("insert into userinfo values(?,?,?,?)");
				ps.setString(1,t1.getText());
				ps.setString(2,t2.getText());
				ps.setString(3,t3.getText());
				ps.setString(4,t4.getText());
				int rs=ps.executeUpdate();
				if(rs>=1) {
					System.out.println("Registered");
					new SignInPageDemo();
					setVisible(false);
				}
				con.close();
			}catch(Exception ee) {System.out.println(ee);}
		}
		
	}
	
	public static void main(String args[])
	{
		new SignUpPage();
	}

}
