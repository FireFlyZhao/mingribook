import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ExampleFrame_06 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_06 frame = new ExampleFrame_06();
		frame.setVisible(true);
	}
	
	public ExampleFrame_06() {
		super();
		setTitle("创建弹出式菜单");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JLabel label = new JLabel();
		label.setText("                请在窗口中单击鼠标右键！");
		getContentPane().add(label, BorderLayout.CENTER);
		
		final JPopupMenu popupMenu = new JPopupMenu();// 创建弹出式菜单对象
		// 为窗体的顶层容器添加鼠标事件监听器
		getContentPane().addMouseListener(new MouseAdapter() {
			// 鼠标按键被释放时触发该方法
			public void mouseReleased(MouseEvent e) {
				// 判断此次鼠标事件是否为该组件的弹出菜单触发事件
				// 如果是则在释放鼠标的位置弹出菜单
				if (e.isPopupTrigger())
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		});
		
		final JMenuItem cutItem = new JMenuItem("剪切");
		cutItem.addActionListener(new ItemListener());
		popupMenu.add(cutItem);
		
		final JMenuItem copyItem = new JMenuItem("复制");
		copyItem.addActionListener(new ItemListener());
		popupMenu.add(copyItem);
		
		final JMenuItem pastItem = new JMenuItem("粘贴");
		pastItem.addActionListener(new ItemListener());
		popupMenu.add(pastItem);
		
		final JMenu editMenu = new JMenu("编辑");
		popupMenu.add(editMenu);
		
		final JMenuItem readItem = new JMenuItem("只读");
		readItem.addActionListener(new ItemListener());
		editMenu.add(readItem);
		
		final JMenuItem writeItem = new JMenuItem("可写");
		writeItem.addActionListener(new ItemListener());
		editMenu.add(writeItem);
		
		final JMenu fontMenu = new JMenu("字体");
		editMenu.add(fontMenu);
		
		final JMenuItem boldfacedItem = new JMenuItem("加粗");
		boldfacedItem.addActionListener(new ItemListener());
		fontMenu.add(boldfacedItem);
		
		final JMenuItem italicItem = new JMenuItem("斜体");
		italicItem.addActionListener(new ItemListener());
		fontMenu.add(italicItem);
		//
	}
	
	private class ItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JMenuItem menuItem = (JMenuItem) e.getSource();
			System.out.println("您单击的是菜单项：" + menuItem.getText());
		}
	}
	
}
