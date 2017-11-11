

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener{
	private JTextField tName = new JTextField();
	private JPasswordField tPsw = new JPasswordField();
	private JLabel lName = new JLabel();
	private JLabel lPsw = new JLabel();
	private JButton bOk = new JButton("��¼");
	private JButton bReset = new JButton("����");
	

	public LoginFrame(){
		setTitle("��¼");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/title/login.png"));
		setLayout(null);
		lName.setText("�û���");
		lName.setBounds(new Rectangle(16,14,54,24));
		tName.setBounds(new Rectangle(72,14,150,24));
		tName.setToolTipText("�����¼ϵͳ���û���");
		lPsw.setText("��    ��");
		lPsw.setBounds(new Rectangle(16,50,54,24));
		tPsw.setEchoChar('��');
		tPsw.setBounds(new Rectangle(72,50,150,24));
		tPsw.setToolTipText("�����¼ϵͳ���û�����Ӧ������");
		bOk.setBounds(new Rectangle(140,90,60,24));
		bOk.setToolTipText("�û��������붼��ȷ�����Խ���ϵͳ");
		bReset.setBounds(new Rectangle(140,90,60,24));
		bReset.setToolTipText("����û�����������Ϣ");
		tName.addActionListener(this);
		tPsw.addActionListener(this);
		bOk.addActionListener(this);
		bReset.addActionListener(this);
		add(lName);
		add(tName);
		add(lPsw);
		add(tPsw);
		add(bOk);
		add(bReset);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = new Dimension(250,170);
		if(frameSize.height>screenSize.height){
			frameSize.height = screenSize.height;
		}
		if(frameSize.width>screenSize.width){
			frameSize.width = screenSize.width;
		}
		setLocation(((screenSize.width - frameSize.width)/2),
				((screenSize.height - frameSize.height)/2));
		setSize(frameSize);
		this.setResizable(false);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new LoginFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == tName || e.getSource() == tPsw
				|| e.getSource() == bOk){
			if(isFormNull()){
				return;
			}
			String username = tName.getText();
			String password = new String(tPsw.getPassword());
			if(username.equals("1")&&password.equals("1")){
				BridGame bridGame;	
				try {
					bridGame = new BridGame();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				this.dispose();
			}else
			{
				JOptionPane.showMessageDialog(this, "�û��������벻���ڣ����������룡");
				tName.setText("");
				tPsw.setText("");
				return;
			}
		}else{
			tName.setText("");
			tPsw.setText("");
		}
		
	}
	private void println(String string) {
		// TODO Auto-generated method stub
		
	}
	private boolean isFormNull() {
		// TODO Auto-generated method stub
		String name = tName.getText().trim();
		if(name.length() == 0){
			JOptionPane.showMessageDialog(this, "��¼������Ϊ��");
			tName.requestFocus(true);
		}
		String password = new String(tPsw.getPassword());
		if(password.length() == 0){
			JOptionPane.showMessageDialog(this, "���벻��Ϊ��");
			return true;
		}
		return false;
	}
}