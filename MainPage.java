

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends Frame implements ActionListener {
	Label head;
	Button b1,b2;
	Image im;
	MainPage()
	{
		setSize(600,400);
        setLayout(null);
        head = new Label("Welcome!");
        b1 = new Button("Sign-up");
        b2 = new Button("Sign-in");
        im = Toolkit.getDefaultToolkit().getImage("Presentation.PNG");
        head.setBounds(285,30,100,20);
        b1.setBounds(150,130,50,30);
        b2.setBounds(150,180,50,30);
        add(head); add(b1); add(b2);
        setVisible(true);
	}

	public static void main(String[] args) {
		MainPage ob = new MainPage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}