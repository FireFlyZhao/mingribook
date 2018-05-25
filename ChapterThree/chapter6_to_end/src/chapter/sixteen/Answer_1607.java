package chapter.sixteen;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.*;

import javax.swing.*;

public class Answer_1607 extends JFrame {
	
	private JTextField textField_2;
	
	private JTextField textField_1;
	
	private JTextField textField;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Answer_1607 frame = new Answer_1607();
			frame.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Answer_1607() {
		super();
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		getContentPane().add(panel, BorderLayout.CENTER);
		
		final JLabel label = new JLabel();
		label.setText("姓名：");
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridx = 0;
		panel.add(label,gridBagConstraints);
		
		textField = new JTextField();
		textField.setName("姓名");
		textField.setColumns(20);
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.gridy = 0;
		gridBagConstraints_5.gridx = 1;
		panel.add(textField, gridBagConstraints_5);
		
		final JLabel label_1 = new JLabel();
		label_1.setText("性别：");
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.gridy = 1;
		gridBagConstraints_1.gridx = 0;
		panel.add(label_1, gridBagConstraints_1);
		
		final JPanel panel_1 = new JPanel();
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridy = 1;
		gridBagConstraints_4.gridx = 1;
		panel.add(panel_1, gridBagConstraints_4); 
		
		final JRadioButton radioButton = new JRadioButton();
		radioButton.setText("男");
		panel_1.add(radioButton);
		
		final JRadioButton radioButton_1 = new JRadioButton();
		radioButton_1.setText("女");
		panel_1.add(radioButton_1);
		
		final JLabel label_2 = new JLabel();
		label_2.setText("出生日期：");
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy = 2;
		gridBagConstraints_2.gridx = 0;
		panel.add(label_2, gridBagConstraints_2);
		
		textField_1 = new JTextField();
		textField_1.setName("出生日期");
		textField_1.setColumns(20);
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridy = 2;
		gridBagConstraints_6.gridx = 1;
		panel.add(textField_1, gridBagConstraints_6);
		
		final JLabel label_3 = new JLabel();
		label_3.setText("身份证号：");
		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy = 3;
		gridBagConstraints_3.gridx = 0;
		panel.add(label_3, gridBagConstraints_3);
		
		textField_2 = new JTextField();
		textField_2.setName("身份证号");
		textField_2.setColumns(20);
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.gridy = 3;
		gridBagConstraints_7.gridx = 1;
		panel.add(textField_2, gridBagConstraints_7);
		
		final JButton button = new JButton();
		button.setText("确定");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Field[] fields = Answer_1607.class.getDeclaredFields();
				for (int i = 0; i < fields.length; i++) {
					Field field = fields[i];
					if (field.getType().equals(JTextField.class)) {}
					field.setAccessible(true);
					JTextField textField = null;
					try {
						textField = (JTextField) field.get(Answer_1607.this);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (textField.getText().trim().length() == 0) {
						String info = "请填写“" + textField.getName() + "”！";
						JOptionPane.showMessageDialog(null, info,
								"友情提示", JOptionPane.INFORMATION_MESSAGE);
						textField.requestFocus();
						return;
					}
				}
			}
		});
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.gridy = 4;
		gridBagConstraints_8.gridx = 1;
		panel.add(button, gridBagConstraints_8);
	}
}
