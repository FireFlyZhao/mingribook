package chapter.thirteen;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;

public class JButtonTest extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new JButtonTest();
		
	}
	
	public JButtonTest() {
		URL url = JButtonTest.class.getResource("imageButton.jpg");
		Icon icon = new ImageIcon(url);
		setLayout(new GridLayout(3,2,5,5));
		Container c = getContentPane();
		for (int i = 0; i < 5; i++) {
			JButton J = new JButton("button" + i, icon);
			c.add(J);
			if(i % 2 == 0) {
				J.setEnabled(false);
			}
		}
		JButton jb = new JButton();
		jb.setMaximumSize(new Dimension(90,30));
		jb.setIcon(icon);
		jb.setHideActionText(true);
		jb.setToolTipText("图片按钮");
		jb.setBorderPainted(false);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "弹出对话框");
			}
		});
		c.add(jb);
		setTitle("创建带文字与图片的按钮");
		setSize(350, 150);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
