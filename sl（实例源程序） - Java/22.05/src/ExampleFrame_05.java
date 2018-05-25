import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.tree.*;

public class ExampleFrame_05 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField;
	
	private DefaultTreeModel treeModel;
	
	private JTree tree;
	
	public static void main(String args[]) {
		ExampleFrame_05 frame = new ExampleFrame_05();
		frame.setVisible(true);
	}
	
	public ExampleFrame_05() {
		super();
		setTitle("维护企业架构");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("倾诚爱家");
		
		DefaultMutableTreeNode nodeA = new DefaultMutableTreeNode("经理办公室");
		root.add(nodeA);
		
		DefaultMutableTreeNode nodeB = new DefaultMutableTreeNode("人事部");
		root.add(nodeB);
		
		DefaultMutableTreeNode nodeC = new DefaultMutableTreeNode("技术部");
		root.add(nodeC);
		nodeC.add(new DefaultMutableTreeNode("网络维护部"));
		nodeC.add(new DefaultMutableTreeNode("应用开发部"));
		
		DefaultMutableTreeNode nodeD = new DefaultMutableTreeNode("服务部");
		root.add(nodeD);
		nodeD.add(new DefaultMutableTreeNode("网络服务部"));
		nodeD.add(new DefaultMutableTreeNode("内勤开发部"));
		
		DefaultMutableTreeNode nodeE = new DefaultMutableTreeNode("推广部");
		root.add(nodeE);
		
		treeModel = new DefaultTreeModel(root, true);
		
		tree = new JTree(treeModel);
		tree.setSelectionPath(new TreePath(root));
		scrollPane.setViewportView(tree);
		
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		final JLabel label = new JLabel();
		label.setText("名称：");
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(8);
		textField.setText("测试");
		panel.add(textField);
		
		final JButton addButton = new JButton("添加");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(
						textField.getText());// 创建欲添加节点
				TreePath selectionPath = tree.getSelectionPath();// 获得选中的父节点路径
				DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectionPath
						.getLastPathComponent();// 获得选中的父节点
				treeModel.insertNodeInto(node, parentNode, parentNode
						.getChildCount());// 插入节点到所有子节点之后
				TreePath path = selectionPath.pathByAddingChild(node);// 获得新添加节点的路径
				if (!tree.isVisible(path))
					tree.makeVisible(path);// 如果该节点不可见则令其可见
			}
		});
		panel.add(addButton);
		
		final JButton updButton = new JButton("修改");
		updButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 获得选中的欲修改节点的路径
				TreePath selectionPath = tree.getSelectionPath();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) selectionPath
						.getLastPathComponent();// 获得选中的欲修改节点
				node.setUserObject(textField.getText());// 修改节点的用户标签
				treeModel.nodeChanged(node);// 通知树模型该节点已经被修改
				tree.setSelectionPath(selectionPath);// 选中被修改的节点
			}
		});
		panel.add(updButton);
		
		final JButton delButton = new JButton("删除");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
						.getLastSelectedPathComponent();// 获得选中的欲删除节点
				// 查看欲删除的节点是否为根节点，根节点不允许删除
				if (!node.isRoot()) {
					DefaultMutableTreeNode nextSelectedNode = node
							.getNextSibling();// 获得下一个兄弟节点，以备选中
					if (nextSelectedNode == null)// 查看是否存在兄弟节点
						nextSelectedNode = (DefaultMutableTreeNode) node
								.getParent();// 如果不存在则选中其父节点
					treeModel.removeNodeFromParent(node);// 删除节点
					tree.setSelectionPath(new TreePath(nextSelectedNode
							.getPath()));// 选中节点
				}
			}
		});
		panel.add(delButton);
		//
	}
}
