

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginFrame extends JFrame implements ActionListener{
	private JTextField tName = new JTextField();
	private JPasswordField tPsw = new JPasswordField();
	private JLabel lName = new JLabel();
	private JLabel lPsw = new JLabel();
	private JButton bOk = new JButton("登录");
	private JButton bReset = new JButton("重置");
	

	public LoginFrame(){
		setTitle("登录");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/title/login.png"));
		setLayout(null);
		lName.setText("用户名");
		lName.setBounds(new Rectangle(16,14,54,24));
		tName.setBounds(new Rectangle(72,14,150,24));
		tName.setToolTipText("输入登录系统的用户名");
		lPsw.setText("密    码");
		lPsw.setBounds(new Rectangle(16,50,54,24));
		tPsw.setEchoChar('。');
		tPsw.setBounds(new Rectangle(72,50,150,24));
		tPsw.setToolTipText("输入登录系统的用户名对应的密码");
		bOk.setBounds(new Rectangle(140,90,60,24));
		bOk.setToolTipText("用户名和密码都正确，可以进入系统");
		bReset.setBounds(new Rectangle(140,90,60,24));
		bReset.setToolTipText("清除用户名和密码信息");
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
				JOptionPane.showMessageDialog(this, "用户名和密码不存在，请重新输入！");
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
			JOptionPane.showMessageDialog(this, "登录名不能为空");
			tName.requestFocus(true);
		}
		String password = new String(tPsw.getPassword());
		if(password.length() == 0){
			JOptionPane.showMessageDialog(this, "密码不能为空");
			return true;
		}
		return false;
	}
}
