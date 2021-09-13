package openproject;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JOptionPane;
public class pro_print extends JFrame implements ActionListener{

     Label profile,gender,g1,age,a1,job,j1,hobby1,h1,hobby2,h2,type,t1,food,f1,movie,mo,music,mu,hate1,hate2,ha1,ha2,comment,c1;
     JButton b1;
     DB_control db=new DB_control();
     printlist pl;
     String term;
     String id;
  public pro_print(ResultSet rs,String term,String id)throws SQLException{ 
	  this.term=term;
	  this.id=id;
       setTitle("Person Matching");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       Container c = getContentPane();
       c.setBackground(Color.PINK);
       setLayout(null);

       rs.next();
       profile = new Label(rs.getString("Id")+"�� ������");
       profile.setFont(new Font("DIALOG", Font.BOLD, 50));
       profile.setBounds(70, 50, 530, 80);
  
      
       gender = new Label("����: ");
       gender.setFont(new Font("DIALOG", Font.BOLD, 15));
       gender.setBounds(70, 150, 50, 40);
       
       g1 = new Label(rs.getString("gender"));
       g1.setFont(new Font("DIALOG", Font.BOLD, 15));
       g1.setBounds(130, 150, 200, 40);
       
       age = new Label("����: ");
       age.setFont(new Font("DIALOG", Font.BOLD, 15));
       age.setBounds(70, 200, 50, 40);
       
       a1 = new Label(rs.getString("age"));
       a1.setFont(new Font("DIALOG", Font.BOLD, 15));
       a1.setBounds(130, 200, 200, 40);
       
       job = new Label("����: ");
       job.setFont(new Font("DIALOG", Font.BOLD, 15));
       job.setBounds(70, 250, 50, 40);
       
       j1 = new Label(rs.getString("job"));
       j1.setFont(new Font("DIALOG", Font.BOLD, 15));
       j1.setBounds(130, 250, 200, 40);
       
       hobby1 = new Label("��� (1): ");
       hobby1.setFont(new Font("DIALOG", Font.BOLD, 15));
       hobby1.setBounds(70, 300, 80, 40);
       
       h1 = new Label(rs.getString("hobby1"));
       h1.setFont(new Font("DIALOG", Font.BOLD, 15));
       h1.setBounds(160, 300, 200, 40);
       
       hobby2 = new Label("��� (2): ");
       hobby2.setFont(new Font("DIALOG", Font.BOLD, 15));
       hobby2.setBounds(70, 350, 80, 40);
       
       h2 = new Label(rs.getString("hobby2"));
       h2.setFont(new Font("DIALOG", Font.BOLD, 15));
       h2.setBounds(160, 350, 200, 40);
       
       type = new Label("�̻���: ");
       type.setFont(new Font("DIALOG", Font.BOLD, 15));
       type.setBounds(70, 400, 70, 40);
       
       t1 = new Label(rs.getString("type"));
       t1.setFont(new Font("DIALOG", Font.BOLD, 15));
       t1.setBounds(150, 400, 200, 40);
       
       food = new Label("�����ϴ� ����: ");
       food.setFont(new Font("DIALOG", Font.BOLD, 15));
       food.setBounds(70, 450, 140, 40);
       
       f1 = new Label(rs.getString("food"));
       f1.setFont(new Font("DIALOG", Font.BOLD, 15));
       f1.setBounds(210, 450, 400, 40);
       
       movie = new Label("�����ϴ� ��ȭ: ");
       movie.setFont(new Font("DIALOG", Font.BOLD,15));
       movie.setBounds(70, 500, 140, 40);
       
       mo = new Label(rs.getString("movie"));
       mo.setFont(new Font("DIALOG", Font.BOLD, 15));
       mo.setBounds(210, 500, 200, 40);
       
       music = new Label("�����ϴ� ����: ");
       music.setFont(new Font("DIALOG", Font.BOLD, 15));
       music.setBounds(70, 550, 140, 40);
       
       mu = new Label(rs.getString("music"));
       mu.setFont(new Font("DIALOG", Font.BOLD, 15));
       mu.setBounds(210, 550, 200, 40);
       
       hate1 = new Label("�Ⱦ��ϴ°� (1): ");
       hate1.setFont(new Font("DIALOG", Font.BOLD, 15));
       hate1.setBounds(70, 600, 140, 40);
       
       ha1 = new Label(rs.getString("hate1"));
       ha1.setFont(new Font("DIALOG", Font.BOLD, 15));
       ha1.setBounds(210, 600, 400, 40);
       
       hate2 = new Label("�Ⱦ��ϴ°� (2): ");
       hate2.setFont(new Font("DIALOG", Font.BOLD, 15));
       hate2.setBounds(70, 650, 140, 40);
       
       ha2 = new Label(rs.getString("hate2"));
       ha2.setFont(new Font("DIALOG", Font.BOLD, 15));
       ha2.setBounds(210, 650, 400, 40);
       
       comment = new Label("comment : ");
       comment.setFont(new Font("DIALOG", Font.BOLD, 15));
       comment.setBounds(70, 700, 100, 40);
       
       c1 = new Label(rs.getString("comment"));
       c1.setFont(new Font("DIALOG", Font.BOLD, 15));
       c1.setBounds(180, 700, 400, 40);
       
       add(profile);
       add(gender);
       add(age);
       add(job);
       add(hobby1);
       add(hobby2);
       add(type);
       add(food);
       add(movie);
       add(music);
       add(hate1);
       add(hate2);
       add(comment);
       add(g1);add(a1);add(j1);add(h1);add(h2);add(t1);add(f1);add(mo);add(mu);add(ha1);add(ha2);add(c1);
       
       b1= new JButton("�ڷΰ���");
       b1.setOpaque(true);
       b1.setForeground(Color.BLACK);
       b1.setFont(new Font("DIALOG", Font.BOLD, 15));
       b1.setBounds(510,770,100,40);
       b1.addActionListener(this);
       add(b1);
       
       setSize(650,1020);
       setResizable(false);
       setVisible(true);
  }
  @Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			this.dispose();
			try {
				pl = new printlist(term,id);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			pl.setVisible(true);
		}
		

	}
     
  

}