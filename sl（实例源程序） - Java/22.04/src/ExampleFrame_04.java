import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.tree.*;

public class ExampleFrame_04 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTree tree;
	public static void main(String args[]) {
		ExampleFrame_04 frame = new ExampleFrame_04();
		frame.setVisible(true);
	}
	public ExampleFrame_04() {
		super();
		setTitle("������");
		setBounds(100, 100, 200, 325);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DefaultMutableTreeNode root;
		root = new DefaultMutableTreeNode("��ҵ���¹���ϵͳ");
		DefaultMutableTreeNode nodeFirstA;
		nodeFirstA = new DefaultMutableTreeNode("���¹���");
		nodeFirstA.add(new DefaultMutableTreeNode("���׹���"));
		nodeFirstA.add(new DefaultMutableTreeNode("���ڹ���"));
		nodeFirstA.add(new DefaultMutableTreeNode("���͹���"));
		nodeFirstA.add(new DefaultMutableTreeNode("��ѵ����"));
		root.add(nodeFirstA);
		DefaultMutableTreeNode nodeFirstB;
		nodeFirstB = new DefaultMutableTreeNode("��������");
		nodeFirstB.add(new DefaultMutableTreeNode("���׹���"));
		nodeFirstB.add(new DefaultMutableTreeNode("��Ա����"));
		nodeFirstB.add(new DefaultMutableTreeNode("��������"));
		root.add(nodeFirstB);
		DefaultMutableTreeNode nodeFirstC;
		nodeFirstC = new DefaultMutableTreeNode("ϵͳά��");
		nodeFirstC.add(new DefaultMutableTreeNode("��ҵ�ܹ�"));
		nodeFirstC.add(new DefaultMutableTreeNode("��������"));
		nodeFirstC.add(new DefaultMutableTreeNode("ϵͳ��ʼ��"));
		root.add(nodeFirstC);
		tree = new JTree(root);
		tree.setRootVisible(false);// ����ʾ���ĸ��ڵ�
		tree.setRowHeight(20);// ���ڵ���и�Ϊ20����
		tree.setFont(new Font("����", Font.BOLD, 14));// ��������������
		// �ڵ�䲻����������
		tree.putClientProperty("JTree.lineStyle", "None");
		DefaultTreeCellRenderer treeCellRenderer;// ������ڵ�Ļ��ƶ���
		treeCellRenderer = (DefaultTreeCellRenderer) tree
				.getCellRenderer();
		treeCellRenderer.setLeafIcon(null);// ����Ҷ�ӽڵ㲻����ͼ��
		treeCellRenderer.setClosedIcon(null);// ���ýڵ��۵�ʱ������ͼ��
		treeCellRenderer.setOpenIcon(null);// ���ýڵ�չ��ʱ������ͼ��
		Enumeration<?> enumeration; // ��ǰ������������ڵ�
		enumeration = root.preorderEnumeration();
		while (enumeration.hasMoreElements()) {
			DefaultMutableTreeNode node;
			node = (DefaultMutableTreeNode) enumeration.nextElement();
			if (!node.isLeaf()) {// �ж��Ƿ�ΪҶ�ӽڵ�
				// �����ýڵ��·��
				TreePath path = new TreePath(node.getPath());
				tree.expandPath(path);// ���������չ���ýڵ�
			}
		}
		getContentPane().add(tree, BorderLayout.CENTER);
	}
}