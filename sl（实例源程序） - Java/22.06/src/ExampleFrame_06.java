import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

public class ExampleFrame_06 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTree tree;
	
	public static void main(String args[]) {
		ExampleFrame_06 frame = new ExampleFrame_06();
		frame.setVisible(true);
	}
	
	public ExampleFrame_06() {
		super();
		setTitle("����չ���ڵ��¼�");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("��ϰ���");
		
		DefaultMutableTreeNode nodeA = new DefaultMutableTreeNode("����칫��");
		root.add(nodeA);
		
		DefaultMutableTreeNode nodeB = new DefaultMutableTreeNode("���²�");
		root.add(nodeB);
		
		DefaultMutableTreeNode nodeC = new DefaultMutableTreeNode("������");
		root.add(nodeC);
		nodeC.add(new DefaultMutableTreeNode("����ά����"));
		nodeC.add(new DefaultMutableTreeNode("Ӧ�ÿ�����"));
		
		DefaultMutableTreeNode nodeD = new DefaultMutableTreeNode("����");
		root.add(nodeD);
		nodeD.add(new DefaultMutableTreeNode("�������"));
		nodeD.add(new DefaultMutableTreeNode("���ڿ�����"));
		
		DefaultMutableTreeNode nodeE = new DefaultMutableTreeNode("�ƹ㲿");
		root.add(nodeE);
		
		tree = new JTree(root);
// �������ڵ㽫Ҫ��չ�����۵����¼�
tree.addTreeWillExpandListener(new TreeWillExpandListener() {
	// ���ڵ㽫Ҫ���۵�ʱ����
	public void treeWillCollapse(TreeExpansionEvent e) {
		TreePath path = e.getPath();// ��ý�Ҫ���۵��ڵ��·��
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
				.getLastPathComponent();// ��ý�Ҫ���۵��Ľڵ�
		System.out.println("�ڵ㡰" + node + "����Ҫ���۵���");
	}
	
	// ���ڵ㽫Ҫ��չ��ʱ����
	public void treeWillExpand(TreeExpansionEvent e) {
		TreePath path = e.getPath();// ��ý�Ҫ��չ���ڵ��·��
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
				.getLastPathComponent();// ��ý�Ҫ��չ���Ľڵ�
		System.out.println("�ڵ㡰" + node + "����Ҫ��չ����");
	}
});
// �������ڵ��Ѿ���չ�����۵����¼�
tree.addTreeExpansionListener(new TreeExpansionListener() {
	// ���ڵ��Ѿ��۵�ʱ����
	public void treeCollapsed(TreeExpansionEvent e) {
		TreePath path = e.getPath();// ����Ѿ����۵��ڵ��·��
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
				.getLastPathComponent();// ����Ѿ����۵��Ľڵ�
		System.out.println("�ڵ㡰" + node + "���Ѿ����۵���");
		System.out.println();
	}
	
	// ���ڵ��Ѿ���չ��ʱ����
	public void treeExpanded(TreeExpansionEvent e) {
		TreePath path = e.getPath();// ����Ѿ���չ���ڵ��·��
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
				.getLastPathComponent();// ����Ѿ���չ���Ľڵ�
		System.out.println("�ڵ㡰" + node + "���Ѿ���չ����");
		System.out.println();
	}
});
		getContentPane().add(tree, BorderLayout.CENTER);
		//
	}
	
}
