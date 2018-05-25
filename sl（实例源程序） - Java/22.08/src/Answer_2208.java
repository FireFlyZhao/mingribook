
import java.awt.*;

import javax.swing.*;
import javax.swing.tree.*;

public class Answer_2208 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Answer_2208 frame = new Answer_2208();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame
	 */
	public Answer_2208() {
		super();
		setTitle("支持树状结构的下拉菜单");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("明日科技");
		DefaultMutableTreeNode aNode2 = new DefaultMutableTreeNode("人事部");
		root.add(aNode2);
		DefaultMutableTreeNode bNode2 = new DefaultMutableTreeNode("开发部");
		root.add(bNode2);
		DefaultMutableTreeNode aNode3 = new DefaultMutableTreeNode("VB");
		bNode2.add(aNode3);
		DefaultMutableTreeNode bNode3 = new DefaultMutableTreeNode("VC");
		bNode2.add(bNode3);
		
		final JPanel topPanel = new JPanel();
		getContentPane().add(topPanel, BorderLayout.NORTH);
		
		final JLabel topLabel = new JLabel();
		topLabel.setText("部门：");
		topPanel.add(topLabel);
		
		final MTreeComboBox topTreeComboBox = new MTreeComboBox(root, 10,
				1.2);
		topPanel.add(topTreeComboBox);
		
		final JPanel bottomPanel = new JPanel();
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		final JLabel bottomLabel = new JLabel();
		bottomLabel.setText("部门：");
		bottomPanel.add(bottomLabel);
		
		final MTreeComboBox bottomTreeComboBox = new MTreeComboBox(root,
				20, 1.2);
		bottomPanel.add(bottomTreeComboBox);
		
		final JLabel label = new JLabel();
		label.setText("");
		getContentPane().add(label, BorderLayout.CENTER);
		//
	}
	
}
