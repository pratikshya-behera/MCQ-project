//Screen4

package mcq;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import Connection.MCQ;

@SuppressWarnings("serial")
public class DisplayOp extends JFrame implements ActionListener{
	
	
	JButton b1,b2,b3,b4;
	JLabel l1,l2,l3;

	public DisplayOp() {
		setSize(600,400);
        setLayout(null);
		b1 = new JButton("Profile");
		b2 = new JButton("Take test");
		b3 = new JButton("Result");
		b4 = new JButton("Sign-out");
		l1 = new JLabel();
		l2 = new JLabel();
		l3 = new JLabel();
		b1.setBounds(100,50,100,30);
		b2.setBounds(100,110,100,30);
		b3.setBounds(100,170,100,30);
		b4.setBounds(100,300,100,30);
		l1.setBounds(300,65,200,30);
		l2.setBounds(300,95,200,30);
		l3.setBounds(300,125,200,30);
		add(b1); add(b2); add(b3); add(b4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		setResizable(false);
		setVisible(true);
		
		}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			
		
		
		if(e.getSource()==b2) {
			
			try {
				new MCQ();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//setVisible(false);
		}	
		
		if(e.getSource()==b3) {
			String result = Integer.toString(MCQ.r);
			l1.setText("Result: "+result+"/20");
			add(l1);
		}
		
		if(e.getSource()==b4) {
			new MainPage();
			setVisible(false);
		}
		
		if(e.getSource()==b1) {
			System.out.println(SignInPageDemo.un);
			String s = SignInPageDemo.un;
			PreparedStatement ps=con.prepareStatement("select * from userinfo where uname in ('"+SignInPageDemo.un+"')");
			//ps.setString(1,s);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			l1.setText(rs.getString(1));
			l2.setText(rs.getString(3));
			l3.setText(rs.getString(4));
			
			add(l2); add(l3);
			
			l1.setVisible(true);
			l2.setVisible(true);
			l3.setVisible(true);
			}
			
		}
		con.close();
		}catch(Exception ee) {System.out.print(ee);}
	}
	
	public static void main(String args[]) {
		
		new DisplayOp();
	}	
}
