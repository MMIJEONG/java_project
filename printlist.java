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
public class printlist extends JFrame implements ActionListener{

	DB_control db = new DB_control();
	pro_print pp;
	pro_write w1;
    JButton b[]=new JButton[5];
    String ID[]=new String[5];
    int i;
    int x=10;
    String term;
    String id;
    JButton b1;
    public printlist(String sql,String id) throws SQLException {
    	 ResultSet rs=db.matching2(sql);
    	 term=sql;
    	 this.id=id;
         setTitle("Person Matching");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Container c = getContentPane();
         c.setBackground(Color.PINK);
         setLayout(null);
         for(i=0;i<5;i++) {
         rs.next();
         ID[i]=rs.getString("Id");
         b[i]= new JButton(rs.getString("Id")+"��");
         b[i].setOpaque(true);
         b[i].setForeground(Color.BLACK);
         b[i].setFont(new Font("DIALOG", Font.BOLD, 30));
         b[i].setBounds(70,x,350,80);
         x+=130;
         add(b[i]);
         }
         b[0].addActionListener(this);
         b[1].addActionListener(this);
         b[2].addActionListener(this);
         b[3].addActionListener(this);
         b[4].addActionListener(this);
         
         b1= new JButton("home");
         b1.setOpaque(true);
         b1.setForeground(Color.BLACK);
         b1.setFont(new Font("DIALOG", Font.BOLD, 15));
         b1.setBounds(380,660,80,40);
         b1.addActionListener(this);
         add(b1);
         
         setSize(500, 780);
         setResizable(false);
         setVisible(true);
    }
    @Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b[0]) {
			ResultSet rs=db.profile(ID[0]);
			this.dispose();
			try {
				pp = new pro_print(rs,term,id);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			pp.setVisible(true);
		}
		else if (e.getSource() == b[1]) {
			ResultSet rs=db.profile(ID[1]);
			this.dispose();
			try {
				pp = new pro_print(rs,term,id);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			pp.setVisible(true);
		}
		else if (e.getSource() == b[2]) {
			ResultSet rs=db.profile(ID[2]);
			this.dispose();
			try {
				pp = new pro_print(rs,term,id);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			pp.setVisible(true);
		}
		else if (e.getSource() == b[3]) {
			ResultSet rs=db.profile(ID[3]);
			this.dispose();
			try {
				pp = new pro_print(rs,term,id);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			pp.setVisible(true);
		}
		else if (e.getSource() == b[4]) {
			ResultSet rs=db.profile(ID[4]);
			this.dispose();
			try {
				pp = new pro_print(rs,term,id);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			pp.setVisible(true);
		}
		else if (e.getSource() == b1) {
			
			this.dispose();
			w1 = new pro_write(id);
			w1.setVisible(true);
		}

	}
  
}