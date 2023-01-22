package mcq;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) {

        JFrame jframe = new JFrame();
        JLabel jLabel = new JLabel();
        jframe.setLayout(new FlowLayout());
        jframe.setBounds(500, 300, 400, 100);

        jframe.add(jLabel);
        jframe.setVisible(true);

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 20;

            public void run() {

                jLabel.setText("Time left: " + i);
                i--;

                if (i < 0) {
                    timer.cancel();
                    jLabel.setText("Time Over!!!");
                }
            }
        }, 0, 1000);
    }
}
