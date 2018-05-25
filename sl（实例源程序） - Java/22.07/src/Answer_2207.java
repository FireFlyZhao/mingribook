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
		
		treeModel = new DefaultTreeModel(root, true);
		
		tree = new JTree(treeModel);
		tree.setSelectionRow(0);
		getContentPane().add(tree, BorderLayout.CENTER);
		
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		final JButton addButton = new JButton("���");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreePath selectionPath = tree.getSelectionPath();
				int pathCount = selectionPath.getPathCount();// ���ѡ�нڵ�ļ���
				had: if (pathCount == 3) {// ѡ�е�Ϊ3���ڵ�
					JOptionPane.showMessageDialog(null,
							"�ܱ�Ǹ���ڸü������²����ٰ����Ӳ��ţ�", "������ʾ",
							JOptionPane.WARNING_MESSAGE);
				} else {// ѡ�е�Ϊ1����2���ڵ�
					String infos[] = { "�����벿�����ƣ�", "����²���", "�����벿�����ƣ�" };
					String newName = getName(infos);// ����²��ŵ�����
					if (newName != null) {// �����²���
						DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectionPath
								.getLastPathComponent();// ���ѡ�в��Žڵ����
						int childCount = parentNode.getChildCount();// ��øò��Ű����Ӳ��ŵĸ���
						for (int i = 0; i < childCount; i++) {// �鿴�´����Ĳ����Ƿ��Ѿ�����
							TreeNode childNode = parentNode.getChildAt(i);
							if (childNode.toString().equals(newName)) {
								JOptionPane.showMessageDialog(null,
										"�ò����Ѿ����ڣ�", "������ʾ",
										JOptionPane.WARNING_MESSAGE);
								break had;// �Ѿ����ڣ�������ָ��λ��
							}
						}
						DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(
								newName);// �����²��Žڵ����
						treeModel.insertNodeInto(childNode, parentNode,
								childCount);// ���²��Žڵ���뵽ѡ�в��Žڵ�����
						tree.expandPath(selectionPath);// չ��ѡ�в��Žڵ�
					}
				}
			}
		});
		panel.add(addButton);
		
		final JButton updButton = new JButton("�޸�");
		updButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreePath selectionPath = tree.getSelectionPath();
				String newName = null;
				if (selectionPath.getPathCount() == 1) {// �޸Ĺ�˾����
					int i = JOptionPane.showConfirmDialog(null,
							"ȷ��Ҫ�޸Ĺ�˾�����ƣ�", "������ʾ",
							JOptionPane.YES_NO_OPTION);// ������ʾ��
					if (i == 0) {// �޸ģ��������ǡ���ť��
						String infos[] = { "�������˾�������ƣ�", "�޸Ĺ�˾����",
								"�������˾�������ƣ�" };
						newName = getName(infos);// ����޸ĺ������
					}
				} else {// �޸Ĳ�������
					String infos[] = { "�����벿�ŵ������ƣ�", "�޸Ĳ�������",
							"�����벿�ŵ������ƣ�" };
					newName = getName(infos);// ����޸ĺ������
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
											"�ò����Ѿ����ڣ�", "������ʾ",
											JOptionPane.WARNING_MESSAGE);
									newName = null;
								}
							}
						}
					}
				}
				if (newName != null) {
					DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) selectionPath
							.getLastPathComponent();// ���ѡ�нڵ����
					treeNode.setUserObject(newName);// �޸Ľڵ�����
					treeModel.reload();// ˢ�����ṹ
					tree.setSelectionPath(selectionPath);// ���ýڵ�Ϊѡ��״̬
				}
			}
		});
		panel.add(updButton);
		
		final JButton delButton = new JButton("ɾ��");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
						.getLastSelectedPathComponent();// ���ѡ�е���ɾ���ڵ�
				if (!node.isRoot()) {// �鿴��ɾ���Ľڵ��Ƿ�Ϊ���ڵ㣬���ڵ㲻����ɾ��
					DefaultMutableTreeNode nextSelectedNode = node
							.getNextSibling();// �����һ���ֵܽڵ㣬�Ա�ѡ��
					if (nextSelectedNode == null)// �鿴�Ƿ�����ֵܽڵ�
						nextSelectedNode = (DefaultMutableTreeNode) node
								.getParent();// �����������ѡ���丸�ڵ�
					treeModel.removeNodeFromParent(node);// ɾ���ڵ�
					tree.setSelectionPath(new TreePath(nextSelectedNode
							.getPath()));// ѡ�нڵ�
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
				JOptionPane.showMessageDialog(null, infos[2], "������ʾ",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		return newName;
	}
	
}
