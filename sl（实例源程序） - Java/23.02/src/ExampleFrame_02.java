import java.awt.*;
import java.net.*;

import javax.swing.*;
import javax.swing.event.*;

public class ExampleFrame_02 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_02 frame = new ExampleFrame_02();
		frame.setVisible(true);
	}
	
	public ExampleFrame_02() {
		super();
		getContentPane().setFocusCycleRoot(true);
		setTitle("选项卡面板");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JTabbedPane tabbedPane = new JTabbedPane();
		// 设置选项卡标签的布局方式
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				// 获得被选中选项卡的索引
				int selectedIndex = tabbedPane.getSelectedIndex();
				// 获得指定索引的选项卡标签
				String title = tabbedPane.getTitleAt(selectedIndex);
				System.out.println(title);
			}
		});
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		URL resource = ExampleFrame_02.class.getResource("/tab.JPG");
		ImageIcon imageIcon = new ImageIcon(resource);
		final JLabel tabLabelA = new JLabel();
		tabLabelA.setText("选项卡A");
		// 将标签组件添加到选项卡中
		tabbedPane.addTab("选项卡A", imageIcon, tabLabelA, "点击查看选项卡A");
		final JLabel tabLabelB = new JLabel();
		tabLabelB.setText("选项卡B");
		tabbedPane.addTab("选项卡B", imageIcon, tabLabelB, "点击查看选项卡B");
		final JLabel tabLabelC = new JLabel();
		tabLabelC.setText("选项卡C");
		tabbedPane.addTab("选项卡C", imageIcon, tabLabelC, "点击查看选项卡C");
		tabbedPane.setSelectedIndex(2); // 设置索引为2的选项卡被选中
		tabbedPane.setEnabledAt(0, false); // 设置索引为0的选项卡不可用
	}
}
