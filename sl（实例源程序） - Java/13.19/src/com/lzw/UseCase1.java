package com.lzw;

import java.awt.*;

import javax.swing.*;

public class UseCase1 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBox;
	public static void main(String[] args) {
		new UseCase1();

	}
	public UseCase1() {
		super();
		setVisible(true);
		setSize(200,150);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		comboBox = new JComboBox<>();
		comboBox.addItem("��");
		comboBox.addItem("��");
		comboBox.addItem("��");
		comboBox.addItem("��");
		getContentPane().add(comboBox, BorderLayout.NORTH);

		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);

		final JCheckBox checkBox = new JCheckBox();
		checkBox.setText("��");
		panel.add(checkBox);

		final JCheckBox checkBox_1 = new JCheckBox();
		checkBox_1.setText("Ů");
		panel.add(checkBox_1);

		final JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		final JButton okButton = new JButton();
		okButton.setText("ȷ��");
		panel_1.add(okButton);

		final JButton button_1 = new JButton();
		button_1.setText("ȡ��");
		panel_1.add(button_1);
	}

}
