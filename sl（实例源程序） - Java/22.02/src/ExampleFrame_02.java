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
		setTitle("����ѡ�нڵ��¼�");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DefaultMutableTreeNode root;// �������ĸ��ڵ�
		root = new DefaultMutableTreeNode("���ش��̣�D����");
		DefaultMutableTreeNode nodeA;// ��������һ���ӽڵ�
		nodeA = new DefaultMutableTreeNode("ͼƬ");
		root.add(nodeA);// ��һ���ӽ����ӵ������
		// ��һ���ӽڵ���Ӷ����ӽڵ�
		nodeA.add(new DefaultMutableTreeNode("ǧɽ��������԰����"));
		DefaultMutableTreeNode nodeAB;// �������Ķ����ӽڵ�
		nodeAB = new DefaultMutableTreeNode("���ɽ������¹������");
		nodeA.add(nodeAB);// �������ӽڵ���ӵ�һ���ӽڵ�
		// ������ӽڵ����Ҷ�ӽڵ�
		nodeAB.add(new DefaultMutableTreeNode("������ɳ.GIF", false));
		// ������ӽڵ����Ҷ�ӽڵ�
		nodeAB.add(new DefaultMutableTreeNode("�����Ĵ�.JPG", false));
		// ����ڵ����һ���ӽڵ�
		root.add(new DefaultMutableTreeNode("����"));
		DefaultTreeModel treeModel;// ͨ�����ĸ��ڵ㴴����ģ��
		treeModel = new DefaultTreeModel(root, true);
		tree = new JTree(treeModel);// ͨ����ģ�ʹ�����
		TreeSelectionModel treeSelectionModel;// �������ѡ��ģ��
		treeSelectionModel = tree.getSelectionModel();
		// ��������ѡ��ģʽΪ��ѡ
		treeSelectionModel.setSelectionMode(CONTIGUOUS_TREE_SELECTION);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				if (!tree.isSelectionEmpty()) {// �鿴�Ƿ���ڱ�ѡ�еĽڵ�
					// ������б�ѡ�нڵ��·��
					TreePath[] selectionPaths = tree.getSelectionPaths();
					for (int i = 0; i < selectionPaths.length; i++) {
						// ��ñ�ѡ�нڵ��·��
						TreePath treePath = selectionPaths[i];
						// ��Object�������ʽ���ظ�·�������нڵ�Ķ���
						Object[] path = treePath.getPath();
						for (int j = 0; j < path.length; j++) {
							DefaultMutableTreeNode node;// ��ýڵ�
							node = (DefaultMutableTreeNode) path[j];
							String s = node.getUserObject()
									+ (j == (path.length - 1) ? "" : "-->");
							System.out.print(s);// ����ڵ��ǩ
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