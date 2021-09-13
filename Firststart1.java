package openproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class Firststart1 extends JFrame implements ActionListener {
    Firststart2 f2;
    JButton b1;
	public Firststart1() {
		
		setTitle("Person Matching");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.PINK);
		c.setLayout(null);
		
		
		ImageIcon ic  = new ImageIcon(Firststart1.class.getResource("./1.png"));
		JLabel lbImage1  = new JLabel(ic);
		lbImage1.setBounds(145, 120, 400, 200);
		add(lbImage1);

		b1= new JButton("START");
		b1.setOpaque(true);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("DIALOG", Font.BOLD, 50));
        b1.setBounds(230,370,220,100);
        b1.addActionListener(this);
        add(b1);
		
		setSize(700, 600);
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
