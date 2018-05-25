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
		setTitle("处理展开节点事件");
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
		
		tree = new JTree(root);
// 捕获树节点将要被展开或折叠的事件
tree.addTreeWillExpandListener(new TreeWillExpandListener() {
	// 树节点将要被折叠时触发
	public void treeWillCollapse(TreeExpansionEvent e) {
		TreePath path = e.getPath();// 获得将要被折叠节点的路径
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
				.getLastPathComponent();// 获得将要被折叠的节点
		System.out.println("节点“" + node + "”将要被折叠！");
	}
	
	// 树节点将要被展开时触发
	public void treeWillExpand(TreeExpansionEvent e) {
		TreePath path = e.getPath();// 获得将要被展开节点的路径
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
				.getLastPathComponent();// 获得将要被展开的节点
		System.out.println("节点“" + node + "”将要被展开！");
	}
});
// 捕获树节点已经被展开或折叠的事件
tree.addTreeExpansionListener(new TreeExpansionListener() {
	// 树节点已经折叠时触发
	public void treeCollapsed(TreeExpansionEvent e) {
		TreePath path = e.getPath();// 获得已经被折叠节点的路径
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
				.getLastPathComponent();// 获得已经被折叠的节点
		System.out.println("节点“" + node + "”已经被折叠！");
		System.out.println();
	}
	
	// 树节点已经被展开时触发
	public void treeExpanded(TreeExpansionEvent e) {
		TreePath path = e.getPath();// 获得已经被展开节点的路径
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
				.getLastPathComponent();// 获得已经被展开的节点
		System.out.println("节点“" + node + "”已经被展开！");
		System.out.println();
	}
});
		getContentPane().add(tree, BorderLayout.CENTER);
		//
	}
	
}
