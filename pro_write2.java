package openproject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

public class pro_write2 extends JFrame implements ActionListener{

	Label lblGen, lblHobby,lblJob,lblAge,lblAdd,lblent,lblfood,lblmov,lblsong,lblhate ;
    TextField txtent,txtAdd,txtfood,txthate1,txthate2;
    Checkbox cbMale,cbFeMale;
    Choice chAge,chJob,chHobby1, chHobby2,chmov,chsong;
    Button btnSubmit, btnCancel;
   
    Panel panGen = new Panel(new FlowLayout(FlowLayout.LEFT));
    pro_write w1;
    String id;
    String[] u_arr = new String[12];
    DB_control db=new DB_control();
    public pro_write2(String id) {
    	this.id=id;
    	setTitle("Person Matching");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setBackground(Color.PINK);
		c.setLayout(null);
    
        lblGen=new Label("����");
        lblHobby=new Label("���");
        lblJob=new Label("����");
        lblAge =new Label("����");
        lblent=new Label("�̻���(������)");
        lblfood =new Label("�����ϴ� ����");
        lblmov=new Label("�����ϴ� ��ȭ");
        lblsong=new Label("�����ϴ� ����");
        lblhate= new Label("�Ⱦ��ϴ� ��");
        lblAdd= new Label("���λ���");
        
        lblGen.setBounds(20, 35, 100, 20);
        lblAge.setBounds(20, 64, 100, 20);
        lblJob.setBounds(20, 100, 100, 20);
        lblHobby.setBounds(20, 135, 100 , 20);
        lblent.setBounds(20, 200, 105 , 20);
        lblfood.setBounds(20, 230, 100 , 20);
        lblmov.setBounds(20, 260, 100 , 20);
        lblsong.setBounds(20, 293, 100 , 20);
        lblhate.setBounds(20, 323, 100 , 20);
        lblAdd.setBounds(20, 380, 100, 20);
       
        add(lblGen);
        add(lblHobby);
        add(lblJob);
        add(lblAge);
        add(lblent);
        add(lblfood);
        add(lblmov);
        add(lblsong);
        add(lblhate);
        add(lblAdd);
       
        CheckboxGroup group = new CheckboxGroup();
        cbMale = new Checkbox("����",group,true);
        cbFeMale = new Checkbox("����",group,false);
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
        txtent= new TextField(20);
        txtfood= new TextField(20);
        
        chmov= new Choice();
        chmov.add("�θǽ�");
        chmov.add("������");
        chmov.add("�׼�");
        chmov.add("�߸�");
        chmov.add("��Ÿ��");
        
        chsong= new Choice();
        chsong.add("����");
        chsong.add("����");
        chsong.add("Ŭ����");
        chsong.add("��");
        chsong.add("����");
        
        txtAdd= new TextField(20);
        txthate1= new TextField(20);
        txthate2= new TextField(20);
       
        btnCancel = new Button("���");       
        btnSubmit = new Button("�ۼ��Ϸ�");
      
        panGen.setBounds(140, 26, 150, 28); 
        chAge.setBounds(140, 65, 150, 20);
        chJob.setBounds(140, 98, 150, 20);
        chHobby1.setBounds(140,132, 150, 20);
        chHobby2.setBounds(140,165, 150, 20);
        txtent.setBounds(140,200,150,20);
        txtfood.setBounds(140,230,150,20);
        chmov.setBounds(140,256,150,20);
        chsong.setBounds(140,288,150,20);
        txthate1.setBounds(140,323,150,20);
        txthate2.setBounds(140,350,150,20);
        txtAdd.setBounds(140,380,230,100);
       
        btnSubmit.setBounds(140,500,65,20);
        btnCancel.setBounds(210,500,60,20);
        
        add(panGen);
        add(chAge);
        add(chJob);
        add(chHobby1);
        add(chHobby2);
        add(txtent);
        add(txtfood);
        add(chmov);
        add(chsong);
        add(txthate1);
        add(txthate2);
        add(txtAdd);
    
        btnSubmit.addActionListener(this);
        btnCancel.addActionListener(this);
        add(btnSubmit);
        add(btnCancel);
        
        setSize(550, 600);
        setResizable(false);
        setVisible(true);
 }
    @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnSubmit) {
			if(cbMale.getState())
   				u_arr[0] = "����";
   			else
   				u_arr[0] = "����";
   			u_arr[1] = chAge.getSelectedItem();
   			u_arr[2] = chJob.getSelectedItem();
   			u_arr[3] = chHobby1.getSelectedItem();
   			u_arr[4] = chHobby2.getSelectedItem();
   			u_arr[5] = txtent.getText();
   			u_arr[6] = txtfood.getText();
   			u_arr[7] = chmov.getSelectedItem();
   			u_arr[8] = chsong.getSelectedItem();
   			u_arr[9] = txthate1.getText();
   			u_arr[10] = txthate2.getText();
   			u_arr[11] = txtAdd.getText();
			db.insert_user_info2(u_arr,id);
			JOptionPane.showMessageDialog(null,"�ۼ��Ϸ�");
			this.dispose();
			w1 = new pro_write(id);
		    w1.setVisible(true);
		}
		if(e.getSource()==btnCancel) {
			this.dispose();
			w1 = new pro_write(id);
			w1.setVisible(true);
		}

       }
 }
