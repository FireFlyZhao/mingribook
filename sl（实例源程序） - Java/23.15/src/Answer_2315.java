import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class Answer_2315 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTree tree;

	private JDesktopPane desktopPane;

	private JLabel iconLabel;

	private JButton pButton;

	private JButton nButton;

	private JScrollPane iconScrollPane;

	private JPanel iconPanel;

	int imgIndex;

	int imgCount;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Answer_2315 frame = new Answer_2315();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public Answer_2315() {
		super();
		setResizable(false);
		setBounds(0, 0, 1024, 768);
		setExtendedState(Answer_2315.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerLocation(220);
		getContentPane().add(splitPane, BorderLayout.CENTER);

		final JScrollPane treeSscrollPane = new JScrollPane();
		splitPane.setLeftComponent(treeSscrollPane);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("");

		File[] files = File.listRoots();// 遍历系统根目录
		for (int i = 0; i < files.length; i++) {
			File file = files[i];// 获得跟目录对象
			DefaultMutableTreeNode node = null;
			try {
				node = new DefaultMutableTreeNode(file.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			File[] files2 = file.listFiles(fileFilter);// 遍历二级子目录
			if (files2 != null) {
				for (int j = 0; j < files2.length; j++) {
					File file2 = files2[j];// 获得二级子目录对象
					if (file2.isDirectory())
						node.add(new DefaultMutableTreeNode(file2.getName()));
					else
						node.add(new DefaultMutableTreeNode(file2.getName(),
								false));
				}
			}
			root.add(node);
		}

		tree = new JTree(root, true);
		tree.setRootVisible(false);
		tree.addTreeWillExpandListener(new TreeWillExpandListener() {
			public void treeWillExpand(TreeExpansionEvent e)
					throws ExpandVetoException {
				TreePath willExpandPath = e.getPath();
				loadChildNode(willExpandPath);// 加载子目录
			}

			public void treeWillCollapse(TreeExpansionEvent e)
					throws ExpandVetoException {
			}
		});
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				TreePath selectionPath = tree.getSelectionPath();
				loadChildNode(selectionPath);// 加载子目录
				//
				iconPanel.removeAll();
				Object[] nodePath = selectionPath.getPath();
				String selectedDir = nodePath[1].toString().replace("\\", "/");
				for (int i = 2; i < nodePath.length; i++) {
					selectedDir = selectedDir + nodePath[i] + "/";
				}
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) selectionPath
						.getLastPathComponent();
				if (node.getAllowsChildren()) {
					new LoadIconInThread(selectedDir, node).start();
				} else {
					if (pButton.isEnabled())
						pButton.setEnabled(false);
					if (nButton.isEnabled())
						nButton.setEnabled(false);
					showImgInFrame(selectedDir);
				}
				SwingUtilities.updateComponentTreeUI(iconPanel);
			}
		});
		treeSscrollPane.setViewportView(tree);

		final JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		splitPane.setRightComponent(panel);

		desktopPane = new JDesktopPane();
		JLabel backLabel = new JLabel(); // 创建一个标签组件对象
		URL resource = this.getClass().getResource("/bg.jpg"); // 获得背景图片的路径
		ImageIcon icon = new ImageIcon(resource); // 创建背景图片对象
		backLabel.setIcon(icon); // 令标签组件显示背景图片
		backLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小
		desktopPane.add(backLabel, new Integer(Integer.MIN_VALUE)); // 将标签组件添加到指定索引位置
		panel.add(desktopPane, BorderLayout.CENTER);

		final JPanel operatePanel = new JPanel();
		operatePanel.setLayout(new BorderLayout());
		operatePanel.setPreferredSize(new Dimension(0, 150));
		panel.add(operatePanel, BorderLayout.SOUTH);

		pButton = new JButton();
		pButton.setText("<<");
		pButton.setEnabled(false);
		pButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imgIndex--;
				JButton button = (JButton) iconPanel.getComponent(imgIndex);
				showImgInFrame(button.getName());
				if (imgIndex == 0)
					pButton.setEnabled(false);
				if (!nButton.isEnabled()) {
					if (imgIndex < imgCount - 1)
						nButton.setEnabled(true);
				}
				button.requestFocus();
			}
		});
		operatePanel.add(pButton, BorderLayout.WEST);

		nButton = new JButton();
		nButton.setText(">>");
		nButton.setEnabled(false);
		nButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imgIndex++;
				JButton button = (JButton) iconPanel.getComponent(imgIndex);
				showImgInFrame(button.getName());
				if (!pButton.isEnabled()) {
					if (imgIndex > 0)
						pButton.setEnabled(true);
				}
				if (imgIndex == imgCount - 1)
					nButton.setEnabled(false);
				button.requestFocus();
			}
		});
		operatePanel.add(nButton, BorderLayout.EAST);

		iconScrollPane = new JScrollPane();
		iconScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		operatePanel.add(iconScrollPane, BorderLayout.CENTER);

		iconPanel = new JPanel();
		iconScrollPane.setViewportView(iconPanel);
		//
	}

	FileFilter fileFilter = new FileFilter() {
		public boolean accept(File file) {
			if (file.isDirectory())
				return true;
			else {
				String name = file.getName().toUpperCase();
				if (name.endsWith(".JPG"))
					return true;
				else if (name.endsWith(".GIF"))
					return true;
				else
					return false;
			}
		}
	};

	private class PreviewButtonAL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			showImgInFrame(((JButton) e.getSource()).getName());
		}
	}

	public void showImgInFrame(String imgDir) {
		JInternalFrame frame = desktopPane.getSelectedFrame();
		String imgName = new File(imgDir).getName();
		JInternalFrame[] allFrames = desktopPane.getAllFrames();
		for (int i = 0; i < allFrames.length; i++) {
			JInternalFrame internalFrame = allFrames[i];
			if (internalFrame.getTitle().equals(imgName)) {
				if (internalFrame.isIcon()) {
					try {
						internalFrame.setIcon(false);
					} catch (PropertyVetoException e) {
						e.printStackTrace();
					}
				}
				if (!internalFrame.isSelected()) {
					try {
						internalFrame.setSelected(true);
					} catch (PropertyVetoException e) {
						e.printStackTrace();
					}
				}
				frame = internalFrame;
				break;
			}
		}

		if (frame == null || frame.isIcon()) {
			frame = new JInternalFrame();
			frame.setIconifiable(true);
			frame.setMaximizable(true);
			frame.setBounds(-5, -5, 800, 600);
			desktopPane.add(frame);
			frame.setVisible(true);
			iconLabel = new JLabel();
			frame.getContentPane().add(iconLabel);
		}
		if (!frame.getTitle().equals(imgName)) {
			frame.setTitle(imgName);
			iconLabel.setIcon(new ImageIcon(imgDir));
		}
	}

	public void loadChildNode(TreePath path) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
				.getLastPathComponent();
		if (node.getAllowsChildren() && node.getChildCount() == 0) {
			StringBuffer dirBuffer = new StringBuffer();
			Object[] nodes = path.getPath();
			for (int i = 0; i < nodes.length; i++) {
				dirBuffer.append(nodes[i]);
				dirBuffer.append("\\");
			}
			File file = new File(dirBuffer.toString());
			File[] files = file.listFiles(fileFilter);
			for (int i = 0; i < files.length; i++) {
				File file2 = files[i];
				if (file2.isDirectory())
					node.add(new DefaultMutableTreeNode(file2.getName()));
				else
					node
							.add(new DefaultMutableTreeNode(file2.getName(),
									false));
			}
		}
	}

	private class LoadIconInThread extends Thread {

		private String selectedDir;

		private DefaultMutableTreeNode node;

		public LoadIconInThread(String selectedDir, DefaultMutableTreeNode node) {
			this.node = node;
			this.selectedDir = selectedDir;
		}

		@Override
		public void run() {
			imgIndex = -1;
			imgCount = 0;
			pButton.setEnabled(false);
			nButton.setEnabled(false);
			int childCount = node.getChildCount();
			for (int i = 0; i < childCount; i++) {
				DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node
						.getChildAt(i);
				if (!childNode.getAllowsChildren()) {
					imgCount++;
					String imgName = childNode.toString();
					MButton button = new MButton();
					button.setText(imgName);
					button.setName(selectedDir + imgName);
					button.setPreferredSize(new Dimension(120, 120));
					button.addActionListener(new PreviewButtonAL());
					iconPanel.add(button);
					iconScrollPane.validate();
					if (!nButton.isEnabled()) {
						if (imgCount > 0)
							nButton.setEnabled(true);
					}
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("文件夹“" + node + "”中的图片加载完毕！");
		}
	}

	private class MButton extends JButton {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			int width = getWidth();
			int height = getHeight();
			ImageIcon icon = new ImageIcon(getName());
			g.drawImage(icon.getImage(), 0, 0, width, height - 25, this);
			icon = null;
			g.drawString(getText(), 5, height - 10);
		}

	}

}
