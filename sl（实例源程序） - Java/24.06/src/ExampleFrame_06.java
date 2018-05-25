import static javax.swing.SpringLayout.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.SpringLayout.Constraints;

public class ExampleFrame_06 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_06 frame = new ExampleFrame_06();
		frame.setVisible(true);
	}
	
	public ExampleFrame_06() {
		super();
		setTitle("利用弹簧控制组件大小");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		Spring vST = Spring.constant(20);// 创建一个支柱
		Spring hSP = Spring.constant(20, 100, 500);// 创建一个弹簧
		JButton lButton = new JButton("按钮L");
		getContentPane().add(lButton);
		springLayout.putConstraint(NORTH, lButton, vST, NORTH,
				getContentPane());// “按钮L”北侧——>容器北侧
		springLayout.putConstraint(WEST, lButton, hSP, WEST,
				getContentPane());// “按钮L”西侧——>容器西侧
		JButton rButton = new JButton("按钮R");
		getContentPane().add(rButton);
		// “按钮R”北侧——>“按钮R”北侧
		springLayout.putConstraint(NORTH, rButton, 0, NORTH, lButton);
		// “按钮R”西侧——>“按钮L”东侧
		springLayout.putConstraint(WEST, rButton, Spring.scale(hSP, 2),
				EAST, lButton);
		springLayout.putConstraint(EAST, getContentPane(), hSP, EAST,
				rButton);// 容器东侧——>“按钮R”东侧
		Spring widthSP = Spring.constant(60, 300, 600);// 创建一个弹簧
		Spring heightST = Spring.constant(60);// 创建一个支柱
		// 获得“按钮L”的Constraints对象
		Constraints lButtonCons = springLayout.getConstraints(lButton);
		lButtonCons.setWidth(widthSP);// 设置控制组件宽度的弹簧
		lButtonCons.setHeight(heightST);// 设置控制组件高度的支柱
		// 获得“按钮R”的Constraints对象
		Constraints rButtonCons = springLayout.getConstraints(rButton);
		rButtonCons.setWidth(widthSP);// 设置控制组件宽度的弹簧
		rButtonCons.setHeight(heightST);// 设置控制组件高度的支柱
	}
}
