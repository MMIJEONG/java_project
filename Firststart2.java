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
import javax.swing.JOptionPane;
public class Firststart2 extends JFrame implements ActionListener{

	Label lblId;
    Label lblPwd;
    Label lblFail;
    TextField txtId;
    TextField txtPwd;
    JButton b1,b2;
    sign_up s1;
    pro_write w1;
    DB_control db=new DB_control();
    public Firststart2() {
    	
    	 setTitle("Person Matching");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Container c = getContentPane();
 		 c.setBackground(Color.PINK);
         setLayout(null);

         lblId = new Label("���̵�");
         lblId.setFont(new Font("DIALOG", Font.BOLD, 20));
         lblId.setBounds(70, 70, 130, 40);
         txtId = new TextField();
         txtId.setBounds(200, 80, 120, 20);
        
         lblPwd = new Label("��й�ȣ");
         lblPwd.setFont(new Font("DIALOG", Font.BOLD, 20));
         lblPwd.setBounds(70, 120, 120, 40);
         txtPwd = new TextField();
         txtPwd.setBounds(200, 130, 120, 20);
        
         add(lblId);
         add(txtId);
         add(lblPwd);
         add(txtPwd);
        
         b1= new JButton("ȸ������");
 		 b1.setOpaque(true);
         b1.setForeground(Color.BLACK);
         b1.setFont(new Font("DIALOG", Font.BOLD, 15));
         b1.setBounds(70,168,110,30);
         b1.addActionListener(this);
         add(b1);
         
         b2= new JButton("�α���");
 		 b2.setOpaque(true);
         b2.setForeground(Color.BLACK);
         b2.setFont(new Font("DIALOG", Font.BOLD, 15));
         b2.setBounds(220,168,100,30);
         b2.addActionListener(this);
         add(b2);
        
         setSize(400, 300);
         setResizable(false);
         setVisible(true);
    }
    @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			this.dispose();
			s1 = new sign_up();
			s1.setVisible(true);
		}

		if(e.getSource()==b2) {
			boolean bool=db.login(txtId.getText(), txtPwd.getText());
			if(bool) {
				System.out.println("�α��� Ȯ��");
				this.dispose();
				w1 = new pro_write(txtId.getText());
				w1.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null,"�߸� �Է��ϼ̽��ϴ�. �ٽ��Է��ϼ���.");
			}
			
		}
		
	}

}