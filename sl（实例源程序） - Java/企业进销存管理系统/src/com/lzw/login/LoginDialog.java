package com.lzw.login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.lzw.*;
import com.lzw.dao.*;

public class LoginDialog extends JFrame {// 登录窗体
	private static final long serialVersionUID = 1L;
	private LoginPanel loginPanel = null;// 登录面板
	private JLabel jLabel = null;// “用户名”标签
	private JTextField userField = null;// “用户名”文本框
	private JLabel jLabel1 = null;// “密码”标签
	private JPasswordField passwordField = null;// “密码”文本框
	private JButton loginButton = null;// “登录”按钮
	private JButton exitButton = null;// “退出”按钮
	private static String userStr;// “用户名”文本框中的内容
	private MainFrame mainFrame;// 主窗体

	public LoginDialog() {// 登录窗体的构造方法
		try {
			// 设置登录窗体的风格
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mainFrame = new MainFrame();// 实例化主窗体
			initialize();// 初始化登录窗体
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private LoginPanel getLoginPanel() {// 初始化loginPanel登录面板的方法
		if (loginPanel == null) {// 登录面板中没有组件时
			jLabel1 = new JLabel();// “密码”标签
			jLabel1.setBounds(new Rectangle(86, 71, 55, 18));// 设置“密码”标签的位置与宽高
			jLabel1.setText("密　码：");// 设置“密码”标签的文本内容
			jLabel = new JLabel();// “用户名”标签
			jLabel.setText("用户名：");// 设置“用户名”标签的文本内容
			jLabel.setBounds(new Rectangle(85, 41, 56, 18));// 设置“用户名”标签的位置与宽高
			loginPanel = new LoginPanel();// 登录面板
			loginPanel.setLayout(null);// 设置登录面板的布局为绝对布局
			loginPanel.setBackground(new Color(0xD8DDC7));// 设置登录面板的背景色
			loginPanel.add(jLabel, null);// 把“用户名”标签置于登录面板中
			loginPanel.add(getUserField(), null);// 把“用户名”文本框置于登录面板中
			loginPanel.add(jLabel1, null);// 把“密码”标签置于登录面板中
			loginPanel.add(getPasswordField(), null);// 把“密码”文本框置于登录面板中
			loginPanel.add(getLoginButton(), null);// 把“登录”按钮置于登录面板中
			loginPanel.add(getExitButton(), null);// 把“退出”按钮置于登录面板中
		}
		return loginPanel;// 返回登录面板
	}

	private JTextField getUserField() {// 初始化“用户名”文本框
		if (userField == null) {// “用户名”文本框对象为空时
			userField = new JTextField();// 实例化“用户名”文本框
			userField.setBounds(new Rectangle(142, 39, 127, 22));// 设置“用户名”文本框的位置和宽高
		}
		return userField;// 返回“用户名”文本框
	}

	private JPasswordField getPasswordField() {// 初始化“密码”文本框
		if (passwordField == null) {// “密码”文本框对象为空时
			passwordField = new JPasswordField();// 实例化“密码”文本框
			passwordField.setBounds(new Rectangle(143, 69, 125, 22));// 设置“密码”文本框的位置和宽高
			passwordField.addKeyListener(new KeyAdapter() {// 为“密码”文本框添加键盘时间的监听
				public void keyTyped(KeyEvent e) {
					if (e.getKeyChar() == '\n')// 按下的按键是回车时
						loginButton.doClick();// “登录”按钮执行点击事件
				}
			});
		}
		return passwordField;// 返回“密码”文本框
	}

	private JButton getLoginButton() {// 初始化“登录”按钮
		if (loginButton == null) {// “登录”按钮对象为空时
			loginButton = new JButton();// 实例化“登录”按钮
			loginButton.setBounds(new Rectangle(109, 114, 48, 20));// 设置“登录”按钮的位置和宽高
			loginButton.setIcon(new ImageIcon(getClass().getResource("/res/loginButton.jpg")));// 设置“登录”按钮的图标
			loginButton.addActionListener(new ActionListener() {// 为“登录”按钮添加动作事件的监听
				public void actionPerformed(ActionEvent e) {
					try {
						userStr = userField.getText();// 获得“用户名”文本框中的内容
						String passStr = new String(passwordField.getPassword());// 获得“密码”文本框中的内容
						if (!Dao.checkLogin(userStr, passStr)) {// 验证用户名、密码失败
							JOptionPane.showMessageDialog(LoginDialog.this, "用户名与密码无法登录", "登录失败",
									JOptionPane.ERROR_MESSAGE);// 弹出“登录失败”对话框
							return;
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);// 设置主窗体的关闭方式
					mainFrame.setVisible(true);// 使主窗体可见
					MainFrame.getCzyStateLabel().setText(userStr);// 设置主窗体中操作员标签的字体是
					setVisible(false);// 使登录窗体不可见
				}
			});
		}
		return loginButton;// 返回“登录”按钮
	}

	private JButton getExitButton() {// 初始化“退出”按钮
		if (exitButton == null) {// “退出”按钮对象为空时
			exitButton = new JButton();// 实例化“退出”按钮
			exitButton.setBounds(new Rectangle(181, 114, 48, 20));// 设置“退出”按钮的位置和宽高
			exitButton.setIcon(new ImageIcon(getClass().getResource("/res/exitButton.jpg")));// 设置“退出”按钮的图标
			exitButton.addActionListener(new ActionListener() {// 为“退出”按钮天津爱动作事件的监听
				public void actionPerformed(ActionEvent e) {
					System.exit(0);// 退出当前的应用程序
				}
			});
		}
		return exitButton;// 返回“退出”按钮
	}

	private void initialize() {// 初始化登录窗体
		Dimension size = getToolkit().getScreenSize();// 获得屏幕尺寸
		setLocation((size.width - 296) / 2, (size.height - 188) / 2);// 设置登录窗体
		setSize(296, 188);// 设置登录窗体的宽高
		this.setTitle("系统登录");// 设置登录窗体的标题
		setContentPane(getLoginPanel());// 将登录面板置于登录窗体中
	}

	public String getUserStr() {// 获得“用户名”文本框中的内容
		return userStr;// 返回“用户名”文本框中的内容
	}

}
