package openproject;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

public class match_con extends JFrame implements ActionListener{
	

	Label lblGen, lblHobby, lblJob, lblAge, lblAdd, lblent, lblfood, lblmov, lblsong, lblhate;
	TextField txtent, txtAdd, txtfood, txthate1, txthate2;
	Checkbox cbMale, cbFeMale;
	Choice chAge, chJob, chHobby1, chHobby2, chmov, chsong;
	JButton b1;
	
	Panel panGen = new Panel(new FlowLayout(FlowLayout.LEFT));
	pro_write w1;
	String id;
	String[] u_arr = new String[7];
	DB_control db = new DB_control();
	printlist pl;
	public match_con(String id) {
		this.id=id;
		setTitle("Person Matching");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setBackground(Color.PINK);
		c.setLayout(null);

		lblGen = new Label("����");
		lblHobby = new Label("���");
		lblJob = new Label("����");
		lblAge = new Label("����");
		lblmov = new Label("�����ϴ� ��ȭ");
		lblsong = new Label("�����ϴ� ����");

		lblGen.setBounds(20, 35, 100, 20);
		lblAge.setBounds(20, 64, 100, 20);
		lblJob.setBounds(20, 100, 100, 20);
		lblHobby.setBounds(20, 135, 100, 20);
		lblsong.setBounds(20, 238, 100, 20);
		lblmov.setBounds(20, 205, 100 , 20);

		add(lblGen);
		add(lblHobby);
		add(lblJob);
		add(lblAge);
		add(lblmov);
		add(lblsong);

		CheckboxGroup group = new CheckboxGroup();
		cbMale = new Checkbox("����", group, true);
		cbFeMale = new Checkbox("����", group, false);
		panGen.add(cbMale);
		panGen.add(cbFeMale);

		
		chAge = new Choice();
		chAge.add("10��");
		chAge.add("20��");
		chAge.add("30��");
		chAge.add("40��");
		chAge.add("50���̻�");
	

		
		chJob = new Choice();
		chJob.add("��ȣ��");
		chJob.add("�˻�");
		chJob.add("����");
		chJob.add("�����̳�");
		chJob.add("������");
		chJob.add("�ҹ��");
		chJob.add("�ǻ�");
		chJob.add("�ǻ�");
		chJob.add("���α׷���");
		chJob.add("ȸ���");
		
		

		
		chHobby1 = new Choice();
		chHobby1.add("����");
		chHobby1.add("����");
		chHobby1.add("����");
		chHobby1.add("����");
		chHobby1.add("��ȭ����");
		chHobby1.add("����");
		chHobby1.add("�丮");
		chHobby1.add("�");
		chHobby1.add("���ǵ��");
		chHobby1.add("û��");
		chHobby1.add("��");
	

		chHobby2 = new Choice();
		chHobby2.add("����");
		chHobby2.add("����");
		chHobby2.add("����");
		chHobby2.add("����");
		chHobby2.add("��ȭ����");
		chHobby2.add("����");
		chHobby2.add("�丮");
		chHobby2.add("�");
		chHobby2.add("���ǵ��");
		chHobby2.add("û��");
		chHobby2.add("��");
		
		
		txtent = new TextField(20);
		txtfood = new TextField(20);

		
		chmov = new Choice();
		chmov.add("�θǽ�");
		chmov.add("������");
		chmov.add("�׼�");
		chmov.add("�߸�");
		chmov.add("��Ÿ��");
		

	
		chsong = new Choice();
		chsong.add("����");
		chsong.add("����");
		chsong.add("Ŭ����");
		chsong.add("��");
		chsong.add("����");
		

		txtAdd = new TextField(20);
		txthate1 = new TextField(20);
		txthate2 = new TextField(20);


		

		panGen.setBounds(140, 26, 150, 28);
		chAge.setBounds(140, 65, 150, 20);
		chJob.setBounds(140, 98, 150, 20);
		chHobby1.setBounds(140, 132, 150, 20);
		chHobby2.setBounds(140, 165, 150, 20);
		chmov.setBounds(140, 201, 150, 20);
		chsong.setBounds(140, 233, 150, 20);
		
		b1= new JButton("��Ī");
		b1.setOpaque(true);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("DIALOG", Font.BOLD, 30));
        b1.setBounds(90,310,150,60);
        b1.addActionListener(this);
        add(b1);
		


		add(panGen);
		add(chAge);
		add(chJob);
		add(chHobby1);
		add(chHobby2);
		add(chmov);
		add(chsong);
		
	
	

		setSize(350, 450);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			if (cbMale.getState())
				u_arr[0] = "����";
			else
				u_arr[0] = "����";
			u_arr[1] = chAge.getSelectedItem();
			u_arr[2] = chJob.getSelectedItem();
			u_arr[3] = chHobby1.getSelectedItem();
			u_arr[4] = chHobby2.getSelectedItem();
			u_arr[5] = chmov.getSelectedItem();
			u_arr[6] = chsong.getSelectedItem();
			String sql=db.matching(u_arr);
			
			this.dispose();
			try {
				pl = new printlist(sql,id);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			pl.setVisible(true);
		}

	}
}