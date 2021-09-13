package openproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
public class sign_up extends JFrame implements ActionListener {

	Label lblId, lblPwd, lblName, lblHp,lbMail;
    TextField txtId, txtPwd, txtName,txtMail;
    TextField txtHp1, txtHp2, txtHp3;
    Button btnSubmit, btnCancel,btnCheck;
    Firststart2 f2;
    D_sign_up s2;
    Panel panGen = new Panel(new FlowLayout(FlowLayout.LEFT));
    String[] u_arr = new String[5];
    DB_control db = new DB_control();
    public sign_up() {
    	setTitle("Person Matching");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setBackground(Color.PINK);
		c.setLayout(null);
    
        lblId =new Label("���̵�");
        lblPwd=new Label("��й�ȣ");
        lblName=new Label("�̸�");
        lblHp=new Label("�ڵ���");
        lbMail=new Label("�̸���");
        lblId.setBounds(20, 50, 100, 20);
        lblPwd.setBounds(20, 80, 100, 20);
        lblName.setBounds(20, 110, 100, 20);
        lblHp.setBounds(20, 140, 100 , 20);
        lbMail.setBounds(20, 170, 100 , 20);
        
        add(lblId);
        add(lblPwd);
        add(lblName);
        add(lblHp);
        add(lbMail);
      
        txtId =new TextField(20);
        txtPwd =new TextField(20);
        txtName= new TextField(20);
        txtMail= new TextField(20);
        Label lblhipen1 = new Label("-");
        Label lblhipen2 = new Label("-");
        txtHp1 = new TextField();
        txtHp2 = new TextField();
        txtHp3 = new TextField();
     
        btnCancel = new Button("���");       
        btnSubmit = new Button("���ԿϷ�");
        btnCheck = new Button("�ߺ�Ȯ��");
       
        txtId.setBounds(120, 50, 150, 20);
        txtPwd.setBounds(120, 80, 150, 20);
        txtName.setBounds(120, 110, 150, 20);
        txtHp1.setBounds(120, 140, 60, 20);
        lblhipen1.setBounds(190, 140, 10, 20);
        txtHp2.setBounds(210, 140, 60, 20);
        lblhipen2.setBounds(275, 140, 10, 20);
        txtHp3.setBounds(290, 140, 60, 20);
        txtMail.setBounds(120,170,150,20);
        
        btnCheck.setBounds(280,50,60,20);
        btnSubmit.setBounds(120,200,60,20);
        btnCancel.setBounds(190,200,60,20);
        
        btnSubmit.addActionListener(this);
        btnCancel.addActionListener(this);
        btnCheck.addActionListener(this);

        add(txtId);
        add(txtPwd);
        add(txtName);
        add(txtHp1);
        add(lblhipen1);
        add(txtHp2);
        add(lblhipen2);
        add(txtHp3);
        add(txtMail);
       
        add(btnCheck);
        add(btnSubmit);
        add(btnCancel);
        
        setSize(450, 300);
        setResizable(false);
        setVisible(true);

    }
    @Override
   	public void actionPerformed(ActionEvent e) {
   		if(e.getSource()==btnCancel) {
   			this.dispose();
   			f2 = new Firststart2();
   			f2.setVisible(true);
   		}
   		else if(e.getSource()==btnSubmit) {
   			u_arr[0] = txtId.getText();
   			u_arr[1] = txtPwd.getText();
   			u_arr[2] = txtName.getText();
   			u_arr[3] = txtHp1.getText() + txtHp2.getText() + txtHp3.getText();
   			u_arr[4] = txtMail.getText();
   			db.insert_user_info(u_arr);
   		   	this.dispose();
   			s2 = new D_sign_up();
		    s2.setVisible(true);
   		}   	
   		else if(e.getSource()==btnCheck) {
   			boolean bool=db.check(txtId.getText());
   			if(!bool) 
   				JOptionPane.showMessageDialog(null,"�̹� ��� ���� ���̵��Դϴ�. �ٽ��Է��ϼ���.");
   		    else
   				JOptionPane.showMessageDialog(null,"��� ������ ���̵��Դϴ�.");
   		}   	
   	}


}
