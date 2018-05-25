import java.awt.*;

import javax.swing.*;
import javax.swing.tree.*;

public class ExampleFrame_01 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_01 frame = new ExampleFrame_01();
		frame.setVisible(true);
	}
	
	public ExampleFrame_01() {
		super();
		setTitle("简单的树");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 创建根节点
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("根节点");
		// 创建一级节点
		DefaultMutableTreeNode nodeFirst = new DefaultMutableTreeNode(
				"一级子节点A");
		root.add(nodeFirst);// 将一级节点添加到根节点
		DefaultMutableTreeNode nodeSecond = new DefaultMutableTreeNode(
				"二级子节点", false);// 创建不允许有子节点的二级节点
		nodeFirst.add(nodeSecond);// 将二级节点添加到一级节点
		root.add(new DefaultMutableTreeNode("一级子节点B"));// 创建一级节点
		JTree treeRoot = new JTree(root);// 利用根节点直接创建树
		getContentPane().add(treeRoot, BorderLayout.WEST);
		// 利用根节点创建树模型，采用默认的判断方式
		DefaultTreeModel treeModelDefault = new DefaultTreeModel(root);
		// 利用树模型创建树
		JTree treeDefault = new JTree(treeModelDefault);
		getContentPane().add(treeDefault, BorderLayout.CENTER);
		// 利用根节点创建树模型，并采用非默认的判断方式
		DefaultTreeModel treeModelPointed = new DefaultTreeModel(root,
				true);
		JTree treePointed = new JTree(treeModelPointed);// 利用树模型创建树
		getContentPane().add(treePointed, BorderLayout.EAST);
	}
}