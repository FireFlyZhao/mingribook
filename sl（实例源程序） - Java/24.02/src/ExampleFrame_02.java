import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ExampleFrame_02 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel cardPanel;// 采用片布局管理器的面板对象
	
	private CardLayout cardLayout;// 卡片布局管理器对象
	
	public static void main(String args[]) {
		ExampleFrame_02 frame = new ExampleFrame_02();
		frame.setVisible(true);
	}
	
	public ExampleFrame_02() {
		super();
		setTitle("使用卡片布局管理器");
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cardLayout = new CardLayout();// 创建一个卡片布局管理器对象
		cardPanel = new JPanel(cardLayout);// 创建一个采用片布局管理器的面板对象
		getContentPane().add(cardPanel, BorderLayout.CENTER);// 添加到窗体中间
		
		String[] labelNames = { "卡片A", "卡片B", "卡片C" };
		for (int i = 0; i < labelNames.length; i++) {
			// 创建代表卡片的标签对象
			final JLabel label = new JLabel(labelNames[i]);
			// 设置标签文本的位置
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("", Font.BOLD, 16));// 设置标签文本的字体
			label.setForeground(new Color(255, 0, 0));// 设置标签文本的颜色
			// 向采用片布局管理器的面板中添加卡片
			cardPanel.add(label, labelNames[i]);
		}
		
		final JPanel buttonPanel = new JPanel();// 创建一个按钮面板
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);// 添加到窗体下方
		
		String[] buttonNames = { "第一个", "前一个", "卡片A", "卡片B", "卡片C",
				"后一个", "最后一个" };
		for (int i = 0; i < buttonNames.length; i++) {
			final JButton button = new JButton(buttonNames[i]);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String buttonText = button.getText();
					if (buttonText.equals("第一个"))
						cardLayout.first(cardPanel);// 显示第一个卡片
					else if (buttonText.equals("前一个"))
						cardLayout.previous(cardPanel);// 显示上一个卡片
					else if (buttonText.equals("卡片A"))
						cardLayout.show(cardPanel, "卡片A");// 显示卡片A
					else if (buttonText.equals("卡片B"))
						cardLayout.show(cardPanel, "卡片B");// 显示卡片B
					else if (buttonText.equals("卡片C"))
						cardLayout.show(cardPanel, "卡片C");// 显示卡片C
					else if (buttonText.equals("后一个"))
						cardLayout.next(cardPanel);// 显示下一个卡片
					else
						cardLayout.last(cardPanel);// 显示最后一个卡片
				}
			});
			buttonPanel.add(button);
		}
	}
}
