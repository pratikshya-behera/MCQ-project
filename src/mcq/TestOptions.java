package mcq;

import javax.swing.*;
import java.awt.event.*;

import Connection.MCQ;

@SuppressWarnings("serial")
public class TestOptions extends JFrame implements ActionListener{
	
	JButton b;
	JLabel l1;
	JTextField t1;
	static String str;
	

	public TestOptions()  {
		// TODO Auto-generated constructor stub
		setSize(500,500);
        setLayout(null);
        l1=new JLabel("Number of questions in test: ");
        b=new JButton("Start");
        t1=new JTextField();
        t1.setBounds(250,50,100,30);
        l1.setBounds(50,50,200,30);
        b.setBounds(260,250,100,30);
        add(l1);add(b);add(t1);
        str=t1.getText();
        b.addActionListener(this);
    	setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new TestOptions();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b)
		{
			
			try {
				System.out.println(str);
				new MCQ();
				setVisible(false);
			} catch (Exception e1) {
				// T)ODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(false);
		}
		
	}

	

}
