import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.*;

public class Answer_2314 extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ButtonGroup showInfoButtonGroup = new ButtonGroup();

	private ButtonGroup leaveInfoButtonGroup = new ButtonGroup();

	private ButtonGroup leave_2InfoButtonGroup = new ButtonGroup();

	private JTable table;

	private JTextField textField_1;

	private JTextArea textArea;

	private JTree tree;

	private JTextField textField;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Answer_2314 dialog = new Answer_2314();
			dialog.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			dialog.setVisible(true);
			dialog.addIconToTray();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Add the SystemTray
	 */
	public void addIconToTray() throws AWTException {
		if (SystemTray.isSupported()) {// �ж�ϵͳ�Ƿ�֧��ϵͳ���̹���

			URL resource = this.getClass().getResource("/img.JPG");// ���ͼƬ·��
			ImageIcon icon = new ImageIcon(resource);// ����ͼƬ����

			PopupMenu popupMenu = new PopupMenu();// ���������˵�����
			MenuItem item = new MenuItem("�˳�");// �������˳����˵���Ŀ����
			item.addActionListener(new ActionListener() {// Ϊ�˵���Ŀ��Ӷ���������
						public void actionPerformed(ActionEvent e) {
							System.exit(0);// �˳�ϵͳ
						}
					});
			popupMenu.add(item);// �����˳����˵���Ŀ��ӵ������˵���

			TrayIcon trayIcon = new TrayIcon(icon.getImage(), "�ҵ�QQ", popupMenu);// ��������ͼƬ����

			SystemTray systemTray = SystemTray.getSystemTray();// ���ϵͳ���̶���
			systemTray.add(trayIcon);// ������ͼƬ��ӵ�ϵͳ������
		}
	}

	/**
	 * Create the dialog
	 */
	public Answer_2314() {
		super();
		setTitle("�ҵ�QQ");
		setBounds(100, 100, 270, 570);

		final JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		final JMenu menu = new JMenu();
		menu.setText("�ļ���F��");
		menu.setMnemonic('F');
		menuBar.add(menu);

		final JMenuItem menuItem = new JMenuItem();
		menuItem.setText("�����û�");
		menu.add(menuItem);

		menu.addSeparator();

		final JMenu menu_3 = new JMenu();
		menu_3.setText("�ҵ�״̬");
		menu.add(menu_3);

		final JMenuItem menuItem_1 = new JMenuItem();
		menuItem_1.setText("����");
		menu_3.add(menuItem_1);

		final JMenu menu_7 = new JMenu();
		menu_7.setText("�뿪");
		menu_3.add(menu_7);

		final JRadioButtonMenuItem radioButtonMenuItem_2 = new JRadioButtonMenuItem();
		leaveInfoButtonGroup.add(radioButtonMenuItem_2);
		radioButtonMenuItem_2.setText("����æ��");
		menu_7.add(radioButtonMenuItem_2);

		final JRadioButtonMenuItem radioButtonMenuItem_3 = new JRadioButtonMenuItem();
		leaveInfoButtonGroup.add(radioButtonMenuItem_3);
		radioButtonMenuItem_3.setText("���ϻ�����");
		menu_7.add(radioButtonMenuItem_3);

		final JRadioButtonMenuItem radioButtonMenuItem_4 = new JRadioButtonMenuItem();
		leaveInfoButtonGroup.add(radioButtonMenuItem_4);
		radioButtonMenuItem_4.setText("���ڲμӻ��飡");
		menu_7.add(radioButtonMenuItem_4);

		final JRadioButtonMenuItem radioButtonMenuItem_5 = new JRadioButtonMenuItem();
		leaveInfoButtonGroup.add(radioButtonMenuItem_5);
		radioButtonMenuItem_5.setText("��Ϣ�У�������ţ�");
		menu_7.add(radioButtonMenuItem_5);

		menu_7.addSeparator();

		final JRadioButtonMenuItem radioButtonMenuItem_6 = new JRadioButtonMenuItem();
		radioButtonMenuItem_6.setSelected(true);
		leaveInfoButtonGroup.add(radioButtonMenuItem_6);
		radioButtonMenuItem_6.setText("���ظ���Ϣ");
		menu_7.add(radioButtonMenuItem_6);

		menu_7.addSeparator();

		final JMenuItem menuItem_22 = new JMenuItem();
		menuItem_22.setText("�Զ���...");
		menu_7.add(menuItem_22);

		final JMenuItem menuItem_6 = new JMenuItem();
		menuItem_6.setText("����");
		menu_3.add(menuItem_6);

		menu.addSeparator();

		final JMenuItem menuItem_2 = new JMenuItem();
		menuItem_2.setText("��������");
		menu.add(menuItem_2);

		final JMenuItem menuItem_3 = new JMenuItem();
		menuItem_3.setText("ϵͳ����");
		menu.add(menuItem_3);

		menu.addSeparator();

		final JMenuItem menuItem_4 = new JMenuItem();
		menuItem_4.setText("�˳�");
		menu.add(menuItem_4);

		final JMenu menu_1 = new JMenu();
		menu_1.setText("��ϵ�ˣ�P��");
		menu_1.setMnemonic('P');
		menuBar.add(menu_1);

		final JMenuItem menuItem_7 = new JMenuItem();
		menuItem_7.setText("������ϵ��");
		menu_1.add(menuItem_7);

		menu_1.addSeparator();

		final JMenu menu_4 = new JMenu();
		menu_4.setText("������ϵ��");
		menu_1.add(menu_4);

		final JMenuItem menuItem_8 = new JMenuItem();
		menuItem_8.setText("�����ϵ��");
		menu_4.add(menuItem_8);

		final JMenuItem menuItem_9 = new JMenuItem();
		menuItem_9.setText("ɾ����ϵ��");
		menu_4.add(menuItem_9);

		final JMenu menu_5 = new JMenu();
		menu_5.setText("�����Զ�����");
		menu_1.add(menu_5);

		final JMenuItem menuItem_10 = new JMenuItem();
		menuItem_10.setText("����Զ�����");
		menu_5.add(menuItem_10);

		final JMenuItem menuItem_11 = new JMenuItem();
		menuItem_11.setText("ɾ���Զ�����");
		menu_5.add(menuItem_11);

		menu_5.addSeparator();

		final JMenuItem menuItem_12 = new JMenuItem();
		menuItem_12.setText("�����Զ�����");
		menu_5.add(menuItem_12);

		menu_1.addSeparator();

		final JMenu menu_6 = new JMenu();
		menu_6.setText("��ʾ��ʽ");
		menu_1.add(menu_6);

		final JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem();
		checkBoxMenuItem.setState(true);
		checkBoxMenuItem.setText("��ʾ�˺�");
		menu_6.add(checkBoxMenuItem);

		final JCheckBoxMenuItem checkBoxMenuItem_1 = new JCheckBoxMenuItem();
		checkBoxMenuItem_1.setSelected(true);
		checkBoxMenuItem_1.setText("��ʾ����");
		menu_6.add(checkBoxMenuItem_1);

		menu_6.addSeparator();

		final JRadioButtonMenuItem radioButtonMenuItem = new JRadioButtonMenuItem();
		radioButtonMenuItem.setSelected(true);
		showInfoButtonGroup.add(radioButtonMenuItem);
		radioButtonMenuItem.setText("��ʾ������ϵ��");
		menu_6.add(radioButtonMenuItem);

		final JRadioButtonMenuItem radioButtonMenuItem_1 = new JRadioButtonMenuItem();
		showInfoButtonGroup.add(radioButtonMenuItem_1);
		radioButtonMenuItem_1.setText("ֻ��ʾ������ϵ��");
		menu_6.add(radioButtonMenuItem_1);

		final JMenu menu_2 = new JMenu();
		menu_2.setText("������O��");
		menu_2.setMnemonic('O');
		menuBar.add(menu_2);

		final JMenuItem menuItem_13 = new JMenuItem();
		menuItem_13.setText("������Ϣ");
		menu_2.add(menuItem_13);

		final JMenuItem menuItem_14 = new JMenuItem();
		menuItem_14.setText("�����ļ�");
		menu_2.add(menuItem_14);

		menu_2.addSeparator();

		final JMenuItem menuItem_15 = new JMenuItem();
		menuItem_15.setText("�鿴��Ϣ��¼");
		menu_2.add(menuItem_15);

		final JMenuItem menuItem_16 = new JMenuItem();
		menuItem_16.setText("�鿴������Ϣ");
		menu_2.add(menuItem_16);

		final JMenuItem menuItem_17 = new JMenuItem();
		menuItem_17.setText("�鿴δ����Ϣ");
		menu_2.add(menuItem_17);

		final JMenu menu_9 = new JMenu();
		menu_9.setText("������H��");
		menu_9.setMnemonic('H');
		menuBar.add(menu_9);

		final JMenuItem menuItem_18 = new JMenuItem();
		menuItem_18.setText("����");
		menu_9.add(menuItem_18);

		menu_9.addSeparator();

		final JMenuItem menuItem_19 = new JMenuItem();
		menuItem_19.setText("����");
		menu_9.add(menuItem_19);

		final JPanel panel = new JPanel();
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setLayout(flowLayout);
		getContentPane().add(panel, BorderLayout.NORTH);

		final JLabel label = new JLabel();
		label
				.setIcon(new ImageIcon(this.getClass().getResource(
						"/head.gif")));
		panel.add(label);

		final JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(0, 1));
		panel.add(panel_1);

		final JPanel panel_2 = new JPanel();
		final FlowLayout flowLayout_1 = new FlowLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_2.setLayout(flowLayout_1);
		panel_1.add(panel_2);

		final JLabel label_1 = new JLabel();
		label_1.setText("17833518");
		panel_2.add(label_1);

		final JButton button = new MButton();
		button.setText("���� ��");
		panel_2.add(button);

		final JPopupMenu popupMenu = new JPopupMenu();
		addPopup(button, popupMenu);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popupMenu.show(button, button.getX(), button.getY());
			}
		});

		//
		final JMenuItem menuItem_111 = new JMenuItem();
		menuItem_111.setText("����");
		popupMenu.add(menuItem_111);

		final JMenu menu_117 = new JMenu();
		menu_117.setText("�뿪");
		popupMenu.add(menu_117);

		final JRadioButtonMenuItem radioButtonMenuItem_112 = new JRadioButtonMenuItem();
		leave_2InfoButtonGroup.add(radioButtonMenuItem_112);
		radioButtonMenuItem_112.setText("����æ��");
		menu_117.add(radioButtonMenuItem_112);

		final JRadioButtonMenuItem radioButtonMenuItem_113 = new JRadioButtonMenuItem();
		leave_2InfoButtonGroup.add(radioButtonMenuItem_113);
		radioButtonMenuItem_113.setText("���ϻ�����");
		menu_117.add(radioButtonMenuItem_113);

		final JRadioButtonMenuItem radioButtonMenuItem_114 = new JRadioButtonMenuItem();
		leave_2InfoButtonGroup.add(radioButtonMenuItem_114);
		radioButtonMenuItem_114.setText("���ڲμӻ��飡");
		menu_117.add(radioButtonMenuItem_114);

		final JRadioButtonMenuItem radioButtonMenuItem_115 = new JRadioButtonMenuItem();
		leave_2InfoButtonGroup.add(radioButtonMenuItem_115);
		radioButtonMenuItem_115.setText("��Ϣ�У�������ţ�");
		menu_117.add(radioButtonMenuItem_115);

		menu_117.addSeparator();

		final JRadioButtonMenuItem radioButtonMenuItem_116 = new JRadioButtonMenuItem();
		radioButtonMenuItem_116.setSelected(true);
		leave_2InfoButtonGroup.add(radioButtonMenuItem_116);
		radioButtonMenuItem_116.setText("���ظ���Ϣ");
		menu_117.add(radioButtonMenuItem_116);

		menu_117.addSeparator();

		final JMenuItem menuItem_1122 = new JMenuItem();
		menuItem_1122.setText("�Զ���...");
		menu_117.add(menuItem_1122);

		final JMenuItem menuItem_116 = new JMenuItem();
		menuItem_116.setText("����");
		popupMenu.add(menuItem_116);
		//

		final JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);

		final JButton button_1 = new MButton();
		button_1.setText("������Ϣ");
		panel_3.add(button_1);

		final JButton button_2 = new MButton();
		button_2.setText("δ����Ϣ");
		panel_3.add(button_2);

		final JPanel panel_4 = new JPanel();
		panel_4.setLayout(new BorderLayout());
		getContentPane().add(panel_4, BorderLayout.CENTER);

		final JToolBar toolBar = new JToolBar();
		panel_4.add(toolBar, BorderLayout.NORTH);

		textField = new JTextField();
		textField.setText("<�ɰ��˺š�������ƴ�����в���>");
		textField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				textField.setText(null);
			}

			public void focusLost(FocusEvent e) {
				textField.setText("<�ɰ��˺š�������ƴ�����в���>");
			}
		});
		toolBar.add(textField);

		final JButton button_3 = new JButton();
		button_3.setText("����");
		toolBar.add(button_3);

		final JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerLocation(300);
		splitPane.setOneTouchExpandable(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_4.add(splitPane, BorderLayout.CENTER);

		final JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(SwingConstants.LEFT);
		splitPane.setLeftComponent(tabbedPane);

		final JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("<html><br>��<br>ϵ<br>��<br><br></html>", null,
				scrollPane, null);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("");
		String[] types = { "��ϵ��", "�ҵĺ���", "������" };
		String[][] personnels = { { "A", "B", "C", "D", "E", "F" },
				{ "G", "H", "I", "J", "K", "L" },
				{ "M", "N", "O", "P", "Q", "R" } };
		for (int i = 0; i < 3; i++) {
			DefaultMutableTreeNode typeNode = new DefaultMutableTreeNode(
					types[i]);
			for (int j = 0; j < 6; j++) {
				typeNode
						.add(new DefaultMutableTreeNode(personnels[i][j], false));
			}
			root.add(typeNode);
		}

		tree = new JTree(root, true);
		tree.setRootVisible(false);
		scrollPane.setViewportView(tree);

		final JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOneTouchExpandable(true);
		splitPane_1.setDividerLocation(200);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		tabbedPane.addTab("<html><br>��<br>��<br>¼<br><br></html>", null,
				splitPane_1, null);

		final JPanel panel_7 = new JPanel();
		panel_7.setLayout(new BorderLayout());
		splitPane_1.setLeftComponent(panel_7);

		final JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, BorderLayout.NORTH);

		final JButton button_6 = new JButton();
		button_6.setText("�½�");
		panel_8.add(button_6);

		final JButton button_7 = new JButton();
		button_7.setText("�޸�");
		panel_8.add(button_7);

		final JButton button_8 = new JButton();
		button_8.setText("ɾ��");
		panel_8.add(button_8);

		final JScrollPane scrollPane_1 = new JScrollPane();
		panel_7.add(scrollPane_1, BorderLayout.CENTER);

		String[] columnNames = { "ʱ��", "����" };
		DefaultTableModel tableModel = new DefaultTableModel(null, columnNames);

		table = new JTable(tableModel);
		scrollPane_1.setViewportView(table);

		final JPanel panel_6 = new JPanel();
		panel_6.setLayout(new BorderLayout());
		splitPane_1.setRightComponent(panel_6);

		textField_1 = new JTextField();
		panel_6.add(textField_1, BorderLayout.NORTH);

		final JScrollPane scrollPane_2 = new JScrollPane();
		panel_6.add(scrollPane_2, BorderLayout.CENTER);

		textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);

		final JPanel panel_5 = new JPanel();
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		splitPane.setRightComponent(panel_5);

		final JButton button_4 = new MButton();
		button_4.setText("������ϵ��");
		panel_5.add(button_4);

		final JButton button_5 = new MButton();
		button_5.setText("�鿴��Ϣ��¼");
		panel_5.add(button_5);

		final JLabel label_2 = new JLabel();
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setText("| ���� ");
		getContentPane().add(label_2, BorderLayout.SOUTH);
		//
	}

	private class MButton extends JButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MButton() {
			setMargin(new Insets(0, 0, 0, 0));
			setFocusPainted(false);
			setBorderPainted(false);
			setContentAreaFilled(false);
		}
	}

	private static void addPopup(final Component component,
			final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger())
					showMenu(e);
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger())
					showMenu(e);
			}

			private void showMenu(MouseEvent e) {
				popup
						.show(e.getComponent(), component.getX(), component
								.getY());
			}
		});
	}
}
