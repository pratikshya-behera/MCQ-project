//Screen1

package mcq;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class MainPage extends JFrame implements ActionListener{
	JLabel head;
	JButton b1,b2;
	Image im;
	Font f;
	MainPage()
	{
		setSize(600,400);
        setLayout(null);
        f = new Font("Arial",Font.BOLD,30);
        head = new JLabel("Welcome!");
        b1 = new JButton("Sign-up");
        b2 = new JButton("Sign-in");
        //im = Toolkit.getDefaultToolkit().getImage("Presentation.png");
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 2) + 1) + 2;
        JLabel MyImage = new JLabel(new ImageIcon("nature-"+randomNum+".jpg"));
        head.setBounds(285,30,100,20);
        b1.setBounds(130,130,100,30);
        b2.setBounds(130,200,100,30);
        add(head); add(b1); add(b2); add(MyImage);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setResizable(false);
        setVisible(true);
	}
	
	//public void paint(Graphics g)
	//{
		//g.drawImage(im,300,80,250,230,this);
	//}

	public static void main(String[] args) {
		MainPage ob = new MainPage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b2) {
			System.out.println("Sign-in page");
		    new SignInPageDemo();
		    setVisible(false);
		}
		if(e.getSource()==b1) {
			System.out.println("Sign-up page");
		    new SignUpPage();
		    setVisible(false);
		}
		
	}

}
