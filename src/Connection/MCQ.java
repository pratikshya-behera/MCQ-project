package Connection;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MCQ extends Frame implements ActionListener,ItemListener
 {
     Label l,res,head;
     Label jLabel;
     public static int r=0,i=0;
     Checkbox b1,b2,b3,b4;
      CheckboxGroup cg;
     Button b9;
     String ans="";
     String cans="";
     Question que[];
     public MCQ() throws Exception
     {
       setSize(700,500);
       setLayout(null);
       head=new Label("MCQ");
       res=new Label("Result="+0);
       cg=new CheckboxGroup();
       l=new Label();
       jLabel = new Label();
       b1=new Checkbox("",cg,false);
       b2=new Checkbox("",cg,false);
       b3=new Checkbox("",cg,false);
       b4=new Checkbox("",cg,false);
       b9=new Button("Next");
       head.setBounds(100,30,100,20);
       res.setBounds(250,30,150,20);
       l.setBounds(50,50,500,30);
       jLabel.setBounds(400,30,150,20);
       b1.setBounds(50,90,150,30);
       b2.setBounds(200,90,150,30);
       b3.setBounds(50,130,150,30);
       b4.setBounds(200,130,150,30);
       b9.setBounds(300,300,100,30);
       setLocation(433,134);
	   setResizable(false);  
       add(b1);add(b2);add(b3);add(b4);add(l);add(b9);add(res);
       add(head);add(jLabel);
	b1.addItemListener(this);
        b2.addItemListener(this);
        b3.addItemListener(this);
        b4.addItemListener(this);
	b9.addActionListener(this);
	
	Timer timer = new Timer();

    timer.scheduleAtFixedRate(new TimerTask() {
        int i = 100;

        public void run() {

            jLabel.setText("Time left: " + i);
            i--;

            if (i < 0) {
                timer.cancel();
                jLabel.setText("Time Over!!!");
                setVisible(false);
            }
        }
    }, 0, 1000);
	
	setVisible(true);
       loadQue();
       
       repaint();
   }
    void loadQue() throws Exception
    {
        que=new Question[20];
         try{  int sno=0;
               
                	Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				PreparedStatement ps=con.prepareStatement(" select * from (select * from MCQ order by dbms_random.random)where rownum<21");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
			   		que[sno++]=new Question(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				}
				con.close();


            } catch(Exception e) {
            	System.out.println(e);
            }
        
    }
    @SuppressWarnings("deprecation")
	public void paint(Graphics g)
    {
           cg.setCurrent(null);
           l.setText(que[i].qt);
           b1.setLabel(que[i].op1);
           b2.setLabel(que[i].op2);
           b3.setLabel(que[i].op3);
           b4.setLabel(que[i].op4);
     }
   public void actionPerformed(ActionEvent ee)
	{
          if(ee.getSource()==b9)
	  {
             if(ans.equals(que[i].ans))
               r++;
               res.setText("Result="+r);
              
              if(i==que.length)
                res.setText("Result="+r);
               else
                 i++;
              
               repaint();	
	   }
          
          
         }
  public void itemStateChanged(ItemEvent eee)
  {
       ans=(String)eee.getItem();
  }	
  public static void main(String args[]) throws Exception
  {
	  
      new MCQ();
  }
}
