package chapter.thirteen;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class UseCase3 extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UseCase3();
	}
	
	public UseCase3() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("登录窗体");
		setBounds(300, 200, 300, 150);
		Container cp=getContentPane();
		cp.setLayout(null);
		
		JLabel jl = new JLabel("用户名：");
		jl.setBounds(10, 10, 200, 18);
		final JTextField name = new JTextField();
		name.setBounds(80, 10, 150, 18);
		
		JLabel jl2 = new JLabel("密码：");
		jl2.setBounds(10, 50, 200, 18);
		final JPasswordField password = new JPasswordField();
		password.setBounds(80, 50, 150, 18);
		
		cp.add(jl);
		cp.add(name);
		cp.add(jl2);
		cp.add(password);
		
		JButton jb = new JButton("确定");
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (name.getText().trim().length()==0 || 
						new String(password.getPassword()).trim().length()==0) {
					JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
					return;
				}
				if (name.getText().trim().equals("mr") && 
						new String(password.getPassword()).trim().equals("mrsoft")) {
					JOptionPane.showMessageDialog(null, "登录成功");
				}else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
				}
			}
		});
		jb.setBounds(80, 80, 60, 18);
		cp.add(jb);
		
		final JButton button = new JButton();
		button.setText("重置");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				name.setText("");
				password.setText("");
			}
		});
		button.setBounds(150, 80, 60, 18);
		getContentPane().add(button);
		
		setVisible(true);
	}
}
