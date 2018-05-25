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
		setTitle("定制树");
		setBounds(100, 100, 200, 325);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DefaultMutableTreeNode root;
		root = new DefaultMutableTreeNode("企业人事管理系统");
		DefaultMutableTreeNode nodeFirstA;
		nodeFirstA = new DefaultMutableTreeNode("人事管理");
		nodeFirstA.add(new DefaultMutableTreeNode("账套管理"));
		nodeFirstA.add(new DefaultMutableTreeNode("考勤管理"));
		nodeFirstA.add(new DefaultMutableTreeNode("奖惩管理"));
		nodeFirstA.add(new DefaultMutableTreeNode("培训管理"));
		root.add(nodeFirstA);
		DefaultMutableTreeNode nodeFirstB;
		nodeFirstB = new DefaultMutableTreeNode("待遇管理");
		nodeFirstB.add(new DefaultMutableTreeNode("帐套管理"));
		nodeFirstB.add(new DefaultMutableTreeNode("人员设置"));
		nodeFirstB.add(new DefaultMutableTreeNode("待遇报表"));
		root.add(nodeFirstB);
		DefaultMutableTreeNode nodeFirstC;
		nodeFirstC = new DefaultMutableTreeNode("系统维护");
		nodeFirstC.add(new DefaultMutableTreeNode("企业架构"));
		nodeFirstC.add(new DefaultMutableTreeNode("基本资料"));
		nodeFirstC.add(new DefaultMutableTreeNode("系统初始化"));
		root.add(nodeFirstC);
		tree = new JTree(root);
		tree.setRootVisible(false);// 不显示树的根节点
		tree.setRowHeight(20);// 树节点的行高为20像素
		tree.setFont(new Font("宋体", Font.BOLD, 14));// 设置树结点的字体
		// 节点间不采用连接线
		tree.putClientProperty("JTree.lineStyle", "None");
		DefaultTreeCellRenderer treeCellRenderer;// 获得树节点的绘制对象
		treeCellRenderer = (DefaultTreeCellRenderer) tree
				.getCellRenderer();
		treeCellRenderer.setLeafIcon(null);// 设置叶子节点不采用图标
		treeCellRenderer.setClosedIcon(null);// 设置节点折叠时不采用图标
		treeCellRenderer.setOpenIcon(null);// 设置节点展开时不采用图标
		Enumeration<?> enumeration; // 按前序遍历所有树节点
		enumeration = root.preorderEnumeration();
		while (enumeration.hasMoreElements()) {
			DefaultMutableTreeNode node;
			node = (DefaultMutableTreeNode) enumeration.nextElement();
			if (!node.isLeaf()) {// 判断是否为叶子节点
				// 创建该节点的路径
				TreePath path = new TreePath(node.getPath());
				tree.expandPath(path);// 如果不是则展开该节点
			}
		}
		getContentPane().add(tree, BorderLayout.CENTER);
	}
}