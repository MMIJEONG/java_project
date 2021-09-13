package openproject;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class D_sign_up extends JFrame implements ActionListener{
	Firststart2 f2;
	Label Done;
	JButton b1;
	public D_sign_up() {
		setTitle("Person Matching");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
		 c.setBackground(Color.PINK);
        setLayout(null);
       
        Done = new Label("ȯ���մϴ�");
        Done.setFont(new Font("DIALOG", Font.BOLD, 20));
        Done.setBounds(140, 70, 130, 40);
        add(Done);
        
        b1= new JButton("home");
		b1.setOpaque(true);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("DIALOG", Font.BOLD, 15));
        b1.setBounds(140,168,110,30);
        b1.addActionListener(this);
        add(b1);
        
        setSize(400, 300);
        setResizable(false);
        setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			this.dispose();
			f2 = new Firststart2();
			f2.setVisible(true);
		}
	}
}
