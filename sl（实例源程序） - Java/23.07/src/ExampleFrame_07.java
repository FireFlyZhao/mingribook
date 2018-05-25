import static java.awt.event.InputEvent.*;
import static java.awt.event.KeyEvent.*;

import java.awt.event.*;
import java.net.*;

import javax.swing.*;

public class ExampleFrame_07 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final ButtonGroup buttonGroup = new ButtonGroup();
	
	public static void main(String args[]) {
		ExampleFrame_07 frame = new ExampleFrame_07();
		frame.setVisible(true);
	}
	
	public ExampleFrame_07() {
		super();
		setBounds(100, 100, 500, 375);
		setTitle("订制个性化菜单");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		final JMenu fileMenu = new JMenu("文件（F）");// 创建“文件”菜单
		fileMenu.setMnemonic('F');// 设置快捷键
		menuBar.add(fileMenu);// 添加到菜单栏
		final JMenuItem newItem = new JMenuItem("新建（N）");// 创建菜单项
		newItem.setMnemonic('N');// 设置快捷键
		// 设置加速器为“Ctrl+N”
		newItem.setAccelerator(KeyStroke.getKeyStroke(VK_N, CTRL_MASK));
		newItem.addActionListener(new ItemListener());// 添加动作监听器
		fileMenu.add(newItem);// 添加到“文件”菜单
		final JMenu openMenu = new JMenu("打开（O）");// 创建“打开”子菜单
		openMenu.setMnemonic('O');// 设置快捷键
		fileMenu.add(openMenu);// 添加到“文件”菜单
		// 创建子菜单项
		final JMenuItem openNewItem = new JMenuItem("未打开过的（N）");
		openNewItem.setMnemonic('N');// 设置快捷键
		// 设置加速器为“Ctrl+Alt+N”
		openNewItem.setAccelerator(KeyStroke.getKeyStroke(VK_N, CTRL_MASK
				| ALT_MASK));
		openNewItem.addActionListener(new ItemListener());// 添加动作监听器
		openMenu.add(openNewItem);// 添加到“打开”子菜单
		// 创建子菜单项
		final JMenuItem openClosedItem = new JMenuItem("刚打开过的（C）");
		openClosedItem.setMnemonic('C');// 设置快捷键
		// 设置加速器
		openClosedItem.setAccelerator(KeyStroke.getKeyStroke(VK_C,
				CTRL_MASK | ALT_MASK));
		openClosedItem.setEnabled(false);// 禁用菜单项
		// 添加动作监听器
		openClosedItem.addActionListener(new ItemListener());
		openMenu.add(openClosedItem);// 添加到“打开”子菜单
		fileMenu.addSeparator();// 添加分隔线
		
		final JMenuItem saveItem = new JMenuItem();
		saveItem.setText("保存（S）");
		saveItem.setMnemonic('S');
		saveItem.setAccelerator(KeyStroke.getKeyStroke(VK_S, CTRL_MASK));
		saveItem.addActionListener(new ItemListener());
		fileMenu.add(saveItem);
		
		fileMenu.addSeparator();
		
		final JMenuItem exitItem = new JMenuItem();
		exitItem.setText("退出（E）");
		exitItem.setMnemonic('E');
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.CTRL_MASK));
		exitItem.addActionListener(new ItemListener());
		fileMenu.add(exitItem);
		
		final JMenu editMenu = new JMenu();
		editMenu.setText("编辑（E）");
		editMenu.setMnemonic('E');
		menuBar.add(editMenu);
		
		URL resource = this.getClass().getResource("/img.JPG");
		ImageIcon icon = new ImageIcon(resource);
		
		final JMenuItem cutItem = new JMenuItem();
		cutItem.setIcon(icon);
		cutItem.setText("剪切（T）");
		cutItem.setMnemonic('T');
		cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,
				InputEvent.CTRL_MASK));
		cutItem.addActionListener(new ItemListener());
		editMenu.add(cutItem);
		
		final JMenuItem copyItem = new JMenuItem();
		copyItem.setIcon(icon);
		copyItem.setText("复制（C）");
		copyItem.setMnemonic('C');
		copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.CTRL_MASK));
		copyItem.addActionListener(new ItemListener());
		editMenu.add(copyItem);
		
		final JMenuItem pastItem = new JMenuItem();
		pastItem.setIcon(icon);
		pastItem.setText("粘贴（P）");
		pastItem.setMnemonic('P');
		pastItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				InputEvent.CTRL_MASK));
		pastItem.addActionListener(new ItemListener());
		editMenu.add(pastItem);
		
		editMenu.addSeparator();
		editMenu.insertSeparator(2);
		
		final JMenu fontMenu = new JMenu("字体（F）");// 创建“字体”子菜单
		fontMenu.setIcon(icon);// 设置菜单图标
		fontMenu.setMnemonic('F');// 设置快捷键
		editMenu.add(fontMenu);// 添加到“编辑”菜单
		final JCheckBoxMenuItem bCheckBoxItem = new JCheckBoxMenuItem(
				"加粗（B）");// 创建复选框菜单项
		bCheckBoxItem.setMnemonic('B');// 设置快捷键
		bCheckBoxItem.setAccelerator(KeyStroke.getKeyStroke(VK_B,
				CTRL_MASK | ALT_MASK)); // 设置加速器为“Ctrl+Alt+B”
		bCheckBoxItem.addActionListener(new ItemListener()); // 添加动作监听器
		fontMenu.add(bCheckBoxItem);// 添加到“字体”子菜单
		final JCheckBoxMenuItem iCheckBoxItem = new JCheckBoxMenuItem(
				"斜体（I）");// 创建复选框菜单项
		iCheckBoxItem.setMnemonic('I');// 设置快捷键
		iCheckBoxItem.setAccelerator(KeyStroke.getKeyStroke(VK_I,
				CTRL_MASK | ALT_MASK)); // 设置加速器为“Ctrl+Alt+I”
		iCheckBoxItem.addActionListener(new ItemListener()); // 添加动作监听器
		fontMenu.add(iCheckBoxItem);// 添加到“字体”子菜单
		
		editMenu.addSeparator();
		
		final JMenu attributeMenu = new JMenu("属性（A）");// 创建“属性”子菜单
		attributeMenu.setIcon(icon);// 设置菜单图标
		attributeMenu.setMnemonic('A');// 设置快捷键
		editMenu.add(attributeMenu);// 添加到“编辑”菜单
		final JRadioButtonMenuItem rRadioButtonItem = new JRadioButtonMenuItem(
				"只读（R）");// 创建单选按钮菜单项
		rRadioButtonItem.setMnemonic('R');// 设置快捷键
		rRadioButtonItem.setAccelerator(KeyStroke.getKeyStroke(VK_R,
				CTRL_MASK | ALT_MASK));// 设置加速器为“Ctrl+Alt+R”
		buttonGroup.add(rRadioButtonItem);// 添加到按钮组
		rRadioButtonItem.setSelected(true);// 设置为被选中
		rRadioButtonItem.addActionListener(new ItemListener());// 添加动作监听器
		attributeMenu.add(rRadioButtonItem);// 添加到“属性”子菜单
		final JRadioButtonMenuItem eRadioButtonItem = new JRadioButtonMenuItem(
				"编辑（E）");// 创建单选按钮菜单项
		eRadioButtonItem.setMnemonic('E');// 设置快捷键
		eRadioButtonItem.setAccelerator(KeyStroke.getKeyStroke(VK_E,
				CTRL_MASK | ALT_MASK));// 设置加速器为“Ctrl+Alt+E”
		buttonGroup.add(eRadioButtonItem);// 添加到按钮组
		eRadioButtonItem.addActionListener(new ItemListener());// 添加动作监听器
		attributeMenu.add(eRadioButtonItem);// 添加到“属性”子菜单
		
		final JMenu helpMenu = new JMenu("帮助（H）", false);
		helpMenu.setText("帮助（H）");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);
		
		final JMenuItem aboutItem = new JMenuItem();
		aboutItem.setText("关于（A）");
		aboutItem.setMnemonic('A');
		aboutItem.addActionListener(new ItemListener());
		helpMenu.add(aboutItem);
		//
	}
	
	private class ItemListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JMenuItem menuItem = (JMenuItem) e.getSource();
			System.out.println("您单击的是菜单项：" + menuItem.getText());
		}
	}
	
}
