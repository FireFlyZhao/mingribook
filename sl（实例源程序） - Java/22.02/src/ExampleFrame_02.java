import static javax.swing.tree.TreeSelectionModel.*;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class ExampleFrame_02 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTree tree;
	
	public static void main(String args[]) {
		ExampleFrame_02 frame = new ExampleFrame_02();
		frame.setVisible(true);
	}
	
	public ExampleFrame_02() {
		super();
		setTitle("处理选中节点事件");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DefaultMutableTreeNode root;// 创建树的跟节点
		root = new DefaultMutableTreeNode("本地磁盘（D：）");
		DefaultMutableTreeNode nodeA;// 创建树的一级子节点
		nodeA = new DefaultMutableTreeNode("图片");
		root.add(nodeA);// 将一级子结点添加到跟结点
		// 向一级子节点添加二级子节点
		nodeA.add(new DefaultMutableTreeNode("千山——世博园旅游"));
		DefaultMutableTreeNode nodeAB;// 创建树的二级子节点
		nodeAB = new DefaultMutableTreeNode("凤凰山——大鹿岛旅游");
		nodeA.add(nodeAB);// 将二级子节点添加到一级子节点
		// 向二级子节点添加叶子节点
		nodeAB.add(new DefaultMutableTreeNode("大浪淘沙.GIF", false));
		// 向二级子节点添加叶子节点
		nodeAB.add(new DefaultMutableTreeNode("辽阔的大海.JPG", false));
		// 向根节点添加一级子节点
		root.add(new DefaultMutableTreeNode("音乐"));
		DefaultTreeModel treeModel;// 通过树的根节点创建树模型
		treeModel = new DefaultTreeModel(root, true);
		tree = new JTree(treeModel);// 通过树模型创建树
		TreeSelectionModel treeSelectionModel;// 获得树的选择模型
		treeSelectionModel = tree.getSelectionModel();
		// 设置树的选择模式为连选
		treeSelectionModel.setSelectionMode(CONTIGUOUS_TREE_SELECTION);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				if (!tree.isSelectionEmpty()) {// 查看是否存在被选中的节点
					// 获得所有被选中节点的路径
					TreePath[] selectionPaths = tree.getSelectionPaths();
					for (int i = 0; i < selectionPaths.length; i++) {
						// 获得被选中节点的路径
						TreePath treePath = selectionPaths[i];
						// 以Object数组的形式返回该路径中所有节点的对象
						Object[] path = treePath.getPath();
						for (int j = 0; j < path.length; j++) {
							DefaultMutableTreeNode node;// 获得节点
							node = (DefaultMutableTreeNode) path[j];
							String s = node.getUserObject()
									+ (j == (path.length - 1) ? "" : "-->");
							System.out.print(s);// 输出节点标签
						}
						System.out.println();
					}
					System.out.println();
				}
			}
		});
		getContentPane().add(tree, BorderLayout.CENTER);
	}
}