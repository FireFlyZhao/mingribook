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
		setTitle("�򵥵���");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �������ڵ�
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("���ڵ�");
		// ����һ���ڵ�
		DefaultMutableTreeNode nodeFirst = new DefaultMutableTreeNode(
				"һ���ӽڵ�A");
		root.add(nodeFirst);// ��һ���ڵ���ӵ����ڵ�
		DefaultMutableTreeNode nodeSecond = new DefaultMutableTreeNode(
				"�����ӽڵ�", false);// �������������ӽڵ�Ķ����ڵ�
		nodeFirst.add(nodeSecond);// �������ڵ���ӵ�һ���ڵ�
		root.add(new DefaultMutableTreeNode("һ���ӽڵ�B"));// ����һ���ڵ�
		JTree treeRoot = new JTree(root);// ���ø��ڵ�ֱ�Ӵ�����
		getContentPane().add(treeRoot, BorderLayout.WEST);
		// ���ø��ڵ㴴����ģ�ͣ�����Ĭ�ϵ��жϷ�ʽ
		DefaultTreeModel treeModelDefault = new DefaultTreeModel(root);
		// ������ģ�ʹ�����
		JTree treeDefault = new JTree(treeModelDefault);
		getContentPane().add(treeDefault, BorderLayout.CENTER);
		// ���ø��ڵ㴴����ģ�ͣ������÷�Ĭ�ϵ��жϷ�ʽ
		DefaultTreeModel treeModelPointed = new DefaultTreeModel(root,
				true);
		JTree treePointed = new JTree(treeModelPointed);// ������ģ�ʹ�����
		getContentPane().add(treePointed, BorderLayout.EAST);
	}
}