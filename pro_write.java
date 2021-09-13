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

import javax.swing.JButton;
import javax.swing.JFrame;


public class pro_write extends JFrame implements ActionListener{
	JButton b1,b2,b3;
    pro_write2 w2;
    match_con mc;
    Firststart2 f2;
    String id;
    public pro_write(String id) {
    	 this.id=id;
    	 setTitle("Person Matching");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Container c = getContentPane();
 		 c.setBackground(Color.PINK);
         setLayout(null);

         
        
        
         b1= new JButton("�� ������ �ۼ�/�����ϱ�");
 		 b1.setOpaque(true);
         b1.setForeground(Color.BLACK);
         b1.setFont(new Font("DIALOG", Font.BOLD, 15));
         b1.setBounds(70,80,200,50);
         b1.addActionListener(this);
         add(b1);
         
         b2= new JButton("��Ī�ϱ�");
 		 b2.setOpaque(true);
         b2.setForeground(Color.BLACK);
         b2.setFont(new Font("DIALOG", Font.BOLD, 15));
         b2.setBounds(70,165,200,50);
         b2.addActionListener(this);
         add(b2);
         
         b3= new JButton("�α׾ƿ�");
 		 b3.setOpaque(true);
         b3.setForeground(Color.BLACK);
         b3.setFont(new Font("DIALOG", Font.BOLD, 15));
         b3.setBounds(210,255,100,30);
         b3.addActionListener(this);
         add(b3);
        
         setSize(350, 350);
         setResizable(false);
         setVisible(true);
    }
    @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			this.dispose();
			w2 = new pro_write2(id);
			w2.setVisible(true);
		}
		else if(e.getSource()==b2) {
			this.dispose();
			mc = new match_con(id);
			mc.setVisible(true);
		}
		else if(e.getSource()==b3) {
			this.dispose();
			f2 = new Firststart2();
			f2.setVisible(true);
		}
	}

}