import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ExampleFrame_03 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_03 frame = new ExampleFrame_03();
		frame.setVisible(true);
	}

	public ExampleFrame_03() {
		super();
		setTitle("使用网格组布局管理器");
		getContentPane().setLayout(new GridBagLayout());
		setBounds(100, 100, 500, 170);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JButton button = new JButton("A");
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridy = 0;// 起始点为第1行
		gridBagConstraints.gridx = 0;// 起始点为第1列
		gridBagConstraints.weightx = 10;// 第一列的分布方式为10%
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(button, gridBagConstraints);

		final JButton button_1 = new JButton("B");
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.gridy = 0;
		gridBagConstraints_1.gridx = 1;
		// 设置组件左侧的最小距离
		gridBagConstraints_1.insets = new Insets(0, 5, 0, 0);
		gridBagConstraints_1.weightx = 20;// 第一列的分布方式为20%
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(button_1, gridBagConstraints_1);

		final JButton button_2 = new JButton("C");
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy = 0;// 起始点为第1行
		gridBagConstraints_2.gridx = 2;// 起始点为第3列
		gridBagConstraints_2.gridheight = 2;// 组件占用两行
		gridBagConstraints_2.insets = new Insets(0, 5, 0, 0);
		gridBagConstraints_2.weightx = 30;// 第一列的分布方式为30%
		// 同时调整组件的宽度和高度
		gridBagConstraints_2.fill = GridBagConstraints.BOTH;
		getContentPane().add(button_2, gridBagConstraints_2);

		final JButton button_3 = new JButton("D");
		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.gridy = 0;
		gridBagConstraints_3.gridx = 3;
		gridBagConstraints_3.gridheight = 4;
		// 设置组件左侧和右侧的最小距离
		gridBagConstraints_3.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints_3.weightx = 40;// 第一列的分布方式为40%
		gridBagConstraints_3.fill = GridBagConstraints.BOTH;
		getContentPane().add(button_3, gridBagConstraints_3);

		final JButton button_4 = new JButton("E");
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridy = 1;
		gridBagConstraints_4.gridx = 0;
		gridBagConstraints_4.gridwidth = 2;// 组件占用两列
		// 设置组件上方的最小距离
		gridBagConstraints_4.insets = new Insets(5, 0, 0, 0);
		// 只调整组件的宽度
		gridBagConstraints_4.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(button_4, gridBagConstraints_4);

		final JButton button_5 = new JButton("F");
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.gridy = 2;// 起始点为第3行
		gridBagConstraints_5.gridx = 0;// 起始点为第1列
		gridBagConstraints_5.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(button_5, gridBagConstraints_5);

		final JButton button_6 = new JButton("G");
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridy = 2;
		gridBagConstraints_6.gridx = 1;
		gridBagConstraints_6.gridwidth = 2;// 组件占用两列
		gridBagConstraints_6.gridheight = 2;// 组件占用两行
		gridBagConstraints_6.insets = new Insets(5, 5, 0, 0);
		gridBagConstraints_6.fill = GridBagConstraints.BOTH;// 只调整组件的高度
//		gridBagConstraints_6.fill = GridBagConstraints.VERTICAL;// 只调整组件的高度
//		gridBagConstraints_6.ipadx = 30;// 增加组件的首选宽度
//		gridBagConstraints_6.anchor = GridBagConstraints.EAST;// 显示在东方
		getContentPane().add(button_6, gridBagConstraints_6);

		final JButton button_7 = new JButton("H");
		final GridBagConstraints gridBagConstraints_7 = new GridBagConstraints();
		gridBagConstraints_7.gridy = 3;
		gridBagConstraints_7.gridx = 0;
		gridBagConstraints_7.insets = new Insets(5, 0, 0, 0);
		gridBagConstraints_7.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(button_7, gridBagConstraints_7);
		//
	}

}
