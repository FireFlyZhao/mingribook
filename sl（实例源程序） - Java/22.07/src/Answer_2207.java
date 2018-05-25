import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.tree.*;

public class Answer_2207 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DefaultTreeModel treeModel;
	
	private JTree tree;
	
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Answer_2207 frame = new Answer_2207();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame
	 */
	public Answer_2207() {
		super();
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		tree.setSelectionRow(0);
		getContentPane().add(tree, BorderLayout.CENTER);
		
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		final JButton addButton = new JButton("添加");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreePath selectionPath = tree.getSelectionPath();
				int pathCount = selectionPath.getPathCount();// 获得选中节点的级别
				had: if (pathCount == 3) {// 选中的为3级节点
					JOptionPane.showMessageDialog(null,
							"很抱歉，在该级部门下不能再包含子部门！", "友情提示",
							JOptionPane.WARNING_MESSAGE);
				} else {// 选中的为1级或2级节点
					String infos[] = { "请输入部门名称：", "添加新部门", "请输入部门名称！" };
					String newName = getName(infos);// 获得新部门的名称
					if (newName != null) {// 创建新部门
						DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectionPath
								.getLastPathComponent();// 获得选中部门节点对象
						int childCount = parentNode.getChildCount();// 获得该部门包含子部门的个数
						for (int i = 0; i < childCount; i++) {// 查看新创建的部门是否已经存在
							TreeNode childNode = parentNode.getChildAt(i);
							if (childNode.toString().equals(newName)) {
								JOptionPane.showMessageDialog(null,
										"该部门已经存在！", "友情提示",
										JOptionPane.WARNING_MESSAGE);
								break had;// 已经存在，跳出到指定位置
							}
						}
						DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(
								newName);// 创建新部门节点对象
						treeModel.insertNodeInto(childNode, parentNode,
								childCount);// 将新部门节点插入到选中部门节点的最后
						tree.expandPath(selectionPath);// 展开选中部门节点
					}
				}
			}
		});
		panel.add(addButton);
		
		final JButton updButton = new JButton("修改");
		updButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreePath selectionPath = tree.getSelectionPath();
				String newName = null;
				if (selectionPath.getPathCount() == 1) {// 修改公司名称
					int i = JOptionPane.showConfirmDialog(null,
							"确定要修改贵公司的名称？", "友情提示",
							JOptionPane.YES_NO_OPTION);// 弹出提示框
					if (i == 0) {// 修改（单击“是”按钮）
						String infos[] = { "请输入贵公司的新名称：", "修改公司名称",
								"请输入贵公司的新名称！" };
						newName = getName(infos);// 获得修改后的名称
					}
				} else {// 修改部门名称
					String infos[] = { "请输入部门的新名称：", "修改部门名称",
							"请输入部门的新名称！" };
					newName = getName(infos);// 获得修改后的名称
					if (newName != null) {
						DefaultMutableTreeNode node = (DefaultMutableTreeNode) selectionPath
								.getLastPathComponent();
						DefaultMutableTreeNode nodeParent = (DefaultMutableTreeNode) node
								.getParent();
						for (int i = 0; i < nodeParent.getChildCount(); i++) {
							DefaultMutableTreeNode nodeSibling = (DefaultMutableTreeNode) nodeParent
									.getChildAt(i);
							if (!nodeSibling.equals(node)) {
								if (nodeSibling.getUserObject().toString()
										.equals(newName)) {
									JOptionPane.showMessageDialog(null,
											"该部门已经存在！", "友情提示",
											JOptionPane.WARNING_MESSAGE);
									newName = null;
								}
							}
						}
					}
				}
				if (newName != null) {
					DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) selectionPath
							.getLastPathComponent();// 获得选中节点对象
					treeNode.setUserObject(newName);// 修改节点名称
					treeModel.reload();// 刷新树结构
					tree.setSelectionPath(selectionPath);// 设置节点为选中状态
				}
			}
		});
		panel.add(updButton);
		
		final JButton delButton = new JButton("删除");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
						.getLastSelectedPathComponent();// 获得选中的欲删除节点
				if (!node.isRoot()) {// 查看欲删除的节点是否为根节点，根节点不允许删除
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
	
	private String getName(String infos[]) {
		String newName = "";
		while (newName != null && newName.length() == 0) {
			newName = JOptionPane.showInputDialog(null, infos[0],
					infos[1], JOptionPane.INFORMATION_MESSAGE);
			if (newName != null && newName.length() == 0) {
				JOptionPane.showMessageDialog(null, infos[2], "友情提示",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		return newName;
	}
	
}
